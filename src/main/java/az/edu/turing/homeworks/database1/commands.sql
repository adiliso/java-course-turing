
create database practice;

create table users
(
    id                    serial primary key,
    name                  varchar(30)  not null,
    surname               varchar(30)  not null,
    email                 varchar(255) not null CHECK (email LIKE '%_@_%._%'),
    password              varchar(100) not null,
    birthdate             date,
    registration_datetime timestamp(5) default now(),
    last_login            timestamp(6) default now()

);

create table posts
(
    id            serial primary key,
    image_url     varchar(255)              not null,
    title         varchar(255)              not null,
    content       text,
    author_id     int references users (id) not null,
    comment_count int       default 0,
    like_count    int       default 0,
    view_count    int       default 0,
    created_at    timestamp default now(),
    updated_at    timestamp default now()
);

create table comments
(
    id          serial primary key,
    content     text                      not null,
    post_id     int references posts (id) not null,
    like_count  int       default 0,
    reply_count int       default 0,
    created_at  timestamp default now(),
    updated_at  timestamp default now()
);

insert into users (name, surname, email, password, birthdate)
VALUES ('Adil', 'Ismayilov', 'aismayilov@gmail.com', '1234', '2005-07-09');

insert into posts(image_url, title, author_id)
values ('image.png', 'abc', 1);

insert into comments(content, post_id)
values ('This post is special.', 1);

select *
from users;

select *
from posts;

select *
from comments;