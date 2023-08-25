package library.model.dao;

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
	
}
