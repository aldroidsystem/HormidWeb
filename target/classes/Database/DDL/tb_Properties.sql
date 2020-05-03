/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Sep 12, 2016
 */

drop table tb_properties;

create table tb_properties (
property_code varchar(15) not null,
peroperty_name varchar(30) not null,
property_desc varchar(100),
datatype varchar(15),
property_value varchar(100),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_properties_pk PRIMARY KEY (property_code)
);