<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
		<h1 class="hidden">본문 영역</h1>
		<div id="title-area">
			<h2 class="hidden">글 정보</h2>
			<div>카테고리</div>
			<div class="title">${b.title }</div>
			<div>2016.06.13.22:00</div>
		</div>
		<!-- <div class="div-line">분할선</div> -->
		<main>
			<h2 class="hidden">글 내용</h2>
			<div id="content">
				${b.content}
			</div>
			<div class="hashtag">
				<h3 class="hidden">해시태그</h3>
				<ul>
					<li><a href="">#태그1</a></li>
					<li><a href="">#태그2</a></li>
					<li><a href="">#태그3</a></li>
				</ul>        
			</div>
			<div>
				<h3 class="hidden">글 평가</h3>
				<dl>
					<dt>좋아요</dt>
					<dd>22</dd>
					<dt>싫어요</dt>
					<dd>1</dd>
				</dl>
			</div>
<%-- 			<div>
				<ul>
					<li><a href="">수정</a></li>
					<li><a href="answers-delete?c=${b.code}">삭제</a></li><!-- 보류 -->
				</ul>
			</div> --%>
			<div>
				<a href="">답변달기</a>
			</div>
			<div>
				<a href="question-board">목록보기</a>
			</div>
		</main>	
	</div>
	
			<div id="comment">
		<h3 class="hidden">댓글</h3>
		
		<table  id="question-list" class="table"> 
			<thead>
				<tr>
					<td>작성자</td>
					<td>내용</td>
					<td colspan="4">작성일</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="n" items="${cmtList}"  begin="${fn:length(cmtList)-5}" end="${fn:length(cmtList)}"   step="1">
					<c:if test="${n.commentCode ==null }">
						<tr>
							<td class="writer">${n.nickname}</td>
							<td class="content">${n.content}</td>
							<td class="regdate">${n.regDate}</td>

							<td><a href="comment-edit?c=${n.code}">수정</a></td>
							<td><a href="comment-del?c=${n.code}">삭제</a></td>
							<td><a href="comment-charge?c=${n.code}">신고</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

		<div id="reply-article">
			<form>
			<fieldset></fieldset>
			<!-- 댓글 등록부분 -->
			<div class="article-content">
				<textarea id="txtContent" class="txtContent form-control" name="content"  placeholder="댓글을 입력해주세요"></textarea>
			</div>
			<div><textarea rows="" cols=""  id="code-value"  class="hidden">${b.code}</textarea></div>
			<div class="article-comment">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				<input class="btn-save btn btn-default" type="submit"value="입력"  />
			</div>
			</form>
		</div>
				
		<template id="comment-template">
		<tr>
			<td class="writer"></td>
			<td class="content"><a href=""></a></td>
			<td class="regdate"></td>
			<td><a href=""></a></td>
			<td><a href=""></a></td>
			<td><a href=""></a></td>
		</tr>
	</template>
		
		<div>
			<!-- <input type="button" value="댓글보기" /> -->
			<p>
				<input id="blog-code" type="hidden" name="code" value="${b.code}" ng-bind="blcode" />
				<a href="qnacomment?c=${b.code }">댓글 더 보기</a>
			</p>
		</div>

	</div>

	
<!-- 	<div>
		<h1 class="hidden">글 목록 영역</h1>
		 <div id="list"  class="container">
                
                <div class="item"><h2>1</h2></div>
                <div class="item"><h2>2</h2></div>
                <div class="item"><h2>3</h2></div>
                <div class="item"><h2>4</h2></div>
                <div class="item"><h2>5</h2></div>
                <div class="item"><h2>6</h2></div>
                <div class="item"><h2>7</h2></div>
                <div class="item"><h2>8</h2></div>
                <div class="item"><h2>9</h2></div>
                <div class="item"><h2>10</h2></div>
                <div class="item"><h2>11</h2></div>
                <div class="item"><h2>12</h2></div>
                <div class="item"><h2>13</h2></div>
                <div class="item"><h2>14</h2></div>
                <div class="item"><h2>15</h2></div>
                <div class="item"><h2>16</h2></div>
           </div>
		
	</div> -->