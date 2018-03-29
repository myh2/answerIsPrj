package net.answeris.web.controller;

import java.security.Principal; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/*import com.google.gson.Gson;*/

import net.answeris.web.dao.mybatis.BlogCommentChargeDao;
import net.answeris.web.dao.mybatis.BlogDao;
import net.answeris.web.dao.mybatis.BlogGoodDao;
import net.answeris.web.dao.mybatis.CategoryDao;
import net.answeris.web.dao.mybatis.ChargeOptionDao;
//import net.answeris.web.dao.mybatis.BlogDao;
import net.answeris.web.dao.mybatis.CodeletDao;
import net.answeris.web.dao.mybatis.CommentDao;
import net.answeris.web.dao.mybatis.LanguageDao;
import net.answeris.web.dao.mybatis.MainMemberDao;
import net.answeris.web.dao.mybatis.PlatformDao;
import net.answeris.web.dao.mybatis.BlogLanguageDao;
import net.answeris.web.model.Blog;
import net.answeris.web.model.BlogComment;
import net.answeris.web.model.BlogCommentCharge;
import net.answeris.web.model.BlogGood;
import net.answeris.web.model.Category;
import net.answeris.web.model.ChargeOption;
import net.answeris.web.model.Language;
import net.answeris.web.model.Platform;
import net.answeris.web.model.BlogLanguage;
//import net.answeris.web.model.Blog;

@Controller
@RequestMapping("/{id}")
public class BlogController {

   @Autowired
   private BlogDao blogDao;
   
   @Autowired 
   private CommentDao commentDao;
   
   @Autowired
   private CategoryDao categoryDao;
   
   @Autowired
   private BlogLanguageDao blogLanguageDao;
   
   @Autowired
   private LanguageDao languageDao;
   
   @Autowired
   private PlatformDao platformDao;
   
   @Autowired
	private BlogCommentChargeDao blogCommentChargeDao;
	
	@Autowired
	private ChargeOptionDao chargeOptionDao;
	
	@Autowired
	private MainMemberDao mainMemberDao;
   
	@Autowired
	private BlogGoodDao blogGoodDao;
	
    
	//블로그 초기화면 로드시키는 함
	@RequestMapping({"","/main"})
	public String index(@PathVariable("id") String id, Model model, Principal principal) {
    	String userName = null;
    	List<Blog> list = null;
//    	System.out.println(principal.getName());
    	//가져올 아이디가 있는지 없는지에 대한 예외처
    	if(principal!=null){
    		
	    	if(principal.getName().equals(id)){
	    		list = blogDao.getList(id);
	    		System.out.println("1");
	    	
	    	}
	    	else{
	    		System.out.println("결과:"+id+","+principal.getName());
	    		list = blogDao.getLists(id);
	    		System.out.println("2");
	    	}
    	}
    	else{
    		list = blogDao.getLists(id);
    		System.out.println("3");
    	}
    	
		List<Category> cList = categoryDao.getList(id);
		model.addAttribute("list", list);
		model.addAttribute("cList", cList);
		model.addAttribute("blogId", id);

		return "blog.main";
	}
/*
    //똥쟁이 병우신이 싸놓은 똥코
    @RequestMapping("mainJSON")
	@ResponseBody
   	public String mainJSON(@PathVariable("id") String id, Model model, Principal principal) {

       	
    	List<Blog> list = null;
    	if(principal!=null){
    		
	    	if(principal.getName().equals(id)){
	    		list = blogDao.getList(id);
	    		System.out.println("11");
	    	
	    	}
	    	else{
	    		System.out.println("결과:"+id+","+principal.getName());
	    		list = blogDao.getLists(id);
	    		System.out.println("12");
	    	}
    	}
    	else{
    		list = blogDao.getLists(id);
    		System.out.println("13"+id);
    	}
   		
   		for(Blog n:list){
   			
   			BlogGood blogGood=blogGoodDao.getLike(n.getCode());
   			n.setLikeNum(blogGood.getLikeNum());
   		}
   		
   		Gson gson = new Gson();
  
		return gson.toJson(list);
   	}*/

    
   @RequestMapping("/setting")
   public String setting() {

      return "blog.setting";
   }

