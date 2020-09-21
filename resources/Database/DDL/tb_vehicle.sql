drop table tb_vehicle;
drop sequence sq_vehicle_id;
create sequence sq_vehicle_id;


create table tb_vehicle (
vehicle_id number(38) default on null sq_vehicle_id.nextval,
plate_number varchar2(10 char) not null,
vehicle_type varchar2(20 char),
default_biaya_bongkar number(7),
catatan varchar2(500 char),
flag_Active  NUMBER(1),
flag_Deleted NUMBER(1),
created_by varchar2(30 char),
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_vehicle_pk PRIMARY KEY (vehicle_id)
);