package net.answeris.web.dao.mybatis;

import java.util.List; 

import org.apache.ibatis.annotations.Param;
import net.answeris.web.model.Answer;
import net.answeris.web.model.BlogComment;

public interface AnswerDao {

	public List<Answer> getList(
			@Param("page") int page, String mid);
	
	public List<Answer> getNextList(String count, String mid);
	
	public List<Answer> getList(int page);
	
	public List<Answer> getList();
	
	public List<BlogComment> getAnswerComments(String code);
	
	public Answer get(String code);
	
	public String getPrevBlogCode(String code, String mid);
	
	public String getNextBlogCode(String code, String mid);
	
	public int add(Answer answer);
	
	public int delete(String code);
	
	/*public List<Answer> searchListTitle(@Param("keyword") String keyword, @Param("mid") String mid);*/
	public List<Answer> searchListTitle(String keyword, String mid);
	public List<Answer> searchListContent(String keyword, String mid);
	
	public String getId(String nickname);
	
	public String getQnaCode(String blogCode);
}
