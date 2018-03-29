package net.answeris.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.MainLogin;

public class MybatisMainLoginDao implements MainLoginDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MainLogin get(String emailId) {
		// TODO 
		MainLoginDao mainLoginDao = sqlSession.getMapper(MainLoginDao.class);
		return mainLoginDao.get(emailId);
	}

}
