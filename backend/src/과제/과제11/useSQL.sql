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
    bview int default 0,
    mno int,
    primary key ( bno),
    foreign key (mno) references member(mno) on delete cascade       # 회원탈퇴[PK레코드 삭제] 되면 FK의 레코드 같이 삭제
    #foreign key (mno) references member(mno) on delete restrict    # (default)회원탈퇴[PK레코드 삭제] 할때 FK의 레코드가 존재하면 탈퇴 불가능
    #foreign key (mno) references member(mno) on delete set null    # 회원탈퇴[PK레코드 삭제] 되면 FK의 값을 null로 수정
    #foreign key (mno) references member(mno) on delete no action    # 회원탈퇴[PK레코드 삭제] 되면 아무런 변화 없는 상태
    
);

select * from board;
select * from board order by bdate desc;

# 테이블  합치기
# 1. select * from 테이블명1 , 테이블명2 [ 레코드수 X 레코드수 ]
select * from member , board;
# 2. 테이블 합치는데 기준!!!   [ PK --- FK ]
   # member pk = mno / board fk = mno
    # 1. 조건 조인 [ pk필드와 fk필드가 일치하면 검색 ] * 일반 조건들과 가독성 떨어짐 [ 조인을 위한 조건인지 식별 힘듬 ]
select * from member , board where member.mno = board.mno;
   # 테이블명이 길어지면 sql문도 길어져서 그래서 * 별칭!!! : 하나의 쿼리문에 다수의 테이블이 존재할때 식별용
    select * from member m , board b where m.mno = b.mno;
   # 2. 자연 조인 [ 자동으로 두 테이블간 pk필드와 fk필드를 식별해서 조인 ] * pk ,fk 다수일때 힘듬
select * from member natural join board;
   select * from member m natural join board b;
    # * 내가 보고싶은 것만 필드 골라서 출력
   # b.* : board테이블 모든 필드
    # m.mid : member테이블의 mid 필드
    select b.* , m.mid from member m natural join board b;
     select b.* , m.mid from member m natural join board b order by b.bdate desc;
    
   # 테이블명이 길어지면 sql문도 길어져서 그래서 * 별칭!!!

# 3번 게시물 조회
select * from board where bno =3;

# board테이블 조회하는데 member테이블에 있는 mid 추가적으로 같이 조회
   # 1. 1단계 : 조인      / mid는 다른 테이블에 존재하므로 
select * from board natural join member;
   # 2. 2단계 : 하나의 쿼리문에 테이블이 다수일때 별칭 권장
select * from board b natural join member m;
   # 3. 3단계 : 조건 판단
select * from board b natural join member m where b.bno =3;
   # 4. 4단계 : 정렬 판단 [ 1개 조회 정렬 무의미 ]
select * from board b natural join member m where b.bno =3 order by b.date desc;
   # 5. 5단계 : 검색 레코드 개수 제한 [ 1개 조회라서 무의미 ]
select * from board b natural join member m where b.bno =3 order by b.date desc limit 3;
   # 6. 6단계 : 검색 레코드에 표시할 필드명 선택 
select b.*, m.mid from board b natural join member m where b.bno =7;