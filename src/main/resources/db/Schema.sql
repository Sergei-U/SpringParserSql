CREATE TABLE TOPICSQLRU (
                         ID SERIAL PRIMARY KEY NOT NULL,
                         TITLE        varchar(220) NOT NULL,
                         URL          varchar(500) NOT NULL,
                         VACANCYTEXT  varchar(1000) NOT NULL,
                         DATE         varchar(200) NOT NULL
);

CREATE TABLE URLBYFIND (
                        id serial primary key not null,
                        url varchar(200) not null
);