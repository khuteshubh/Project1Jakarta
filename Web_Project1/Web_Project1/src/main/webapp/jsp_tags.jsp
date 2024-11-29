<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp_Tag</title>
</head>
<body>
<%--including the resource:color.html --%>
<%@include file="color.html" %>
<%--using the declaration section to declare a variable and define a method --%>
<%!
int val = 7;
public String sayWelcome(String name){
String meassage = "welcome"+name;
return meassage;
}

%>

<%--Showing hello using h1 heading 5 times --%>

<%--Starting of for loop using scriptlet --%>
<%
for(int a=1;a<=5;a++){
	
%>
<h1>HELLO</h1>
<%}%>
<%--Fetching the value of val using expression --%>
<h2>val=<%=val%></h2>
<h2>Square of Val=<%=(val*val)%></h2>

<%--Invoking the method :saay Welcome()using expression --%>
<h2>Reply from method is <%=sayWelcome (" James") %> </h2>

<%--Creating a localDate object for system date --%>
<%
LocalDate today =LocalDate.now();
%>
<h2>Today's date is <%=today%></h2>
</body>
</html>