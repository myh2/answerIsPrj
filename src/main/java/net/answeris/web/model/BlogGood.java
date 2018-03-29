package net.answeris.web.model;

public class BlogGood {
	private String MemberId;
	private String BlogCode;
	private String regDate;
	private String likeNum;
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
	public String getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(String likeNum) {
		this.likeNum = likeNum;
	}
	
	

}
