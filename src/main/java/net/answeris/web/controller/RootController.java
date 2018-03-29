package net.answeris.web.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.answeris.web.dao.mybatis.MainMemberDao;
import net.answeris.web.dao.mybatis.MainSearchDao;
import net.answeris.web.dao.mybatis.MessageDao;
import net.answeris.web.model.MainMember;
import net.answeris.web.model.MainSearch;
import net.answeris.web.model.Msg;

@Controller
public class RootController {

	@Autowired
	private MainSearchDao mainSearchDao;

	@Autowired
	private MainMemberDao mainMemberDao;

	@Autowired
	private MessageDao messageDao;

	@RequestMapping({ "", "/index" })
	public String index(Model model) {
		model.addAttribute("address", "index");
		return "root.index";
	}

	@RequestMapping("/search-result")
	public String searchResult(

			@RequestParam(value = "search-term") String keyword, Model model,
			@RequestParam(value = "where", defaultValue = "") String where) {
		/*
		 * --------------------------------------- 검색어 설정
		 * ----------------------------------------------------------------
		 */
		String keyword_trim = "";
		// keyword_trim = keyword.replace(" ", "");
		// System.out.println(keyword_trim);

		String[] keywords = keyword.split(" ");
		int i = 0;

		switch (i) {
		case 0:
			keyword_trim = keywords[0];
			break;

		case 1:
			keyword_trim = keywords[0];
			keyword_trim = keywords[1];
			break;

		case 2:
			keyword_trim = keywords[0];
			keyword_trim = keywords[1];
			break;

		case 3:
			keyword_trim = keywords[0];
			keyword_trim = keywords[1];
			keyword_trim = keywords[2];
			break;

		}

		if (where.equals("")) {
			List<MainSearch> list = mainSearchDao.get(keyword_trim);

			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
			SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
			SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);
			List<Map> newList = new ArrayList<Map>();
			for (int i1 = 0; i1 < list.size(); i1++) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("day", mmdd.format(list.get(i1).getRegDate()));
				map.put("year", yyyy.format(list.get(i1).getRegDate()));
				map.put("time", time.format(list.get(i1).getRegDate()));
				map.put("content", list.get(i1).getContent());
				map.put("memberid", list.get(i1).getMemberid());
				map.put("title", list.get(i1).getTitle());
				map.put("code", String.valueOf(list.get(i1).getCode()));
				newList.add(map);
			}
			model.addAttribute("list", newList);
			model.addAttribute("searchterm", keyword_trim);

			List<MainSearch> list1 = mainSearchDao.getQnA(keyword_trim);
			List<Map> newList1 = new ArrayList<Map>();
			for (int i2 = 0; i2 < list1.size(); i2++) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("day", mmdd.format(list1.get(i2).getRegDate()));
				map.put("year", yyyy.format(list1.get(i2).getRegDate()));
				map.put("time", time.format(list1.get(i2).getRegDate()));
				map.put("content", list1.get(i2).getContent());
				map.put("memberid", list1.get(i2).getMemberid());
				map.put("title", list1.get(i2).getTitle());
				map.put("code", String.valueOf(list1.get(i2).getCode()));
				newList1.add(map);
			}
			
			model.addAttribute("listQnA", newList1);
			model.addAttribute("searchterm", keyword_trim);

			return "root.search-result";

			

		} else if (where.equals("blog")) {
			List<MainSearch> list = mainSearchDao.get(keyword_trim);
			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
			SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
			SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);
			List<Map> newList = new ArrayList<Map>();
			for (int i3 = 0; i3 < list.size(); i3++) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("day", mmdd.format(list.get(i3).getRegDate()));
				map.put("year", yyyy.format(list.get(i3).getRegDate()));
				map.put("time", time.format(list.get(i3).getRegDate()));
				map.put("content", list.get(i3).getContent());
				map.put("members", list.get(i3).getMemberid());
				map.put("title", list.get(i3).getTitle());
				map.put("code", String.valueOf(list.get(i3).getCode()));
				newList.add(map);
			}
			model.addAttribute("list", newList);
			model.addAttribute("searchterm", keyword_trim);


			return "root.search-blog";

		} else if (where.equals("qna")) {

			List<MainSearch> list1 = mainSearchDao.getQnA(keyword_trim);
			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
			SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
			SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);
			List<Map> newList = new ArrayList<Map>();
			for (int i4 = 0; i4 < list1.size(); i4++) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("day", mmdd.format(list1.get(i4).getRegDate()));
				map.put("year", yyyy.format(list1.get(i4).getRegDate()));
				map.put("time", time.format(list1.get(i4).getRegDate()));
				map.put("content", list1.get(i4).getContent());
				map.put("members", list1.get(i4).getMemberid());
				map.put("title", list1.get(i4).getTitle());
				map.put("code", String.valueOf(list1.get(i4).getCode()));
				newList.add(map);
			}
			model.addAttribute("listQnA", newList);
			model.addAttribute("searchterm", keyword_trim);

			return "root.search-qna";
		}

		return "root.search-result";
	}

	/*
	 * --------------------------------------- 헤더정보
	 * 가져오기----------------------------------------------------------------
	 */
	@RequestMapping(value = "/header-member-ajax", method = RequestMethod.GET)
	@ResponseBody
	public String headerMember(Principal principal) {
		MainMember member = mainMemberDao.getId(principal.getName());
		Gson gson = new Gson();
		return gson.toJson(member);
	}

	@RequestMapping(value = "/header-message-new-ajax", method = RequestMethod.GET)
	@ResponseBody
	public String headerNewMessage(Principal principal) {
		System.out.println("ok");
		Msg newMessage = messageDao.getNewMessage(principal.getName());
		Gson gson = new Gson();
		return gson.toJson(newMessage);
	}

	/*
	 * --------------------------------------- 더보기
	 * ----------------------------------------------------------------
	 */
	@RequestMapping(value = "menublogJSON", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String menublogJSON(String keyword, String count) {

		List<MainSearch> list = mainSearchDao.getNext(keyword, count);

		Gson gson = new Gson();
		// System.out.println("리스트&키워드 : "+list+keyword);
		return gson.toJson(list);

	}

	@RequestMapping(value = "menuJSON", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String menuJSON(String keyword, String count) {

		List<MainSearch> list = mainSearchDao.getQnANext(keyword, count);

		Gson gson = new Gson();
		//System.out.println("리스트&키워드 : "+list+keyword);
		return gson.toJson(list);

	}

}
