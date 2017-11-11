<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>" type="text/css"/>
    <title>Authorization</title>
  </head>
  <body style="background-color: #DCDCDC;">
      <div class="center_login_page border border-secondary rounded text-center">
          <div class="pt-4">
          <c:if test="${wrongUserMessage != null}">
          <p class="text-danger">${wrongUserMessage}</p>
          </c:if>
              <h3>Authorization</h3>
              <form action="<c:url value='/login'/>" method="POST">
              <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login:<input type="text" name="login" maxlength="50" size="30"></p>
              <p>Password:<input type="password" name="password" maxlength="50" size="30"></p>
              <p><input type="submit" value="Sign in">&nbsp;&nbsp;<input type="submit" value="Sign up"></p>
              </form>
          </div>
      </div>
<jsp:include page="/WEB-INF/tiles/footer.jsp" />
