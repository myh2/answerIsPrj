package net.answeris.web.model;

import java.util.Date;

public class Answer {
	
	private int code = 0;
	private int like = 0;
	private int hate = 0;
	private boolean select = false;
	private int blogCode = 0;
	private int questionCode = 0;
	private String title = "";
	private String nickname = "";
	private Date regDate = null;
	private String content = "";
	private String hashTag = "";
	private int hit=0;
	
	

	public int getBlogCode() {
		return blogCode;
	}
	public void setBlogCode(int blogCode) {
		this.blogCode = blogCode;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getHate() {
		return hate;
	}
	public void setHate(int hate) {
		this.hate = hate;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public int getPublicBlogCode() {
		return blogCode;
	}
	public void setPublicBlogCode(int publicBlogCode) {
		this.blogCode = publicBlogCode;
	}
	public int getQuestionCode() {
		return questionCode;
	}
	public void setQuestionCode(int questionCode) {
		this.questionCode = questionCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	
	
}
