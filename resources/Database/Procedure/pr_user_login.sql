create or replace 
Procedure pr_user_login(
in_username IN VARCHAR2,
in_password IN VARCHAR2,
cursorResult OUT SYS_REFCURSOR)
IS
BEGIN
  

  OPEN cursorResult FOR 
  SELECT username, fullname, area, address, phone, email, password  
  from tb_user 
  where username = in_username
  and password=in_password
  and flagActive=1;

   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;
  pr_auditLog_insert(null,'pr_user_login',SQLERRM,''''||in_username||','''||in_password||'''');
  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
   
END;
/