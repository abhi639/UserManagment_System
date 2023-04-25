<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
  rel="stylesheet"
/>
   <!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- DataTables CDN CSS -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/dataTables.bootstrap4.min.css">

<!-- DataTables CDN JS -->
<script type="text/javascript" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script></head>
<body>

<!-- <nav class="navbar navbar-expand-md bg-dark navbar-dark">
  Brand
  <a class="navbar-brand" href="#" style="color:white">User Management System</a>

  Toggler/collapsibe Button
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  Navbar links
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" th:href="@{/users}" style="color:white">User Management</a>
      </li>
    </ul>
  </div>
</nav> -->

 <div class ="container" >
		<div class = "row">
			<h1>List of inactive Users</h1>
		</div>
		

     	<table  id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			<thead class = "table-dark">
				<tr>
					<!-- <th>id</th> -->
					<th>FirstName</th>
					<th> LastName </th>
					<th> Dob </th>
					<th> Email Address </th>
					<th> Mobile No </th>
          <th>Action</th>
					<!-- <th> Password </th> -->
					
					
				</tr>
			</thead>
        <tbody>
            <c:forEach var="user" items="${users}">
          <tr>
            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.dateof_birth}</td>
            <td>${user.email}</td>
            <td>${user.mobile_number}</td>
            <td style="width: 250px;"><a class="btn btn-danger" href="/inactiveuser/${user.u_id}/delete"><i class="fas fa-trash-alt"> Delete</i></a></td>
          </tr>
        </c:forEach>
        </tbody>
       
      </table>

</div>



      <script type="text/javascript">
        
            $(document).ready(function () {
  $('#dtBasicExample').DataTable({
    "pageLength": 5,
    "searching": false, 
"lengthChange": false 
  });
  
  
});
      </script>
</body>
</html>