package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;


@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardInfoController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 2. 쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 첨부파일 업로드 [ cos.jar -> MultipartRequest 클래스 ]
		MultipartRequest multi = new MultipartRequest(
				request, // 요청 방식
				request.getServletContext().getRealPath("board/upload"), // 저장경로
				1024*1024*1024, // 업로드 허용 용량 [바이트] 1GB
				"UTF-8", // 인코딩타입
				new DefaultFileRenamePolicy() // 만약에 업로드파일명이 서버내 존재하면 (중복) 자동으로 파일명뒤에 숫자 붙이기
				);
		// 2. (입력받은 매개변수) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
			// - 작성자(mno) 입력 안받음 / mno는 세션에 저장되어있는 상태
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		
		
		// 3. 유효성 검사/ 객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno);
		System.out.println(boardDto);
		// 4. DAO 처리
		boolean result = BoardDao.getInstance().bwrite(boardDto);
		// 5. DAO 결과 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);


	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
