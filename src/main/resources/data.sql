/*
create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);

*/
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());

INSERT INTO COURSE (ID, NAME ) 
VALUES(10001, 'JPA Course');

INSERT INTO COURSE (ID,  NAME ) 
VALUES(10002, 'Java Course');

INSERT INTO COURSE (ID,  NAME ) 
VALUES(10004, 'Junit Course');