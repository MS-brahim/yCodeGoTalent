CREATE DATABASE IF NOT EXISTS yc_goTalent;

CREATE TABLE IF NOT EXISTS users(
    id 			BIGINT PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    email       VARCHAR(50) NOT NULL,
    phone       VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS administrator(
    id_user     BIGINT,
    password    VARCHAR(50) NOT NULL,

    PRIMARY KEY (id_user),
    FOREIGN KEY (id_user) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS category (
    id 			BIGINT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS participation(
    id_user 		  BIGINT,
    id_category       BIGINT,
    description       VARCHAR(50) NOT NULL,
    show_start_time   DATETIME,
    show_end_time     DATETIME,
    attached_file     VARCHAR(100),
    is_accepted       BOOLEAN,

    PRIMARY KEY (id_user,id_category),
    FOREIGN KEY (id_user) REFERENCES users (id),
    FOREIGN KEY (id_category) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS adminSession(
    id 			       BIGINT,
    id_administrator   BIGINT,
    is_connected       BOOLEAN,

    PRIMARY KEY (id),
    FOREIGN KEY (id_administrator) REFERENCES administrator (id_user)
)