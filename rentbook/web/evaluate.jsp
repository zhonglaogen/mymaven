<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-2-22
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="jquery.js"></script>
    <script>
        // 获取url参数
        function GetQueryString(name)
        {
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
            if(r!=null)return  unescape(r[2]); return null;
        }

        $(document).ready(function () {
            $("#userevaluate").on('click',function () {
                var evaluate=$("textarea[name='evaluate']").val();
                var bookid=GetQueryString("bookid");
                $.ajax({
                    url: "${pageContext.request.contextPath}/userevaluate.action",
                    data:{evaluate:evaluate,bookid:bookid},
                    type:"POST"
                });


            });

        });

    </script>
</head>
<body>
<textarea name="evaluate" style="margin: 0px; width: 495px; height: 124px;"></textarea>
<button value="评价" id="userevaluate"></button>

</body>
</html>
