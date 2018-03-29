package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.answeris.web.model.Answer;
import net.answeris.web.model.BlogComment;
import net.answeris.web.model.Question;

public interface QuestionDao {

	public List<Question> getList(
			@Param("page") int page, String mid);
	
	public List<Question> getNextList(String count, String mid);
	
	public List<Question> getList(int page);
	
	public List<Question> getList();
	
	public List<BlogComment> getQuestionComments(String code);    /*question-board-comments �ҷ��� ���� ���� ����ϴ� �Լ�*/
	
	public Question getQuest(String code);
	
	public Question getAns(int code);
	
	public Question getPrev(String code);
	
	public Question getNext(String code);
	
	public int add(Question question);
	
	public int delete(String code);
	
	public List<Question> searchListTitle(String keyword, String mid);

	public List<Question> searchListContent(String keyword, String mid);

	public String getId(String nickname);
	
/*	===============================question-board===================================*/
	
	public List<Question> getBoardList(
			@Param("page") int page);
	
	public List<Question> getBoardList();

	public List<Question> searchBoardTitle(String keyword, String mid);

	public List<Question> searchBoardContent(String keyword, String mid);
	
	public Question getQuestion(String code);
	
	public Question getPrevQuestion(String code);
	
	public Question getNextQuestion(String code);
}
