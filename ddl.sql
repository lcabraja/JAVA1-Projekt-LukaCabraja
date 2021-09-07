USE master
GO
IF OBJECT_ID('JAVA1DB') IS NOT NULL
BEGIN
    USE master
    GO
    DROP DATABASE JAVA1DB
END
GO
CREATE DATABASE JAVA1DB
GO
-- Clearing tables
USE JAVA1DB
GO
IF OBJECT_ID('User') IS NOT NULL
BEGIN
	DROP TABLE User
END

-- Creating Tables
-----------------------------------------------------
create table Roles
(
	IDRole int identity
		constraint Roles_pk
			primary key nonclustered,
	Title nvarchar(32) not null,
	AccessLevel int not null
)
go

create unique index Roles_AccessLevel_uindex
	on Roles (AccessLevel)
go
create table Users
(
	IDUser int identity
		constraint Users_pk
			primary key nonclustered,
	Username nvarchar(32) not null,
	PasswordHash nvarchar(128) not null,
	RoleID int not null
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
	IDActor int identity
		constraint Actors_pk
			primary key nonclustered,
	PersonID int
		constraint Actors_Person_IDPerson_fk
			references Person
    AlternateName nvarchar(128)
)
go
create table Directors
(
	IDDirector int identity
		constraint Directors_pk
			primary key nonclustered,
	PersonID int
		constraint Directors_Person_IDPerson_fk
			references Person
    AlternateName nvarchar(128)
)
go
-----------------------------------------------------
create table Genres
(
	IDGenre int identity
		constraint Genres_pk
			primary key nonclustered,
    Title nvarchar(32) not null
)
go
CREATE TABLE Movie (
    IDMovie int identity
		constraint Genres_pk
			primary key nonclustered,
    Title nvarchar(256) not null,
    OriginalTitle nvarchar(256),
    DatePublished datetimeoffset,
    HTMLDescription nvarchar(4096),
    Length int,
    Genre int,
    PosterFilePath nvarchar(512),
    TrailerLink nvarchar(128)
    Link nvarchar(128),
    GUID nvarchar(128),
    StartsPlaying date
)

CREATE TABLE ActorMovie (
    MovieID int,
    ActorID
) 