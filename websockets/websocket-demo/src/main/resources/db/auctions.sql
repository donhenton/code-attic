-- create  schema demo;
set schema auctions;


alter table auction_bids drop constraint FK_ITEMS;
alter table auction_bids drop constraint FK_BIDDERS;

drop table auction_items;
drop table auction_bids;
drop table bidders;
--drop table dbmaintain_scripts;

CREATE  TABLE AUCTION_ITEMS (
        id integer generated by default as identity,
        auction_description VARCHAR(255),
        starting_bid  FLOAT,
         primary key (id)
    );

CREATE  TABLE auction_bids (
        id integer generated by default as identity,
        auction_item_id INT,
        bidder_id INT,
         primary key (id)
    );

 
CREATE  TABLE bidders (
        id integer generated by default as identity,
        user_name VARCHAR(255),
        password VARCHAR(255),
         primary key (id)
    );
 

alter table auction_bids 
        add constraint FK_ITEMS 
        foreign key (auction_item_id) 
        references auction_items ;
alter table auction_bids 
 add constraint FK_BIDDERS
        foreign key (bidder_id) 
        references bidders;
 
insert into bidders (user_name,password) values ('admin', md5('admin'));