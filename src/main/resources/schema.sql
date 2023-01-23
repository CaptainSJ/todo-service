create table todo (
    id int not null,
    user_id int not null ,
    title varchar(100),
    completed boolean,
    version int
);