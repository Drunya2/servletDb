<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 24.01.2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Customer"%>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Заказчики</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <a href="/" class="w3-button w3-margin w3-large w3-yellow w3-left">Главная</a>
</div>

<div class="w3-container w3-padding w3-blue w3-large w3-center">
    <h1>Заказчики</h1>
</div>

</br>

<div class="w3-container w3-padding w3-large">
    <ol class="w3-ul">
        <%
            List<Customer> customers = (List<Customer>) request.getAttribute("customers");
            if (customers.isEmpty()){
                out.print("<div class=\"w3-container w3-center w3-red w3-margin-bottom\">");
                out.println("<h2> Заказчиков нет </h2>");
                out.println("</div>");
            }
            else{
                for(Customer customer: customers) {
                    out.print("<li class=\"w3-yellow\">" + customer.getId() + ".  " + customer.getName() +
                            " <a class=\"w3-button w3-green\" href=\"/customer_info?id=" + customer.getId() + "\">Инфо</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/customer_edit?id=" + customer.getId() + "\">Редактировать</a>" +
                            " <a class=\"w3-button w3-green\" href=\"/customer_delete?id=" + customer.getId() + "\">Удалить</a>" );
                    out.println("</li>");
                }
            }
        %>
    </ol>
</div>

</br>
<a href="/customer_add" class="w3-margin-top w3-button w3-green w3-right">Добавить заказчика</a>
</body>
</html>



