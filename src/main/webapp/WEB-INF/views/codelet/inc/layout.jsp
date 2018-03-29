<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
   <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<script src="../resouce/js/modernizr-custom.min.js"></script>		
		<script src="${context}/resource/js/jquery-3.0.0.js"></script>
		<script src="${context}/resource/js/codelet/<tiles:getAsString name="js"/>"></script>
		<link href="${context}/resource/css/codelet/<tiles:getAsString name="css" />" type="text/css" rel="stylesheet" />
		<script src="${context}/resource/js/modernizr-custom.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ext-language_tools.js"></script>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>모든 답은 이곳에, Answeris</title>

    <!-- Bootstrap -->
    <link href="${context}/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${context}/resource/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
   <body>
      <!-- 헤더 부분 -->
      <div id="layout-header">
         <div class="layout-side"></div>
            <div id="layout-header-container">
               <tiles:insertAttribute name="header"/>
            </div>
         <div class="layout-side"></div>
      </div>
      
      <!-- 탭 부분 -->
      <%-- <tiles:insertAttribute name="tap"/> --%>
      
      <div id="main">
         <div class="wrap-codelet clear table-responsive">
            <!-- content 부분 -->
            <tiles:insertAttribute name="codeletHeader"/>
            <tiles:insertAttribute name="body"/>
            <!-- aside 부분 -->
           <%--  <tiles:insertAttribute name="aside"/>  --%>
         </div>
      </div>
      <!-- Footer부분 -->
      <%-- <tiles:insertAttribute name="footer"/> --%>
   </body>
</html>