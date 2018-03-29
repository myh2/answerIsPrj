<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="blog-set-container" ng-controller="blogSetController">
	<h1 class="hidden">카테고리 관리,설정</h1>
	<div id="blog-set-category-nav">
		<h1 class="hidden">카테고리 내비게이션</h1>
		<div>
			<a href="" ng-click="colors.push({})">카테고리 추가</a> <a href="">구분선
				추가</a> <input class="button" id="blog-set-category-del" type="submit"
				value="삭제" />
		</div>
	</div>
	<div id="blog-set-category">
		<h1 class="hidden">카테고리 전체보기</h1>
		<ul>
			<c:forEach var="c" items="${cList}">
				<li id="blog-category" value="${c.code}"><a href=""
					ng-click="categoryEditFunction()">${c.name}</a></li>
			</c:forEach>
			<li ng-repeat="color in colors">
			<label><input type="text"></label>
				<button ng-click="colors.splice($index, 1)" aria-label="Remove">X</button>
			</li>
		</ul>
	</div>
	<div id="blog-set-category-set">
		<h1 class="hidden">카테고리 세부설정</h1>
		<fieldset>
			<form action="set" method="post">
				<dl>
					<dt class="blog-set-category-title">카테고리명</dt>
					<dd class="blog-set-category-margin">
						<ul>
							<li><input name="name" type="text" ng-model="example.text"
								maxlength="16" /></li>
							<li><input type="checkbox" value="" />카테고리 옆 포스트 수 표시 공개 설정</li>
						</ul>
					</dd>
					<dt class="blog-set-category-title">공개설정</dt>
					<dd class="blog-set-category-margin">
						<input type="radio" name="" value="공개" />공개 <input type="radio"
							name="" value="비공개" />비공개
					</dd>
					<dt class="blog-set-category-title">주제 분류</dt>
					<dd class="blog-set-category-margin">
						<select>
							<option value="">주제를 선택하세요1</option>
							<option value="">주제를 선택하세요2</option>
							<option value="">주제를 선택하세요3</option>
							<option value="">주제를 선택하세요4</option>
							<option value="">주제를 선택하세요5</option>
							<option value="">주제를 선택하세요6</option>
							<option value="">주제를 선택하세요7</option>
						</select>
					</dd>
				</dl>
				<input id="blog-set-category-save" type="submit" value="저장" />
			</form>
		</fieldset>
	</div>
</div>
