/**
 * 
 */	
 
        

            var email;
            var password;
            var mobile_no;


            var maxDate = new Date();
            maxDate.setFullYear(maxDate.getFullYear() - 18);

            // Initialize the datepicker with the minDate option
            $('#birth_DATE').datepicker({
              minDate: "-100y",
              maxDate: "-18y",
              yearRange: "-100:+0",
              changeYear: true,
              changeMonth: true,
              dateFormat: 'dd-mm-yy'
            });

            // Set the maxDate option dynamically based on the calculated value
            $('#birth_DATE').datepicker("option", "maxDate", maxDate);
            $("#submit_data").click(function (event) {

              if (email == false || password == false || mobile_no == false) {

                event.preventDefault();
                alert("please validate the details")

              }

            })

            // Bind keyup event to input fields
            $('input[type="text"], input[type="password"],input[type="email"]').keyup(function () {
              var field = $(this);
              var fieldId = field.attr('id');
              var value = field.val();

              // Validate based on field ID
              switch (fieldId) {
                case 'c_pincode1':

                value = value.replace(/[^\d]/g, "");
                  if (value.length > 6) {
                    value = value.slice(0, 6);

                  }

                  // Set the value of the input
                  this.value = value;
                  break;
                    
                case 'c_pincode':
                  value = value.replace(/[^\d]/g, "");
                  if (value.length > 6) {
                    value = value.slice(0, 6);

                  }

                  // Set the value of the input
                  this.value = value;
                  break;


                case 'mobile_number':
                  value = value.replace(/[^\d]/g, "");
                  if (value.length > 10) {
                    value = value.slice(0, 10);


                  }
                  //^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
                  this.value = value;
                  if (value.length == 0) {
                    console.log(value.length)

                    $("#mob").text("please enter  Mobile number").css("color", "red");
                  }

                  $.ajax({
                    url: "/useremailvalidmobile/" + value,
                    type: "GET",

                    success: function (result) {


                      if (result == "true") {
                        if (value.length == 10) {
                          console.log(value.length)
                          $("#mobile_number").css("color", "green");
                          $("#mob").text("Valid Mobile number").css("color", "green");
                          mobile_no = true;
                        }


                        console.log(result)
                      }

                      else if (result == "false") {
                        $("#mobile_number").css("color", "red");
                        $("#mob").text(" mobile number is already exist").css("color", "red");
                        mobile_no = false
                      }


                    },
                    error: function (xhr, status, error) {
                      $("#vali").text("")
                      console.log(error);
                    }
                  });
                  break;

                case 'email_id':

                  $.ajax({
                    url: "/useremailvalid/" + value,
                    type: "GET",
                    success: function (result) {
                      if (result == "true") {
                        var email1 = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(value);

                        console.log("data==" + email1)
                        if (email1 == false) {
                          $("#vali").text("please enter proper email address").css("color", "red");
                          email = false;

                        }
                        else {
                          $("#email_id").css("color", "green");
                          $("#vali").text("Valid email address").css("color", "green");
                          console.log(result)
                          email = true
                        }
                      }
                      else if (result == "false") {
                        $("#email_id").css("color", "red");
                        $("#vali").text("dublicate email address").css("color", "red");
                        email = false;
                      }


                    },
                    error: function (xhr, status, error) {
                      $("#vali").text("")
                      console.log(error);
                    }
                  });


                  break;

                case 'password':
                  var data = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(value);
                  console.log(data)
                  if (data == true) {
                    $("#password").css("color", "green");
                    $("#pass").text("Valid password").css("color", "green");

                    password = true
                  }
                  else if (data == false) {
                    $("#password").css("color", "red");
                    $("#pass").text("inValid password").css("color", "red");
                    password = false;
                  }


                  break;
                // Add cases for other input fields as needed

              }
            });



            $("#check").click(function () {
              if ($("#check").prop('checked')) {
                $('#password').attr('type', 'text');
              }
              else {

                $('#password').attr('type', 'password');

              }

            })

            
  $("#checkBox").change(function() {


let pAddressLine1 = $("#p_line1");
let pAddressLine2 = $("#p_line2");
let pLandmark = $("#p_street");
let pZipcode = $("#c_pincode");
let pCity = $("#p_city");
let pState = $("#p_state");


let curAddressLine1 = $("#c_line1");
let curAddressLine2 = $("#c_line2");
let curLandmark = $("#c_street");
let curZipcode = $("#c_pincode1");
let curCity = $("#c_city");
let curState = $("#c_state");


 if ($(this).is(':checked'))
 {
 
let pAddressLine1Value = pAddressLine1.val();
let pAddressLine2Value = pAddressLine2.val();
let pLandmarkValue     = pLandmark.val();
let pZipcodeValue      = pZipcode.val();
let pCityValue         = pCity.val();
let pStateValue        = pState.val();


curAddressLine1.val(pAddressLine1Value); 
curAddressLine2.val(pAddressLine2Value); 
curLandmark.val(pLandmarkValue);   
curZipcode.val(pZipcodeValue);     
curCity.val(pCityValue);     
curState.val(pStateValue);       
     


}
 else
 {
curAddressLine1.val("");
curAddressLine2.val(""); 
curLandmark.val("");     
curZipcode.val("");     
curCity.val("");         
curState.val("");       
        
 }
});
 