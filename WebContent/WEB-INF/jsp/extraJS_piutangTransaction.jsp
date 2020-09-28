<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script> 
<spring:url value="/resources/plugins/toastr/toastr.min.js" var="toastr" />
<script src="${toastr}"></script>   

<script type="text/javascript">
$(document).ready(function () {    
  $('#piutangForm').validate({
    rules: {
    	"jenisTransaksi": {
        	required: true
      	},
        "amount": {
           required: true,
           maxlength:20,
           number: true,
           digits:true
         }
    },
    messages: {
    	"jenisTransaksi": {
    		required: "Kolom ini tidak boleh kosong"
	    },
	    "amount": {
        	required: "Kolom ini tidak boleh kosong",
        	maxlength: "Maximum panjang karakter adalah 20",
            number: "Masukan harus berupa angka",
            digits:"Masukan harus berupa angka"
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
  

	if("${notification}" == "success"){
	 toastr.success("<spring:message code='notification.update.success' />");
	} else if("${notification}" == "fail"){
	 toastr.success("<spring:message code='notification.update.success' />");
	}
});
</script>