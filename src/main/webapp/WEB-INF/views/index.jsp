<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Main -->
<main id="main">
<div class="content-container">
	<div>
		<a href="${context}/index"><img
			src="${context}/resource/images/main/logo-ara.png"></a>
	</div>
	<div>
		<form id="searchform" action="search-result" method="get">
			<div>
				<div id="search-sort-btn"></div>
				<div>
					<fieldset>
						<legend class="hidden">검색</legend>
						<input type="text" id="search-input" name="search-term" placeholder="통합 검색" /> <input
							type="submit" class="hidden" value="AnswerIs 검색" />
					</fieldset>
				</div>
			</div>
			<div id="sort">
				<div></div>
				<div>
					<div>
						<div id="sort-language">
							<p>Language</p>
							<ul>
								<c:forEach var="n" items="${headerlanguage}">
									<li><input class="language-sortbtn" type="button"
										value="${n.name}" /><input class="language-sort"
										name="${n.name}" value="0" /></li>
								</c:forEach>
							</ul>
						</div>
						<div id="sort-platform">
							<p>Platform</p>
							<ul>
								<c:forEach var="n" items="${headerpaltform}">
									<li><input class="platform-sortbtn" type="button"
										value="${n.name}" /><input class="platform-sort"
										name="${n.name}" value="0" /></li>
								</c:forEach>
							</ul>

						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
</main>
