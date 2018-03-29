<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 쪽지 쓰기 -->
<main id="main"> <!-- 쪽지 쓰기 -->
<div class="send_window">

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
	<form action="../messagebox/write-message-sender" method="POST">
		<fieldset>
			<div id="normalMode">
				<span class="tf_tit"> <label for="who" class="recipient">받는사람</label>
					<input name="id" type="text"  placeholder="아이디" value="${reply}" />
					<!--  <a href="#" id="addressButton" class="">주소록</a> -->
				</span> <span> 
				<input type="checkbox"
					value="${pageContext.request.userPrincipal.name}" id="checkBox">
					<label for="chk_tome">내게쓰기</label>
				</span>
			</div>

			<div class="writing_area">

				<textarea id="writeNote" name="text"></textarea>
			</div>
	<div class="writing_option">
		<div class="character">
			<span id="noteLen">0</span> / <span id="noteMaxLen">1,000</span>자
		</div>
	</div>

	<div id="check">
		<input type="submit" value="send">
	</div>

		</fieldset>
	</form>

</div>
</main>