   @RequestMapping(value="/regist", method=RequestMethod.GET)
   public String regist(Principal principal, Model model) {
	   List<Category> cList = categoryDao.getList(principal.getName());
	   List<Language> lList=languageDao.getList();
	   List<Platform> pList=platformDao.getList();
	   
	   model.addAttribute("cList", cList);
	   model.addAttribute("lList", lList);
	   model.addAttribute("pList", pList);

      return "blog.regist";
   }
   
   @RequestMapping(value="/regist", method=RequestMethod.POST)
   public String regist(Blog blog, Principal principal) {
	   blog.setMemberId(principal.getName());
	   
	  
	   int rc=blogDao.add(blog);
	  
	   
	   
	   if(Integer.parseInt(blog.getPublicOption())==3){
	       
	       blogDao.publicSet(blog.getCode());
	      }
	      
	      else if(Integer.parseInt(blog.getPublicOption())==1){
	         
	      }
	      
	      else if(Integer.parseInt(blog.getPublicOption())==2){
	         
	      }

      return "redirect:main";
   }
   
   @RequestMapping("/reg-setting")
   public String regSetting() {

      return "blog.reg-setting";
   }

   @RequestMapping(value="/detail", method=RequestMethod.GET)
   public String detail(@PathVariable("id") String id, @RequestParam(value="c")String code ,Principal principal, Model model) {
	  
	   Blog blog= blogDao.get(code);
	   BlogGood blogGood=blogGoodDao.getLike(code);
	   
	   blog.setLikeNum( blogGood.getLikeNum());
	   String content = null;
	   if(blog.getContent().contains("\n")){
		   content= blog.getContent().replace(System.getProperty("line.separator"), "<br/>");
		   //System.out.println("이거"+content);
		   blog.setContent(content);
	   }
	   List<BlogComment> list = commentDao.getList(code);
	   List<Category> cList = categoryDao.getList(id);
	   model.addAttribute("b",blog);
	   model.addAttribute("cList", cList);
	   model.addAttribute("cmtList",list);
      return "blog.detail";
   }

   @RequestMapping(value="/comment", method=RequestMethod.GET)
   public String comment(
			@RequestParam(value="c", defaultValue="1") String code,
			Model model){

	   List<BlogComment> list = commentDao.getList(code);
		model.addAttribute("cmtList",list);
		model.addAttribute("code",code);
		return "blog.comment";	   
   }
   
 //�����Ϸ������ư
   @RequestMapping(value="/comment-edit", method=RequestMethod.GET)
   public String commentEdit(@RequestParam(value="c", defaultValue="1") String code, Model model){ 
	   
	   BlogComment n= commentDao.get(code);
	   model.addAttribute("n", n);
		return "blog.comment-edit";
	
   }
   
   //�����Ϸ��ư
	@RequestMapping(value="/comment-edit", method=RequestMethod.POST)
	public String commentEdit(BlogComment n){
		
//		System.out.println(n);
		int rc=commentDao.update(n);
		
		return "redirect:comment?c="+n.getBlogCode();
		}
   //�����ϱ�
	@RequestMapping(value="/comment-del")
	 public String commentDelete(@RequestParam(value="c") String code, Principal principal){ 
		   BlogComment bc = commentDao.get(code);
		   String blogMemberId = bc.getMemberId();
		   String loginId= principal.getName();
		   // 아이디에 따라서 삭제하는 내용을 달리한다.
		   // 정확히 말해서 삭제가 아닌 내용의 변경에 해당한다.
		   if(blogMemberId.equals(loginId)){
			   int rc = commentDao.delete(code);
		   }
		   else{
			   int rc= commentDao.deleteAdmin(code);
		   }
		   return "redirect:comment";		
	   }
   
   @RequestMapping("/blog-menu")
   public String blogMenu(Principal principal, Model model){
	   List<Category> list = categoryDao.getList(principal.getName());
	   model.addAttribute("cList", list);
	   return "blog.aside";	   
   }
   
