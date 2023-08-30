package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{

	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getInstance() {return memberDao;}
	
	private MemberDao() {super();} 
	
	// 1. 회원가입
	public boolean signup(MemberDto dto) {
		try {
			String sql ="insert into member(mid,mpwd,memail,mimg) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	// 2. 로그인
	public boolean login( String mid , String mpwd) {
		try {
			String sql = "select * from member where mid =? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid); ps.setString(2, mpwd);
			rs =ps.executeQuery();
			if(rs.next()) return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 3. 아이디찾기
	
	// 4. 비밀번호찾기
	
	// 5. 내 정보 호출
	
	// 6. 아이디 중복 검사 [ 인수 : 검사할 아이디 / 반환 : true(중복O) , false(중복X)
		// type : 필드명 / data(입력받은 mid, memail ) : 필드에서 찾을값
	public boolean findIdOrEmail(String type, String data) {
		try {
			String sql = "select * from member where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			// [ while vs if ]
			if( rs.next()) return true;
		} catch (Exception e) {
			System.out.println(e);
			
		}
		return false;
	}
	// 7. 회원수정
	
	// 8. 회원탈퇴
	
}










