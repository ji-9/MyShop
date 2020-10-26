package myshop.board;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class myshopDAO {
	
private static myshopDAO instance = new myshopDAO();
    
    public static myshopDAO getInstance() {
        return instance;
    }
    
    private myshopDAO() {
    }
    
    private Connection getConnection() throws Exception {
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
      return ds.getConnection();
    }

    public void insertProduct(myshopDTO product) throws Exception
    {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "insert into MyShopGoods values(Goods.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getGoods_name());
			pstmt.setInt(2, product.getGoods_price());
			pstmt.setInt(3, product.getGoods_state());
			pstmt.setString(4, product.getGoods_img());
			pstmt.setString(5, product.getGoods_txt());

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)	try { rs.close(); } catch (SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
			if (conn != null) try {	conn.close(); } catch (SQLException ex) {}
		}
		
    }

    public String getCode2Name(int code) throws Exception
    {
       String getStr = null;
       Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       try
       {
         String sql = "select goods_name from MyShopGoods where goods_code = ?";
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, code);
         rs = pstmt.executeQuery();
         if( rs.next() )
        	 getStr = rs.getString(1);
       }
       catch (Exception ex) 
       {
         ex.printStackTrace();
       }
       finally
       {
          if (rs != null)   try { rs.close(); } catch (SQLException ex) {}
         if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
         if (conn != null) try {   conn.close(); } catch (SQLException ex) {}
       }
       
       return getStr;
    }
}
