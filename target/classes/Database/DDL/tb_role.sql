drop table tb_role;

create table tb_role (
role_code varchar(30) not null,
role_name varchar(30),
role_desc varchar(50),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_role_pk PRIMARY KEY (role_code)
);