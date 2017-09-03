<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="com.bsdim.tlj.ui.web.info.InfoBlock"%>
<%@ page import="java.util.*"%>
<div class="container mt-3">
<div class="row">
<%for(InfoBlock info: (List<InfoBlock>)request.getAttribute("blocks")) {%>
<div class="col text-center">
<img src="pictures/<%out.print(info.getImageUrl());%>.jpg" class="rounded border border-dark" width=300  height=300 />
<p><%out.print(info.getTitle());%></p>
</div>
<%}%>
</div>
</div>
