<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="domain.Developer" %>
<%@ page import="domain.Project" %>
<%@ page import="domain.Skill" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Добавление разработчика</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Developer developer = (Developer) request.getAttribute("developer");%>

<div class="w3-container w3-blue w3-center">
    <a href="/developers" class="w3-button w3-margin w3-large w3-yellow w3-left">Разработчики</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Редактирование разработчика - <%=developer.getName() + "  " + developer.getSurname()%></h1>
</div>

<br/>

<div class="w3-container w3-blue w3-padding">
    <form method="post" action="/developer_edit">
        <input type="hidden" name="developerId" value="<%=developer.getId()%>">

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Имя:</h3>
            <input class="w3-input"  name="developerName" value="<%=developer.getName()%>">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Фамилия:</h3>
            <input class="w3-input" name="developerSurname" value="<%=developer.getSurname()%>">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Пол(male или female):</h3>
            <input class="w3-input" name="developerSex" value="<%=developer.getSex().toString()%>">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Зарплата:</h3>
            <input class="w3-input" type="number" name="developerSalary" value="<%=developer.getSalary()%>">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID проектов (через пробел): </h3>
            <%String idProjects = "";
            for (Project project : developer.getProjects()){
                idProjects += project.getId() + " ";
            }%>
            <input type="hidden" name="developerProjectsToDelete" value="<%=idProjects%>">
            <input class="w3-input" name="developerProjects" value="<%=idProjects%>">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID навыков (через пробел): </h3>
            <%String idSkills = "";
                for (Skill skill : developer.getSkills()){
                    idSkills += skill.getId() + " ";
                }%>
            <input type="hidden" name="developerSkillsToDelete" value="<%=idSkills%>">
            <input class="w3-input" name="developerSkills" value="<%=idSkills%>">
        </div>

        <div class="w3-container">
            <input type="submit" href="/client_edit" class="w3-button w3-green w3-right w3-large" value="Подтвердить"/>

        </div>
    </form>
</div>
</body>
</html>
