drop table child;
drop table parent;


CREATE TABLE PARENT (
    ID integer generated by default as identity,
    NAME varchar(50) not null ,
    primary key (ID)    
);

CREATE TABLE CHILD (
    ID integer generated by default as identity,
    CHILD_NAME varchar(50) not null,
    PARENT_ID integer,
    primary key (ID),
    CONSTRAINT FK_CHILD_TYPE FOREIGN KEY (PARENT_ID) REFERENCES PARENT(ID)
);

 