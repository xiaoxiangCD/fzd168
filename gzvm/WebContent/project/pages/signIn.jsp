<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松</title>

<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/signIn.css">
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
					<span class="current">赛事资讯</span>
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
		<div class="infor w space_bottom">
			<p class="hint align_c w space_top">为了保证您能正常参赛，请保证您所有填写信息正确无误！</p>
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 手机号码</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-5 align_l ps">PS:填写常用手机号码</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 证件类型</div>
				<div class="col-md-4">
					<select class="item w" type="select">
						<option>身份证</option>
						<option>护照</option>
						<option>港澳通行证</option>
					</select>
				</div>
				<div class="col-md-1 align_l"><span class="required">*</span> 证件号码</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 真实姓名</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1 align_l"><span class="required">*</span> 性别</div>
				<div class="col-md-4">
					<select class="item w" type="select">
						<option>男</option>
						<option>女</option>
					</select>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 出生日期</div>
				<div class="col-md-4">
					<select name="SYear" id="SYear" class="date date_left">
					　　 <option value="">年</option>
					</select>
					<select name="SMonth" id="SMonth" class="date">
					　　 <option value="">月</option>
					</select>
					<select name="SDay" id="SDay" class="date date_right">
					　　 <option value="">日</option>
					</select>
				</div>
				
				<div class="col-md-6"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 紧急联系人</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1 align_l"><span class="required">*</span> 紧急联系方式</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 参赛证明</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-5 align_l ps">PS:图片上传插件</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l">职业</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1 align_l">邮箱</div>
				<div class="col-md-4">
					<input class="item w" type="text"/>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l">地址</div>
				<div class="col-md-7">
					<textarea class="area w" ></textarea>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<div class="rule">
						<lable>
							<input class="rule_select" type="checkbox" value="">
							<p class="rule_dsc">
								我已阅读并同意“<a href="#"><span class="secure">2017国际垂直马拉松成都保险方案</span></a>”
							</p>
						</lable>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="title space_top">
						<h2 class="title_cn">| 参赛包</h2>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row package_panel space_top">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="package">
						<div class="package_title">
							<p class="package_name">标准参赛包：</p>
							<p class="package_value">￥189</p>
						</div>
						<div class="package_text">
							<p class="package_content">码布+芯片+奖牌+保险+赛事包</p>
							<input class="package_select" type="checkbox" value="">
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row package_panel space_top">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="package">
						<div class="package_title">
							<p class="package_name">标准参赛包：</p>
							<p class="package_value">￥189</p>
						</div>
						<div class="package_text">
							<p class="package_content">码布+芯片+奖牌+保险+赛事包</p>
							<input class="package_select" type="checkbox" value="">
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="title space_top">
						<h2 class="title_cn">| 附加保险</h2>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="secure row space_top">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<lable>
						<input class="secure_select" type="checkbox" value="">
						<p class="secure_dsc">
							<a href="#">2017国际垂直马拉松成都保险方案</a>
						</p>
						<p class="secure_value">￥189</p>
					</lable>
				</div>
				<div class="col-md-1"></div>
				<div class="clear"></div>
			</div>
			
			<div class="secure row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<lable>
						<input class="secure_select" type="checkbox" value="">
						<p class="secure_dsc">
							<a href="#">2017国际垂直马拉松成都保险方案</a>
						</p>
						<p class="secure_value">￥189</p>
					</lable>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			
			<div class="row space_top ">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input class="item w bg_color btn space_top" type="submit" value="立即报名" id="sure"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
		</div>
	</div>
	<div id="footer">
		<div class="footer_panel" >
			<p class="footer_item">广州垂马体育发展有限公司</p>
		</div>
	</div>
	
	<div class="pop_panel">
		<div class="pop_top w">
			<p>温馨提示</p>
			<span class="pop_exit" id="exit">
				<img src="/gzvm/client/images/exit.png">
			</span>
		</div>
		<div class="pop_content">
			<div class=" w space_top space_bottom">
				<div class="row space_bottom hint_panel align_c">
					<div class="pop_hint pop_hint_l">
						<span class="hint_img">
							<img src="/gzvm/client/images/hint_img.png">
						</span>
					</div>
					<div class="pop_hint pop_hint_r">
						<p class="success_hint align_l w ">您已成功报名赛事“成都IFS”，请留意短信信息。报名结果公示，我们将第一时间短信通知您！</p>
					</div>
				</div>
				<div class="row space_top align_c">
					<div class="align_c">
						<input class="item  bg_color btn  pop_btn" type="submit" value="立即登录" id="login"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>

</body>
    <script type="text/javascript">
    
	    $("#sure").click(function(){
			$(".pop_panel").show();
		})
		$("#exit").click(function(){
			$(".pop_panel").hide();
		})
	
	
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