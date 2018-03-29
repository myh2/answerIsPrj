<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="context" value="${pageContext.request.contextPath}"/>
	<c:set var='wid'>${blogId}</c:set>
	<c:set var='uid'>${pageContext.request.userPrincipal.name}</c:set>

<div>


	<div id="blog-contents">
		<input type="button" ng-click="test()" value="test" />
		<c:forEach var="n" items="${list}">
			
			<div class="bulletin-container">
				<div class="click-area">
					<div class="bulletin-title">
						<h1>${n.title}</h1>
						<div class="link">
							<a class="hidden" href="${context }/${blogId }/detail?c=${n.code}">www.answeris.net/michaelpark7</a>
						</div>
					</div>
				</div>
				<div class="content click-area">${n.content}</div>
				<div class="hash-tag">
					<ul>
						<li>${n.hashtag}</li>
	
					</ul>
	
				</div>
				<div class="comm-mod-container">
					<div  class="comm">
							
							<div><a href=""><i class="fa fa-commenting-o" aria-hidden="true"></i> 댓글</a></div>
							<div ><a ng-click="likeClick(n.code)"  class="likeBtn"  href="">
							<i  class="fa fa-thumbs-o-up" aria-hidden="true"></i>
							 좋아요(<span ng-bind="n.likeNum"></span>)</a></div>
						
					</div>
					<c:if test="${wid==uid}">
						<div class="modify">
							
								<div><a href=""><i class="fa fa-pencil" aria-hidden="true"></i> 수정</a></div>
								<div><a href=""><i class="fa fa-trash-o" aria-hidden="true"></i> 삭제</a></div>
							
						</div>
					</c:if>
				</div>
			</div>
		</c:forEach>
	
	</div>
	<div class="add-btn-container">
		<form action="" method="post">
	
			<input class="hidden" type="text" name="c"/> 
			<input id="add-btn" type="button" ng-click="addClick()" value="더보기" class="hidden content-add " />
	
		</form>
	
	
	</div>

	<c:if test="${wid==uid}">
		<div id="btn-blog-write">
				<a href="${context}/${uid }/regist"><img src="${context }/resource/images/btn-blog-write.png" /></a>
		</div>
	</c:if>
</div>