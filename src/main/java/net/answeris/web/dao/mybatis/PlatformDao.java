package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.Language;
import net.answeris.web.model.Platform;

public interface PlatformDao {
	
	public List<Platform> getList();
	public Platform get(String code);
}
