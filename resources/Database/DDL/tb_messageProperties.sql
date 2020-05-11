/**
 * Author:  renaldo
 * Created: Mar 19, 2019
 */

DROP TABLE  tb_messageProperties;

CREATE TABLE tb_messageProperties (
resource_key varchar2(30 char) not null,
message varchar2(100 char),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_message_properties_pk PRIMARY KEY (resource_key)
);