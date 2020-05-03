
drop table tb_timbang_mobil;

create table tb_timbang_mobil (
no_slip   number(38) not null,
supir varchar2(30 char),
no_polisi varchar2(10 char),
CONSTRAINT ct_timbang_mobil_fk FOREIGN KEY (no_slip) REFERENCES tb_timbang (no_slip),
CONSTRAINT ct_timbang_mobil_supir_fk FOREIGN KEY (supir) REFERENCES tb_user (username)
);
