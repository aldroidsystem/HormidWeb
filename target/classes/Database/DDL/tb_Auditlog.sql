/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Sep 12, 2016
 */

drop table tb_auditlog;

create table tb_auditlog (
log_timestamp timestamp default on null current_timestamp,
tablename varchar2(15),
errorcode varchar2(100),
title varchar2(50), 
description varchar2(300)
);

CREATE INDEX ix_auditlog_log_timestamp ON tb_auditlog(log_timestamp);