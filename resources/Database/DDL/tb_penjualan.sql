drop table  tb_penjualan;
drop sequence sq_penjualan_id;
create sequence sq_penjualan_id;

create table tb_penjualan (
penjualan_id number(38) default on null sq_penjualan_id.nextval,
no_nota varchar2(30 char) not null,
pabrik varchar2(50 char) not null,
supir varchar2(30 char) not null,
vehicle_id number(30) not null,
plate_number varchar2(10 char),
bruto number(10) not null,
tare number(10) not null,
netto number(10) not null,
potongan number(2) not null,
total_potongan number(10) not null,
berat_bersih number(10) not null,
harga number(10) not null,
total  number(20) not null,
pajak  number(20),
total_pajak  number(20),
total_bayar  number(20) not null,
tanggal timestamp not null,
uang_jalan  number(20),
biaya_kendaraan  number(20),
total_biaya_kendaraan  number(20),
gaji_supir  number(20),
gaji_kuli  number(20),
flag_Kuli_Bayar number(1),
flag_Supir_Bayar number(1),
catatan varchar2(300 char),
created_by varchar2(30 char) not null,
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_penjualan_pk PRIMARY KEY (penjualan_id)
);