package accountbook.model.Dao;

import java.util.ArrayList;

import accountbook.model.Dto.AccountbookDto;
import model.dao.Dao;

public class AccountbookDao extends Dao{

private static AccountbookDao accountbookDao = new AccountbookDao();
	
	public static AccountbookDao getInstance() {return accountbookDao;}
	
	private AccountbookDao() {super();} 
	
	public boolean awrite(AccountbookDto accountbookDto) {
		
		try {
			String sql = "insert into accountbook(acontent , amoney , adate) values (?,?,?)";
			ps = conn.prepareStatement(sql); // 2. SQL 연결
			ps.setString(1,accountbookDto.getAcontent());// 3. SQL 매개변수 대입
			ps.setInt(2,accountbookDto.getAmoney());
			ps.setString(3,accountbookDto.getAdate());
			ps.executeUpdate(); // 4. SQL 실행
			return true; // 5. 결과 반환
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public ArrayList<AccountbookDto> aread() {
		ArrayList<AccountbookDto> list = new ArrayList<>();
		
		try {
			String sql = "select ano, acontent, amoney ,date_format(adate, '%Y-%m-%d') as adate from accountbook";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AccountbookDto accountbookDto = new AccountbookDto(
						rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
						list.add(accountbookDto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
	public boolean aupdate(int ano, String acontent, int amoney, String adate) {
		try {
			String sql = "update accountbook set acontent = ? , amoney = ? , adate = ? where ano = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, acontent);
			ps.setInt(2, amoney);
			ps.setString(3, adate);
			ps.setInt(4, ano);
			int row = ps.executeUpdate();
			if(row == 1) return true;
			return false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		}

	public boolean adelete(int ano) {
		try {
			String sql = "delete from accountbook where ano =?"; 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ano);
			
			int row = ps.executeUpdate(); 
			if(row == 1) return true; 
			return false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		}
}
