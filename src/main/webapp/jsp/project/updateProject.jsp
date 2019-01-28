<%@ page import="domain.Project" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 22.01.2019
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование проекта</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Project project = (Project) request.getAttribute("project");%>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/projects" class="w3-button w3-margin w3-large w3-yellow w3-left">Проекты</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Редактирование проекта - <%=project.getProjectName()%></h1>
</div>

<div class="w3-container">
    <form method="post" action="/project_edit">
        <input type="hidden" name="projectId" value="<%=project.getId()%>">

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Название проекта</h3>
            <input class="w3-input" name="projectName" value="<%=project.getProjectName()%>"/>
        </div>

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Описание: </h3>
            <input class="w3-input" name="projectDescription" value="<%=project.getDescription()%>"/>
        </div>

        <div class="w3-container">
            <input type="submit" class="w3-button w3-green w3-right w3-large" value="Подтвердить"/>
        </div>

    </form>
</div>
</body>
</html>
