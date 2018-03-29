package net.answeris.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.MainMyInfo;

public class MybatisMainMyInfoDao implements MainMyInfoDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public String getPhoto(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getPhoto(id);
	}

	@Override
	public String getPassword(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getPassword(id);
	}

	@Override
	public String getEmail(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getEmail(id);
	}

	@Override
	public String getNickname(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getNickname(id);
	}

	@Override
	public String getBirthday(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getBirthday(id);
	}

	@Override
	public int getExperience(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getExperience(id);
	}

	@Override
	public String getMyLanguage(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getMyLanguage(id);
	}

	@Override
	public String getMyPlatform(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getMyPlatform(id);
	}

	@Override
	public String getMyJobClassMain(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getMyJobClassMain(id);
	}

	@Override
	public String getMyJobClassSub(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getMyJobClassSub(id);
	}

	@Override
	public String getMyBlog(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getMyBlog(id);
	}

	@Override
	public String getMyNotification(String id) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.getMyNotification(id);
	}

	@Override
	public int update(MainMyInfo myInfo) {
		MainMyInfoDao myInfoDao = sqlSession.getMapper(MainMyInfoDao.class);
		return myInfoDao.update(myInfo);
	}



}
