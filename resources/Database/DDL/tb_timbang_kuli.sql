drop table tb_timbang_kuli;

create table tb_timbang_kuli (
no_slip   number(38) not null,
kuli varchar2(30 char) not null,
CONSTRAINT ct_timbang_kuli_fk FOREIGN KEY (no_slip) REFERENCES tb_timbang (no_slip),
CONSTRAINT ct_timbang_kuli_kuli_fk FOREIGN KEY (kuli) REFERENCES tb_user (username)
);