package myshop.cart;
import java.sql.Timestamp;

public class CartDTO {
	
	private String user_id;
	private int goods_code;
	private String goods_name;
	private int amount;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(int goods_code) {
		this.goods_code = goods_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
	
	