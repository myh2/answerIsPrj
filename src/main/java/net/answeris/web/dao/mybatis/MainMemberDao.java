package net.answeris.web.dao.mybatis;

import net.answeris.web.model.MainMember;

public interface MainMemberDao {
	public MainMember getId(String id);
	public MainMember getNickName(String nickName);
	public MainMember getEmail(String email);
	
	public MainMember findId(String name);
	public MainMember findPassword(String id);
	
	public int checkEmail(String email);
	public int checkId(String id);
	public int checkNickName(String nickName);
	
	public int add(MainMember member);			
	public int update(MainMember member);		
	public int withdraw(String emailId);
	public int updatePwd(String Id, String password);
	
	
	
	
	
}