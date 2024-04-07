CREATE TABLE Attendees(
    attendees_id SERIAL primary key ,
    attendees_name varchar(100) not null ,
    email varchar(250) not null
);

CREATE TABLE Event_attendees(
    id SERIAL primary key,
    event_id INT REFERENCES Event(event_id) ON DELETE CASCADE ,
    attendees_id INT REFERENCES Attendees(attendees_id) ON DELETE CASCADE
);

CREATE TABLE Event(
    event_id SERIAL PRIMARY KEY ,
    event_name varchar(50) not null ,
    event_date timestamp not null ,
    venues_id INT REFERENCES venues(venues_id) ON DELETE cascade
);

SELECT at.attendees_id,at.attendees_name,at.email FROM Attendees at
JOIN Event_attendees Ea on at.attendees_id = Ea.attendees_id
WHERE Ea.event_id=1;

CREATE TABLE Venues(
    venues_id SERIAL PRIMARY KEY ,
    venues_name varchar(100) not null ,
    location varchar(250) not null
);

SELECT * FROM Attendees;

SELECT * FROM Attendees WHERE attendees_id=1;

INSERT INTO Attendees (attendees_name, email)
VALUES ('Madina','madina@gmail.com');

UPDATE Attendees
SET attendees_name = 'Hour',email='hour@gmail.com'
WHERE attendees_id = 2;

-- INSERT INTO Event_attendees (event_id, attendees_id)
-- values (3,2);

DELETE FROM event
WHERE event_id =45;

SELECT * FROM Event;

SELECT * FROM Venues WHERE venues_id =1;

DELETE FROM event
WHERE event_id=44;

INSERT INTO Venues (venues_name, location)
VALUES ('PVH','location PVH');

UPDATE Event
SET event_name = 'KOH',event_date=now(),venues_id=6
WHERE event_id= 7;




DELETE FROM Venues
WHERE venues_id =7;


INSERT INTO Event (event_name, event_date, venues_id)
VALUES ('Big Big',now(),3)
RETURNING event_id;


INSERT INTO Event_attendees (event_id, attendees_id)
VALUES (34,5);

SELECT * FROM Event
WHERE event_id = 1;

SELECT * FROM Event
WHERE event_id = 4;

