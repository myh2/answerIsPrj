package net.answeris.web.dao.mybatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import net.answeris.web.model.Msg;

public interface MessageDao {
	//------------- 쪽지 리스트
	/* ------- 받은 쪽지 리스트 파라메터
	 * recvMemberID : 수신자 ID (기본값 : 없음)
	 * boolRecvRead : 수신자가 읽은 쪽지들도 리스트에 포함시킬 것인가? 
	 * 			     {"Y","N"} 읽은 것, 안 읽은 것 모두 리스트에 포함시킨다
	 * 			     {"N"} 안 읽은 쪽지들만 리스트에 포함시킨다
	 * 			     {"Y"} 읽은 쪽지들만 리스트에 포함시킨다
	 * 			     (기본값 : {"Y","N"}
	 * boolRecvDel  : 수신자가 삭제한 쪽지들도 리스트에 포함시킬 것인가
	 *                {"Y","N"} 삭제한 것, 삭제하지 않은 것 모두 리스트에 포함시킨다
	 *                {"N"} 삭제하지 않은 것만 리스트에 포함시킨다
	 *                {"Y"} 삭제한 것만 리스트에 포함시킨다
	 *                (기본값 : {"N"})
	 * boolRecvSave : 수신자가 저장한 쪽지들 여부
	 *                {"Y"} 저장한 것
	 *                {"N"} 저장하지 않은 것
	 *                {"Y", "N"} 저장한 것, 저장하지 않은 것 모두
	 *                (기본값 : {"Y", "N"})
	 * recordsPerPage: 한 페이지당 출력할 레코드 수(기본값:10)
	 * pageNumber   : 출력할 페이지 수(기본값:1)
	 * ------- 보낸 쪽지 리스트 파라메터
	 * sentMemberID : 발신인 ID (기본값 : 없음)
	 * boolSentDel  : 발신자가 삭제한 쪽지들도 리스트에 포함시킬 것인가
	 *                {"Y","N"} 삭제한 것, 삭제하지 않은 것 모두 리스트에 포함시킨다
	 *                {"N"} 삭제하지 않은 것만 리스트에 포함시킨다
	 *                {"Y"} 삭제한 것만 리스트에 포함시킨다
	 *                (기본값 : {"N"})
	 * boolSentSave : 발신자가 저장한 쪽지들 여부
	 *                {"Y"} 저장한 것
	 *                {"N"} 저장하지 않은 것
	 *                {"Y", "N"} 저장한 것, 저장하지 않은 것 모두
	 *                (기본값 : {"Y", "N"})
	 * recordsPerPage: 한 페이지당 출력할 레코드 수(기본값:10)
	 * pageNumber   : 출력할 페이지 수(기본값:1) */
	
	public List<Msg> getRecvMsgLst(@Param("recvMemberID") String recvMemberID, 
								   @Param("boolRecvRead") String[] boolRecvRead, 
								   @Param("recvDeletePoint") String[] recvDeletePoint,
								   @Param("RecordsPerPage") int recordPerPage,
								   @Param("PageNumber") int pageNumber);
	public String getRecvMsgLstCnt(@Param("recvMemberID") String recvMemberID, // 총 쪽지 갯수(주어진 조건에 따른)
									@Param("recvDeletePoint") String[] recvDeletePoint,
			   						  @Param("boolRecvRead") String[] boolRecvRead);
	

	public List<Msg> getSentMsgLst(@Param("sentMemberID") String sentMemberID,
								   @Param("sentDeletePoint") String[] recvDeletePoint,
								   @Param("RecordsPerPage") int recordPerPage,
								   @Param("PageNumber") int pageNumber);
	
	public String getSentMsgLstCnt(@Param("sentMemberID") String sentMemberID); // 총 쪽지 갯수(주어진 조건에 따른) 
	//------------- 쪽지 가져오기
	/* ------- 쪽지 가져오기 파라메터 
	 * code : 쪽지 코드 */
	public Msg getMsg(@Param("code") long code);
	
	//------------- 쪽지 보내기
	/* ------- 쪽지 보내기 파라메터 
	 * msg          : msg 객체 (net.answeris.web.model.Msg)
	 * recvMemberID : 수신자 ID
	 * sentMemberID : 발신자 ID
	 * title        : 쪽지 제목 (최대 255자, nvarchar(MAX))
	 * content      : 쪽지 내용 (최대 2,147,483,647자, text)
	 * sentDate     : 발신 일시 (기본값 : 서버의 현재 시각)
	 * boolRecvRead : 수신자가 읽었는지 여부 (기본값 : "N")
	 * boolRecvDel  : 수신자가 삭제하였는지 여부 (기본값 : "N")
	 * boolRecvSave : 수신자가 저장하였는지 여부 (기본값 : "N")
	 * boolSentDel  : 발신자가 삭제하였는지 여부 (기본값 : "N")
	 * boolSentSave : 발신자가 저장하였는지 여부 (기본값 : "N")*/
	public int writeMsg(String recvMemberID, String sentMemberID, String content);
	public int writeMsg(String recvMemberID, String sentMemberID, String content,
						Date sentDate, String boolRecvRead);
	public int writeMsg(Msg msg);
	
	//------------- 쪽지 상태(읽음 여부, 삭제 여부) 업데이트
	/* ------- 쪽지 업데이트 파라메터 
	 * code         : 쪽지 코드
	 * boolRecvRead : 수신자가 읽었는지 여부 (기본값 : "N")
	 * boolRecvDel  : 수신자가 삭제하였는지 여부 (기본값 : "N")
	 * boolRecvSave : 수신자가 저장하였는지 여부 (기본값 : "N")
	 * boolSentDel  : 발신자가 삭제하였는지 여부 (기본값 : "N")
	 * boolSentSave : 발신자가 저장하였는지 여부 (기본값 : "N")
	 * readDate     : 수신자가 쪽지를 읽은 일시 (기본값 : 서버의 현재 시각)*/
	public int updateReadState(long code, String boolRecvRead);		        // 수신자가 읽었는지 여부를 update

	public int updateRecvDeletePoint(@Param("code") String c);	
	
	public int updateSentDeletePoint(@Param("code") String c);
	
	public Msg getNewMessage(String Id);
	
}
