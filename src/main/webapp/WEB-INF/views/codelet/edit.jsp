<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
<c:set var="context" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/zclip/1.1.2/jquery.zclip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ext-language_tools.js"></script>
   

<main id="content" class="wrap-codelet">
   <%-- <h1 class="hidden">codelet</h1>
      <h2 id="content-main">CodeletEdit Page</h2>
         
         <section>
         <form id="search-form" method="get">
            <fieldset>
               <legend class="hidden">코드릿 검색 폼</legend>
               <!-- <input id="langlist-button" type="button" value="언어선택▼" /> -->
             	<select>
             		<option>등록언어별</option>
             	<c:forEach var="n" begin="0" end="${fn:length(langList)}" step="1" items="${langList}">
             		
             		<option class="langlist">${n.languageCode}</option>
             		
             	</c:forEach>
             	</select>
               <select id="select">
               	<option>제목</option>
               	<option>해시태그</option>
               </select>
               
               <input type="text" size="40" name="q" />
               <input type="submit" value="검색" />
            </fieldset>
             
         </form>
      </section>
      
      <div id="save-button">
            <input class="btn-save button" type="button" onclick="location.href='${pageContext.request.contextPath }/codelet-reg'"  value="글쓰기" />
      </div> --%>
      

   <div>
      <div>
         <h3 class="hidden">content</h3>      
         <form action="codelet-edit" method="POST">      
            <div>
            <input id="languageCode" class="margin" type="text" name="${c.languageCode}" value="${c.languageCode}" />
        	</div>
	         <div id="title" class="clearfix margin">
	            <dl class="title">
	               <dt class="hidden">제목</dt>
	               <dd class="title"><input type="text" name="title" value="${c.title}"/></dd>
	               <%-- <dd class="title">${c.title}</dd> --%>
	            </dl>
	            <dl class="title regdate">
	               <dt class="hidden">작성일</dt>
	               <dd class="title">${c.regDate}</dd>
	            </dl>
	            <dl class="title hidden">
	               <dt class="hidden">조회수</dt>
	               <dd class="title">100</dd>
	            </dl>
	         </div>     
            <div id="code1"><textarea class="hidden" id="txta" rows="30" cols="80">${c.codeSrc}</textarea></div>
            <textarea class="hidden" name="codeSrc" id="txta" rows="30" cols="80">${c.codeSrc}</textarea>
            <div id="tag">
               <label for="find-tag">태그검색 </label>
               <input name="find-tag" type="text" size="68" value="#JSP, #JAVA" />
               <fieldset>
                  <legend>자동완성태그는스크립트로해야함쓰</legend>
                  <ul id="tag-auto">
                     <li><a href="">JAVA</a></li>
                     <li><a href="">JAVASCRIPT</a></li>
                  </ul>
               </fieldset>
            </div>
            
            <div id="tag-freq">
               <fieldset>
                  <legend>자주사용하는 태그</legend>
                  <ul id="tag-list">
                     <li><a href="">C</a></li>
                     <li><a href="">C++</a></li>
                     <li><a href="">HTML</a></li>
                     <li><a href="">JSP</a></li>
                  </ul>
               </fieldset>
            </div>
		      <p class="button-family">
		            <input type="submit" onclick="alert('수정되었습니다')" value="수정" />
		            <input type="hidden" name="code" value="${c.code}"/>
		            <a  href="${pageContext.request.contextPath}/codelet">취소</a>
		      </p>
         </form>
      </div>
   </div>
</main>