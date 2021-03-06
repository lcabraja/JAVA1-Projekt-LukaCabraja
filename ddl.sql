-----------------------------------------------------
-- Initializing database
-----------------------------------------------------
use master
go
drop database if exists JAVA1DB
go
create database JAVA1DB
go
-----------------------------------------------------
-- Clearing tables
-----------------------------------------------------
use JAVA1DB
drop index if exists Roles_AccessLevel_uindex on Roles
drop index if exists Users_Username_uindex on Users
drop table if exists Users
drop table if exists Roles
-----------------------------------------------------
drop table if exists MovieActor
drop table if exists MovieDirector
drop table if exists Actors
drop table if exists Directors
drop table if exists Persons
-----------------------------------------------------
drop table if exists Movie
go
-----------------------------------------------------
-- Creating Tables
-----------------------------------------------------
use JAVA1DB
create table Roles
(
    IDRole      int identity
        constraint Roles_pk
            primary key nonclustered,
    Title       nvarchar(32) not null,
    AccessLevel int          not null
)
go

create unique index Roles_AccessLevel_uindex
    on Roles (AccessLevel)
go
create table Users
(
    IDUser       int identity
        constraint Users_pk
            primary key nonclustered,
    Username     nvarchar(32)  not null,
    PasswordHash nvarchar(128) not null,
    RoleID       int           not null
        constraint Users_Roles_IDRole_fk
            references Roles
)
go

create unique index Users_Username_uindex
    on Users (Username)
go
-----------------------------------------------------
create table Persons
(
    IDPerson int identity
        constraint Person_pk
            primary key nonclustered,
    FullName nvarchar(128) not null
)
go
create table Actors
(
    IDActor       int identity
        constraint Actors_pk
            primary key nonclustered,
    PersonID      int
        constraint Actors_Person_IDPerson_fk
            references Persons,
    AlternateName nvarchar(128)
)
go
create table Directors
(
    IDDirector    int identity
        constraint Directors_pk
            primary key nonclustered,
    PersonID      int
        constraint Directors_Person_IDPerson_fk
            references Persons,
    AlternateName nvarchar(128)
)
go
-----------------------------------------------------

create table Movie
(
    IDMovie         int identity
        constraint Movie_pk
            primary key nonclustered,
    Title           nvarchar(256) not null,
    OriginalTitle   nvarchar(256),
    HTMLDescription nvarchar(4000),
    Length          int,
    Genre           nvarchar(64),
    PosterFilePath  nvarchar(512),
    TrailerLink     nvarchar(128),
    Link            nvarchar(128),
    GUID            nvarchar(128),
    StartsPlaying   date
)
go
create table MovieActor
(
    MovieID int
        constraint MovieActor_Movie_IDMovie_fk
            references Movie,
    ActorID int
        constraint MovieActor_Actors_IDActor_fk
            references Actors,
    constraint MovieActor_pk
        primary key nonclustered (MovieID, ActorID)
)
go
create table MovieDirector
(
    MovieID    int
        constraint MovieDirector_Movie_IDMovie_fk
            references Movie,
    DirectorID int
        constraint MovieDirector_Directors_IDDirector_fk
            references Directors,
    constraint MovieDirector_pk
        primary key nonclustered (MovieID, DirectorID)
)
go
-----------------------------------------------------
-- procedure creation
-----------------------------------------------------
-- admin procedures
-----------------------------------------------------
drop procedure if exists proc_create_default_user
go
create procedure proc_create_default_user
as
begin
    if not exists(select * from Roles where Title = 'Admin' or Title = 'User')
        begin
            insert into Roles
            values ('Admin', 100),
                   ('User', 50)
        end
    if not exists(select * from Users where Username = 'Admin')
        begin
            insert into Users
            values ('Admin', 'password', (select IDRole from Roles where Title = 'Admin'))
        end
end
go
drop procedure if exists proc_clear_all_data
go
create procedure proc_clear_all_data
as
begin
    delete from Users
    delete from Roles
    delete from MovieActor
    delete from MovieDirector
    delete from Actors
    delete from Directors
    delete from Persons
    delete from Movie
    exec proc_create_default_user
end
go
drop procedure if exists proc_create_user
go
create procedure proc_create_user @Username nvarchar(32),
                                  @PasswordHash nvarchar(128),
                                  @UserID int output
as
begin
    insert into Users
    values (@Username, @PasswordHash, (select top 1 IDRole from Roles where Title = 'User'))
    set @UserID = scope_identity()
