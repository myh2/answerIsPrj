<%-- <%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/zclip/1.1.2/jquery.zclip.min.js"></script>
<script  src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ext-language_tools.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<main id="content"  class="wrap-codelet"> 
<c:set var="context" value="${pageContext.request.contextPath}" />
	<div>
		<h2 class="hidden">content</h2>
		<form id="target"  method="POST">
			<input type="hidden" name="regMemberId" value="hyelee" /> 
			<select	id="languageCode" name="languageCode">
				<option value="" <c:if  test="${c.languageCode eq '' }">selected</c:if> >언어선택</option>
				<option value="c_cpp" <c:if  test="${c.languageCode eq 'c_cpp' }">selected</c:if> >C</option>
				<option value="css" <c:if  test="${c.languageCode eq 'css' }">selected</c:if> >CSS</option>
				<!-- <option value="c#" <c:if  test="${c.languageCode eq 'c#' }">selected</c:if> >C#</option> -->
				<option value="javascript" <c:if  test="${c.languageCode eq 'javascript' }">selected</c:if> >JavaScript</option>
				<option value="html" <c:if  test="${c.languageCode eq 'html' }">selected</c:if> >HTML</option>
				<option value="JSP" <c:if  test="${c.languageCode eq 'JSP' }">selected</c:if> >JSP</option>
				<option value="java" <c:if  test="${c.languageCode eq 'java' }">selected</c:if> >JAVA</option>
				<option value="mysql" <c:if  test="${c.languageCode eq 'mysql' }">selected</c:if> >MySQL</option>
				<!-- <option value="m" <c:if  test="${c.languageCode eq 'm' }">selected</c:if> >Objective-C</option> -->
				<option value="php" <c:if  test="${c.languageCode eq 'php' }">selected</c:if> >PHP</option>
				<!-- <option value="py" <c:if  test="${c.languageCode eq 'py' }">selected</c:if> >Python</option> -->
				<option value="r" <c:if  test="${c.languageCode eq 'r' }">selected</c:if> >R</option>
				<option value="rb" <c:if  test="${c.languageCode eq 'rb' }">selected</c:if> >Ruby</option>
				<option value="sql" <c:if  test="${c.languageCode eq 'sql' }">selected</c:if> >SQL</option>
				<option value="sqlserver" <c:if  test="${c.languageCode eq 'sqlserver' }">selected</c:if> >SQLServer</option>
				<option value="swift" <c:if  test="${c.languageCode eq 'swift' }">selected</c:if> >Swift</option>
				<option value="txt" <c:if  test="${c.languageCode eq 'txt' }">selected</c:if> >Text</option>
				<option value="xml" <c:if  test="${c.languageCode eq 'xml' }">selected</c:if> >XML</option>
				<option value="Django" <c:if  test="${c.languageCode eq 'Django' }">selected</c:if> >Django</option>
			</select>

		</div>
	
		<div id="div-tag">
			<legend class="hidden">codelet 등록 폼</legend>
				<div class="clearfix margin">
					<label>제목</label><input type="text" size="60" name="title" id="title" value="${c.title}"/>
					
					<c:if  test="${c.code ne null }">
		            	<label class="hidden">작성일</label><span class="title">${c.regDate}</span>
					</c:if>
	                
	            </dl>
			    </div>
				<div id="code1"><textarea class="hidden" id="txta" rows="30" cols="80">${c.codeSrc}</textarea></div>
	            <textarea class="hidden" name="codeSrc" id="txta" rows="30" cols="80">${c.codeSrc}</textarea>
				<div>
				<span>태그검색</span>
				<input type="text" size="80%"  id="hashTag"  name="hashTag" value="${c.hashTag}"/>					
				<input type="button" name="btn-myTag" value="나의 태그▽">
			</div>						
			<div id="div-myTagList"></div>
		</div>
		<div class="button-family">
			
<c:choose>
<c:when test="${c.code eq null }">

				<input type="button"  value="등록"  name="btn-save"  id="btn-save" />
</c:when>
<c:otherwise>
		            <input type="button"  value="수정" name="btn-save"  id="btn-save"  />
		            <input type="hidden" name="code" value="${c.code}"/>
</c:otherwise>
</c:choose>   			
				<a href="${pageContext.request.contextPath}/codelet">취소</a>

				<input type="hidden"  id="currentAction"  value=" <c:choose><c:when test="${c.code eq null }">R</c:when><c:otherwise>U</c:otherwise></c:choose>"  />
			</div>
		</form>
	</div>

</main>