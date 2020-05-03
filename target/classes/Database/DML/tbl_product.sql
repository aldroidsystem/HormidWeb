/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Dec 11, 2016
 */

INSERT INTO TBL_PRODUCT (
publicid,
"name",
description,
potonganBerat,
harga,
branchId,
statusid,
lastupdatedby) 
VALUES (
(nextval('sec_publicId_product') * 0),
'Kelapa Sawit',
'-',
8,
1500,
-1,
1,--status create
0);