drop table tb_vehicle;

create table tbl_vehicle (
platenumber varchar2(12) not null,
vehicleType varchar2(20),
notes varchar(300),
supir varchar(30) not null,
update_date timestamp,
create_date timestamp,
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_vehicle_pk PRIMARY KEY (platenumber)
);