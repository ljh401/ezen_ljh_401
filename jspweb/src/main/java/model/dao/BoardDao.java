package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{

	private static BoardDao boardDao = new BoardDao();
	
	public static BoardDao getInstance() {return boardDao;}
	
	private BoardDao() {super();}

	// 1. 글쓰기
	public boolean bwrite(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle, bcontent , bfile , mno , bcno ) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBfile());
			ps.setInt(4, boardDto.getMno());
			ps.setInt(5, boardDto.getBcno());
			int count = ps.executeUpdate();
			if(count == 1) return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	// 2. 모든 글 출력
	public ArrayList<BoardDto> boardPrint(){
		return null;
	}
	// 3. 개별 글 출력
	
	// 4. 게시물 수정
	public void boardUpdate() {
		
	}
	// 5. 게시물 삭제
	public void boardDelete() {
		
	}
	// 6. 조회수 증가
}