end
go
drop procedure if exists proc_get_user
go
create procedure proc_get_user @Search nvarchar(128)
as
begin
    select IDUser, Username, PasswordHash, Title as Role, AccessLevel
    from Users U
             inner join Roles R2 on R2.IDRole = U.RoleID
    where Username like @Search
end
go
-----------------------------------------------------
-- CRUD movie
-----------------------------------------------------
drop procedure if exists proc_create_movie
go
create proc proc_create_movie @Title nvarchar(256),
                              @OriginalTitle nvarchar(256),
                              @HTMLDescription nvarchar(4000),
                              @Length int,
                              @Genre nvarchar(64),
                              @PosterFilePath nvarchar(512),
                              @TrailerLink nvarchar(128),
                              @Link nvarchar(128),
                              @GUID nvarchar(128),
                              @StartsPlaying date,
                              @MovieID int output
as
begin
    insert into Movie
    values (@Title, @OriginalTitle, @HTMLDescription, @Length, @Genre, @PosterFilePath, @TrailerLink,
            @Link, @GUID, @StartsPlaying)
    set @MovieID = scope_identity()
end
go
drop procedure if exists proc_read_movie
go
create proc proc_read_movie @IDMovie int
as
begin
    select IDMovie,
           Title,
           OriginalTitle,
           HTMLDescription,
           Length,
           Genre,
           PosterFilePath,
           TrailerLink,
           Link,
           GUID,
           StartsPlaying
    from Movie
    where IDMovie = @IDMovie
end
go
drop procedure if exists proc_read_movies
go
create proc proc_read_movies
as
begin
    select IDMovie,
           Title,
           OriginalTitle,
           HTMLDescription,
           Length,
           Genre,
           PosterFilePath,
           TrailerLink,
           Link,
           GUID,
           StartsPlaying
    from Movie
end
go
drop procedure if exists proc_update_movie
go
create proc proc_update_movie @IDMovie int,
                              @Title nvarchar(256),
                              @OriginalTitle nvarchar(256),
                              @HTMLDescription nvarchar(4000),
                              @Length int,
                              @Genre nvarchar(64),
                              @PosterFilePath nvarchar(512),
                              @TrailerLink nvarchar(128),
                              @Link nvarchar(128),
                              @GUID nvarchar(128),
                              @StartsPlaying date
as
begin
    update Movie
    set Title           = @Title,
        OriginalTitle   = @OriginalTitle,
        HTMLDescription = @HTMLDescription,
        Length          = @Length,
        Genre           = @Genre,
        PosterFilePath  = @PosterFilePath,
        TrailerLink     = @TrailerLink,
        Link            = @Link,
        GUID            = @GUID,
        StartsPlaying   = @StartsPlaying
    where IDMovie = @IDMovie
end
go
drop procedure if exists proc_delete_movie
go
create proc proc_delete_movie @IDMovie int
as
begin
    delete from Movie where IDMovie = @IDMovie
end
go
-----------------------------------------------------
-- CRUD actor
-----------------------------------------------------
drop procedure if exists proc_create_actor
go
create proc proc_create_actor @Name nvarchar(128),
                              @ActorID int output
as
begin
    if exists(select IDPerson
              from Persons
              where FullName = @Name)
        begin
            declare @PersonID int = (select IDPerson
                                     from Persons
                                     where FullName = @Name)
            if exists(select IDActor from Actors where PersonID = @PersonID)
                begin
                    set @ActorID = (select IDActor from Actors where PersonID = @PersonID)
                end
            else
                begin
                    insert into Actors (PersonID)
                    values (@PersonID)
                    set @ActorID = scope_identity()
                end
        end
    else
        begin

            insert into Persons
            values (@Name)
            insert into Actors (PersonID)
            values (scope_identity())
            set @ActorID = scope_identity()
        end

end
go
drop procedure if exists proc_read_actor
go
create proc proc_read_actor @IDActor int
as
begin
    select A.*, P.FullName
    from Actors A
             inner join Persons P on P.IDPerson = A.PersonID
    where IDActor = @IDActor
end
go
drop procedure if exists proc_read_actors
go
create proc proc_read_actors
as
begin
    select A.*, P.FullName
    from Persons P
             inner join Actors A on P.IDPerson = A.PersonID
end
go
drop procedure if exists proc_update_actor
go
create proc proc_update_actor @IDActor int,
                              @FullName nvarchar(128),
                              @AlternateName nvarchar(128)
