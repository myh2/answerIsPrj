package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Platform;

public class MybatisPlatformDao implements PlatformDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Platform> getList() {
		PlatformDao platformDao=sqlSession.getMapper(PlatformDao.class);
		return platformDao.getList();
	}

	@Override
	public Platform get(String code) {
		PlatformDao platformDao=sqlSession.getMapper(PlatformDao.class);
		return platformDao.get(code);
	}

}
