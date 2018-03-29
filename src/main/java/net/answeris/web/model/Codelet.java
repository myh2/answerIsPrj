package net.answeris.web.model;

import java.util.Date;

public class Codelet {
	
	private String code;
	private String title;
	private String codeSrc;
	private String favorite;
	private Date recent;
	private String languageCode;
	private String hashTag;
	private String platformCode;
	private String regMemberId;
	private Date regDate;
	private int hit;
	
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
	public String getCodeSrc() {
		return codeSrc;
	}
	public void setCodeSrc(String codeSrc) {
		this.codeSrc = codeSrc;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public Date getRecent() {
		return recent;
	}
	public void setRecent(Date recent) {
		this.recent = recent;
	}
	
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public String getPlatformCode() {
		return platformCode;
	}
	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}
	public String getRegMemberId() {
		return regMemberId;
	}
	public void setRegMemberId(String regMemberId) {
		this.regMemberId = regMemberId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}	
	
}
