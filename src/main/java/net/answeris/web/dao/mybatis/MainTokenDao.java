package net.answeris.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.MainToken;

public interface MainTokenDao {
	
	
	public MainToken get(String email);
	public MainToken getToken(String token);
	public int add(MainToken mainToken);
	public int update(MainToken mainToken);
}
