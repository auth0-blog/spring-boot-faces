drop table spring_session_attributes if exists;
drop table spring_session if exists;

create table spring_session (
	session_id char(36) not null,
	creation_time bigint not null,
	last_access_time bigint not null,
	max_inactive_interval int not null,
	principal_name varchar(100),
	constraint spring_session_pk
	    primary key (session_id)
);

create index spring_session_idx on spring_session (last_access_time);

create table spring_session_attributes (
	session_id char(36) not null,
	attribute_name varchar(200) not null,
	attribute_bytes longvarbinary not null,
	constraint spring_session_attributes_pk
      primary key (session_id, attribute_name),
	constraint spring_session_attributes_fk
      foreign key (session_id)
      references spring_session(session_id)
      on delete cascade
);

create index spring_session_attributes_idx on spring_session_attributes (session_id);
