/**
 * 
 */
 $(document).ready(function(){
 
 
  var pAddressLine1 =  $('input[name="adress[0].line1"]')
var pAddressLine2 =  $('input[name="adress[0].line2"]')
var pLandmark =  $('input[name="adress[0].street"]')
var pZipcode = $('input[name="adress[0].pincode"]')
var pCity =  $('input[name="adress[0].city"]')
var pState =  $('input[name="adress[0].state"]')


var curAddressLine1 =  $('input[name="adress[1].line1"]')
var curAddressLine2 =  $('input[name="adress[1].line2"]')
var curLandmark =  $('input[name="adress[1].street"]')
var curZipcode =  $('input[name="adress[1].pincode"]')
var curCity = $('input[name="adress[1].city"]')
var curState =  $('input[name="adress[1].state"]')

var pAddressLine1Value 
var pAddressLine2Value 
var pLandmarkValue    
var pZipcodeValue     
var pCityValue        
var pStateValue       



    
  $("#checkBox").change(function() {




 if ($(this).is(':checked'))
 {
 
 pAddressLine1Value = pAddressLine1.val();
pAddressLine2Value = pAddressLine2.val();
 pLandmarkValue     = pLandmark.val();
 pZipcodeValue      = pZipcode.val();
 pCityValue         = pCity.val();
 pStateValue        = pState.val();
 console.log("data=="+pAddressLine1Value)

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

console.log($('#state[0]').val())
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

  // Bind keyup event to input fields
  $('input[type="text"]').keyup(function() {
    var field = $(this);
  
    var fieldId = field.attr('id');
   
    var value = field.val();

    // Validate based on field ID
    switch (fieldId) {
      case '':
        break;
        case 'pincode[1]':
        case 'pincode[0]':
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
        this.value = value;
      break;
     
      // Add cases for other input fields as needed
    }
  });
 
})