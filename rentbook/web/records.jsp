<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-1-25
  Time: 下午2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shoppingcar</title>
    <style>
        .bar{
            position:fixed;/*固定地位	不受滚动条的控制*/
            right: 0px;
            top: 0px;
        }

    </style>
</head>
<body>

<div class="bar">
    <a href="allbooks.action">首页</a>&nbsp;欢迎,${current.username}<a href="/remove">注销</a><br>


</div>

正借书本:<br>
<c:forEach items="${noReturn}" var="packingRecord">
    <div>
        图书名称：${packingRecord.bookname}<br>
        借阅日期<br>
        <a href="/returnbook.action?recordid=${packingRecord.record.id}&bookid=${packingRecord.record.bookid}">归还</a>&nbsp;&nbsp;&nbsp;<a href="">延期</a>
    </div>
</c:forEach>



<hr />历史记录：<br>
<c:forEach items="${isReturn}" var="packingRecord">
    <div class="history">
        图书名称：${packingRecord.bookname}<br>
        借阅日期<br>
        归还日期<br>
        <a href="delete.action?id=${packingRecord.record.id}">删除记录</a>
        <a href="evaluate.jsp?bookid=${packingRecord.record.bookid}">评价</a>
    </div>
</c:forEach>

</body>
</html>
