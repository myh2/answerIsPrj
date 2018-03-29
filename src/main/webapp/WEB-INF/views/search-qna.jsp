<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<main id="body">
<div ng-controller="mainqna-controller" >
   <div class="content-wrapper">
      <section class="header-item-container">
      <div id="search-form">
         <h3 class="hidden">검색 폼</h3>
         <!--                <form>
                  <fieldset>
                     <legend class="hidden">검색필드</legend>
                     <select>
                        <option value="TITLE">제목</option>
                        <option value="CONTENT">내용</option>
                     </select>
                        <input id="search-input" type="text" name="subject" />
                        <input id="search-button" type="submit" value="검색" />
                  </fieldset>
               </form> -->
      </div>
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
      <li class="main-menu-item"><a id="dd" class="main-menu-item-text"
         href="search-result?search-term=${searchterm}&where=qna">Q&A</a></li>
   </ul>
   </nav>

   <div class="answeris_section">




      <div class="section_head">
         <h3>ANSWER</h3>
      </div>
      
 

       <c:forEach var="n" items="${listQnA}">
         <li>
            <dl>
               <dt class="title">
                  <a href="/AnswerisPrj/qna/questions-detail?c=${n.code}" onclick="">${n.title}</a>
               </dt>

               <dd class="content" id="dd">
                  <a href="/AnswerisPrj/qna/questions-detail?c=${n.code}" onclick="">${n.content}</a>
               </dd>
               <dd>
                  <span class="memberid">${n.memberid}</span><span class="regDate">${n.year}/${n.day}</span>
               </dd>
            </dl>
         </li>
      </c:forEach> 
      
      <div ng-repeat="nl in nList">
         <li>
            <dl>
               <dt class="title">
                  <a ng-href="/AnswerisPrj/qna/questions-detail?c={{nl.code}}">{{nl.title}}</a>
               </dt>
               <dd class="content">
                  <a href="/AnswerisPrj/qna/questions-detail?c={{nl.code}}">{{nl.content}}</a>
               </dd>
               <dd>
                  <span class="memberid">{{nl.memberid}}</span>
                  <span class="regDate" ng-bind="nl.regDate">${nl.year}/${nl.day}</span>
               </dd>
            </dl>
         </li>
      </div> 



      <!-- ------------------------더보기 버튼---------------------------------------  -->
      <div class="add-btn-container">
         <form action="" method="post">

            <input class="hidden" type="text" name="c" /> <input id="add-btn"
               type="button" ng-click="addClick()" value="더보기"
               class="content-add " />

         </form>
      </div>

   </div>
</div>
</main>