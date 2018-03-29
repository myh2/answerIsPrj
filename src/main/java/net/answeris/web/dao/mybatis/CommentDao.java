package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.answeris.web.model.BlogComment;

public interface CommentDao {
	
	public List<BlogComment> getList(String code);
	
	public List<BlogComment> getList();
	//�� �󼼺������� ��������
	public BlogComment get(String code);
	
	// ��� ���	
	public int add(String content ,String blogCode, String memberId);
	//���� ���
	public int add(String content ,String blogCode, String memberId,String commentCode);
	//������ �������� ��� �ҷ�����
	public BlogComment getNext(String code);
	//��� ����
	public int update(BlogComment blogComment);
	//��� ����
	public int delete(String code);
	//관리자에 의한 삭제
	public int deleteAdmin(String code);
	//ó�� 5���� �ҷ�����
	public List<BlogComment> initGetList(String code);
}
