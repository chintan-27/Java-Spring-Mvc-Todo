<%@page import="todoapp.models.Tasks"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<body>
<h1>TASKS </h1>
<h1> USER ID: ${user_id }</h1>
<a href="/todoapp/tasks/add_task?user_id=${user_id }">Add Task</a>

<br>
<br>
<br>
<table>
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
</table>
</body>
</html>