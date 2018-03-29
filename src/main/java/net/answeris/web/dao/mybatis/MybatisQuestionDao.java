package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Answer;
import net.answeris.web.model.BlogComment;
import net.answeris.web.model.Question;

public class MybatisQuestionDao implements QuestionDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Question> getList(int page, String mid) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getList(page, mid);
	}

	@Override
	public List<Question> getNextList(String count, String mid) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getNextList(count, mid);
	}

	@Override
	public List<Question> getList(int page) {
		// TODO Auto-generated method stub
		return getList(page);
	}

	@Override
	public List<Question> getList() {
		return getList(1);
	}
	
	@Override
	public List<BlogComment> getQuestionComments(String code) {   					/* question-board-comments �ҷ��ö� ���� ���� �Լ�*/
		
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getQuestionComments(code);
	}


	@Override
	public Question getQuest(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getQuest(code);
	}

	@Override
	public Question getAns(int code) {
		QuestionDao questionDao= sqlSession.getMapper(QuestionDao.class);
		return questionDao.getAns(code);
	}
	

	@Override
	public Question getPrev(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getPrev(code);
	}

	@Override
	public Question getNext(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getNext(code);
	}

	@Override
	public int add(Question question) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.add(question);
	}

	@Override
	public int delete(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.delete(code);
	}
	
	@Override
	public List<Question> searchListTitle(String keyword, String mid) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.searchListTitle(keyword, mid);
	}
	
	@Override
	public List<Question> searchListContent(String keyword, String mid) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.searchListTitle(keyword, mid);
	}

	
	@Override
	public String getId(String nickname) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getId(nickname);
	}
/*===================================question-board========================================*/	
	
	@Override
	public List<Question> getBoardList(int page) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getBoardList(page);
	}

	@Override
	public List<Question> getBoardList() {
		
		return getBoardList(1);
	}
	
	
	@Override
	public List<Question> searchBoardTitle(String keyword, String mid) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.searchBoardTitle(keyword, mid);
	}

	@Override
	public List<Question> searchBoardContent(String keyword, String mid) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.searchBoardContent(keyword, mid);
	}


	@Override
	public Question getQuestion(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getQuestion(code);
	}

	@Override
	public Question getPrevQuestion(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getPrevQuestion(code);
	}

	@Override
	public Question getNextQuestion(String code) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.getNextQuestion(code);
	}








}
