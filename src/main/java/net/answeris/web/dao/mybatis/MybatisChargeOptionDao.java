package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.ChargeOption;

public class MybatisChargeOptionDao implements ChargeOptionDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ChargeOption> getList(String adminCode) {
		ChargeOptionDao chargeOptionDao=sqlSession.getMapper(ChargeOptionDao.class);
		return chargeOptionDao.getList(adminCode);
	}

	@Override
	public ChargeOption get(String code) {
		ChargeOptionDao chargeOptionDao=sqlSession.getMapper(ChargeOptionDao.class);
		return chargeOptionDao.get(code);
	}


}
