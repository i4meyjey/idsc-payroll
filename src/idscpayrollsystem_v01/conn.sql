CREATE TABLE employee_information (
    emp_id primary key auto_increment,
    fullname varchar(70),
    gender varchar(10),
    dob date,
    blood_group varchar(3),
    marital_stat varchar(20),
    email varchar(300),
    contact varchar(50),
    emergency_con varchar(50),
    contact_prsn varchar(70),
    address varchar(100),
    house_no varchar(20),
    post_code varchar(50),
    department varchar(100),
    date_hired date,
    status varchar(15),
    bank_name varchar(150),
    acc_no varchar(100),
    bank_branch varchar(150),
    image blob;
);

CREATE TABLE attendance (
att_id int primary key auto_increment,
emp_id int,
foreign key(emp_id) references employee_informations(emp_id)
);

CREATE TABLE users (
id int primary key auto_increment,
username varchar(20),
password varchar(30),
division varchar(50),
emp_id int,
foreign key(emp_id) references employee_informations(emp_id)
);

INSERT INTO department_information (dept_id, department, monthlyRate, daysperMonth, dailyRate, hoursperDay, hourlyRate, shift, time_in, time_out) VALUES 
(101, 'Academic', 55000, 22, 2500, 8, 312, 'Regular Day Shift', '08:00:00', '16:00:00'),
(102, 'Administrative', 60000, 22, 2727, 8, 340, 'Regular Day Shift', '08:00:00', '16:00:00'),
(103, 'Library', 50000, 22, 2272, 8, 284, 'Regular Day Shift', '08:00:00', '16:00:00'),
(104, 'Support Services', 45000, 22, 2045, 8, 255, 'Regular Day Shift', '08:00:00', '16:00:00');
