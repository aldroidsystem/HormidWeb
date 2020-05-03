drop table tb_timbang;
drop sequence sq_timbang_noslip;
create sequence sq_timbang_noslip;

create table tb_timbang (
no_slip number(38) default on null sq_timbangGantung_id.nextval,
petani varchar2(30 char) not null,
agen varchar2(30 char),
harga number(10),
potonganwajib number(20),
potonganhutang number(20),
potonganlainnya number(20),
keteranganpotongan varchar2(200 char),
biayaKuli number(20),
biayaLainnya number(20),
keteranganBiaya varchar2(200 char),
netto number(10),
bruto number(10),
refraksi number(2),
totalPotongan number(10),
totalBiaya number(20),
totalHarga number(20),
totalBayar number(20),
catatan varchar2(500 char),
tanggal_Timbang timestamp default on null current_timestamp,
status_code varchar2(30 char),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_timbang_pk PRIMARY KEY (no_slip),
CONSTRAINT ct_timbang_petani_fk FOREIGN KEY (petani) REFERENCES tb_user (username),
CONSTRAINT ct_timbang_agen_fk FOREIGN KEY (agen) REFERENCES tb_user (username)
);