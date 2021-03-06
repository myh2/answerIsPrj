<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="regist-header" >
		<h1 class="hidden">글쓰기 페이지 헤더</h1>
		<ul>
			<li class="cancel"><a href="detail">취소</a></li>
			<li>글쓰기</li>
			<li class="file-attach">파일첨부</li>
			<li class="next-step">다음</li>
		</ul>
	</div>
	<main>
		<div id="reg-wrapper">
			<form id="write-area" action="modify" method="post">
				<div >
					<dl>
						<dt class="hidden"><label for="reg-title">제목</label></dt>
						<dd ><input id="reg-title" name="title" type="text" value="${blog.title}" /></dd>
						
					</dl>
					<dl>
						<dt class="hidden">내용</dt>
						<dd >
						<textarea id="reg-text-box" name="content" rows="15">${blog.content}</textarea>
					</dd>
					</dl>
					<div>
					<!-- ====================히든 시킨 데이터들 처리========================= -->
						<input class="hidden" name="code" type="text" value="${blog.code}" />
						<input class="hidden" name="hashtag" type="text" value="${blog.hashtag}" />
						<input class="hidden" name="categoryCode" type="text" value="${blog.categoryCode}" />
						<input class="hidden" name="languageCode" type="text" value="${blog.languageCode}" />
						<input class="hidden" name="platformCode" type="text" value="${blog.platformCode}" />
					
						<input class="btn-save button hidden" type="submit" value="저장" />
						 <a href="" class="hidden">취소</a>
					</div>
				</div>
				
				<div class="content-container" id="reg-setter">
					<div id="move-bar">
						<h2 class="hidden">이동바</h2>
						<ul id="test">
							<li>prev</li>
							<li><span>글설정</span></li>
							<li id="submit-btn-trigger">register</li>
						</ul>
					</div>
					<div id="setting-select">
						<ul>
						
							<li><label for="category-select"> 카테고리</label> 
								<select id="category-select" name="categoryCode">
									<c:forEach var="l" items="${cList }">
										<option value="${l.code }">${l.name}</option>
									</c:forEach>
								</select>
							</li>
	
							<li><label for="tag"> 태그</label> <input id="tag" name="hashtag"></li>
	
	
							<li>
								<label for="public-select"> 공개설정</label> 
                        <select id="public-select" name="publicOption">
                           <option selected value="1">비공개</option>
                           <option value="2">질문하기</option>
                           <option value="3">공개하기</option>
                        </select>   							
							</li>
							<li><label for="language-select">Language</label> 
								<select id="language-select">
									<c:forEach var="lang" items="${lList }">
										<option value="${lang.code }">${lang.name }</option>
									</c:forEach>
								</select>
							</li>
							<li><label for="platform-select">Platform</label> 
								<select id="platform-select">
									<c:forEach var="p" items="${pList }">
										<option value="${p.code }">${p.name }</option>
									</c:forEach>
								</select>
							</li>
							
						</ul>
						
					</div>
			</div>
			</form>
		</div>
	</main>