--DDL - Data Definition Language
--CREATE TABLE
--DROP TABLE




--ALTER TABLE
CREATE TABLE employee
(
        employee_id SERIAL NOT NULL PRIMARY KEY
        ,department_id INTEGER NOT NULL
        ,job_title VARCHAR(80)
        ,first_name VARCHAR(80)
        ,last_name VARCHAR(80)
        ,gender CHAR(1)
        ,date_of_birth VARCHAR(20)
        ,hire_date VARCHAR(20)
        
);

CREATE TABLE project_employee
(
        project_id INTEGER NOT NULL 
        ,employee_id INTEGER NOT NULL
        
        ,PRIMARY KEY (
                project_id
                ,employee_id
                )
);

CREATE TABLE project
(
        project_id SERIAL NOT NULL PRIMARY KEY
        ,project_name VARCHAR(80)
        ,start_date DATE
        ,number_of_employees INTEGER
);

CREATE TABLE department
(
        department_id SERIAL NOT NULL PRIMARY KEY
        ,department_name VARCHAR(80)
        ,dept_number_of_employees INTEGER
);


-- add relationships
ALTER TABLE employee
ADD CONSTRAINT fk_department_employee
FOREIGN KEY (department_id)
REFERENCES department (department_id);

ALTER TABLE project_employee
ADD CONSTRAINT fk_employee_project_employee
FOREIGN KEY (employee_id)
REFERENCES employee (employee_id);

ALTER TABLE project_employee
ADD CONSTRAINT fk_project_employee_project
FOREIGN KEY (project_id)
REFERENCES project (project_id);


--insert data into tables


INSERT INTO department
(
        department_name
        ,dept_number_of_employees
)
VALUES
        ('Human Resources',2)
        ,('Payroll',2)
        ,('Maintenace',3);
        
--SELECT *
--FROM department;
        




INSERT INTO employee
(
        department_id
        ,job_title
        ,first_name
        ,last_name
        ,gender
        ,date_of_birth
        ,hire_date
)
VALUES
        (2,'Payroll Clerk','Money','Man','M','01/01/1965','03/02/1990')
        ,(2,'Payroll Manager','Black','Jack','M','03/01/1940','02/02/1986')
        ,(1,'HR Specialist','Plenty','Work','F','04/09/1972','03/02/2020')
        ,(1,'HR Manager','Guy','Idle','M','01/01/1990','01/02/2021')
        ,(3,'Janitor','Ralph','Clean','M','01/24/1975','02/02/1999')
        ,(3,'House Supervisor','Suzy','Clorox','F','03/01/1965','03/17/2016')
        ,(3,'Janitor','Spit','Shine','F','01/01/1960','03/02/1990')
        ,(2,'Payroll Clerk','Get','Paid','M','12/01/1995','03/02/2019');
        
        
--SELECT *
--FROM employee;

INSERT INTO project
(
         project_name
        ,start_date
        ,number_of_employees
)
VALUES
        ('Payroll Automation', '2020-09-06',1)
        ,('New Cleaning Equipment', '2017-01-01',1)
        ,('HR Website Go Live','2019-02-14',1)
        ,('HR Cleanup','2020-03-14',2);
        
--SELECT *
--FROM project;

INSERT INTO project_employee
(
        project_id
        ,employee_id
)
VALUES
        (1,2)
        ,(2,7)
        ,(3,3)
        ,(4,5)
        ,(4,6);

--select*
--from project_employee;