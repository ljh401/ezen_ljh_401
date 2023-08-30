package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.model.dao.LibraryDao;
import library.model.dto.LibraryDto;



@WebServlet("/library")
public class library extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public library() {super();}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int lno = Integer.parseInt(request.getParameter("lno"));
	      String lname = request.getParameter("lname"); System.out.println("lname : " +lname);
	      String lphone = request.getParameter("lphone"); System.out.println("lphone : " +lphone);

	      
	      LibraryDto libraryDto = new LibraryDto( lno , lname, lphone);

	      boolean result = LibraryDao.getInstance().inroom(libraryDto);
	      
	      response.setContentType("application/json;charset=UTF-8");
	      response.getWriter().print(result);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lno = Integer.parseInt(request.getParameter("lno")); System.out.println("lno : " + lno);
		String lphone = request.getParameter("lphone");  System.out.println("lphone : " + lphone);
		
		boolean result = LibraryDao.getInstance().outroom(lno, lphone);
	
		
		response.setContentType("application/json; charset =UTF-8");
		response.getWriter().print(result);
		
	}

}