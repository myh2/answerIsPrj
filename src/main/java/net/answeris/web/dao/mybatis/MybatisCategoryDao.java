package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Category;

public class MybatisCategoryDao implements CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Category get(String code) {
		CategoryDao categoryDao=sqlSession.getMapper(CategoryDao.class);
		return categoryDao.get(code);
	}

	@Override
	public List<Category> getList(String memberId) {
		CategoryDao categoryDao=sqlSession.getMapper(CategoryDao.class);
		return categoryDao.getList(memberId);
	}
	@Override
	public int add(Category category) {
		CategoryDao categoryDao=sqlSession.getMapper(CategoryDao.class);
		return categoryDao.add(category);
	}

}
