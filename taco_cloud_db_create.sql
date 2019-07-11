
    create table favourite (
       id integer not null auto_increment,
        author integer not null,
        category varchar(255),
        content varchar(255),
        title varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table news (
       id integer not null auto_increment,
        author integer not null,
        category varchar(255),
        content varchar(255),
        title varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table report (
       id integer not null auto_increment,
        author varchar(255),
        headline varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id integer not null auto_increment,
        author varchar(255),
        email varchar(255),
        password varchar(255),
        role varchar(255),
        primary key (id)
    ) engine=InnoDB
