<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>answeris|admin</title>
</head>
 <body >
      <!-- Header 영역 -->
      <div id="layout-header">
     	 <tiles:insertAttribute name="header"/>
      </div>        
         <!-- side menu 부분 -->
      <tiles:insertAttribute name="aside"/>
      
      <div  id="main">
            <!-- content 부분 -->
            <tiles:insertAttribute  name="body"/>
      </div>
   </body>
</html>