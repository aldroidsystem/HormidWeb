drop table tb_harga;
drop sequence sq_harga_id;
create sequence sq_harga_id;

create table tb_harga (
hargaId number(38)  default on null sq_harga_id.nextval,
tanggalMulai date,
hargaJual number(10),
hargaBeli number(10),
createdBy varchar2(30 char) not null,
createdDate timestamp default on null current_timestamp,
CONSTRAINT ct_harga_pk PRIMARY KEY (hargaId)
);