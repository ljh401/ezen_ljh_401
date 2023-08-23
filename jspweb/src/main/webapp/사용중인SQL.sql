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

select * from visitlog;