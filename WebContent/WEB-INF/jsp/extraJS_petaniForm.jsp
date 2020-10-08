<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script> 
<spring:url value="/resources/plugins/toastr/toastr.min.js" var="toastr" />
<script src="${toastr}"></script>   
<spring:url value="/resources/plugins/select2/js/select2.full.min.js" var="select2Jss" />
<script src="${select2Jss}"></script>
<script type="text/javascript">

$(function () {
    //Initialize Select2 Elements
    $('.select2').select2()
  })
  
$(document).ready(function () {	
	
	if("${notification}" == "success"){
		 toastr.success("<spring:message code='notification.update.success' />");
		} else if("${notification}" == "fail"){
		 toastr.success("<spring:message code='notification.update.success' />");
		}
		
  $('#petaniForm').validate({
    rules: {
      defaultPotongan: {
        digits:true
      }
    },
    messages: {
      defaultPotongan: {
        	required: "<spring:message code='validation.notEmpty' />",
	        digits:"<spring:message code='validation.notNumber' />"
      }
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
  
});
</script>
