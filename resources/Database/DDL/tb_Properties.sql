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
property_code varchar2(100 char) not null,
property_desc varchar2(255 char),
datatype varchar2(30 char),
property_value varchar2(100 char),
CONSTRAINT ct_properties_pk PRIMARY KEY (property_code)
); 