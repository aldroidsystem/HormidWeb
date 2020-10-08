drop table tb_timbangGantung;
drop sequence sq_timbangGantung_id;
create sequence sq_timbangGantung_id;

create table tb_timbangGantung (
no_nota varchar2(38) not null,
username varchar2(30 char) not null,
bruto number(10),
potongan number(2),
total_potongan number(10),
netto number(10),
harga number(5),
pembulatan number(3);
total number(20),
catatan varchar2(500 char),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_timbangGantung_pk PRIMARY KEY (no_nota),
CONSTRAINT ct_timbangGantung_petani_fk FOREIGN KEY (username) REFERENCES tb_user (username),
CONSTRAINT ct_timbangGantung_kasir_fk FOREIGN KEY (created_by) REFERENCES tb_user (username)
);