as
begin
    update Persons
    set FullName = @FullName
    where IDPerson = (select PersonID from Actors where IDActor = @IDActor)
    update Actors
    set AlternateName = @AlternateName
    where IDActor = @IDActor
end
go
drop procedure if exists proc_delete_actor
go
create proc proc_delete_actor @IDActor int
as
begin
    delete
    from MovieActor
    where ActorID = @IDActor
    delete
    from Actors
    where idactor = @IDActor
end
go
-----------------------------------------------------
-- CRUD director
-----------------------------------------------------
drop procedure if exists proc_create_director
go
create proc proc_create_director @Name nvarchar(128),
                                 @DirectorID int output
as
begin
    if exists(select IDPerson
              from Persons
              where FullName = @Name)
        begin
            declare @PersonID int = (select IDPerson
                                     from Persons
                                     where FullName = @Name)
            if exists(select IDDirector from Directors where PersonID = @PersonID)
                begin
                    set @DirectorID = (select IDDirector from Directors where PersonID = @PersonID)
                end
            else
                begin
                    insert into Directors (PersonID)
                    values (@PersonID)
                    set @DirectorID = scope_identity()
                end
        end
    else
        begin

            insert into Persons
            values (@Name)
            insert into Directors (PersonID)
            values (scope_identity())
            set @DirectorID = scope_identity()
        end

end
go
drop procedure if exists proc_read_director
go
create proc proc_read_director @IDDirector int
as
begin
    select D.*, P.FullName
    from Directors D
             inner join Persons P on D.PersonID = P.IDPerson
    where IDDirector = @IDDirector
end
go
drop procedure if exists proc_read_directors
go
create proc proc_read_directors
as
begin
    select D.*, P.FullName
    from Persons P
             inner join Directors D on P.IDPerson = D.PersonID
end
go
drop procedure if exists proc_update_director
go
create proc proc_update_director @IDDirector int,
                              @FullName nvarchar(128),
                              @AlternateName nvarchar(128)
as
begin
    update Persons
    set FullName = @FullName
    where IDPerson = (select PersonID from Directors where IDDirector = @IDDirector)
    update Directors
    set AlternateName = @AlternateName
    where IDDirector = @IDDirector
end
go
drop procedure if exists proc_delete_director
go
create proc proc_delete_director @IDDirector int
as
begin
    delete
    from MovieDirector
    where DirectorID = @IDDirector
    delete
    from Directors
    where iddirector = @IDDirector
end
go
-----------------------------------------------------
-- CRUD movie - actor
-----------------------------------------------------
drop procedure if exists proc_create_movie_actor
go
create proc proc_create_movie_actor @MovieID int,
                                    @ActorID int
as
begin
    insert into MovieActor
    values (@MovieID, @ActorID)
end
go
drop procedure if exists proc_read_movie_actor
go
create proc proc_read_movie_actor @MovieID int
as
begin
    select A.*, P.FullName
    from Actors A
             inner join Persons P on P.IDPerson = A.PersonID
             inner join MovieActor MA on A.IDActor = MA.ActorID
    where MovieID = @MovieID
end
go
drop procedure if exists proc_delete_movie_actor
go
create proc proc_delete_movie_actor @MovieID int,
                                    @ActorID int
as
begin
    delete
    from MovieActor
    where MovieID = @MovieID
      and ActorID = @ActorID
end
go
-----------------------------------------------------
-- CRUD movie - director
-----------------------------------------------------
drop procedure if exists proc_create_movie_director
go
create proc proc_create_movie_director @MovieID int,
                                       @DirectorID int
as
begin
    insert into MovieDirector
    values (@MovieID, @DirectorID)
end
go
drop procedure if exists proc_read_movie_director
go
create proc proc_read_movie_director @MovieID int
as
begin
    select A.*, P.FullName
    from Directors A
             inner join Persons P on P.IDPerson = A.PersonID
             inner join MovieDirector MA on A.IDDirector = MA.DirectorID
    where MovieID = @MovieID
end
go
drop procedure if exists proc_delete_movie_director
go
create proc proc_delete_movie_director @MovieID int,
                                       @DirectorID int
as
begin
    delete
    from MovieDirector
    where MovieID = @MovieID
      and DirectorID = @DirectorID
end
go
-----------------------------------------------------
-- creating default user
-----------------------------------------------------
exec proc_create_default_user
