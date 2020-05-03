drop table  tb_setor;
drop sequence sq_setor_id;
create sequence sq_setor_id;

create table tb_setor (
setor_id number(38) default on null sq_setor_id.nextval,
no_nota varchar(30) not null,
pabrik_setor varchar2(50) not null,
supir varchar2(30) not null,
no_polisi varchar2(20) not null,
berat_kirim number(10),
berat_kembali number(10),
harga number(10),
bruto number(10),
netto number(10),
satuan_berat varchar2(10),
catatan varchar2(300),
total_harga  number(20),
dibuat_oleh varchar2(30) not null,
tanggal_setor timestamp default on null current_timestamp,
tanggal_ubah timestamp,
diubah_oleh varchar2(30),
status_code varchar(30),
alasan_ubah varchar(300),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
timestampDelete timestamp,
dihapus_oleh varchar2(30),
alasan_hapus varchar2(300),
CONSTRAINT ct_setor_pk PRIMARY KEY (setor_id)
);