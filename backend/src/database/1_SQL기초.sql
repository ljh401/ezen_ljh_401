#한줄주석
# 확대축소 : ctrl + 마우스 휠
-- 한줄주석
/* 여러 줄 주석 */

/*
   데이터베이스 : 데이터[자료] , 베이스[모임] 
      - 종류
         1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. NoSQL 데이터 베이스 : Key-value 
      
        - 용어
            DBA[ 데이터베이스 관리자 ]
               - 개발자
                DBMS[ 데이터베이스 관리 시스템 ]
               - MYSQL , ORACLE(1) , MARIADB , SQLSERVER - 각 회사별 소프트웨어
                    - SQL [ 구조화된 질의 언어 ]
                DB[ 데이터베이스 ]
               - 실제 데이터가 저장된 곳 = DB SERVER
                    - 메모리[ 16진수/기계어 ] : 개발자는 직접적으로 관리 힘이 듬
                    
      - 관계
        
         DBA ---------------> DB   [x]
            개발자            기계어
            
            DBA   ---------------> DBMS   -------------> DB   [o]
            개발자            관리시스템              기계어
                        MYSQL
                        ORACLE
            
               표 만들어줘            기계어
               create
                    SQL언어 학습
            이클립스 ------------> JVM -----------------> 메모리 [o]
            개발자            번역                  
               출력해줘            기계어
               print()
               자바언어 학습
                    
      - SQL : DB 조작/관리/제어 할 때 사용되는 언어/문법 (대소문자 구분X)
         - 1. DDL   [ 데이터베이스 정의어 ]
            - 1. create      : 데이터베이스 , 테이블 , 뷰(가상테이블) 생성
               - create database db명;
                    - create table table명( 필드명 속성명 , 필드명 속성명 , 필드명 속성명 )
                    
                - 2. drop      : 데이터베이스 , 테이블 , 뷰(가상테이블) 삭제
               - drop database db명;
                    - drop database if exists db명;
                    
                - 3. alter      : 테이블 , 뷰(가상테이블) 속성 수정
                - 4. truncate    : 테이블내 데이터 초기화/삭제
                - 5. rename      : 테이블 , 뷰(가상테이블)의 이름 변경
                - 6. show      :
               - show databases;               : 데이터베이스 전체 목록보기
                    - show variables like 'datadir';   : 데이터베이스 저장소 로컬 경로 확인
            - 7. use
               - use db명   : 데이터베이스 사용 선택
            - 2. DWL   [ 데이터베이스 조작어 ]
            - 1. insert      : 테이블(표)에 레코드(행) 삽입
                - 2. select      : 테이블(표)에 레코드(행) 검색
               - select * from 테이블명   : 테이블내 모든 필드의 레코드(행) 검색[ * : 와일드카드(모든) ]
                - 3. update      : 테이블(표)에 레코드(행) 수정
                - 4. delete      : 테이블(표)에 레코드(행) 삭제
            - 3. DCL   [ 데이터베이스 제어어 ]
            - 1. grant      : 사용자 권한 부여
                - 2. revoke      : 사용자 권한 취소
            - 4. TCL   [ 트랜잭션 제어어 ]
            - 1. commit      : !! 트랜잭션[명령어 단위]  완료
                - 2. rollback   : 트랜잭션[명령어 단위] 취소
         
      - 테이블 용어 / 테이블 [ 표 ]
                (컬럼 , colum , 열 , 필드)
             |        |        |             |
            학번      학생명   전화번호         주소
                1010   김현수   010-4444-3333   안산      가로 = 행 = row = 레코드
                1011   강호동   010-3333-3333   수원      
         1. 속성=column=열=필드=속성 : 테이블[표]의 열
            학번필드 , 학생명필드 , 전화번호필드 주소필드
                
         2. 가로 = 행 = row = 레코드 : 테이블[표]의 행
            1번레코드 , 2번레코드 , 3번레코드
         
            3. 행/열로 구성된 테이블(표)를 다른 테이블(표)와 연결/관계 = 관계형 데이터베이스

   - 데이터 필드 타입 [ mysql 기준 *DBMS 조금씩 다름 ]
      (숫자) : 바이트 단위
      1.정수
         tinyint      [1]       : -128~127 
            smallint   [2]       : 약 +-3만 
         mediumint   [3]       : +-8백만정도
            int         [4]         : 약 +-21억
            bigint      [8]         : +-21억 이상
      2.실수
         float(4)       : 소수점 7자리
            double(8)      : 소수점 15자리
      3.문자
            ( 글자수 최소 1~최대255 )
         char(문자길이)      : 고정길이      char(3) -> 'ab' -> 3바이트   [ *저장할 데이터의 글자수가 정확히 정해져 있는 경우 ]
         ( 글자수 최소 1 ~ 최대65535
            varchar(문자길이)   : 가변길이      varchar(3) -> 'ab' -> 2바이트 [ *저장할 데이터의 글자수가 정확하지 않을 때 ]
      4.대용량 문자
         text (최소 1~최대65535)
            longtext ( 4G )      : 게시물 내용물 , 첨부파일 , 이미지 , 동영상 [ 4G ]
            mediumtext( 최소1 ~ 최대 1600000 )
      5.날짜
         date(날짜)         : YYYY-MM-DD
            time(시간)          : HH:MM:SS
            datetime(날짜시간)    : YYYY-MM-DD HH:MM:SS
      
      6.논리
         boolean(1)
            
      - 제약조건
         1. pk   : primary key( pk 필드명 )
            2. fk   : foreign key( fk 필드명 ) referances pk테이블명( pk 필드명 ) [ 선택 옵션 ]
            
*/
#예1 : 데이터베이스( 여러개의 테이블(표) 들이 저장 할 수 있는 공간 ) 생성
create database sqldb1;
   #create      : 생성한다.
    #database     : 데이터베이스.
    #sqldb1    : 이름정의 [ 아무거나 , 대소문자 구분X , 키워드 X ]
    # ;         : 명령어 끝마침.
      # 명령어 실행 : 해당 명령어 줄에 커서 위치한 상태에서 ctrl+엔터
        # nevigateor 새로고침
