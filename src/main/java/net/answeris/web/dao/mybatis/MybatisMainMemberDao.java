package net.answeris.web.dao.mybatis;

/*import java.util.List;*/

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.MainMember;

public class MybatisMainMemberDao implements MainMemberDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MainMember getId(String id) {
		// TODO �듅�젙 �궎�썙�뱶(e.g. email-id, id)瑜� �넻�빐 �쉶�썝 �젙蹂대�� get�븯�뒗 硫붿냼�뱶
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.getId(id);
	}

	public MainMember getNickName(String nickName) {
		// TODO �듅�젙 �궎�썙�뱶(e.g. email-id, id)瑜� �넻�빐 �쉶�썝 �젙蹂대�� get�븯�뒗 硫붿냼�뱶
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.getNickName(nickName);
	}

	public MainMember getEmail(String email) {
		// TODO �듅�젙 �궎�썙�뱶(e.g. email-id, id)瑜� �넻�빐 �쉶�썝 �젙蹂대�� get�븯�뒗 硫붿냼�뱶
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.getId(email);
	}

	@Override
	public int add(MainMember member) {
		// TODO �쉶�썝�젙蹂대�� �뜲�씠�꽣踰좎씠�뒪�뿉 add�븯�뒗 硫붿냼�뱶
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.add(member);
	}

	@Override
	public int update(MainMember member) {
		// TODO �뜲�씠�꽣踰좎씠�뒪�쓽 �쉶�썝�젙蹂대�� update�븯�뒗 硫붿냼�뱶
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.update(member);
	}

	@Override
	public int withdraw(String emailId) {
		// TODO �듅�젙 �궎�썙�뱶(e.g. email-id, id)瑜� �넻�빐 �쉶�썝 �젙蹂대�� delete�븯�뒗
		// 硫붿냼�뱶
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.withdraw(emailId);
	}

	@Override
	public int checkEmail(String email) {
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.checkEmail(email);
	}

	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.checkId(id);
	}

	@Override
	public int checkNickName(String nickName) {
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.checkNickName(nickName);
	}

	@Override
	public MainMember findId(String name) {
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.findId(name);
	}

	@Override
	public MainMember findPassword(String id) {
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.findPassword(id);
	}

	@Override
	public int updatePwd(String Id, String password) {
		MainMemberDao mainMemberDao = sqlSession.getMapper(MainMemberDao.class);
		return mainMemberDao.updatePwd(Id, password);
	}

}
