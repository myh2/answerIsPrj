<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script src=" ${context }/resource/js/inc/header.js"></script>

<header id="header" jput="member">
	<div id="header-menu-btn"></div>
	<div id="header-logo">
		<a href="${context }/index"></a>
		<a href="${context}" id="header-context" class="hidden"></a>
	</div>
	<c:if test="${address ne 'index'}">
		<div id="header-search-btn"></div>
		<div id="header-top-search">
			<form id="header-top-searchform" action="${context }/search-result"
				method="get">
				<div>
					<div id="header-top-search-sort-btn"></div>
					<div>
						<fieldset>
							<legend class="hidden">검색</legend>
							<input type="text" id="header-top-search-search-input"
								name="search-term" placeholder="통합 검색" /> <input type="submit"
								class="hidden" value="AnswerIs 검색" />
						</fieldset>
					</div>
				</div>
				<div id="header-top-search-sort">
					<div></div>
					<div>
						<div>
							<div id="header-top-search-sort-language">
								<p>Language</p>
								<ul>
									<c:forEach var="n" items="${headerlanguage}">
										<li><input class="language-sortbtn" type="button"
											value="${n.name}" /><input class="language-sort"
											name="${n.name}" value="0" /></li>
									</c:forEach>
								</ul>
							</div>
							<div id="header-top-search-sort-platform">
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
	</c:if>
<!-- ---------------------------------     header-menu     ------------------------------------------- -->
	<div id="header-menu">
		<div>
			<div id="header-menu-side"></div>

			<div id="header-menu-header">
				<div id="header-menu-in-btn"></div>
				<div id="header-menu-in-logo">
					<a href="${context }/index"></a>
				</div>
			</div>


			<div id="header-menu-list">
				<ul>
					<c:if test="${empty pageContext.request.userPrincipal}">
						<li><a href="${context }/main/login/sign-in">Q&A</a></li>
						<li><a href="${context }/main/login/sign-in">Blog</a></li>
						<li><a href="${context }/main/login/sign-in">Codelet</a></li>
					</c:if>
					<c:if test="${not empty pageContext.request.userPrincipal}">
						<li><a href="${context }/qna/answers">Q&A</a></li>
						<li><a
							href="${context }/${pageContext.request.userPrincipal.name}/main">Blog</a></li>
						<li><a href="${context }/codelet">Codelet</a></li>
					</c:if>
					<li><a href="${context }/admin">admin</a></li>
					<li>
						<div id="header-menu-myinfo">
							<div>
								<div id="header-menu-mypic">
									<img src=" ${context }/resource/images/main/guest-pic.png">
								</div>
								<div>
									<div id="header-menu-message">
										<c:if test="${not empty pageContext.request.userPrincipal}">
											<a href="${context }/main/messagebox/rcv-message">
												<input type="button" value="쪽지"/>
												<div id="header-menu-message-new">새쪽지</div>
											</a>
										</c:if>
									</div>
									<div></div>
									<div></div>
									<c:if test="${empty pageContext.request.userPrincipal}">
										<div id="header-menu-user">Guest</div>
									</c:if>
									<c:if test="${not empty pageContext.request.userPrincipal}">
										<div id="header-menu-user-nick">nickName</div>
									</c:if>
									<div id="header-menu-level">
										<c:if test="${not empty pageContext.request.userPrincipal}">
											<div id="header-menu-user-grade">Grade</div>
											<div id="header-menu-user-level">Level</div>
										</c:if>
									</div>
								</div>
							</div>
							<div id="header-menu-myinfo-go">
								<c:if test="${empty pageContext.request.userPrincipal}">
									<a href="${context }/main/login/sign-in">My-info</a>
								</c:if>
								<c:if test="${not empty pageContext.request.userPrincipal}">
									<a href="${context }/main/member/enter-myinfo">My-info</a>
								</c:if>
							</div>
						</div>
					</li>
					<c:if test="${empty pageContext.request.userPrincipal}">
						<li><a href="${context }/main/login/sign-in">Sign-in</a></li>
					</c:if>
					<c:if test="${not empty pageContext.request.userPrincipal}">
						<li><a href="${context }/main/login/sign-out">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<!--   -------------------------------------------- header-search ----------------------------------------------  -->
	<div id="header-search-form">
		<form action="search-result" method="get">
			<div>
				<div>
					<div id="header-search-sort-btn"></div>
					<div>
						<fieldset>
							<legend class="hidden"> 통합 검색 폼 </legend>
							<input id="header-search-input" name="search-term"
								placeholder="통합 검색" type="text" /> <input
								id="header-search-submit" type="submit" />
						</fieldset>
					</div>
					<div id="header-search-back-btn"></div>
				</div>
				<div id="header-sort">
					<div></div>
					<div>
						<div>
							<div id="header-sort-language">
								<p>Language</p>
								<ul>
									<c:forEach var="n" items="${headerlanguage}">
										<li><input class="language-sortbtn" type="button"
											value="${n.name}" /><input class="language-sort"
											name="${n.name}" value="0" /></li>
									</c:forEach>
								</ul>
							</div>
							<div id="header-sort-platform">
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
			</div>
		</form>
	</div>

</header>

