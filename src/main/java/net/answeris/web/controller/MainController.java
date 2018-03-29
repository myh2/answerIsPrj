package net.answeris.web.controller;

import java.security.Principal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.xml.internal.security.keys.content.DEREncodedKeyValue;

import net.answeris.web.controller.mail.MailService;
import net.answeris.web.dao.mybatis.MainMemberDao;
import net.answeris.web.dao.mybatis.MainMyInfoDao;
import net.answeris.web.dao.mybatis.MainTokenDao;
import net.answeris.web.dao.mybatis.MessageDao;
import net.answeris.web.model.MainMember;
import net.answeris.web.model.MainMyInfo;
import net.answeris.web.model.MainToken;
import net.answeris.web.model.Msg;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	MainMemberDao memberDao;

	@Autowired
	MainTokenDao tokenDao;

	@Autowired
	MainMyInfoDao myInfoDao;

	@Autowired
	MailService mailService;

	@Autowired
	MessageDao messageDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login/sign-up", method = RequestMethod.GET)
	public String signUp() {
		return "main.login.sign-up";
	}

	@RequestMapping(value = "/login/find-id", method = RequestMethod.GET)
	public String findId() {
		return "main.login.find-id";
	}

	// email 인증 토큰을 생성하고 DB에 저장. 그 외에 인증메일 발송을 수행하는 메소드
	@RequestMapping(value = "/login/sign-up-email-token", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String createEmailToken(String email) {
		// 이메일 인증 토큰을 생성,
		// 이메일 토큰으로는 일단 8자리 난수를 사용한다.

		Random random = new Random();

		String token = "";
		for (int i = 0; i < 8; i++) {
			token += random.nextInt(10);
		}

		// 만들어진 토큰을 데이터베이스에 저장하는 부분 (DB 생성완료 - 테이블명 : EmailVerify)
		MainToken mainToken = new MainToken();
		mainToken.setEmail(email);
		mainToken.setToken(token);
		mainToken.setRegTime(new Date());

		MainToken dumpToken = new MainToken();
		dumpToken = tokenDao.get(email);
		if (dumpToken == null) {
			tokenDao.add(mainToken);
		} else {
			tokenDao.update(mainToken);
		}

		// 이메일 발송부분 작성하기
		// 향후에는 지정된 jsp form을 이용하여 발송하도록 하자 (미완료)
		// mailService.sendMail( from-email-id, to-email-id, email-title,
		// email-contents );
		String from = "adm.answeris@gmail.com";
		String to = email;
		String title = "Answeris 가입 인증 메일입니다";
		String contents = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
				+ "<html>\n" + "<head><meta charset=\"utf-8\"></head>\n" + "<body>\n"
				+ "<h1>Answeris 가입 인증 메일입니다</h1>\n\n" + email + "님, \n\n<br><br>" + "귀하의 인증번호는 다음과 같습니다. \n\n<br><br>"
				+ "<b><i>" + token + "</i></b>" + "</body>" + "</html>";

		try {
			mailService.sendMimeMail(from, to, title, contents);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "fail";
		}

		return "success";
	}

	@RequestMapping(value = "/login/sign-up", method = RequestMethod.POST)
	public String signUp(String email, String id, String password, String username, String user_birth_year,
			String user_birth_month, String user_birth_day, String nickname) {
		// email=&vrfcode=&password=&passwordcheck=&username=&user_birth_year=2004&user_birth_month=1&user_birth_day=1&nickname=
		// Spring Security 를 이용하여 가입과정을 처리하는 컨트롤러
		// 다음 과정을 시행한다
		// 1) Spring Mapping을 해내는 과정 (완료)
		// 2) mybatis Dao를 구축한다 (완료)
		// 3) Email Verification없이 Spring Security를 이용하여 가입을 받는다 (진행중)
		// 4) Email Verification와 함께 Spring Security를 통해 가입을 한다 (미완료)

		// passwordEncoder(Spring Security Bean)을 이용한 암호화 작업
		String pwd = passwordEncoder.encode(password);
		String name = username;
		String birthDay = user_birth_year + String.format("%2s", user_birth_month).replace(" ", "0")
				+ String.format("%2s", user_birth_day).replace(" ", "0");
		String nickName = nickname;
		MainMember member = new MainMember();

		member.setId(id);
		member.setPassword(pwd);
		member.setEmail(email);
		member.setName(name);
		member.setBirthDay(birthDay);
		member.setNickName(nickName);
		member.setExperience(0); // 기본값은 0

		memberDao.add(member);

		// 여기에 추가하기
		return "redirect:/index";
	}

	@RequestMapping(value = "/login/find-password-email", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findPassword(String id, String name, String year, String month, String day)
			throws ParseException, MessagingException {
		Random random = new Random();

		String birthDay = year + String.format("%2s", month).replace(" ", "0")
				+ String.format("%2s", day).replace(" ", "0");
		String pwd = "";
		for (int i = 0; i < 8; i++) {
			pwd += random.nextInt(10);
		}

		String encodePwd = passwordEncoder.encode(pwd);

		if (memberDao.findPassword(id) == null) {
			return "fail";
		}
		if (memberDao.findPassword(id).getName().equals(name)
				&& memberDao.findPassword(id).getBirthDay().equals(birthDay)) {
			memberDao.updatePwd(id, encodePwd);

			String from = "adm.answeris@gmail.com";
			String to = memberDao.findPassword(id).getEmail();
			String title = "[Answeris]문의하신 Answeris 임시 비밀번호입니다";
			String contents = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
					+ "<html>\n" + "<head><meta charset=\"utf-8\"></head>\n" + "<body>\n"
					+ "<h1>문의하신 Answeris 임시 비밀번호입니다</h1>\n\n" + memberDao.findPassword(id).getName() + "님, \n\n<br><br>"
					+ "귀하의 임시비밀번호는 다음과 같습니다. \n\n<br><br>" + "<b><i>" + pwd + "</i></b>" + "</body>" + "</html>";

			try {
				mailService.sendMimeMail(from, to, title, contents);

			} catch (MessagingException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
				return "fail";
			}

		} else {
			return "fail";

		}
		return "success";
	}

	@RequestMapping(value = "/login/find-id-email", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findId(String name, String year, String month, String day) throws ParseException, MessagingException {

		String birthDay = year + String.format("%2s", month).replace(" ", "0")
				+ String.format("%2s", day).replace(" ", "0");

		if (memberDao.findId(name) == null) {
			return "fail";
		}
		if (!memberDao.findId(name).getBirthDay().equals(birthDay)) {
			return "fail";
		} else {

			String from = "adm.answeris@gmail.com";
			String to = memberDao.findId(name).getEmail();
			String title = "[Answeris]문의하신 Answeris 아이디입니다";
			String contents = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
					+ "<html>\n" + "<head><meta charset=\"utf-8\"></head>\n" + "<body>\n"
					+ "<h1>문의하신 Answeris 아이디입니다</h1>\n\n" + name + "님, \n\n<br><br>" + "귀하의 아이디는 다음과 같습니다. \n\n<br><br>"
					+ "<b><i>" + memberDao.findId(name).getId() + "</i></b>" + "</body>" + "</html>";
			try {
				mailService.sendMimeMail(from, to, title, contents);
			} catch (MessagingException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
				return "fail";
			}
		}
		return "success";
	}

	// 이메일 인증 토큰 확인절차
	@RequestMapping(value = "/login/sign-up-token-check", method = RequestMethod.POST)
	@ResponseBody
	public String checkEmailToken(String token, String email) {

		if (tokenDao.getToken(token) == null) {
			return "fail";
		}

		if (tokenDao.getToken(token).getEmail().equals(email)) {
			return "success";
		} else
			return "fail";
	}

	@RequestMapping(value = "/login/id-check", method = RequestMethod.GET)
	@ResponseBody
	public boolean idCheck(String newID) {

		int existId = memberDao.checkId(newID);

		if (existId == 0) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/login/nickname-check", method = RequestMethod.GET)
	@ResponseBody
	public boolean nickNameCheck(String newNickName) {

		int existNickName = memberDao.checkNickName(newNickName);

		if (existNickName == 0) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/login/sign-in", method = RequestMethod.GET)
	public String signIn() {
		return "main.login.sign-in";
	}

	@RequestMapping("/login/find-password")
	public String findPassword() {
		return "main.login.find-password";
	}
	/*---------------------------------------MY-INFO---------------------------------------*/

	@RequestMapping(value = "/member/enter-myinfo-check", method = RequestMethod.GET)
	public String EnterMyInfoCheck(Principal principal, Model model, String pwd) {

		if (passwordEncoder.matches(pwd, myInfoDao.getPassword(principal.getName()))) {
			System.out.println("Success");

			return "redirect:my-info";

		} else {
			System.out.println("Fail");

			return "redirect:enter-myinfo";
		}
	}

	@RequestMapping(value = "/member/enter-myinfo", method = RequestMethod.GET)
	public String EnterMyInfo(Principal principal, Model model) {

		return "main.member.enter-myinfo";
	}

	@RequestMapping(value = "/member/my-info", method = RequestMethod.GET)
	public String myInfo(Principal principal, Model model) {

		String id = principal.getName();

		model.addAttribute("id", id);
		model.addAttribute("email", myInfoDao.getEmail(id));
		model.addAttribute("nickname", myInfoDao.getNickname(id));
		model.addAttribute("BirthDay", myInfoDao.getBirthday(id));
		model.addAttribute("photo", myInfoDao.getPhoto(id));
		model.addAttribute("experience", myInfoDao.getExperience(id));
		model.addAttribute("blog", myInfoDao.getMyBlog(id));

		model.addAttribute("myJobClassSub", myInfoDao.getMyJobClassSub(id));

		return "main.member.my-info";
	}

	@RequestMapping(value = "/member/change-pwd", method = RequestMethod.POST)
	public String changePwd(Principal principal, Model model, String fromPwd, String toPwd1) {

		String encodePwd = passwordEncoder.encode(toPwd1);
		if (passwordEncoder.matches(fromPwd, myInfoDao.getPassword(principal.getName()))) {
			memberDao.updatePwd(principal.getName(), encodePwd);
			return "success";
		}

		return "fail";
	}

	@RequestMapping(value = "/member/my-info", method = RequestMethod.POST)
	public String myInfoChg(Principal principal, String nickname, String myLanguage, String myPlatform,
			String myJobClassMain, String myJobClassSub) {
		// my-info 폼에서 보낸 정보로 db정보를 업데이트

		String id = principal.getName();
		String newNickname = nickname;
		String newMyLanguage = myLanguage;
		String newMyPlatform = myPlatform;
		String newMyJobClassMain = myJobClassMain;
		String newMyJobClassSub = myJobClassSub;

		MainMyInfo myInfo = new MainMyInfo();

		myInfo.setId(id);
		myInfo.setNickname(newNickname);
		myInfo.setMyLanguage(newMyLanguage);
		myInfo.setMyPlatform(newMyPlatform);
		myInfo.setMyJobClassMain(newMyJobClassMain);
		myInfo.setMyJobClassSub(newMyJobClassSub);

		myInfoDao.update(myInfo);

		return "main.member.my-info";
	}

	@RequestMapping(value = "/login/email-check", method = RequestMethod.GET)
	@ResponseBody
	public boolean emailCheck(String newEmail) {
		int existEmail = memberDao.checkEmail(newEmail);

		if (existEmail != 0) {
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping("/member/withdraw")
	public String withdraw(String action) {
		if (action != null) {
			if (action.equals("agree-check")) {
				return "main.member.withdraw2";
			} else if (action.equals("password-reconfirm")) {
				return "main.member.withdraw3";
			}
		} else {
			return "main.member.withdraw1";
		}
		return "main.member.withdraw1";
	}

	@RequestMapping("/messagebox/send-message")
	public String sendMessage(@RequestParam(value = "pg", defaultValue = "1") int page, Principal principal,
			Model model) {

		String[] sentDeletePoint = { "Y", "N" };
		List<Msg> list = messageDao.getSentMsgLst(principal.getName(), sentDeletePoint, 10, page);

		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
		SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);
		List<Map> msgList = new ArrayList<Map>();

		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();

			if (list.get(i).getRecvMemberID().equals(principal.getName())) {
				map.put("rcvId", "나");
			} else {
				map.put("rcvId", list.get(i).getRecvMemberID());
			}
			map.put("content", list.get(i).getContent());
			map.put("day", mmdd.format(list.get(i).getSentDate()));
			map.put("read", list.get(i).getBoolRecvRead());
			map.put("delPoint", list.get(i).getSentDeletePoint());
			map.put("time", time.format(list.get(i).getSentDate()));
			map.put("year", yyyy.format(list.get(i).getSentDate()));
			map.put("code", String.valueOf(list.get(i).getCode()));
			msgList.add(map);
		}

		model.addAttribute("list", msgList);
		return "main.messagebox.send-message";
	}

	// @RequestMapping(value = "/messagebox/rcv-message")
	@RequestMapping("/messagebox/rcv-message")
	public String rcvMessage(@RequestParam(value = "pg", defaultValue = "1") int page, Principal principal,
			Model model) {
		Msg msg = new Msg();
		String[] recvDeletePoint = { "Y", "N" };
		String[] boolRecvRead = { "Y", "N" };
		List<Msg> list = messageDao.getRecvMsgLst(principal.getName(), boolRecvRead, recvDeletePoint, 10, page);
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
		SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);
		List<Map> msgList = new ArrayList<Map>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			if (list.get(i).getSentMemberID().equals(principal.getName())) {
				map.put("sendId", "나");
			} else {
				map.put("sendId", list.get(i).getSentMemberID());
			}
			map.put("content", list.get(i).getContent());
			map.put("day", mmdd.format(list.get(i).getSentDate()));
			map.put("read", list.get(i).getBoolRecvRead());
			map.put("delPoint", list.get(i).getRecvDeletePoint());
			map.put("time", time.format(list.get(i).getSentDate()));
			map.put("year", yyyy.format(list.get(i).getSentDate()));
			map.put("code", String.valueOf(list.get(i).getCode()));
			msgList.add(map);
		}

		model.addAttribute("list", msgList);
		return "main.messagebox.rcv-message";
	}

	@RequestMapping(value = "/messagebox/rcv-delete", method = RequestMethod.POST)
	public String messageDeleteRecv(String[] c) {
		
	
		int rc = 0;
		for (int i = 0; i < c.length; i++) {
			rc += messageDao.updateRecvDeletePoint(c[i]);
			messageDao.updateReadState(Long.parseLong(c[i]), "Y");
		}
		
		return "redirect:rcv-message";
	}
	
	@RequestMapping(value = "/messagebox/sent-delete", method = RequestMethod.POST)
	public String messageDeleteSent(String[] c) {
		int rc = 0;
		for (int i = 0; i < c.length; i++) {
			rc += messageDao.updateSentDeletePoint(c[i]);		
		}
		return "redirect:send-message";
	}
	

	@RequestMapping("/messagebox/write-message")
	public String writeMessage(@RequestParam(value = "wh") String reply, Model model) {
		model.addAttribute("reply", reply);

		return "main.messagebox.write-message";
	}

	@RequestMapping(value = "/messagebox/write-message-sender", method = RequestMethod.POST)

	public String writeMessageSender(Principal principal, String id, String text) {
		System.out.println("here");
		String userName = principal.getName();

		System.out.println(text);
		Msg msg = new Msg();

		if (memberDao.getId(id) == null) {
			return "fail";
		} else {
			msg.setRecvMemberID(id);
			msg.setSentMemberID(userName);
			msg.setContent(text);
			msg.setSentDate(new Date());
			msg.setBoolRecvRead("N");
			msg.setRecvDeletePoint("N");
			msg.setSentDeletePoint("N");
			messageDao.writeMsg(msg);

			return "redirect:/main/messagebox/rcv-message";
		}
	}

	@RequestMapping("/messagebox/detail")
	public String detail(@RequestParam(value = "c") int code, Model model, @RequestParam(value = "ch") String check,
			Principal principal) {

		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
		SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);

		if (check.equals("1")) {
			messageDao.updateReadState(code, "Y");
		}
		List<Map> detail = new ArrayList<Map>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("check", check);

		if (messageDao.getMsg(code).getSentMemberID().equals(principal.getName())) {
			map.put("sendId", "나");
		} else {
			map.put("sendId", messageDao.getMsg(code).getSentMemberID());
		}
		if (messageDao.getMsg(code).getRecvMemberID().equals(principal.getName())) {
			map.put("rcvId", "나");
		} else {
			map.put("rcvId", messageDao.getMsg(code).getRecvMemberID());
		}

		map.put("content", messageDao.getMsg(code).getContent());
		map.put("day", mmdd.format(messageDao.getMsg(code).getSentDate()));
		map.put("read", messageDao.getMsg(code).getBoolRecvRead());
		map.put("time", time.format(messageDao.getMsg(code).getSentDate()));
		map.put("year", yyyy.format(messageDao.getMsg(code).getSentDate()));
		detail.add(map);
		model.addAttribute("list", detail);

		return "main.messagebox.detail";
	}
}
