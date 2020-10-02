drop table tb_agen_petani;

create table tb_agen_petani (
agen varchar2(30 char) not null,
petani varchar2(30 char) not null,
CONSTRAINT ct_agen_petani_pk PRIMARY KEY (agen,petani),
CONSTRAINT ct_agen_agpet_fk FOREIGN KEY (agen) REFERENCES tb_user (username),
CONSTRAINT ct_petani_agpet_fk FOREIGN KEY (petani) REFERENCES tb_user (username)
);