<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/blog/comment-charge.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<h1 class="hidden">댓글 신고 페이지</h1>
	<div id="comment-charge-container">
		<div>
			<form id="comment-charge-form" action="comment-charge" method="post">
			<input name="commentCode" type="hidden" value="${c}" />
				<h2 class="hidden">신고 사유</h2>
				<div id="comment-charge-option">
					<select name="chargeOption">
						<c:forEach var="cc" items="${ccList}">
							<option value="${cc.code}">${cc.chargeName}</option>
						</c:forEach>
					</select>
				</div>
				<h2 class="hidden">자세한 신고 사유</h2>
				<div id="comment-charge-detail">
					<textarea name="detailReason" rows="5" cols="10"></textarea>
				</div>
				
				<div >
					<input id="comment-charge-submit-button" type="submit" value="제출" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>