<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<div id="header">
		<h1 class="hidden">헤더 영역</h1>
		<div class="content-container">		
			<h2 class = "hidden">Answeris Header</h2>
			<div>
			</div>
			<h2 class = "hidden">Blog Header</h2>
			<ul>
				<li id="open">목록</li>
				<li>블로그 이름</li>
			</ul>
		</div>
	</div>
	
	<form action="comment-edit" method="post">
		<input type="hidden" name="code" value="${n.code}" />	
		<input type="hideen" name="blogCode" value="${n.blogCode}"/>	
	<div id="reply-input">
		<h1 class="hidden">댓글입력 영역</h1>
		<div>
			<textarea name="content">${n.content}</textarea>
			<input type="submit" value="수정"/>
			<a class="btn-cancel button" href="comment?c=${n.blogCode}">취소</a>	
		</div>
	</div>
	</form>
	
	
	