<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.01.2019
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Company"%>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Компании</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/" class="w3-button w3-margin w3-large w3-yellow w3-left">Главная</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Компании</h1>
</div>

</br>

<div class="w3-container w3-padding w3-large">
    <ol class="w3-ul">
        <%
            List<Company> companies = (List<Company>) request.getAttribute("companies");
            if (companies.isEmpty()){
                out.print("<div class=\"w3-container w3-center w3-red w3-margin-bottom\">");
                out.println("<h2> Компаний нет </h2>");
                out.println("</div>");
            }
            else{
                for(Company company: companies) {
                    out.print("<li class=\"w3-yellow\">" + company.getId() + ".  " + company.getName() +
                            " <a class=\"w3-button w3-green\" href=\"/company_info?id=" + company.getId() + "\">Инфо</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/company_edit?id=" + company.getId() + "\">Редактировать</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/company_delete?id=" + company.getId() + "\">Удалить</a>" );
                    out.println("</li>");
                }
            }
        %>
    </ol>
</div>

</br>
<a href="/company_add" class="w3-margin-top w3-button w3-green w3-right">Добавить компанию</a>
</body>
</html>


