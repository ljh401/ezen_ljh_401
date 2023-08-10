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

drop table if exists board;
create table board(
	bno int auto_increment,
    btitle varchar(50) not null,
    bcontent longtext not null,
    bdate datetime default now(),
    bview int not null,
    mno int,
    primary key ( bno),
    foreign key (mno) references member(mno) on delete cascade 		# 회원탈퇴[PK레코드 삭제] 되면 FK의 레코드 같이 삭제
    #foreign key (mno) references member(mno) on delete restrict 	# (default)회원탈퇴[PK레코드 삭제] 할때 FK의 레코드가 존재하면 탈퇴 불가능
    #foreign key (mno) references member(mno) on delete set null 	# 회원탈퇴[PK레코드 삭제] 되면 FK의 값을 null로 수정
    #foreign key (mno) references member(mno) on delete no action 	# 회원탈퇴[PK레코드 삭제] 되면 아무런 변화 없는 상태
    
);