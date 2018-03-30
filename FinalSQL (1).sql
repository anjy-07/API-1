create database FINAL_DB;
use FINAL_DB; 

create table OFFICE(
OFFICE_ID int NOT NULL AUTO_INCREMENT,
ADDRESS text NOT NULL,
PINCODE int NOT NULL,
DISTRICT text NOT NULL,
CITY text NOT NULL,
STATE text NOT NULL,
PRIMARY KEY(OFFICE_ID)
);

insert into OFFICE values(1, 'dwarka city center', 110088, 'dwarka', 'New Delhi', 'Delhi');
insert into OFFICE values(2, 'huda city center', 110088, 'huda', 'Gurgaon', 'Haryana');

create table OFFICER(
OID int NOT NULL AUTO_INCREMENT,
NAME text NOT NULL,
OFFICE_ID int NOT NULL,
DESIGNATION text NOT NULL,
EMAIL_ID text NOT NULL,
MOBILE int NOT NULL,
AADHAR_CARD int UNIQUE NOT NULL,
PASSWORD text NOT NULL,
TOKEN_ID text NOT NULL,
DOJ  timestamp NOT NULL,
RTD timestamp NOT NULL,
ADMIN_RIGHTS ENUM('YES', 'NO') NOT NULL DEFAULT 'NO',
FOREIGN KEY (OFFICE_ID) REFERENCES OFFICE(OFFICE_ID) ON DELETE CASCADE,
PRIMARY KEY (OID));

insert into OFFICER values(1, 'Ashima', 1, 'MoHFW', 'ashima@gmail.com', 98978, 112233, 'pass', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),  1 );
insert into OFFICER values(2, 'Anjali', 2, 'MoHFW', 'anjali@gmail.com', 989878, 878687, 'pass', 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),  2 );

create table PROGRAMME(
PID int NOT NULL AUTO_INCREMENT,
NAME text NOT NULL,
LAUNCHDATE timestamp NOT NULL,
DESCRIPTION text NOT NULL,
PRIMARY KEY(PID));

insert into PROGRAMME values(1, 'Child Care', CURRENT_TIMESTAMP(), 'For Child');
insert into PROGRAMME values(2, 'Vision 2020',CURRENT_TIMESTAMP(), 'For Blind');

create table ADDRESS(
AID int NOT NULL AUTO_INCREMENT,
ADDRESS text NOT NULL,
PINCODE int NOT NULL,
DISTRICT text NOT NULL,
CITY text NOT NULL,
STATE text NOT NULL,
PRIMARY KEY(AID)
);

insert into ADDRESS values(1, 'dwarka city center', 110088, 'dwarka', 'New Delhi', 'Delhi');
insert into ADDRESS values(2, 'huda city center', 110088, 'huda', 'Gurgaon', 'Haryana');

create table STATUS(
STATUS_ID int NOT NULL AUTO_INCREMENT,
STATUS text NOT NULL,
PRIMARY KEY(STATUS_ID)
);

insert into STATUS values(1, 'Completed');
insert into STATUS values(2, 'Under Verification');
insert into STATUS values(3, 'Request for Follow-Up');
insert into STATUS values(4, 'Pending');
insert into STATUS values(5, 'Schedule next Follow-Up');
insert into STATUS values(6, 'Not yet Started');

create table ACTION(
ACTION_ID int NOT NULL AUTO_INCREMENT,
ACTION text NOT NULL,
PRIMARY KEY(ACTION_ID)
);

insert into ACTION values(1, 'Completed');
insert into ACTION values(2, 'Pending');
insert into ACTION values(3, 'Follow-Up');

create table TASK(
TID int NOT NULL AUTO_INCREMENT,
PID int NOT NULL,
OID int NOT NULL,
AID int NOT NULL,
STATUS_ID int NOT NULL,
DESCRIPTION text NOT NULL,
SET_DATE timestamp NOT NULL,
DEADLINE timestamp NOT NULL,
VISIT_TYPE text NOT NULL,
FOREIGN KEY (PID) REFERENCES PROGRAMME(PID) ON DELETE CASCADE,
FOREIGN KEY (OID) REFERENCES OFFICER(OID) ON DELETE CASCADE,
FOREIGN KEY (AID) REFERENCES ADDRESS(AID) ON DELETE CASCADE,
FOREIGN KEY (STATUS_ID) REFERENCES STATUS(STATUS_ID) ON DELETE CASCADE,
PRIMARY KEY(TID));

insert into TASK values(1, 1, 1, 1, 6, 'For Delhi', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'District Visit');
insert into TASK values(2, 2, 2, 2, 6, 'For Gurgaon', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'Hospital Visit');

create table VISIT(
VID int NOT NULL AUTO_INCREMENT,
TID int NOT NULL,
ACTION_ID int NOT NULL,
PICTURE text,
LAT DECIMAL(10,8) NOT NULL,
LONGITUDE DECIMAL (11,8) NOT NULL,
REMARK_OFFICER text,
REMARK_ADMIN text,
FOREIGN KEY (TID) REFERENCES TASK(TID) ON DELETE CASCADE,
FOREIGN KEY (ACTION_ID) REFERENCES ACTION(ACTION_ID) ON DELETE CASCADE,
PRIMARY KEY(VID));

insert into VISIT values(1, 1, 2, 'I am a picture :P', 87.98, 98.87, 'Remark by Officer1', 'Remark by Admin1');
insert into VISIT values(2, 2, 2, 'I am a picture :P', 87.98, 98.87, 'Remark by Officer2', 'Remark by Admin2');

create table QUESTION(
QID int NOT NULL AUTO_INCREMENT,
QUESTION text NOT NULL,
DESCRIPTION text,
FORMAT text NOT NULL,
PID int NOT NULL,
VISIT_TYPE text NOT NULL,
FOREIGN KEY (PID) REFERENCES PROGRAMME(PID) ON DELETE CASCADE,
PRIMARY KEY(QID));

insert into QUESTION values(1, 'How is the work going on ?', 'Realted to work', 'TextBox', 1, 'District Visit');
insert into QUESTION values(2, 'How much work is done ?', 'Realted to work', 'TextBox', 2, 'District Visit');

create table ANSWER(
ANS_ID int NOT NULL AUTO_INCREMENT,
ANSWER text NOT NULL,
QID int NOT NULL,
VID int NOT NULL,
FOREIGN KEY (VID) REFERENCES VISIT(VID) ON DELETE CASCADE,
FOREIGN KEY (QID) REFERENCES QUESTION(QID) ON DELETE CASCADE,
PRIMARY KEY(ANS_ID));

insert into ANSWER values(1, 'good', 1, 1);
insert into ANSWER values(2, '50%', 2, 2);