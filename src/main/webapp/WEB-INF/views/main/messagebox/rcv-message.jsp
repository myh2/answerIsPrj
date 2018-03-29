<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 받은 쪽지함 -->
<main id="main">
<div class="rcvMessage">

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
		<div id="buttons">
			<input type="button" value="삭제" />
		</div>

		<div class="section_head"></div>

		<div id="tableDiv">
			<table>
				<tr>
					<th><input id="checkAll" type="checkbox" /></th>
					<th class="th-id">보낸사람</th>
					<th class="th-content">내용</th>
					<th class="th-date">날짜</th>
					<!-- <th class="th-read">읽음</th> -->
				</tr>
				<tbody class="mList">
				<c:forEach var="m" items="${list}">
					<tr class="checkboxes">
						<td><input type="checkbox"  data-value="${m.code}"/></td>
						<td class="id"><a>${m.sendId}</a></td>
						<td class="content" ><a href="detail?c=${m.code}&ch=1"><div>${m.content}</div></a></td>
						<td class="date"><div><a>${m.day}</a></div><div><a>${m.read}</a></div></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="pager">
			<div id="prev">
				<a href="">이전</a>
			</div>
			<ul>
				<li><a id="" href="rcv-message?pg=1">1</a></li>
				<li><a id="" href="rcv-message?pg=2">2</a></li>
				<li><a id="" href="rcv-message?pg=3">3</a></li>
				<li><a id="" href="rcv-message?pg=4">4</a></li>
				<li><a id="" href="rcv-message?pg=5">5</a></li>
			</ul>

			<div id="next">
				<a href="">다음</a>
			</div>
		</div>
	</div>
</main>