drop table tb_timbang;
drop sequence sq_timbang_noslip;
create sequence sq_timbang_noslip;

create table tb_timbang (
no_slip number(38) default on null sq_timbangGantung_id.nextval,
petani varchar2(30) not null,
agen varchar2(30),
harga number(10),
potonganwajib number(20),
potonganhutang number(20),
potonganlainnya number(20),
keteranganpotongan varchar2(200),
biayaKuli number(20),
biayaLainnya number(20),
keteranganBiaya varchar2(200),
netto number(10),
bruto number(10),
refraksi number(2),
totalPotongan number(10),
totalBiaya number(20),
totalHarga number(20),
totalBayar number(20),
catatan varchar2(500),
dibuat_oleh varchar2(30) not null,
tanggal_Timbang timestamp default on null current_timestamp,
tanggal_ubah timestamp,
diubah_oleh varchar2(30),
status_code varchar(30),
alasan_ubah varchar(300),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
timestampDelete timestamp,
dihapus_oleh varchar2(30),
alasan_hapus varchar2(300),
CONSTRAINT ct_timbang_pk PRIMARY KEY (no_slip)
);