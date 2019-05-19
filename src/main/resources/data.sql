
insert into Tv_Chanels(name) values ('RTL');
insert into Tv_Chanels(name) values ('TV2');
insert into Tv_Chanels(name) values ('M1');
insert into Tv_Chanels(name) values ('FILM+');



insert into movie(id,age_limit,end,imdb,start,img_path,title,date,tvchanel) values (5,12,13,2.2,13, 'path','Horrora akadva' ,'2019-04-03',1);
insert into movie(id,age_limit,end,imdb,start,img_path,title,date,tvchanel) values (1,18,13,4.4,13, 'path','Taplo telapo' ,'2019-03-20',2);
insert into movie(id,age_limit,end,imdb,start,img_path,title,date,tvchanel) values (2,12,13,5.7,13, 'path','Dirty Dancing' ,'2019-03-19',2);
insert into movie(id,age_limit,end,imdb,start,img_path,title,date,tvchanel) values (3,12,13,1.9,13, 'path','Hirado','2019-03-18',1);
insert into movie(id,age_limit,end,imdb,start,img_path,title,date,tvchanel) values (4,12,13,2.8,13, 'path','Nagyon jo' ,'2019-03-17',1);


insert into CATEGORY values (1,'Akció');
insert into CATEGORY values (2,'Családi');
insert into CATEGORY values (3,'Vigjáték');
insert into CATEGORY values (4,'Kaland');
insert into CATEGORY values (5,'Horror');
insert into CATEGORY values (6,'Krimi');



insert into MOVIE_CATEGORIES values (1,1);
insert into MOVIE_CATEGORIES values (1,2);
insert into MOVIE_CATEGORIES values (2,3);
insert into MOVIE_CATEGORIES values (3,6);
insert into MOVIE_CATEGORIES values (4,5);
insert into MOVIE_CATEGORIES values (5,1);
insert into MOVIE_CATEGORIES values (5,4);
insert into MOVIE_CATEGORIES values (5,3);




INSERT INTO ROLE (id, name)
values (1, 'ADMIN');

INSERT INTO ROLE (id, name)
values (2, 'USER');

insert into users values(1,'admin','admin','admin@admin.com','admin' );


