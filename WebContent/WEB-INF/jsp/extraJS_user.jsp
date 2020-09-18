<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- DataTables -->
<spring:url value="/resources/plugins/datatables/jquery.dataTables.min.js" var="dataTablesJs" />
<script src="${dataTablesJs}"></script>
<spring:url value="/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js" var="dataTablesBootJs" />
<script src="${dataTablesBootJs}"></script>
<spring:url value="/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js" var="respJs" />
<script src="${respJs}"></script>
<spring:url value="/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js" var="respBootJs" />
<script src="${respBootJs}"></script>
