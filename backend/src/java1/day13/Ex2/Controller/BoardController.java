package java1.day13.Ex2.Controller;

import java1.day13.Ex2.Model.dao.BoardDao;
import java1.day13.Ex2.Model.dto.BoardDto;

public class BoardController {

   // 싱글톤o : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
   private static BoardController boardController = new BoardController();
   public static BoardController getInstance() { return boardController; }
   private BoardController() {}
   
   // 글쓰기 처리 기능함수
   public boolean writeLogic(String writer, String content) {
      
      // 1. 매개변수로부터 전달 받은 content, writer를 하나의 객체로 선언
      BoardDto boardDto = new BoardDto(content, writer);
      // 2. 객체를 배열에 저장 [ 빈공간을 찾아서 빈공간 저장 ]
//      for(int i = 0 ; i < BoardDao.getInstance().boardDtoArray.length; i++) {
//         if(BoardDao.getInstance().boardDtoArray[i] == null) {
//            BoardDao.getInstance().boardDtoArray[i] = b;
//            return true;
//         }
//      }
      // 2. 객체를 리스트에 저장
      BoardDao.getInstance().boardDtoList.add(boardDto);
      // 성공[true] 또는 실패[false]
      
         
      return true;
   }
   
   // 글출력 처리 기능함수
   public BoardDto printLogic(int index) {
      
      BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
      
      
      return boardDto;
   }
   
   // 글수정 처리 기능함수
   public boolean updateLogic(int index, String content , String writer) {
	   // 1. 입력받은 인덱스의 게시물을 호출해서 새로운 입력받은 값으로 대입/저장/수정 = set , 호출/불러오기 = get
	   BoardDao.getInstance().boardDtoList.get(index).setContent(content);
	   	// BoardDao.getInstance().boardDtoList.get(index) = content // *DTO 필드에 직접접근X => set/ get 간접접근O
	   BoardDao.getInstance().boardDtoList.get(index).setWriter(writer);
	
	   return true;
      
   }
   
   // 글삭제 처리 기능함수
   public boolean deleteLogic(int index) {
      
      BoardDao.getInstance().boardDtoList.remove(index);
      
      return true
    		  ;
   }
   
   
}