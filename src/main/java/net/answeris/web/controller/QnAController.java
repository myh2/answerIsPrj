package net.answeris.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.answeris.web.dao.mybatis.AnswerDao;
import net.answeris.web.dao.mybatis.BlogDao;
import net.answeris.web.dao.mybatis.BlogGoodDao;
import net.answeris.web.dao.mybatis.BlogHateDao;
import net.answeris.web.dao.mybatis.CategoryDao;
import net.answeris.web.dao.mybatis.CommentDao;
import net.answeris.web.dao.mybatis.QuestionDao;
import net.answeris.web.model.Answer;
import net.answeris.web.model.Blog;
import net.answeris.web.model.BlogComment;
import net.answeris.web.model.BlogGood;
import net.answeris.web.model.BlogHate;
import net.answeris.web.model.Category;
import net.answeris.web.model.MainSearch;
import net.answeris.web.model.Question;

@Controller
@RequestMapping("/qna/*")
public class QnAController {

	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private QuestionDao questionDao;
	
   @Autowired
   private BlogDao blogDao;
   
   @Autowired 
   private CommentDao commentDao;
   
   @Autowired
   private CategoryDao categoryDao;
   
	@Autowired
	private BlogGoodDao blogGoodDao;
	
	@Autowired
	private BlogHateDao blogHateDao;
	/*---------------answers controller~~----------------------------        --*/
	@RequestMapping("answers")
	public String myAnswerList(
			@RequestParam(value="page", defaultValue="1") int page, String mid, Principal principal, Model model){
		
		mid = principal.getName();
		
		List<Answer> list = answerDao.getList(page, mid);
		
		model.addAttribute("list", list);
		
		return "qna.answers";
	}
	
	
	@RequestMapping("answersDelete")
	public String answerDelete(@RequestParam(value="c")String code){
		int rc= answerDao.delete(code);
		return "redirect:answers";
	}


	
	   @RequestMapping(value="answers-detail", method=RequestMethod.GET)
	   public String answerDetail(@RequestParam(value="c")String code ,Principal principal, Model model) {

		   
		   String qnaCode = answerDao.getQnaCode(code);
		   String mid = principal.getName();
		   
		   String blogPrevCode = answerDao.getPrevBlogCode(qnaCode,mid);
		   String blogNextCode = answerDao.getNextBlogCode(qnaCode,mid);
		   
		   Blog blog= blogDao.get(code);
		   BlogGood blogGood=blogGoodDao.getLike(code);
		   BlogHate blogHate = blogHateDao.getHate(code);
		   System.out.println("qnacode ="+qnaCode);
		   System.out.println("nextcode ="+blogNextCode);
		   System.out.println("prevcode ="+blogPrevCode);
		   
		   blog.setLikeNum( blogGood.getLikeNum());
		   blog.setHateNum(blogHate.getHateNum());
		   List<BlogComment> list = commentDao.getList(code);
		  // List<Category> cList = categoryDao.getList("Pbwoo");//����
		   model.addAttribute("blogNextCode",blogNextCode);
		   model.addAttribute("blogPrevCode",blogPrevCode);
		   model.addAttribute("b",blog);
		   //model.addAttribute("cList", cList);
		   model.addAttribute("cmtList",list);
			

	      return "qna.answers-detail";
	   }
	   
