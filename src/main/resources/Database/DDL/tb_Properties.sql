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
property_code varchar2(30 char) not null,
peroperty_name varchar2(50 char) not null,
property_desc varchar2(100 char),
datatype varchar2(30 char),
property_value varchar2(100 char),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_properties_pk PRIMARY KEY (property_code)
);