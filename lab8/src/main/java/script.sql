drop table movies;
drop table genres;

create table movies(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    tutorial_author VARCHAR(40) NOT NULL,
    release_date DATE NOT NULL,
    duration INT(100),
    score INT(1000),
    PRIMARY KEY ( id )
);

create table genres(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    PRIMARY KEY ( id )
);

