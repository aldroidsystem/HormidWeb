create or replace Procedure pr_timbangJembatan_payment( 
	in_noNota  IN VARCHAR2, 
	in_pengirim IN VARCHAR2,
	in_potonganBon  IN NUMBER,
	in_createdBy IN VARCHAR2
)
IS
	v_totalBon number(20);
	v_pengirim varchar(20);
BEGIN
	
	update tb_timbangJembatanTemp 
	set paid_by = in_createdBy,
	timestamp_paid = current_timestamp 
	where no_nota = in_noNota;
	
	if in_potonganBon > 0 then
		pr_piutang_insert(in_noNota,in_pengirim,in_potonganBon,'bayar',
		'pembayaran hutang melalui pemotongan pembayaran sawit',null,in_createdBy);
	end if;
	
	insert into tb_timbangJembatan select * from tb_timbangJembatanTemp where no_nota = in_noNota;
	
	delete from tb_timbangJembatanTemp where no_nota = in_noNota;
	
  commit;
   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;

--  pr_auditLog_insert(in_createdBy,'pr_timbangGantung_insert',SQLERRM,
--  ''''||in_noNota||''','''||in_username||''','||in_potongan||','||in_bruto||','||in_harga||','''||in_catatan||''','''||in_createdBy||'''');

  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
  
END;
/