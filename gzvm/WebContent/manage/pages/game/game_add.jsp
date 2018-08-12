<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赛事发布</title>
<link rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link rel="stylesheet" href="/gzvm/css/common.css">
<link rel="stylesheet" href="/gzvm/css/bootstrap-table.css">
<link rel="stylesheet" href="/gzvm/manage/css/game_add.css">
<link type="text/css" rel="stylesheet" href="/gzvm/css/sweetalert.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>

</head>
<body>
	<div id="header">
		<div class="header_panel">
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="" class="img-responsive logo_img">
						<!-- <p class="header_fonts">| 欢迎你</p> -->
					</div>
					<div class="col-md-6 user_panel">
						<div class="user_panel">
							<img id="headImg" src="/gzvm/manage/images/imgNull.png"
								class="img-circle head_img">
							<p class="user_name">管理员1</p>
						</div>
						<p class="login_out">
							| <a style="color: #FFF;"> 【退出】</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container" id="container">
		<div class="row mg_choice_panel">
			<div class="col-md-2 mg_left_panel">
				<div class="mg_choice_item">
					<div class="mg_choice_name">管理</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openAdministrate();">管理员管理</li>
						<li class="mg_list_item" onclick="openRole();">角色管理</li>
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">赛事</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item  mg_active">赛事管理</li>
						<li class="mg_list_item" onclick="openGamePackage();">参赛包管理</li>
						<li class="mg_list_item" onclick="openSignUp();">报名管理</li>
						<li class="mg_list_item" onclick="openLottery();">中签管理</li>
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">用户</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openPlayer();">选手管理</li>
						<!-- <li class="mg_list_item">角色管理</li>
						<li class="mg_list_item">消息管理</li> -->
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">显示</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openBanner();">banner管理</li>
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">联系我们</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openProblem();">常见问题</li>
						<li class="mg_list_item" onclick="openContact();">联系方式</li>
					</ul>
				</div>	
			</div>

			<div class="col-md-10 mg_right_panel">
				<div class="row ctrl_panel">
					<div class="col-md-6">
						<div class="col-md-6 ctrl_item" style="text-align: left;">
							<a onclick="openGame();">赛事管理</a>><a>赛事发布</a>
						</div>
						<div class="col-md-6 ctrl_item"></div>
					</div>
					<div class="col-md-6"></div>
				</div>
				<div class="add_panel">
					<div class="panel_one">
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-1"></div>
								<div class="col-md-4 panel_title">
									<a class="panel_name">1.赛事基本信息</a>
								</div>
							</div>
							<div class="col-md-6"></div>
						</div>
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>赛事名称:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="competiName">
								</div>
							</div>
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>赛事级别:</label>
								</div>
								<div class="col-md-8">
									<select class="form-control" id="level">
										<option value="">--请选择--</option>
										<option value="1">系列赛</option>
										<option value="2">公开赛</option>
										<option value="3">挑战赛</option>
										<option value="4" >精英赛</option>
										<option value="5">大满贯</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>赛事组别:</label>
								</div>
								<div class="col-md-8">
									<select class="form-control" id="groupType" >
										<option value="">--请选择--</option>
										<option value="1">个人组</option>
								    <!-- <option>团体组</option> -->		
									<!-- <option>个人组+团体组</option> -->		
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>参赛人数:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="peopleNum">
								</div>
							</div>
						</div>
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>比赛开始时间:</label>
								</div>
								<div class="col-md-8">
									<input type="date" class="form-control" id="startTime">
								</div>
							</div>
							
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>比赛结束时间:</label>
								</div>
								<div class="col-md-8">
									<input type="date" class="form-control" id="endTime">
								</div>
							</div>
						</div>
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>报名开始时间:</label>
								</div>
								<div class="col-md-8">
									<input type="date" class="form-control" id="joinStartTime">
								</div>
							</div>
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>报名结束时间:</label>
								</div>
								<div class="col-md-8">
									<input type="date" class="form-control" id="joinEndTime">
								</div>
							</div>
						</div>
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>报名形式:</label>
								</div>
								<div class="col-md-8">
									<select class="form-control" id="joinType" onchange="changeJoinType()">
										<option value="">--请选择--</option>
										<option value="1">预报名</option>
										<option value="2">直接报名</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>收费形式:</label>
								</div>
								<div class="col-md-8">
									<select class="form-control" id="chargeType">
										<option>--请选择--</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>参赛包:</label>
								</div>
								<div class="col-md-8">
									<select class="form-control">
										<option>--请选择--</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>参赛费用:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="">
								</div>
							</div>
						</div>
						
							<div class="row .mg_add_item add_row">
							
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>所在城市:</label>
								</div>
								<div class="col-md-8">
									<select class="form-control" id="city">
										<option value="">--请选择--</option>
										<option value="1">北京</option>
										<option value="2">上海</option>
										<option value="3">广州</option>
										<option value="4">深圳</option>
										<option value="5">成都</option>
										<option value="6">惠州</option>
										<option value="7">佛山</option>
									</select>
								</div>
							</div>
							
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>详细地址:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="addr">
								</div>
							</div>
						</div>
						
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-3 mg_add_item_label">
									<label>封面图片:</label>
								</div>
								<div class="col-md-6">
									<img alt="" src="/gzvm/manage/images/imgNull.png"
										class="face_img">
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_img_btn">选择图片</button>
								</div>
							</div>
							<div class="col-md-6"></div>
						</div>
						<div class="row .mg_add_item add_row last_row">
							<div class="col-md-6"></div>
							<div class="col-md-6">
								<div class="col-md-5"></div>
								<div class="col-md-3">
									<button class="btn mg_btn edit_sure" onclick="saveCompet();">确定</button>
								</div>
								<div class="col-md-3">
									<button class="btn mg_btn edit_cancel">取消</button>
								</div>
							</div>
						</div>
					</div>

					<div class="panel_two">
						<div class="row .mg_add_item add_row">
							<div class="col-md-6">
								<div class="col-md-1"></div>
								<div class="col-md-4 panel_title">
									<a class="panel_name">2.赛事优惠</a>
								</div>
