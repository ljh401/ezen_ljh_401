package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return productDao;}
	
	// 1. 제품등록
	public boolean register(ProductDto dto) {
		try {
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat, plng, mno ) values (?,?,?,?,?,?,?)";
			// * sql insert 후 자동생성[auto_increment] 된 pk번호를 반환하는 방법.
				// .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 생성된 식별키를 반환
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, dto.getPcno());
			ps.setString(2, dto.getPname());
			ps.setString(3, dto.getPcontent());
			ps.setInt(4, dto.getPprice());
			ps.setString(5, dto.getPlat());
			ps.setString(6, dto.getPlng());
			ps.setInt(7, dto.getMno());
			
			int count = ps.executeUpdate(); // 제품 등록
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키 [pk] 반환해서 resultset[ps]에 대입
			rs.next(); // resultset null -- next() -> 결과레코드1 -- next() --> 결과레코드2
						// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ]
			
			if(count == 1 ) { // 만약에 제품등록 1개 등록했으면
				
				// 1-2 제품 등록후 생성된 제품pk를 가지고 [ 이미지 등록 ]
					// 1. dto에 저장된 이미지 개수만큼
					// Map<Integer , String>		: map객체명.keySet() : map객체 내 모든 키 호출
					// ------ get(i) 안쓰는 이유 : map컬렉션 set 컬렉션은 인덱스 없음.
				for(String img : dto.getImgList().values()) {
					sql = "insert into productimg(pimg,pno) values (?,?)";
					ps = conn.prepareStatement(sql);
					ps.setString(1 , img);
					ps.setInt(2, rs.getInt(1)); // ???? 위에서 insert 된 제품범호 ?
					ps.executeUpdate();
					
				}
				
				
				return true; // 제품등록과 이미지 등록 성공 했을때
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 2. 출력
	
		// 0. 제품에 해당하는 이미지 출력하는 함수
	public Map<Integer , String> getProductImg(int pno) { // 공통적으로 사용되는 부분을 함수화 시킴.
		try {
			
			Map<Integer, String> imglist = new HashMap<>(); // 제품별 여러개 이미지
			String sql = "select * from productimg where pno="+pno;
			
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ResultSet rs2 = ps2.executeQuery();
			// * 위에서 먼저 사용중인 rs인터페이스가 사용중이므로 [ while ] 중복 사용 불가능
			// 해결방안 새로운 rs 만들기 (PreparedStatement,ResultSet 2개 사용)
			// 새로만드는 이유 : 힙 생각을 해야함.
			// rs는 힙에 저장되는 객체이고 공유해서 저장하기 때문에 겹침. 만약에 2를 안만들고 그냥 rs라고 쓰면 둘이 공유하게 되서 덮어쓰기 되는 꼴임.
			while(rs2.next()) {
				imglist.put(rs2.getInt("pimgno"), rs2.getString("pimg"));
			}
			
			return imglist;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 3. 선택된 제품번호에 해당하는 제품 출력 함수
		public ProductDto findByPno(int pno){
			try {
				String sql = "select * from product p natural join pcategory pc natural join member m where p.pno= "+pno;
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					ProductDto productDto = new ProductDto(
							rs.getInt("pcno"), rs.getString("pcname"),
							rs.getInt("pno"),rs.getString("pname"),
							rs.getString("pcontent"),rs.getInt("pprice"),
							rs.getInt("pstate"),rs.getString("pdate"),
							rs.getString("plat"),rs.getString("plng"),
							rs.getInt("mno"),getProductImg(rs.getInt("pno")),
							rs.getString("mid"));
					return productDto;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
			}
		
	
	
		// 1. N개 제품들을 최신순으로 출력 함수
	public List<ProductDto> findByTop(int count){
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			String sql = "select * from product order by pdate desc limit " + count ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next()) {list.add(findByPno(rs.getInt("pno") ) ); }
			return list;
		} catch (Exception e) {System.out.println(e);}
		return null;
		}
	
	// 2. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수 
		public List<ProductDto> findByLatLng( String east , String west , String south , String north ){ 
			try { 	// 제품의 경도가 '동쪽' 작고 경도가 '서쪽' 크고 / 제품의 경도가 '남쪽' 작고 '북쪽' 크다. 
				List<ProductDto> list = new ArrayList<>();
				String sql = "select * from product "
						+ "	where	plat <= ? and "
						+ "			plat >= ? and "
						+ "			plng >= ? and "
						+ "			plng <= ? "
						+ " order by pdate desc";
				ps = conn.prepareStatement(sql);  
				ps.setString( 4 , east ); ps.setString( 3 , west ); ps.setString( 2 , south ); ps.setString( 1 , north );
				rs = ps.executeQuery();	System.out.println( ps );
				while( rs.next() ) {  list.add( findByPno( rs.getInt("pno") ) ); 	} return list;
				// rs가 굴러가는 *도중*에 다른 함수(DAO가 DAO를)를 불러내기 때문에 새로운 rs를 생성해야함.
				// 하지만 rs가 다 끝난후에 호출할경우는 새로운 rs를 생성할 필요가 없는거임.
			} catch (Exception e) { System.out.println(e); } return null; 
		}	
		
		// 4. 모든 제품들을 출력하는 함수
	public List<ProductDto> findByAll(){
		try {
			List<ProductDto> list = new ArrayList<>();
			String sql = "select * from product";
			ps =conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next()) {list.add(findByPno(rs.getInt("pno") ) ); }
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		}
	
	
	// 3. 제품 찜하기 등록(=찜하기 상태가 아닐때=조건에 따른 레코드가 없을때)/취소(=찜하기 상태일때 = 조건에 따른 레코드 있을때)
	public boolean setWish(int mno , int pno) {
		try {
			
			String sql = getWish(mno,pno)?
					"delete from pwishlist where mno = ? and pno = ?" :
					"insert into pwishlist values ( ? , ?)" ;
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, pno);
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 4. 제품 찜하기 상태 출력
	public boolean getWish(int mno , int pno) {
		try {
		String sql = "select * from pwishlist where mno =? and pno =?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, mno);
		ps.setInt(2, pno);
		rs = ps.executeQuery(); if(rs.next()) { return true;}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 5. 현재 로그인된 회원의 찜한 제품[여러개] 정보를 출력하는 함수
	public List<ProductDto> getWishProductList(int mno) {
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			// 현재 회원이 찜한 제품번호 찾기
			String sql = "select pno from pwishlist where mno = "+ mno; // 현재 회원의 찜하기 제품번호 목록 찾기
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 현재 회원이 찜한 제품번호의 레코드반환
				// 찾은 제품번호 하나씩  findByPno() 함수에게 전달해서 제품정보를 list 담기
			while(rs.next()) {list.add(findByPno( rs.getInt("pno")));}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
