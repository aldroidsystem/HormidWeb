drop table tb_timbang_mobil;

create table tb_timbang_mobil (
no_slip   number(38) not null,
supir number(30),
no_polisi varchar2(10),
CONSTRAINT ct_timbang_mobil_fk FOREIGN KEY (no_slip) REFERENCES tb_timbang (no_slip)
);