<!-- 								<div class="col-md-7 panel_edit"> -->
<!-- 									<button class="btn mg_btn edit_btn">编辑</button> -->
<!-- 								</div> -->
							</div>
							<div class="col-md-6"></div>
						</div>
<!-- 						<div class="row .mg_add_item add_row"> -->
<!-- 							<div class="col-md-6"> -->
<!-- 								<div class="col-md-1"></div> -->
<!-- 								<div class="col-md-3 mg_add_item_label"> -->
<!-- 									<p>口令减免设定:</p> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-3"> -->
<!-- 									<a class="new_command"> + 新增口令</a> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="col-md-6"></div> -->
<!-- 						</div> -->
						<div class="row .mg_add_item add_row">
							<div class="col-md-1"></div>
							<div class="col-md-3 mg_padding_clear">
								<div class="col-md-4 mg_add_item_label">
									<label>口令编码:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="password">
								</div>
							</div>
							<div class="col-md-3 mg_padding_clear">
								<div class="col-md-4 mg_add_item_label">
									<label>减免费用:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="discount">
								</div>
							</div>
							<div class="col-md-3 mg_padding_clear">
								<div class="col-md-4 mg_add_item_label">
									<label>使用次数:</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="discountNum">
								</div>
							</div>
							<div class="col-md-2">
								<button class="btn mg_btn edit_btn del_command" onclick="saveDiscount();">新增口令</button>
							</div>
						</div>
						<div class="row .mg_add_item add_row" style="padding: 0 14px;">
							<table id="orderTable" data-undefined-text="暂无数据"></table>
						</div>
						<div class="row .mg_add_item add_row last_row">
							<div class="col-md-6"></div>
							<div class="col-md-6">
								<div class="col-md-5"></div>
								<div class="col-md-3">
								</div>
								<div class="col-md-3">
								</div>
							</div>
						</div>

						<div class="panel_three">
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-1"></div>
									<div class="col-md-4 panel_title">
										<a class="panel_name">3.报名信息</a>
									</div>
									<div class="col-md-7 panel_edit">
										<button class="btn mg_btn edit_btn">编辑</button>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-3 mg_add_item_label">
										<label>附加资料:</label>
									</div>
									<div class="col-md-8">
										<select class="form-control">
											<option>--请选择--</option>
											<option>证件照</option>
											<option>生活照</option>
											<option>参赛证明</option>
											<option>体检证明</option>
										</select>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-1"></div>
									<div class="col-md-3 mg_add_item_label">
										<p>填写信息设定:</p>
									</div>
									<div class="col-md-3">
										<a class="new_command"> + 新增信息</a>
									</div>
									<!-- <div class="col-md-3">
										<a class="del_command"> - 删除口令</a>
									</div> -->
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<div class="col-md-12 mg_add_item_label">
										<label>1</label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-2 mg_add_item_label">
										<label>姓名:</label>
									</div>
									<div class="col-md-10">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<div class="col-md-12 mg_add_item_label">
										<label>2</label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-2 mg_add_item_label">
										<label>电话:</label>
									</div>
									<div class="col-md-10">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<div class="col-md-12 mg_add_item_label">
										<label>3</label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-2 mg_add_item_label">
										<label>证件号:</label>
									</div>
									<div class="col-md-10">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<div class="col-md-12 mg_add_item_label">
										<label>4</label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-2 mg_add_item_label">
										<label>装备码数:</label>
									</div>
									<div class="col-md-10">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<div class="col-md-12 mg_add_item_label">
										<label>5</label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-2 mg_add_item_label">
										<label>紧急联系人:</label>
									</div>
									<div class="col-md-10">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-1">
									<div class="col-md-12 mg_add_item_label">
										<label>6</label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-2 mg_add_item_label">
										<label>紧急联系方式:</label>
									</div>
									<div class="col-md-10">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row last_row">
								<div class="col-md-6"></div>
								<div class="col-md-6">
									<div class="col-md-5"></div>
									<div class="col-md-3">
										<button class="btn mg_btn edit_sure">确定</button>
									</div>
									<div class="col-md-3">
										<button class="btn mg_btn edit_cancel">取消</button>
									</div>
								</div>
							</div>
						</div>

						<div class="panel_four">
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-1"></div>
									<div class="col-md-4 panel_title">
										<a class="panel_name">4.中签规则</a>
									</div>
									<div class="col-md-7 panel_edit">
										<button class="btn mg_btn edit_btn">编辑</button>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-3 mg_add_item_label">
										<label>中签规则:</label>
									</div>
									<div class="col-md-8">
										<select class="form-control">
											<option>--请选择--</option>
											<option>根据年龄段</option>
											<option>根据服装数量</option>
										</select>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-1"></div>
									<div class="col-md-3 mg_add_item_label">
										<p>填写信息设定:</p>
									</div>
									<div class="col-md-3">
										<a class="new_command"> + 新增信息</a>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-3 mg_padding_clear">
									<div class="col-md-4 mg_add_item_label">
										<label>最小年龄:</label>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-3 mg_padding_clear">
									<div class="col-md-4 mg_add_item_label">
										<label>最大年龄:</label>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-3 mg_padding_clear">
									<div class="col-md-4 mg_add_item_label">
										<label>人数:</label>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-1"></div>
								<div class="col-md-3 mg_padding_clear">
									<div class="col-md-4 mg_add_item_label">
										<label>最小年龄:</label>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-3 mg_padding_clear">
									<div class="col-md-4 mg_add_item_label">
										<label>最大年龄:</label>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-3 mg_padding_clear">
									<div class="col-md-4 mg_add_item_label">
										<label>人数:</label>
									</div>
									<div class="col-md-8">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_btn del_command">删除信息</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row last_row">
								<div class="col-md-6"></div>
								<div class="col-md-6">
									<div class="col-md-5"></div>
									<div class="col-md-3">
										<button class="btn mg_btn edit_sure">确定</button>
									</div>
									<div class="col-md-3">
										<button class="btn mg_btn edit_cancel">取消</button>
									</div>
								</div>
							</div>
						</div>
						<div class="panel_five">
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-1"></div>
									<div class="col-md-4 panel_title">
										<a class="panel_name">5.文书信息</a>
									</div>
									<div class="col-md-7 panel_edit">
										<button class="btn mg_btn edit_btn">编辑</button>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-3 mg_add_item_label">
										<label>免责声明:</label>
									</div>
									<div class="col-md-9">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-6">
									<button class="btn mg_btn edit_btn choice_file">选择文件</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-6">
									<div class="col-md-1"></div>
									<div class="col-md-3 mg_add_item_label">
										<p>赛事保险设定:</p>
									</div>
									<div class="col-md-3">
										<a class="new_command"> + 新增保险</a>
									</div>
								</div>
								<div class="col-md-6"></div>
							</div>
							<div class="row .mg_add_item add_row">
								<div class="col-md-7">
									<div class="col-md-3 mg_add_item_label">
										<label>赛事保险:</label>
									</div>
									<div class="col-md-7">
										<input type="text" class="form-control">
									</div>
									<div class="col-md-2">
										<button class="btn mg_btn edit_btn choice_file">选择文件</button>
									</div>
								</div>
								<div class="col-md-3">
									<div class="col-md-5 mg_add_item_label">
										<label>保险费用:</label>
									</div>
									<div class="col-md-7">
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-1">
									<button class="btn mg_btn edit_btn del_command">保存</button>
								</div>
								<div class="col-md-1">
									<button class="btn mg_btn edit_btn del_command">删除</button>
								</div>
							</div>
							<div class="row .mg_add_item add_row last_row"></div>
						</div>
						<div class="row .mg_add_item add_row" style="padding-bottom:20px;">
							<div class="col-md-12">
								<div class="col-md-4"></div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_sure" style="padding: 3px 40px;">发布</button>
								</div>
								<div class="col-md-2">
									<button class="btn mg_btn edit_cancel">存为草稿</button>
								</div>
								<div class="col-md-4"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>
	<div id="alertWindow" class="mg_alert_window">
		<div class="mg_window_top">
			<p class="mg_title_font">删除</p>
			<p class="mg_title_icon">
				<img alt="" src="/gzvm/manage/images/close.png" class="mg_icon_img"
					onclick="closeDel();">
			</p>
		</div>
		<div class="mg_window_middle">
			<p class="mg_alert_item">删除后将无法回复，是否确定删除？</p>
		</div>
		<div class="mg_window_bottom">
			<div class="mg_btn_panel">
				<button class="btn mg_sure_btn mg_btn">确定</button>
			</div>
			<div class="mg_btn_panel">
				<button class="btn mg_cancel_btn" onclick="closeDel();">取消</button>
			</div>s
		</div>
	</div>

    <script src="/gzvm/js/sweetalert.min.js"></script>
	<script type="text/javascript" src="/gzvm/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="/gzvm/js/common.js"></script>
	<script type="text/javascript" src="/gzvm/manage/js/game_add.js"></script>
	<script type="text/javascript" src="/gzvm/js/bootstrap-table-zh-CN.js"></script>
</body>
</html>