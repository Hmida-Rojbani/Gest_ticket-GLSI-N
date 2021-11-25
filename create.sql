create table client_entity (id integer not null auto_increment, courriel varchar(255), date_de_naissance date, nom varchar(50), prenom varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table met_entity (dtype varchar(31) not null, id integer not null auto_increment, nom varchar(255), prix double precision not null, primary key (id)) engine=InnoDB
create table table_rest (numero integer not null auto_increment, nb_couverts integer not null, supplements double precision not null, type varchar(255), primary key (numero)) engine=InnoDB
create table ticket_entity (numero integer not null auto_increment, addition double precision not null, date_time datetime, nb_couverts integer not null, client_id integer, table_numero integer, primary key (numero)) engine=InnoDB
create table ticket_entity_mets (tickets_numero integer not null, mets_id integer not null) engine=InnoDB
alter table ticket_entity add constraint FKbm6arj6b0xbh1o60jbue3vw6u foreign key (client_id) references client_entity (id)
alter table ticket_entity add constraint FKd1etdag1wr4ri1ma0q9dx5arm foreign key (table_numero) references table_rest (numero)
alter table ticket_entity_mets add constraint FK174n9wgohypt155tb3yg97nto foreign key (mets_id) references met_entity (id)
alter table ticket_entity_mets add constraint FKek9trmfb89ukoabtvjohk1s9q foreign key (tickets_numero) references ticket_entity (numero)