	   @RequestMapping(value="answers-detail-prev", method=RequestMethod.GET)
	   public String answerDetailPrev(@RequestParam(value="c")String code ,Principal principal, Model model) {

		   String qnaCode = answerDao.getQnaCode(code);
		   String mid = principal.getName();
		     
		   String blogCode = answerDao.getPrevBlogCode(qnaCode,mid);
		   qnaCode = answerDao.getQnaCode(blogCode);
		   
		   String blogNextCode = answerDao.getNextBlogCode(qnaCode,mid);
		   String blogPrevCode = answerDao.getPrevBlogCode(qnaCode,mid);
		   
		   System.out.println("qnacode ="+qnaCode);
		   System.out.println("nextcode ="+blogNextCode);
		   System.out.println("prevcode ="+blogPrevCode);
		   
		   Blog blog= blogDao.get(blogCode);
		   BlogGood blogGood=blogGoodDao.getLike(blogCode);
		   BlogHate blogHate = blogHateDao.getHate(blogCode);
		   
		   blog.setLikeNum(blogGood.getLikeNum());
		   blog.setHateNum(blogHate.getHateNum());
		   List<BlogComment> list = commentDao.getList(code);
		  // List<Category> cList = categoryDao.getList("Pbwoo");//����
		   model.addAttribute("blogNextCode",blogNextCode);
		   model.addAttribute("blogPrevCode",blogPrevCode);
		   model.addAttribute("b",blog);
		   //model.addAttribute("cList", cList);
		   model.addAttribute("cmtList",list);
			

	      return "qna.answers-detail";
	   }
	   
	   
	   @RequestMapping(value="answers-detail-next", method=RequestMethod.GET)
	   public String answerDetailNext(@RequestParam(value="c")String code ,Principal principal, Model model) {

		   String qnaCode = answerDao.getQnaCode(code);
		   String mid = principal.getName();
		   
		   
		   String blogCode = answerDao.getNextBlogCode(qnaCode,mid);
		   qnaCode = answerDao.getQnaCode(blogCode);
		  
		   String blogPrevCode = answerDao.getPrevBlogCode(qnaCode,mid);
		   String blogNextCode = answerDao.getNextBlogCode(qnaCode,mid);
		   
		   System.out.println("qnacode ="+qnaCode);
		   System.out.println("nextcode ="+blogNextCode);
		   System.out.println("prevcode ="+blogPrevCode);
		   
		   Blog blog= blogDao.get(blogCode);
		   BlogGood blogGood=blogGoodDao.getLike(blogCode);
		   BlogHate blogHate = blogHateDao.getHate(blogCode);
		   
		   blog.setLikeNum( blogGood.getLikeNum());
		   blog.setHateNum(blogHate.getHateNum());
		   List<BlogComment> list = commentDao.getList(code);
		  // List<Category> cList = categoryDao.getList("Pbwoo");//����
		   model.addAttribute("blogNextCode",blogNextCode);
		   model.addAttribute("blogPrevCode",blogPrevCode);
		   model.addAttribute("b",blog);
		   //model.addAttribute("cList", cList);
		   model.addAttribute("cmtList",list);
			

	      return "qna.answers-detail";
	   }
	   
	   
	   @RequestMapping("qna-answers-search")
	   public String answerSearchResult(
	         /*@RequestParam(value="pg", defaultValue="1") int page,
	         @RequestParam(value="f", defaultValue="TITLE") String field,
	         @RequestParam(value="q", defaultValue="") String query*/
	         @RequestParam(value="search-opt") String opt,@RequestParam(value="search-term") String keyword, Model model, Principal principal){
	   String mid;
		  mid = principal.getName();
	      String keyword_trim;
	      keyword_trim = keyword.replace(" ", "");
	      // String [] keywords = keyword.split(" ");   
	      //System.out.println(keyword_trim);
	     //System.out.println("searchoption ="+opt);
	     if(opt.equals("CONTENT")){
	    	 List<Answer> list = answerDao.searchListContent(keyword_trim, mid);
	         model.addAttribute("list",list);
	     }
	     else if(opt.equals("TITLE")){
	         List<Answer> list = answerDao.searchListTitle(keyword_trim, mid);
	         model.addAttribute("list",list);
	     }


	      return "qna.answers";
	   }
	   
	   
	   
	   
	   
	   
/*		@RequestMapping(value="answersPrev" , method=RequestMethod.GET)
		public String answerprev(@RequestParam(value="c")String code, Model model){
			Answer answer = answerDao.getPrev(code);
			model.addAttribute("n",answer);
			return "redirect:answers";
		}
		
		@RequestMapping(value="answersPrev" , method=RequestMethod.GET)
		public String answernext(@RequestParam(value="c")String code, Model model){
			Answer answer = answerDao.getPrev(code);
			model.addAttribute("n",answer);
			return "redirect:answers";
		}*/

	   
	   
/*	---------------------------------------------------Question-Controller-----------------------------------------------------------*/
	
	
	@RequestMapping("questions")
	public String myQuestionList(
			@RequestParam(value="pg", defaultValue="1") int page, String mid, Principal principal,  Model model){
		
		mid = principal.getName();
		
		List<Question> list = questionDao.getList(page, mid);
		
		model.addAttribute("list", list);
		
		return "qna.questions";
		
	}
	

	@RequestMapping("questionsDelete")
	public String questionDelete(@RequestParam(value="c")String code){
	
		int rc = questionDao.delete(code);
		
		return "redirect:questions";
	}
	
