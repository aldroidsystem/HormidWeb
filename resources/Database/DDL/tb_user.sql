drop table tb_user;

create table tb_user (
username varchar2(30 char) not null,
fullname varchar2(50 char),
area varchar2(30 char),
address varchar2(10 char),
phone varchar2(15 char),
email varchar2(50 char),
password varchar2(100 char),
catatan varchar2(300 char),
login_fail_count NUMBER(1),
pwd_chg_date timestamp(6),
pwd_expiry_period number(3),
session_instance_count number(2),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagNeverDisable  NUMBER(1) default on NULL 0 CHECK(flagNeverDisable in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
flagChgPassword NUMBER(1) default on NULL 0 CHECK(flagChgPassword in (0,1)),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_user_pk PRIMARY KEY (username)
);