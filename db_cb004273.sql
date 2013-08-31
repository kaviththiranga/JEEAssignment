create table AircraftCB004273(
aircraftid varchar(10) constraint pk_aircraftid primary key,
manufacturer VARCHAR(20),
details varchar(20),
capacity numeric(3));

create table FlightCB004273(
flightno varchar(10) constraint pk_flightno primary key,
aircraftid VARCHAR(10),
deptairport varchar(20),
arrairport varchar(20),
depdate date,
arrdate date,
capacity numeric(3),
CONSTRAINT fk_aircraftid FOREIGN KEY (aircraftid) REFERENCES AircraftCB004273(aircraftid));

create table PassengerCB004273(
passengerid varchar(10) constraint pk_passengerid primary key,
fname VARCHAR(20),
lname varchar(20));

create table BookingCB004273(
bookingno varchar(10) constraint pk_bookingno primary key,
flightno VARCHAR(10),
passengerid VARCHAR(10),
CONSTRAINT fk_flightno FOREIGN KEY (flightno) REFERENCES FlightCB004273(flightno),
CONSTRAINT fk_passengerid FOREIGN KEY (passengerid) REFERENCES PassengerCB004273(passengerid));