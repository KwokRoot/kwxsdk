<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="static/js/jquery-1.11.3.min.js"></script>
<script src="static/js/jweixin-1.2.0.js"></script>

<script type="text/javascript">
	var postData = {
		urlStr : window.location.href.split('#')[0]
	}

	$(function() {
		$.ajax({
			type : "POST",
			url : 'WeiXinShareConfigServlet',
			async : false,
			dataType : 'json',
			data : postData,
			success : function(data) {

				//console.log(data.appId);
				//console.log(data.timestamp);
				//console.log(data.nonceStr);
				//console.log(data.signature);

				wx.config({
					debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
					appId : data.appId, // 必填，公众号的唯一标识
					timestamp : data.timestamp, // 必填，生成签名的时间戳
					nonceStr : data.nonceStr, // 必填，生成签名的随机串
					signature : data.signature,// 必填，签名，见附录1
					jsApiList : [ 'onMenuShareTimeline',
							'onMenuShareAppMessage', 'hideMenuItems',
							'hideAllNonBaseMenuItem', 'showMenuItems',
							'showAllNonBaseMenuItem' ]
				// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
				});

				wx.ready(function() {

					wx.hideAllNonBaseMenuItem();

					wx.hideMenuItems({
						menuList : [ "menuItem:share:appMessage",
								"menuItem:share:qq", "menuItem:share:weiboApp",
								"menuItem:share:QZone" ]
					// 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
					});

					wx.showMenuItems({
						menuList : [ "menuItem:share:appMessage",
								"menuItem:share:timeline" ]
					// 要显示的菜单项，所有menu项见附录3
					});

					wx.onMenuShareTimeline({
						title : '******', // 分享标题
						link : '******', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
						imgUrl : '******', // 分享图标
						success : function() {
							// 用户确认分享后执行的回调函数
						},
						cancel : function() {
							// 用户取消分享后执行的回调函数
						}
					});

					wx.onMenuShareAppMessage({

						title : '******', // 分享标题
						desc : '******', // 分享描述
						link : '******', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
						imgUrl : '******', // 分享图标
						success : function() {
							// 用户确认分享后执行的回调函数
						},
						cancel : function() {
							// 用户取消分享后执行的回调函数
						}

					});

				})

			},
			error : function() {
				alert('错误了，请刷新页面');
			}
		});
	})
</script>
