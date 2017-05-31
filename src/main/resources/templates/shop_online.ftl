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
    	<link rel="stylesheet" type="text/css" href="/css/mobiscroll_002.css"/>
		<link rel="stylesheet" type="text/css" href="/css/mobiscroll_003.css"/>
		<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/shop.css" />
		
	    <script src="/js/jquery.js"></script>
	    <script src="/js/mobiscroll_002.js" type="text/javascript"></script>
		<script src="/js/mobiscroll.js" type="text/javascript"></script>
		<script src="/js/mobiscroll_003.js" type="text/javascript"></script>
	    <title>善心树</title>
	</head>
	<body class="shop">
		
		<header>
			<a class="back" href="/index"><img  src="/img/_temp/back.png"/></a>
			<img src="/img/title/shop.png"/>
			<b class="header_bg"></b>
		</header>
		
		<section class="wrapper goods">
			<div class="clearfix">
				<img src="/img/_temp/szz2.png"/>
				<a id="szz" class="buym" href="javascript:(0);"><img src="/img/_temp/buy.png"/></a>
			</div>
			<div class="clearfix">
				<img src="/img/_temp/sxb2.png"/>
				<a id="sxb" class="buym" href="javascript:(0);"><img src="/img/_temp/buy.png"/></a>
			</div>
		</section>
		
		
		<section class="order_corder">
			<h2 class="title"><img src="/img/_temp/order_corder.png"/></h2>
			<div class="select clearfix wrapper">
				<span class="left" style="padding-right: 11px;">默认：近一个月订单</span>
				<span class="left">日期：</span>
				<div class="date clearfix left">
					<input class="left" style="width: 46%;" type="text" readonly="" name="appDate" id="appDate" value="${begin}" placeholder="${begin}">
					<span style="width: 8%; text-align: center; line-height: 24px;" class="left">-</span>
					<input class="left" style="width: 46%;" type="text" readonly="" name="appDate2" id="appDate2" value="${end}" placeholder="${end}">
				</div>
				<a class="btn" href="javascript:(0)" id="btn">筛选</a>
				 <script type="text/javascript">
				 $(function(){
				 	$("#btn").click(function(){
				 		var begin = $("#appDate").val();
				 		var end = $("#appDate2").val();
				 		window.location.href = "/shop_onlineByQuery?begin=" + begin + "&&end=" + end;
				 	})
				 })
				 </script>
			</div>
		</section>
		
		<hr style="height: 10px; background: #f0f0f0;" />
		
		<section class=" order">
		<#if orders?exists>
		<#list orders as order>
			<div class="clearfix wrapper">
				<p class="order_num">平台订单号：<span>${order.orderNumber}</span></p>
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td rowspan="3"><img src="img/_temp/icon-szz.png"/></td>
						<td>${order.formatTime}</td>
						<td></td> 
						<td class="state">${order.statusS}</td>
					</tr>
					<tr>
						<td>${order.commS} x ${order.orderCount}</td>
						 <td> </td> 
						
					</tr>
					<tr>
						<td>${order.money}</td>
						<td>
						</td>
						<#if order.status lt 1>
						<td>
						<input id="${order.id}" type="hidden" value="${order.djs}" name="hid" />
						<DIV id="CountMsg" class="HotDate"> 
							<span name="${order.id}"></span> 
							
						</DIV>
						<a class="pay" href="javascript:(0)" onclick="paaa('${order.id}')" ">
						前往支付
						</a></td>
						</#if>
					</tr>
				</table>
			</div>
		</#list>
		</#if>
		</section>
		
		
		
		<div class="popup" id="popup">
			<div class="popupbg"></div>
			<div class="content contents">
				<h2><img src="/img/_temp/szz_title.png"/>  <!--善金币-->	</h2>
				<img class="close" src="/img/_temp/close.png"/>
				<div class="clearfix">
					<span class="left txt">购买数量</span>
					<div class="left gw_num">
						<a href="javascript:(0)" class="jian" id="jian"><img src="/img/_temp/jian.png"/></a>
            			<div class="num">
            				<input type="tel" value="1" id="num" />
            			</div>
						<a href="javascript:(0)" class="add" id="add"><img src="/img/_temp/add.png"/></a>
            		</div>
				</div>
				<div class="clearfix">
					<span class="left txt">总计金额</span>
					<div class="left gw_total">
						<span class="txt">￥</span>
						<span class="z txt" id="total"></span>
            		</div>
				</div>
				<a href="javascript:(0)" class="buy" id="buyszz"><img src="/img/_temp/buy.png"/></a>
			</div>
		</div>
		
		<div class="popup" id="popup2">
			<div class="popupbg"></div>
			<div class="content contents">
				<h2><img src="/img/_temp/szz_title.png"/>  <!--善金币-->	</h2>
				<img class="close" src="/img/_temp/close.png"/>
				<div class="clearfix">
					<span class="left txt">购买数量</span>
					<div class="left gw_num">
						<a href="javascript:(0)" class="jian" id="jian2"><img src="/img/_temp/jian.png"/></a>
            			<div class="num" >
            				<input type="tel" value="1" id="num2" />
            			</div>
						<a href="javascript:(0)" class="add" id="add2"><img src="/img/_temp/add.png"/></a>
            		</div>
				</div>
				<div class="clearfix">
					<span class="left txt">总计金额</span>
					<div class="left gw_total">
						<span class="txt">￥</span>
						<span class="z txt" id="total2"></span>
            		</div>
				</div>
				<a href="javaScript:(0)" class="buy" id="buysxb"><img src="/img/_temp/buy.png"/></a>
			</div>
		</div>
		
		<script type="text/javascript"> 
		
			var arr = $("input[name='hid']").each(function(){
				var t = $(this).val();
				var idd = $(this).attr("id");
				t = t.replace(",","");
				countDown( t,function( msg ){  
			        $("span[name='"+idd+"']").html(msg);
			    }) 
			});
		
			function countDown( maxtime,fn ){      
			   var timer = setInterval(function(){  
			       if(maxtime>=0){     
			             var minutes = Math.floor(maxtime/60);     
			             var seconds = Math.floor(maxtime%60);     
			             var msg = minutes + "分" + " " + seconds + "秒";  
			             fn( msg );   
			             --maxtime;     
			        }else{     
			            clearInterval( timer );  
			            location.reload();
			        }     
			    }, 1000);  
			}
			
			
		</script> 
		
		
		<script type="text/javascript">
			function paaa(id){
				$.post("/orderpayfor",{'id':id},function(data){
					//返回订单状态，0是不存在，1是已关闭，2是可以支付
					if(data  == 0){
						alert("订单不存在！")
						location.reload();
					} 
					if(data  == 1){
						alert("订单已支付！")
						location.reload();
					}
					if(data  == 2){
						alert("订单已关闭！")
						location.reload();
					}
					
					if(data  == 3){
						window.location.href = "/toorder_pay?id="+id;
					}
				},'json')
			}
		
			$(".popup").hide();
			$("#szz").click(function(){
				$("#popup").show();
			})
			$("#sxb").click(function(){
				$("#popup2").show();
			})
			$("img.close").click(function(){
				$(".popup").hide();
			})
		</script>
		
		<script type="application/javascript">  
			var num =1;
			var total = 300*num;
			$("#total").html(total);	
			$(document).ready(function(){
				//加的效果
				$("#add").click(function(){
					var n=$(this).prev().children("input").val();
					var num=parseInt(n)+1;
					if(num==0){ return;}
					total = 300*num;
					$(this).prev().children("input").val(num);
					$("#total").html(total);	
					});
				//减的效果
				$("#jian").click(function(){
					var n=$(this).next().children("input").val();
					var num=parseInt(n)-1;
					if(num== 0){ return;}
					total = 300*num;
					$(this).next().children("input").val(num);
					$("#total").html(total);	
				});
				
				
				$("#num").keyup(function(){
					var num=$(this).val();
					total = 300*num;
					$("#total").html(total);
    			});
			})
			
			$("#buyszz").click(function(){
				var m = total;
				var c = total/300;
				window.location.href="/order_pay?type=2&&count="+c;
			})
		</script> 
		
		<script type="application/javascript">  
			var num2 =1;
			var total2 = 100*num2;
			$("#total2").html(total2);	
			$(document).ready(function(){
				//加的效果
				$("#add2").click(function(){
					var n=$(this).prev().children("input").val();
					var num2=parseInt(n)+1;
					if(num2 == 0){ return;}
					total2 = 100*num2;
					$(this).prev().children("input").val(num2);
					$("#total2").html(total2);	
					});
				//减的效果
				$("#jian2").click(function(){
					var n=$(this).next().children("input").val();
					var num2 =parseInt(n)-1;
					if(num2 == 0){ return;}
					total2 = 100*num2;
					$(this).next().children("input").val(num2);
					$("#total2").html(total2);	
				});
				
				
				$("#num2").keyup(function(){
					var num2=$(this).val();
					total2 = 100*num2;
					$("#total2").html(total2);
    			});
			})
			
			$("#buysxb").click(function(){
				var m = total2;
				var c = total2/100;
				window.location.href="/order_pay?type=1&&count="+c;
			})
		</script> 
		
		
		<script type="text/javascript">
	        $(function (){
				var currYear = (new Date()).getFullYear();	
				var opt={};
				opt.date = {preset : 'date'};
				opt.datetime = {preset : 'datetime'};
				opt.time = {preset : 'time'};
				opt.default = {
					theme: 'android-ics light', //皮肤样式
			        display: 'modal', //显示方式 
			        mode: 'scroller', //日期选择模式
					dateFormat: 'yyyy-mm-dd',
					lang: 'zh',
					showNow: true,
				 	setText: "确定",
					nowText: "今天",
					cancelText: "取消",
			        startYear: currYear - 10, //开始年份
			        endYear: currYear + 10 //结束年份
				};
	
			  	$("#appDate").mobiscroll($.extend(opt['date'], opt['default']));
			  	$("#appDate2").mobiscroll($.extend(opt['date'], opt['default']));
			  	var optDateTime = $.extend(opt['datetime'], opt['default']);
			  	var optTime = $.extend(opt['time'], opt['default']);
			    $("#appTime").mobiscroll(optTime).time(optTime);
	        });
	    </script>
		
	</body>
</html>
