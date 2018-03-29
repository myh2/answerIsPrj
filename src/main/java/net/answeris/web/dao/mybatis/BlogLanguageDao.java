package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.BlogLanguage;

public interface BlogLanguageDao {
	public List<BlogLanguage> getList(String memberId);
}
