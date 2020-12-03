<%@ page import="ru.unclediga.spec.model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            transition: 0.3s;
            width: 40%;
            border-radius: 5px;
        }

        .card:hover {
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
        }

        img {
            border-radius: 5px 5px 0 0;
        }

        .container {
            padding: 2px 16px;
        }
    </style>
</head>
<body>
<%
    Customer customer = (Customer) request.getAttribute("CUSTOMER");
%>
<h2>Customer Info</h2>
<div class="card">
    <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" style="width:20%">
    <div class="container">
        <h4>Name: <%= customer.getName()%>
        </h4>
        <h4>Phone: <%= customer.getPhone()%>
        </h4>
    </div>
</div>
<div class="container">
    <h4>URL: <%= request.getAttribute("URL")%>
    </h4>
    <h4>Rate: ${requestScope.RATE}
    </h4>
    <h5>Properties</h5>
    <c:forEach var="map" items="${requestScope.PARAMS}">
        <h5>${map.key} => ${map.value}</h5>
    </c:forEach>
</div>
</body>
</html>
