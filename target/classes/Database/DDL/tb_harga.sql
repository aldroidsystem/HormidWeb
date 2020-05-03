drop table tb_harga;
drop sequence sq_harga_id;
create sequence sq_harga_id;

create table tb_harga (
harga_id number(38)  default on null sq_harga_id.nextval,
created_by varchar(30) not null,
created_date timestamp,
harga_jual number(10),
harga_beli number(10),
CONSTRAINT ct_harga_pk PRIMARY KEY (harga_id)
);