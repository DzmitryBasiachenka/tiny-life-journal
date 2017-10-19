<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" scope="request" value="Article" />
<jsp:include page="/WEB-INF/tiles/header.jsp" />
<div class="container-fluid mt-3">
<h3 class="card-header text-center line_feed">${article.title}</h3>
<p class="mt-3">${article.text}</p>
</div>
</div>
<jsp:include page="/WEB-INF/tiles/footer.jsp" />
