package net.answeris.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.answeris.web.dao.mybatis.CodeletDao;
import net.answeris.web.model.Codelet;


@Controller
public class CodeletController {

	@Autowired
	private CodeletDao codeletDao;
	//main page�� load�ϴ� controller
	@RequestMapping("/codelet")
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public String index(Model model,Principal principal,
			@RequestParam(value="q", defaultValue="") String query,
			@RequestParam(value="select", defaultValue="") String select,
			@RequestParam(value="sortFlag", defaultValue="")String sortFlag,
			@RequestParam(value="sortSelec", defaultValue="")String sortSelec){

		//spring security�� principal�� parameter�� �޾Ƽ� ���̵� ������ �����Ѵ�.
		if(principal.equals(null)){
			
			return "root.index";
		}
		
		String regMemberId=principal.getName();
		
		List<Codelet> list = codeletDao.getList(regMemberId,sortFlag, query, select ,sortSelec);//sortFlag R : recent, F : favorite, "":regDate

		model.addAttribute("list", list);
		

		List<Codelet> langList = codeletDao.getLangList(regMemberId);
		model.addAttribute("langList", langList);

		return "codelet.main";
	}
	
	@RequestMapping("/codelet-partial")
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public String indexPartial(Model model,Principal principal,
			@RequestParam(value="q", defaultValue="") String query,
			@RequestParam(value="select", defaultValue="") String select,
			@RequestParam(value="sortFlag", defaultValue="")String sortFlag,
			@RequestParam(value="sortSelec", defaultValue="")String sortSelec){

		//spring security�� principal�� parameter�� �޾Ƽ� ���̵� ������ �����Ѵ�.
		if(principal.equals(null)){
					
			return "root.index";
		}
		String regMemberId=principal.getName();
		
		System.out.println(sortSelec);
		List<Codelet> list = codeletDao.getList(regMemberId,sortFlag, query, select ,sortSelec);//sortFlag R : recent, F : favorite, "":regDate

		model.addAttribute("list", list);
		
		List<Codelet> langList = codeletDao.getLangList(regMemberId);
		model.addAttribute("langList", langList);
		
		return "/codelet/main";
	}
	
	
	
	//��� �������� get ��û�� �޴� controller
	@RequestMapping(value="codelet-reg", method = RequestMethod.GET)
	public String codeletReg(HttpSession session, HttpServletResponse response, Principal principal, Model model) throws IOException {
		
		String regMemberId=principal.getName();
		
		List<Codelet> langList = codeletDao.getLangList(regMemberId);
		model.addAttribute("langList", langList);
		
		//reg page�� post ��û���� �ٽ� reload�Ѵ�.
		return "codelet.reg";
	}
	//reg page�� post ��û controller
	@RequestMapping(value="codelet-reg", method = RequestMethod.POST)
	public String codeletReg(Codelet codelet,Principal principal) {

		codelet.setRegMemberId(principal.getName());
		codeletDao.add(codelet);		
		
		//db�� ����Ǹ� �ٽ� main page�� redirect�Ѵ�.
		return "redirect:codelet";

	}
	//detail page�� get��û�� �ٷ�� controller
	@RequestMapping("/codelet-detail")
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String codeletDetail(String c, Model model,Principal principal,
			@RequestParam(value="q", defaultValue="") String query,
			@RequestParam(value="select", defaultValue="") String select,
			@RequestParam(value="sortFlag", defaultValue="")String sortFlag,
			@RequestParam(value="sortSelec", defaultValue="")String sortSelec){

		String regMemberId=principal.getName();
	      
		List<Codelet> langList = codeletDao.getLangList(regMemberId);
		model.addAttribute("langList", langList);
		
		Codelet codelet = codeletDao.get(c);
		
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		SimpleDateFormat mmdd = new SimpleDateFormat("MM/dd", Locale.KOREA);
		SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", Locale.KOREA);
		
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("code", codelet.getCode());
		map.put("title", codelet.getTitle());
		map.put("codeSrc", codelet.getCodeSrc());
		map.put("favorite", codelet.getFavorite());
		map.put("recent", String.valueOf(codelet.getRecent()));
		map.put("languageCode", codelet.getLanguageCode());
		map.put("hashTag", codelet.getHashTag());
		map.put("platformCode", codelet.getPlatformCode());
		map.put("regMemberId", codelet.getRegMemberId());
		map.put("day", mmdd.format(codelet.getRegDate()));
		map.put("time", time.format(codelet.getRegDate()));
		map.put("year", yyyy.format(codelet.getRegDate()));
		map.put("hit", String.valueOf(codelet.getHit()));
		
		
		model.addAttribute("c", map);
		
	      
		return "codelet.detail";
	}
	//edit page�� get��û�� �ٷ�� controller
	@RequestMapping(value="/codelet-edit", method= RequestMethod.GET)
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public String codeletEdit(String c, Model model, Principal principal){

		Codelet codelet = codeletDao.get(c);
		model.addAttribute("c", codelet);
		
		String regMemberId=principal.getName();
		
		List<Codelet> langList = codeletDao.getLangList(regMemberId);
		model.addAttribute("langList", langList);
		
		//edit page�� post ��û���� �ٽ� reload�Ѵ�.
		//reg�� edit ����
		return "codelet.reg";
	}
	//edit page�� post��û�� �ٷ�� controller
	@RequestMapping(value="/codelet-edit", method= RequestMethod.POST)
	public String codeletEdit(Codelet codelet){

		codeletDao.update(codelet);
		//������ page�� detail page�� redirect�Ѵ�.
		return "redirect:codelet-detail?c=" + codelet.getCode();
	}
	//delete�ϴ� controller
	@RequestMapping("codelet-del")
	public String codeletDelete(String c) {

		codeletDao.delete(c);

		//main page�� redirect�Ѵ�.
		return "redirect:codelet";
	}

