<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div align="center">
    <form action="login" method="post">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="reset" value="重置"/>
        <input type="submit" value="登录"/></br>
        <span style="color:#F00">${requestScope}</span>
    </form>
</div>
</body>
</html>
