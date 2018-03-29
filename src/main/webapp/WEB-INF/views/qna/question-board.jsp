<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="../resource/js/qna/answers.js" ></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  
<div id="question-board-header">
	<ul>
		<li><a href="answers">answers</a></li>
		<li><a href="questions">question</a></li>
		<li><a href="question-board">Q-board</a></li>
	</ul>
</div>
<div id="content">
	<h2 class="hidden">질문 게시판</h2>

	<div id="list-form">
		<h3 class="hidden">정렬 폼</h3>
		<ul>
			<li><input type="checkbox" /> 공지숨기기</li>
			<li><select name="sort-option">
					<option value="최신순">최신순</option>
					<option value="답변있는글만">답변有</option>
					<option value="답변없는글만">답변無</option>
			</select></li>
			<li><select name="flatform">
					<option value="">플랫폼</option>
					<option value="">플랫폼</option>
					<option value="">플랫폼</option>
					<option value="">플랫폼</option>
			</select></li>
			<li><select name="language">
					<option value="java">java</option>
					<option value="c">c</option>
					<option value="c#">c#</option>
					<option value="c++">c++</option>
			</select></li>


		</ul>
	</div>

	<h3 class="hidden">질문 목록</h3>
	<div id="question-list-div">
		<table id="question-list" >
			<thead>
				<tr>
					<td class="seq">번호</td>
					<td class="title">제목</td>
					<td class="writer">작성자</td>
					<td class="regdate">작성일</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="n" items="${list}">
				<tr>
				
					<td class="code">${n.code}</td>
					<td class="title"><a href="question-board-detail?c=${n.blogCode}">${n.title}</a></td>
					<td class="writer">${n.nickname }</td>
					<td class="regdate">${n.regDate }</td>
	
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="member-menu" ></div>

	<div id="moreList">
		<center><input type="button" value="더보기" /></center>
	</div>

	<!-- 페이징 
	<div id="pager">
		<p>
			<a class="" href="">이전</a>
		</p>
		pc용                <ul>
                  <li>
                     <a href="">1</a>
                  </li>
                  <li>
                     <a href="">2</a>
                  </li>
                  <li>
                     <a href="">3</a>
                  </li>
                  <li>
                     <a href="">4</a>
                  </li>
                  <li>
                     <a href="">5</a>
                  </li>
               </ul>
		<p>
			<a class="" href="">다음</a>
		</p>
	</div>
 -->
	<form id="search-form" action="qna-question-board-search" method="get">
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


		<div id="moveTop">  <!-- 상단으로 이동 -->
			<input type="image" src="../resource/images/top.png" />
 		</div>

</div>
</html>