   @RequestMapping(value="/modify", method=RequestMethod.GET)
   public String modify(Principal principal, Model model, 
		   @RequestParam(value="c", defaultValue="1") String code) {
	   
	   
	   Blog blog = blogDao.get(code);
	   
	   List<Category> cList = categoryDao.getList(principal.getName());
	   model.addAttribute("cList", cList);
	   
	   model.addAttribute("blog", blog);
	   

      return "blog.modify";
   }
   @RequestMapping(value="/modify", method=RequestMethod.POST)
   public String modify(Blog blog, Principal principal) {
      blog.setMemberId(principal.getName());
     
      int rc=blogDao.update(blog);
      if(Integer.parseInt(blog.getPublicOption())==3){
       
       blogDao.publicSet(blog.getCode());
      }
      
      else if(Integer.parseInt(blog.getPublicOption())==1){
         
      }
      
      else if(Integer.parseInt(blog.getPublicOption())==2){
         
      }
      return "redirect:detail?c=" + blog.getCode();
   }

	@RequestMapping(value="/delete")
	 public String delete(@RequestParam(value="c") String code, Principal principal){ 
		   
			int rc= blogDao.delete(code);
		   
			return "redirect:main";
		
	   }
   
	@RequestMapping(value="menuJSON",produces="text/plain;charset=UTF-8",method=RequestMethod.POST)
	/*�̰� �����Ƿ� �䰡 �ʿ���� �ٷ� ����̵ȴ�. �̺κ��� �䰡 �Ǵ°�*/
	@ResponseBody
	public String menuJSON(String bc ,@PathVariable("id") String id, Principal principal){
	
	
	List<Blog> list = null;
	if(principal!=null){
		
    	if(principal.getName().equals(id)){
    		list = blogDao.getNextList(bc, id);
    		System.out.println("11");
    	
    	}
    	else{
    		System.out.println("결과:"+id+","+principal.getName());
    		list = blogDao.getNextLists(bc, id);
    		System.out.println("12");
    	}
	}
	else{
		list = blogDao.getNextLists(bc, id);
		System.out.println("13"+id);
	}
	
	
	
	
			
			
		StringBuilder json = new StringBuilder();
		json.append("[");
		
		
	
		
		for(Blog n : list){
			//String con = n.getContent();
			String content=n.getContent();
			//System.out.println("�״��:"+content);
			
			if(content.contains("\n")){
			 content= content.replace(System.getProperty("line.separator"), "");
			 
			 //System.out.println("----------------------------------");
			}
			if(content.contains("\""))
				content=content.replace("\"", "\'");
			
			BlogGood blogGood=blogGoodDao.getLike(n.getCode());
			n.setLikeNum(blogGood.getLikeNum());
			n.setContent(content);
			
			/*if(content.length()>100){
				content=content.substring(0,100);
				System.out.println("�ٲ�:"+content);
				System.out.println("----------------------------------");
			}*/
			//String obj = String.format("{\"date\":\"%s\",\"title\":\"%s\",\"hashtag\":\"%s\",\"content\":\"%s\",\"memberId\":\"%s\",\"likeNum\":\"%s\",\"code\":\"%s\"}",n.getRegDate(),n.getTitle(),n.getHashtag(),content,n.getMemberId(),n.getLikeNum(),n.getCode());
			
			//json.append(obj);
			
			
			/*if(n != list.get(list.size()-1)){
				json.append(",");
			}*/
		
		}		
		
		//json.append("]");
		
	
		
		
   		
   		Gson gson = new Gson();
   	 System.out.println("리스트&키워드 : "+list);
		return gson.toJson(list);

		//return json.toString();
		
	}
	
	@RequestMapping(value = "/comment-charge", method = RequestMethod.GET)
	public String commentCharge(String c, Principal principal, Model model) {
		List<ChargeOption> ccList = chargeOptionDao.getList("1");
		model.addAttribute("c", c);
		model.addAttribute("ccList", ccList);
		
		return "blog.charge";
	}
	
