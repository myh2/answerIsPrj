package net.answeris.web.model;

import java.util.Date;

public class BlogComment {
	private String code;
	private String content;
	private Date regDate;
	private String memberId;
	private String blogCode;
	private String commentCode;
	
	private String nickname;
		
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	public String getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBlogCode() {
		return blogCode;
	}
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}
	
	
}
