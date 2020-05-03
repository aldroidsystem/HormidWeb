drop table tb_role;

create table tb_role (
role_code varchar2(30 char) not null,
role_name varchar2(30 char),
role_desc varchar2(50 char),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_role_pk PRIMARY KEY (role_code)
);