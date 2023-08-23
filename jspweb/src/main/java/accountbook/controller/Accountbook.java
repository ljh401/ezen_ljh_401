package accountbook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import accountbook.model.Dao.AccountbookDao;
import accountbook.model.Dto.AccountbookDto;


@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Accountbook() {super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<AccountbookDto> result = AccountbookDao.getInstance().aread();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		System.out.println(jsonArray);
		response.setContentType("application/json; charset = UTF-8");
		response.getWriter().print(jsonArray);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acontent = request.getParameter("acontent"); System.out.println("acontent : " + acontent);
		int amoney = Integer.parseInt(request.getParameter("amoney")); System.out.println("amoney : " + amoney);
		String adate = request.getParameter("adate"); System.out.println("adate : " + adate);
	
		AccountbookDto accountbookDto = new AccountbookDto(acontent , amoney , adate); System.out.println("accountbookDto :" + accountbookDto);
		boolean result = AccountbookDao.getInstance().awrite(accountbookDto);
		response.setContentType("application/json; charset= UTF-8");
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int ano = Integer.parseInt(request.getParameter("ano")); System.out.println("ano : " + ano);
			String acontent = request.getParameter("acontent"); System.out.println("acontent : " + acontent);
			int amoney = Integer.parseInt(request.getParameter("amoney")); System.out.println("amoney : " + amoney);
			String adate = request.getParameter("adate"); System.out.println("adate : " + adate);
			
			boolean result = AccountbookDao.getInstance().aupdate(ano, acontent, amoney, adate);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int ano = Integer.parseInt(request.getParameter("ano")); System.out.println("ano : " + ano);
			boolean result = AccountbookDao.getInstance().adelete(ano);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(result);
	}

}
