/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Oct 23, 2016
 */

drop table tb_status;

create table tb_status (
status_code varchar(30) not null,
module_code varchar(30),
status_name varchar(30),
status_desc varchar(50),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_status_pk PRIMARY KEY (status_code),
CONSTRAINT ct_status_module_fk FOREIGN KEY (module_code) REFERENCES tb_module (module_code)
);