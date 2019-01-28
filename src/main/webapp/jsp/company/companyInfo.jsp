<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.01.2019
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set" %>
<%@ page import="domain.*" %>
<html>
<head>
    <title>Информация о компании</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Company company = (Company) request.getAttribute("company");%>

<div class="w3-container w3-blue w3-center">
    <a href="/companies" class="w3-button w3-margin w3-large w3-yellow w3-left">Компании</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Компания - <%=company.getName()%></h1>
</div>

<div class="w3-container w3-center w3-blue">
    <h2>Глобальная информация</h2>
    <p>Название компании: <%=company.getName()%></p>
    <p>Город: <%=company.getCity()%></p>
</div>

<br/>
<br/>

<div class="w3-container w3-center w3-purple">
    <h2>Разработчики: </h2>
    <%Set<Developer> developers = company.getDevelopers();
        if (developers.isEmpty()) out.print("<p> Разработчиков нет </p>");
        else{
            for (Developer developer : developers){
                out.print("<a href=\"/developer_info?id=" + developer.getId() +"\">• "  + developer.getName() +
                         " " + developer.getSurname() + "</a>");
                out.print("</br>");
            }
        }
    %>
</div>

<div class="w3-container w3-center w3-purple">
    <h2>Проекты: </h2>
    <%Set<Project> projects = company.getProjects();
        if (projects.isEmpty()) out.print("<p> Проектов нет </p>");
        else{
            for (Project project : projects){
                out.print("<a href=\"/project_info?id=" + project.getId() +"\">• "  + project.getProjectName() + "</a>");
                out.print("</br>");
            }
        }
    %>
</div>
</body>
</html>


