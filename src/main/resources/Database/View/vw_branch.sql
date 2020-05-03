/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Oct 24, 2016
 */
DROP  VIEW IF EXISTS vw_branch;
CREATE VIEW vw_branch AS 
SELECT * FROM vw_branch_last tbl where statusid <> 2;