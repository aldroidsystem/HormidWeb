<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <spring:url value="/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" var="dataTableCss" />
  <link rel="stylesheet" href="${dataTableCss}">
  <spring:url value="/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css" var="dataTableRespCss" />
  <link rel="stylesheet" href="${dataTableRespCss}">