	   @RequestMapping(value="questions-detail", method=RequestMethod.GET)
	   public String questionDetail(@RequestParam(value="c")String code ,Principal principal, Model model) {

		   //Blog blog= blogDao.get(code);
		   Blog blog= blogDao.get(code);
		   BlogGood blogGood=blogGoodDao.getLike(code);
		   BlogHate blogHate = blogHateDao.getHate(code);
		   Question question = questionDao.getQuest(code);
		   Question answer = questionDao.getAns(question.getCode());
		   blog.setLikeNum( blogGood.getLikeNum());
		   blog.setHateNum(blogHate.getHateNum());
		   List<BlogComment> list = commentDao.getList(code);
		  // List<Category> cList = categoryDao.getList("Pbwoo");
		   //model.addAttribute("b",blog);
		  // model.addAttribute("cList", cList);
		   System.out.println("------------------------------zzzz----------------");
		  //System.out.println( answer.getContent());
		   boolean ans;
		  if(answer==null)
			  ans=false;
		  else
			  ans=true;
		   
		   model.addAttribute("b",blog);
		   model.addAttribute("cmtList",list);
			model.addAttribute("q",question);
			model.addAttribute("a",answer);
			model.addAttribute("ans",ans);
	      return "qna.questions-detail";
	   }
	   
	   
	   @RequestMapping("qna-questions-search")
	   public String questionSearchResult(
	         /*@RequestParam(value="pg", defaultValue="1") int page,
	         @RequestParam(value="f", defaultValue="TITLE") String field,
	         @RequestParam(value="q", defaultValue="") String query*/
			   @RequestParam(value="search-opt") String opt, @RequestParam(value="search-term") String keyword, Model model, Principal principal){
		   String mid;
		  mid = principal.getName();
		  System.out.println(mid);
	      String keyword_trim;
	      keyword_trim = keyword.replace(" ", "");
	      // String [] keywords = keyword.split(" ");   
	      //System.out.println(keyword_trim);
	      
		     if(opt.equals("CONTENT")){
		    	
		    	  List<Question> list = questionDao.searchListContent(keyword_trim, mid);
			      model.addAttribute("list",list);
		     }
		     else if(opt.equals("TITLE")){
		    	  List<Question> list = questionDao.searchListTitle(keyword_trim, mid);
			      model.addAttribute("list",list);
		     }

	      return "qna.questions";
	   }
	
	/* --------------- question-board---------------------------------*/
	@RequestMapping("question-board")
	public String questionList(
			@RequestParam(value="pg", defaultValue="1") int page, Model model){
		
		List<Question> list = questionDao.getBoardList(page);
		
		model.addAttribute("list", list);
		
		return "qna.question-board";
		
	}
	
	   @RequestMapping("qna-question-board-search")
	   public String questionBoardSearchResult(
	         /*@RequestParam(value="pg", defaultValue="1") int page,
	         @RequestParam(value="f", defaultValue="TITLE") String field,
	         @RequestParam(value="q", defaultValue="") String query*/
			   @RequestParam(value="search-opt") String opt, @RequestParam(value="search-term") String keyword, Model model, Principal principal){
		   String mid;
		  mid = principal.getName();
	      String keyword_trim;
	      keyword_trim = keyword.replace(" ", "");
	      // String [] keywords = keyword.split(" ");   
	      //System.out.println(keyword_trim);
	      
		     if(opt.equals("CONTENT")){
		    	
		    	  List<Question> list = questionDao.searchBoardContent(keyword_trim, mid);
			      model.addAttribute("list",list);
		     }
		     else if(opt.equals("TITLE")){
		    	  List<Question> list = questionDao.searchBoardTitle(keyword_trim, mid);
			      model.addAttribute("list",list);
		     }

	      return "qna.question-board";
	   }
	
	   @RequestMapping(value="question-board-detail", method=RequestMethod.GET)
	   public String questionBoardDetail(@RequestParam(value="c")String code ,Principal principal, Model model) {

		   Blog blog= blogDao.get(code);
		   List<BlogComment> list = commentDao.getList(code);
		   List<Category> cList = categoryDao.getList("Pbwoo");
		   model.addAttribute("b",blog);
		   model.addAttribute("cList", cList);
		   model.addAttribute("cmtList",list);
			

	      return "qna.question-board-detail";
	   }
	
	   /*--------------------comment ------------------------------*/
	   
