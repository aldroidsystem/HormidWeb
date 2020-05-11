drop table tb_note;
drop sequence sq_note_id;
create sequence sq_note_id;

create table tb_note (
note_id number(38)  default on null sq_note_id.nextval,
entity_key varchar2(30 char) not null,
entity_module varchar2(30 char) not null,
created_by varchar2(30 char) not null,
updated_date timestamp default on null current_timestamp,
created_date timestamp default on null current_timestamp,
CONSTRAINT ct_note_pk PRIMARY KEY (note_id)
);