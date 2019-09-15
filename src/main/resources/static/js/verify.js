
function testImgType(c) {
    var clazz="."+c;
    $(clazz).remove();
    var p="#"+c;
    $(p).parent().show();
}

function  addTip() {
    var tip= $("#tip").val();
    if (tip==""){
        alert("请输入标签")
        return ;
    }
    var value=$("#tips").val()+tip+",";
    $("#tips").val(value);
}
function clearTip() {
    setTimeout(function () {
        $("#tips").val("");
    },1000)
}
//售卖价格
$(function () {
    $("#RMB").change(function () {
        var value=this.value;
        var reg=/^\+?[1-9][0-9]*$/g;
        if (!reg.test(value)){
            alert("请输入正整数");
            return ;
        }
        var v=value+".00";
        $("#RMB").val(v);
    })
})
//初始名称
$(function () {
    $("#name").change(function () {
        var value=this.value.trim();
        if (value==""){
            layer.msg("请输入名称");
        }else{
            this.value="《"+value+"》";
        }
    })
})
function verify() {
    var provider=$("#provider").val();
    var name=$("#name").val();
    var tips=$("#tips").val();
    var createTime=$("#createTime").val();
    var content=$("#content").val();
    var price=$("#RMB").val();
    var length=$("#length").val();
    var mainImg=document.getElementById("mainImg").files;
    var detailsImg=document.getElementById("detailsImg").files;
    //初始名称
    if (name==""){
        layer.msg("初始名称不能为空")
        return ;
    }
    if (provider==""){
        layer.msg("提供者不能为空")
        return ;
    }
    if (tips==""){
        layer.msg("请添加相应标签")
        return;
    }
    if (length==""){
        layer.msg("请填写作品时长")
        return;
    }
    if (createTime==""){
        layer.msg("请添加时间")
        return;
    }
    if (content.length<50){
        layer.msg("内容简介不得低于50字")
        return;
    }
    if (price==""){
        layer.msg("价格不能为空");
        return;
    }
    if (price.length>7){
        layer.msg("价格不能过万");
        return;
    }
    if (mainImg.length==0){
        layer.msg("请添加作品主图");
        return;
    } 
    if (detailsImg.length!=6){
        layer.msg("请一次性选择6张详图进行添加");
        return;
    }

}


function upload() {
    //数据校验
    verify();
    //上传
    var provider=$("#provider").val();
    var name=$("#name").val();
    var season=$("#season option:checked").val();
    var tips=$("#tips").val();
    var createTime=$("#createTime").val();
    var content=$("#content").val();
    var price=$("#RMB").val();
    var length=$("#length").val();
    var mainImg=document.getElementById("mainImg").files;
    var detailsImg=document.getElementById("detailsImg").files;
    var oneVideo=document.getElementById("1min").files;
    var wholeVideo=document.getElementById("whole").files;
    var formData=new FormData();
    formData.append("filmProvider",provider);
    formData.append("filmName",name);
    formData.append("filmSeason",season);
    formData.append("filmLength",length);
    formData.append("filmLables",tips);
    formData.append("filmCreateTime",createTime);
    formData.append("filmContent",content);
    formData.append("filmPrice",price);
    formData.append("mainImg",mainImg[0]);
    formData.append("oneVideo",oneVideo[0]);
    formData.append("wholeVideo",wholeVideo[0]);
    for (var i = 0; i < detailsImg.length; i++) {
        var name="details"+i;
        formData.append(name,detailsImg[i]);
    }
    var index;
    $.ajax({
        url:'/film/upload',
        type:'post',
        cache: false,
        processData: false,
        contentType: false,
        data:formData
        ,before:function () {
          index =layer.load("上传中");
        }
        ,success:function (json) {
            layer.close(index);
            layer.msg(json);
            if (json=="上传成功"){
                setTimeout(function () {
                    location.reload();
                },1500)
            }
        }
        ,error:function () {
            layer.close(index);
            layer.msg("上传异常,请联系管理员");
        }
    })
}