<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
	<div id="blog-nav">
		<h1 class="hidden">블로그 메뉴 박스</h1>
		<ul>
        	<li>
        		<div id="close"></div>
        	</li>
			<li id="blog-icon-menu">
				<div>
					<h3 class="hidden">블로그 아이콘 메뉴</h3>
					<ul>
						<li><a href=""><img src="${context }/resource/images/profile.png" /></a></li>
						<li><a href=""><img src="${context }/resource/images/message.png" /></a></li>
						<li><a href=""><img src="${context }/resource/images/qna.png" /></a></li>
						<li><a href=""><img src="${context }/resource/images/star.png" /></a></li>
					</ul>
				</div>
			</li>            
            <li id="blog-nav-name">
            	<div>
                	<h3 class="hidden">블로그 이름</h3>
                		<ul>
                    		<li>ARA'S BLOG</li>
                        	<li></li>
                    	</ul>
                </div>	
            </li>            
			<li id="blog-nav-category">
				<div>
					<h3 class="hidden">블로그 카테고리</h3>
					<ul>
						<li>
							<a href="" class="nav-category-b">IT</a>
							<div>
								<ul class="nav-category-s">
									<c:forEach var="l" items="${cList }">
										<li><a href="">${l.name}</a></li>
									</c:forEach>
								</ul>
							</div>
						</li>
						<li>
							<a href="" class="nav-category-b">Other</a>
							<div>
								<ul class="nav-category-s">
									<li><a href="">책 추천</a></li>
									<li><a href="">일상</a></li>
									<li><a href="">개소리</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</li>
		</ul>
	</div>