<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="../resource/js/qna/questions-detail.js" ></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="body" ng-controller="questions-detail-controller">
	<h1 class="hidden">디테일 보기</h1>

	<div id="title-area">
		<h2 class="hidden">글 정보</h2>
		<div class="title">${q.title }</div>
		<div>
			<h3 class="hidden">질문보기</h3>
			<input type="button"  value="질문보기" ng-click="formVisible =! formVisible"  class="btn btn-success"/><!-- angular로 만들기 -->
			 <div class="show-question"  ng-show="formVisible">
            	<h3 class="hidden">질문보기세부내용</h3>
            			<legend class= "hidden">질문 세부 필드들</legend>
            			<dl>
            				<dt><label for="writer">작성자</label></dt>
            				<dd>${q.nickname }</dd>
            				<dt><label for="content">내용</label></dt>
            				<dd>${q.content }</dd>
            				<dt><label for="content">등록일자</label></dt>
            				<dd>${q.regDate }</dd>
            			</dl>
          	  </div>

		</div>
		<!-- <div class="category">카테고리</div> -->
		<div>${a.regDate}</div>
	</div>
	<!-- <div class="div-line">분할선</div> -->

	<div id="content-area">
		<h2 class="hidden">글 내용</h2>
		<div id="content" >${a.content}</div>
		<div id="content"  ng-show="!${ans}">등록된 답변이 없습니다.</div>
	
		<%-- <div class="hashtag">
			<h3 class="hidden">해시태그</h3>
			<ul>
				<li><a href="">${a.hashtag }</a></li>
			</ul>
		</div> --%>

		<div id="like-hate">
			<h3 class="hidden">글 평가</h3>
			<ul>
				<li>
					<i class="fa fa-thumbs-o-up" aria-hidden="true">    ${b.likeNum}</i>
				</li>
				<li>
					<i class="fa fa-thumbs-o-down" aria-hidden="true">    ${b.hateNum}</i>
				</li>
			</ul>
		</div>


		<div id="edit">
			<ul>
				<li>
					<a href="${pageContext.request.contextPath}/blog/detail?c=${q.code}">
					<i class="fa fa-pencil" aria-hidden="true"></i>
					수정
					</a>
				</li>
				<!-- edit 페이지 만들면 수정 -->
				<li>
					<a href="${pageContext.request.contextPath}/qna/answersDelete?c=${q.code}">
					<i class="fa fa-trash-o" aria-hidden="true"></i>
					삭제
					</a>
				</li>
				<li><a href="${pageContext.request.contextPath}/qna/questions"><i class="fa fa-list" aria-hidden="true"></i>
				목록으로</a></li>
			</ul>
		</div>
		
		<div id="prev-next">
			<ul>
				<li>
					<i class="fa fa-angle-left" aria-hidden="true"></i>
					<a href="${pageContext.request.contextPath}/qna/answers-detail?c=${cmtList[q.code].code-1}">이전글</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/qna/answers-detail?c=${cmtList[q.code].code+1}">다음글</a>
					<i class="fa fa-angle-right" aria-hidden="true"></i>
				</li>
			</ul>
		</div>
	</div>

	<div id="member-info" ></div>

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
			<%-- <c:if test="${fn:length(cmtList)-5} > 0 }"> --%><!-- 댓글 5개 이하일때 수정하기 -->
				<c:forEach var="n" items="${cmtList}"  begin="${fn:length(cmtList)-5}" end="${fn:length(cmtList)}"   step="1">
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
			<%-- </c:if>
			<c:if test="${fn:length(cmtList)-5} < 0 }">
				<c:forEach var="n" items="${cmtList}">
					<c:if test="${n.commentCode ==null }">
						<tr>
							<td class="writer"><a href="">${n.nickname}</a></td>
							<td class="content">${n.content}</td>
							<td class="regdate">${n.regDate}</td>

							<td><a href="comment-edit?c=${n.code}">수정</a></td>
							<td><a href="comment-del?c=${n.code}">삭제</a></td>
							<td><a href="comment-charge?c=${n.code}">신고</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if> --%>
			
			</tbody>
		</table>

		<div id="reply-article">
			<form>
			<!-- 댓글 등록부분 -->
			<div class="article-content">
				<textarea id="txtContent" class="txtContent form-control" name="content" placeholder="댓글을 입력해주세요"></textarea>
			</div>
			<div><textarea rows="" cols=""  id="code-value"  class="hidden">${q.blogCode}</textarea></div>
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
				<input id="blog-code" type="hidden" name="code" value="${q.blogCode}" ng-bind="blcode" />
				<a href="qnacomment?c=${q.blogCode}">댓글 더 보기</a>
			</p>
		</div>

	</div>

</div>

<%-- 
		<div id="reply-wrapper">
		<h1 class="hidden">댓글 영역</h1>
		
		<c:forEach var="n" items="${cmtList}">
		<div class="reply-container">
			<h2 class="hidden">댓글</h2>
			
			<div class="reply-user">
				<h3 class="hidden">유저정보</h3>
				<div><a href="">${n.memberId}</a></div>
			</div>
			
			<div class="reply-date">
				<h3 class="hidden">날짜</h3>
				<div>${n.regDate}</div>
			</div>
			
			<div class="reply-response">
				<h3 class="hidden">반응하기</h3>
				<ul>
					<li><a href="">수정</a></li>
					<li><a href="">삭제</a></li>
					<li><a href="">신고</a></li>
				</ul>
			</div>
			
			<div class="reply-content">
				<h3 class="hidden">댓글 내용</h3>
				<div>${n.content}</div>
			</div>
			
		</div>
		</c:forEach>
		
		
		
		<div>
			<h2 class="hidden">댓글 더보기</h2>
			<input id="btn-reply-more" type="button" value="댓글 더보기"/>
		</div>
	</div>
	
	<div id="reply-input">
		<h1 class="hidden">댓글입력 영역</h1>
		<div>
			<textarea></textarea>
			<input id="btn-reply-input" type="button" value="입력" />
		</div>
	</div>
	<div>
		<a href="answers">목록보기</a>
	</div> --%>
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