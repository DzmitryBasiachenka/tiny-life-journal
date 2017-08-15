<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Authorization</title>
     <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
<div class="login_page">
<h3 align="center">Authorization</h3>
<form action="processingForm" method="POST">
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login:<input type="text" name="login" maxlength="50" size="30"></p>
<p>Password:<input type="password" name="password" maxlength="50" size="30"></p>
<p align="center"><input type="submit" value="Sign in">
<input type="submit" value="Sign up"></p>
</form>
</div>
</body>
</html>
