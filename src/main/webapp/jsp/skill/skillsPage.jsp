<%@ page import="domain.Skill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.01.2019
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список навыков</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-padding w3-blue w3 center">
    <a href="/" class="w3-button w3-margin w3-yellow w3-left w3-large">Главная</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Навыки</h1>
</div>

<br/>

<div class="w3-container w3-padding w3-large">
    <ol class="w3-ul">
    <%
        List<Skill> skills = (List<Skill>) request.getAttribute("skills");
        if (skills.isEmpty()){
            out.print("<div class=\"w3-container w3-center w3-red w3-margin-bottom\">");
            out.println("<h2> Навыков нет </h2>");
            out.println("</div>");
        }
        else {
            for (Skill skill : skills) {
                out.print("<li class=\"w3-yellow\">" + skill.getId() + ".  " + skill.getSkill() +
                        " " + skill.getSkillLevel() +
                        " <a class=\"w3-button w3-green\" href=\"/skill_info?id=" + skill.getId() + "\">Инфо</a>" +
                        " <a class=\"w3-button w3-green\" href=\"/skill_edit?id=" + skill.getId() + "\">Редактировать</a>" +
                        " <a class=\"w3-button w3-green\" href=\"/skill_delete?id=" + skill.getId() + "\">Удалить</a>");
                out.println("</li>");
            }
        }
    %>
    </ol>
</div>

<br/>

<a href="/skill_add" class="w3-margin-top w3-button w3-green w3-right">Добавить навык</a>
</body>
</html>
