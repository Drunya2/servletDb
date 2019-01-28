<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Добавление разработчика</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>


<div class="w3-container w3-blue w3-center">
    <a href="/developers" class="w3-button w3-margin w3-large w3-yellow w3-left">Разработчики</a>
</div>

<div class="w3-container w3-blue w3-center">
    <h1>Добавление разработчика</h1>
</div>

<br/>

<div class="w3-container w3-blue w3-padding">
    <form method="post" action="/developer_add">
        <input type="hidden" name="developerId" value="<%= request.getAttribute("developerId")%>">

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Имя:</h3>
            <input class="w3-input"  name="developerName" value="">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Фамилия:</h3>
            <input class="w3-input" name="developerSurname" value="">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Пол(male или female):</h3>
            <input class="w3-input" name="developerSex" value="">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>Зарплата:</h3>
            <input class="w3-input" type="number" name="developerSalary" value="">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID проектов (через пробел): </h3>
            <input class="w3-input" name="developerProjects" value="">
        </div>

        <div class="w3-container w3-light-grey w3-margin w3-padding">
            <h3>ID навыков (через пробел): </h3>
            <input class="w3-input" name="developerSkills" value="">
        </div>

        <div class="w3-container">
            <input type="submit" class="w3-button w3-green w3-right w3-large" value="Добавить разработчика"/>
        </div>
    </form>
</div>
</body>
</html>
