layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form()
        ,layer = layui.layer
        ,table = layui.table
        , $ = layui.jquery;
    //加载数据
    $(function () {
        var url=location.href;
        var index=url.lastIndexOf("=");
        var id=url.substring(index+1);
        if (id==null||id==0||id==""){
            return;
        }
        $.ajax({
            url:'/userInfo/one',
            type:'post',
            data:{
                "loginId":id
            },success:function (userInfo) {
                $("#name").html(userInfo.userInfoName);
                $("#sex").html(userInfo.userInfoSex);
                $("#school").html(userInfo.userInfoSchool);
                $("#province").html(userInfo.userInfoSchoolProvince);
                $("#city").html(userInfo.userInfoSchoolCity);
                $("#major").html(userInfo.userInfoMajor);
                $("#graduation").html(userInfo.userInfoGraduationDate);
                var url="/student/"+userInfo.userInfoRegisterImg;
                $("#img").attr("src",url);
                $("#img").attr("layer-src",url);
                $("#img").css("width","20%");
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
        if (data.field.check=="拒绝通过"){
            if (data.field.content==""){
                alert("请输入系统回复")
                return ;
            }
        }
        return false;
    });

});


function bigImg(){
    alert(1);
    //自定页
    layer.open({
        type: 1,
        skin: 'layui-layer-demo', //样式类名
        closeBtn: 0, //不显示关闭按钮
        anim: 2,
        shadeClose: true, //开启遮罩关闭
        content: ''
    });
}