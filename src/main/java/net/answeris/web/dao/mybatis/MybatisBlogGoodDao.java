package net.answeris.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.BlogGood;

public class MybatisBlogGoodDao implements BlogGoodDao {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public BlogGood getLike(String BlogCode) {
		// TODO Auto-generated method stub
				BlogGoodDao blogGoodDao=sqlSession.getMapper(BlogGoodDao.class);
				return blogGoodDao.getLike(BlogCode);
	}

}
