<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Activity</title>
<script type="text/javascript" src="static/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="static/css/index.css">
<link rel="stylesheet" href="static/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style type="text/css">
.name_div{
	font-size: 90px;
}
</style>


<title>年终盛典</title>
</head>

<!-- 主体盒子-->
<div class="main-box">
  <!-- 喜迎新年-->
  <div class="title-box">
	<img src="static/images/pc-titile.png" alt="">
  </div>
  <!-- 装饰点缀-->
  <div class="desc-box">
	  <img src="static/images/dianzhui.png" alt="">
  </div>		
  <div class="main">
	  <!-- 数字背景盒子-->
	  <div class="num-bg-box">
		  <!-- 数字盒子-->
		  <div class="num_box">
		 		<div class="name_div">2019-2020</div>
		  </div>
	  </div>
  </div>
</div>
<!-- 操作按钮-->
<div class="btn-box">
	<div class="btn start">开始抽奖</div>
	<div class="btn stop" >停止抽奖</div>
</div>

<div>
<p style="font-size: 30px;"><strong>签到名单：</strong></p>
<c:forEach items="${userBList}" var="userB" varStatus="status">
	<span style="font-size: 25px; padding-right: 20px;" id="name_${status.index}" data-openid="${userB.openid}">${userB.nickname}</span>
</c:forEach>
</div>
<p style="text-align: right; z-index: 1000; position:relative;"><button type="button" class="layui-btn layui-btn-danger layui-btn-radius" id="refresh_btn">刷新名单<i class="layui-icon"> &#xe669;</i></button></p>
<div>
<p style="font-size: 30px;color: yellow;"><strong>中奖名单：</strong></p>
<c:forEach items="${userBLuckList}" var="userB">
	<span style="font-size: 25px; padding-right: 20px;color: yellow;" data-openid="${userB.openid}">${userB.nickname}</span>
</c:forEach>
</div>

<!--js-->
<script>
	
	var count = ${userBList.size()};
	var isRunning = false;
	var timer;
	var rand;
	var luckOpenId= "${userB.openid}";
	var luckName= "${userB.nickname}";
		
	function run(){
		isRunning = true;
		timer = setInterval(function(){
			rand = randNum(0, count-1);
			$(".name_div").html($("#name_"+rand).html())
		}, 5);
		
	}
	
	$(function(){
		//开始抽奖
		$('.start').click(function(){
			if(isRunning){
				return false;
			}else{
				run();
			}
		});
		//停止抽奖
		$('.stop').click(function(){
			if(isRunning){
				clearInterval(timer);
				$(".name_div").html(luckName==""?"全中奖啦!":luckName);
				var openid = luckOpenId;
				$.get("submit?openId="+openid, function(result){
				    console.log(result);
				});
			}else{
				console.log("请先点击开始按钮");
			}
		});
		
		$("#refresh_btn").click(function(){
			window.location.reload();
		})
		
	})
	
	function randNum(min,max){
	    return Math.floor(Math.random() * (max - min + 1) + min);
	}

</script>
</body>
</html>