<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script> 
<spring:url value="/resources/plugins/toastr/toastr.min.js" var="toastr" />
<script src="${toastr}"></script>   
<!-- Bootstrap4 Duallistbox -->
<spring:url value="/resources/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js" var="duallistJss" />
<script src="${duallistJss}"></script>

<script type="text/javascript">  
$(document).ready(function () {	
	
	if("${notification}" == "success"){
		 toastr.success("<spring:message code='notification.update.success' />");
		} else if("${notification}" == "fail"){
		 toastr.success("<spring:message code='notification.update.success' />");
		}


  $('#pabrikForm').validate({
    rules: {
    	namaPerusahaan: {
        	required: true
		},
		uangJalanTruk: {
			required: true,
			digits:true
		},
		biayaMobilTruk: {
     		required: true,
     		digits:true
   		},
   		uangJalanTronton: {
       		required: true,
     		digits:true
   		},
   		biayaMobilTronton: {
       		required: true,
     		digits:true
   		}
    },
    messages: {
    	namaPerusahaan: {
        	required: "<spring:message code='validation.notEmpty' />"
		},
		uangJalanTruk: {
			required: "<spring:message code='validation.notEmpty' />",
			digits: "<spring:message code='validation.notNumber' />"
		},
		biayaMobilTruk: {
     		required: "<spring:message code='validation.notEmpty' />",
     		digits: "<spring:message code='validation.notNumber' />"
   		},
   		uangJalanTronton: {
       		required: "<spring:message code='validation.notEmpty' />",
     		digits: "<spring:message code='validation.notNumber' />"
   		},
   		biayaMobilTronton: {
       		required: "<spring:message code='validation.notEmpty' />",
     		digits: "<spring:message code='validation.notNumber' />"
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
