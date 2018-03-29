<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
      <title>모든 답은 이곳에, Answeris</title>
      <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

      <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
      <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" />
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-animate.min.js"></script>
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.min.js"></script>
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-sanitize.min.js"></script>
      <script type="text/javascript" src="${context }/resource/js/modernizr-custom.min.js"></script>
      <script type="text/javascript" src="${context }/resource/js/jquery-3.0.0.js"></script>
      
      <script type="text/javascript" src="${context }/resource/js/blog/blog-nav.js"></script>
      <script type="text/javascript" src="${context }/resource/js/blog/blogReg.js" ></script>
      <script type="text/javascript" src="${context }/resource/js/blog/list.js"></script>
      <script type="text/javascript" src="${context }/resource/js/blog/<tiles:getAsString name="js" />"></script>
      <script type="text/javascript" src="${context }/resource/js/blog/aside.js"></script>
      <link href="${context }/resource/css/reset.css" type="text/css" rel="stylesheet" />
      
      <link href="${context }/resource/css/blog/blog-header.css" type="text/css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/blog-detail.css" type="text/css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/blog-list.css" type="text/css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/blog-aside.css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/blog-regist.css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/blog-main.css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/blog-set.css" type="text/css" rel="stylesheet" />
      <link href="${context }/resource/css/blog/main-header.css" rel="stylesheet" />
      
      <link href="${context }/resource/css/blog/reg-setting.css" type="text/css" rel="stylesheet" />
      
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" />
      <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" />
      
      
      <%-- <link href="${context }/resource/css/blog.css" type="text/css" rel="stylesheet" /> --%>
   </head>
   <body  >
      
      <!-- Header 영역 -->
      <div id="layout-header">
         <div class="layout-side"></div>
         <div id="layout-header-container">
            <tiles:insertAttribute name="header"/>
         </div>
         <div class="layout-side"></div>
      </div>
      
      <c:set var="chker"><tiles:getAsString name="chker"/></c:set>
      <c:if test="${chker!='regist'}">
         <tiles:insertAttribute name="blogHeader"/>
         <!-- side menu 부분 -->
         <tiles:insertAttribute name="aside"/>
      </c:if>
      
      <div  id="main">
         <div class="body-wrapper clear">
            <!-- content 부분 -->
            <tiles:insertAttribute  name="body"/>
            
         </div>
      </div>
      <!-- Footer부분 -->
      <%-- <tiles:insertAttribute name="footer"/> --%>
   </body>
</html>