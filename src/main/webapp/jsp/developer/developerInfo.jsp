<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 20.01.2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Developer"%>
<%@ page import="java.util.Set" %>
<%@ page import="domain.Skill" %>
<%@ page import="domain.Project" %>
<%@ page import="domain.Company" %>
<html>
<head>
    <title>Информация о разработчике</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Developer developer = (Developer) request.getAttribute("developer");%>

<div class="w3-container w3-blue w3-center">
    <a href="/developers" class="w3-button w3-margin w3-large w3-yellow w3-left">Разработчики</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Разработчик <%=developer.getName()%>  <%=developer.getSurname()%></h1>
</div>

<div class="w3-container w3-center w3-blue">
    <h2>Глобальная информация</h2>
    <p>Имя: <%=developer.getName()%></p>
    <p>Фамилия: <%=developer.getSurname()%></p>
    <%
        String sex = null;
        if (developer.getSex().toString() == "male") sex = "Мужской";
        else sex = "Женский";
    %>
    <p>Пол: <%=sex%></p>
    <p>Зарплата: <%=developer.getSalary()%> $</p>
    <%
        Company company = developer.getCompany();
        if (company == null) out.print("<p>Компания: Отсутствует</p>");
        else{
            out.print("<a href=\"/company_info?id=" + company.getId() +"\">Компания: "  + company.getName() + "</a>");
            out.print("</br>");
        }
    %>
    </div>

<br/>
<br/>

<div class="w3-container w3-center w3-light-blue w3-large">
    <h2>Навыки: </h2>
    <div class="w3-container w3-left w3-light-blue w3-large">
        <%Set<Skill> skills = developer.getSkills();
            if (skills.isEmpty()) out.print("<p> - Навыков нет </p>");
            else{
                for (Skill skill : skills){
                    out.print("<a href=\"/skill_info?id=" + skill.getId() +"\">" + skill.getId() + ". " + skill.getSkill() +
                            " " + skill.getSkillLevel() + "</a>");
                    out.print("</br>");
                }
            }
        %>
    </div>
</div>

<br/>
<br/>

<div class="w3-container w3-center w3-light-blue w3-large">
    <h2>Проекты: </h2>
    <div class="w3-container w3-left w3-light-blue w3-large">
        <%Set<Project> projects = developer.getProjects();
            if (projects.isEmpty()) out.print("<p> - Проектов нет </p>");
            else{
                for (Project project : projects){
                    out.print("<a href=\"/project_info?id=" + project.getId() +"\">" + project.getId() + ". " +
                            project.getProjectName() + "</a>");
                    out.print("</br>");
                }
            }
        %>
    </div>
</div>
</body>
</html>
