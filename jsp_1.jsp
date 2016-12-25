<%@ page import="javax.servlet.jsp.PageContext" %>
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
            ServletConfig servletConfig = getServletConfig();
            String testEmail = servletConfig.getInitParameter("testEmail");

            ServletContext ctx = getServletContext();
            ctx.setAttribute("testEmail", testEmail);
        }
    %>

    <%
        pageContext.setAttribute("foo", new Float(42.5));
        pageContext.setAttribute("foo2", new String("slon"), PageContext.SESSION_SCOPE);
    %>

    <div class="demoBlock">
        (Блок 1) testEmail =
        <%
            ServletContext c = getServletContext();
            String m = (String)c.getAttribute("testEmail");
            out.println(m);
        %>
        <br>
        ServletContext c = getServletContext();<br>
        String m = (String)c.getAttribute("testEmail");<br>
        out.println(m);
    </div>

    <div class="demoBlock">
        (Блок 2) testEmail = ${testEmail}<br>
        &#36;{testEmail}
    </div>

    <div class="demoBlock">
        (Блок 3) foo = ${foo} <br>
        &#36;{foo}
    </div>

    <div class="demoBlock">
        (Блок 4) foo2 = ${foo2} <br>
        &#36;{foo2}
    </div>

    <div class="demoBlock">
        (Блок 5) foo = <%= pageContext.getAttribute("foo") %> <br>
        &lsaquo;%= pageContext.getAttribute("foo") %&rsaquo;
    </div>

    <div class="demoBlock">
        (Блок 6) foo = <%= pageContext.findAttribute("foo") %> <br>
        &lsaquo;%= pageContext.findAttribute("foo") %&rsaquo;
    </div>

    <div class="demoBlock">
        (Блок 7) foo2 = <%= pageContext.findAttribute("foo2") %> <br>
        &lsaquo;%= pageContext.findAttribute("foo2") %&rsaquo;
    </div>

    <div class="demoBlock">
        (Блок 8) foo2 = <%= pageContext.findAttribute("foo2") %> <br>
        &lsaquo;%= pageContext.findAttribute("foo2") %&rsaquo;
    </div>
</div>
</body>
</html>