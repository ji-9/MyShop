package myShop.board;

import java.sql.*;

import java.util.*; 
import javax.sql.*; 
import javax.naming.*;

import myShop.board.DataBaseConnection;


public class MyShopDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	
/// 1.데이터 세기
	public int getAlbumCount() {
		int totalAlbumCount = 0;
		
		try {
			conn = DataBaseConnection.getConnection();
			
			String sql = "select count(*) from MyShopgoods";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				totalAlbumCount = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return totalAlbumCount;
	}
	

		
//2. 파일데이터 전체조회
	public List getAlbums(int start, int end) {
		List albumList=null;
		try {
			conn = DataBaseConnection.getConnection();
			
			String sql;
			sql = "select goods_code, goods_img, goods_name, goods_price, rownum from (select * from MyShopGoods order by goods_code desc) where rownum>=? and rownum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				albumList = new ArrayList(end);
				do {
					MyShopDTO dto = new MyShopDTO();
					dto.setGoods_code(rs.getInt("goods_code"));
					dto.setGoods_img(rs.getString("goods_img"));
					dto.setGoods_name(rs.getString("goods_name"));
					dto.setGoods_price(rs.getString("goods_price"));
					
					albumList.add(dto);
				
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}	
		return albumList;
	}

/*	//상품
	public void insertProduct(MyShopDTO dto) {
		
		try {
			int num=dto.getNum();
			int ref=dto.getRef();
			int re_step=dto.getRe_step();
			int re_level=dto.getRe_level();
			int number=0;
			String sql;
			pstmt = conn.prepareStatement("select max(num) from myshopBoard");
			rs = pstmt.executeQuery();
				
			if (rs.next())
				number=rs.getInt(1)+1;
			else
				number=1; 
			   
			if (num!=0)   
		   {  
				sql="update board set re_step=re_step+1 where ref= ? and re_step> ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step=re_step+1;
				re_level=re_level+1;
		   }else{
			    ref=number;
				re_step=0;
				re_level=0;
		   }	 
		    	 
		}catch(Exception e) {
		e.printStackTrace();	
		}finally {
			closeAll();
		}	
		
	} 

	
	
//파일데이터입력	
	public void insertData(MyShopDTO dto) {
			
		try {
			conn = DataBaseConnection.getConnection();
			String sql;
			sql = "insert into myshopTest(num,image, subject,price values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2,dto.getImage());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4,dto.getPrice());
				
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}		
//특정 데이터 조회
	public MyShopDTO getReadData(int num) {
		MyShopDTO dto = null;
		
		
		try {
			conn = DataBaseConnection.getConnection();
			String sql;
			sql = "select num,image, subject,price from myshopTest where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num); 
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MyShopDTO();
				dto.setNum(rs.getInt("num"));
				dto.setImage(rs.getString("image"));
				dto.setSubject(rs.getString("subject"));
				dto.setPrice(rs.getString("price"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return dto;
		}
			
//레코드번호	
	public int getMaxNum() {
		int maxNum = 0;
		
		try {
			conn = DataBaseConnection.getConnection();
			String sql;
			sql="select max(num),0 from myshopTest";
				
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		closeAll();
		}
		return maxNum;
		}
*/	
	
	
	private void closeAll() {
		if(rs != null) {try {rs.close();}catch(SQLException s) {} }
		if(pstmt != null) {try{pstmt.close();}catch(SQLException s) {} }
		if(conn != null) {try{conn.close();}catch(SQLException s) {} }
	}

}
