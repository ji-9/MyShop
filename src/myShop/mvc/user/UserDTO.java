package myShop.mvc.user;

import java.sql.Timestamp;

public class UserDTO {
	
	private String join;
	private String rating;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_phone;
	private String user_address;
	private Timestamp user_date;
	private String auto;
	private String user_cash;
	
	public String getJoin() {
		return join;
	}
	public void setJoin(String join) {
		this.join = join;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public Timestamp getUser_date() {
		return user_date;
	}
	public void setUser_date(Timestamp user_date) {
		this.user_date = user_date;
	}
	public String getAuto() {
		return auto;
	}
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public String getUser_cash() {
		return user_cash;
	}
	public void setUser_cash(String user_cash) {
		this.user_cash = user_cash;
	}

}


