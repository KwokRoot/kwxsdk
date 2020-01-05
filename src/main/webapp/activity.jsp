<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>    
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Activity</title>
<script type="text/javascript" src="static/js/jquery-1.11.3.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
<input type="button" value="Item1" data-item="1" /><br><br>
<input type="button" value="Item2" data-item="2" /><br><br>
<input type="button" value="Item3" data-item="3" /><br><br>
<input type="button" value="Item4" data-item="4" /><br><br>
<input type="button" value="Item5" data-item="5" /><br><br>
<input type="button" value="Item6" data-item="6" /><br><br>
</body>

<script type="text/javascript">
	
	$(":button").click(function(){
		//console.log($(this).data("item"));
		var postData = {
			unionid : '${unionid}',
			itemid : $(this).data("item")
		};
		$.post("ActivityServlet",postData,function(data){
			alert(data.message);
		});
		
	});

</script>

</html>