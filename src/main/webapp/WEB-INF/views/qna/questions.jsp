<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script type="text/javascript" src="../resource/js/qna/questions.js" ></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


<div id="questions-header">
	<ul>
		<li><a href="answers">answers</a></li>
		<li><a href="questions">question</a></li>
		<li><a href="question-board">Q-board</a></li>
	</ul>
</div>
<div id="content">
	<h2 class="hidden">나의 질문</h2>

<form id="search-form" action="qna-questions-search" method="get">
		<fieldset>
			<legend class="hidden"> 목록 검색 폼 </legend>

			<input type="hidden" name="" value="" /> 
			<label for=""	class="hidden">검색필드</label> 
			<select name="search-opt" class="opt">
				<option value="TITLE">제목</option>
				<option value="CONTENT">내용</option>
			</select> 
			<label class="hidden" for="">검색어</label> 
			<input type="text" name="search-term"  class="form-search"  placeholder="qna 검색"/> 
			<input type="submit" value="검색"  class="btn btn-default"/>
		</fieldset>
	</form>

<!-- 	<div class="sort-div">
		<h3 class="hidden">정렬 폼</h3>
		<ul class="hidden">
			<li><a href="answers-small-list"><img src="" alt="목록형" /></a></li>
			<li><a href="answers-big-list"><img src="" alt="펼쳐진 목록형" /></a></li>
			<li><a href="answers-square-list"><img src="" alt="격자형" /></a></li>
		</ul>
	</div> -->

	<h3 class="hidden">나의 질문 목록</h3>

	<div id="question-all">
		<h3 class="hidden">나의 답변 목록</h3>
		<legend class="hidden">공지사항 필드들</legend>

		<div class="question-all-table">
			<c:forEach var="n" items="${list}">
			<!--  <div> -->
				<dl>
					<dd class="code">${n.code}</dd>

					<dd class="title"><a href="questions-detail?c=${n.blogCode }" >${n.title}</a></dd>
					
				
<%-- 				    <dd class="writer">${n.nickname}</dd>
				   		 <dd id="member-menu" ></dd> <!-- 회원정보목록 -->
 --%>
					<dd class="hit">${n.hit}</dd>

					<dd class="regdate">${n.regDate}</dd>
					
					<dd class="content"><a href="questions-detail?c=${n.blogCode }" >${n.content}</a></dd>

					<dd class="hashtag">${n.hashTag}</dd>

				</dl>
				<!-- </div> -->
			</c:forEach>
		</div>

	</div>	
	
	<div id="load-more">
		<center><input type="button"  class="btn btn-success"  value="more" /></center>
	</div>

	<div id="moveTop">   <!-- 상단으로 이동 -->
		<input type="image" src="../resource/images/top.png" />
	</div>
	
	

		<!-- -------------------------------- 댓글 목록------------------------------------------------------------------------------------ -->

<%-- 		<div id="comment-list">
			<input type="hidden" name="writer" value="${loginId}" />
			<textarea cols="30" rows="2" id="comment" name="comment"></textarea>
			<input type="submit" id="reply-btn" value="등록" />

			<table>

				<tr>
					<td colspan="30"
						style="padding: 5px 0 2px 0; text-align: left; border: none;">
						<span style="font-weight: 600; color: #7e53ac;">작성자왈${writer}
					</span>
					</td>
				</tr>
				<tr>
					<td style="border-top: none; border-bottom: 1px solid #dededb;">내용이다으아아아ddddddddds${comment}</td>
					<td
						style="border-top: none; padding-left: 30px; border-bottom: 1px solid #dededb;">2016-06-29${regdate}</td>
				</tr>

				<tr>
					<td colspan="30"
						style="padding: 5px 0 2px 0; text-align: left; border: none;">
						<span style="font-weight: 600; color: #7e53ac;">갑을병정${writer}
					</span>
					</td>
				</tr>
				<tr>
					<td style="border-top: none; border-bottom: 1px solid #dededb;">fuck
						uuuuuuuu${comment}
					</td>
					<td
						style="border-top: none; padding-left: 30px; border-bottom: 1px solid #dededb;">2016-06-29${regdate}</td>
				</tr>
		
			</table>

		</div> --%>

		<!-- <a class="button" href="">수정</a> pc용-->
		<!-- <a class="button" href="">삭제</a> -->
		
	
	

</div>
</html>