	@RequestMapping(value = "/comment-charge", method = RequestMethod.POST)
	public String blogCommentCharge(BlogCommentCharge blogCommentCharge, Principal principal) {
		blogCommentCharge.setMemberId(principal.getName());
		
		int rc = blogCommentChargeDao.add(blogCommentCharge);
			
		return "redirect:main";
	}
	
	@RequestMapping("/publish")
	public String publishBlog(String c){
		
		int rc=blogDao.publicSet(c);
		//�����Ǹ� 1, �̹� �־ ���� �ȵǸ� -1 ����.
	
		return "redirect:detail?c=" + c;
	}
   
	@RequestMapping(value="/blogcomment-reg-ajax", method = RequestMethod.POST)
	
	public String blogCommentRegAjax(BlogComment blogcomment, @RequestParam(value="bc") String blogCode, Principal principal){
		
		
		if(principal != null){
			blogcomment.setMemberId(principal.getName());
		}
		else{
			return "redirect:detail?c="+blogcomment.getBlogCode();
		}
		 String content = null;
		   if(blogcomment.getContent().contains("\n")){
			   content= blogcomment.getContent().replace(System.getProperty("line.separator"), "<br/>");
			  
			   blogcomment.setContent(content);
		   }
		System.out.println(blogcomment.getCode());
		System.out.println(blogcomment.getContent());
		
		System.out.println(blogcomment.getContent());
		blogcomment.setBlogCode(blogCode);
		System.out.println(blogcomment.getBlogCode());
		int rc =commentDao.add(blogcomment.getContent(), blogcomment.getBlogCode(),blogcomment.getMemberId());
		
		
		return "redirect:detail?c="+blogcomment.getBlogCode();	
	}
	
	@RequestMapping(value="blogCommentJSON", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String blogCommentJSON( @RequestParam(value="c") String blogCode, Principal principal
	        ) {
		
		
		List<BlogComment> list = commentDao.initGetList(blogCode);
		
		StringBuilder json = new StringBuilder();

		json.append("[");
	      
		String content = null;
	      for(BlogComment n : list){
	    	 /* String content=n.getContent();
				if(content.contains("\n")){
					
					 content= content.replace(System.getProperty("line.separator"),"<br/>");
					System.out.println("변환"+content);
					 n.setContent(content);
				}*/
				   if(n.getContent().contains("\n")){
					   content= n.getContent().replace("\n", "<br/>");
					  // System.out.println("변환"+content);
					   n.setContent(content);
				   }
				
				
		
	         String obj = String.format("{\"nickName\":\"%s\",\"content\":\"%s\",\"regDate\":\"%s\"}"
	        		 , n.getNickname(), n.getContent(), n.getRegDate());
			/*	String obj = String.format("{\"nickName\":\"%s\",\"regDate\":\"%s\"}"
		        		 , n.getNickname(), n.getRegDate());*/
	         json.append(obj);
	         
	         if(n != list.get(list.size()-1))  /*�������� �ƴ϶��*/
	            json.append(",");
	         
	      }
	      
	      json.append("]");
	      
	      //System.out.println(json.toString());
	      String result = json.toString();
	      if(result.contains("\n")){
	    	 result= result.replace('\n',' ');
	      }
	      
	      return result;
		
		
	}
	
	@RequestMapping(value="/setLike-ajax", method = RequestMethod.POST)
	@ResponseBody
	public String likeAddAjax(@RequestParam(value="code") String code, Principal principal){
			
		int rc=blogDao.setLike(principal.getName(), code);
			
		return String.valueOf(rc);	
	}
	
	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String Blogsetting(String c, Principal principal, Model model) {
		List<Category> cList = categoryDao.getList(principal.getName());
		model.addAttribute("cList", cList);
		
		return "blog.setting";
	}
	
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public String blogSetting(Category category, Principal principal) {
		category.setMemberId(principal.getName());
		
		int rc = categoryDao.add(category);
			
		return "blog.setting";
	}
	
	//좋아요 숫자 가져오기
	@RequestMapping(value ="/like-num", method= RequestMethod.GET)
	public String getLikeNum(String code){
		
		String a = blogDao.getLikeNum(code);
		return null;
	}

}