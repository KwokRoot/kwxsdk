<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排行榜</title>
</head>
<body>
<c:forEach items="${rankList}" var="rank">
	<p>${rank.userName} <img alt="头像" src="${rank.userPic}"> ${rank.score}</p>
</c:forEach>
</body>
</html>