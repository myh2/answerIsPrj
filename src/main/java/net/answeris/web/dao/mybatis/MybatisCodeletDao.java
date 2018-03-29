package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Codelet;

public class MybatisCodeletDao implements CodeletDao {

	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<Codelet> getList(String regMemberId, String sortFlag, String query, String select,String sortSelec) {

		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);

		return codeletDao.getList(regMemberId, sortFlag, query, select ,sortSelec);
	}

	@Override
	public Codelet get(String code) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.get(code);
	}

	@Override
	public int add(Codelet codelet) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.add(codelet);
	}

	@Override
	public int update(Codelet codelet) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.update(codelet);
	}

	@Override
	public int delete(String code) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.delete(code);
	}

	@Override
	public int addFav(String code) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.addFav(code);
	}

	@Override
	public int delFav(String code) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.delFav(code);
	}

	@Override
	public List<Codelet> getLangList(String regMemberId) {

		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);

		return codeletDao.getLangList(regMemberId);
	}

	@Override
	public int updateRec(String code) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.updateRec(code);
	}

	@Override
	public List<Codelet> getFavList() {
	      // TODO Auto-generated method stub
	   CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);

	   return codeletDao.getFavList();

	}

	@Override
	public List<Codelet> getRecList() {
	      // TODO Auto-generated method stub

	   CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);

	   return codeletDao.getRecList();

	 }

	@Override
	public List<Codelet> getHashTags(String userFlag, String ht, String regMemberId) {
		CodeletDao codeletDao = sqlSession.getMapper(CodeletDao.class);
		return codeletDao.getHashTags(userFlag, ht, regMemberId);
	}
}
