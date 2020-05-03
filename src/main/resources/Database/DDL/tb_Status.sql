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
status_code varchar2(30 char) not null,
module_code varchar2(30 char),
status_name varchar2(30 char),
status_desc varchar2(50 char),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_status_pk PRIMARY KEY (status_code),
CONSTRAINT ct_status_module_fk FOREIGN KEY (module_code) REFERENCES tb_module (module_code)
);