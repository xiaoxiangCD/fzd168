$().ready(function() { 
	var h = $(window).height() - 125;
	$("#container").height(h+'px');
	/*$('#logoImg').click(function(){
		window.location.href = '/gzvm/manage/pages/index.jsp';
		});
	setLogoImg();*/
	setFooter();
})

function setFooter(){//设置底部的内容
	var htmlStr = '<div class="footer_panel" ><p class="footer_item">广州锋之道实业有限公司</p></div>';
	$('#footer').html(htmlStr);
}

function setLogoImg(){//换logo
	/*var htmlStr = '/gzvm/manage/images/chuima.png';*/
	var htmlStr = '/gzvm/fzd/images/fzd.png';
	$('#logoImg').attr("src",htmlStr);
}

function openAdministrate(){//管理员管理
	window.location.href = '/gzvm/manage/pages/manage/administrate.jsp';
}

function openRole(){//角色管理
	window.location.href = '/gzvm/manage/pages/manage/role.jsp';
}

function openGame(){//赛事管理
	window.location.href = '/gzvm/manage/pages/game/game.jsp';
}

function openGamePackage(){//参赛包管理
	window.location.href = '/gzvm/manage/pages/game/game_package.jsp';
}

function openSignUp(){//报名管理
	window.location.href = '/gzvm/manage/pages/game/game_sign_up.jsp';
}

function openLottery(){//中签管理
	window.location.href = '/gzvm/manage/pages/game/game_lottery.jsp';
}

function openPlayer(){//选手管理
	window.location.href = '/gzvm/manage/pages/player/player_manage.jsp';
}

function openBanner(){//banner管理
	window.location.href = '/gzvm/manage/pages/game/game.jsp';
}

function openProblem(){//常见问题
	window.location.href = '/gzvm/manage/pages/game/game.jsp';
}

function openContact(){//联系我们
	window.location.href = '/gzvm/manage/pages/game/game.jsp';
}
var Theight = '';
function initTable(options){
	Theight = $('#container').height() - ($('.ctrl_panel').height() + 40);
	$(".table_panel").height(Theight+'px');
	var tableOption = {
		height: Theight,
		striped: true,
		pagination: true,
		pageSize: 20,
		pageNumber:1,
		pageList: [10, 15, 20, 30, 50, 100],
		//search: true,
		clickToSelect: true,
		singleSelect : true,
		onPageChange : function (number, size){
			
		},
		onLoadSuccess : function (data){
			console.log(data);
			if (data.resultCode == 1) {
				$('#'+options.tableId).bootstrapTable('load',data.results);
			}else{
				alert(data.resultMsg);
				if (data.hasLogined == 0) {
					logout();
				}
			}
		},
	}
	for (var key in options) {
		tableOption[key] = options[key];
	}
	$('#'+options.tableId).bootstrapTable(tableOption);
	
}

function logout(){
	window.location.href = '/gzvm/admin!logout.action';
}

/*setInterval(ping, 150000);
function ping() {
	$.ajax({
		url : '/gzvm/admin!ping.action',
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if (result.resultCode == 0) {
				parent.logout();
			}
		}
	});
}*/

/** 以数组获取select的option
 */
function getSelectOptionStr(results,valueFiled,nameFiled){
	var htmlStr = '';
	for (var i in results) {
		var obj = results[i];
		htmlStr += '<option value="'+obj[valueFiled]+'">'+obj[nameFiled]+'</option>';
	}
	return htmlStr;
}
