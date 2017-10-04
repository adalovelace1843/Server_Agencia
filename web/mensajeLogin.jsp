<%-- 
    Document   : mensaje
    Created on : 26/07/2017, 09:30:18 AM
    Author     : f188315
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>
            <c:out value="${mensaje}"></c:out>
        </h2>
        <a href="index.jsp">Volver</a>
    </body>
</html>
