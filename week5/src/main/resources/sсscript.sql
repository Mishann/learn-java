drop database if exists blog ;
create database blog;
use blog;
--
CREATE TABLE User (
	id INT,
	firstName VARCHAR(50),
	lastName VARCHAR(50),
	CONSTRAINT PK_User PRIMARY KEY (id)
);

CREATE TABLE Factory (
	id INT,
	role VARCHAR(255),
	userId INT,
	CONSTRAINT PK_Factory PRIMARY KEY (id),
	CONSTRAINT FK_User FOREIGN KEY (userId)
	REFERENCES User (id)
		ON DELETE CASCADE
);

CREATE TABLE temp (
	id INT PRIMARY KEY AUTO_INCREMENT,
	role VARCHAR(255)
);

insert into
	User(id,firstName,lastName)
values
	(1,'Anna','Eriksen'),
	(2,'John','Smith'),
	(3,'Harry','Kane'),
	(4,'Mary','Ashton'),
	(5,'John','Doe');

insert into
	Factory(id,role,userId)
values
	(1,'manager',1),
	(2,'worker',1),
	(3,'worker',2),
	(4,'worker',3),
	(5,'worker',4),
	(6,'guard',5);

# disable foreign keys
#SET FOREIGN_KEY_CHECKS=0;
#delete from `User` where id = 1;

#delete on cascade
#delete from `User` where id =1;


start transaction;

insert into
	User(id,firstName,lastName)
values
	(6,'Eric','Dier');


SELECT  * FROM users;

insert into
	Factory(id,role,userId)
values
	(7,'worker',6);

commit;
