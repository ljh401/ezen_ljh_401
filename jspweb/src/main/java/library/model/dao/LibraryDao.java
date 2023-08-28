package library.model.dao;

import library.model.dto.LibraryDto;
import model.dao.Dao;

public class LibraryDao extends Dao{

private static LibraryDao libraryDao = new LibraryDao();
	
	public static LibraryDao getInstance() {return libraryDao;}
	
	private LibraryDao() {super();} 
	
	public boolean outroom(int lno , String lphone) {
		try {
			String sql = "delete from library where lno =? and lphone =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lno);
			ps.setString(2, lphone);
			
			int row = ps.executeUpdate();
			if(row == 1) return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	 public boolean inroom( LibraryDto libraryDto ) {
	      System.out.println(libraryDto.getLname());
	      try {
	         String sql = "insert into library(  lno , lname , lphone ) values( ? , ? , ? )";
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, libraryDto.getLno());
	         ps.setString(2, libraryDto.getLname());
	         ps.setString(3, libraryDto.getLphone());
	         ps.executeUpdate();
	         return true;
	      } catch (Exception e) {System.out.println(e);}
	      return false;
	   }

}
