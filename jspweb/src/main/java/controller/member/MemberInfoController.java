package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberInfoController() {super();}

    // 2. 회원정보(세션호출) / 로그아웃(세션초기화) 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청한다 [ 기능 구분을 위한 요청 ]
		String type = request.getParameter("type");
			// * 만약에 type이 info라면
		if(type.equals("info")) {
			// * 세션에 저장된 로그인객체를 꺼내기
			// 1. 세션호출한다 . [세션타입은 Object ]
			Object session = request.getSession().getAttribute("loginDto");
				// 2. 타입변환한다. [ 부-> 자 (캐스팅/강제타입변환) ]
			MemberDto loginDto = (MemberDto)session;
			
				// * DTO는 JS가 이해할수 없는 언어 이므로 JS가 이해할수 있게 JS언어로 변환 [ jackson 라이브러리 ]
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(loginDto);
			// 4. 응답한다.
			
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
		} else if (type.equals("logout")){
			// * 세션에 저장된 로그인객체를 없애기/초기화/지우기/삭제
			// 방법1 : (세션의 모든 속성) 초기화하는 함수
				// request.getSession().invalidate(); // 로그인 정보 뿐만 아니라 모두 삭제.
			// 방법2 : (세션의 톡정 속성) 초기화하는 방법 JVM GC(쓰레기 수집기 = 해당 객체를 아무도 참조하고 있지 않으면 삭제 )
				// 삭제할 세션속성명과 동일하게 null 대입
			request.getSession().setAttribute("loginDto", null);
		}
	}
	// 1. [C] 첨부파일 있을때 form 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// -----------------------------------------파일 업로드 : 서버 폴더에 --------------------------------------------------------//
		//  첨부파일을 저장할 폴더의 절대 경로
		// 1. 개발자 pc경로 업로드 [ 문제발생: 개발자pc에 업로드하면 업로드파일을 서버로 빌드 ]
		// String uploadpath = "C:\\Users\\504\\git\\ezen_ljh_401\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로
		// 2. 서버 pc경로 업로드 [ 사용자는 바로 서버pc 업로드 ]
		// String uploadpath = "C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps"
		// 3. 서버 pc 경로 ( 상대 경로 = 서버 경로 찾아주는 함수 )
			// request.getSession().getServletContext().getRealPath("프로젝트명 이하 경로);
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/img");
		System.out.println("member 폴더 imge 폴더 실제(서버) 경로 : " + uploadpath);
		
		
		// 첨부파일 전송 했을때.
			// 1. 첨부파일 서버PC에 업로드( COS.jar 라이브러리 )
				// MultipartRequest : 파일 업로드 클래스
		
			MultipartRequest multi = new MultipartRequest(
					request , 						// 1. 요청방식
					uploadpath , 					// 2. 첨부파일을 저장할 폴더 경로
					1024 * 1024 * 10 ,				// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
					"UTF-8" ,						// 4. 한글인코딩타입
					new DefaultFileRenamePolicy()	// 5. [파일중복제거]만약에 서버내 첨부파일이 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기
					);
	// ----------------------------------------------DB처리 : 업로드된 파일명 --------------------------------------------------------//	
			// 2. form안에 있는 각 데이터 호출
		
			// 일반 input : request.getParameter("form 객체 전송시 input name" )
			// 첨부파일 input : multi.getFilesystemName();
		String mid = multi.getParameter("mid"); System.out.println("mid : " + mid);
		String mpwd = multi.getParameter("mpwd"); System.out.println("mpwd : " + mpwd);
		String memail = multi.getParameter("memail"); System.out.println("memail : " + memail);
		//String mimg = multi.getParameter("mimg"); System.out.println("mimg : " + mimg);
		String mimg = multi.getFilesystemName("mimg"); System.out.println("mimg : " + mimg);
		
		// * 만약에 사진 업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
		if( mimg == null) {mimg = "default.webp";}
		
		// 2. (선택) 객체화
		MemberDto dto = new MemberDto(mid,mpwd,memail,mimg);
		
		// 3. DAO에게 전달하고 결과 받기
		boolean result = MemberDao.getInstance().signup(dto);
		
		// 4. AJAX통신으로 결과 데이터를 응답을 보낸다. [ response ]
		response.setContentType("application/json; charset = UTF-8");
		response.getWriter().print(result);
	}
	
	/*
	// 1. [C] 첨부파일 없을때 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. AJAX 통신 받은 data객체의 '속성명' 요청 [ request ]
		String mid = request.getParameter("mid"); System.out.println("mid : " + mid);
		String mpwd = request.getParameter("mpwd"); System.out.println("mpwd : " + mpwd);
		String memail = request.getParameter("memail"); System.out.println("memail : " + memail);
		String mimg = request.getParameter("mimg"); System.out.println("mimg : " + mimg);
		
		// 2. (선택) 객체화
		MemberDto dto = new MemberDto(mid,mpwd,memail,mimg);
		
		// 3. DAO에게 전달하고 결과 받기
		boolean result = MemberDao.getInstance().signup(dto);
		
		// 4. AJAX통신으로 결과 데이터를 응답을 보낸다. [ response ]
		response.setContentType("application/json; charset = UTF-8");
		response.getWriter().print(result);
	}
	*/
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		//------------------------------------파일 업로드 ---------------------------------------//
			MultipartRequest multi = new MultipartRequest(
					request , 						
					request.getServletContext().getRealPath("/member/img"),
					1024 * 1024 * 10 ,				
					"UTF-8" ,						
					new DefaultFileRenamePolicy()
					);
		// -----------------------------------DB 업데이트 --------------------------------------- //
		// * form 전송일때는 input의 데이터 호출시
				// 일반 input : multi.getParameter("input name");
				// 첨부 input : multi.getFilessystemName("input name");
			String mimg = multi.getFilesystemName("mimg");
			
			// Dao [ 로그인된 회원번호 ,수정할 값 ]
			Object object = request.getSession().getAttribute("loginDto"); // 1. 로그인 세션 호출
			MemberDto memberDto = (MemberDto)object; // 2. 타입 변환
			int loginMno = memberDto.getMno();	// 3. 로그인객체에 회원번호만 호출한다.
			
			// 만약에 수정할 첨부파일 이미지 없으면
			if(mimg == null) { // 기존 이미지 그대로 사용
				mimg = memberDto.getMimg(); // 세션에 있던 이미지 그대로 대입
			}
			
			boolean result = MemberDao.getInstance().mupdate(loginMno, mimg);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);

			
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청한다.
		String mpwd = request.getParameter("mpwd");
		// 2. 유효성검사/객체화
		System.out.println(mpwd);
		// 3. DAO 처리 [ 현재로그인된 회원번[pk] ,입력받은 패스워드 [mpwd]
			// 1. 현재로그인된 회원정보 => 세션
		//((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		Object object = request.getSession().getAttribute("loginDto"); // 1. 로그인 세션 호출
		MemberDto memberDto = (MemberDto)object; // 2. 타입 변환
		int loginMno = memberDto.getMno();	// 3. 로그인객체에 회원번호만 호출한다.
		// 2. Dao 전달
		boolean result = MemberDao.getInstance().mdelete(loginMno, mpwd);
		System.out.println(loginMno + " " +  mpwd);
		System.out.println(result);
		// 4. 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}

/*
 	용량 단위
 	
 		bit : 0 or 1
 		byte : 01010101
 		kb : 1024byte -> 1kb
 		mb : 1024kb -> 1mb
 		
 */
