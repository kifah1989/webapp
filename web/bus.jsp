<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<title>Add new bus</title>
</head>
<body>

    <form method="POST" action='BusController' name="frmAddBus"> 
        Bus Name : <input
            type="text" name="busName"
            value="<c:out value="${bus.busName}" />" /> <br /> 
        Lunch Time : <input
            type="text" name="lunchTime"
            value="<c:out value="${bus.lunchTime}" />" /> <br /> 
        Destination : <input 
            type="text" name="destination"
            value="<c:out value="${bus.destination}" />" /> <br /> 
        <input
            type="submit" value="Submit" />
    </form>
</body>
</html>