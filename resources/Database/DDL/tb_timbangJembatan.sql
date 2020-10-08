drop table tb_timbangJembatan;
drop sequence sq_timbangJembatan_id;
create sequence sq_timbangJembatan_id;

create table tb_timbangJembatan (
no_nota varchar2(38) not null,
pengirim varchar2(30 char),
supir varchar2(30 char),
vehicle_id number(38),
plate_number varchar2(10 char),
bruto number(10),
tare number(10),
netto number(10),
potongan number(2),
total_potongan number(10),
beratBersih number(10),
harga number(5),
total number(20),
biaya_bongkar number(10),
biaya_mobil number(10),
potongan_bon number(20),
sisa_bon number(20),
biaya_lain number(20),
keterangan_biaya_lain varchar2(150 char),
pembulatan number(3),
total_bayar number(20),
catatan varchar2(500 char),
flag_lunas number(1) default on NULL 0,
flag_kros number(1),
flag_kuli_lunas number(1) default on NULL 0,
timbang1_by varchar2(30 char),
timbang2_by varchar2(30 char),
paid_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
timestamp_timbang1 timestamp,
timestamp_timbang2 timestamp,
timestamp_paid timestamp,
CONSTRAINT ct_timbangJembatan_pk PRIMARY KEY (no_nota),
CONSTRAINT ct_timbangJembatan_pengirim_fk FOREIGN KEY (pengirim) REFERENCES tb_user (username),
CONSTRAINT ct_timbangJembatan_supir_fk FOREIGN KEY (supir) REFERENCES tb_user (username),
CONSTRAINT ct_timbangJembatan_vehicle_fk FOREIGN KEY (vehicle_id) REFERENCES tb_vehicle (vehicle_id),
CONSTRAINT ct_timbangJembatan_tbg1By_fk FOREIGN KEY (timbang1_by) REFERENCES tb_user (username),
CONSTRAINT ct_timbangJembatan_tbg2By_fk FOREIGN KEY (timbang2_by) REFERENCES tb_user (username),
CONSTRAINT ct_timbangJembatan_paidBy_fk FOREIGN KEY (paid_by) REFERENCES tb_user (username)
);