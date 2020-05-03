/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Oct 24, 2016
 */
DROP  VIEW IF EXISTS vw_user_last;
CREATE VIEW vw_user_last AS 
SELECT usr.* FROM tbl_user usr
INNER JOIN (
    SELECT 
max(id) as id, 
publicId
 from  tbl_user GROUP BY publicId) usrTemp on usr.id= usrTemp.id;