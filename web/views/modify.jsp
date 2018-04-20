<%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/4/20
  Time: 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/question" method="post" modelAttribute="question">
    <br/>
    <h1>修改的题目编号为${requestScope.question.id}</h1>
    <form:hidden path="id"/>
    <input type="hidden" name="_method" value="PUT"/>
    <br/>
    内容：<form:input path="text"/>
    <br/>
    A：<form:input path="ans1"/>
    <br/>
    B：<form:input path="ans2"/>
    <br/>
    C：<form:input path="ans3"/>
    <br/>
    D：<form:input path="ans4"/>
    <br/>
    正确答案：<form:input path="right_ans"/>
    <br/>
    题型：<form:input path="style"/>
    <br/>
    <input type="submit" value="确认" />
</form:form>
</body>
</html>
