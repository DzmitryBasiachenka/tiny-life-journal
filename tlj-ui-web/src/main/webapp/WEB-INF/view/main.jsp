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
        <div class="btn-group">
          <button type="button" class="btn btn-dark dropdown-toggle btn-lg btn-block" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Настройка статей
          </button>
          <div class="dropdown-menu dropdown-menu-right">
            <button class="dropdown-item" type="button" data-toggle="modal" data-target="#add-article" data-whatever="@mdo">Добавить</button>
            <button class="dropdown-item" type="button">Редактировать</button>
            <button class="dropdown-item" type="button">Удалить</button>
          </div>
        </div>
        <h3 class="card-header">Список статей:</h3>
        <c:forEach var="info" items="${articles}">
          <li class="list-group-item" data-toggle="tooltip" data-placement="right" title="${info.title}">
          <p class="clip"><a class="text-dark alert-link align-middle" href="/tlj-ui-web/article/${info.id}">${info.title}</a></p></li>
        </c:forEach>
      </ul>
    </div>
    <div class="col-md-8">
      <c:if test="${emptyArticle != null}">
        <div class="modal-body border border-danger rounded text-center">
          <h4>${emptyArticle}</h4>
        </div>
      </c:if>
      <c:if test="${fileNotValid != null}">
        <div class="modal-body border border-danger rounded text-center">
          <h4>${fileNotValid}</h4>
        </div>
      </c:if>
    </div>
    <div class="col-md-8">

    </div>
  </div>
 </div>
</div>
<jsp:include page="/WEB-INF/tiles/footer.jsp" />
