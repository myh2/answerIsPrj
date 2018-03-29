package net.answeris.web.model;

// �쉶�썝媛��엯 諛� �궡 �젙蹂� �닔�젙�벑�뿉�꽌 �궗�슜�븷 紐⑤뜽
public class MainMember {
	private String 		id;					// id
	private String		password;			// password
	private String		email;				// email
	private String		name;				// name
	private	String		birthDay;			// birth date
	private String		nickName;			// nickname
	private int		experience;			// experience ?? �뼱�뼡 �냽�꽦�씠吏�?
	
	
	
	
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	}
