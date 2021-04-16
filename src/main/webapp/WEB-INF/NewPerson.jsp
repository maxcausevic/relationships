<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New Person</h1>
	<form method="POST" action="/createPerson" modelAttribute="person">
        <label>First Name: <input type="text" name="firstName"></label>
        <br>
        <br>
        <label>Last Name <input type="text" name="lastName"></label>
        <br>
        <br>
    
    <input type="submit" value="Submit"/>
    </form>
</body>
</html>