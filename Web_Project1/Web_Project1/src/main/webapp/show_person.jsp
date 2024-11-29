<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show_Person</title>
</head>
<body bgcolor="yellow" style="padding-left:500px;padding-top:100px">
<%--Obtaining the bean of type :Person with id:personObj --%>
<jsp:useBean id="personObj" class="example.bean.Person" scope="session"></jsp:useBean>
<%--Retrieving the value of the bean properties and printing them --%>
<h1 style="color:blue " >Person Details:</h1>
<h2>Name:-   <jsp:getProperty property="name" name="personObj"/></h2>
<h2>Age:-    <jsp:getProperty property="age" name="personObj"/></h2>
<h2>Weight:- <jsp:getProperty property="weight" name="personObj"/></h2>

</body>
</html>