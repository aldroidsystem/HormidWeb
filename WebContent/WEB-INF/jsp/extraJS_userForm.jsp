<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

  <spring:url value="/resources/plugins/select2/js/select2.full.min.js" var="select2Jss" />
  <script src="${select2Jss}"></script>
  <script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()
  })
  </script>
  