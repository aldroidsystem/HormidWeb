create or replace 
Procedure pr_auditlog_insert( 
in_username in varchar2,
in_procedureName in varchar2,
in_errorcode in varchar2,
in_description in varchar2
)
IS
BEGIN
    
 insert into tb_auditlog(username,procedure_name,errorcode,description)
	values (in_username,in_procedureName,in_errorcode,in_description);
   commit;

EXCEPTION
WHEN OTHERS THEN
   raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END;