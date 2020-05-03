drop table tb_cicilan;
drop sequence sq_cicilan_id;
create sequence sq_cicilan_id;

create table tb_cicilan (
cicilan_id number(38)  default on null sq_cicilan_id.nextval,
peminjam varchar2(30) not null,
created_by varchar(30) not null,
updated_date timestamp,
created_date timestamp,
jumlah_cicilan number(20),
catatan varchar2(500),
CONSTRAINT ct_cicilan_pk PRIMARY KEY (cicilan_id),
CONSTRAINT ct_cicilan_user_fk FOREIGN KEY (peminjam) REFERENCES tb_user (username)
);