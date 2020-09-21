drop table tb_vehicle_agen;

create table tb_vehicle_agen (
vehicle_id number(38),
username varchar(30),
CONSTRAINT ct_vehicle_agen_pk PRIMARY KEY (vehicle_id,username),
CONSTRAINT ct_vehicle_vehag_fk FOREIGN KEY (vehicle_id) REFERENCES tb_vehicle (vehicle_id),
CONSTRAINT ct_agen_vehag_fk FOREIGN KEY (username) REFERENCES tb_agen (username)
);