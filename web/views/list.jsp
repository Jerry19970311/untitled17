<%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/4/20
  Time: 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function() {
        $(".delete").click(function() {
            var href = $(this).attr("href");
            $("form").attr("action", href).submit();
            return false;
        });
    })
</script>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>
<c:if test="${empty requestScope.questions}">
    没有任何学生信息
</c:if>
<c:if test="${!empty requestScope.questions}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>编号</th>
            <th>题目</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>正确答案</th>
            <th>唯一标识符</th>
            <th>题型号</th>
            <th>入库时间</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.questions}" var="question">
            <tr>
                <td>${question.id}</td>
                <td>${question.text}</td>
                <td>${question.ans1}</td>
                <td>${question.ans2}</td>
                <td>${question.ans3}</td>
                <td>${question.ans4}</td>
                <td>${question.right_ans}</td>
                <td>${question.sign}</td>
                <td>${question.style}</td>
                <td>${question.timestamp}</td>
                <td><a href="question/${question.id}">修改</a></td>
                <td><a class="delete" href="question/${question.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="question"> 新增题目</a>
</body>
</html>
