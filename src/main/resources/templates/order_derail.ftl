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
		<link rel="stylesheet" type="text/css" href="/css/order.css" />
	    <title>善心树</title>
	</head>
	<body>
		
		<header>
			<a class="back" href="/index"><img src="/img/_temp/back.png"/></a>
			<img src="/img/title/order_detail.png"/>
			<b class="header_bg"></b>
		</header>
		
		<section class="wrapper">
			
			<!--支付状态-->
			<div class="info">
			<#if type=="2">
				<!--关闭-->
				<img src="/img/_temp/close2.png"/>
				<span>已关闭</span>
			</#if>
			<#if type=="1">
				<!--成功-->
				<img src="/img/_temp/succes.png"/>
				<span>支付成功</span>
			</#if>
			</div>
			<!--支付状态-->
			
			<h3>支付订单信息</h3>
			<hr style="height: .5px; background: #ccc; " />
			<ul class="infomation">
				<li class="clearfix"><strong>平台订单号：</strong><span>${order.orderNumber}</span></li>
				<li class="clearfix"><strong>创建时间：</strong><span>${order.formatTime}</span></li>
				<li class="clearfix"><strong>订单金额：</strong><span>¥ ${order.money}</span></li>
				
				<!--关闭-->
				<#if type=="2">
				<li class="clearfix"><strong>支付状态：</strong><span>已关闭</span></li>
				<a class="kj btn" href="/shop_online">返回</a>
				</#if>
				<!--成功-->
				<#if type=="1">
				<li class="clearfix"><strong>平台订单号：</strong><span>201704131651010000001</span></li>
				<li class="clearfix"><strong>支付订单号：</strong><span>201704131651010000001</span></li>
				<li class="clearfix"><strong>创建时间：</strong><span>2017-04-15  00:00:00</span></li>
				<li class="clearfix"><strong>付款时间：</strong><span>2017-04-15  00:00:00</span></li>
				<li class="clearfix"><strong>订单金额：</strong><span>¥ 900</span></li>
				<li class="clearfix"><strong>支付状态：</strong><span>已支付</span></li>
				<li class="clearfix"><strong>支付方式：</strong><span>招商银行</span></li>
				<a class="kj btn" href="">返回</a>
				</#if>
			</ul>
		</section>
		
	</body>
</html>
