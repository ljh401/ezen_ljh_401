package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.LetterDto;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
   // 0.싱글톤
   private static LoginPage loginPage = new LoginPage();
   public static  LoginPage getInstance() {return loginPage;}
   private LoginPage() {}
   
   // 0.입력객체
   private Scanner sc = new Scanner(System.in);
   // 1. loginMenu   :  로그인했을때 메뉴
   public void loginMenu() {
	   
	   
	   
      while(MemberController.getInstance().getLoginSession() !=0) { // 로그인이 되어 있는 경우에만 반복문
    	  boardPrint();
         System.out.println("\n\n ======= ======== =========");
         System.out.println("1. 로그아웃 2. 회원정보 3. 글쓰기 4. 글조회 선택");
         
         try {
            
            int ch = sc.nextInt();
            if(ch == 1) {MemberController.getInstance().logOut();}
            if(ch == 2) {info() ;}
            if(ch==3) {boardWrite();} 
            if(ch ==4) {boardView();}
            }catch(Exception e) {
               System.out.println("경고] 잘못 입력했습니다.");
               sc = new Scanner(System.in);
         } // c end
      } // w end
   }// f end
   // 2. info         : 로그인된 회원정보 페이지
   public void info() {
	   System.out.println("\n\n ===== info =====");
	   // 1. 컨트롤에게 회원정보 요청해서 1명의 회원정보[Dto]반환받기
	   MemberDto result = MemberController.getInstance().info();
	   // 2. 반환받은 회원정보객체[memberDto]의 각 필드를 출력
	   //System.out.println(">ID :" + result.id); DTO 필드에 직접접근 불가능
	   System.out.println(">ID :" + result.getMid());
	   System.out.println(">NAME :"+ result.getMname());
	   System.out.println(">PHONE :"+ result.getMphone());
	   
	   // 2. 서브메뉴
	   System.out.print("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 4. 쪽지확인 선택 :");
	   int ch = sc.nextInt();
	   if(ch == 1) {infoUpdate();}
	   if(ch == 2) {infoDelete();}
	   if(ch == 3) {return;} // 생략 가능
	   if(ch ==4 ) {letterCheck();}
	   
   }
   // 3. infoUpdate   : 회원정보수정 페이지
   public void infoUpdate() {
	   System.out.println("\n\n ===== password Update =====");
	   System.out.print("새로운 비밀번호 :"); String newPw = sc.next();
	   
	   boolean result =MemberController.getInstance().infoUpdate(newPw);
	   if(result) {System.out.println("안내] 비밀번호 수정 완료 : 로그아웃됩니다.");
	   	MemberController.getInstance().logOut();
	   }
	   else {System.out.println("안내] 비밀번호 수정 실패 , 관리자에게 문의.");}
   }
   // 4. infoDelete    : 회원탈퇴 페이지
   public void infoDelete() {
	   System.out.println("\n\n ===== member Delete =====");
	   System.out.print("정말 탈퇴하시겠습니까? 1.예 2.아니요 :");
	   int ch = sc.nextInt();
	   if(ch ==1) {
		   boolean result = MemberController.getInstance().infoDelete();
		   if(result) {
			   System.out.println("안내] 회원탈퇴성공 : 로그아웃됩니다.");
			   MemberController.getInstance().logOut();
		   } else {
			   System.out.println("경고] 회원탈퇴실패 , 관리자에게 문의.");
		   }
	   }
	   
   }
   // 5. boardWrite   : 게시물쓰기 페이지
   public void boardWrite() {
	   System.out.println("\n\n ===== boardWrite =====");
	   System.out.print("글 제목 :" ); String title = sc.next();
	   System.out.print("글 내용 :" ); String content = sc.next();
	   
	   boolean result = BoardController.getInstance().boardWrite(title, content);
	   
	   if(result) {System.out.println("안내 ] 글쓰기 등록");}
	   else  {System.out.println("안내 ] 글쓰기 실패 : 제목 1~50 사이로 필수 입력.");}
   }
   // 6. boardPrint    : 모든 게시물 출력
   public void boardPrint() {
	   
	   // 1. 여러개의 게시물을 요청해서 반환된 결과 저장
	
			  ArrayList<BoardDto> result = BoardController.getInstance().boardPrint();
	   // 2. 출력
	   System.out.println("\n\n ===== post LIST =====");
	   System.out.printf("%-3s %-4s %-15s %-10s %s \n", "no","view","date","mid","title");
	   for(int i = 0; i<result.size(); i++) {
		   BoardDto dto = result.get(i);	// i번째 객체를 호출
		   
		   System.out.printf("%-3s %-4s %-15s %-10s %s \n", dto.getBno() , dto.getBview(), dto.getBdate(),dto.getMid(), dto.getBtitle());
	   }
	   
   }
   // 7. boardView   : 개별 게시물 출력
   public void boardView() {
	   System.out.println("\n\n ===== post VIEW =====");
	   // 1. 보고자 하는 게시물의 게시물번호를 입력받음
	   System.out.print("게시물번호 :"); int bno = sc.nextInt();
	   // 2.
	   BoardDto result = BoardController.getInstance().boardView(bno);
	   // 3. 출력
	   System.out.printf("bno : %-3s view : %-3s mid : %-10s date : %-19s \n" ,
			   result.getBno() , result.getBview(),
			   result.getMid(), result.getBdate());
	   System.out.printf("title : %s \n" , result.getBtitle());
	   System.out.printf("content : %s \n" , result.getBcontent());
	   
	   // 4. 추가메뉴
	   System.out.print("1. 뒤로가기 2. 수정 3. 삭제  4. 쪽지보내기 선택>"); int ch = sc.nextInt();
	   if (ch == 1) {}
	   if (ch == 2) {boardUpdate(bno, result.getMno());} // 보고 있는 게시물 번호와 작성자회원번호
	   if (ch == 3) {boardDelete(bno, result.getMno());}
	   if ( ch == 4) {letterSend();}
   }
   // 8. boardUpdate: 게시물 수정 [ 게시물 번호 식별해서 제목이랑 내용만 수정 ]
   public void boardUpdate(int bno , int mno) {
	   System.out.println("\n\n ===== post update =====");
	   sc.nextLine();
	   System.out.print("수정할 글 제목 :" ); String title = sc.next();
	   System.out.print("수정할 글 내용 :" ); String content = sc.next();
	   int result =
			   BoardController.getInstance().boardUpdate( bno ,  mno,  title , content);
	   if( result == 1) {System.out.println("안내 ] 글 수정 성공");}
	   else if( result == 2) {System.out.println("안내 ] 글 수정 실패 관리자에게 문의");}
	   else if( result == 3) {System.out.println("안내 ] 본인 글만 수정 가능");}
	   else if( result == 4) {System.out.println("안내 ] 수정할 제목을 1~50 글자 사이로 입력");}
	   // 2.
	   
	   
   }
   // 결과가 여러개면 int 
   // 결과가 2개(성공,실패 경우) 이면 boolean
   
   // 9. boardDelete   : 게시물 삭제 [ 게시물 번호 식별해서 삭제 -> 로그인된 사람과 작성자가 일치할 경우 가능하도록 ]
   public void boardDelete(int bno , int mno) {
	   int result = BoardController.getInstance().boardDelete(bno , mno);
	   if( result == 1) {System.out.println("안내 ] 글 삭제 성공");}
	   else if( result == 2) {System.out.println("안내 ] 글 삭제 실패 : 관리자에게 문의");}
	   else if( result == 3) {System.out.println("안내 ] 본인 글만 삭제 가능합니다.");}
   }
   public void letterSend() {}

