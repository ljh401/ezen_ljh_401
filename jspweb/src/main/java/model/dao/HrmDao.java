package model.dao;

import java.util.ArrayList;


import model.dto.HrmDto;

public class HrmDao extends Dao {

private static HrmDao hrmDao = new HrmDao();
	
	public static HrmDao getInstance() {return hrmDao;}
	
	private HrmDao() {super();}

	public boolean save(HrmDto dto) {
		try {
			String sql ="insert into hrm(hname,hphone,himg,hposition) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getHname());
			ps.setString(2, dto.getHphone());
			ps.setString(3, dto.getHimg());
			ps.setString(4, dto.getHposition());
			
			int row = ps.executeUpdate();
			if(row == 1) return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} 
	
	public ArrayList<HrmDto> print() {
ArrayList<HrmDto> list = new ArrayList<>();
		
		try {
			String sql = "select hno, himg, hname,hphone,hposition ,date_format(hdate, '%Y-%m-%d') as hdate from hrm";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				HrmDto Dto = new HrmDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
						list.add(Dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
}
