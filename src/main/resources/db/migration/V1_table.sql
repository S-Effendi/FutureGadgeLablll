CREATE TABLE Ticket(

tikcetId int generated BY DEFAULT AS identity PRIMARY KEY,
entryTime timestamp DEFAULT current_timestamp NOT NULL,
exitTime timestamp,
fee float.

);