drop table tb_vehicle_petani;

create table tb_vehicle_petani (
vehicle_id number(38),
username varchar(30),
CONSTRAINT ct_vehicle_petani_pk PRIMARY KEY (vehicle_id,username),
CONSTRAINT ct_vehicle_vehpet_fk FOREIGN KEY (vehicle_id) REFERENCES tb_vehicle (vehicle_id),
CONSTRAINT ct_petani_fk FOREIGN KEY (username) REFERENCES tb_petani (username)
);