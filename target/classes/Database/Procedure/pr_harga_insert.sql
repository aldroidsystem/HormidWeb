create or replace 
Procedure pr_harga_insert( 
in_createdBy IN VARCHAR2,
in_createdDate in TIMESTAMP,
in_hargaJual in NUMBER,
in_hargaBeli in NUMBER
)
IS
BEGIN
    
 insert into tb_harga(CREATED_BY,CREATED_DATE,HARGA_JUAL,HARGA_BELI)
	values (in_createdBy,in_createdDate,in_hargaJual,in_hargaBeli);

   commit;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END;
/