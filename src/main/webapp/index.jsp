<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--
    源码来自：
    https://blog.csdn.net/u011872945/article/details/65447008
    https://download.csdn.net/download/u011872945/9791570
    -->
    <meta charset="utf-8">

    <!--
    jSignature 在网页上手写签名的插件(html5手写签名) 在IE7~IE8这种不支持HTML5的浏览器上，是利用Flash嵌入的方式实现的签名处理;
    在支持的HTML5的浏览器上默认采用canvas标签处理签名，可以生成 PNG格式、SVG格式的签名图片。
    非常适合在IPAD等移动客户端上实现手写签名的，该插件基于JQuery
    -->
    <script type="text/javascript" src="static/js/jquery.js"></script>
    <!--处理版本低于IE9的浏览器，支持IE7、IE8,使用Flash实现-->
    <script type="text/javascript" src="static/js/flashcanvas.js"></script>
    <!--处理支持H5的浏览器,使用canvas,非压缩吧，去掉了其中的签字横线，可以使用jSignature.min.js 看看两者的区别-->
    <script type="text/javascript" src="static/js/jSignature.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#signature").jSignature();
            // $(".jSignature").css({ "width": "100%", "height": "100%" });

            $('#showSign').click(showSign);
            $('#resetSign').click(resetSign);
            $('#outputSign').click(outputSign);
        });

        function showSign() {
            var $sigdiv = $("#signature");
            var datapair = $sigdiv.jSignature("getData", "image"); //设置输出的格式，具体可以参考官方文档

            var i = new Image();
            i.src = "data:" + datapair[0] + "," + datapair[1]
            $(i).appendTo($("#image")) // append the image (SVG) to DOM.
        }

        function resetSign() {
            var $sigdiv = $("#signature");
            $sigdiv.jSignature("reset");
        }

        function outputSign() {
            var $sigdiv = $("#signature");
            var datapair = $sigdiv.jSignature("getData", "image"); //设置输出的格式，具体可以参考官方文档

            var imagebase64 = datapair[1].replace(/\+/g, '%2B');

            $.ajax({
                type: "POST",
                url: "Default.aspx",
                data: "image=" + imagebase64,
                success: function (msg) {
                    var createImage = new Image();
                    createImage.src = msg;
                    $(createImage).appendTo($("#img_src"))
                }
            });
        }
    </script>
</head>
<body>
<fieldset style="border: 2px solid green; width: 100%; height: 352px;">
    <legend>签名区域</legend>
    <div id="signature" style="height: 100%;">
    </div>
</fieldset>
<button id="showSign" type="button">
    输出签名
</button>
<button id="resetSign" type="button">
    重置
</button>
<button id="outputSign" type="button">
    生成Image图片
</button>
<div id="image" style="margin: 20px">
</div>
<div id="img_src">
</div>
</body>
</html>
