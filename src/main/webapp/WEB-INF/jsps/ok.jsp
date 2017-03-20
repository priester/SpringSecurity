<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
drop table tb_dept;
create table tb_dept (
deptid int,
dname varchar(30),
constraint PK_TB_DEPT primary key (deptid) 
);

drop table tb_emp;
create table tb_emp (
empId int,
job varchar(30), 
hiredate date,
sal number(10,2),
comn number(10,2),
deptid int,
username varchar(20)
constraint PK_TB_EMP primary key (empid)
);

alter table tb_emp
   add constraint FK_TB_EMP_DEPTID foreign key(deptid) 
   references tb_dept(deptid);

insert into tb_dept(deptid,dname)
	values(1,'管理部门');
insert into tb_dept(deptid,dname)
	values(2,'系统管理员');
insert into tb_dept(deptid,dname)
	values(3,'人事部门');
insert into tb_dept(deptid,dname)
	values(4,'销售部门');
insert into tb_dept(deptid,dname)
	values(5,'工作部门');

drop table emp_message;
create table emp_message(
empId int,
name varchar(10),
idCard varchar(20),
age varchar(2),
sex varchar(2),
addr varchar(50),
specialty varchar(20),
job varchar(10),
studyeffort varchar(10),
school varchar(20),
tel varchar(20),
email varchar(20),
qq varchar(10),
note varchar(100),
PRIMARY KEY (empId)
);
drop SEQUENCE empM_sequence; 
CREATE SEQUENCE empM_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER EMPMES
BEFORE INSERT ON  emp_message
FOR EACH ROW 
BEGIN 
SELECT empM_sequence.nextval INTO :new.empId  FROM dual;
END; 

drop table emp_salary;
create table emp_salary(
empId int,
year int,
mon int,
basic number (10,2),
overtime int,
leavetime int,
comn number(10,2),
scot number(9,2),
safest number(8,2),
pulishment number(7,2),
granttime varchar(20),
PRIMARY KEY (empId ,year,mon)
);


drop table bs_worktime;
create table bs_worktime(
empId int,
datetime date, 
wktime varchar(20),
offtime varchar(20)
);


INSERT INTO bs_worktime VALUES('1',to_timestamp('2016-5-1 8:30:00', 'yyyy-mm-dd hh24:mi:ss'),to_timestamp('2013-5-1 18:30:00', 'yyyy-mm-dd hh24:mi:ss'));
select * from bs_worktime where wktime>= to_date ('2016-5-2','yyyy-mm-dd') and empId = 2;


drop TABLE bs_resources;
CREATE TABLE bs_resources (
  rescId int,
  rescName varchar(50) ,
  parentId int,
  rescKey varchar(50) ,
  type varchar(10) ,
  resUrl varchar(200) ,
  description varchar(200) ,
  PRIMARY KEY (rescId)
) ;

delete from bs_resources where rescId = '1';
delete from bs_resources where rescId = '2';
INSERT INTO bs_resources VALUES ('1', '管理员访问', '1010','sys_admin', '0', '/mainn/admin','管理员界面');
INSERT INTO bs_resources VALUES ('2', '普通用户访问', '1', 'sys_user', '1', '/main/commom','普通用户界面');
INSERT INTO bs_resources VALUES ('3', '普通用户访问', '1', 'sys_admin_test', '1', 'index','普通用户界面');
INSERT INTO bs_resources VALUES ('4', '管理员访问', '1010','sys_user_query', '0', '/user/list','管理员界面');


drop TABLE bs_role;
CREATE TABLE bs_role (
  roleId int NOT NULL,
  roleName varchar(50) ,
  roleKey varchar(50) ,
  description varchar(200),
  PRIMARY KEY (roleId)
) ;
drop SEQUENCE bsrl_sequence; 
CREATE SEQUENCE bsrl_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER BSROLE
BEFORE INSERT ON  bs_role
FOR EACH ROW 
BEGIN 
SELECT bsrl_sequence.nextval INTO :new.roleId  FROM dual;
END; 
INSERT INTO bs_role (roleName,rolekey,description)VALUES ('管理员', 'ROLE_ADMIN', '系统管理员');
INSERT INTO bs_role (roleName,rolekey,description)VALUES ('普通用户', 'ROLE_USER', '普通用户');



drop TABLE bs_user;
CREATE TABLE bs_user (
  userId int,
  userName varchar(20),
  password varchar(40),
  crDate varchar(20),
  roleId int,
  PRIMARY KEY (userId)
);
drop SEQUENCE bsus_sequence; 
CREATE SEQUENCE bsus_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER BSUser
BEFORE INSERT ON  bs_user
FOR EACH ROW 
BEGIN 
SELECT bsus_sequence.nextval INTO :new.userId  FROM dual;
END; 
INSERT INTO bs_user (userName,password,crDate,roleId)Values（'admin','admin','2016-04-22','1');
INSERT INTO bs_user (userName,password,crDate,roleId)VALUES （'user','user','2016-04-22','2'）;

