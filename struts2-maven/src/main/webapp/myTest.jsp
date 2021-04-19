<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>我是test页面</title>
</head>
<body>
    <h2>我是test页面</h2>
    <p>传递的参数1是：<%out.print(request.getParameter("username")); %></p>
    <p>传递的参数2是：${param.date }</p>
    <h2>
        <s:if test="param.date==null">222</s:if>
        <s:else>333</s:else>
    </h2>
</body>
</html>