create database sqldb2;
create database sqldb3;
create database sqldb4;
create database sqldb5;

#예2 : 데이터베이스 목록 보기
show databases;

#예3 : 데이터베이스 저장된ㄹ 로컬[pc] 경로 확인
show variables like 'datadir';
   
#예4 : 데이터베이스 삭제
drop database sqldb1;
   # drop : 삭제한다.
    # database : 데이터베이스
    # sqldb1 : DB명
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

#예5 : 만약에 데이터베이스 존재했을 때 삭제 [ *만약에 데이터베이스 없을 때 삭제명령어 사용하면 오류 발생!! ]
drop database if exists sqldb1;
   # if exists : 만약에 존재하면

#예6 : 여러개의 데이터베이스 중 사용할 데이터베이스 선택
use sqldb1;
use sqldb2;

#활용1 : 데이터베이스 새롭게 생성하세요.
# 1. 데이터베이스 존재하면 삭제처리
drop database if exists test1;

# 2. 데이터베이스 생성
create database test1;

# 3. 데이터베이스 사용준비
use test1;

/* --------------- 테이블(표) 만들기 ---------------- */
# 테이블(표)는 데이터베이스 안에 저장 [ * 무슨 데이터베이스 생성할 것인지 ... use DB명; ]
# 예1 : 테이블 생성
use sqldb1; # 테이블을 생성할 데이터베이스 선택
create table member( 아이디 text , 비밀번호 text );
   # create   : 생성한다.
    # table      : 테이블
    # member   : 이름정의 [ 아무거나 , 대소문자 구분x , 키워드x ]
    # ( );      : 테이블 속성/열/필드 정의 구역
      # ( 필드명 타입 , 필드명 타입 , 필드명 타입 , 필드명 타입 ) : 테이블(표) 제목/속성/열/필드 정의
#예2 : 테이블 확인
select * from member;

# 활용 2 :
/* 
   문제1 :
      1. 웹개발 하는데 DB저장소 'sqldb1web' 이름으로 DB 생성
        2. 해당 db에 member 테이블 생성
         id( 문자열 최대 20 )
            password( 문자열 최대 10 )

*/
# 1. 만약에 생성할 이름의 DB명이 존재하면 삭제
drop database if exists sqldb1web;
# 2. DB 생성
create database sqldb1web;
# 3. DB 사용 선택
use sqldb1web;
# 4. 만약에 생성할 이름의 테이블명이 존재하면 삭제
drop table if exists member;
# 5. table 생성
create table member( id varchar(20)   , password varchar(10) );
# 6. 테이블 생성 여부 확인
select * from member;

/* 
   문제2 :
      1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
        2. 해당 db에 board 테이블 생성
          게시물번호   ( 필드명 : bno         타입 : 최대 21억정도 )
             게시물제목   ( 필드명 : btitle      타입 : 문자열 최대 100 )
             게시물내용   ( 필드명 : bcontent   타입 : 문자열 최대 6만5천 이상 )
             게시물조회수   ( 필드명 : bview      타입 : 최대 21억정도 )
            게시물작성일   ( 필드명 : bdate   타입 : 날짜/시간 )
*/
drop table if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists board;
create table board( bno int , btitle varchar(100) , bcontent longtext , bview int , bdate datetime );
select * from board;

