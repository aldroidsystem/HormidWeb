drop table tb_user_role;

create table tb_user_role (
role_code varchar2(30 char) not null,
username varchar2(30 char) not null,
CONSTRAINT ct_user_role_pk PRIMARY KEY (role_code,username),
CONSTRAINT ct_user_role_role_fk FOREIGN KEY (role_code) REFERENCES tb_role (role_code),
CONSTRAINT ct_user_role_user_fk FOREIGN KEY (username) REFERENCES tb_user (username)
);