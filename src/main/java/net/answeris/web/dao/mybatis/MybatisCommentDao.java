package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Blog;
import net.answeris.web.model.BlogComment;

public class MybatisCommentDao implements CommentDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BlogComment> getList(String code) {
		// TODO Auto-generated method stub
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		
		return commentDao.getList(code);
	
	}

	@Override
	public List<BlogComment> getList() {
		// TODO Auto-generated method stub
		
		return getList("2");
	}

	@Override
	public BlogComment get(String code) {
		// TODO Auto-generated method stub
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.get(code);
	}
	@Override
	public BlogComment getNext(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BlogComment blogComment) {
		// TODO Auto-generated method stub
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.update(blogComment);
	}
	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.delete(code);
	}
	@Override
	public int deleteAdmin(String code) {
		// TODO Auto-generated method stub
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.deleteAdmin(code);
	}

	@Override
	public int add(String content, String blogCode, String memberId) {
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.add(content, blogCode, memberId);
	}

	@Override
	public int add(String content, String blogCode, String memberId, String commentCode) {
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.add(content, blogCode, memberId,commentCode);
	}

	@Override
	public List<BlogComment> initGetList(String code) {
		// TODO Auto-generated method stub
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		
		return commentDao.initGetList(code);
	}

}
