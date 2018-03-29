package net.answeris.web.model;

import java.util.Date;

public class Blog {
	private String code;
	private String title;
	private String content;
	private String hashtag;
	private Date regDate;
	private Date modifyDate;
	private String memberId;
	private String categoryCode;
	private String languageCode;
	private String platformCode;
	private String publicOption;
	private String likeNum="0";
	private String hateNum="0";
	private String CategoryName;
	private String MemberNickname;
	
	
	public String getHateNum() {
		return hateNum;
	}
	public void setHateNum(String hateNum) {
		this.hateNum = hateNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getPlatformCode() {
		return platformCode;
	}
	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}
	public String getPublicOption() {
		return publicOption;
	}
	public void setPublicOption(String publicOption) {
		this.publicOption = publicOption;
	}
	public String getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(String likeNum) {
		this.likeNum = likeNum;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getMemberNickname() {
		return MemberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		MemberNickname = memberNickname;
	}
			
	
}
