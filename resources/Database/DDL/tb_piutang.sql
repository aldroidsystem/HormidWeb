drop table tb_piutang;
drop sequence sq_piutang_id;
create sequence sq_piutang_id;

create table tb_piutang (
piutang_id varchar2(38)  not null,
username varchar2(30 char) not null,
hutang number(20),
bayar number(20),
sisa_hutang number(20),
keterangan varchar2(529 char),
catatan varchar2(529 char),
created_by varchar2(30 char) not null,
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_piutang_pk PRIMARY KEY (piutang_id),
CONSTRAINT ct_piutang_user_fk FOREIGN KEY (username) REFERENCES tb_user (username)
);