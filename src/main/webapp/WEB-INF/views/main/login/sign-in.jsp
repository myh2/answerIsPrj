<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main id="main">
<div class="page-container">
	<h1>Sign In</h1>
	<form id="sign-in" action="sign-in" method="post">
		<div>
			<label>ID</label> <input type="text" name="id" class="id"
				placeholder="ID" />
		</div>
		<div>
			<label>Password</label> <input type="password" name="password"
				placeholder="Password" />
		</div>
		<div id="submit">
			<input type="submit" value="Sign in" />
		</div>
		<div id="menu">
			<ul >
				<li><a href="sign-up">회원가입</a></li>
				<li><a href="find-id">아이디 찾기</a></li>
				<li><a href="find-password">비밀번호 찾기</a></li>
			</ul>

		</div>


	</form>

</div>
</main>