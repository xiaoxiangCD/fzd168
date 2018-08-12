<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/css/pagination.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/personalMine.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script type="text/javascript" src="/gzvm/js/jquery.pagination.js"></script>
</head>
<body>
<div class="bg">
	<div id="header">
		<div class="header_panel" >
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="/gzvm/client/images/logo.png" class="img-responsive logo_img">
					</div>
					<div class="col-md-3 logo_panel">
						<img  src="/gzvm/client/images/avalogo.png" class="img-responsive avalogo_img">
						<img  src="/gzvm/client/images/tvalogo.png" class="img-responsive avalogo_img">
					</div>
					<div class="col-md-3 logo_panel">
						<p class="login_text"><a href="">登录</a> | <a href="">注册</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="nav_panel">
		<ul class="nav h" id="nav">
			<li class="h ">
				<a href="#">
					<span class="index_icon" id="index"></span>
					<span class="nav_name " id="index_name">首页</span>
					<div class="clear"></div>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span class="competition_icon" id="competition"></span>
					<span class="nav_name" id="competition_name">赛事资讯</span>
					<div class="clear"></div>
				</a>  
			</li>
			<li class="h current">
				<a href="#">
					<span class="about_icon_current" id="about"></span>
					<span class="nav_name nav_name_current" id="about_name">关于我们</span>
					<div class="clear"></div>
				</a>  
			</li>
			
		</ul>
	</div>
	
	<div class="container content space_top">
		<div class="sub_nav float_l">
			<div class="basics">
				<div class="user_img">
					<img src="/gzvm/client/images/default.png">
				</div>
				<div class="user_infor">
					<p class="user_name">用户昵称</p>
					<p class="user_detail">
						<span class="user_sex">女</span>
						<span class="user_age">25</span>
					</p>
				</div>
			</div>
			<div class="sub_type personal current">
				<p>个人资料</p>
			</div>
			<div class="sub_type change">
				<p>修改密码</p>
			</div>
			<div class="sub_type mine">
				<p>我的赛事</p>
			</div>
			<div class="sub_type grade">
				<p>成绩查询</p>
			</div>
		</div>
		
		<div class="detail_panel float-l">
			<div class="list">
				<div class="detail_title align_l w space_bottom">
					<p class="detail_name">我报名的赛事</p>
					<div class="state_search">
						<lable>
							<select class="form-control search_input " type="text" name="" >
								<option>赛时状态</option>
								<option>预报名</option>
								<option>抽签中</option>
								<option>开赛</option>
								<option>已结束</option>
							</select>
							<input class="form-control btn bg_color state_btn" type="submit"  value="赛事筛选"/>
							<div class="clear"></div>
						</lable>
					</div>
				</div>
				<div class="competition">
					<div class="row">
						<div class="col-md-6">
							<div class="comptition_img">
								<img src="/gzvm/client/images/default.png">
							</div>
						</div>
						<div class="col-md-6">
							<div class="comptition_text">
								<div class="competition_title">成都国际金融中心（成都IFS）</div>
								<div class="competition_type">
									<p>个人赛</p>
									<p>系列赛</p>
								</div>
								<div class="competiton_date">
									<p>时间：</p>
									<p id="date">2017-04-13</p>
								</div>
								<div class="competiton_adress">
									<p>地点：</p>
									<p id="adress">成都国际金融中心</p>
								</div>
								<div class="competition_dsc">
									<p>
										本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中…
									</p>
								</div>
								<div class="detail">
									<a href="#">更多详情 ></a>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="competition">
					<div class="row">
						<div class="col-md-6">
							<div class="comptition_img">
								<img src="/gzvm/client/images/default.png">
							</div>
						</div>
						<div class="col-md-6">
							<div class="comptition_text">
								<div class="competition_title">成都国际金融中心（成都IFS）</div>
								<div class="competition_type">
									<p>个人赛</p>
									<p>系列赛</p>
								</div>
								<div class="competiton_date">
									<p>时间：</p>
									<p id="date">2017-04-13</p>
								</div>
								<div class="competiton_adress">
									<p>地点：</p>
									<p id="adress">成都国际金融中心</p>
								</div>
								<div class="competition_dsc">
									<p>
										本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中…
									</p>
								</div>
								<div class="detail">
									<a href="#">更多详情 ></a>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="competition">
					<div class="row">
						<div class="col-md-6">
							<div class="comptition_img">
								<img src="/gzvm/client/images/default.png">
							</div>
						</div>
						<div class="col-md-6">
							<div class="comptition_text">
								<div class="competition_title">成都国际金融中心（成都IFS）</div>
								<div class="competition_type">
									<p>个人赛</p>
									<p>系列赛</p>
								</div>
								<div class="competiton_date">
									<p>时间：</p>
									<p id="date">2017-04-13</p>
								</div>
								<div class="competiton_adress">
									<p>地点：</p>
									<p id="adress">成都国际金融中心</p>
								</div>
								<div class="competition_dsc">
									<p>
										本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中…
									</p>
								</div>
								<div class="detail">
									<a href="#">更多详情 ></a>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="competition">
					<div class="row">
						<div class="col-md-6">
							<div class="comptition_img">
								<img src="/gzvm/client/images/default.png">
							</div>
						</div>
						<div class="col-md-6">
							<div class="comptition_text">
								<div class="competition_title">成都国际金融中心（成都IFS）</div>
								<div class="competition_type">
									<p>个人赛</p>
									<p>系列赛</p>
								</div>
								<div class="competiton_date">
									<p>时间：</p>
									<p id="date">2017-04-13</p>
								</div>
								<div class="competiton_adress">
									<p>地点：</p>
									<p id="adress">成都国际金融中心</p>
								</div>
								<div class="competition_dsc">
									<p>
										本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中…
									</p>
								</div>
								<div class="detail">
									<a href="#">更多详情 ></a>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="competition">
					<div class="row">
						<div class="col-md-6">
							<div class="comptition_img">
								<img src="/gzvm/client/images/default.png">
							</div>
						</div>
						<div class="col-md-6">
							<div class="comptition_text">
								<div class="competition_title">成都国际金融中心（成都IFS）</div>
								<div class="competition_type">
									<p>个人赛</p>
									<p>系列赛</p>
								</div>
								<div class="competiton_date">
									<p>时间：</p>
									<p id="date">2017-04-13</p>
								</div>
								<div class="competiton_adress">
									<p>地点：</p>
									<p id="adress">成都国际金融中心</p>
								</div>
								<div class="competition_dsc">
									<p>
										本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中…
									</p>
								</div>
								<div class="detail">
									<a href="#">更多详情 ></a>
								</div>
							</div>
						</div>
					</div>
				</div>	
				<div class="page space_top space_bottom ">
					<div class="M-box3"></div>
					<div class="clear"></div>
				</div>
			</div>
					
		</div>
		
		<div class="clear"></div>
	</div>
	<div id="footer">
		<div class="footer_panel" >
			<p class="footer_item">广州垂马体育发展有限公司</p>
		</div>
	</div>
</div>

</body>
    <script type="text/javascript">
	    $('.M-box3').pagination({
	        pageCount:50,
	        jump:true,
	        coping:true,
	        homePage:'首页',
	        endPage:'末页',
	        prevContent:'上页',
	        nextContent:'下页'
	    });
    </script>
</html>