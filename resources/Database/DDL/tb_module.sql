/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: May 1, 2020
 */

drop table tb_module;

 CREATE TABLE TB_MODULE
   (MODULE_CODE VARCHAR2(30 CHAR) NOT NULL, 
	MODULE_NAME VARCHAR2(30 CHAR), 
	MODULE_DESC VARCHAR2(50 CHAR), 
  flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
  flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
	CONSTRAINT CT_MODULE_PK PRIMARY KEY (MODULE_CODE) 
   );