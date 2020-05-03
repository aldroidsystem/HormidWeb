drop table tb_pengeluaran;
drop sequence sq_pengeluaran_id;
create sequence sq_pengeluaran_id;

create table tb_pengeluaran (
pengeluaran_id number(38)  default on null sq_pengeluaran_id.nextval,
jumlah_pengeluaran number(20),
tanggal_pengeluaran timestamp,
keterangan_pengeluaran varchar2(500),
created_by varchar(30) not null,
created_date timestamp,
updated_date timestamp,
CONSTRAINT ct_pengeluaran_pk PRIMARY KEY (pengeluaran_id)
);