select userId,userName,,password,roleName from 
drop table bs_resources_role;
CREATE TABLE bs_resources_role (
roleId int ,  
rescId int ,
PRIMARY KEY (rescId,roleId)
) ; 
INSERT INTO　bs_resources_role VALUES('1','1');
INSERT INTO　bs_resources_role VALUES('1','2');
INSERT INTO　bs_resources_role VALUES('1','3');
INSERT INTO　bs_resources_role VALUES('1','4');

INSERT INTO　bs_resources_role VALUES('2','2');


SELECT rescKey
	FROM bs_resources WHERE rescId in(
		SELECT rescId FROM
			bs_resources_role WHERE roleId in(
				SELECT roleId FROM bs_user_role
				WHERE userId=1))
drop table bs_login;
CREATE TABLE bs_login (
 loginId int,
 userName varchar(10), 
 loginTime varchar(30),
 loginIP varchar(30),
 PRIMARY KEY (loginId)
)
drop SEQUENCE bslg_sequence; 
CREATE SEQUENCE bslg_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER BeforeTestLogin
BEFORE INSERT ON  bs_login
FOR EACH ROW 
BEGIN 
SELECT bslg_sequence.nextval INTO :new.loginId  FROM dual; 
END; 
 


INSERT INTO bs_login (userName,loginTime,loginIP)VALUES ('user', '2016-4-05 20:36:55', '127.0.0.1');


CREATE TABLE bs_log (
  loginId int,
  username varchar(30),
  module varchar(30),
  action varchar(30) ,
  actionTime varchar(30),
  userIP varchar(30),
  operTime timestamp,
  PRIMARY KEY (loginId)
)


drop TABLE bs_resources;
CREATE TABLE bs_resources (
  rescId int,
  rescName varchar(50) ,
  rescKey varchar(50) ,
  type varchar(10) ,
  resUrl varchar(200) ,
  description varchar(200) ,
  PRIMARY KEY (rescId)
) ;
drop SEQUENCE bsresc_sequence; 
CREATE SEQUENCE bsresc_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER BeforeTestResc
BEFORE INSERT ON  bs_resources
FOR EACH ROW 
BEGIN 
SELECT bsresc_sequence.nextval INTO :new.rescId  FROM dual; 
END; 

delete from bs_resources where rescId = '1';
delete from bs_resources where rescId = '2';
INSERT INTO bs_resources (rescName,rescKey,resUrl,description) VALUES ('管理员访问', 'sys_admin','/main/admin','管理员界面');
INSERT INTO bs_resources (rescName,rescKey,resUrl,description) VALUES ('普通用户访问', 'sys_user','/main/commom','普通用户界面');
INSERT INTO bs_resources (rescName,rescKey,resUrl,description) VALUES ('普通用户访问', 'sys_admin_test','index','普通用户界面');




当前时间减去7分钟的时间
select sysdate,sysdate - interval '7' MINUTE from dual
当前时间减去7小时的时间
select sysdate - interval '7' hour from dual
当前时间减去7天的时间
select sysdate - interval ’7’ day from dual
当前时间减去7月的时间
select sysdate,sysdate - interval '7' month from dual
当前时间减去7年的时间
select sysdate,sysdate - interval '7' year from dual
时间间隔乘以一个数字
select sysdate,sysdate - 8*interval '7' hour from dual

drop table bs_fmes;
create table bs_fmes(
mesId int,
name varchar(10),
title varchar(50),
message varchar(400),
time varchar(20),
acttime varchar(20),
praise int,
primary key(mesId)
);

drop SEQUENCE bsfm_sequence; 
CREATE SEQUENCE bsfm_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER bs_fmes
BEFORE INSERT ON  bs_fmes
FOR EACH ROW 
BEGIN 
SELECT bsfm_sequence.nextval INTO :new.mesId FROM dual; 
END; 

drop table bs_comm;
create table bs_comm(
cmId int,
mesId int,
cmmes varchar(200),
name varchar(10),
time varchar(20),
primary key(cmId)
);

drop SEQUENCE bscm_sequence; 
CREATE SEQUENCE bscm_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 

CREATE OR REPLACE TRIGGER bs_comm
BEFORE INSERT ON  bs_comm
FOR EACH ROW 
BEGIN 
SELECT bscm_sequence.nextval INTO :new.cmId FROM dual; 
END;

drop table bs_disp;
create table bs_disp(
dispId int,
cmId int,
byname varchar(10),
toname varchar(10),
time varchar(20),
primary key(dispId)
);
drop SEQUENCE bsdp_sequence; 
CREATE SEQUENCE bsdp_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 
CREATE OR REPLACE TRIGGER bs_disp
BEFORE INSERT ON  bs_disp
FOR EACH ROW 
BEGIN 
SELECT bsdp_sequence.nextval INTO :new.dispId FROM dual; 
END;

create table bs_message(
mId int,
message varchar(200),
byname varchar(20),
toname varchar(20),
time varchar(20),
mark int,
primary key(mId)
);
drop SEQUENCE bsmsg_sequence; 
CREATE SEQUENCE bsmsg_sequence 
increment by 1   
start with 1       
nomaxvalue     
minvalue 1       
NOCYCLE; 
CREATE OR REPLACE TRIGGER bs_msg
BEFORE INSERT ON  bs_message
FOR EACH ROW 
BEGIN 
SELECT bsmsg_sequence.nextval INTO :new.mId FROM dual; 
END;

</body>
</html>