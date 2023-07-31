package java1.day13.Ex2.View;

import java.util.Scanner;

import java1.day13.Ex2.Controller.BoardController;

public class MainPage {

		// 싱글톤(공유)O : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
		// 1. 현재 클래스안에 현재클래스로 객체 선언 [ private static ]
		private static MainPage mainPage = new MainPage();
		// 2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수
		public static MainPage getInstance() {return mainPage;}
		// 3. 외부로 부터 객체 생성 차단하는 생성자 선언
		private MainPage() {}
		
		// 입력객체 필드
		private Scanner sc = new Scanner(System.in);
		
		
		// 메인페이지 입출력 함수
		public void mainView() {
			while(true)	 {
				System.out.println("\n\n >>>>> 방문록 프로그램 >>>>>");
				System.out.print("1.글등록 2.글보기 3.글수정 4.글삭제 선택> ");
				int ch = sc.nextInt();
				if(ch == 1) {writeView();} // 각 번호별 페이지 함수 호출
				if(ch == 2) {printView();}
				if(ch == 3) {updateView();}
				if(ch == 4) {deleteView();}
			} // while end
		} 
		
		// 글등록 처리 기능함수
		public void writeView() {
			// View에서 Controller 함수 호출
			BoardController.getInstance().writeLogic();
		}
		// 글출력 처리 기능함수
		public void printView() {
			// View에서 Controller 함수 호출
			BoardController.getInstance().printLogic();
		}
		// 글삭제 처리 기능함수
		public void updateView() {
			// View에서 Controller 함수 호출
			BoardController.getInstance().updateLogic();
		}
		// 글수정 처리 기능함수
		public void deleteView() {
			// View에서 Controller 함수 호출
			BoardController.getInstance().deleteLogic();
		}
		
}	
