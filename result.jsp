<%@ page import="java.util.*" %>
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
        <a href="https://github.com/kvark85/JAVA_Joke_exprt-MVC-">github.com/kvark85/JAVA_Joke_exprt-MVC-</a>
    </div>

    <div class="page-header">
        <h1>Простое приложение для получения анекдотов <small>(JAVA MVC)</small></h1>
    </div>

    <div class="margin-bottom">
        <%
            String joke = (String)request.getAttribute("joke");
            out.print(":) " + joke);
        %>
    </div>

    <div class="margin-bottom">
        <a class="btn btn-primary" href="/JAVA_Joke_exprt-MVC" role="button">Назад</a>
    </div>

    <div class="jumbotron">
        <p>
            Данная страница построена с помощью jsp
        </p>
        <p>
            Дизайнер этой страницы:
            <b><% out.print((String)request.getAttribute("markup_designer")); %></b>
            <br />
            (путь: servlet init parameters (in DD) -> Servlet -> JSP)
        </p>
        <p>
            Значение <b>"main_domain"</b> из <b>"context init parameters"</b>:
            <b><% out.print((String)request.getAttribute("main_domain")); %></b>
            <br />
            (путь: context init parameters (in DD) -> Servlet -> JSP)
        </p>
    </div>
</div>
</body>
</html>
