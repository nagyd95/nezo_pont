
insert into movie(id,age_limit,end,imdb,start,img_path,title,date) values (5,12,13,3.4,13, 'path','cim' ,'2019-04-03');
insert into movie(id,age_limit,end,imdb,start,img_path,title,date) values (1,18,13,3.4,13, 'path','cim' ,'2019-03-20');
insert into movie(id,age_limit,end,imdb,start,img_path,title,date) values (2,12,13,3.4,13, 'path','cim' ,'2019-03-19');
insert into movie(id,age_limit,end,imdb,start,img_path,title,date) values (3,12,13,3.4,13, 'path','cim' ,'2019-03-18');
insert into movie(id,age_limit,end,imdb,start,img_path,title,date) values (4,12,13,3.4,13, 'path','Nagyon jo' ,'2019-03-17');


insert into CATEGORY values (1,'Akció');
insert into CATEGORY values (2,'Családi');
insert into CATEGORY values (3,'Vigjáték');
insert into CATEGORY values (4,'Kaland');
insert into CATEGORY values (5,'Horror');
insert into CATEGORY values (6,'Krimi');
insert into MOVIE_CATEGORIES  (MOVIE_ID , CATEGORIES_ID ) values (1, 3);
insert into MOVIE_CATEGORIES  (MOVIE_ID , CATEGORIES_ID ) values (1, 2);
insert into MOVIE_CATEGORIES  (MOVIE_ID , CATEGORIES_ID ) values (1, 6);
INSERT INTO ROLE (id, name)
values (1, 'ADMIN');

INSERT INTO ROLE (id, name)
values (2, 'USER');

insert into users values(1,'admin','admin','admin@admin.com','admin' );


