drop table tb_supir;

create table tb_supir (
username varchar2(30),
catatan varchar2(500 char),
flag_Active  NUMBER(1),
flag_Deleted NUMBER(1),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_supir_pk PRIMARY KEY (username),
CONSTRAINT ct_supir_user_fk FOREIGN KEY (username) REFERENCES tb_user (username)
);