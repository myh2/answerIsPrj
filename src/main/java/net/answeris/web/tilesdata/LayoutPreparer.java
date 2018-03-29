package net.answeris.web.tilesdata;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.answeris.web.dao.mybatis.CategoryDao;
import net.answeris.web.model.Category;

public class LayoutPreparer implements ViewPreparer{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		//Map<String, Object> request = tilesContext.getContext("request");
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		String str=request.getServletPath();
		
		str=str.substring(1);
		int i=str.indexOf('/');
		str=str.substring(0, i);
		
		System.out.println(str);
		
		List<Category> cList = categoryDao.getList(str);
		//request.put("cList", cList);
		request.setAttribute("cList", cList);
		
	}

}
