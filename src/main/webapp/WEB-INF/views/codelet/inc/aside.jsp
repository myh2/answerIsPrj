<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script src="../../resouce/js/modernizr-custom.min.js"></script>		
<script src="${context }/resource/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="${context }/resource/js/codelet/aside.js" ></script>
<body>
		 
	<div>
		<h3 class="hidden">codelet-aside-search</h3>
		<c:forEach var="n" begin="0" end="${fn:length(langList)}" step="1"
   				items="${langList}">
		
			<ul name="sortSelec" id="sortSelec">
				<li section-name="${n.languageCode}">
 					<a href="">${n.languageCode}</a>
				</li>
			</ul>
		</c:forEach>
	</div>
</body>
</html>