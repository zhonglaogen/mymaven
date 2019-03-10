<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-1-25
  Time: 上午10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bar{
            position:fixed;/*固定地位	不受滚动条的控制*/
            right: 0px;
            top: 0px;
        }

    </style>
</head>
<body>

<div>
    书名：${currentbook.bookname}<br>
    书号：${currentbook.bookid}<br>
    简介：${currentbook.information}<br>
    <a href="/rent.action?bookid=${currentbook.bookid}">确认租借</a>
    <a href="javascript:void(0)">查看评价</a>
    <div id="evaluates">

    </div>
</div>
<div class="bar">
    <a href="allbooks.action">首页</a>&nbsp;
    欢迎,${current.username}<a href="/remove">注销</a>&nbsp;
    <a href="/userrecords.action">租借记录</a><br>
</div>

</body>
</html>
