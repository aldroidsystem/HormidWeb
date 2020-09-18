drop table tb_user;

create table tb_user (
username varchar2(30 char) not null,
fullname varchar2(50 char),
area varchar2(30 char),
address varchar2(100 char),
phone varchar2(15 char),
email varchar2(50 char),
password varchar2(100 char),
login_fail_count SMALLINT default on NULL 0,
pwd_chg_date date default on null sysdate,
pwd_expiry_period  SMALLINT,
session_instance_count SMALLINT default on NULL 0,
flag_Active NUMBER(1) default on NULL 1 CHECK(flag_Active in (0,1)),
flag_never_locked  NUMBER(1) default on NULL 0 CHECK(flag_never_locked in (0,1)),
flag_deleted NUMBER(1) default on NULL 0 CHECK(flag_deleted in (0,1)),
flag_force_reset_pwd NUMBER(1) default on NULL 0 CHECK(flag_force_reset_pwd in (0,1)),
flag_locked  NUMBER(1) default on NULL 0 CHECK(flag_locked in (0,1)),
token varchar2(36 char ),
token_creation_date timestamp default on null current_timestamp,
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_user_pk PRIMARY KEY (username)
);


create index ix_user_fullname on tb_user ( fullname );