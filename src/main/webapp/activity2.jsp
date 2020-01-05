<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${userName}</title>
<script type="text/javascript" src="static/js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<p>${userName}</p>
	<img alt="用户头像" src="${userPic}">
	<br>
	<input type="text" id="score">
	<input type="button" id="tjBtn" value="提交">
	<br>
	<a href="RankServlet">排行榜</a>
</body>
<script type="text/javascript">
	$("#tjBtn").click(function() {
		var score = $("#score").val();
		if (/^[0-9]+$/.test(score) && score >= 60) {

			var postData = {
				userId : '${userId}',
				score : score,
			};
			$.post("Activity2Servlet", postData, function() {
				alert("已提交");
			})
		} else {
			alert("分数填写错误");
		}

	})
</script>
</html>