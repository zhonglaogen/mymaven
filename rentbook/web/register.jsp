<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-1-23
  Time: 下午9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="jquery.js"></script>
    <script>
        $(document).ready(function () {
            $("#register").on('click',function () {
                alert("click");
                var userid=$("input[name='userid']").val();
                var username=$("input[name='username']").val();
                var password=$("input[name='password']").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/regist.action",
                    data:{userid:userid,username:username,password:password},
                    type:"POST",
                    success:function (data) {
                        if(data=="success"){
                            alert("注册成功");

                        }else alert("失败");

                    },
                    error:function (data) {
                        alert("BBBBBB");
                    }
                });


            });

        });
    </script>
</head>
<body>

<input type="text" name="userid">用户id<br>
<input type="text" name="username">用户昵称<br>
<input type="password" name="password">用户密码
<input type="button" value="register" id="register">

</body>
</html>
