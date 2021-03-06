
    alter table SANDBOX.PersonalComputer 
        drop constraint FKF7E80D9BD409F9CC;

    alter table SANDBOX.Switch 
        drop constraint FK9460A354D409F9CC;

    drop table SANDBOX.NetworkAsset;

    drop table SANDBOX.PersonalComputer;

    drop table SANDBOX.Switch;

    create table SANDBOX.NetworkAsset (
        db_id integer generated by default as identity unique,
        assetDescription varchar(255),
        ipAddress varchar(255),
        primary key (db_id)
    );

    create table SANDBOX.PersonalComputer (
        employeeName varchar(255),
        memory integer not null,
        db_id integer not null,
        primary key (db_id)
    );

    create table SANDBOX.Switch (
        manufacturerName varchar(255),
        switchIdentifier varchar(255),
        switchType varchar(255),
        db_id integer not null,
        primary key (db_id)
    );

    alter table SANDBOX.PersonalComputer 
        add constraint FKF7E80D9BD409F9CC 
        foreign key (db_id) 
        references SANDBOX.NetworkAsset;

    alter table SANDBOX.Switch 
        add constraint FK9460A354D409F9CC 
        foreign key (db_id) 
        references SANDBOX.NetworkAsset;
