package net.answeris.web.tiles;

import java.util.Map;
import java.security.Principal;
import java.util.List;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.dao.mybatis.LanguageDao;
import net.answeris.web.dao.mybatis.MainMemberDao;
import net.answeris.web.dao.mybatis.PlatformDao;
import net.answeris.web.model.Language;
import net.answeris.web.model.Platform;

public class LayoutHeaderPreparer implements ViewPreparer {

	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private PlatformDao platformDao;
	
	@Autowired
	private MainMemberDao memberDao;
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext){

		Map<String, Object> request = tilesContext.getContext("request");
		
		List<Language> headerlanguage = languageDao.getList();
		List<Platform> headerpaltform = platformDao.getList();
		
		
		
		request.put("headerlanguage", headerlanguage);
		request.put("headerpaltform", headerpaltform);

	}
}