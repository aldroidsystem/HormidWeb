drop table tb_timbang_Jembatan;

create table tb_timbang_Jembatan (
no_slip   number(38) not null,
beratTimbangMasuk number(10),
timestampTimbangMasuk timestamp,
beratTimbangKeluar number(10),
timestampTimbangKeluar timestamp,
CONSTRAINT ct_timbang_jembatan_fk FOREIGN KEY (no_slip) REFERENCES tb_timbang (no_slip)
);