// 쪽지 보내기 페이지 
 
// 쪽지확인 페이지 // + 쪽지답장 보내기
	public void letterCheck() {
		System.out.println("\n\n ===== letter check =====");
		ArrayList<LetterDto> letterDto = BoardController.getInstance().letterCheck();
		System.out.printf("%-3s %-4s %-15s %-10s \n", "쪽지번호","보낸사람","보낸내용","보낸일시");
		for(int i = 0; i<letterDto.size(); i++) {
			LetterDto dto = letterDto.get(i);	// i번째 객체를 호출
			   
			   System.out.printf("%-3s %-4s %-15s %-10s \n", dto.getPno() , dto.getMno(), dto.getPcontent(),dto.getPdate());
		}
		
		System.out.print("1. 뒤로가기 2. 초기화면 3. 답장하기"); int ch = sc.nextInt();
		if(ch == 1) {info();}
		if(ch ==2 ) {return ;}
		if(ch ==3) {letterReply();}
	}
	
	public void letterReply(int pno) {
		System.out.println("\n\n ===== letter reply =====");
		System.out.print("답장할 쪽지를 선택하세요."); pno = sc.nextInt();
		
		
		  // 2.
		   LetterDto result = BoardController.getInstance().letterReply(pno);
		   // 3. 출력
		   System.out.printf("쪽지번호 : %-3s 보낸사람 : %-3s 보낸내용 : %-10s 보낸일시 : %-19s \n" ,
				   result.getPno() , result.getMno(),
				   result.getPcontent(), result.getPdate());
		  
		}
}
	
/*
	ArrayList<리스트에저장할타입> 리스트 객체명 = new ArrayList<>();
		1. .size()		: 리스트내 객체수						==유사 result.length
		2. .get(인덱스) 	: 리스트내 인덱스번째의 객체 호출		==유사 result[i]

*/