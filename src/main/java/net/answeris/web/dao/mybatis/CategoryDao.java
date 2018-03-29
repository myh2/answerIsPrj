package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.Category;

public interface CategoryDao {

	public List<Category> getList(String memberId);
	public Category get(String code);
	public int add(Category category);

}
