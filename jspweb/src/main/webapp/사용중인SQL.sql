drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists visitlog;
create table visitlog (
	vno 		int auto_increment, 	-- 식별 번호 (방문록 번호) , 자동 번호 부여
    vwriter 	varchar(30) not null, 	-- (방문록 작성자명) , 공백불가능
    vpwd 		varchar(10) not null, 	-- (방문록 비밀번호) , 공백불가능 
    vcontent 	text not null, 			-- (방문록 내용)
    vdate 		datetime default now(), -- (방문록 작성일/시간) , 생략시 자동 날짜/ 시간 등록
    primary key( vno )
);

# 1. 저장 insert / 레코드 추가
insert into visitlog( vwriter , vpwd , vcontent) values ('이진형','1234','하이');
# insert into visitlog( vwriter , vpwd , vcontent) values (?,?,?);

# 2. 호출 select / 모든 레코드 검색 / 정렬(최신 글부터 출력)
select * from visitlog order by vdate desc;

# 3. 수정 [ 삭제할 식별자 필수 ]
update visitlog set vcontent = '내용수정했다' where vno = 3; /* vno 3이면 vcontent 필드의 값을 수정 */
update visitlog set vcontent = '내용수정했다' where vno = 3 and vpwd = '123123'; /* vno 3이면서 vpwd 1234이면 vcontent 필드 값 수정

# 4. 삭제 [ 삭제할 식별자 필수 ]
delete from visitlog;	/* 모든 레코드 삭제 */
delete from visitlog where vno = 3; /* vno 3이면 삭제 */
delete from visitlog where vno = 3 and vpwd = '1234'; /* vno 3 이면서 vpwd 1234면 레코드 삭제 */
# delete from visitlog where vno = ? and vpwd = ?;

drop table if exists accountbook ;
create table accountbook (
	ano int auto_increment,
	acontent text not null,
    amoney int not null,
    adate datetime default now(),
    primary key (ano)
);
select * from accountbook;
select ano, acontent, amoney ,date_format(adate, '%Y-%m-%d') as adate from accountbook;

drop table if exists member;
create table member (
	mno int auto_increment,
    mid varchar(50) not null unique,
    mpwd varchar(20) not null,
    memail varchar(50) not null unique,
    mimg longtext,		# 만약에 프로필 미등록시 기본 프로필 사용.
    primary key (mno)
    
);

# 게시판 카테고리
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment,
    bcname varchar(30) not null,
    primary key(bcno)
);
#샘플 [ 공지사항 , 자유게시판 , 노하우 ]
insert into bcategory values (1,'공지사항');
insert into bcategory values (2,'자유게시판');
insert into bcategory values (3,'노하우');


# 게시판 
drop table if exists board;
create table board(
	bno int auto_increment,
    btitle varchar(30) not null,
    bcontent longtext,
    bfile longtext,
    bdate datetime default now(),
    bview int default 0,
    mno int, 
    bcno int ,
    primary key (bno),
    foreign key(mno) references member(mno) on delete cascade , 
    foreign key(bcno) references bcategory(bcno) on delete cascade on update cascade
);



select * from member;
# 1. 회원가입
insert into member(mid,mpwd,memail,mimg) values ('이진형','a1234','qwe@qwe.com','default.jpg');

# 2. 아이디 중복검사 [ 특정 mid의 아이디로 검색했을때 존재하면 중복 , 없으면 사용중인 아이디 X]
select * from member where mid = 'qweqwe';
# select * from member where mid = ?;

# 3. 로그인 [ 아이디와 비밀번호가 일치한 레코드 존재여부 ]
select * from member where mid ='qweqwe' and mpwd = 'qweqwe'; # 레코드가 검색되면 로그인 성공 / 없으면 로그인 실패
# select * from member where mid =? and mpwd = ?;

# 4. 회원정보 호출 [ 아이디를 이용해서 패스워드 제외하고 모든 회원정보를 호출 ]
select mno, mid ,memail, mimg from member where mid = 'qweqwe';
# select mno, mid ,memail, mimg from member where mid = ?;

# 5. 회원탈퇴 [ 누구(mno)를 탈퇴할건지 , 검증(탈퇴할 회원의 패스워드) ]
delete from member where mno = 1 and mpwd = 'qweqwe' ; # 1번회원이 패스워드가 'qweqwe' 이면 레코드 삭제
# delete from member where mno = ? and mpwd = ? ;

# 6. 회원수정



update board set bview = bview +1  where bno =1;

drop table if exists library;
create table library (
	lno int,
     lname varchar(20) not null,
    lphone varchar(20) not null,
   
     
    primary key ( lno)
);

select * from library;

insert into library (lno ,lphone, lname)  values (3, '010-1111-1111','이진형');



drop table if exists hrm;
create table hrm (
	hno int auto_increment,
    himg longtext,
    hname varchar(20) not null,
    hphone varchar(20) not null,
    hposition varchar(20) not null,
    hdate datetime default now(),
    primary key(hno)
);

select * from hrm;
select * from member where mno = 1 and mpwd = 'wlsgud123';

# 모든 글 출력 [ 게시물 번호 , 제목 , 파일 , 작성일 , 조회수 , 작성자아이디 , 카테고리명 ]
select bno,btitle,bfile,bdate,bview from board;
   # 게시물테이블과 회원 테이블 조인[테이블 합치기 / pk - fk]
    # 게시물 테이블내 작성자번호와 회원테이블의 작성자번호와 같으면
select * from board b natural join member m;
select b.bno , b.btitle , b.bfile , b.bdate, m.mid from board b natural join member m; 
   #게시몰 테이블 모든 필드, 회원테이블 아이디 , 게시몰카테고리테이블 카테고리명
select b.*, m.mid,m.mimg,bc.bcname
from board b 
natural join bcategory bc 
natural join member m 
order by b.bdate desc; 

# ------------------------------------------------------- 제품 --------------------------------------------------- #
	# pk[상위] 테이블 먼저 생성
# 1. 제품 카테고리
drop table if exists pcategory;
create table pcategory(pcno int auto_increment , pcname varchar(100) not null, primary key(pcno));

	# 샘플
insert pcategory(pcname) values ('노트북');
insert pcategory(pcname) values ('테블릿');
insert pcategory(pcname) values ('냉장고');

# 2. 제품
drop table if exists product;
create table product(
	pno			int auto_increment,
    pname		varchar(100) not null,
    pcontent 	longtext,
    pprice 		int unsigned default 0 not null, -- signed(기본값: 음수사용 +-21억)/unsigned(음수사용X-음수만큼의 메모리를 양수로 사용 0~40억정도) : 음수 사용여부
    pstate		tinyint default 0, -- [ 0 : 판매중(기본값) , 1 : 거래중 , 2 : 판매대기 , 3: 판매완료 ]
    pdate		datetime default now(),
    plat		varchar(30),
    plng		varchar(30),
    pcno		int ,
    mno			int ,
    primary key( pno ),
    foreign key(pcno) references pcategory(pcno) on delete set null on update cascade,
    foreign key( mno) references member(mno) on delete cascade on update cascade
    );
    
    
# 3. 제품 이미지
drop table if exists productimg;
create table productimg(
	pimgno int auto_increment,
    pimg longtext,
    pno int ,
    primary key ( pimgno ),
    foreign key ( pno ) references product(pno) on delete cascade on update cascade
    
);


