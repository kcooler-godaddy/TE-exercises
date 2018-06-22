--create database organizer;
--drop table employee_project;
--drop table employee;
--drop table job;
--drop table department;
--drop table project;

create table department (
        department_number serial,
        name varchar(35) not null,
        
        constraint pk_department_number primary key (department_number)
);

create table project (
        project_number serial,
        name varchar(35) not null,
        start_date date not null,
        
        constraint pk_project_number primary key (project_number)
);

create table job (
        job_id serial,
        title varchar(50) not null,
        department_number int not null,
        
        constraint pk_job_id primary key (job_id),
        constraint fk_department_number foreign key (department_number) references department (department_number)
);

create table employee (
        employee_number serial,
        first_name varchar(35) not null,
        last_name varchar(35) not null,
        gender varchar(20),
        birthday date not null,
        hire_date date not null,
        job_id int not null, 
        
        constraint pk_employee_number primary key (employee_number),
        constraint fk_job_id foreign key (job_id) references job (job_id)
);

create table employee_project (
        employee_project_id serial,
        employee_number int not null,
        project_number int not null,
        
        constraint pk_employee_project_id primary key (employee_project_id),
        constraint fk_employee_number foreign key (employee_number) references employee (employee_number),
        constraint fk_project_number foreign key (project_number) references project (project_number)
);

insert into department (name) values ('Production');
insert into department (name) values ('Warehouse');
insert into department (name) values ('Engineering');

insert into job (title, department_number) values ('Developer', (select department_number from department where name = 'Engineering'));
insert into job (title, department_number) values ('Automation Tester', (select department_number from department where name = 'Engineering'));
insert into job (title, department_number) values ('Driver', (select department_number from department where name = 'Warehouse'));
insert into job (title, department_number) values ('Paletizer', (select department_number from department where name = 'Warehouse'));
insert into job (title, department_number) values ('Wrapper', (select department_number from department where name = 'Production'));
insert into job (title, department_number) values ('Operator', (select department_number from department where name = 'Production'));

insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'Kevin', 'Cooler', 'Male', '1989-11-21', '2010-01-01', (select job_id from job where title = 'Developer'));
insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'Andrew', 'Smith', 'Male', '1980-10-11', '2017-05-22', (select job_id from job where title = 'Developer'));
insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'Emily', 'Potts', 'Female', '1989-12-28', '2011-01-01', (select job_id from job where title = 'Automation Tester'));
insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'Bridget', 'Stephas', 'Female', '1994-3-10', '2012-01-01', (select job_id from job where title = 'Paletizer'));
insert into employee (first_name, last_name, birthday, hire_date, job_id) values(
        'Sam', 'Cooler', '1987-10-31', '2013-01-01', (select job_id from job where title = 'Driver'));
insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'David', 'Stephas', 'Male', '1963-07-25', '2014-01-01', (select job_id from job where title = 'Wrapper'));
insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'Annie', 'Odonnell', 'Female', '1963-10-04', '2015-01-01', (select job_id from job where title = 'Operator'));
insert into employee (first_name, last_name, gender, birthday, hire_date, job_id) values(
        'Jenny', 'Honerlaw', 'Female', '1990-02-22', '2009-01-01', (select job_id from job where title = 'Operator'));

insert into project (name, start_date) values ('Alpha', '2018-01-01');
insert into project (name, start_date) values ('Beta', '2018-02-01');
insert into project (name, start_date) values ('Charlie', '2018-03-01');
insert into project (name, start_date) values ('Echo', '2018-04-01');

insert into employee_project (employee_number, project_number) values (
        (select employee_number from employee where first_name = 'Kevin'), (select project_number from project where name = 'Alpha'));
insert into employee_project (employee_number, project_number) values (
        (select employee_number from employee where first_name = 'Andrew'), (select project_number from project where name = 'Beta'));
insert into employee_project (employee_number, project_number) values (
        (select employee_number from employee where first_name = 'Emily'), (select project_number from project where name = 'Charlie'));
insert into employee_project (employee_number, project_number) values (
        (select employee_number from employee where first_name = 'Jenny'), (select project_number from project where name = 'Echo'));
insert into employee_project (employee_number, project_number) values (
        (select employee_number from employee where first_name = 'Annie'), (select project_number from project where name = 'Charlie'));
insert into employee_project (employee_number, project_number) values (
        (select employee_number from employee where first_name = 'Jenny'), (select project_number from project where name = 'Alpha'));