/**
 * Author:  renaldo
 * Created: Mar 19, 2019
 */

DROP TABLE  tb_message_resource;

CREATE TABLE tb_message_resource (
	resource_key varchar2(255 char) not null,
	locale varchar2(2 char) not null,
	message varchar2(255 char),
	CONSTRAINT ct_message_properties_pk PRIMARY KEY (resource_key,locale)
);
