drop table tb_vehicle;

create table tb_vehicle (
platenumber varchar2(10 char) not null,
vehicleType varchar2(20 char),
catatan varchar2(300 char),
supir varchar2(30 char) not null,
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
updated_date timestamp default on null current_timestamp,
CONSTRAINT ct_vehicle_pk PRIMARY KEY (platenumber),
CONSTRAINT ct_vehicle_supir_fk FOREIGN KEY (supir) REFERENCES tb_user (username)
);