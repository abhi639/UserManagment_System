<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="row" style="margin-right: 150;">
   <div class="col-sm-6">
    <h5 class="text-primary">Permanent Address</h5>
      
    <!--=== Permanent address=== -->
     <div class="form-group">
        <form:input path="" type="text" class="form-control" placeholder="Address Line 1" id="pAddressLine1"/>
     </div>
      <div class="form-group">
          <form:input path="" type="text" class="form-control" placeholder="Address Line 2" id="pAddressLine2"/>
      </div>
      <div class="form-group">
          <form:input path="" type="text" class="form-control" placeholder="Streat" id="pLandmark"/>
       </div>
      <div class="form-group">
          <form:input path="" type="text" class="form-control" placeholder="Zip Code" id="pZipcode"/>
       </div>
      <div class="form-group">
          <form:input path="" type="text" class="form-control" placeholder="City" id="pCity"/>
       </div>
      <div class="form-group">
          <form:input path="" type="text" class="form-control" placeholder="State" id="pState"/>
       </div>
      
    
    <!--=== Permanent address=== -->
   </div>
 <div class="col-sm-6">
   <h5 class="text-primary">Current Address</h5>
      
  
         
     
    <!--=== current address=== -->
      <div class="form-group">
          <form:input type="text" path="name" class="form-control" placeholder="Address Line 1" id="curAddressLine1"/>
       </div>
      <div class="form-group">
          <form:input type="text" path="name" class="form-control" placeholder="Address Line 2" id="curAddressLine2"/>
       </div>
      <div class="form-group">
          <form:input type="text" path="name" class="form-control" placeholder="Landmark" id="curLandmark"/>
       </div>
      <div class="form-group">
          <form:input type="text" path="name" class="form-control" placeholder="Zip Code" id="curZipcode"/>
       </div>
      <div class="form-group">
          <form:input type="text" path="name" class="form-control" placeholder="City" id="curCity"/>
       </div>
      <div class="form-group">
          <form:input type="text" path="name" class="form-control" placeholder="State" id="curState"/>
       </div>
      
    <!--=== current address=== -->
   </div>
   <div class="col-sm-4"></div>
</div>
</body>
</html>