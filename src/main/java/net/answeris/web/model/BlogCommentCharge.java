package net.answeris.web.model;

import java.util.Date;

public class BlogCommentCharge {
	private String code = "";
	private String chargeOption = "";
	private Date regDate = null;
	private String memberId = "";
	private String detailReason = "";
	private String commentCode="";
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getChargeOption() {
		return chargeOption;
	}
	public void setChargeOption(String chargeOption) {
		this.chargeOption = chargeOption;
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
	
	public String getDetailReason() {
		return detailReason;
	}
	public void setDetailReason(String detailReason) {
		this.detailReason = detailReason;
	}
	public String getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}
	
}
