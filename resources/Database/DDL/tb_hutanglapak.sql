drop table tb_hutanglapak;
drop sequence sq_hutanglapak_id;
create sequence sq_hutanglapak_id;

create table tb_hutanglapak (
hutanglapak_id number(38)  default on null sq_hutanglapak_id.nextval,
pemberi_pinjaman varchar2(30 char) not null,
target_pelunasan date,
jumlah_pinjaman number(20),
flagLunas NUMBER(1) default on NULL 0 CHECK(flagLunas in (0,1)),
tanggal_lunas timestamp,
keterangan varchar2(500 char),
created_by varchar2(30 char) not null,
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_hutanglapak_pk PRIMARY KEY (hutanglapak_id)
);