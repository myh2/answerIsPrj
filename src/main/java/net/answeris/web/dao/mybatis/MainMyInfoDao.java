package net.answeris.web.dao.mybatis;

import net.answeris.web.model.MainMyInfo;

public interface MainMyInfoDao {
	
	public String getPhoto(String id);
	public String getPassword(String id);
	public String getEmail(String id);
	public String getNickname(String id);
	public String getBirthday(String id);
	public int getExperience(String id);
	
	public String getMyLanguage(String id);
	public String getMyPlatform(String id);
	public String getMyJobClassMain(String id);
	public String getMyJobClassSub(String id);
	
	public String getMyBlog(String id);
	public String getMyNotification(String id);
	
	public int update(MainMyInfo myInfo);

}
