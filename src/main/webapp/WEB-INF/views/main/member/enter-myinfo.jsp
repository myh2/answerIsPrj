<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main id="main">
<div id="enter-myinfo">
	<h1>사용자 확인</h1>
	<form id="info" action="../member/enter-myinfo-check" method="GET">
		<fieldset>
			<div id="pwd">
				<label>비밀번호</label> <input name="pwd" type="password">
			</div>

			<div id="check-btn">
				<div>
					<input type="submit" class="submit" value="확인">
				</div>
			</div>

		</fieldset>
	</form>
</div>

</main>
