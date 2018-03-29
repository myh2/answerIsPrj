package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.BlogGood;
import net.answeris.web.model.BlogHate;
import net.answeris.web.model.ChargeOption;

public interface BlogHateDao {
	public BlogHate getHate(String BlogCode);
}
