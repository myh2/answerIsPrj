package net.answeris.web.model;


// 로그인에서 사용될 모델 - 그런데 Spring Security의 Principal로 대체 가능한 것 아닌가? 확인해보자.
public class MainLogin {
	private String id;				// e-mail ID
	private String password;			// password
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
