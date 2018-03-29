package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Language;

public class MybatisLanguageDao implements LanguageDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Language> getList() {
		LanguageDao languageDao=sqlSession.getMapper(LanguageDao.class);
		return languageDao.getList();
	}

	@Override
	public Language get(String code) {
		LanguageDao languageDao=sqlSession.getMapper(LanguageDao.class);
		return languageDao.get(code);
	}

}
