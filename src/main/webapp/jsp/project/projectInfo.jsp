<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 22.01.2019
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set" %>
<%@ page import="domain.*" %>
<html>
<head>
    <title>Информация о проекте</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Project project = (Project) request.getAttribute("project");%>

<div class="w3-container w3-blue w3-center">
    <a href="/projects" class="w3-button w3-margin w3-large w3-yellow w3-left">Проекты</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Проект - <%=project.getProjectName()%></h1>
</div>

<div class="w3-container w3-center w3-blue">
    <h2>Глобальная информация</h2>
    <p>Название проекта: <%=project.getProjectName()%></p>
    <p>Описание: <%=project.getDescription()%></p>
    <%
        Company company = project.getCompany();
        if (company == null) out.print("<p>Компания: Отсутствует</p>");
        else{
            out.print("<a href=\"/company_info?id=" + company.getId() +"\">Компания: "  + company.getName() + "</a>");
            out.print("</br>");
        }
    %>

    <%
        Customer customer = project.getCustomer();
        if (customer == null) out.print("<p>Заказчик: Отсутствует</p>");
        else{
            out.print("<a href=\"/customer_info?id=" + customer.getId() +"\">Заказчик: "  + customer.getName() + "</a>");
            out.print("</br>");
        }
    %>
</div>

<br/>
<br/>

<div class="w3-container w3-center w3-light-blue w3-large">
    <h2>Разработчики: </h2>
    <div class="w3-container w3-left w3-light-blue w3-large">
        <%Set<Developer> developers = project.getDevelopers();
            if (developers.isEmpty()) out.print("<p> Разработчиков нет </p>");
            else{
                for (Developer developer : developers){
                    out.print("<a href=\"/developer_info?id=" + developer.getId() +"\">" + "• " +
                            developer.getName() + " " + developer.getSurname() + "</a>");
                    out.print("</br>");
                }
            }
        %>
    </div>
</div>

</body>
</html>