	   @RequestMapping(value="qnacomment", method=RequestMethod.GET)
	   public String comment(
				@RequestParam(value="c") String code,  //  default value ���߿� ���� �ϱ�
				Model model){
		   Blog blog = blogDao.get(code);
		   List<BlogComment> list = commentDao.getList(code);
			model.addAttribute("cmtList",list);
			model.addAttribute("b",blog);
			return "qna.comment";	  
	   }
	   
		
		@RequestMapping("qnacomment-reg-ajax")
		@ResponseBody
		public String noticeRegAjax(@RequestParam(value="c") String code,BlogComment blogcomment, Principal principal){
			
			//System.out.println(blogcomment.getContent());
			//blog.setMemberId(principal.getName()); ??
			//blog.setCode(principal.getClass()); ??
			//System.out.println(principal.getName());
			blogcomment.setMemberId(principal.getName());
			blogcomment.setBlogCode(code);
			
			 String content = null;
			   if(blogcomment.getContent().contains("\n")){
				   content= blogcomment.getContent().replace(System.getProperty("line.separator"), "<br/>");
				  
				   blogcomment.setContent(content);
			   }
			
			/*String comment = blogcomment.getContent();
			
			if(comment.contains("\r\n")){
				comment.replace("\r\n","<br>");
				System.out.println(comment);
			}
			blogcomment.setContent(comment);
			*///int rc =commentDao.add( blogcomment.getContent(),blogcomment.getBlogCode(), blogcomment.getMemberId());
			int rc =commentDao.add( blogcomment.getContent(),blogcomment.getBlogCode(), blogcomment.getMemberId() );
			
			//System.out.println(blogcomment.getMemberId()+blogcomment.getBlogCode()+blogcomment.getContent());
			return String.valueOf(rc);	
		}
		
	   

	/*-----------------JSON------------------------------------------------*/
	@RequestMapping(value="answersJSON", produces="text/plain;charset=UTF-8")
	@ResponseBody
	   public String answersJSON(
			   @RequestParam(value="page", defaultValue="1") int page, String mid
	         ){
	      
	      List<Answer> list = answerDao.getList(page, mid);
	      
	      StringBuilder json = new StringBuilder();
	      
	      json.append("[");
	      
	      for(Answer n : list){
	         String obj = String.format("{\"code\":\"%d\",\"title\":\"%s\", \"content\":\"%s\", \"Nickname\":\"%s\",\"hit\":\"%d\", \"regdate\":\"%s\", \"hashtag\":\"%s\", \"like\":\"%d\", \"hate\":\"%d\"}"
	        		 ,n.getCode(), n.getTitle(), n.getContent(), n.getNickname(),n.getHit(), n.getRegDate(),n.getHashTag(),n.getLike(),n.getHate());
	         json.append(obj);
	         
	         if(n != list.get(list.size()-1))  /*�������� �ƴ϶��*/
	            json.append(",");
	         
	      }
	      
	      json.append("]");
	      
	      return json.toString();
	   }
	
	@RequestMapping(value="qMenuJSON",produces="text/plain;charset=UTF-8")
	/*�̰� �����Ƿ� �䰡 �ʿ���� �ٷ� ����̵ȴ�. �̺κ��� �䰡 �Ǵ°�*/
	@ResponseBody

	public String qMenuJSON(@RequestParam(value="c", defaultValue="1") String count, String mid, Principal principal){
		System.out.println(count);
		
		mid = principal.getName();
		
		List<Question> list = questionDao.getNextList(count, mid);

		StringBuilder json = new StringBuilder();

		json.append("[");
		
		for(Question n : list){
			
			String content = n.getContent();
			if(content.contains("\n")){
				 content= content.replace(System.getProperty("line.separator"), "aa");
				      }
					 n.setContent(content);
			
			String obj = String.format("{\"code\":\"%d\",\"title\":\"%s\",\"content\":\"%s\",\"Nickname\":\"%s\",\"hit\":\"%d\",\"regdate\":\"%s\",\"hashtag\":\"%s\", \"blogCode\":\"%s\"}"
					, n.getCode(), n.getTitle(), n.getContent(), n.getNickname(), n.getHit(), n.getRegDate(), n.getHashTag(), n.getBlogCode());
			json.append(obj);
			
			if(n != list.get(list.size()-1))
				json.append(",");
		}
		json.append("]");
	

		 System.out.println("------------------------------------------------");
		 System.out.println(json.toString());
		
		return json.toString();
	}
	
