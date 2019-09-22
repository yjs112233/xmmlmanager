layui.config({
    base : "js/"
}).use(['form','layer','jquery'],function(){
    var form = layui.form(),
        $ = layui.jquery;
$(function () {
    $.ajax({url:'/authentication/needCheck',type:'get',success:function (list) {
            var $container=$(".news_content");
            for (var i = 0; i < list.length; i++) {
                var user=list[i];
                var $tr=$("<tr></tr>");
                $container.prepend($tr);
                for (var j = 0; j <8 ; j++) {
                    var $td=$("<td></td>");
                    if (j==0){
                        var check=$("<input type=\"checkbox\" name=\"checked\" lay-skin=\"primary\" lay-filter=\"choose\">");
                        check.appendTo($td);
                    };
                    if (j==1)$td.html(user.userLoginPhone);
                    if (j==2) $td.html(user.userInfoName);
                    if (j==3) {
                            $td.html("待审核");
                            $td.css("color","red");
                    }
                    if (j==4)$td.html(user.userLastLogin);
                    if (j==5)$td.html(user.userLoginCount);
                    if (j==6)$td.html(user.userCreateTime);
                    if (j==7){
                        var $a1=$("<a  onclick='auth("+user.userLoginId+")' class=\"layui-btn layui-btn-mini authdetail\"><i class=\"iconfont icon-edit\"></i> 审核</a>");
                        $a1.appendTo($td);
                    }
                    $td.appendTo($tr);
                }
            }
            form.render();
        }})
    })
})

//审核用户
//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
layui.use("layer",function () {
    $(".authdetail").click(function(){

        var index = layui.layer.open({
            title : "审核用户详情",
            type : 2,
            shade: [0.8, '#393D49'],
            area: ['1000px', '400px'],
            content : "authdetail.html",
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        // layui.layer.full(index);
    })
})

function auth(id) {
    var index = layui.layer.open({
        title : "审核用户详情",
        type : 2,
        content : "authdetail.html?id="+id,
        success : function(layero, index){
            setTimeout(function(){
                layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
                    tips: 3
                });
            },500)
        }
    })
    layui.layer.full(index);

}