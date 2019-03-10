<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-1-23
  Time: 下午8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <script src="jquery.js"></script>
    <script>
        $(document).ready(function () {
                $("#userlogin").on('click',function () {
                var userid=$("input[name='userid']").val();
                var password=$("input[name='password']").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/login.action",
                    data:{userid:userid,password:password},
                    type:"POST",
                    success:function (data) {

                       if(data=="success"){
                           alert(data);
                           window.location.href="/allbooks.action";
                       }else {
                           $("#error").text("用户名或密码错误");
                       }
                    },
                    error:function (data) {
                        alert("BBBBBB");
                    }
                });


            });

        });
        function register() {
            window.open("/register.jsp");

        }
    </script>
</head>
<body>


    <input type="text" name="userid"><br>
    <input type="password" name="password"><br>
    <input  type="button" id="userlogin" value="login">
    <input  type="button" id="register" value="register" onclick="register()" ><br>
    <label id="error"></label>


</body>
</html>
