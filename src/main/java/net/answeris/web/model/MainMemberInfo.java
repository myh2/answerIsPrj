package net.answeris.web.model;

public class MainMemberInfo {
	// 내 정보 수정에서, 추가 정보 입력을 하는 부분
	// ------------------MemberDetail-----------------------
	// 관심분야 > 관심언어, 관심플랫폼
	// 업무분야 > 대분류(업무분야), 소분류(업무분야)
	// 답변요청 알림
	private String id;				// 회원 ID 			<----- Member.Id
	private String FavoriteLang;	// 관심언어			<----- Language.Code
									// 여러 관심언어들을 선택하여 하나의 문자열로 병합해 사용
									// "#1#2#10" = 관심언어 1 + 관심언어 2 + 관심언어 10
	private String FavoriteLangETC;	// 관심언어(기타)
	private String FavoritePltfm;	// 관심플랫폼		<----- Platform.code
	private String FavoritePltfmETC;// 관심플랫폼(기타)
	private String JobCode;			// 업무분야(대분류) <----- Job.code
	private String JobSubClassText;	// 업무뷴야(소분류)
	private String NotifySetting;	// 답변요청 알림
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFavoriteLang() {
		return FavoriteLang;
	}
	
	public void setFavoriteLang(String favoriteLang) {
		FavoriteLang = favoriteLang;
	}
	
	public String getFavoriteLangETC() {
		return FavoriteLangETC;
	}
	
	public void setFavoriteLangETC(String favoriteLangETC) {
		FavoriteLangETC = favoriteLangETC;
	}
	
	public String getFavoritePltfm() {
		return FavoritePltfm;
	}
	
	public void setFavoritePltfm(String favoritePltfm) {
		FavoritePltfm = favoritePltfm;
	}
	
	public String getFavoritePltfmETC() {
		return FavoritePltfmETC;
	}
	
	public void setFavoritePltfmETC(String favoritePltfmETC) {
		FavoritePltfmETC = favoritePltfmETC;
	}
	
	public String getJobCode() {
		return JobCode;
	}
	
	public void setJobCode(String jobCode) {
		JobCode = jobCode;
	}
	
	public String getJobSubClassText() {
		return JobSubClassText;
	}
	
	public void setJobSubClassText(String jobSubClassText) {
		JobSubClassText = jobSubClassText;
	}
	
	public String getNotifySetting() {
		return NotifySetting;
	}
	
	public void setNotifySetting(String notifySetting) {
		NotifySetting = notifySetting;
	}
}
