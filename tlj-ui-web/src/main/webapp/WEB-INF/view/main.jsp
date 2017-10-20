<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" scope="request" value="Main" />
<jsp:include page="/WEB-INF/tiles/header.jsp" />
<div class="container-fluid mt-3">
<div class="row">
  <div class="col-md-4">
  <ul class="list-group">
  <h3 class="card-header">Список статей:</h3>
  <c:forEach var="info" items="${articles}">
  <li class="list-group-item" data-toggle="tooltip" data-placement="right" title="${info.title}">
  <p class="clip"><a class="text-dark alert-link" href="/tlj-ui-web/article/${info.id}">${info.title}</a></p></li>
  </c:forEach>
  </ul>
  </div>
  <div class="col-md-8"></div>
</div>
</div>
</div>
<jsp:include page="/WEB-INF/tiles/footer.jsp" />
