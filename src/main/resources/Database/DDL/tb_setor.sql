drop table  tb_setor;
drop sequence sq_setor_id;
create sequence sq_setor_id;

create table tb_setor (
setor_id number(38) default on null sq_setor_id.nextval,
no_nota varchar2(30 char) not null,
pabrik_setor varchar2(50 char) not null,
supir varchar2(30 char) not null,
no_polisi varchar2(20 char) not null,
berat_kirim number(10),
berat_kembali number(10),
harga number(10),
bruto number(10),
netto number(10),
satuan_berat varchar2(10 char),
catatan varchar2(300 char),
total_harga  number(20),
tanggal_setor timestamp default on null current_timestamp,
status_code varchar2(30),
created_by varchar2(30 char) not null,
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_setor_pk PRIMARY KEY (setor_id)
);