/* 
   문제3 :
      1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
        2. 해당 db에 board 테이블 생성
          회원번호       ( 필드명 : mno      타입 : 최대 21억정도 )
             회원아이디   ( 필드명 : mid      타입 : 문자열 최대 20 )
             회원비밀번호   ( 필드명 : mpw       타입 : 문자열 최대 20 )
          게시물번호   ( 필드명 : bno      타입 : 최대 21억정도 )
             게시물제목   ( 필드명 : btitle      타입 : 문자열 최대 100 )
             게시물내용   ( 필드명 : bcontent   타입 : 문자열 최대 6만5천 이상 )
             게시물조회수   ( 필드명 : bview      타입 : 최대 21억정도 )
            게시물작성일   ( 필드명 : bdate   타입 : 날짜/시간 )
*/
# 1. 데이터베이스 생성
# 만약에 동일한 db명이 존재했을 때 생성불가능 하기 때문에 먼저 드롭
drop database if exists sqldb1web2;
create database sqldb1web2;
use sqldb1web2;
drop table if exists memberboard;
create table membeboard2board2rboard( 
   mno int , 
    mid varchar(20) ,
    mpw varchar(20) ,
    bno int , 
    btitle varchar(100) , 
    bcontent longtext , 
    bview int , 
    bdate datetime 
);
select * from memberboard;

/* 
   문제4 :
      1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 선택
        2. 해당 db에 memberboard 테이블 기준으로 2개의 테이블로 생성 [ 필드와 타입은 문제3 동일 ]
          회원번호       ( 필드명 : mno      타입 : 최대 21억정도 )
             회원아이디   ( 필드명 : mid      타입 : 문자열 최대 20 )
             회원비밀번호   ( 필드명 : mpw       타입 : 문자열 최대 20 )
          게시물번호   ( 필드명 : bno      타입 : 최대 21억정도 )
             게시물제목   ( 필드명 : btitle      타입 : 문자열 최대 100 )
             게시물내용   ( 필드명 : bcontent   타입 : 문자열 최대 6만5천 이상 )
             게시물조회수   ( 필드명 : bview      타입 : 최대 21억정도 )
         게시물작성일   ( 필드명 : bdate   타입 : 날짜/시간 )
*/

# I 기본키 : [pk]primary key : 식별키 : 테이블의 유일한 값을 가지는 필드 : 중복이 없고 null과 공백이 없는 필드

# M 외래키 : [fk]foreign key : 참조키 : PK필드와 연결된 다른 테이블의 필드 : 중복이 있다.
   # PK : 데이터의 중복이 없는 식별가능한 필드 [ 후보 : mno , mid ]
      # mno : 회원번호 [ 절대적인 식별 ] 권장o 
        # mid : 회원아이디 [ 강호동 qwe 라는 아이디로 가입 후 탈퇴하고 5년 후 asd라는 아이디로 유재석 가입 ] 권장 x
      # -번호 형태의 pk필드 권장하는 이유 : 문자열 데이터 필드보다는 메모리 효율적으로 사용 가능.
        # -테이블 1개당 PK필드 1개이상 권장 O 
   # FK : 다른 테이블에 있는 PK필드와 연결
      # 1. FK필드명은 PK필드명과 동일하게 사용 [ 권장 ]
        # 2. [필수] FK필드의 타입은 PK필드의 타입과 동일
        # 3. [ 참조하는테이블 ] 에서 FK 필드 선언 [ 1:M 관계에서 M쪽이 참조하는 테이블 1:참조당하는 테이블 ]
        
-- 예1 : 1:M 관계 / PK:FK 관계
drop database if exists sqldb2web1;
create database sqldb2web1;
use sqldb2web1;
drop table if exists memberList;
create table member2(
   mno_pk int , 
    mid varchar(20) ,
    mpw varchar(20) ,
    primary key( mno_pk )   -- 현재 테이블에서 mno라는 필드를 식별키로 사용 설정
); 
drop table if exists boardList;
create table board2(
   bno int , 
    btitle varchar(100) , 
    bcontent longtext , 
    bview int , 
    bdate datetime ,
    mno_fk int ,   -- 1. FK 필드 선언
    foreign key( mno_fk ) references member2( mno_pk )-- 2. 현재 테이블에서 mno라는 필드를 외래키로 사용
      # foreign key( mno_fk )       : 'mno_fk' 라는 필드를 FK 필드로 설정
        # references member2( mno_pk )   : FK필드를 member2 테이블의 
);

