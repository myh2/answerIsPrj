package net.answeris.web.dao.mybatis;

import java.util.List;

import net.answeris.web.model.ChargeOption;

public interface ChargeOptionDao {

	public List<ChargeOption> getList(String adminCode);
	public ChargeOption get(String code);

}
