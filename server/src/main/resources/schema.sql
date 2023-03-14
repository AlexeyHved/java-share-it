CREATE TABLE IF NOT EXISTS users
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL UNIQUE
);

create table if not exists requests
(
    id           bigint generated by default as identity primary key,
    created      timestamp not null,
    description  varchar(255),
    requester_id bigint    not null references users (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS items
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    owner_id    BIGINT       NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    name        VARCHAR(20)  NOT NULL,
    description VARCHAR(255) NOT NULL,
    available   BOOLEAN      NOT NULL,
    request_id  bigint references requests (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS bookings
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    start_time TIMESTAMP,
    end_time   TIMESTAMP,
    item_id    bigint      not null references items (id) on delete cascade,
    booker_id  bigint      not null references users (id) on delete cascade,
    status     varchar(20) not null
);

create table if not exists comments
(
    id        bigint generated by default as identity primary key,
    created   timestamp,
    text      varchar(255) not null,
    author_id bigint       not null references users (id) on delete cascade,
    item_id   bigint       not null references items (id) on delete cascade
);