drop database if exists sqldb2sys;
create database sqldb2sys;
use sqldb2sys;

drop table if exists category;
drop table if exists product;

create table category(
	cno_pk tinyint,
    cname varchar(10),
    primary key( cno_pk )
);

create table product(
	pno int,
    pname varchar(20),
    pprice int,
    cno_fk tinyint, -- FK필드로 사용할 필드 선언 [ 연결할 PK필드명/타입과 동일하게 선언 ]
    primary key ( pno_pk ),
    foreign key( cno_fk ) references category( cno_pk)
);

# 1:M 관계 할 경우 M테이블 FK 필드 선언/설정

drop table if exists ordertable;

# jdbc와 연결할 db선언
# Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web","root","1234");
drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;
drop table if exists member;
create table member (
	mno int not null unique auto_increment,
	mid varchar(20) not null unique,
	mpw varchar(20) not null,
	mname varchar(20) not null,
	mphone varchar(13) not null unique,
	primary key(mno)
);

select * from member;

insert into member(mid,mpw,mname,mphone)values('ezen','1234','이젠','123-123-1234');

# 로그인 [ 테이블에 값 검색(select) ]
select * from member;
select mid, mpw from member; -- mid,mpw필드 레코드 검색
# 아이디와 패스워드가 일치한 레코드 검색
select mid,mpw from member where mid = '123';	# 만약에 mid필드에 '123'문자열이 있는 레코드 검색
select mid,mpw from member where mid = '234' and mpw = '234';	# 만약에 mid필드가 '234'이면서 mpw필드가 '234인 레코드 검색

/*
	1. 테이블의 필드에 해당하는 레코드 검색
		select 필드명 from 테이블명			: 해당 필드의 레코드 검색
        select 필드명, 필드명, 필드명 from 테이블 : 여러 개 필드들의 레코드 검색
        select * from 테이블명				: 모든 필드[*] 레코드 검색
	2. 필드에 조건 추가		[ where 조건절 (필드명 연산자 값) ]
		select 필드명 			from 테이블명 where 조건
        select 필드명,필드명,필드명 	from 테이블명 where 조건
        select * 				from 테이블명 where 조건
    
*/




# jdbc와 연결할 db선언
# Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web","root","1234");
drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;
drop table if exists member;
create table member (
	mno int not null unique auto_increment,
	mid varchar(20) not null unique,
	mpw varchar(20) not null,
	mname varchar(20) not null,
	mphone varchar(13) not null unique,
	primary key(mno)
);

select * from member;

insert into member(mid,mpw,mname,mphone)values('ezen','1234','이젠','123-123-1234');

# 로그인 [ 테이블에 값 검색(select) ]
select * from member;
select mid, mpw from member; -- mid,mpw필드 레코드 검색
# 아이디와 패스워드가 일치한 레코드 검색
select mid,mpw from member where mid = '123';	# 만약에 mid필드에 '123'문자열이 있는 레코드 검색
select mid,mpw from member where mid = '234' and mpw = '234';	# 만약에 mid필드가 '234'이면서 mpw필드가 '234인 레코드 검색

/*
	1. 테이블의 필드에 해당하는 레코드 검색
		select 필드명 from 테이블명			: 해당 필드의 레코드 검색
        select 필드명, 필드명, 필드명 from 테이블 : 여러 개 필드들의 레코드 검색
        select * from 테이블명				: 모든 필드[*] 레코드 검색
	2. 필드에 조건 추가		[ where 조건절 (필드명 연산자 값) ]
		select 필드명 			from 테이블명 where 조건
        select 필드명,필드명,필드명 	from 테이블명 where 조건
        select * 				from 테이블명 where 조건
    
*/

/*------------------------------------------------------------------------*/
drop database if exists sqldb5web;
create database sqldb5web;
use sqldb5web;
drop table if exists table1;
create table table1( 데이터1 int , 데이터2 varchar(100));
# CRUD :
# 1. insert [C : create] 회원가입 ,글쓰기,제품등록,주문 , 대여 등등
	# insert into 테이블명(필드명 ,필드명) values(값1, 값2)
insert into table1(데이터1,데이터2) values( 1, '유재석');
insert into table1(데이터1,데이터2) values( 2, '강호동');

# 2. select [R : reading] 로그인, 아이디/비번찾기 , 글목록, 글조회 , 제품조회 , 주문현황 등등
	# select 필드명 from 테이블명
    # select 필드명 from 테이블명 where 조건절
select * from table1;
select * from table1 where 데이터2 = '강호동';

# 3. update [U : update]
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값
    # update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 where 조건절
