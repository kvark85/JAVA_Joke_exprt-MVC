<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP 1</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<div class="container">
    <div class="page-header"><div>Типа header</div></div>

    <%!
        public void jspInit() {
            //todo не могу никак в этом месте вытащить testEmail из КОНФИГУРАЦИИ СЕРВЛЕТА
            ServletConfig servletConfig = getServletConfig();
            String testEmail = servletConfig.getInitParameter("testEmail");
            ServletContext ctx = getServletContext();

            String ss = getServletConfig().getInitParameter("testEmail");

            ctx.setAttribute("testEmail", testEmail);
        }
    %>

    <div class="demoBlock">
        Блок 1
        <%
            ServletContext c = getServletContext();
            String m = (String)c.getAttribute("testEmail");
            out.println(m);
        %>
    </div>

    <div class="demoBlock">
        Блок 2 ${testEmail}
    </div>
</div>
</body>
</html>