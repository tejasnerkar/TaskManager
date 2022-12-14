CREATE TABLE "UserType"(
UserTypeID INT PRIMARY KEY NOT NULL,
Code VARCHAR(20) NOT NULL,
Name VARCHAR(20)
)

CREATE TABLE "StatusType"(
StatusTypeID INT PRIMARY KEY NOT NULL,
Code VARCHAR(20) NOT NULL,
Name VARCHAR(20)
)


CREATE TABLE "User"(
UserID INT PRIMARY KEY NOT NULL,
UserName VARCHAR(20) NOT NULL,
UserTypeID INT
)

CREATE TABLE "Task"(
TaskID INT PRIMARY KEY NOT NULL,
CreatedBy INT NOT NULL,
AssignedTo INT NOT NULL,
StatusTypeID INT NOT NULL,
Details VARCHAR(100),
Comments VARCHAR(100)
)


ALTER TABLE "User"
ADD FOREIGN KEY (UserTypeID) 
REFERENCES "UserType"(UserTypeID)

ALTER TABLE "Task"
ADD FOREIGN KEY (CreatedBy) 
REFERENCES "User"(UserID);

ALTER TABLE "Task"
ADD FOREIGN KEY (AssignedTo) 
REFERENCES "User"(UserID);

ALTER TABLE "Task"
ADD FOREIGN KEY (StatusTypeID) 
REFERENCES "StatusType"(StatusTypeID);





