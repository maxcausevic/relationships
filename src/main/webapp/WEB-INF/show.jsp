<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver</title>
</head>
<body>

<h1><c:out value="${person.firstName} ${person.lastName}"></c:out></h1>
<h3><c:out value="${license.number}"></c:out></h3>
<h3><c:out value="${license.state}"></c:out></h3>
<h3><c:out value="${license.expirationDate}"></c:out></h3>


</body>
</html>