drop table  tb_pabrik;
drop sequence sq_pabrik_id;
create sequence sq_pabrik_id;

create table tb_pabrik (
pabrik_id number(38) default on null sq_pabrik_id.nextval,
nama_Perusahaan varchar2(50 char) not null,
uang_jalan_truk number(10) not null,
biaya_Mobil_Truk number(3) not null,
uang_jalan_tronton number(10) not null,
biaya_Mobil_tronton number(3) not null,
catatan varchar2(300 char),
updated_by varchar2(30 char) not null,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_pabrik_pk PRIMARY KEY (pabrik_id)
);