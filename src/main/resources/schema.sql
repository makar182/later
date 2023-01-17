create table users
(
    id                long     not null,
    name              varchar2 not null,
    email             varchar2,
    registration_date varchar2 not null,
    constraint pk_users_id
        primary key (id)
);

create table items
(
    id      long not null,
    user_id long not null,
    url     varchar2,
    constraint pk_items_id
        primary key (id),
    constraint fk_items_users_id
        foreign key (user_id) references users (id)
);