package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getInstance() {return memberDao;}
	
	private MemberDao() {super();} // 직계부모의 생성자
	
	
		// 1. 회원정보 Check 함수 : type = 1 아이디중복체크 type = 2 전화번호중복체크
		public boolean infoCheck(String 검색할필드명 , String 검색할값) {
			
			try {
				String sql = "select * from member where "+ 검색할필드명+"= ?"; 
				ps = conn.prepareStatement(sql);
				ps.setString(1, 검색할값);
				rs = ps.executeQuery();
				if(rs.next()) {return true;}		
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return false;
		}
	
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
		public int loginSQL(String id, String pw) {
			try {
			// 1. SQL 작성 [workbench에서 임의값으로 테스트하기]
			String sql = "select * from member where mid = ? and mpw = ?";
			// 2. SQL 조작할수 있는 객체 PreparedStatement 반환받기
			ps = conn.prepareStatement(sql);
			// 3. SQL 조작 [SQL안에 있는 매개변수[?]에 값 대입]
			ps.setString(1,id);
			ps.setString(2,pw);
			// 4. SQL 실행해서 그 결과객체를 rs객체에 대입[ps는 결과조작 불가능] [  select만 쿼리 Query ]
			rs = ps.executeQuery();
			// 5. : SQL 실행 결과를 조작 [rs.next() : 결과 중에서 다음 레코드객체 호출] 
				// 만약에 결과의 레코드 3개 가정하면 [ rs = null -> 레코드1 -> 레코드2 ->레코드3]			
				// next()로 null값 뛰어넘는거 
			if(rs.next()) { // 로그인SQL 결과레코드는 1개 또는 0개 이므로 if 사용해서 .next() 1번호출
				return rs.getInt(1); // 검색된 회원번호(첫번째 필드)를 반환
			}
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
		
		// 4. 
		public String findById(String name , String phone) {
			try {
				// sql 작성
			String sql = "select mid from member where mname = ? and mphone = ?";
				// 작성된 sql을 조작할 PreparedStatement 객체를 연동객체로 부터 반환
			ps = conn.prepareStatement(sql);
				// sql조작 [ 매개변수 대입 ]
			ps.setString(1, name); // 1. sql문에 있는 첫번째 ? 에 name 변수 대입
			ps.setString(2, phone);
				// sql 조작 [ sql 실행 ]
				// sql 결과를 조작할 ResultSet 객체를 excuteQuery 메소드로부터 반환 
			rs = ps.executeQuery();
				// sql 결과 조작 [ rs.next() : 검색된 레코드중 다음레코드 이동 ]
				// rs.getString(검색필드순서번호)  : 현재 위치한 레코드의 필드값 호출
			if(rs.next()) {return rs.getString(1);} // 검색된 레코드중 2번째 필드인 id값을 반환
			
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
		}
		
		// 5. 
		public String findByPw(String id, String phone) {
			try {
				String sql = "select mpw from member where mid = ? and mphone = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, phone);
				rs = ps.executeQuery();
				if(rs.next()) {return rs.getString(1);} // 검색된 레코드 중 1번째 필드인 pw값을 반환
				
				} catch (Exception e) {
					System.out.println(e);
				}
				
			
			return null;
		}
		

		// 6. 회원번호를 가지고 회원정보 찾기 .. 회원번호가 존재하는 레코드 찾기
		   public MemberDto info(int mno) {
			   try {
				   String sql = "select * from member where mno =?"; // 1. SQL 작성
				   ps = conn.prepareStatement(sql); // 2. SQL조작할 객체
				   ps.setInt(1, mno); // 3. SQL조작
				   rs = ps.executeQuery();  //4. SQL실행 // 5 SQL결과 조작 객체
				   if(rs.next()) { // 6. sql결과 조작 // 만약에 다음 레코드가 존재하면
					   // * 현재 레코드 DTO로 만들기
					   MemberDto dto = new MemberDto(
							   rs.getInt(1),rs.getString(2),
							   rs.getString(3),rs.getString(4), rs.getString(5));
					   	return dto;
				   }
			   }catch (Exception e) {
				System.out.println(e);
			}
			   return null; //실패
		   }
		
		// 7. 비밀번호 수정
		   public boolean infoUpdate(String newPw , int mno) {
			   try {
				String sql = "update member set mpw = ? where mno = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, newPw);
				ps.setInt(2, mno);
				int row = ps.executeUpdate(); // 업데이트한 레코드 개수 반환
				if(row == 1) return true;
			   }catch (Exception e) {
				   System.out.println(e);
			   }
			   
			   return false;
		   }
		   
		// 8. 회원 탈퇴
		   public boolean infoDelete(int mno) {
			   try {
					String sql = "delete from member where mno = ?"; 
					ps = conn.prepareStatement(sql);
					ps.setInt(1, mno);
					int row = ps.executeUpdate(); // 삭제한 레코드 반환 (mno은 pk라서 2개 이상 나오면 이상한거)
					if(row == 1) return true;
				   }catch (Exception e) {
					   System.out.println(e);
				   }
			   
			   return false;
		   }
		
}
