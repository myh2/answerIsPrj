package net.answeris.web.model;

public class MainMemberInfo {
	// �� ���� ��������, �߰� ���� �Է��� �ϴ� �κ�
	// ------------------MemberDetail-----------------------
	// ���ɺо� > ���ɾ��, �����÷���
	// �����о� > ��з�(�����о�), �Һз�(�����о�)
	// �亯��û �˸�
	private String id;				// ȸ�� ID 			<----- Member.Id
	private String FavoriteLang;	// ���ɾ��			<----- Language.Code
									// ���� ���ɾ����� �����Ͽ� �ϳ��� ���ڿ��� ������ ���
									// "#1#2#10" = ���ɾ�� 1 + ���ɾ�� 2 + ���ɾ�� 10
	private String FavoriteLangETC;	// ���ɾ��(��Ÿ)
	private String FavoritePltfm;	// �����÷���		<----- Platform.code
	private String FavoritePltfmETC;// �����÷���(��Ÿ)
	private String JobCode;			// �����о�(��з�) <----- Job.code
	private String JobSubClassText;	// �������(�Һз�)
	private String NotifySetting;	// �亯��û �˸�
	
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
