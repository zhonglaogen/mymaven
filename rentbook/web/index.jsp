<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-1-22
  Time: 下午6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>图书商城</title>
    <style>
      .bar{
        position:fixed;/*固定地位	不受滚动条的控制*/
        right: 0px;
        top: 0px;
      }

    </style>
  </head>
  <body>
  <input type="text">关键字搜索图书
<c:forEach items="${books}" var="book">
  <div>
    <a href="/showbook.action?bookid=${book.bookid}" title="查看详情" ><span>${book.bookname}</span></a><br>
    剩余数量:<span>${book.counts}
  </div><br>
</c:forEach>



<div class="bar">
  <a href="allbooks.action">首页</a>&nbsp;
  欢迎,${current.username}<a href="/remove">注销</a>&nbsp;
  <a href="/userrecords.action">租借记录</a><br>
</div>

  </body>
</html>
