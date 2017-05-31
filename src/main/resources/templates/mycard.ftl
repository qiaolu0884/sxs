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
		<link rel="stylesheet" type="text/css" href="/css/card.css" />
	    <title>善心树</title>
	    <script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	</head>
	 <script type="text/javascript">
		$(function() {
			$("#card_add").click(function(){
				$.post("card_yz",{},function(data){
					if(data == 0){
						alert("最多只可以添加五张银行卡！");
					} else {
						window.location.href="/tocard_add";
					}
				})
			})
		})
	</script>
	<body>
		
		<header>
			<a class="back" href="/index"><img src="/img/_temp/back.png"/></a>
			<img src="/img/title/my_card.png"/>
			<b class="header_bg"></b>
		</header>
		<hr style="height: 10px; background: #f0f0f0; border-bottom: 1px solid #ddd;" />
		
		<section class="card_detail" >
		<#if cards?exists>
		<#list cards as card>
			<div class="clearfix wrapper detail">
				<img src="/img/_temp/bank.jpg"/>
				<div class="right">
					<p>银行卡信息</p>
					<p>${card.cardnum}</p>
				</div>
			</div>
		</#list>
		</#if>
			<div class="wrapper">
				<a href="javascript:(0)" class="btn kj" id="card_add">添加银行卡</a>
			</div>
		</section>
	</body>
</html>
