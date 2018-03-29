package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Answer;
import net.answeris.web.model.BlogComment;

public class MybatisAnswerDao implements AnswerDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Answer> getList( int page, String mid) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getList(page, mid);
	}
	
	@Override
	public List<Answer> getNextList(String count, String mid) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getNextList(count, mid);
	}

	@Override
	public List<Answer> getList(int page) {
		
		return getList(page);
	}

	@Override
	public List<Answer> getList() {
		return getList(1);
	}
	
	@Override
	public List<BlogComment> getAnswerComments(String code) {                    /* question-board-comments �ҷ��ö� ���� ���� �Լ�*/
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getAnswerComments(code);
	}

	@Override
	public Answer get(String code) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.get(code);
	}

	@Override
	public String getPrevBlogCode(String code, String mid) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getPrevBlogCode(code,mid);
	}

	@Override
	public String getNextBlogCode(String code,String mid) {	
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getNextBlogCode(code,mid);
	}

	@Override
	public int add(Answer answer) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.add(answer);
	}

	@Override
	public int delete(String code) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.delete(code);
	}

	@Override
	public List<Answer> searchListTitle(String keyword, String mid) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.searchListTitle(keyword, mid);
	}

	@Override
	public List<Answer> searchListContent(String keyword, String mid) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.searchListContent(keyword, mid);
	}

	@Override
	public String getId(String nickname) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getId(nickname);
	}

	@Override
	public String getQnaCode(String blogCode) {
		AnswerDao answerDao = sqlSession.getMapper(AnswerDao.class);
		return answerDao.getQnaCode(blogCode);
	}

}
