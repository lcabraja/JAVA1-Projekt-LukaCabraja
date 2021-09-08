use JAVA1DB
go
delete
from Users
delete
from Roles
-----------------------------------------------------
delete
from MovieActor
delete
from MovieDirector
delete
from Actors
delete
from Directors
delete
from Persons
-----------------------------------------------------
delete
from Genres
delete
from Movie
go
insert into Roles
values ('Admin', 100),
       ('User', 50)
go