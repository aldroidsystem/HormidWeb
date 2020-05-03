/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Oct 24, 2016
 */
DROP  VIEW IF EXISTS vw_vehicle;
CREATE VIEW vw_vehicle AS 
SELECT * FROM vw_vehicle_last where statusid <> 2;