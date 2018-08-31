CREATE TABLE question (
id INT PRIMARY KEY AUTO_INCREMENT,
subject VARCHAR(255),
description VARCHAR(1000),
answer VARCHAR(1000)
);

insert into question (subject, description, answer) values ('Spring Boot', 'What is Spring Boot?', 'Framework that makes is easy to develop Spring applications.');
insert into question (subject, description, answer) values ('Spring Boot', 'What are Spring Boot Starters?', 'Starters are dependency descriptors that reference a list of libraries.');
insert into question (subject, description, answer) values ('Spring Boot', 'What is the name for Spring Boot Web Starter ?', 'spring-boot-starter-web');
insert into question (subject, description, answer) values ('Spring Boot', 'What is the name for Spring Boot JPA Starter ?', 'spring-boot-starter-data-jpa');

