<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/4/20
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/question" method="post" modelAttribute="question">
    <br/>
    <h1>增加一个题目：</h1>
    题目：
    <form:input path="text"/>
    <br/>
    A选项：
    <form:input path="ans1"/>
    <br/>
    B选项：
    <form:input path="ans2"/>
    <br/>
    C选项：
    <form:input path="ans3"/>
    <br/>
    D选项：
    <form:input path="ans4"/>
    <br/>
    正确答案：
    <form:input path="right_ans"/>
    <br/>
    唯一标识符：
    <form:input path="sign"/>
    <br/>
    题型号（1为单选题，2为多选题）：
    <form:input path="style"/>
    <input type="submit" value="确认" />
</form:form>
</body>
</html>
