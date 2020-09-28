drop table tb_agen;

create table tb_agen (
username varchar2(30),
default_potongan_persen number(2),
catatan varchar2(500 char),
flag_Active  NUMBER(1),
flag_Deleted NUMBER(1),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_agen_pk PRIMARY KEY (username),
CONSTRAINT ct_agen_user_fk FOREIGN KEY (username) REFERENCES tb_user (username)
);