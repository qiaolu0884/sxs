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
		<link rel="stylesheet" type="text/css" href="/css/sxs.css" />
		<!--<script type="text/javascript" src="js/jquery.js"></script>-->
	    <title>善心树</title>
	    <script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
<!--		<header class="index"></header>-->
	 	<!--侧拉导航  start-->
	 	<div class="slide_nav">
	 		<div class="bg"></div>
	 		<div class="content">
	 			<h2 class="clearfix">
		 			<div class="left">
		 				<img class="left" src="/img/_temp/logo.png"/>
		 				<span class="user_name left">善心汇</span>
		 			</div>
		 			<div class="btn right"><img src="/img/_temp/arrow.png"/></div>
		 		</h2>
		 		<ul>
		 			<li class="clearfix">
		 				<img src="/img/_temp/icon-szz.png"/>
		 				<img src="/img/_temp/szz_text.png"/>
		 				<span><em>${szzCount}</em>枚</span>
		 			</li>
		 			<li class="clearfix">
		 				<img src="/img/_temp/icon-sxb.png"/>
		 				<img src="/img/_temp/sxb_text.png"/>
		 				<span><em>${sxbCount}</em>枚</span>
		 			</li>
		 		</ul>
		 		<nav>
		 			<li><a href="/shop_online"><img src="/img/_temp/icon-car.png"/><img src="/img/_temp/car_text.png"/></a></li>
		 			<li><a href="/grow_record"><img src="/img/_temp/icon-grow.png"/><img src="/img/_temp/grow_text.png"/></a></li>
		 		</nav>
	 		</div>
	 		<div class="slide_navbg"></div>
	 	</div>
	 	<!--侧拉导航  end-->
		
		<!--成长阶段  start-->
		<section class="tree">
			<img src="/img/sl/${img}.png"/>
			<!--树龄13个阶段（种子--10年）-->
			<!--<img src="/img/sl/2.png"/>
			<img src="/img/sl/3.png"/>
			<img src="/img/sl/4.png"/>
			<img src="/img/sl/5.png"/>
			<img src="/img/sl/6.png"/>
			<img src="/img/sl/7.png"/>
			<img src="/img/sl/8.png"/>
			<img src="/img/sl/9.png"/>
			<img src="/img/sl/10.png"/>
			<img src="/img/sl/11.png"/>
			<img src="/img/sl/12.png"/>
			<img src="/img/sl/13.png"/>-->
			
			<div class="top">
			<!--头像-->
				<div class="info">
					<img src="/img/_temp/logo.png"/>
				</div>
				<div class="progress">
					<p>树龄：<span>${age}</span></p>
					<div class="clearfix">
						<div class="schedulebg left">
			                <div class="schedule" style="width:${jdt}%;"></div>
			                <p><em>${begin}</em>/<em>${end}</em></p>
			            </div>
			            <span class="right">正能量值</span>
					</div>
				</div>
			</div>
			<img onclick="window.location.href = '/tree_gdl' " class="map" src="/img/_temp/treemap.png"/>
			<img onclick="window.location.href = '/tree_gl' " class="gl" src="/img/_temp/treegl.png"/>	
		</section>
		<!--成长阶段  end-->
		
		<hr style="height: 10px; background: #f0f0f0;"/>
	
		<h2 class="title">
			<img src="/img/_temp/rank.png"/>
		</h2>
	
		<section class="wrapper rank">
			<ul>
				<li class="clearfix">
					<b class="left num">1</b>
					<div class="left clearfix content">
						<div class="left">
							<img src="/img/_temp/logo.png"/>
							<span class="name">善心汇</span>
						</div>
						<div class="right">
							<span>800</span>正能量
						</div>
					</div>
				</li>
				<li class="clearfix">
					<b class="left num">2</b>
					<div class="left clearfix content">
						<div class="left">
							<img src="/img/_temp/logo.png"/>
							<span class="name">善心汇</span>
						</div>
						<div class="right">
							<span>800</span>正能量
						</div>
					</div>
				</li>
				<li class="clearfix">
					<b class="left num">3</b>
					<div class="left clearfix content">
						<div class="left">
							<img src="/img/_temp/logo.png"/>
							<span class="name">善心汇</span>
						</div>
						<div class="right">
							<span>800</span>正能量
						</div>
					</div>
				</li>
				<li class="clearfix">
					<b class="left num">4</b>
					<div class="left clearfix content">
						<div class="left">
							<img src="/img/_temp/logo.png"/>
							<span class="name">善心汇</span>
						</div>
						<div class="right">
							<span>800</span>正能量
						</div>
					</div>
				</li>
				<li class="clearfix">
					<b class="left num">5</b>
					<div class="left clearfix content">
						<div class="left">
							<img src="/img/_temp/logo.png"/>
							<span class="name">善心汇</span>
						</div>
						<div class="right">
							<span>800</span>正能量
						</div>
					</div>
				</li>
			</ul>
			
			<a href="" class="more">查看更多</a>
		</section>
	
		<script type="text/javascript">
			$(document).ready(function(){
				$(".top .info").click(function(){
					$(".slide_nav").addClass("show");
					$(this).hide();
				});
				$(".slide_nav .btn").click(function(){
					$(".slide_nav").removeClass("show");
					$(".top .info").show();
				});
			})
			
		</script>
	</body>
</html>