<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 20.01.2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Developer"%>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Разработчики</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/" class="w3-button w3-margin w3-large w3-yellow w3-left">Главная</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Разработчики</h1>
</div>

</br>

<div class="w3-container w3-padding w3-large">
    <ol class="w3-ul">
        <%
            List<Developer> developers = (List<Developer>) request.getAttribute("developers");
            if (developers.isEmpty()){
                //out.print("<h2> Проектов нет </h2>");
                out.print("<div class=\"w3-container w3-center w3-red w3-margin-bottom\">");
                out.println("<h2> Разработчиков нет </h2>");
                out.println("</div>");
            }
            else {
                for (Developer developer : developers) {
                    out.print("<li class=\"w3-yellow\">" + developer.getId() + ".  " + developer.getName() +
                            " " + developer.getSurname() +
                            " <a class=\"w3-button w3-green\" href=\"/developer_info?id=" + developer.getId() + "\">Инфо</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/developer_edit?id=" + developer.getId() + "\">Редактировать</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/developer_delete?id=" + developer.getId() + "\">Удалить</a>");
                    out.println("</li>");
                }
            }
        %>
    </ol>
</div>

</br>
<a href="/developer_add" class="w3-margin-top w3-button w3-green w3-right">Добавить разработчика</a>
</body>
</html>
