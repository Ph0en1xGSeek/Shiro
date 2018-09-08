create table user(
    id int(11) not null auto_increment,
    name varchar(30) not null unique,
    password varchar(50) not null,
    primary key(id)
);

create table role(
    id int(11) not null auto_increment,
    name varchar(30) not null unique,
    primary key(id)
);

create table permission(
    id int(11) not null auto_increment,
    name varchar(30) not null unique,
    primary key(id)
);

create table user_role(
    user_id int(11),
    role_id int(11),
    foreign key(user_id) references user(id) on delete cascade,
    foreign key(role_id) references role(id) on delete cascade
);

create table role_permission(
    role_id int(11),
    permission_id int(11),
    foreign key(role_id) references role(id) on delete cascade,
    foreign key(permission_id) references permission(id) on delete cascade
);

insert into role(name) value('user');
insert into role(name) value('admin');

insert into permission(name) value('read');
insert into permission(name) value('write');

insert into role_permission(role_id, permission_id) value(1, 1);
insert into role_permission(role_id, permission_id) value(2, 1);
insert into role_permission(role_id, permission_id) value(2, 2);

insert into user_role value(1, 1);
insert into user_role value(2, 2);

