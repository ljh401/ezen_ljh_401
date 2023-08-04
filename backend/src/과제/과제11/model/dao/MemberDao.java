package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getInstance() {return memberDao;}
	
	private MemberDao() {super();} // 직계부모의 생성자
		// 2. 회원가입SQL
		public boolean signupSQL(MemberDto memberDto) {
			
			// 1. 회원가입 필요한 SQL을 문자열에 작성해서 저장
				// 테이블에 레코드 삽입 : insert into 테이블명(필드명,필드명,필드명)values(매개변수1,매개변수2,매개변수3);
			String sql = "insert into member(mid,mpw,mname,mphone) values(?,?,?,?)";
			try { // Connection , PreparedStatement , ResultSet 예외처리 필수 !!
			// 2. 위에서 작성한 SQL를 DB연동객체에 대입 [conn.prepareStatement(sql)]
			// 3. 대입한 SQL 조작하기 위해 반환된 PreparedStatement를 ps 대입
			ps = conn.prepareStatement(sql); // db연동객체.prepareStatement(조작할 SQL 문자열)
			// conn , ps 필드는 Dao 부모클래스에게 물려받음
			
			// 4. SQL에서 작성한 매개변수(?)에 대해 값 대입 [ .setString(?순서번호, 값) ]
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpw());
			ps.setString(3, memberDto.getMname());
			ps.setString(4, memberDto.getMphone());
			
			// 5. sql 실행				[ ps.executeUpdate();	: SQL실행]			  [
			ps.executeUpdate();	
			return true;
			} catch (Exception e) {System.out.println("경고] 회원가입 실패 사유 : " + e);}
			return false;
		}
		// 3. 로그인SQL
		public boolean loginSQL(String id, String pw) {
			try {
			// 1. SQL 작성 [workbench에서 임의값으로 테스트하기]
			String sql = "select * from where mid = ? and mpw = ?";
			// 2. SQL 조작할수 있는 객체 PreparedStatement 반환받기
			ps = conn.prepareStatement(sql);
			// 3. SQL 조작 [SQL안에 있는 매개변수[?]에 값 대입]
			ps.setString(1,id);
			ps.setString(2,pw);
			// 4. SQL 실행해서 그 결과객체를 rs객체에 대입[ps는 결과조작 불가능] [  select만 쿼리 Query ]
			ps.executeQuery();
			// 5. : SQL 실행 결과를 조작 [rs.next() : 결과 중에서 다음 레코드객체 호출] 
				// 만약에 결과의 레코드 3개 가정하면 [ rs = null -> 레코드1 -> 레코드2 ->레코드3]			
				// next()로 null값 뛰어넘는거 
			if(rs.next()) { // 로그인SQL 결과레코드는 1개 또는 0개 이므로 if 사용해서 .next() 1번호출
				return true;
			}
			} catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
}
