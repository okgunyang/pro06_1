CREATE TABLE sample(id varchar(20), pw varchar(20), vcnt bigint);

insert into sample values('abc','123',0);
insert into sample values('bcd','234',0);
insert into sample values('cde','345',0);
insert into sample values('def','456',0);

-- 이용자 테이블 구조 변경 : 비밀번호 크기 변경
alter table user1 alter COLUMN pw type varchar(300);

-- 카테고리 테이블 생성
CREATE TABLE category (
  id int GENERATED ALWAYS AS IDENTITY,
  id_parent int NOT NULL DEFAULT 0,
  title varchar(200) NOT NULL,
  icon varchar(200) NOT NULL,
  description varchar(2000) DEFAULT '',
  create_timestamp date NOT NULL DEFAULT now(),
  update_timestamp date NOT NULL DEFAULT now(),
  PRIMARY KEY (id)
);

-- 제품 테이블 생성
CREATE TABLE product (
  id int GENERATED ALWAYS AS IDENTITY,
  name varchar(500) NOT NULL,
  price int NOT NULL,
  description varchar(2000) NOT NULL,
  image_url varchar(200) NOT NULL,
  color varchar(200) NOT NULL,
  size varchar(200) NOT NULL,
  discount int NOT NULL,
  category_id int NOT NULL,
  create_timestamp date NOT NULL DEFAULT now(),
  update_timestamp date NOT NULL DEFAULT now(),
  PRIMARY KEY (id),
  CONSTRAINT product_FK FOREIGN KEY (category_id) REFERENCES category (id)
);

-- 장바구니 테이블 생성
CREATE TABLE basket (
  bid int GENERATED ALWAYS AS IDENTITY,
  username varchar(50) NOT NULL,
  product_id int NOT NULL,
  amount int NOT NULL,
  create_timestamp date NOT NULL DEFAULT now(),
  update_timestamp date NOT NULL DEFAULT now(),
  PRIMARY KEY (username),
  CONSTRAINT basket_FK FOREIGN KEY (product_id) REFERENCES product (id)
   ON DELETE CASCADE ON UPDATE CASCADE
);

-- 열거형 선언
create type statustype as ENUM ('ready','delivery','complete');

-- 판매 테이블 생성
CREATE TABLE sales (
  sid int GENERATED ALWAYS AS IDENTITY,
  username varchar(50) NOT NULL,
  product_id int NOT NULL,
  amount int not null DEFAULT 1,
  status statustype NOT NULL,
  create_timestamp date NOT NULL DEFAULT now(),
  update_timestamp date NOT NULL DEFAULT now(),
  PRIMARY KEY (sid),
  CONSTRAINT order_FK FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 댓글 테이블 생성
create table coment(idx int primary key GENERATED ALWAYS as identity,
  paragraph varchar(500) not null,
  id varchar(15) not null,					
  writer varchar(20),
  restime TIMESTAMP DEFAULT now());

-- 이용자 별점 테이블 생성
create table satis(idx int primary key GENERATED ALWAYS as identity,
  proid int not null,
  sid int not null,
  userid varchar(15) not null,
  words varchar(500) not null,
  star real DEFAULT 5.0,
  restime TIMESTAMP DEFAULT now());


-- 테이블 정보 보기
-- 해당 테이블 정보 확인
select * from information_schema.tables where table_name = 'user1';
-- 테이블 목록 확인
select * from information_schema.tables where table_schema = 'public';
-- 해당 테이블의 구조 확인
select * from information_schema.columns where table_name = 'user1';

commit;

-- 테이블 조회
select * from sample;
select * from board;
select * from user1;
select * from category;
select * from product;
select * from basket;
select * from sales;
select * from coment;
select * from satis;


