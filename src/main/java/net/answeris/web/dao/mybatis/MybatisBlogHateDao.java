package net.answeris.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.BlogGood;
import net.answeris.web.model.BlogHate;

public class MybatisBlogHateDao implements BlogHateDao {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public BlogHate getHate(String BlogCode) {
		// TODO Auto-generated method stub
				BlogHateDao blogGoodDao=sqlSession.getMapper(BlogHateDao.class);
				return blogGoodDao.getHate(BlogCode);
	}

}
