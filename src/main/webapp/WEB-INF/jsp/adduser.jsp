<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">



 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html>

        <head>
          <meta charset="UTF-8">
          <title>Add User</title>
        </head>

        <body class="bg-info">
      
            <h5 class="font-weight-bold text-white text-dark text-center mt-5">Register User</h5>
           
            <div class="col-md-6 shadow-lg p-3 mb-5 bg-white rounded  " style="margin-left: 345px;">
             
                 <form:form action="/adduser1" method="post" id="user-form" modelAttribute="user">
               
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
                      placeholder="Date of birth" required="true" />
                  </div>

                  <div class="form-floating mb-3">
                    <label for="exampleInputPassword1">email id<span class="text-danger">*</span></label>
                    <form:input type="email" id="email_id" path="email" class="form-control" placeholder="email id"
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
                      placeholder="Password" required="true" />
                          <input id="check" type="checkbox" class="form-control-check-input">  check for password<br>
                    
                      <a id="pass"></a>
                 
                
               
             </div>
           </div>

                  <div class="row">
                    <div class="col-sm-6">
                      <h5 class="font-weight-light">Permanent Address<span class="text-danger">*</span></h5><br>

                      <c:forEach var="use" items="${user.adress}">

                        <input type="hidden" placeholder="Address Type" name="permanetAdd" value="Permanent"
                          required="true">
                        <span id="usernpasswordame-error"></span>
                        <div class="form-group">
                          <input type="text" class="form-control" id="p_street" placeholder="street " name="permanetAdd"
                            value="${use.street}" required="true">
                          <span id="username-error"></span>
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="p_line1" placeholder="Address Line 1"
                            name="permanetAdd" value="${use.line1}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="p_line2" placeholder="Address Line 2"
                            name="permanetAdd" value="${use.line2}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="p_city" placeholder="city" name="permanetAdd"
                            value="${use.city}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="p_state" placeholder="state" name="permanetAdd"
                            value="${use.state}" required="true">
                        </div>
                        <div class="form-group">

                          <input type="text" class="form-control"
                            oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\.*)\./g, '$1');"
                            id="c_pincode" placeholder="Pincode" name="permanetAdd" value="${use.pincode}"
                            required="true">
                        </div>
                      </div>
                      </c:forEach>
                   
                    <div class="col-sm-6" style="float:right;">
                      <h5 class="font-weight-light">Current Address<span class="text-danger">*</span></h5>
                      <input type="checkbox" class="form-control-check-input" id="checkBox"> same as permanetAdd
                      <c:forEach var="use2" items="${user.adress}">

                        <input type="hidden" placeholder="Addlress Type" name="currentAdd" value="Current"
                          required="true">

                        <div class="form-group">
                          <input type="text" class="form-control" id="c_street" placeholder="street " name="currentAdd"
                            value="${use2.street}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="c_line1" placeholder="Address Line 1"
                            name="currentAdd" value="${use2.line1}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="c_line2" placeholder="Address Line 2"
                            name="currentAdd" value="${use2.line2}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="c_city" placeholder="city" name="currentAdd"
                            value="${use2.city}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" id="c_state" placeholder="state" name="currentAdd"
                            value="${use2.state}" required="true">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control"
                            oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\.*)\./g, '$1');"
                            id="c_pincode1" placeholder="Pincode" name="currentAdd" value="${use2.pincode}" required>
                        </div>
                      </c:forEach>
                     
                    </div>
                   
                  </div>
                  <div>
                  <button type="submit" id="submit_data" class="btn btn-primary " style="margin-left: 212px">Submit</button> <a
                    href="/" class="btn btn-info ml-2">Back</a></div>
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
         <script type="text/javascript" src="js/script.js"></script>

        </body>

        </html>