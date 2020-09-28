<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
    $('#idDariTanggal').datetimepicker({
        format: 'L'
    });


    //Date picker
    $('#idSampaiTanggal').datetimepicker({
        format: 'L'
    });
  })

</script>