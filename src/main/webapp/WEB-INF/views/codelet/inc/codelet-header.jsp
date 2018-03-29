<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script src="../../resouce/js/modernizr-custom.min.js"></script>		
<script src="${context }/resource/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="${context }/resource/js/codelet/aside.js" ></script>

<h1 class="hidden">codelet</h1>
<h2 id="content-main" class="text-center">Codelet</h2>
<section class=" text-center">
	<form class="form-inline" id="search-form" method="get" action="codelet">
		<fieldset>
			<!-- <legend class="hidden">코드릿 검색 폼</legend> -->
			<!-- <input id="langlist-button" type="button" value="언어선택▼" /> -->
			<div class="form-group">
			<select class="form-control codelet-header-selectbox" name="sortSelec" id="sortSelec">
				<option label="등록언어별"></option>
				<c:forEach var="n" begin="0" end="${fn:length(langList)}" step="1" items="${langList}">
					<option class="langlist" value="${n.languageCode}">${n.languageCode}</option>
				</c:forEach>
			</select>
			</div>
			<div class="form-group">
			 <select class="form-control codelet-header-selectbox" name="select" id="select">
				<option></option>
				<option value="title">제목</option>
				<option value="hashtag">해시태그</option>
			</select>
			</div>
			<input placeholder="검색어를 입력하세요" type="text" size="40" name="q" class="form-control"/>
			<input class="btn btn-default" type="submit" value="검색" />
		</fieldset>
	</form>
</section>
<div id="save-button" class="text-right">
	<input class="btn btn-default"  type="button" onclick="location.href='${pageContext.request.contextPath }/codelet-reg'" value="글쓰기" />
</div>