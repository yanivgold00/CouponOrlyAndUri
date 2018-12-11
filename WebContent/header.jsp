<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>7/11</title>
<style>
	body{
		background: yellow;
		color: purple;
	}
	
	#group{
		border: 1px solid blue
		
	}
	
	#group.h1{
		font-size: 15px
	}
	#group.h2{
		font-size: 5px
	}
</style>
</head>
<body>
<%if (session.getAttribute("message") != null){ %>
	<h4><%=session.getAttribute("message") %></h4>
<%
session.removeAttribute("message");
} %>
<h1>Welcome to my Market</h1>