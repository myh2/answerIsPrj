package net.answeris.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.MainToken;

public class MybatisMainTokenDao implements MainTokenDao{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MainToken get(String email) {
		MainTokenDao mainTokenDao = sqlSession.getMapper(MainTokenDao.class);
		return mainTokenDao.get(email);
	}

	@Override
	public int add(MainToken mainToken) {
		MainTokenDao mainTokenDao = sqlSession.getMapper(MainTokenDao.class);
		return mainTokenDao.add(mainToken);
	}

	@Override
	public int update(MainToken mainToken) {
		MainTokenDao mainTokenDao = sqlSession.getMapper(MainTokenDao.class);
		return mainTokenDao.update(mainToken);
	}

	@Override
	public MainToken getToken(String token) {
		MainTokenDao mainTokenDao = sqlSession.getMapper(MainTokenDao.class);
		return mainTokenDao.getToken(token);
	}

}
