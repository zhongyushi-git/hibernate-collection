<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>ognl</title>
</head>
<body>
    <p>session.msg:<s:property value="#session.msg"></s:property></p>
    <p>application.msg:<s:property value="#application.msg"></s:property></p>
    <p>request.msg:<s:property value="#request.msg"></s:property></p>
    <p>attr.msg:<s:property value="#attr.msg"></s:property></p>
    <hr />
    <h3>%符号的用法</h3>
    <h4>构造Map</h4>
    <s:set name="key" value="#{'key1':'value1','key2':'value2'}" />
    <p>key1的值是 <s:property value="#key['key1']" /></p>
    <p>不使用%：<s:url value="#key['key1']" /></p>
    <p>使用%：<s:url value="%{#key['key1']}" /></p>
    <hr />
    获取的静态属性值为：<s:property value="@com.zxh.ssh.action.TestMain@staticValue"/><br/>
    调用静态方法的结果请查看控制台<s:property value="@com.zxh.ssh.action.TestMain@testMethod()"/>
</body>
</html>
