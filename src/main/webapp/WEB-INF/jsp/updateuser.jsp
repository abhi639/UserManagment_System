<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<style>
.app{
    margin-top: 100px;
    margin-left: 270px;
}






</style>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body class="bg-info">

<h5 class="font-weight-bold text-white text-dark text-center mt-5">Update User</h5>
<div  class="col-md-6 shadow-lg p-3 mb-5 bg-white rounded" style="margin-left: 345px;">

<form:form modelAttribute="user" id="user-form" action="/user/${U_id}/update" method="post" >

              <div class="col mt-5 " >

                  <div class="form-floating mb-3">
                    <label for="exampleInputEmail1" >Name<span class="text-danger">*</span></label>
                    <form:input type="text" onkeydown="return /[a-z]/i.test(event.key)" path="first_name"
                      id="first_name" class="form-control" placeholder="Name" required="true" />
                  </div>
                  <div class="form-floating mb-3">
                    <label for="exampleInputEmail1">Last Name<span class="text-danger">*</span></label>
                    <form:input type="text" onkeydown="return /[a-z]/i.test(event.key)" path="last_name" id="last_name"
                      class="form-control" placeholder="Last Name" required="true" />
                  </div>
                  <div class="form-floating mb-3">
                    <label for="exampleInputEmail1">Date of Birth<span class="text-danger">*</span></label>
                    <form:input type="text" path="dateof_birth" id="birth_DATE" class="form-control"
                      placeholder="Date of birth" required="true" /><i class="bi bi-calendar3"></i>
                  </div>

                  <div class="form-floating mb-3">
                    <label for="exampleInputPassword1">email id<span class="text-danger">*</span></label>
                    <form:input type="email" readonly="true" id="email_id" path="email" class="form-control" placeholder="email id"
                      required="true" />
                    <a id="vali"></a>

                    <!-- <p class="help-block"></p> -->
                  </div>


                  <div class="form-floating mb-3">
                    <label for="exampleInputEmail1">Mobile number<span class="text-danger">*</span></label>
                    <form:input type="text" path="mobile_number"
                      oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\.*)\./g, '$1');"
                      class="form-control" id="mobile_number" placeholder="Mobile number" required="true" />
                    <a id="mob"></a>
                  </div>

                  <div class=" form-floating mb-3">
                    <label for="exampleInputEmail1">Password<span class="text-danger">*</span></label>
          
                     
                    <form:input type="password" path="password" class="form-control" id="password"
                      placeholder="Password" readonly="true" required="true" />
                    
                     
                 
                
               
             </div>
           </div>
  	

   <div class="row" >
  
   
 <c:forEach var="use" items="${user.adress}" varStatus="status">
 
   <div class="col-sm-6">
    <h5 class="font-weight-light">${use.adress_type} Address</h5>
    
  <input type="hidden"  name="adress[${status.index}].Add_id" id="permanetAdd.{status.index}" value="${use.add_id}">
  
  <input type="hidden" class="form-control" placeholder="Address Type" name="adress[${status.index}].adress_type" id="permanetAdd.{status.index}" value="${use.adress_type}">
  <div class="form-group">
   <input type="text" class="form-control" placeholder="street "name="adress[${status.index}].street"id="street[${status.index}]" value="${use.street}">
  </div>
  <div class="form-group">
  
   <input type="text" class="form-control" placeholder="Address Line 1" name="adress[${status.index}].line1" id="line1[${status.index}]" value="${use.line1}">
  </div>
  <div class="form-group">
   <input type="text" class="form-control" placeholder="Address Line 2" name="adress[${status.index}].line2" id="line2[${status.index}]" value="${use.line2}">
 </div>
 <div class="form-group">
   <input type="text" class="form-control" placeholder="city" name="adress[${status.index}].city" id="city[${status.index}]" value="${use.city}">
   </div>
   <div class="form-group">
   <input type="text" class="form-control" placeholder="state" name="adress[${status.index}].state" id="state[${status.index}]" value="${use.state}">
   </div>
   <div class="form-group">
   <input type="text" class="form-control" placeholder="Pincode" name="adress[${status.index}].pincode" id="pincode[${status.index}]" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\.*)\./g, '$1');" id="c_pincode" value="${use.pincode}">
   </div>
</div>
</c:forEach>
<input type="checkbox" class="form-control-check-input" id="checkBox" style="margin-left: 17px;">  same as permanetAdd

</div>

 


  <button type="submit" class="btn btn-primary align-middle mt-3" style="margin-left: 212px">Update</button> <a href="/" class="btn btn-info align-middle mt-3">Back</a>
</form:form>

</div>

 <script src="https://code.jquery.com/jquery-3.6.4.js"
            integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
          <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
          <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css">

<script type="text/javascript" src="/js/script2.js">
</script>


</body>
</html>