<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script> 
<spring:url value="/resources/plugins/toastr/toastr.min.js" var="toastr" />
<script src="${toastr}"></script>   
<spring:url value="/resources/plugins/daterangepicker/daterangepicker.js" var="datepickerJS"/>
<script src="${datepickerJS}"></script>   
<spring:url value="/resources/plugins/moment/moment.min.js" var="momentJS"/>
<script src="${momentJS}"></script>
<!-- Tempusdominus Bootstrap 4 -->
<spring:url value="/resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js" var="tempusJS"/>
<script src="${tempusJS}"></script>
<script>
  $(function () {

    //Date picker
    $('#reservationdate').datetimepicker({
        format: 'L'
    });

  })


  $(document).ready(function () {	
   $('#hargaForm').validate({
    rules: {
      "tanggalMulai": {
        required: true,
        maxlength:10
      },
      "hargaJual": {
        required: true,
        maxlength:5,
        number: true,
        digits:true
      },
      "hargaBeliJembatan": {
        required: true,
        maxlength:5,
        number: true,
        digits:true
      },
      "hargaBeliGantung": {
        required: true,
        maxlength:5,
        number: true,
        digits:true
      }
    },
    messages: {  
    "tanggalMulai": {
        required: "<spring:message code='validation.notEmpty' />",
        maxlength:"Maksimal panjang karakter 10"
    },
    "hargaJual": {
      required: "<spring:message code='validation.notEmpty' />",
      maxlength:"Maksimal panjang karakter 200",
      number: "Masukan harus berupa angka",
      digits:"Masukan harus berupa angka"
    },
    "hargaBeliJembatan": {
      required: "<spring:message code='validation.notEmpty' />",
      maxlength:"Maksimal panjang karakter 200",
      number: "Masukan harus berupa angka",
      digits:"Masukan harus berupa angka"
    },
    "hargaBeliGantung": {
      required: "<spring:message code='validation.notEmpty' />",
      maxlength:"Maksimal panjang karakter 200",
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