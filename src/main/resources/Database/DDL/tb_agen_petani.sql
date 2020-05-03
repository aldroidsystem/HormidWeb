drop table tb_agen_petani;

create table tb_agen_petani (
agen varchar2(30 char) not null,
petani varchar2(30 char) not null,
created_by varchar2(30 char) not null,
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_agen_petani_agen_fk FOREIGN KEY (agen) REFERENCES tb_user (username),
CONSTRAINT ct_agen_petani_petani_fk FOREIGN KEY (petani) REFERENCES tb_user (username)
);