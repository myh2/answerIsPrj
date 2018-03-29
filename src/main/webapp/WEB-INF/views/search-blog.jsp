<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <main id="body">
   <div ng-controller="mainblog-controller" >
      <div class="content-wrapper">
         <section class="header-item-container">

         </section>
      </div>

<div id="search-term">
<input type="hidden" value="${searchterm}" >
</div>


	  <nav id="main-menu">
         <h1 class="hidden">메인메뉴</h1>
         <ul class="clear fix">
            <li class="main-menu-item"><a class="main-menu-item-text"
               href="search-result?search-term=${searchterm}">ALL</a></li>
            <li class="main-menu-item"><a class="main-menu-item-text"
               href="search-result?search-term=${searchterm}&where=blog">BLOG</a></li>
            <li class="main-menu-item"><a class="main-menu-item-text"
               href="search-result?search-term=${searchterm}&where=qna">Q&A</a></li>
         </ul>
      </nav>

      <div class="answeris_section">

         <div class="section_head">
            <h3>BLOG</h3>
         </div>
 			
 		 <c:forEach var="m" items="${list}">
         
            <li>
            <dl>
               <dt class="title"><a href="/AnswerisPrj/${m.memberid}/detail?c=${m.code}" onclick="">${m.title}</a>
               </dt>
               <dd class="content"><a href="/AnswerisPrj/${m.memberid}/detail?c=${m.code}" onclick="">${m.content}</a></dd>
               <dd> 
                  <span class="memberid">${m.memberid}</span><span class="regDate">${m.year}/${m.day}</span>
               </dd>
              
            </dl>
            </li>
         </c:forEach>

      <div ng-repeat="nb in mList">
         <li>
            <dl>
               <dt class="title">
                  <a ng-href="/AnswerisPrj/{{nb.memberid}}/detail?c={{nb.code}}">{{nb.title}}</a>
               </dt>
               <dd class="content">
                  <a href="/AnswerisPrj/{{nb.memberid}}/detail?c={{nb.code}}">{{nb.content}}</a>
               </dd>
               <dd>
                  <span class="memberid">{{nb.memberid}}</span>
                  <span class="regDate" ng-bind="nb.regDate">${nb.year}/${nb.day}</span>
               </dd>
            </dl>
         </li>
      </div> 



      <!-- ------------------------더보기 버튼---------------------------------------  -->
      <div class="add-btn-container">
         <form action="" method="post">

            <input class="hidden" type="text" name="c" /> 
            <input id="add-btn" type="button" ng-click="addClick1()" value="더보기" class="content-add " />

         </form>
      </div>


      </div>
      </div>
   </main>
