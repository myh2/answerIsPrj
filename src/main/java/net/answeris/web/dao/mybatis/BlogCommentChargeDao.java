package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.BlogCommentCharge;

public interface BlogCommentChargeDao {

	public List<BlogCommentCharge> get(String code);
	public int add(BlogCommentCharge blogCommentCharge);
	
}
