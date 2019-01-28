<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.01.2019
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление навыка</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"></head>
<body>
<div class="w3-container w3-padding w3-blue w3 center">
    <a href="/skills" class="w3-button w3-margin w3-yellow w3-left w3-large">Навыки</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Добавление навыка</h1>
</div>

<br/>

<div class="w3-container w3-padding w3-blue">
    <form method="post" action="/skill_add">
        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Язык программирования: </h3>
            <input class="w3-input" name="skillName" value=""/>
        </div>

        <div class="w3-container w3-padding w3-light-grey w3-margin">
            <h3>Уровень (junior, middle, senior): </h3>
            <input class="w3-input" name="skillLevel" value=""/>
        </div>

        <div class="w3-container">
            <input type="submit" class="w3-button w3-green w3-right w3-large" value="Добавить навык"/>
        </div>
    </form>
</div>
</body>
</html>
