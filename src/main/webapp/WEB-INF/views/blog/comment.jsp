<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='uid'>${pageContext.request.userPrincipal.name}</c:set>
<c:set var='code'>${code }</c:set>
<div id="reply-wrapper">

      <h1 class="hidden">댓글 영역</h1>
      <div>
      	<a href="detail?c=${code}">블로그로 이동하기</a>
      </div>
      <c:forEach var="n" items="${cmtList}">
      <c:if test="${n.commentCode ==null }" >
      <div class="reply-container">
         <h2 class="hidden">댓글</h2>
         
         <div class="reply-user">
            <h3 class="hidden">유저정보</h3>
            <div><a href="">${n.nickname}</a></div>
         </div>
         
         <div class="reply-date">
            <h3 class="hidden">날짜</h3>
            <div>${n.regDate}</div>
         </div>
         
         <div class="reply-response">
            <h3 class="hidden">반응하기</h3>
            <ul>
            <c:set var="wid">${n.memberId }</c:set>
			<c:if test="${wid==uid }">
               <li><a href="comment-edit?c=${n.code}">수정</a></li>
               <li><a href="comment-del?c=${n.code}">삭제</a></li>
             </c:if>
               <li><a href="comment-charge?c=${n.code}">신고</a></li>
            </ul>
         </div>
         
         <div class="reply-content">
            <h3 class="hidden">댓글 내용</h3>
            <div>${n.content}</div>
         </div>
      </div>
         </c:if>
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
      </c:forEach>
      </div>