	//���ã�⸦ �߰� �� �����ϴ� controller. java script�� �̿��ϱ� ������ view���� ��ü�ϴ� responsebody�� ���
	@RequestMapping(value = "/favorites", method = RequestMethod.POST)
	@ResponseBody
	public String favorites(String data, String code) {
		//���ã�� ���� �ʾ��� ���
		if(data.equals("N")){
			codeletDao.addFav(code);

		}
		//���ã�Ⱑ �Ǿ����� ���
		else if(data.equals("Y")){
			codeletDao.delFav(code);
		}
		return "1";
	}

	//data�� ��� ���� json�� �ٷ�� controller. java script�� �̿��ϱ� ������ view���� ��ü�ϴ� responsebody�� ���
	@RequestMapping(value="codeletJSON", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String codeletJSON(String code) {

		//�����͸� �޾ƿ� json���·� �����ϴ� logic
		Codelet list=codeletDao.get(code);
		StringBuilder json = new StringBuilder();
		json.append("[");


			String obj =
					String.format("{\"favorite\":\"%s\"}", list.getFavorite());

			json.append(obj);

		json.append("]");
		//����� json ������ �����͸� string���� ��ȯ�Ͽ� �����ش�.
		return json.toString();
	}

	//�ֱ� ��ȸ ���� ����ϱ� ���� controller.java script�� �̿��ϱ� ������ view���� ��ü�ϴ� responsebody�� ���
	@RequestMapping(value = "/recent", method = RequestMethod.POST)
	@ResponseBody
	public String favorites(String code) {

			codeletDao.updateRec(code);
		return "1";
	}

	   @RequestMapping(value ="/fav-list"/*, method = RequestMethod.GET*/)
	   @ResponseBody
	   public String getFavList(@RequestBody Model model, Principal principal) {

		   String regMemberId=principal.getName();

		   List<Codelet> list = codeletDao.getFavList();

	      List<Codelet> langList = codeletDao.getLangList(regMemberId);

	      model.addAttribute("list", list);
	      model.addAttribute("langList", langList);

	      return "codelet.main";
	   }


	   @RequestMapping(value ="/rec-list"/*, method = RequestMethod.GET*/)
	   @ResponseBody
	   @Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	   public String getRecList(@RequestBody Model model, Principal principal) {

		  String regMemberId=principal.getName();

	      List<Codelet> list = codeletDao.getRecList();

	      List<Codelet> langList = codeletDao.getLangList(regMemberId);

	      model.addAttribute("list", list);
	      model.addAttribute("langList", langList);

	      return "codelet.main";
	   }

		@RequestMapping(value="codelet-hashTags", produces="text/plain;charset=UTF-8")
		@ResponseBody
		public String getHashTags(@RequestParam(value="userFlag", defaultValue="U") String userFlag,
												@RequestParam(value="ht", defaultValue="") String ht,
												String regMemberId,
												Principal principal) {
			if( userFlag.equals("U"))
				regMemberId = principal.getName();//"hyelee";
			else
				regMemberId = "";

			List<Codelet> list = codeletDao.getHashTags( userFlag, ht, regMemberId );

			Gson gson = new Gson();

			return gson.toJson(list);
		}
		
		@RequestMapping(value="codeletJSONAjax", produces="text/plain;charset=UTF-8")
		@ResponseBody
		public String codeletJSONAjax(Principal principal,
				@RequestParam(value="q", defaultValue="") String query,
				@RequestParam(value="select", defaultValue="") String select,
				@RequestParam(value="sortFlag", defaultValue="")String sortFlag,
				@RequestParam(value="sortSelec", defaultValue="")String sortSelec) {

			List<Codelet> list = codeletDao.getList(principal.getName(),sortFlag, query, select ,sortSelec);//sortFlag R : recent, F : favorite, "":regDate
			
			Gson gson = new Gson();
	
			return gson.toJson(list);
		}
}
