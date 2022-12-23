-- 데이터베이스 생성
create database myshop;

-- 테스트 테이블 생성
create table test(num int primary key generated always as identity,name varchar(20) unique not null, birth date default current_date);

-- 테스트 테이블 더미 데이터 추가
insert into test(name) values ('kim');
insert into test(name) values ('lee');
insert into test(name) values ('park');
insert into test(name) values ('kang');

select * from test;
update test set birth='1979-12-25' where name='kim';
update test set birth='1997-08-12' where name='lee';
delete from test where name='park';
create table test2(id varchar(10));
insert into test2 values ('kim');
select * from test2;
drop table test2;

-- 테이블 목록 보기
select * from pg_catalog.pg_tables;

-- 공지사항 테이블 생성
create table board(idx int primary key GENERATED ALWAYS as identity,
  subject varchar(100) not null,
  content varchar(500) not null,
  writer varchar(20) not null,
  resdate date DEFAULT now());
  
-- 공지사항 테이블 더미 데이터 추가
insert into board values (default,'제목1','예시글 1입니다.','관리자',default);
insert into board values (default,'글제목2','예시글 2의 내용입니다.','김기태',default);
insert into board values (default,'글의 제목3','예시글 3의 안효준 글 내용입니다.','안효준',default);
insert into board values (default,'글4','샘플글 4의 내용입니다.','강병수',default);
insert into board values (default,'글의 제목5','더미글 5의 콘텐츠입니다.','조민재',default);
insert into board values (default,'글제목6','아무나 글 6의 글 내용입니다.','정병진',default);

-- 사용자 테이블 생성
create table user1(idm int GENERATED ALWAYS as identity,
  id varchar(15) primary key, pw varchar(15),
  name varchar(30), email varchar(40),
  regdate date default current_date);

alter table user1 alter COLUMN pw TYPE varchar(300);

-- 사용자 더미 데이터 추가
insert into user1 values(default, 'kkt', '1234', '김기태', 'kkt@naver.com', default);

select * from user1;

update user1 set pw='EjirwAY9zs5/2VfMRE9fyA==' where id='kkt';

commit;




