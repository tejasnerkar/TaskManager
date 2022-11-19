INSERT INTO "UserType"(UserTypeID,Code,Name)
VALUES
(1,'MNGR','Manager'),
(2,'TEAMMBR','Team Member');

INSERT INTO "StatusType"(StatusTypeID,Code,Name)
VALUES
(1,'TODO',' To Do'),
(2,'INPGRS','In Progress'),
(3,'CMPLT','Completed');


INSERT INTO "User"(UserID,UserName,UserTypeID)
VALUES
(1,'Tejas Nerkar',2),
(2,'Pavan Sharma',1),
(3,'Anusha Phaye',2),
(4,'Vishal Kumar',1),
(5,'Avesh Azad',2),
(6,'Shankar Kharade',2);



INSERT INTO "Task"(TaskID, CreatedBy, AssignedTo, StatusTypeID, Details, Comments)
VALUES(1,2,1,1,'FSSFD','AFFG');
