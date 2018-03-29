package net.answeris.web.model;

public class BlogHate {
	private String MemberId;
	private String BlogCode;
	private String regDate;
	private String hateNum;
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getBlogCode() {
		return BlogCode;
	}
	public void setBlogCode(String blogCode) {
		BlogCode = blogCode;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getHateNum() {
		return hateNum;
	}
	public void setHateNum(String hateNum) {
		this.hateNum = hateNum;
	}
	
	

}
