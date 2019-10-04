layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	$(function () {
		$.ajax({url:'/film/all',type:'get',success:function (list) {
				var $container=$(".films_content");
				for (var i = 0; i < list.length; i++) {
					var film=list[i];
					var $tr=$("<tr></tr>");
					$container.prepend($tr);
					for (var j = 0; j <10 ; j++) {
						var $td=$("<td></td>");
						if (j==0){
							var check=$("<input type=\"checkbox\" name=\"checked\" lay-skin=\"primary\" lay-filter=\"choose\">");
							check.appendTo($td);
						}
						if (j==1)$td.html(film.filmName);
						if (j==2)$td.html(film.filmCode);
						if (j==3)$td.html(film.filmType);
						if (j==4)$td.html(film.filmLength);
						if (j==5)$td.html(film.filmSeason);
						if (j==6)$td.html(film.filmShotPlace);
						if (j==7)$td.html(film.filmArea);
						if (j==8)$td.html(film.filmClickNumber);
						if (j==9){
							var $a1=$("<a class=\"layui-btn layui-btn-mini \"  onclick='Info("+film.filmId+")'><i class=\"iconfont icon-edit\"></i> 编辑</a>");
							var $a2=$("<a class=\"layui-btn layui-btn-normal layui-btn-mini news_collect\"><i class=\"layui-icon\">&#xe600;</i> 下架</a>");
							$a1.appendTo($td);
							$a2.appendTo($td);
						}
						$td.appendTo($tr);
					}
				}
				form.render();
			}})
	})

	//查询
	$(".search_btn").click(function(){
		var newArray = [];
		if($(".search_input").val() != ''){
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
            	$.ajax({
					url : "../../json/newsList.json",
					type : "get",
					dataType : "json",
					success : function(data){
						if(window.sessionStorage.getItem("addNews")){
							var addNews = window.sessionStorage.getItem("addNews");
							newsData = JSON.parse(addNews).concat(data);
						}else{
							newsData = data;
						}
						for(var i=0;i<newsData.length;i++){
							var newsStr = newsData[i];
							var selectStr = $(".search_input").val();
		            		function changeStr(data){
		            			var dataStr = '';
		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
		            			if(showNum > 1){
									for (var j=0;j<showNum;j++) {
		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
		            				}
		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
		            				return dataStr;
		            			}else{
		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
		            				return dataStr;
		            			}
		            		}
		            		//文章标题
		            		if(newsStr.newsName.indexOf(selectStr) > -1){
			            		newsStr["newsName"] = changeStr(newsStr.newsName);
		            		}
		            		//发布人
		            		if(newsStr.newsAuthor.indexOf(selectStr) > -1){
			            		newsStr["newsAuthor"] = changeStr(newsStr.newsAuthor);
		            		}
		            		//审核状态
		            		if(newsStr.newsStatus.indexOf(selectStr) > -1){
			            		newsStr["newsStatus"] = changeStr(newsStr.newsStatus);
		            		}
		            		//浏览权限
		            		if(newsStr.newsLook.indexOf(selectStr) > -1){
			            		newsStr["newsLook"] = changeStr(newsStr.newsLook);
		            		}
		            		//发布时间
		            		if(newsStr.newsTime.indexOf(selectStr) > -1){
			            		newsStr["newsTime"] = changeStr(newsStr.newsTime);
		            		}
		            		if(newsStr.newsName.indexOf(selectStr)>-1 || newsStr.newsAuthor.indexOf(selectStr)>-1 || newsStr.newsStatus.indexOf(selectStr)>-1 || newsStr.newsLook.indexOf(selectStr)>-1 || newsStr.newsTime.indexOf(selectStr)>-1){
		            			newArray.push(newsStr);
		            		}
		            	}
		            	newsData = newArray;
		            	newsList(newsData);
					}
				})
            	
                layer.close(index);
            },2000);
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})
})


//资料
function Info(id){
	$.ajax({
		url:'/film/one',
		type:'post',
		data:{
			"id":id
		},success:function (info) {
			var str="<p>姓名:"+info.userInfoName+"</p>";
			str+="<p>性别:"+info.userInfoSex+"</p>";
			str+="<p>学校:"+info.userInfoSchool+"</p>";
			str+="<p>学校所在省:"+info.userInfoSchoolProvince+"</p>";
			str+="<p>学校所在市:"+info.userInfoSchoolCity+"</p>";
			str+="<p>专业:"+info.userInfoMajor+"</p>";
			str+="<p>毕业期限:"+info.userInfoGraduationDate+"</p>";
			str+="<p>社区昵称:"+info.userInfoNickName+"</p>";
			str+="<p>邮箱:"+info.userInfoEmail+"</p>";
			str+="<p>微信号:"+info.userInfoWechat+"</p>";
			str+="<p>账户余额:"+info.userInfoBlance+"</p>";
			str+="<p>优惠券:"+info.userInfoCoupon+"</p>";
			str+="<p>支付宝账号:"+info.userInfoAlipayId+"</p>";
			str+="<p>微信支付账号:"+info.userInfoVxpayId+"</p>";
			layer.alert(str,{icon:6, title:'友链编辑'});
		}
	})
}
