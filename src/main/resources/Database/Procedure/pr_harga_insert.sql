create or replace 
Procedure pr_harga_insert( 
in_tanggalMulai date,
in_createdBy IN VARCHAR2(30 char),
in_createdDate in TIMESTAMP,
in_hargaJual in NUMBER(10),
in_hargaBeli in NUMBER(10),
out_result out VARCHAR2(2 char)
)
IS
BEGIN
    
 insert into tb_harga(TANGGAL_MULAI, CREATED_BY,CREATED_DATE,HARGA_JUAL,HARGA_BELI)
	values (in_tanggalMulai,in_createdBy,in_createdDate,in_hargaJual,in_hargaBeli);

   commit;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END;
/