drop table tbr_user_role_vehicle;

create table tbr_user_role_vehicle (
vehicle_id number(38) not null,
username varchar(30) not null,
role_code varchar2(30 char) not null,
CONSTRAINT ct_usrolveh_pk PRIMARY KEY (vehicle_id,username,role_code),
CONSTRAINT ct_usrolveh_vehicle_fk FOREIGN KEY (vehicle_id) REFERENCES tb_vehicle (vehicle_id),
CONSTRAINT ct_usrolveh_user_fk FOREIGN KEY (username) REFERENCES tb_user (username),
CONSTRAINT ct_usrolveh_role_fk FOREIGN KEY (role_code) REFERENCES tb_role (role_code)
);