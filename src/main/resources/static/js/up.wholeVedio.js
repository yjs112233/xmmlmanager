$(function() {
    var delParent;
    var defaults = {
        fileType: ["flv","mp4","mov","MP4","MOV","FLV"],
        // 上传图片支持的格式
        fileSize: 1024 * 1024 * 200 // 上传的图片大小不得超过 200M
    };
    /*点击图片*/
    $("#whole").change(function() {
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
        if (fileList.length > 1 || totalNum > 1) {
            alert("你好！上传视频不得超过1个");
            //一次选择上传超过1个  自己定义
        } else if (numUp < 1) {
            fileList = validateUp(fileList);
            for (var i = 0; i < fileList.length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]);
                imgArr.push(imgUrl);
                var $section = $("<div class='aui-up-section fl loading whole'>");
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
                var $img = $("<video class='aui-to-up-img aui-up-clarity' controls='controls'>");
                $img.attr("src", imgArr[i]);
                $img.appendTo($section);
                var $p = $("<p class='img-aui-img-name-p'>");
                $p.html(fileList[i].name).appendTo($section);
                // var $input = $("<input id='actionId' name='actionId' value='' type='hidden'>");
                // $input.appendTo($section);
                // var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
                // $input2.appendTo($section);

            }
        }
        setTimeout(function() {
            $(".aui-up-section").removeClass("loading");
            $(".aui-to-up-img").removeClass("aui-up-clarity");
        }, 2100);
        numUp = imgContainer.find(".aui-up-section").length;
        if (numUp >= 1) {
            $(this).parent().hide();
        }
    });

    $(".aui-photo").delegate(".aui-close-up-img", "click", function() {
        $(".aui-works-mask").show();
        delParent = $(this).parent();
    });

    $(".aui-accept-ok").click(function() {
        $(".aui-works-mask").hide();
        var numUp = delParent.siblings().length;
        if (numUp < 3) {
            delParent.parent().find(".aui-file-up").show();
        }
        delParent.remove();

    });

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
                        var show=parseInt(file.size/1000000);
                        alert('您这个"' + file.name + '"文件大小过大:   '+show+"M");
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
