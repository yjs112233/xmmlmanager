layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form();
    //加载数据
    $(function () {
        var url=location.href;
        var index=url.lastIndexOf("=");
        var id=url.substring(index+1);
        if (id==null||id==0||id==""){
            return;
        }
        $.ajax({
            url:'/authentication/one',
            type:'post',
            data:{
                "loginId":id
            },success:function (map) {
                var userInfo=map.info;
                var authList=map.authList;
                $("#name").html(userInfo.userInfoName);
                $("#sex").html(userInfo.userInfoSex);
                $("#school").html(userInfo.userInfoSchool);
                $("#province").html(userInfo.userInfoSchoolProvince);
                $("#city").html(userInfo.userInfoSchoolCity);
                $("#major").html(userInfo.userInfoMajor);
                $("#graduation").html(userInfo.userInfoGraduationDate);
                var url="/student/"+authList[0].authImg;
                $("#img").attr("src",url);
                $("#img").attr("layer-src",url);
                $("#img").css("width","20%");
                $("#bigImg").val(url);
                if (authList.length>1){
                    var tbody=$("#tbody");
                    for (var i = 1; i < authList.length; i++) {
                        var auth=authList[i];
                        var tr=$("<tr>");tr.appendTo(tbody);
                        var td1=$("<td>");td1.appendTo(tr);
                        var td2=$("<td>");td2.appendTo(tr);
                        var td3=$("<td>");td3.appendTo(tr);
                        var td4=$("<td>");td4.appendTo(tr);
                        td1.html("历史审核"+i);
                        td1.css("color","red");
                        td2.html("提交时间:"+auth.authCreateTime);
                        var url="/student/"+auth.authImg;
                        td3.html("<img src='"+url+"' >");
                        td4.html("审核结果<p>"+auth.authResult+"</p>");
                    }
                }
            }
        })
    })

    //监听指定开关
    form.on('radio(check)', function(data){
       if (data.value=="允许通过") {
           $("#content").html("您已通过身份验证，相关通道已为您开放");
           $("#content").css("background-color","wheat");
           $("#content").attr("disabled",true)
       }else {
           $("#content").html("");
           $("#content").css("background-color","white")
           $("#content").attr("disabled",false)
       }
       form.render();
    });

    //监听提交
    form.on('submit(demo1)', function(data){
        //校验
        if (data.field.check=="拒绝通过"){
            if (data.field.content==""){
                alert("请输入系统回复")
                return ;
            }
        }
        //获取用户登录id
        var url=location.href;
        var index=url.lastIndexOf("=");
        var id=url.substring(index+1);
        if (id==null||id==0||id==""){
            return;
        }
        $.ajax({
            url: '/authentication/result',
            type: 'post',
            data: {
                "receiverId": id,
                "messageContent":data.field.content,
                "check":data.field.check
            }, success: function (json) {
                layer.msg(json);
                setTimeout(function () {
                    window.parent.location.reload();//刷新父页面
                    parent.layer.close(index);//关闭弹出层
                },1000)
            }
        })
        return false;
    });

});

function bigImg(url) {
    //查看大图
    layer.open({
        type: 1,
        title: false,
        closeBtn: 0,
        area: ['600px', '360px'],
        skin: 'layui-layer-nobg', //没有背景色
        shadeClose: true,
        content: "<div> <img src='"+url+"' style='width: 100%;'></div>"
    });

}