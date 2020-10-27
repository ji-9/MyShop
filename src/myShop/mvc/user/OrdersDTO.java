package myShop.mvc.user;
import java.sql.Timestamp;

public class OrdersDTO 
{
	private int orderNumber;
	private int goods_code;
	private String buyer;
	private String seller;
	private int amount;
	private int totalPrice;
	private String track;
	private Timestamp orderDate;
	
	public void setOrderNumber(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	public void setGoods_code(int goods_code)
	{
		this.goods_code=goods_code;
	}
	public void setBuyer(String buyer)
	{
		this.buyer=buyer;
	}
	public void setSeller(String seller)
	{
		this.seller=seller;
	}
	public void setAmount(int amount)
	{
		this.amount=amount;
	}
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice=totalPrice;
	}
	public void setTrack(String track)
	{
		this.track = track;
	}
	public void setOrderDate(Timestamp orderDate)
	{
		this.orderDate=orderDate;
	}
	
	
	public int getOrderNumber()
	{
		return orderNumber;
	}
	public int getGoods_code()
	{
		return goods_code;
	}
	public String getBuyer()
	{
		return buyer;
	}
	public String getSeller()
	{
		return seller;
	}
	public int getAmount()
	{
		return amount;
	}
	public int getTotalPrice()
	{
		return totalPrice;
	}
	public String getTrack()
	{
		return track;
	}
	public Timestamp getOrderDate()
	{
		return orderDate;
	}
	
}
