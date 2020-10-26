package order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;


public class OrdersDAO
{
	private static OrdersDAO instance = new OrdersDAO();
	
	public static OrdersDAO getInstance() {
        return instance;
    }
	
    private Connection getConnection() throws Exception 
    {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
        return ds.getConnection();
    }
    public List getOrderList(String userId, int start, int end) throws Exception //내 주문내역 검색
    {
    	String sql="select * "+
 			   "from (select orderNumber, goods_code, buyer, seller, amount, totalPrice, track, orderDate, rownum r " +
 			   "from (select * from orders order by orderDate desc where userId=?) order by orderDate desc) "+
 			   "where r >= ? and r <= ?";
    	List myOrdersList = null;
    	myOrdersList = new ArrayList();
 	try
 	{
 		Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.setInt(2, start);
        pstmt.setInt(3, end);
        ResultSet rs = pstmt.executeQuery();
     	
        if(rs.next())
        {
         	do
         	{
         		OrdersDTO order = new OrdersDTO();
         		order.setOrderNumber(rs.getInt("orderNumber"));
         		order.setGoods_code(rs.getInt("goods_code"));
         		order.setSeller(rs.getString("seller"));
         		order.setBuyer(rs.getString("buyer"));
         		order.setAmount(rs.getInt("amount"));
         		order.setTotalPrice(rs.getInt("totalPrice"));
         		order.setTrack(rs.getString("track"));
         		order.setOrderDate(rs.getTimestamp("orderDate"));
         		myOrdersList.add(order);
         	}while(rs.next());
         }
 	}
 	catch(Exception ex) 
 	{
         ex.printStackTrace();
     }
 	finally
 	{
		closeAll();
 	}
 	return myOrdersList;
    }
	public int getOrderCount(String userId) throws Exception 
	{
		String sql = "select count(*) from board where buyer=?";
		

		int x=0;

		try 
		{
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
			{
				x= rs.getInt(1);
			}
		} 
		catch(Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
		     
		}
				return x;
	}
	public void closeAll()
	{
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	    if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	    if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
}
