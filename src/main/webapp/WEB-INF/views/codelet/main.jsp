<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   

<!-- <script   src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/zclip/1.1.2/jquery.zclip.min.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
<script   src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ext-language_tools.js"></script> -->
   
<!-- <div class="wrap-codelet"> -->
<main id="content" class="container-fluid"> 
	  <div id="codelet-table">
         <h3 class="hidden">Codelet List</h3>
         <div id="list" >
         <!-- <input type="checkbox" ng-click="checkAll();"/> -->
      	<input class="btn btn-default" type="button"  onClick="location.href='./codelet?sortFlag='"  value="최근등록순"/>
      	 <input class="btn btn-default" type="button"   onClick="location.href='./codelet?sortFlag=F'" value="즐겨찾기"/>
      	<input class="btn btn-default" type="button"  onClick="location.href='./codelet?sortFlag=R'"  value="최근조회"/>
      	  
	      	<!-- <a class="btn-save button" href="" ng-click="favList();">즐겨찾는순</a>
	      	<a class="btn-save button" href="" ng-click="recList();">최근조회순</a> -->
	      </div>
            <c:forEach var="n" items="${list}" varStatus="status">
	      <div>
          <table id="codelet-list" class="table table-striped table-hover" >
                     <tr class="row">
                     	<!-- <td><input type="checkbox" ng-model="n.isChecked"/></td> -->
                        <td style="text-overflow:ellipsis">
						<c:forTokens var="ht" items="${n.hashTag}" delims=", "  >
							<a id="ht" href="">${ht}</a><span class="hidden">${ht}</span>
						</c:forTokens>                           
                        <br><a style="width:10%" id="codelet-title" href="codelet-detail?c=${n.code}">${n.title}</a><span class="hidden">${n.code}</span></td>
                        <%-- <td>${n.regDate}</td> --%>
                        <td style="width:10%"><a class="btn-del button btn btn-default btn-xs" href="${pageContext.request.contextPath }/codelet-del?c=${n.code}">삭제</a></td>
                        <td style="width:10%"><input class="hidden" id="language${status.index}" type="text" value="${n.languageCode}"/></td> 
                        <td style="width:10%"><input id="fav" type="button" class="btn btn-default btn-xs" value="☆"/><span>${n.favorite}</span><span class="hidden">${n.code}</span></td>
                        <td style="width:10%"><input id="copy-button" class="btn btn-default btn-xs" type="button" value="바로 복사"/><textarea id="txtA" class="hidden">${n.codeSrc}</textarea></td>
                        <td style="width:10%"><input id="preview" type="button" value="미리보기" class="btn btn-default btn-xs" /></td>
                     </tr>
          </table>
		</div>
          <div id="code${status.index}" style="display:none;height:200px;"><textarea>${n.codeSrc}</textarea></div>
            </c:forEach>         
          <input id="listLength" type="text" class="hidden" value="${fn:length(list)}" />
      </div>
</main>
<!-- </div> -->