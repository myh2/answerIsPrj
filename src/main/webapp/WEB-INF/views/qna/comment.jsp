<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>


<div id="reply-wrapper">

	<h1 class="hidden">댓글 영역</h1>
			
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

	<div id="member-info" ></div>
	
	<table id="question-list"  class="table">
		<thead>
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td colspan="4">작성일</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="n" items="${cmtList}">
				<c:if test="${n.commentCode ==null }">
					<tr>
						<td>
							<input type = "button" value = "${n.nickname}" class = "writer"/>
							<input type = "text" value ="${pageContext.request.contextPath}" class ="hidden pageContext"/>
						</td>
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
		<!-- 댓글 등록부분 -->
		<div class="article-content">
			<textarea id="txtContent" class="txtContent form-control" name="content" placeholder="댓글을 입력해주세요"></textarea>
		</div>
		<div><textarea rows="" cols=""  id="code-value"  class="hidden">${b.code}</textarea></div>
		<div class="article-comment">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			<input class="btn-save btn btn-default" type="submit"value="입력"  />
		</div>
		</form>
	</div>



	<%--   
      <div class = "reply-second">
         <c:forEach var="cc" items="${cmtList}">
         <c:if test="${n.code == cc.commentCode }" >
            <div class="reply-user">
            <h4 class="hidden">유저정보</h4>
            <div><a href="">${cc.nickname}</a></div>
         </div>
         
         <div class="reply-date">
            <h4 class="hidden">날짜</h4>
            <div>${cc.regDate}</div>
         </div>
         
         <div class="reply-response">
            <h4 class="hidden">반응하기</h4>
            <ul>
               <li><a href="comment-edit?c=${cc.code}">수정</a></li>
               <li><a href="comment-del?c=${cc.code}">삭제</a></li>
               <li><a href="comment-charge?c=${cc.code}">신고</a></li>
            </ul>
         </div>
         
         <div class="reply-content">
            <h4 class="hidden">댓글 내용</h4>
            <div>${cc.content}</div>
         </div>
            
         </c:if>
         </c:forEach>
         </div>
      </c:forEach> --%>

</div>
