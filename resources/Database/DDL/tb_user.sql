drop table tb_user;

create table tb_user (
username varchar2(30 char) not null,
fullname varchar2(50 char),
area varchar2(30 char),
address varchar2(100 char),
phone varchar2(15 char),
email varchar2(50 char),
password varchar2(100 char),
catatan varchar2(300 char),
login_fail_count SMALLINT default on NULL 0 CHECK(login_fail_count in (0,1)),
pwd_chg_date timestamp(6),
pwd_expiry_period  SMALLINT default on NULL 0 CHECK(pwd_expiry_period in (0,1)),
session_instance_count SMALLINT default on NULL 0 CHECK(session_instance_count in (0,1)),
flagActive SMALLINT default on NULL 1 CHECK(flagActive in (0,1)),
flagNeverDisable  SMALLINT default on NULL 0 CHECK(flagNeverDisable in (0,1)),
flagDeleted SMALLINT default on NULL 0 CHECK(flagDeleted in (0,1)),
flagChgPassword SMALLINT default on NULL 0 CHECK(flagChgPassword in (0,1)),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_user_pk PRIMARY KEY (username)
);

alter table
   tb_user
modify
(
login_fail_count SMALLINT default on NULL 0 CHECK(login_fail_count in (0,1)),
pwd_expiry_period  SMALLINT default on NULL 0 CHECK(pwd_expiry_period in (0,1)),
session_instance_count SMALLINT default on NULL 0 CHECK(session_instance_count in (0,1)),
flagActive SMALLINT default on NULL 1 CHECK(flagActive in (0,1)),
flagNeverDisable  SMALLINT default on NULL 0 CHECK(flagNeverDisable in (0,1)),
flagDeleted SMALLINT default on NULL 0 CHECK(flagDeleted in (0,1)),
flagChgPassword SMALLINT default on NULL 0 CHECK(flagChgPassword in (0,1))
);