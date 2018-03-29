package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.Language;

public interface LanguageDao {
	
	public List<Language> getList();
	public Language get(String code);
}
