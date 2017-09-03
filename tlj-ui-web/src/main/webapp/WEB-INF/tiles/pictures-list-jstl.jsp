<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container mt-3">
<div class="row">
<c:forEach var="info" items="${blocks}">
<div class="col text-center">
<img src="pictures/${info.imageUrl}.jpg" class="rounded border border-dark" width=300  height=300 />
<p>${info.title}</p>
</div>
</c:forEach>
</div>
</div>
