<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<script   src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/zclip/1.1.2/jquery.zclip.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ext-language_tools.js"></script>

<main id="content">
     <div>
      <h3 class="hidden">content</h3>
      <div>
         <input id="languageCode" class="hidden" type="text" name="${c.languageCode}" value="${c.languageCode}" />
      </div>
      <div id="title">
         <p>
            <span class="hidden">제목</span>
            <span class="h3">${c.title}</span>
            <span class="hidden">작성일</span>
            <span class="title-right h5">${c.year}/${c.day}</span>
         </p>
      </div>
      
      <div id="code1"  class="col-md-10 col-xs-6"><textarea name="codeSrc" id="code1">${c.codeSrc}</textarea></div>
      
      <div>
      <!-- <div id="sns">
         <ul>
            <li><a href="https://www.facebook.com/"> <img src="../../resource/images/facebook.png" alt="facebook" /></a></li>
            <li><a href="https://twitter.com"> <img src="" alt="kakao" /></a></li>
            <li><a href="https://www.google.co.kr/"> <img src="" alt="google" /></a></li>
            <li><a href="https://github.com/"> <img src="" alt="github" /></a></li>
         </ul>
      </div> -->

      <p class="text-right">
		 <button style="font-size: 10px; font-weight: 400; line-height: 1.42857143;" type="button" class="btn btn-default btn-lg" id="fav" ><span class="" aria-hidden="true"></span></button>
		 <span class="hidden">${c.favorite}</span>
		 <span class="hidden">${c.code}</span>
         <input class="btn btn-default" type="button" onclick="alert('준비중입니다.')" value="실행">
         <a style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;"class="btn btn-default" href="${pageContext.request.contextPath }/codelet">목록</a> 
         <a style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;"class="btn btn-default" href="${pageContext.request.contextPath }/codelet-edit?c=${c.code}">수정</a>
         <a style="font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;"class="btn btn-default" href="${pageContext.request.contextPath }/codelet-del?c=${c.code}">삭제</a>
         <input class="btn btn-default" id="copy-button" type="button" value="클립보드로 복사">
      </p>
      </div>
   </div>
</main>