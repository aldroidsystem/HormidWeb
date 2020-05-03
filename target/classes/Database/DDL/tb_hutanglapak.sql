drop table tb_hutanglapak;
drop sequence sq_hutanglapak_id;
create sequence sq_hutanglapak_id;

create table tb_hutanglapak (
hutanglapak_id number(38)  default on null sq_hutanglapak_id.nextval,
pemberi_pinjaman varchar2(30) not null,
target_pelunasan date,
jumlah_pinjaman number(20),
flagLunas NUMBER(1) default on NULL 0 CHECK(flagLunas in (0,1)),
tanggal_lunas timestamp,
catatan varchar2(500),
created_by varchar(30) not null,
created_date timestamp,
updated_date timestamp,
CONSTRAINT ct_hutanglapak_pk PRIMARY KEY (hutanglapak_id)
);