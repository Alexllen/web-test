<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>天天论坛</title>

<!-- Bootstrap CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 50px;
	padding-bottom: 40px;
	color: #5a5a5a;
}

/*滚动图*/
.carousel {
	height: 435px;
	margin-bottom: 0px;
}

.carousel .item {
	height: 435px;
}

.carousel-caption p {
	margin-bottom: 0px;
	font-size: 20px;
	line-height: 1.8;
}

/*简介*/
.summary {
	padding-left: 15px;
	padding-right: 15px;
}

.summary .col-md-4 {
	margin-bottom: 20px;
	text-align: center;
}

/*特征*/
.feature-divider {
	margin: 40px 0;
}

.feature {
	padding: 30px 0;
}

.feature-heading {
	font-size: 50px;
	color: #2a6496;
}

.feature-heading .text-muted {
	font-size: 28px;
}

ol {
	counter-reset: :li;
	list-style: none;
	*list-style: decimal;
	font: 15px 'trebuchet MS', 'lucida sans';
	padding: 0;
	margin-bottom: 4em;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
}

.rounded-list a {
	position: :relative;
	display: block;
	padding: .4em .4em .4em .2em;
	*padding: .4em;
	margin: .5em 0;
	background: #ddd;
	color: #444;
	text-decoration: none;
	border-radius: .3em;
	transition: all .3s ease-out;
}

/*响应式*/
@media ( max-width : 768px) {
	.summary {
		padding-top: 0px； padding-left:3px;
		padding-right: 3px;
	}
	.carousel {
		height: 300px;
		margin-bottom: 30px;
	}
	.carousel .item {
		height: 300px;
	}
	.carousel img {
		min-height: 300px;
	}
	.carousel-caption p {
		font-size: 16px;
		line-height: 1.4;
	}
	.feature-heading {
		font-size: 34px;
	}
	.feature-heading .text-muted {
		font-size: 22px;
	}
}

@media ( min-width : 992px) {
	.feature-heading {
		margin-top: 120px;
	}
}
</style>
</head>
<body>

	<!-- 导航 -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		id="menu-nav">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<div style="width:1000px; float:left;font-size:20px;font-size: 50px;color: #c1c16b;"
					class="navbar-brand" onClick="window.location.href='Main.do'">天天论坛</div>
				<%
					String name=(String)request.getAttribute("name");
						String picture=(String)request.getAttribute("pichead");
						if(name!=null&&picture!=null){
				%>
				<div style="width:40px; float:right;" class="icon" href="#">
					<img src="./images/<%=picture%>" width="40px" height="40px"
						style="border-radius:50%">
				</div>
				<div style="width:60px; float:right;padding-top: 10px;
				font-size: 20px;color:white;"class="username"><%=name%></div>
				<div
					style="width:40px; float:right;padding-top: 10px;
					font-size: 20px;color:white;"
					class="welcome">欢迎</div>
				<%
					}else{
				%>
				<div style="width:65px; float:right;" class="btn btn-lg btn-primary"
					onClick="window.location.href='register.jsp'" role="button"
					align="right">注册</div>
				<div style="width:65px; float:right;" class="btn btn-lg btn-primary"
					onClick="window.location.href='login.jsp'" role="button"
					align="right">登录</div>
				<%
					}
				%>
			</div>
		</div>
	</nav>
	<!-- 广告轮播 -->
	<div id="carousel-id" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carousel-id" data-slide-to="0" class=""></li>
			<li data-target="#carousel-id" data-slide-to="1" class=""></li>
			<li data-target="#carousel-id" data-slide-to="2" class="active"></li>
			<li data-target="#carousel-id" data-slide-to="3" class=""></li>
			<li data-target="#carousel-id" data-slide-to="4" class=""></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide"
					alt="First slide" src="./images/Android.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Android开发</h1>
					</div>
				</div>
			</div>
			<div class="item">
				<img
					data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide"
					alt="Second slide" src="./images/html5-css.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>html5与css3实现动态网页</h1>
					</div>
				</div>
			</div>
			<div class="item">
				<img
					data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide"
					alt="Second slide" src="./images/React Native.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>React native开发</h1>
					</div>
				</div>
			</div>
			<div class="item">
				<img
					data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide"
					alt="Second slide" src="./images/weixin.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>微信小程序</h1>

					</div>
				</div>
			</div>
			<div class="item ">
				<img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide"
					alt="Third slide" src="./images/python.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>python</h1>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#carousel-id" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#carousel-id" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>

	<!-- 主要内容 -->
	<div class="container summary">

		<!-- 特征 -->
		<hr class="feature-divider">

		<ul class="nav nav-tabs" id="feature-tab">
			<li class="active"><a href="#tab-ready" data-toggle="tab">帖子分类列表--></a></li>
			<%
				Map<Integer,String> map=(Map<Integer,String>)request.getAttribute("cgmap");
						ArrayList<Integer> list =new ArrayList<Integer>(map.keySet());
							for (Map.Entry<Integer,String> entry : map.entrySet()) {
			%>
			<li><a href="#tab-<%=entry.getKey()%>" data-toggle="tab"><%=entry.getValue()%></a></li>
			<%
				}
			%>
		</ul>
		<div class="tab-content">
			<div class="tab-pane active" id="tab-ready">
				<div class="row feature">
					<div class="col-md-7">欢迎进入天天论坛，这里是提供技术交流的平台</div>
					<div class="col-md-5">
						<img src="./images/chrome-logo.jpg" alt=""
							class="img-responsive feature-image">
					</div>
				</div>
			</div>
			<%
				for(int i=0;i<list.size();i++){
					String mapname="tymap"+list.get(i);
					Map<Integer,String> tymap=(Map<Integer,String>)request.getAttribute(mapname);
			%>
			<div class="tab-pane" id="tab-<%=list.get(i)%>">
				<div class="row feature">
					<div class="col-md-7">
						<ol class="rounded-list">
							<%
								if(tymap!=null||tymap.size()>0)
													for (Map.Entry<Integer,String> entrytest : tymap.entrySet()) {
							%>
							<li><a href="TopicAll.do?typeid=<%=entrytest.getKey()%>"><%=entrytest.getValue()%></a></li>
							<%
								}else{
							%>
							抱歉当前类型并没有分类帖子
							<%
								}
							%>
						
					</div>
					<div class="col-md-5">
						<img src="./images/safari-logo.jpg" alt=""
							class="img-responsive feature-image">
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<footer>
			<p class="pull-right">
				<a href="#">回到顶部</a>
			<p>&copy;钟敏，胡清涛</p>
			</p>
		</footer>
	</div>



	<!-- jQuery -->
	<script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
	<!-- Bootstrap JavaScript -->
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#carousel-id").carousel();
			$("#menu-nav .navbar-collapse a").click(function() {
				// var href=$(this).attr('href');
				var tabId = $(this).attr('data-tab');
				// console.log(tabId);
				$("#feature-tab  a[href=#" + tabId + "]").tab("show");
			});
		});
	</script>
</body>
</html>