package model2_shop.com.vo;

import java.sql.Timestamp;

public class ItemVo {
	private int item_num;     
	private String name;         
	private String title;        
	private int count;        
	private int price;       
	private String color;      
	private String main_img;     
	private String detail_img;   
	private String model_num;    
	private String member_id;    
	private Timestamp post_time;    
	private Timestamp sale_time;    
	private Timestamp sale_end_time;
	private byte state;        
	private int cate_num;
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMain_img() {
		return main_img;
	}
	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	public String getDetail_img() {
		return detail_img;
	}
	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}
	public String getModel_num() {
		return model_num;
	}
	public void setModel_num(String model_num) {
		this.model_num = model_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Timestamp getPost_time() {
		return post_time;
	}
	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
	public Timestamp getSale_time() {
		return sale_time;
	}
	public void setSale_time(Timestamp sale_time) {
		this.sale_time = sale_time;
	}
	public Timestamp getSale_end_time() {
		return sale_end_time;
	}
	public void setSale_end_time(Timestamp sale_end_time) {
		this.sale_end_time = sale_end_time;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public int getCate_num() {
		return cate_num;
	}
	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	@Override
	public String toString() {
		return "{\"item_num\":" + item_num + ", \"name\": \"" + name
				+ "\", \"title\": \"" + title + "\", \"count\": " + count
				+ ", \"price\": " + price + ", \"color\": \"" + color
				+ "\", \"main_img\": \"" + main_img + "\", \"detail_img\": \""
				+ detail_img + "\", \"model_num\": \"" + model_num
				+ "\", \"member_id\": \"" + member_id + "\", \"post_time\": \""
				+ post_time + "\", \"sale_time\": \"" + sale_time
				+ "\", \"sale_end_time\": \"" + sale_end_time
				+ "\", \"state\": " + state + ", \"cate_num\":"
				+ cate_num + "}";
	}     
}
