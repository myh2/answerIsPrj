<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:set var='uid'>${pageContext.request.userPrincipal.name}</c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div id = "detail-all" ng-app="detailApp">
	<div ng-controller="detailController">
		<div>
			<input id="abcd" type="button" ng-click="test()"  value="{{vv}}" />
			<h1 class="hidden">본문 영역</h1>
		</div>

	<div>
		<h1 class="hidden">본문 영역</h1>
		<div id="title-area">
			<h2 class="hidden">글 정보</h2>
			<div>${b.categoryName }</div>
			<div class="title">${b.title }</div>
			<div>${b.regDate }</div>
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
					<c:forTokens items="${b.hashtag}" delims=" " var="tag">
						<li>${tag}</li>
					</c:forTokens>
				</ul>
			</div>

			<div>
				<div id="like-num">${b.likeNum}</div>
				<div id="get-code">${b.code }</div>
			</div>
			<div id="title-area">
				<h2 class="hidden">글 정보</h2>
				<div>${b.categoryName }</div>
				<div class="title">${b.title }</div>
				<div>${b.regDate }</div>
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
						<c:forTokens items="${b.hashtag}" delims=" " var="tag">
							<li>#${tag}</li>
						</c:forTokens>
					</ul>
				</div>
				<div>
					<h3 class="hidden">글 평가</h3>
					<dl>
						<dt>좋아요</dt>
						<dd ng-model="likeNum"></dd>
						<!-- <dt>싫어요</dt>
						<dd>1</dd> -->
					</dl>
				</div>
				<!-- -------------------박현욱님 수정부분 수정 페이지 만들기------------------ -->
				<c:set var='wid'>${b.memberId}</c:set>
				<c:set var='uid'>${pageContext.request.userPrincipal.name}</c:set>
				<c:if test="${wid==uid}">
					<div>
						<a href="modify?c=${b.code}">수정</a>
					</div>
					<div>
						<a href="delete?c=${b.code}">삭제</a>
					</div>
					<div>
						<a href="publish?c=${b.code}">공개</a>
					</div>
				</c:if>
			</main>
			
		</div>
	
		<div id="reply-wrapper">
			<h1 class="hidden">댓글 영역</h1>
			
			<c:forEach var="n" items="${cmtList}" end="3">
			<div>
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
			
			</c:forEach>
				<div>
				<input class="hidden" type="button" id="codeBtn" value="dd" ng-click="blogCode(${b.code})">
				</div>
			
			
			
			<div>
				<h2 class="hidden">댓글 더보기</h2>
			<a class="hidden" id="moreComment-href" href="comment?c=${b.code}">123</a>
	         <input id="btn-reply-more" type="button" value="댓글 더보기" /> 
			</div>
		</div>
		
		<div id="reply-input">
			<h1 class="hidden">댓글입력 영역</h1>
			<div>
				<form action="blogcomment-reg-ajax" method="post">
					<input id="blog-code" type="hidden" name="bc" value="${b.code}"/>
					
					<textarea id="comment-textarea" name="content"></textarea>
					<input id="btn-reply-input" type="submit" value="입력" />
				</form>
			</div>
		</div>
		
		<div>
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
			
		</div>
	</div>
</div>