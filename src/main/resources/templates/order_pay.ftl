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
		<link rel="stylesheet" type="text/css" href="/css/radios.css"/>
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		
		<link rel="stylesheet" type="text/css" href="/css/order.css" />
		<script src="/js/jquery.js"></script>
	    <title>善心树</title>
	    <script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	    <script type="text/javascript">
		$(function  () {
			$("#back").click(function(){
				if(confirm("确定离开支付页面么？")){
					location.href="/shop_online";
				}
			})
			//跳转银行卡列表
			$("#mycard").click(function(){
				window.location.href = "/mycard?uid="+${order.userId};
			})
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
			var t = "${order.djs}";
			t = t.replace(",","");
			countDown( t,function( msg ){  
		        $("span[id='t_djs']").html(msg);
		    });
		    
		    function countDown( maxtime,fn ){      
			   var timer = setInterval(function(){  
			       if(maxtime>=0){     
			             var minutes = Math.floor(maxtime/60);     
			             var seconds = Math.floor(maxtime%60);     
			             var msg = "该订单交易时间剩余：" + minutes + "分" + " " + seconds + "秒";  
			             fn( msg );   
			             --maxtime;     
			        }     
			         else{     
			            window.location.href = "/order_derail?type=2&oid="+${order.id};  
			        }     
			    }, 1000);  
			}
			 
		})
		</script>
	</head>
	<body>
		
		<header>
			<a class="back" id="back"><img src="/img/_temp/back.png"/></a>
			<img src="/img/title/kjzf.png"/>
			<b class="header_bg"></b>
		</header>
		<div id="timer" style="color:red"></div> 
		<hr style="height: 10px; background: #f0f0f0; border-bottom: 1px solid #ddd;" />
		<section class="order_pay">
			<p class="order_num">平台订单号：<span>${order.orderNumber}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span id="t_djs"></span></p>
			<div class="clearfix pay"  style="margin: 0;">
			
				<img src="/img/_temp/icon-szz.png"/>
				<p class="clearfix">
					<span class="left">${order.commS}</span>
					<span class="right">x${order.orderCount}</span>
				</p>
				<p class="clearfix">
					<span class="left">总金额</span>
					<span class="right total">￥ ${order.money}</span>
				</p>
			</div>
			
			
			<!--支付方式-->
			<div class="pay_style">
				<!--<p>请选择支付方式</p>
				<a class="kj btn" href="">快捷支付</a>
				<a class="wechat btn" href="">微信支付</a>
				<a class="zfb btn" href="">支付宝支付</a>-->
			</div>
			<form action="/pay" method="post" class="card" style="margin: 0;">
			<input type="hidden" name="oid" value="${order.orderNumber}"/>
				<p>请选择支付方式</p>
				<div class="radios" style="border-bottom: 1px solid #ddd;">
				<#if cards?exists>
					<#list cards as card>
					<div class="r1 clearfix">
						<input type="radio" id="rad1" name="cardNum" value="${card.card}">
						<div class="value clearfix detail right">
							<img src="img/_temp/bank.jpg"/>
							<div class="right">
								<p>银行卡信息</p>
								<p>${card.cardnum}</p>
							</div>
						</div>
					</div>
					</#list>
				</#if>
				</div>
				<a href="javascript:(0)" class="addcard" id="mycard">添加新银行卡支付</a>
				<!-- <div>
				<p  style="line-height: 30px; border: none;">请输入手机${telephone}收到的短信验证码</p>
				<div class="clearfix">
					<div class="code clearfix">
						<input type="text" class="c_code_msg"placeholder="请输入短信验证码">
						<span class="msgs">获取验证码</span> 
					</div>
				</div>
				</div> -->
				 <input type="submit" class="btn kj" value="确认支付￥${order.money}"/>
			</form>
			<!--快捷支付--首次支付-->
			
			<!--<form class="card" action="" method="post">
				<div class="clearfix">
					<label></label>
					<p style="border: none;">*请验证持卡人本人的银行卡，仅支持储蓄卡。</p>
				</div>
				
				<div class="clearfix">
					<label>持卡人</label>
					<input type="text" name="" id="" value="" placeholder="请输入持卡人姓名" />
				</div>
				<div class="clearfix">
					<label>身份证号</label>
					<input type="text" name="" id="" value="" placeholder="请输入持卡人身份证号" />
				</div>
				<div class="clearfix">
					<label>银行卡号</label>
					<input type="text" name="" id="" value="" placeholder="请输入持卡人银行卡号" />
				</div>
				<div class="clearfix">
					<label>手机号</label>
					<input type="text" name="" id="" value="" placeholder="请输入银行卡预留手机号，未设置请联系发卡行" />
				</div>
				<div class="clearfix checkBox box">
					<label for=""></label>
	                <p class="clearfix" style="border: none;">
	                	<input type="checkbox" name="" id="cb1" checked="checked" value="《快捷支付服务协议》">
	                    <label for="cb1" class="check-box"></label>
	                    <span class="left">《快捷支付服务协议》</span>
	                </p> 
	            </div>
	            <input class="kj btn" type="submit" value="同意协议，下一步"/>
			</form>-->
		</section>
		<script src="/js/radios.js"/>

	</body>
</html>
