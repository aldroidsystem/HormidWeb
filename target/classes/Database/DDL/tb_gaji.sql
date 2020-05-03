drop table tb_gaji;
drop sequence sq_gaji_id;
create sequence sq_gaji_id;

create table tb_gaji (
gaji_id number(38)  default on null sq_gaji_id.nextval,
karyawan varchar2(30) not null,
periode_dari date,
periode_sampai date,
jumlah_gaji number(20),
created_by varchar(30) not null,
updated_date timestamp,
created_date timestamp,
catatan varchar2(500),
CONSTRAINT ct_gaji_pk PRIMARY KEY (gaji_id),
CONSTRAINT ct_gaji_karyawan_fk FOREIGN KEY (karyawan) REFERENCES tb_user (username),
CONSTRAINT ct_gaji_createdby_fk FOREIGN KEY (created_by) REFERENCES tb_user (username)
);