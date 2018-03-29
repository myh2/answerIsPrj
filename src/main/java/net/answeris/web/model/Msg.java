package net.answeris.web.model;

import java.util.Date;

// 쪽지

public class Msg {
	private long code;				// 
	private String recvMemberID; 	// 쪽지 받을 사람의 ID
	private String sentMemberID; 	// 쪽지 보낸 사람의 ID
	private String title;			// 쪽지의 제목
	private String content;			// 쪽지의 내용
	private Date   sentDate;		// 쪽지 발송 일시
	private Date   readDate;		// 쪽지 수신 일시
	private String boolRecvRead;	// 수신자가 쪽지를 읽었는지 여부.    읽음:"Y" 읽지않음:"N"`
	private int newCount;
	private String recvDeletePoint; // 받은쪽지함 삭제 여부			초기값:"N" 삭제값:"Y"
	private String sentDeletePoint; // 보낸쪽지함 삭제 여부			초기값:"N" 삭제값:"Y"
	
	public int getNewCount() {
		return newCount;
	}
	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getRecvMemberID() {
		return recvMemberID;
	}
	public void setRecvMemberID(String recvMemberID) {
		this.recvMemberID = recvMemberID;
	}
	public String getSentMemberID() {
		return sentMemberID;
	}
	public void setSentMemberID(String sentMemberID) {
		this.sentMemberID = sentMemberID;
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
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	public String getBoolRecvRead() {
		return boolRecvRead;
	}
	public void setBoolRecvRead(String boolRecvRead) {
		this.boolRecvRead = boolRecvRead;
	}
	public String getRecvDeletePoint() {
		return recvDeletePoint;
	}
	public void setRecvDeletePoint(String recvDeletePoint) {
		this.recvDeletePoint = recvDeletePoint;
	}
	public String getSentDeletePoint() {
		return sentDeletePoint;
	}
	public void setSentDeletePoint(String sentDeletePoint) {
		this.sentDeletePoint = sentDeletePoint;
	}
	
	

}
