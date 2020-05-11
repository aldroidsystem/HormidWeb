create or replace 
Procedure pr_harga_selectCurrentPrice(cursorResult OUT SYS_REFCURSOR)
IS
BEGIN
  
  OPEN cursorResult FOR 
  SELECT * FROM (
    SELECT a.*, ROW_NUMBER() OVER (ORDER BY tanggal_mulai DESC, harga_id desc) rank FROM tb_harga a
  ) a WHERE a.rank = 1;

   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;
  pr_auditLog_insert(null,'pr_harga_selectCurrentPrice',SQLERRM,null);
  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
   
END;
/