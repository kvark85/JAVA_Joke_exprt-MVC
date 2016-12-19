<%@ page import="java.util.*" %>
<%@ page import="com.example.aboutDeveloper.DeveloperInformation" %>
<%@ page contentType="text/html;charset=utf-8" %>


<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Получить анекдот</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div>
        <a href="https://github.com/kvark85/JAVA_Joke_exprt-MVC">github.com/kvark85/JAVA_Joke_exprt-MVC</a>
    </div>

    <div class="page-header">
        <h1>Простое приложение для получения анекдотов <small>(JAVA MVC)</small></h1>
    </div>

    <div class="margin-bottom">
        :) <%= (String)request.getAttribute("joke") %>
    </div>

    <div class="margin-bottom">
        <button id="backBtn" class="btn btn-primary">Назад</button>
    </div>

    <div class="jumbotron">
        <div class="demoBlock">
            Дизайнер этой страницы: <b><%= (String)request.getAttribute("markup_designer") %></b>
            (изначально значение в КОНФИГУРАЦИИ СЕРВЛЕТА (в DD), в сервлете значение помещается в request).
        </div>

        <div class="demoBlock">
            Наш слоган: <b><%= (String)request.getAttribute("slogan") %></b>
            (изначально значение в КОНФИГУРАЦИИ КОНТЕКСТА СЕРВЛЕТОВ (в DD), в сервлете значение помещается в request).
        </div>

        <div class="demoBlock">
            <%DeveloperInformation developer = (DeveloperInformation)getServletContext().getAttribute("developer");%>

            Разработчик: <b><%= developer.getName() %> (email: <%= developer.getEmail() %>)</b>
            (изначально значения в КОНФИГУРАЦИИ КОНТЕКСТА СЕРВЛЕТОВ (в DD), в слушателе контекста сервлетов
            создается обьект "developer" и помещается в КОНТЕКСТ СЕРВЛЕТОВ).
        </div>
    </div>
</div>

<script>
    document.getElementById("backBtn").addEventListener("click", function(){
        window.history.back();
    });
</script>
</body>
</html>
