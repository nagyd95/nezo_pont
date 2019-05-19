
insert into Tv_Chanels(name) values ('RTL');
insert into Tv_Chanels(name) values ('TV2');
insert into Tv_Chanels(name) values ('M1');
insert into Tv_Chanels(name) values ('FILM+');



insert into movie(age_limit,hossz,imdb,start,img_path,title,date,tvchanel) values (12,2,6.2,16, 'path','Horrora akadva' ,'2019-04-03',1);
insert into movie(age_limit,hossz,imdb,start,img_path,title,date,tvchanel) values (18,2,4.4,18, 'path','Tapló telapó' ,'2019-03-20',2);
insert into movie(age_limit,hossz,imdb,start,img_path,title,date,tvchanel) values (12,2,5.7,20, 'path','Dirty Dancing' ,'2019-03-19',2);
insert into movie(age_limit,hossz,imdb,start,img_path,title,date,tvchanel) values (12,1,1.9,18, 'path','Hirado','2019-05-20',1);
insert into movie(age_limit,hossz,imdb,start,img_path,title,date,tvchanel) values (12,3,8.8,19, 'path','Karib-tenger kalózai: Salazar bosszúja' ,'2019-05-20',1);
insert into movie(age_limit,hossz,imdb,start,img_path,title,date,tvchanel) values (12,2,8.8,22, 'path','A függetlenség napja' ,'2019-05-20',1);



insert into CATEGORY values (1,'Akció');
insert into CATEGORY values (2,'Családi');
insert into CATEGORY values (3,'Vigjáték');
insert into CATEGORY values (4,'Kaland');
insert into CATEGORY values (5,'Horror');
insert into CATEGORY values (6,'Krimi');



insert into MOVIE_CATEGORIES values (1,1);
insert into MOVIE_CATEGORIES values (1,5);
insert into MOVIE_CATEGORIES values (2,2);
insert into MOVIE_CATEGORIES values (2,3);
insert into MOVIE_CATEGORIES values (3,2);
insert into MOVIE_CATEGORIES values (4,2);
insert into MOVIE_CATEGORIES values (5,2);
insert into MOVIE_CATEGORIES values (5,1);
insert into MOVIE_CATEGORIES values (6,2);
insert into MOVIE_CATEGORIES values (6,1);





INSERT INTO ROLE (id, name)
values (1, 'ADMIN');

INSERT INTO ROLE (id, name)
values (2, 'USER');

insert into users values(1,'admin','admin','admin@admin.com','admin' );


