<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="qna">

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${context }/resource/css/reset.css" type="text/css"
	rel="stylesheet" />
<link href="${context }/resource/css/blog.css" type="text/css"
	rel="stylesheet" />
<link
	href="${context }/resource/css/qna/<tiles:getAsString name="css" />"
	type="text/css" rel="stylesheet" />
<link href="${context }/resource/css/inc/header.css" type="text/css"
	rel="stylesheet" />
<link href="${context }/resource/css/inc/layout-qna.css" type="text/css"
	rel="stylesheet" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-animate.min.js"></script>
<script src="${context }/resource/js/modernizr-custom.min.js"></script>
<script src="${context }/resource/js/jquery-3.0.0.js"></script>
<script src="${context }/resource/js/qna/<tiles:getAsString name="js"/>"></script>

<style>

	.opt{
		display: inline-block;
	    width: 80px;
	    height: 34px;
	    padding: 6px 12px;
	    font-size: 14px;
	    line-height: 1.42857143;
	    color: #555;
	    background-color: #fff;
	    background-image: none;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
	    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;	
	}
	.form-search{
		display: inline-block;
	    width: 40%;
	    height: 34px;
	    padding: 6px 12px;
	    font-size: 14px;
	    line-height: 1.42857143;
	    color: #555;
	    background-color: #fff;
	    background-image: none;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
	    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	}
</style>

</head>
<body>
	<!-- 헤더 부분 -->
	<div id="layout-header">
		<div class="layout-side"></div>
		<div id="layout-header-container">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="layout-side"></div>
	</div>


	<div id="layout-main">
		<div class="layout-side"></div>
		<div id="layout-main-container">
			<!-- content 부분 -->
			<tiles:insertAttribute name="body" />
			<!-- aside 부분 -->
			<tiles:insertAttribute name="aside" />
		</div>
		<div class="layout-side"></div>
	</div>
	<!-- Footer부분 -->
	<%-- <tiles:insertAttribute name="footer"/> --%>
</body>
</html>