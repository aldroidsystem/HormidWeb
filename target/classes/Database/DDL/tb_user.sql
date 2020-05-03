drop table tb_user;

create table tb_user (
username varchar2(30) not null,
fullname varchar2(30),
area varchar2(30),
address varchar2(50),
phone varchar2(15),
email varchar2(35),
password varchar2(100),
memo varchar2(100),
login_fail_cnount NUMBER(3),
pwd_chg_date timestamp(6),
pwd_expiry_period number(3),
session_instance_count number(2),
updated_date timestamp,
created_date timestamp default on null current_timestamp,
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagNeverDisable  NUMBER(1) default on NULL 0 CHECK(flagNeverDisable in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
flagChgPassword NUMBER(1) default on NULL 0 CHECK(flagChgPassword in (0,1)),
CONSTRAINT ct_user_pk PRIMARY KEY (username)
);