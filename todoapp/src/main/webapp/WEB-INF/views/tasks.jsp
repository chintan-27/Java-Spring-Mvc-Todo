<%@page import="todoapp.models.Tasks"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<body>
<div class="text-center">
<h1>TASKS </h1>
<h3> USER ID: ${user_id }</h3>
<h3>Welcome, ${user.username } </h3>
</div>

<br>
<br>
<br>
<%-- <table>
	<tr>
		<th>Task</th>
		<th>Completed ?</th>
		<th>Actions</th>
	</tr>
	<% 
	List<Tasks> tasks = (List<Tasks>)request.getAttribute("tasks");
	for(Tasks t: tasks){ %>
	<tr>
		<td> <%=t.getTask() %> </td>
		<td> <%=t.isCompleted() %> </td>
		<td> <a href="/todoapp/tasks/deletetask?user_id=<%=t.getUser().getId()%>&id=<%=t.getId() %>">DELETE</a>
		<% if(!t.isCompleted()){ %>
		<a href="/todoapp/tasks/taskcomplete?user_id=<%=t.getUser().getId()%>&id=<%=t.getId() %>">COMPLETED</a>
		<% } %>
		</td>
	</tr>
	<%} %>
</table> --%>


<div class="text-center">
	<table class="table" style="width:70%;margin-left:auto;margin-right:auto;">
	  <thead class="thead-dark">
	    <tr>
	   		
	      <th scope="col">Sr.No</th>
	      <th scope="col">Task</th>
	      <th scope="col">Completed</th>
	      <th scope="col">Actions</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${tasks }" var="task">
	    <tr >
	    	<td class="text-center"> ${task.getId() }</td>
			<td class="text-center"> ${task.getTask() } </td>
			<td class="text-center"> ${task.isCompleted() } </td>
			<td class="text-center"> <a href="/todoapp/tasks/deletetask?user_id=${task.getUser().getId()}&id=${task.getId() }" style="text-decoration: underline;"><i class="fas fa-trash" style="font-size:50" ></i></a>
			<c:if test="${!task.isCompleted()}">
			<a href="/todoapp/tasks/taskcomplete?user_id=${task.getUser().getId() }&id=${task.getId()}" style="text-decoration: underline;"><i class="fas fa-thumbs-up" ></i></a>
			</c:if>
			</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<a href="/todoapp/tasks/add_task?user_id=${user_id }"><button class="btn btn-success">Add Task</button></a>
</div>
</body>
</html>