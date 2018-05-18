<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    

<%@page import="java.util.ArrayList,com.pragim.model.Country" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.top-buffer { margin-top:20px; }

</style>

<script type="text/javascript">
	$(function() {
    		$("#testdiv").delay(3000).fadeOut(0);
	});
	
	
	function prepareOptionsForLanguages(){
		
		var list = [];
		list.push("HINDI");
		list.push("URDU");
		list.push("Engl");
		list.push("French");
		list.push("Germen");
		
	}
</script>

</head>
<body >


<%
	Country obj = (Country)request.getAttribute("countryObj");

%>
<%

String str = (String)request.getAttribute("message");
if(str!=null)
	%>
	<div class="alert alert-danger" id="testdiv">
  		<strong><%=str %></strong>
	</div>
<form action="getcountries">

<div>
	<%if(obj!=null){ %>
	<input type="hidden" value=<%=obj.getcId()%> name="id"/>
 	<div class="row top-buffer">
      <label class="col-sm-2">CountryName:</label>
      <input class="col-sm-6" type="text" class="form-control" id="email" placeholder="Enter country name" name="cname" value=<%=obj.getName() %>>
    </div>
    <div class="row top-buffer">
      <label class="col-sm-2">Language:</label>
      <select class="col-sm-6" name="lang" value=<%=obj.getLang() %>>
      	<option>HINDI</option>
      	<option>URDU</option>
      	<option>ENG</option>
      	<option>French</option>
      	<option>Germen</option>
      </select>
    </div>
    <div class="row top-buffer">
      <label class="col-sm-2" for="email">Currency:</label>
      <select class="col-sm-6" name="currency" value=<%=obj.getCurrency() %>>
      	<option>RUPEE</option>
      	<option>Afghani</option>
      	<option>Real</option>
      	<option>Yuan</option>
      	<option>Doller</option>
      	<option>Dinar</option>
      	<option>Pound</option>
      </select>
    </div>
    
    <button type="submit" name="button" value="update" class="btn btn-primary">update</button>
	<%}else{ %>
	<div class="row top-buffer">
      <label class="col-sm-2">CountryName:</label>
      <input class="col-sm-6" type="text" class="form-control" id="email" placeholder="Enter country name" name="cname">
    </div>
    <div class="row top-buffer">
      <label class="col-sm-2">Language:</label>
      <select class="col-sm-6" name="lang">
        <option value="">--select--</option>
      	<option>HINDI</option>
      	<option>URDU</option>
      	<option>ENG</option>
      	<option>French</option>
      	<option>Germen</option>
      </select>
    </div>
    <div class="row top-buffer">
      <label class="col-sm-2" for="email">Currency:</label>
      <select class="col-sm-6" name="currency">
      	<option value="">--select--</option>
      	<option>RUPEE</option>
      	<option>Afghani</option>
      	<option>Real</option>
      	<option>Yuan</option>
      	<option>Doller</option>
      	<option>Dinar</option>
      	<option>Pound</option>
      </select>
    </div>
    
    <button type="submit" name="button" value="add" class="btn btn-primary">ADD</button>
	<%} %>
</div>
<br>

<br><br>

<table class="table table-hover" style="width: 50%">
<%

	ArrayList<Country> al = (ArrayList)request.getAttribute("curlist");
	request.getAttribute("curlist");
	for(Country coun:al){
		%>
		<tr>
			<td><input type="checkbox" name="cid" value=<%=coun.getcId()%>></td>
			<td><%=coun.getName() %></td>
			<td><%=coun.getLang() %></td>
			<td><%=coun.getCurrency() %></td>
			<td><a href="getcountries?id=<%=coun.getcId()%>&button=edit" class="glyphicon glyphicon-edit"></a></td>
		</tr>
	<% }

%>
</table>
<br>
<input type="submit" value="delete" name="button" class="btn btn-danger glyphicon glyphicon-trash"/>
</form>
</body>
</html>