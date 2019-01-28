<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 24.01.2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="domain.Customer" %>
<%@ page import="domain.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование заказчика</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Customer customer = (Customer) request.getAttribute("customer");%>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/customers" class="w3-button w3-margin w3-large w3-yellow w3-left">Заказчики</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Редактирование заказчика - <%=customer.getName()%></h1>
</div>

<div class="w3-container">
    <form method="post" action="/customer_edit">
        <input type="hidden" name="customerId" value="<%=customer.getId()%>">

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Имя заказчика</h3>
            <input class="w3-input" name="customerName" value="<%=customer.getName()%>"/>
        </div>

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Страна: </h3>
            <input class="w3-input" name="customerCountry" value="<%=customer.getCountry()%>"/>
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID проектов (через пробел): </h3>
            <%String projectsId = "";
            for (Project project : customer.getProjects()){
                projectsId += project.getId() + " ";
            }
            %>
            <input type="hidden" name="customerProjectsToDelete" value="<%=projectsId%>">
            <input class="w3-input" name="customerProjects" value="<%=projectsId%>">
        </div>

        <div class="w3-container">
            <input type="submit" class="w3-button w3-green w3-right w3-large" value="Подтвердить"/>
        </div>

    </form>
</div>
</body>
</html>

