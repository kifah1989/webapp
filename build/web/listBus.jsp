<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Buses</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Bus Id</th>
                <th>Bus Name</th>
                <th>Lunch Time</th>
                <th>Destination</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${buses}" var="bus">
                <tr>
                    <td><c:out value="${bus.getBusid()}" /></td>
                    <td><c:out value="${bus.getBusName()}" /></td>
                    <td><c:out value="${bus.getLunchTime()}" /></td>
                    <td><c:out value="${bus.getDestination()}" /></td>
                    <td><a href="BusController?action=edit&busId=<c:out value="${bus.getBusid()}"/>">Update</a></td>
                    <td><a href="BusController?action=delete&busId=<c:out value="${bus.getBusid()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="BusController?action=insert">Add Bus</a></p>
</body>
</html>