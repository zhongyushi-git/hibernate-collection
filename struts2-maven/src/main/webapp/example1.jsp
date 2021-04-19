<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>数据标签</title>
</head>
<body>
<div>
    <p>property标签</p>
    直接输出字符串：<s:property value="'今天的天气还不错'"/><br/>
    使用默认值：<s:property value="" default="value是null时我会显示"/><br/>
    忽略HTML代码：<s:property value="'<H3>你今天聊天了吗？</H3>'" escape="true"/><br/>
    不忽略HTML代码：<s:property value="'<H3>你今天聊天了吗？</H3>'" escape="false"/><br/>
</div>
<hr>
<div>
    <p>a标签</p>
    <s:a href="www.baidu.com">点我去百度</s:a>
</div>
<hr>
<div>
    <p>debug标签</p>
    <s:debug/>
</div>
<hr>
<div>
    <p>include标签</p>
    <s:include value="myTest.jsp">
        <s:param name="username" value="'钟小嘿'"></s:param>
        <s:param name="date">2021年4月10号</s:param>
    </s:include>
</div>
<hr>
<div>
    <p>iterator标签</p>
    <s:iterator var="item" value="{'java','C#','paython','php'}" status="st">
        <li><s:property value="#st.index+':'"/><s:property value="item"/></li>
    </s:iterator>
</div>
<hr>
<div>

    <p>form标签</p>
    <s:form action="login" method="post">
        <s:textfield label="用户名" name="username"/>
        <s:password label="密码" name="password" maxlength="20"/>
        <s:radio name="" label="性别" list="#{0:'男',1:'女'}" listKey="key" listValue="value" value="0"/>
        <s:select label="所在城市" name="city"
                  list="#{'BJ':'北京','SH':'上海' }"
                  listKey="key" listValue="value">
            <s:optgroup label="河北"
                        list="#{'BD':'保定','HS':'衡水','SJZ':'石家庄'}"
                        listKey="key" listValue="value"/>
            <s:optgroup label="河南"
                        list="#{'LY':'洛阳','KF':'开封','SQ':'商丘'}"
                        listKey="key" listValue="value"/>
        </s:select>
        <s:checkboxlist label="爱好" name="hobby" list="#{1:'足球',2:'篮球',3:'读书',4:'运动'}" listKey="key" listValue="value"></s:checkboxlist>
        <s:textarea label="备注" name="remark"/>
        <s:file label="照片"></s:file>
        <s:submit value="注册"/>
        <s:reset name="reset" value="重置"/>
    </s:form>

</div>
</body>
</html>
