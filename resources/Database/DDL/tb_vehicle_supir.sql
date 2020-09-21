drop table tb_vehicle_supir;

create table tb_vehicle_supir (
vehicle_id number(38),
username varchar(30),
CONSTRAINT ct_vehicle_supir_pk PRIMARY KEY (vehicle_id,username),
CONSTRAINT ct_vehicle_fk FOREIGN KEY (vehicle_id) REFERENCES tb_vehicle (vehicle_id),
CONSTRAINT ct_supir_fk FOREIGN KEY (username) REFERENCES tb_supir (username)
);