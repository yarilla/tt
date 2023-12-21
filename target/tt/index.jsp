<%@ page import="services.Web" %>
<jsp:useBean id="webService" class="services.Web" scope="session"/>
<html>
<head>
    <title>Books</title>
    <meta charset="UTF-8">
</head>
<body style="background-color: antiquewhite">
<h2>Books</h2>


<I><%= Web.getHTMLData()%></I>

<h5>Quantity = <%= Web.getNUmberOfBooks() %></h5>
<h5>Total Cost = <%= Web.getSumPrice() %></h5>
</body>
</html>
