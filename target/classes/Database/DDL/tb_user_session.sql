drop table tb_user_session;
drop sequence sq_user_session_id;
create sequence sq_user_session_id;

create table tb_user_session (
user_session_id number(38)  default on null sq_user_session_id.nextval,
username varchar2(30) not null,
ip_address varchar2(30),
login_date timestamp,
logout_date timestamp,
logout_type varchar2(30),
device varchar2(30),
CONSTRAINT ct_user_session_pk PRIMARY KEY (username)
);