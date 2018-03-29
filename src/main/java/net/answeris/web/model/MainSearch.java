package net.answeris.web.model;

import java.util.Date;

/*--------------------검색 화면에서 사용될 모델-----------------*/

// 코드릿은 타이틀만
// 블로그 & QnA 타이틀과 컨텐츠
// 공통 : language code + platform code
//        + indicator;블로그인지 QnA인지 코드릿인지 알려주는 indicator
// 검색 키워드

public class MainSearch {
	/*private String searchKeyword;		// 검색키워드
*/	
	/*	private String title;				// 제목
	private String content;				// 내용
	private int langCode;				// 언어 코드
	private int platformCode;			// 플랫폼 코드
	private String hashTag;				// 해쉬 태그
	private Date regDate;				// 등록일자
	private String regMemberId;			// 등록한 유저 ID
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}*/
	private int code;
	private String title;
	private String content;
	private String hashtag;
	private Date regDate;
	private Date modifydate;
	private String memberid;
	private String categorycode;
	private int hit;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
