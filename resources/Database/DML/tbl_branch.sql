/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Dec 7, 2016
 */

INSERT INTO TBL_BRANCH (
publicid,
branchname,
phone,
email,
village,
address,
notes,
parentId,
relationType,
lastupdatedby,
statusid) 
VALUES (
-1,
'Horas Miduk Makartitama',
'01234',
'bedjo.aldroid@gmail.com',
'Makartitama',
'Jl Lintas Rawa Jitu, Kec Penawartama',
'',
null,
0,--corporate
0,
1--status update
);