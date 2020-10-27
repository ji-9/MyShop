package myshop.order;
import java.sql.Timestamp;

public class OrderDTO 
{
	private int order_number;
	private int goods_code;
	private String buyer;
	private String seller;
	private int amount;
	private int total_price;
	private String track;
	private Timestamp order_date;
	
	public void setOrderNumber(int orderNumber)
	{
		this.order_number = orderNumber;
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
		this.total_price=totalPrice;
	}
	public void setTrack(String track)
	{
		this.track = track;
	}
	public void setOrderDate(Timestamp orderDate)
	{
		this.order_date=orderDate;
	}
	
	
	public int getOrder_number()
	{
		return order_number;
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
	public int getTotal_price()
	{
		return total_price;
	}
	public String getTrack()
	{
		return track;
	}
	public Timestamp getOrder_date()
	{
		return order_date;
	}
	
}
