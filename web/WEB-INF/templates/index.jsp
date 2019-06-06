<%@page import="connection.CounterManager"%>
<%@page import="connection.Counter"%>
<%@page import="connection.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <c:forEach var="browser" items="${counter.browsers}">
            <tr>
                <td><c:out value="${browser.name}"/></td>
                <td><fmt:formatNumber value="${browser.requestPercent}" type="percent" pattern="#0.00"/> % </td>
            </tr>
            </c:forEach>
        </table>
        <p>Totat different browsers detected : <c:out value="${counter.total}"/> </p>
    </body>
</html>
