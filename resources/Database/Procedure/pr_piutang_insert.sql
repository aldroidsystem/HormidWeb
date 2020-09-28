
create or replace Procedure pr_piutang_insert( 
in_piutangId  IN VARCHAR2, 
in_username IN VARCHAR2, 
in_jumlah in NUMBER, 
in_transaksi in VARCHAR2, 
in_keterangan IN VARCHAR2, 
in_catatan IN VARCHAR2, 
in_createdBy IN VARCHAR2
)
IS
v_total_hutang tb_user.hutang%type;
v_sisaHutang tb_user.hutang%type;
BEGIN
		
    select NVL(hutang, 0) into v_total_hutang from tb_user where username= in_username;
    
    if in_transaksi = 'bayar' then
    v_sisaHutang := v_total_hutang - NVL(in_jumlah, 0);
    
	insert into tb_piutang 
	(PIUTANG_ID,USERNAME,HUTANG,BAYAR,SISA_HUTANG,KETERANGAN,CATATAN,CREATED_BY) 
	values (in_piutangId, in_username, 0, NVL(in_jumlah, 0), v_sisaHutang, in_keterangan, in_catatan, in_createdBy);

	update tb_user 
	set hutang = v_sisaHutang,
	terakhir_bayar=current_timestamp
	where username= in_username;
	
    elsif in_transaksi = 'pinjam' then
    v_sisaHutang := v_total_hutang + NVL(in_jumlah, 0);
    
	insert into tb_piutang 
	(PIUTANG_ID,USERNAME,HUTANG,BAYAR,SISA_HUTANG,KETERANGAN,CATATAN,CREATED_BY) 
	values (in_piutangId, in_username, NVL(in_jumlah, 0), 0, v_sisaHutang, in_keterangan, in_catatan, in_createdBy);

	update tb_user 
	set hutang = v_sisaHutang,
	terakhir_pinjam=current_timestamp
	where username= in_username;
    end if;
	
  commit;
   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;

  pr_auditLog_insert(in_createdBy,'pr_piutang_insert',SQLERRM,
  ''''||in_piutangId||''','''||in_username||''','||in_jumlah||','''||in_transaksi||''','''||in_keterangan||''','''||in_catatan||''','''||in_createdBy||'''');

  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
  
END;
/