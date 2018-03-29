<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main id="main">
<div id="my-info">
	<h1>회원 정보 수정</h1>
	<form id="info" action="my-info" method="POST">
		<fieldset>
			<div>
				<label>아이디</label>
				<p>${id}</p>
			</div>

			<div id="pwd">
				<label>현재 비밀번호</label> <input type="password" name="fromPwd" /> 
				<label>새비밀번호</label> <input type="password" name="toPwd1" /> 
				<label>새 비밀번호 확인</label> <input type="password" name="toPwd2" />
				<input type="button" value="변경하기">
			</div>

			<div>
				<label>이메일</label>
				<p>${email}</p>
				<!-- <input type="button" value="변경하기" /> -->
			</div>

			<div id="nickname">
				<label>닉네임</label> <input type="text" name="nickname"
					value="${nickname}" /> <input type="button" value="변경하기" />
			</div>

			<div>
				<label>생년월일</label>
				<p>${BirthDay}</p>
			</div>

<%-- 			<div>
				<label>프로필 사진</label>
				<p>${photo}</p>
				<input type="file" name="profileImg" />
			</div> --%>
			<div>
				<label>프로필 사진</label>
				<p>${photo}</p>
				<img id="blah" src="#" alt="your image" />
				<input type="file" name="profileImg" id="imgInp"/>
			</div>

			<div>
				<label>포인트</label>
				<p>${experience}</p>
			</div>

			<div>
				<label>블로그</label>
				<p>${blog}</p>
			</div>

			<div id="job-info">
				<label>관심 언어</label>
				<ul>
					<li>Java<input type="checkbox" name="myLanguage" value="1" /></li>
					<li>C<input type="checkbox" name="myLanguage" value="2" /></li>
					<li>C#<input type="checkbox" name="myLanguage" value="3" /></li>
					<li>C++<input type="checkbox" name="myLanguage" value="4" /></li>
					<li>JavaScript<input type="checkbox" name="myLanguage"
						value="5" /></li>
				</ul>

				<label>관심 플랫폼</label>
				<ul>
					<li>Windows<input type="checkbox" name="myPlatform" value="1" /></li>
					<li>OS X<input type="checkbox" name="myPlatform" value="2" /></li>
					<li>Linux<input type="checkbox" name="myPlatform" value="3" /></li>
					<li>Android<input type="checkbox" name="myPlatform" value="4" /></li>
					<li>iOS<input type="checkbox" name="myPlatform" value="5" /></li>
				</ul>

				<label>업무 분야</label> <select name="myJobClassMain">
					<option value="IT">IT</option>
					<option value="은행">은행</option>
					<option value="교육">교육</option>
				</select> <input placeholder="세부분야" type="text" name="myJobClassSub" />
				<!-- <input type="button" value="변경하기" /> -->
			</div>

			<div id="check-btn">
				<div>
					<input type="submit" class="submit" value="확인"> <input
						type="button" class="buttons" value="취소">
				</div>
			</div>

		</fieldset>
	</form>
</div>

</main>
