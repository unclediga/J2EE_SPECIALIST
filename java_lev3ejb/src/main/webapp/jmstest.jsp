<%@ page import="java.util.List" %>
<%@ page import="ru.unclediga.spec.model.TestMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>JMS Messages</title>
</head>
<body>
<form method="post" action="jmstest">
    Text:
    <input type="text" name="message" placeholder="Message text"/>
    <button type="submit">Send</button>
</form>
<hr/>
<h4>Messages (${requestScope.MESSAGES.size()}) </h4>
<ul>
    <c:forEach var="msg" items="${requestScope.MESSAGES}">
        <li>${msg}</li>
    </c:forEach>
</ul>
</body>
</html>
