drop table tb_hutang;
drop sequence sq_hutang_id;
create sequence sq_hutang_id;

create table tb_hutang (
hutang_id number(38)  default on null sq_hutang_id.nextval,
peminjam varchar2(30) not null,
created_by varchar(30) not null,
updated_date timestamp,
created_date timestamp,
jumlah_pinjaman number(20),
catatan varchar2(500),
flagLunas NUMBER(1) default on NULL 0 CHECK(flagLunas in (0,1)),
CONSTRAINT ct_hutang_pk PRIMARY KEY (hutang_id),
CONSTRAINT ct_hutang_user_fk FOREIGN KEY (peminjam) REFERENCES tb_user (username)
);