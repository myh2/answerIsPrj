<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 쪽지 쓰기 -->
<main id="main">
<div class="read-datail">

	<nav id="main-menu">
	<h1 class="hidden">메인메뉴</h1>
	<ul class="clear fix">
		<li class="main-menu-item"><a class="main-menu-item-text"
			href="/AnswerisPrj/main/messagebox/rcv-message">받은쪽지함</a></li>
		<li class="main-menu-item"><a class="main-menu-item-text"
			href="/AnswerisPrj/main/messagebox/send-message">보낸쪽지함</a></li>
		<li class="main-menu-item"><a class="main-menu-item-text"
			href="/AnswerisPrj/main/messagebox/write-message?wh=">쪽지쓰기</a></li>
	</ul>
	</nav>

	<div class="main-content">
		<c:forEach var="m" items="${list}">
		<div id="buttons">
			<c:if test="${m.check eq '1'}">
				<c:if test="${m.sendId ne '나'}"><a href="write-message?wh=${m.sendId}"><input type="button" value="답장"/></a>
				</c:if>
			</c:if>
			<input type="button" value="삭제" />   
		</div>

		<div id="container">
				<c:if test="${m.check eq '1'}">
					<div id="sender">
						<label>보낸사람</label>
						<p>
							<a>${m.sendId}</a>
						</p>
					</div>
				</c:if>
				<c:if test="${m.check eq '0'}">
					<div id="sender">
						<label>받은사람</label>
						<p>
							<a>${m.rcvId}</a>
						</p>
					</div>
				</c:if>

				<div id="sendTime">
				<c:if test="${m.check eq '1'}">
					<label>받은시간</label>
				</c:if>
				<c:if test="${m.check eq '0'}">
					<label>보낸시간</label>
				</c:if>
				
					<p>
						<a>${m.year}/${m.day} ${m.time}</a>
					</p>
				</div>
				<div id="content">
					<p>
						<a>${m.content}</a>
					</p>
				</div>
		</div>
		</c:forEach>
	</div>
</div>

</main>