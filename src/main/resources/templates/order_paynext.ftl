<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	    <meta http-equiv="cleartype" content="on" />
	    <meta name="apple-touch-fullscreen" content="yes">
		<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/checkbox.css"/>
		<link rel="stylesheet" type="text/css" href="/css/order.css" />
	    <title>善心树</title>
	    <script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	    <script type="text/javascript">
		$(function  () {
			//获取短信验证码
			var validCode=true;
			$(".msgs").click (function  () {
				var time=60;
				var code=$(this);
				if (validCode) {
					validCode=false;
					code.addClass("msgs1");
				var t=setInterval(function  () {
					time--;
					code.html(time+"秒后重新发送");
					if (time==0) {
						clearInterval(t);
					code.html("重新获取");
						validCode=true;
					code.removeClass("msgs1");
					}
				},1000)
				}
			})
		})
		</script>
	</head>
	<body>
		
		<header>
			<a class="back" href="/index"><img src="/img/_temp/back.png"/></a>
			<img src="/img/title/kjzf.png"/>
			<b class="header_bg"></b>
		</header>
		<hr style="height: 10px; background: #f0f0f0; border-bottom: 1px solid #ddd;" />
		
		<section class="order_pay pay_next">
			<form class="card" action="" method="post">
				<p>请输入手机186XXXX8672收到的短信验证码</p>
				<div class="clearfix">
					<div class="code clearfix">
						<input type="text" class="c_code_msg"placeholder="请输入短信验证码">
						<span class="msgs">获取验证码</span>
					</div>
				</div>
	            <a href="/index" class="btn kj">确认支付￥<span>500</span></a>
			</form>
			
			
		</section>
	</body>
</html>
