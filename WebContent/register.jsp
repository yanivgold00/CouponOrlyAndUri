<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import="com.market.com.service.CouponGroup"%>
<%@include file="header.jsp" %>

<h2>register</h2>
<form action="" method="get">
name: <input type="text" name="username"><br>
password: <input type="password" name="userpass"><br>
Group:
<select name="group">
<%for(CouponGroup tmp: CouponGroup.getAllGroups()){ 
	if(tmp!=null){
%>
	<option><%=tmp.getGroupName() %></option>
<%}} %>
</select>
<input type="submit" value="register">
</form>

<%for(CouponGroup tmp: CouponGroup.getAllGroups()){ 
	if(tmp!=null){
%>

<div id="group">
		<h1><%=tmp.getGroupName() %></h1>
		<h2>Num: <%=tmp.getGroupnum() %></h2>
</div>
	
<%}} %>


</body>
</html>