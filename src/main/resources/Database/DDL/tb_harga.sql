drop table tb_harga;
drop sequence sq_harga_id;
create sequence sq_harga_id;

create table tb_harga (
harga_id number(38)  default on null sq_harga_id.nextval,
tanggal_mulai date,
harga_jual number(10),
harga_beli number(10),
created_by varchar2(30 char) not null,
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_harga_pk PRIMARY KEY (harga_id)
);