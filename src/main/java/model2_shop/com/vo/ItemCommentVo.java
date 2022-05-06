package model2_shop.com.vo;

import java.sql.Timestamp;

public class ItemCommentVo {
	private Integer comment_num;
	private String title;
	private String contents;
	private String img;
	private Timestamp post_time;
	private byte delivery_grade;
	private byte item_grade;
	private byte seller_grade;
	private Integer item_num;
	private String member_id;
	private byte state;
	public Integer getComment_num() {
		return comment_num;
	}
	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Timestamp getPost_time() {
		return post_time;
	}
	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
	public byte getDelivery_grade() {
		return delivery_grade;
	}
	public void setDelivery_grade(byte delivery_grade) {
		this.delivery_grade = delivery_grade;
	}
	public byte getItem_grade() {
		return item_grade;
	}
	public void setItem_grade(byte item_grade) {
		this.item_grade = item_grade;
	}
	public byte getSeller_grade() {
		return seller_grade;
	}
	public void setSeller_grade(byte seller_grade) {
		this.seller_grade = seller_grade;
	}
	public Integer getItem_num() {
		return item_num;
	}
	public void setItem_num(Integer item_num) {
		this.item_num = item_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	
}
