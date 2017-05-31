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
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/sxs.css" />
	    <title>善心树</title>
	</head>
	<body>
		
		<header>
			<a class="back" href="index.html"><img src="img/_temp/back.png"/></a>
			<img src="img/title/record.png"/>
			<b class="header_bg"></b>
		</header>
		
		
		<section class="record_info">
			<div class="wrapper clearfix">
				<img class="left" src="img/_temp/logo.png"/>
				<div class="left">
					<p><span class="user_name">善心汇</span><span class="sl">树龄：<b>${age}</b></span></p>
					<div class="progress clearfix">
						<div class="schedulebg">
			                <div class="schedule" style="width:${jdt}%;"></div>
			                <p><em>${begin}</em>/<em>${end}</em></p>
			            </div>
			            <span class="right">正能量值</span>
					</div>
				</div>
			</div>
		</section>
		
		
		
		<section class="wrapper">
			<ul class="record">
			<#if items?exists>
				<li class="date">今天 </li>
			<#list items as item>
				<li class="clearfix">
					<img src="img/_temp/icon-sxb.png"/>
					<div class="right">
						<span class="time">${item.createTime}</span>
						<span class="con">充值<b>${item.orderCount}</b>枚善心币，传递善心 </span>
						<span class="num">+${item.orderCount}</span>
					</div>
				</li>
			</#list>
			</#if>
				<li class="date">昨天</li>
				<li class="clearfix">
					<img src="img/_temp/icon-sxb.png"/>
					<div class="right">
						<span class="time">${item.createTime}</span>
						<span class="con">充值<b>${item.orderCount}</b>枚善心币，传递善心 </span>
						<span class="num">+${item.orderCount}</span>
					</div>
				</li>
				<li class="date">04-24</li>
				<li class="clearfix">
					<img src="img/_temp/icon-sxb.png"/>
					<div class="right">
						<span class="time">${item.createTime}</span>
						<span class="con">充值<b>${item.orderCount}</b>枚善心币，传递善心 </span>
						<span class="num">+${item.orderCount}</span>
					</div>
				</li>
				<b class="line"></b>
			</ul>
		</section>
		
	</body>
</html>
