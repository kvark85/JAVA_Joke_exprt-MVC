<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=utf-8" %>


<!DOCTYPE HTML>
<html lang="en"><head>
    <meta charset="UTF-8">
    <title>Получить анекдот</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>Простое приложение для получения анекдотов <small>(JAVA MVC)</small></h1>
    </div>

    <div>
        <%
            String joke = (String)request.getAttribute("joke");
            out.print(":) " + joke);
        %>
    </div>
    <div>
        <a href="/Beer-v1">Назад</a>
    </div>
</div>
</body>
</html>
