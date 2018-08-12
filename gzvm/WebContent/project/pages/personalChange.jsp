<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松</title>

<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/personalChange.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
</head>
<body>
<div class="bg">
	<div id="header">
		<div class="header_panel" >
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="/gzvm/client/images/chuima.png" class="img-responsive logo_img">
					</div>
					<div class="col-md-6 logo_panel">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="nav_panel">
		<ul class="nav h">
			<li class="h">
				<a href="#">
					<span >首页</span>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span >赛事资讯</span>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span>关于我们</span>
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
		
		<div class="detail float-l">
			<div class="infor w  space_bottom context_panel">
				<div class="detail_title align_l w space_bottom">
					<p class="detail_name">修改密码</p>
					<!-- <p class="detail_dsc">（PS:为了保证您能正常参赛，请保证您所有填写信息正确无误！）</p> -->
				</div>		
			<div class="row space_bottom ">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 手机号码</div>
				<div class="col-md-5">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 手机号码</div>
				<div class="col-md-5">
					<input class="item verify_text" type="text"/>
					<input class="item verify_btn bg_color" type="submit" value="获取验证码"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 密码</div>
				<div class="col-md-5">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 确认 密码</div>
				<div class="col-md-5">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
			<div class="row space_top ">
				<div class="col-md-3"></div>
				<div class="col-md-5">
					<input class="item w bg_color btn sub_btn" type="submit" value="确认提交" id="sure"/>
				</div>
				<div class="col-md-4"></div>
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
        $(function(){
            var yearid = $('#SYear')    //年所在的控件
            var monthid = $('#SMonth')    //月所在的控件
            var dayid = $('#SDay')    //天所在的控件
            var myDate = new Date();
            var year = myDate.getFullYear();
            
            for(var i=(year-10);i<=(year+10);i++){
                yearid.append('<option value="'+i+'">'+i+'</option>')
            }
            
            yearid.change(function(){
                monthid.html('')
                for(var i=1;i<=12;i++){
                    monthid.append('<option value="'+i+'">'+i+'</option>')
                }
                
                monthid.change()
            })
            
            monthid.change(function(){
                var yearValue = yearid.val()
                var monthValue = parseInt(monthid.val())
                var dayvalue ;
                dayid.html('')
                
                
              if(monthValue==1||monthValue==3||monthValue==5||monthValue==7||monthValue==8||monthValue==10||monthValue==12)   {
                    dayvalue = 31
                }else if(monthValue==4||monthValue==6||monthValue==11||monthValue==9)    {
                    dayvalue = 30
                }else if(monthValue==2){
                    
                    if(yearValue%4==0 && (yearValue%4 !=0 || yearValue%400==0)){ //闰年
                        dayvalue = 29
                    }else{
                        dayvalue = 28    
                    }
                    
                }
                
                for(var i=1;i<=dayvalue;i++){
                    dayid.append('<option value="'+i+'">'+i+'</option>')
                }
                                
            })
        })
    </script>
</html>