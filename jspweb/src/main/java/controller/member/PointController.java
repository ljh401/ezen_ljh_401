package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PointController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 서로 다른 함수/기능을 실행하기 위한 분류
		String type = request.getParameter("type");
		
		// -
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		// 2. 분류
		if(type.equals("1")) { // 현재 포인트 출력
			long result = MemberDao.getInstance().getPoint(mno);
			json = mapper.writeValueAsString(result);
		}
		else if(type.equals("2")) { // 포인트 내역 전체 출력
			List<MpointDto> result = MemberDao.getInstance().getPointList(mno);
			json = mapper.writeValueAsString(result);
		
		}
		// 3. 응답
		response.setContentType("application/json; charset =utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mpno = UUID.randomUUID().toString(); // 포인트 내역 식별번호 구성 [ UUID ]
			// UUID.randomUUID() : (s) UUID 고유성을 보장하는 ID[식별자] 만들기 위한 표준규약
		System.out.println(mpno);
		// 2. 로그인된[세션에저장된] 회원정보에서 회원번호만 출력
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		// 3. 포인트 수량 /지급내역은 JS에서 전달받음
		long mpamount = Long.parseLong(request.getParameter("mpamount"));
		String mpcomment = request.getParameter("mpcomment");
		// DTO
		MpointDto mpointDto = new MpointDto(mpno, mno , mpamount , mpcomment, null);
		// DAO
		boolean result = MemberDao.getInstance().setPoint(mpointDto);
		// 응답
		response.setContentType("application/json; charset =utf-8");
		response.getWriter().print(result);
		
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
