$(function() {
    var delParent;
    var defaults = {
        fileType: ["jpg", "png", "bmp", "jpeg"],
        // 上传图片支持的格式
        fileSize: 1024 * 200 // 上传的图片大小不得超过 200kb
    };
    /*点击图片*/
    $("#detailsImg").change(function() {
        var idFile = $(this).attr("id");
        var file = document.getElementById(idFile);
        var imgContainer = $(this).parents(".aui-photo");
        //存放图片的父元素
        var fileList = file.files;
        //获取的图片文件
        console.log(fileList + "======filelist=====");
        var input = $(this).parent();
        //文本框的父亲元素
        var imgArr = [];
        //遍历得到的图片
        var numUp = imgContainer.find(".aui-up-section").length;
        var totalNum = numUp + fileList.length;
        //图片总的数量可自定义
        if (fileList.length > 6 || totalNum > 6) {
            alert("你好！详情图片不得超过6张");
            //一次选择上传超过3个  自己定义
        } else if (numUp < 6) {
            fileList = validateUp(fileList);
            for (var i = 0; i < fileList.length; i++) {
                //获取截图地址
                var imgUrl = window.URL.createObjectURL(fileList[i]);
                imgArr.push(imgUrl);
                var $section = $("<section class='aui-up-section fl loading detailsImg'>");
                imgContainer.prepend($section);
                var $span = $("<span class='aui-up-span'>");
                $span.appendTo($section);

                // var $img0 = $("<img class='aui-close-up-img'>").on("click", function(event) {
                //     event.preventDefault();
                //     event.stopPropagation();
                //     $(".aui-works-mask").show();
                //     delParent = $(this).parent();
                // });
                // $img0.attr("src", "img/close.png").appendTo($section);
                var $img = $("<img class='aui-to-up-img aui-up-clarity'  style='height: auto;padding: 20px 0;margin-top: 10px;' >");
                //加载图片img src=imgArr[i]
                $img.attr("src", imgArr[i]);
                $img.appendTo($section);
                var $p = $("<p class='img-aui-img-name-p'>");
                $p.html(fileList[i].name).appendTo($section);
            }
        }
        //加载图标
        setTimeout(function() {
            $(".aui-up-section").removeClass("loading");
            $(".aui-to-up-img").removeClass("aui-up-clarity");
        }, 500);
        //隐藏上传按钮
        numUp = imgContainer.find(".aui-up-section").length;
        if (numUp >= 6) {
            $(this).parent().hide();
        }
    });

    $(".aui-photo").delegate(".aui-close-up-img", "click", function() {
        $(".aui-works-mask").show();
        delParent = $(this).parent();
    });

    // $(".aui-accept-ok").click(function() {
    //     $(".aui-works-mask").hide();
    //     var numUp = delParent.siblings().length;
    //     if (numUp < 3) {
    //         delParent.parent().find(".aui-file-up").show();
    //     }
    //     delParent.remove();
    //
    // });

    $(".aui-accept-no").click(function() {
        $(".aui-works-mask").hide();
    });

    function validateUp(files) {
        var arrFiles = [];
        //替换的文件数组
        for (var i = 0, file; file = files[i]; i++) {
            //获取图片上传的后缀名
            var newStr = file.name.split("").reverse().join("");
            if (newStr.split(".")[0] != null) {
                var type = newStr.split(".")[0].split("").reverse().join("");
                console.log(type + "===type===");
                if (jQuery.inArray(type, defaults.fileType) > -1) {
                    // 符合图片格式，可以上传
                    if (file.size >= defaults.fileSize) {
                        var show=parseInt(file.size/1000);
                        alert('您这个"' + file.name + '"文件大小过大:   '+show+"KB");
                    } else {
                        arrFiles.push(file);
                    }
                } else {
                    alert('您这个"' + file.name + '"上传类型不符合');
                }
            } else {
                alert('您这个"' + file.name + '"没有类型, 无法识别');
            }
        }
        return arrFiles;
    }

})

