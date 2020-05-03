drop table tb_kuli_timbang;

create table tb_kuli_timbang (
no_slip   number(38) not null,
kuli number(30),
CONSTRAINT ct_kuli_timbangl_fk FOREIGN KEY (no_slip) REFERENCES tb_timbang (no_slip)
);