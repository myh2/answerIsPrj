<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html ng-app="mainad">
  <head>

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>Answer is..</title>
            
    <link href= "${context}/<tiles:getAsString name="css"/>" type="text/css" rel="stylesheet"/>
    
    <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-animate.min.js"></script>
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.min.js"></script>
      <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-sanitize.min.js"></script>
    
    <script src="${context}/resource/js/jquery-3.0.0.js"></script>
    <script src="${context}/<tiles:getAsString name="js"/>"></script>
    
    

    
  </head>
   <body>
      <div id="layout-header">
         <div class="layout-side"></div>
         <div id="layout-header-container">
            <tiles:insertAttribute name="header"/>
         </div>
         <div class="layout-side"></div>
      </div>
      
      <div id="layout-main">
         <div class="layout-side"></div>
         <div id="layout-main-container">

            <tiles:insertAttribute name="main"/>

         </div>
         <div class="layout-side"></div>
      </div>
   </body>
</html>