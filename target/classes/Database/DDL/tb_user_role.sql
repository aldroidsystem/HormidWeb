drop table tb_user_role;

create table tb_user_role (
role_code varchar(30) not null,
username varchar(30) not null,
updated_date timestamp,
CONSTRAINT ct_user_role_pk PRIMARY KEY (role_code,username),
CONSTRAINT ct_user_role_role_fk FOREIGN KEY (role_code) REFERENCES tb_role (role_code),
CONSTRAINT ct_user_role_user_fk FOREIGN KEY (username) REFERENCES tb_user (username)
);