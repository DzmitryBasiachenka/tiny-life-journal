<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="com.bsdim.tlj.ui.web.servlet.InfoBlock"%>
<%@ page import="java.util.*"%>
<%for(InfoBlock info: (List<InfoBlock>)request.getAttribute("blocks")) {%>
<div class="block-img">
<img src="pictures/<%out.print(info.getImageUrl());%>.jpg" width=300  height=300 />
<p><%out.print(info.getTitle());%></p>
</div>
<%}%>
