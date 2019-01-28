<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.01.2019
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="domain.Company" %>
<%@ page import="domain.Developer" %>
<%@ page import="domain.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование компании</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%Company company = (Company) request.getAttribute("company");%>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/companies" class="w3-button w3-margin w3-large w3-yellow w3-left">Компании</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Редактирование компании - <%=company.getName()%></h1>
</div>

<div class="w3-container">
    <form method="post" action="/company_edit">
        <input type="hidden" name="companyId" value="<%=company.getId()%>">

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Название компании</h3>
            <input class="w3-input" name="companyName" value="<%=company.getName()%>"/>
        </div>

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Город: </h3>
            <input class="w3-input" name="companyCity" value="<%=company.getCity()%>"/>
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID проектов (через пробел): </h3>
            <%String idProjects = "";
            for (Project project : company.getProjects()){
                idProjects+= project.getId() + " ";
            }
            %>
            <input type="hidden" name="companyProjectsToDelete" value="<%=idProjects%>">
            <input class="w3-input" name="companyProjects" value="<%=idProjects%>">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID разработчиков (через пробел): </h3>
            <%String idDevelopers = "";
                for (Developer developer : company.getDevelopers()){
                    idDevelopers+= developer.getId() + " ";
                }
            %>
            <input type="hidden" name="companyDevelopersToDelete" value="<%=idDevelopers%>">
            <input class="w3-input" name="companyDevelopers" value="<%=idDevelopers%>">
        </div>

        <div class="w3-container">
            <input type="submit" class="w3-button w3-green w3-right w3-large" value="Подтвердить"/>
        </div>

    </form>
</div>
</body>
</html>

