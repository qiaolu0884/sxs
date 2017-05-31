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
		<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/css/card.css" />
	    <title>善心树</title>
	</head>
	<body>
		
		<header>
			<a class="back" href="/index"><img src="/img/_temp/back.png"/></a>
			<img src="/img/title/card_add.png"/>
			<b class="header_bg"></b>
		</header>
		<hr style="height: 10px; background: #f0f0f0; border-bottom: 1px solid #ddd;" />
		
		<section class="order_pay">
			<!--支付方式-->
			<div class="pay_style">
				
				
				<!--<p>请选择支付方式</p>-->
				<!--<a class="kj btn" href="">快捷支付</a>
				<a class="wechat btn" href="">微信支付</a>
				<a class="zfb btn" href="">支付宝支付</a>-->
			</div>
			
			<!--快捷支付--首次支付-->
			
			<form class="card" action="/card_add" method="post" id="form">
				<div class="clearfix">
					<label></label>
					<p>*请验证持卡人本人的银行卡，仅支持储蓄卡。</p>
				</div>
				
				<div class="clearfix"  style="margin-top: 0;">
					<label>持卡人</label>
					<input type="text" name="name" id="name" value="" placeholder="请输入持卡人姓名" />
					<span id="spname" style="color:red"></span>
				</div>
				<div class="clearfix">
					<label>身份证号</label>
					<input type="text" name="identification_card" id="identification_card" value="" placeholder="请输入持卡人身份证号" />
					<span id="spidentification_card" style="color:red"></span>
				</div>
				<div class="clearfix">
					<label>银行卡号</label>
					<input type="text" name="card" id="card" value="" placeholder="请输入持卡人银行卡号" />
					<span id="spcard" style="color:red"></span>
				</div>
				<div class="clearfix">
					<label>手机号</label>
					<input type="text" name="phone" id="phone" value="" placeholder="请输入银行卡预留手机号，未设置请联系发卡行" />
					<span id="spphone" style="color:red"></span>
				</div>
	            <input class="kj btn" type="button" value="提交" id="bt"/>
			</form>
		</section>
	</body>
	 <script type="text/javascript">
		$(function() {
			$("#bt").click(function(){
			$("#spidentification_card").html("");
			$("#spphone").html("");
			$("#spname").html("");
			
				var card = $("#card").val();
				var identification_card = $("#identification_card").val();
				var name = $("#name").val();
				var phone = $("#phone").val();
				
				if(isChinaName(name)){
					if(isCardNo(identification_card)){
						if(card!=null && card !=''){
							if(isPhoneNo(phone)){
								$("#form").submit();
							} else {
								$("#spphone").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话不合法！");
							}
						} else {
						//判断银行卡
						}
					} else {
						$("#spidentification_card").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证不合法！");
					}
				} else {
					$("#spname").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名不合法！");
				}
			})
			$("#identification_card").blur(function(){
				var identification_card = $("#identification_card").val();
				$("#spidentification_card").html("");
				if(!isCardNo(identification_card)){
					$("#spidentification_card").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证不合法！");
				}
			})
			$("#name").blur(function(){
				var name = $("#name").val();
				$("#spname").html("");
				if(!isChinaName(name)){
					$("#spname").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名不合法！");
				}
			})
			$("#phone").blur(function(){
				var phone = $("#phone").val();
				$("#spphone").html("");
				if(!isPhoneNo(phone)){
					$("#spphone").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话不合法！");
				}
			})
			
		})
		// 验证中文名称
		function isChinaName(name) {
			 var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
			 return pattern.test(name);
		}
		 
		// 验证手机号
		function isPhoneNo(phone) { 
			 var pattern = /^1[34578]\d{9}$/; 
			 return pattern.test(phone); 
		}
		 
		// 验证身份证 
		function isCardNo(card) { 
			 var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
			 return pattern.test(card); 
		} 
		
	</script>
</html>
