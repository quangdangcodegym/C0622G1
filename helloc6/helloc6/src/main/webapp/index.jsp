<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
        <c:forEach items="${requestScope.list}" var="item">
            <h1>${item}</h1>
        </c:forEach>

        <c:choose>
            <c:when test="${requestScope.counter >10}">
                <h1>Counter hien tai: ${requestScope.counter}</h1>
            </c:when>
            <c:otherwise>
                <h1>ERROR</h1>
            </c:otherwise>
        </c:choose>
</body>
</html>