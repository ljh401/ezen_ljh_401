package model.dao;

import java.sql.Statement;

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
	
	// 2. 제품전체출력
	
	// 3. 제품개별조회
	
	// 4. 제품수정
	
	// 5. 제품삭제
}
