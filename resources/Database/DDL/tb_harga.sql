drop table tb_harga;
drop sequence sq_harga_id;
create sequence sq_harga_id;

create table tb_harga (
hargaId number(38)  default on null sq_harga_id.nextval,
tanggal_mulai date,
harga_jual number(5),
harga_beli_jembatan number(5),
harga_beli_gantung number(5),
createdBy varchar2(30 char) not null,
createdDate timestamp default on null current_timestamp,
CONSTRAINT ct_harga_pk PRIMARY KEY (hargaId)
);