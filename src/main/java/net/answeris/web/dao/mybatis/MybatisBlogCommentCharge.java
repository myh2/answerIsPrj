package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Blog;
import net.answeris.web.model.BlogCommentCharge;

public class MybatisBlogCommentCharge implements BlogCommentChargeDao {

	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public List<BlogCommentCharge> get(String code) {
		
		BlogCommentChargeDao blogCommentChageDao = sqlSession.getMapper(BlogCommentChargeDao.class);

		return blogCommentChageDao.get(code);
	}

	@Override
	public int add(BlogCommentCharge blogCommentCharge) {
		BlogCommentChargeDao blogCommentChageDao = sqlSession.getMapper(BlogCommentChargeDao.class);

		return blogCommentChageDao.add(blogCommentCharge);
	}

	
}
