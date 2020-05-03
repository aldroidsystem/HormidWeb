drop table tb_note;
drop sequence sq_note_id;
create sequence sq_note_id;

create table tb_note (
note_id number(38)  default on null sq_note_id.nextval,
created_by varchar(30) not null,
updated_date timestamp,
created_date timestamp,
entity_key varchar(30) not null,
entity_module varchar(30) not null,
CONSTRAINT ct_note_pk PRIMARY KEY (note_id)
);