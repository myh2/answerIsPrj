package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Category;
import net.answeris.web.model.BlogLanguage;

public class MybatisBlogLanguageDao implements BlogLanguageDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BlogLanguage> getList(String memberId) {
		BlogLanguageDao memberLanguageDao = sqlSession.getMapper(BlogLanguageDao.class);
		return memberLanguageDao.getList(memberId);
	}
}
