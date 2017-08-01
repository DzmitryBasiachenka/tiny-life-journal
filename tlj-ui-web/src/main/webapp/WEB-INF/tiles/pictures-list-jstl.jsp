<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="info" items="${blocks}">
<div class="block-img">
<img src="pictures/${info.imageUrl}.jpg" width=300  height=300 />
<p>${info.title}</p>
</div>
</c:forEach>
