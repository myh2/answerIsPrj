package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import net.answeris.web.model.Blog;



public interface BlogDao {
	
	//��α� ��� �ҷ�����
	public List<Blog> getList(
			@Param("memberId") String memberId);
	public List<Blog> getLists(
			@Param("memberId") String memberId);
	public List<Blog> getList(int page);
	
	public List<Blog> getList();

	//�� �󼼺������� ��������
	public Blog get(String code);
	//��α� �� ���
	public int add(Blog blog);
	//������ �������� ����� �ҷ�����
	public List<Blog> getNextList(String code,String memberId);
	public List<Blog> getNextLists(String code,String memberId);
	//��αױ� ����
	public int update(Blog blog);
	//��αױ� ����
	public int delete(String code);
	
	//��������
	   public int publicSet(String code);
	   
	public int setLike(String memberId, String blogCode);
	
	public Blog getLike(String blogCode);
	
	public String getLikeNum(String code);
	

}