	@RequestMapping(value="aMenuJSON",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String aMenuJSON(@RequestParam(value="c", defaultValue="1") String count, String mid, Principal principal){
		System.out.println(count);
		
		mid = principal.getName();
		
		List<Answer> list = answerDao.getNextList(count, mid);
		
		StringBuilder json = new StringBuilder();

		json.append("[");
		
		for(Answer n : list){
			
			String content = n.getContent();
			if(content.contains("\n")){
				 content= content.replace(System.getProperty("line.separator"), "aa");
				      }
					 n.setContent(content);
			
			String obj = String.format("{\"code\":\"%d\",\"title\":\"%s\",\"Nickname\":\"%s\",\"regdate\":\"%s\",\"hit\":\"%d\",\"content\":\"%s\", \"hashtag\":\"%s\",\"like\":\"%d\",\"hate\":\"%d\"}"
					, n.getCode(), n.getTitle(), n.getNickname(), n.getRegDate(), n.getHit(), n.getContent(), n.getHashTag(), n.getLike(), n.getHate());
			json.append(obj);
			
			if(n != list.get(list.size()-1))
				json.append(",");
		}
		json.append("]");
	

		 System.out.println("------------------------------------------------");
		 System.out.println(json.toString());
		
		return json.toString();
	}

	
	@RequestMapping(value="questionsJSON", produces="text/plain;charset=UTF-8")
	   @ResponseBody
	   public String questionsJSON(
			   @RequestParam(value="page", defaultValue="1") int page, String mid
	         ){
	      
	      List<Answer> list = answerDao.getList( page, mid);
	      
	      StringBuilder json = new StringBuilder();
	      
	      json.append("[");
	      
	      for(Answer n : list){
	         String obj = String.format("{\"title\":\"%s\", \"content\":\"%s\", \"Nickname\":\"%s\", \"regdate\":\"%s\", \"hashtag\":\"%s\"}"
	        		 , n.getTitle(), n.getContent(), n.getNickname(), n.getRegDate(),n.getHashTag());
	         json.append(obj);
	         
	         if(n != list.get(list.size()-1))  /*�������� �ƴ϶��*/
	            json.append(",");
	         
	      }
	      
	      json.append("]");
	      
	      return json.toString();
	   }
	
		@RequestMapping(value="questionboardJSON", produces="text/plain;charset=UTF-8")
	   @ResponseBody
	   public String questionboardJSON(
			   @RequestParam(value="page", defaultValue="1") int page, String mid
	         ){
	      
	      List<Answer> list = answerDao.getList( page, mid);
	      
	      StringBuilder json = new StringBuilder();
	      
	      json.append("[");
	      
	      for(Answer n : list){
	         String obj = String.format("{\"Title\":\"%s\", \"Content\":\"%s\", \"Nickname\":\"%s\", \"writer\":\"%s\", \"RegDate\":\"%s\", \"HashTag\":\"%s\"}"
	        		 , n.getTitle(), n.getContent(), n.getNickname(), n.getRegDate(),n.getHashTag());
	         json.append(obj);
	         
	         if(n != list.get(list.size()-1))  /*�������� �ƴ϶��*/
	            json.append(",");
	         
	      }
	      
	      json.append("]");
	      
	      return json.toString();
	   }
	   
		
		@RequestMapping(value="qnaCommentJSON", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
		@ResponseBody
		public String getLastFile( @RequestParam(value="c") String blogCode
		        ) {
			
			System.out.println(blogCode);
			List<BlogComment> list = commentDao.getList(blogCode);
			
			StringBuilder json = new StringBuilder();

			json.append("[");
		      
		      for(BlogComment n : list){
		    	  /*String content=n.getContent();
					if(content.contains("\n")){
						 content= content.replace(System.getProperty("line.separator"),"");
						 n.setContent(content);
					}*/
			
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
		      System.out.println(result);
		      return result;
			
			
		}
		
		 
/*/        ~~~~~~~~~~~~`etc 함수~~~~~~~~~~~~               /*/
	/*	nickname으로 id 값 받아오기*/
		@RequestMapping(value="qna-get-id", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
		@ResponseBody
		public String getId( @RequestParam(value="nickname") String nickname) 
		{
			//System.out.println(nickname);
			String result =  answerDao.getId(nickname);
			//System.out.println(result);
			return result;	
		}
			
	
}
