package java1.day13.Ex2.Model.dao;

public class BoardDao {

	// 싱글톤(공유)O : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardDao boardDao = new BoardDao();
	
	public static BoardDao getInstance() {return boardDao;}
	
	private BoardDao() {}
	
	// 게시물 여러개 저장하는 곳
}
