/**
 * Author:  renaldo
 * Created: Mar 19, 2019
 */

DROP TABLE  tb_message_properties;

CREATE TABLE tb_message_properties (
resource_key varchar(30) not null,
message varchar(100),
flagActive  NUMBER(1) default on NULL 1 CHECK(flagActive in (0,1)),
flagDeleted NUMBER(1) default on NULL 0 CHECK(flagDeleted in (0,1)),
CONSTRAINT ct_message_properties_pk PRIMARY KEY (resource_key)
);