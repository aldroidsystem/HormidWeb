
create or replace 
Procedure pr_harga_insert( 
in_tanggalMulai in TIMESTAMP,
in_hargaJual in NUMBER,
in_hargaBeli in NUMBER,
in_createdBy IN VARCHAR2
)
IS
BEGIN
    
  insert into tb_harga(tanggalMulai,hargaJual,hargaBeli,createdDate)
	values (in_tanggalMulai,in_hargaJual,in_hargaBeli,in_createdBy);

  commit;
   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;
  pr_auditLog_insert(in_createdBy,'pr_harga_insert',SQLERRM,''''||in_tanggalMulai||''','||in_hargaJual||','||in_hargaBeli||','''||in_createdBy||'''');
  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
   
END;
/