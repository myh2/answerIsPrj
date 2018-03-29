package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Blog;

public class MybatisBlogDao implements BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<Blog> getList(String memberId) {
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.getList(memberId);
	}

	@Override
	public List<Blog> getLists(String memberId) {
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.getLists(memberId);
	}

	@Override
	public List<Blog> getList(int page) {
		// TODO Auto-generated method stub
		return getList(page);
	}
	@Override
	public List<Blog> getList() {
		// TODO Auto-generated method stub
		return getList(1);
	}

	@Override
	public Blog get(String code) {
		// TODO Auto-generated method stub
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.get(code);
	}
	

	

	@Override
	public int update(Blog blog) {
		// TODO Auto-generated method stub
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.update(blog);
	}

	@Override
	public int delete(String code) {
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.delete(code);
	}

	@Override
	public int add(Blog blog) {
		// TODO Auto-generated method stub
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.add(blog);
	}

	@Override
	public int publicSet(String code) {
		// TODO Auto-generated method stub
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		return blogDao.publicSet(code);
	}

	@Override
	public List<Blog> getNextList(String code, String memberId) {
BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		
		return blogDao.getNextList(code,memberId);
	}
	
	@Override
	public List<Blog> getNextLists(String code, String memberId) {
BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		
		return blogDao.getNextLists(code,memberId);
	}
	

	@Override
	public int setLike(String memberId, String blogCode) {
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		
		return blogDao.setLike(memberId, blogCode);
	}

	@Override
	public Blog getLike(String blogCode) {
		BlogDao blogDao=sqlSession.getMapper(BlogDao.class);
		
		return blogDao.getLike( blogCode);
	}

	@Override
	public String getLikeNum(String code) {
		// TODO Auto-generated method stub
		BlogDao blogDao= sqlSession.getMapper(BlogDao.class);
		
		return blogDao.getLikeNum(code);
	}

	
	

}
