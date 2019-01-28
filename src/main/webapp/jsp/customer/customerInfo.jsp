<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 24.01.2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set" %>
<%@ page import="domain.*" %>
<html>
<head>
    <title>Информация о заказчике</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Customer customer = (Customer) request.getAttribute("customer");%>

<div class="w3-container w3-blue w3-center">
    <a href="/customers" class="w3-button w3-margin w3-large w3-yellow w3-left">Заказчики</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Заказчик - <%=customer.getName()%></h1>
</div>

<div class="w3-container w3-center w3-blue">
    <h2>Глобальная информация</h2>
    <p>Имя заказчика: <%=customer.getName()%></p>
    <p>Страна: <%=customer.getCountry()%></p>
</div>

<br/>
<br/>

<div class="w3-container w3-center w3-purple">
    <h2>Проекты: </h2>
    <%Set<Project> projects = customer.getProjects();
        if (projects.isEmpty()) out.print("<p> Проектов нет </p>");
        else{
            for (Project project : projects){
                out.print("<a href=\"/project_info?id=" + project.getId() +"\">• "  + project.getProjectName() + "</a>");
                out.print("</br>");            }
        }
    %>
</div>
</body>
</html>