update table1 set 데이터1 = 3;		# 메뉴 -> edit -> Preferences - > sql editor -> safe update 체크 해제
    
# 4. delete [D : delete]
	# delete from 테이블명
    # delete from 테이블명 where 조건절


/* ------------------------------------------------------------------ */
drop database if exists sqldb6web;
create database sqldb6web;
use sqldb6web;
# 1. 회원테이블
drop table if exists member;
create table member(           				# 아이돌 그룹
	mid char(8) not null ,         			# 식별키       최대 8자리
    mname varchar(10) not null ,   			# 그룹명      최대 10자리
    mnumber int not null ,         			# 인원수      정수 +-21억정도
    maddr char(2) not null ,      		 	# 지역      최대 2자리
    mphone1 char(3) ,            			# 지역번호   최대 2자리 
    mphone2 char(8) ,            			# 전화번호    최대 8자리
    mheight smallint ,            		 	# 평균키       정수 +-3만정도
	mdebut date ,              			 	# 데뷔일       yyyy-mm-dd 
    primary key ( mid )          		 	# 제약조건 
);
# 2. 구매테이블
drop table if exists buy;
create table buy(
   bnum int auto_increment ,         	 	# 구매번호   정수    자동번호 부여 
    mid char(8),                  			# 구매자      FK 
    bpname char(6) not null ,         		# 제품명      최대 6자리 
    bgname char(4) ,                		# 분류명       최대   4자리
    bprice int not null ,            		# 가격       정수 
    bamout smallint not null ,        		# 구매수량   정수 
    primary key(bnum) ,              		# 제약조건 
    foreign key ( mid ) references member(mid) # 제약조건 
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# select문
# 1. 테이블 전체 레코드 검색 [ * 모든 필드 ]
select * from member;
select * from buy;
# 2. 테이블 전체 레코드 검색 [ 특정 필드 표시(,구분) ]
select mid from member;
select mid, mname from member;
# 3. 필드 별칭 [ 필드명 as 별칭 vs 필드명 별칭 : 별칭(별칭은 검색결과에 표시할 필드명의 별명) ]
select mid as 그룹식별명 from member;
select mid 그룹식별명 from member;
select mid 그룹식별명 from member m ;
# 4. 조건절 [ where ]
select * from member where mname = '블랙핑크';					# 1. 필드의 값[문자면 '']이 일치한 레코드 검색 
select * from member where mnumber = 4;							# 2. 필드의 값[숫자면 ]이 일치한 레코드 검색
select * from member where mheight <= 162;						# 3. 필드의 값이 이하 이면 레코드 검색
select * from member where mheight >= 165 and mheight <= 170;	# 4. 필드의 값이 이상이면서 이하면 레코드 검색
	select * from member where mheight between 165 and 170;		# 4번과 동일
select * from member where mheight >= 165 or mnumber > 6;		# 5. 필드의 값이 이상이거나 초과면 레코드 검색
select * from member where maddr = '경기' or maddr = '전남' or maddr = '경남';
	select * from member where maddr in('경기','전남','경남');
select * from member where mname = '에이핑크';
select * from member where mname like '에이%';					# 6. '에이'로 시작하는 문자 
select * from member where mname like '%핑크';					# 7. '핑크'로 끝나는 문자
select * from member where mname like '에이_';					# 8. '에이'로 시작하는 세글자 [에이?]
select * from member where mname like '_핑크';					# 9 . '핑크'로 끝나는 세글자
select * from member where mname like '%우%';					# 10. '우'가 포함된 문자
select * from member where mname like '_우_';					# 11. '우'가 두번째에 위치한 글자인 세글자 
select mname 그룹명 ,mnumber 멤버수 , 
	mnumber+10 , mnumber-10 , mnumber * 10, mnumber / 10 , mnumber div 3 , mnumber mod 3,
	mnumber * mheight
from member;													# 12. 산술연산자.

/*
	연산자
		1. 산술연산자 : +더하기 -빼기 *곱하기 /나누기  div몫  mod나머지
        2. 비교연산자 : >초과 <미만 >=이상 <=이하 =같다 !=같지않다
        3. 논리연산자 : and이면서 or이거나 not부정
        4. 기타연산자 : 
			- 동일한 필드명의 여러개 연산 나열할때.
				- between 시작값 and 끝값		: 시작값 부터 끝값 사이이면			= and 유사
				- in(값, 값, 값)				: 여러 값 중 하나라도 포함하고 있으면	= or 유사
			- 패턴 비교 검색
				like
					% : 모든 문자수를 대응
                    _ : _개수만큼 문자수 대응

*/
