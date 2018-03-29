<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main id="body">
<div class="content-wrapper">
	<section class="header-item-container">
	<div id="search-form">
		<h3 class="hidden">검색 폼</h3>
		<!--                <form>
                  <fieldset>
                     <legend class="hidden"v>검색필드</legend>
                     <select>
                        <option value="TITLE">제목</option>
                        <option value="CONTENT">내용</option>
                     </select>
                        <input id="search-input" type="text" name="subject" />
                        <input id="search-button" type="submit" value="검색" />
                  </fieldset>
               </form> -->
	</div>
	</section>
</div>


<nav id="main-menu">
<h1 class="hidden">메인메뉴</h1>
<ul class="clear fix">
	<li class="main-menu-item"><a class="main-menu-item-text"
		href="search-result?search-term=${searchterm}">ALL</a></li>
	<li class="main-menu-item"><a class="main-menu-item-text"
		href="search-result?search-term=${searchterm}&where=blog">BLOG</a></li>
	<li class="main-menu-item"><a class="main-menu-item-text"
		href="search-result?search-term=${searchterm}&where=qna">Q&A</a></li>
</ul>
</nav>

<div class="answeris_section">
	<%-- <input type="hidden" value="${searchterm}" name="aaa">
<input type="hidden" value="${list}" name="bbb"> --%>
<%-- 	<c:choose>
		<c:when test="${(searchterm eq '')}">
			 
				<div>
					<h3>단어의 철자가 정확한지 확인해 보세요. 검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해
						보세요. 두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</h3>
				</div>
			
		</c:when>
		<c:when test= "${(list eq null)}">
		<div>
					 <h3>단어의 철자가 정확한지 확인해 보세요. 검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해
						보세요. 두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</h3> 
				</div>
		</c:when>
	
		<c:otherwise> --%>
		
	<c:if
		test="${(searchterm eq '')}">
				<div>
					<h3>단어의 철자가 정확한지 확인해 보세요. 검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해
						보세요. 두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</h3>
				</div>
	</c:if>
	
	<c:if
		test="${(list eq '[]') && (listQnA eq '[]') }">
				<div>
					<h3>단어의 철자가 정확한지 확인해 보세요. 검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해
						보세요. 두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</h3>
				</div>
	</c:if>
		
		
	<c:if
		test="${((searchterm != '') && (list ne '[]')) }">
	 
			<div class="section_head">
				<h3>BLOG</h3>
			</div>
			<c:forEach var="m" items="${list}">

				<li>
					<dl>
						<dt class="title">
							<a href="/AnswerisPrj/${m.memberid}/detail?c=${m.code}"
								onclick="">${m.title}</a>
						</dt>
						<dd class="content">
							<a href="/AnswerisPrj/${m.memberid}/detail?c=${m.code}"
								onclick="">${m.content}</a>
						</dd>
						<dd>
							<span class="memberid">${m.memberid}</span><span class="regDate">${m.year}/${m.day}</span>
						</dd>
					</dl>
				</li>
			</c:forEach>

			<div class="more_section">
				<a href="search-result?search-term=${searchterm}&where=blog"
					onclick="location.href='index.html';">블로그 더보기</a>
			</div>
	</c:if>
<%-- </c:otherwise>
	</c:choose> --%>
	<c:if
		test="${((searchterm != '') && (listQnA ne '[]')) }">
<%-- <input type="hidden" value="${searchterm}" name="aaa">
<input type="hidden" value="${listQnA}" name="bbb"> --%>
		<div class="section_head">
			<h3>QnA</h3>
		</div>

		<c:forEach var="n" items="${listQnA}">

			<li>
				<dl>
					<dt class="title">
						<a href="/AnswerisPrj/qna/questions-detail?c=${n.code}" onclick="">${n.title}</a>
					</dt>
					<dd class="content">
						<a href="/AnswerisPrj/qna/questions-detail?c=${n.code}" onclick="">${n.content}</a>
					</dd>

				<dd>
					<span class="memberid">${m.memberid}</span><span class="regDate">${n.year}/${n.day}</span>
				</dd>
			</dl>
		</li>
		</c:forEach>

		<div class="more_section">
			<a href="search-result?search-term=${searchterm}&where=qna"
				onclick="location.href='index.html';">Q&A 더보기</a>
		</div>
	</c:if>
	
	




</div>
</main>
