<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 22.01.2019
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Project"%>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Проекты</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/" class="w3-button w3-margin w3-large w3-yellow w3-left">Главная</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Проекты</h1>
</div>

</br>

<div class="w3-container w3-padding w3-large">
    <ol class="w3-ul">
        <%
            List<Project> projects = (List<Project>) request.getAttribute("projects");
            if (projects.isEmpty()){
                out.print("<div class=\"w3-container w3-center w3-red w3-margin-bottom\">");
                out.println("<h2> Проектов нет </h2>");
                out.println("</div>");
            }
            else{
                for(Project project: projects) {
                    out.print("<li class=\"w3-yellow\">" + project.getId() + ".  " + project.getProjectName() +
                            " <a class=\"w3-button w3-green\" href=\"/project_info?id=" + project.getId() + "\">Инфо</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/project_edit?id=" + project.getId() + "\">Редактировать</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/project_delete?id=" + project.getId() + "\">Удалить</a>" );
                    out.println("</li>");
                }
            }
        %>
    </ol>
</div>

</br>
<a href="/project_add" class="w3-margin-top w3-button w3-green w3-right">Добавить проект</a>
</body>
</html>

