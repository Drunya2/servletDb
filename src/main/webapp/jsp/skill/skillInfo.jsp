<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.01.2019
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set" %>
<%@ page import="domain.*" %>
<html>
<head>
    <title>Информация о навыке</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Skill skill = (Skill) request.getAttribute("skill");%>

<div class="w3-container w3-blue w3-center">
    <a href="/skills" class="w3-button w3-margin w3-large w3-yellow w3-left">Навыки</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Навык - <%=skill.getSkill() + " " + skill.getSkillLevel()%></h1>
</div>

<div class="w3-container w3-center w3-blue">
    <h2>Глобальная информация</h2>
    <p>Название языка: <%=skill.getSkill()%></p>
    <p>Уровень: <%=skill.getSkillLevel()%></p>
</div>

<br/>
<br/>

<div class="w3-container w3-center w3-light-blue w3-large">
    <h2>Разработчики: </h2>
    <div class="w3-container w3-left w3-light-blue w3-large">
        <%Set<Developer> developers = skill.getDevelopers();
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


