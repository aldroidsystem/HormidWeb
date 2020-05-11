/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Oct 24, 2016
 */
DROP  VIEW IF EXISTS vw_vehicle_last;
CREATE VIEW vw_vehicle_last AS 
SELECT tbl.* FROM tbl_vehicle tbl
INNER JOIN (
    SELECT 
max(id) as id, 
publicId
 from  tbl_vehicle GROUP BY publicId) tblTemp on tbl.id= tblTemp.id;