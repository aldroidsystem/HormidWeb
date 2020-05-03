/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Oct 24, 2016
 */
DROP  VIEW IF EXISTS vw_employee_last;
CREATE VIEW vw_employee_last AS 
SELECT tbl.* FROM tbl_employee tbl
INNER JOIN (
    SELECT 
max(id) as id, 
publicId
 from  tbl_employee GROUP BY publicId) tblTemp on tbl.id= tblTemp.id;