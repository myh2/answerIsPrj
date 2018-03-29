package net.answeris.web.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.Msg;

public class MybatisMainMessageDao implements MessageDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Msg> getRecvMsgLst(String recvMemberID, String[] boolRecvRead, String[] recvDeletePoint,int recordPerPage, int pageNumber) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);
		return messageDao.getRecvMsgLst(recvMemberID, boolRecvRead, recvDeletePoint, recordPerPage, pageNumber);
	}

	@Override
	public String getRecvMsgLstCnt(String recvMemberID, String[] recvDeletePoint, String[] boolRecvRead) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);
		return messageDao.getRecvMsgLstCnt(recvMemberID, recvDeletePoint, boolRecvRead);
	}

	@Override
	public List<Msg> getSentMsgLst(String sentMemberID, String[] sentDeletePoint, int recordPerPage, int pageNumber) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);
		return messageDao.getSentMsgLst(sentMemberID, sentDeletePoint, recordPerPage, pageNumber);
	}

	@Override
	public String getSentMsgLstCnt(String sentMemberID) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);
		return messageDao.getSentMsgLstCnt(sentMemberID);
	}

	@Override
	public Msg getMsg(long code) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);
		return messageDao.getMsg(code);
	}

	@Override
	public int updateReadState(long code, String boolRecvRead) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);

		return messageDao.updateReadState(code, boolRecvRead);

	}

	@Override
	public int writeMsg(String recvMemberID, String sentMemberID, String content) {

		Date sentDate = new Date();
		String boolRecvRead = "N";

		return writeMsg(recvMemberID, sentMemberID, content, sentDate, boolRecvRead);
	}

	@Override
	public int writeMsg(String recvMemberID, String sentMemberID, String content, Date sentDate, String boolRecvRead) {

		Msg msg = new Msg();

		msg.setRecvMemberID(recvMemberID);
		msg.setSentMemberID(sentMemberID);
		msg.setContent(content);
		msg.setSentDate(sentDate);
		msg.setBoolRecvRead(boolRecvRead);

		return writeMsg(msg);
	}

	@Override
	public int writeMsg(Msg msg) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);
		return messageDao.writeMsg(msg);
	}

	@Override
	public Msg getNewMessage(String id) {
		MessageDao messageDao=sqlSession.getMapper(MessageDao.class);
		return messageDao.getNewMessage(id);
	}

	@Override
	public int updateRecvDeletePoint(String code) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);

		return messageDao.updateRecvDeletePoint(code);
	}

	@Override
	public int updateSentDeletePoint(String code) {
		MessageDao messageDao = sqlSession.getMapper(MessageDao.class);

		return messageDao.updateSentDeletePoint(code);
	}
}
