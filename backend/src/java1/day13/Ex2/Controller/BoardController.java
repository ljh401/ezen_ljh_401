package java1.day13.Ex2.Controller;

public class BoardController {

	// 싱글톤(공유)O : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	
	public static BoardController getInstance() {return boardController;}
	
	private BoardController() {}

	// 글등록 처리 기능함수
	public void writeLogic() {
		System.out.println("검토용 쓰기 컨트롤러까지 도착");
	}
	// 글출력 처리 기능함수
	public void printLogic() {
		System.out.println("검토용 출력 컨트롤러까지 도착");
	}
	// 글삭제 처리 기능함수
	public void updateLogic() {
		System.out.println("검토용 수정 컨트롤러까지 도착");
	}
	// 글수정 처리 기능함수
	public void deleteLogic() {
		System.out.println("검토용 삭제 컨트롤러까지 도착");
	}
}
