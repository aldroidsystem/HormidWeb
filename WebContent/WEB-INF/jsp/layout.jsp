<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title><tiles:insertAttribute name="title" ignore="true" /> - Horas Miduk</title>

  <!-- Font Awesome Icons -->
  <spring:url value="/resources/plugins/fontawesome-free/css/all.min.css" var="allMinCss" />
  <link rel="stylesheet" href="${allMinCss}">
  <!-- overlayScrollbars -->
  <spring:url value="/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" var="overlayCss" />
  <link rel="stylesheet" href="${overlayCss}">
  <!-- Theme style -->
  <spring:url value="/resources/dist/css/adminlte.min.css" var="adminCss" />
  <link rel="stylesheet" href="${adminCss}">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
	  <!-- Navbar -->
	  <nav class="main-header navbar navbar-expand navbar-dark">
		<tiles:insertAttribute name="header" />
	  </nav>
	  <!-- /.navbar -->
	
	  <!-- Main Sidebar Container -->
	  <aside class="main-sidebar sidebar-light-warning elevation-4">
		<tiles:insertAttribute name="sidebar" />
	  </aside>
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <div class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1 class="m-0 text-dark"><tiles:insertAttribute name="title" ignore="true" /></h1>
	          </div><!-- /.col -->
				<tiles:insertAttribute name="breadcrumb" />
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div>
	    <!-- /.content-header -->
	
	    <!-- Main content -->
	    <section class="content">
			<tiles:insertAttribute name="body" />
	    </section>
	    <!-- /.content -->
	  </div>
	  <!-- /.content-wrapper -->
	
	  <!-- Control Sidebar -->
	  <aside class="control-sidebar control-sidebar-dark">
	    <!-- Control sidebar content goes here -->
	  </aside>
	  <!-- /.control-sidebar -->
	
	  <!-- Main Footer -->
	  <footer class="main-footer">
		<tiles:insertAttribute name="footer" />
	  </footer>
	</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<spring:url value="/resources/plugins/jquery/jquery.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
<!-- Bootstrap -->
<spring:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJs" />
<script src="${bootstrapJs}"></script>
<!-- overlayScrollbars -->
<spring:url value="/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js" var="overlayJs" />
<script src="${overlayJs}"></script>
<!-- AdminLTE App -->
<spring:url value="/resources/dist/js/adminlte.js" var="adminLteJs" />
<script src="${adminLteJs}"></script>
<!-- OPTIONAL SCRIPTS -->
<spring:url value="/resources/dist/js/demo.js" var="demoJs" />
<script src="${demoJs}"></script>

<!-- PAGE PLUGINS -->
<!-- jQuery Mapael -->
<spring:url value="/resources/plugins/jquery-mousewheel/jquery.mousewheel.js" var="mouseWheelJs" />
<script src="${mouseWheelJs}"></script>
<spring:url value="/resources/plugins/raphael/raphael.min.js" var="raphaelJs" />
<script src="${raphaelJs}"></script>
<spring:url value="/resources/plugins/jquery-mapael/jquery.mapael.min.js" var="mapaelJs" />
<script src="${mapaelJs}"></script>
<spring:url value="/resources/plugins/jquery-mapael/maps/usa_states.min.js" var="usaJs" />
<script src="${usaJs}"></script>
<!-- ChartJS -->
<spring:url value="/resources/plugins/chart.js/Chart.min.js" var="chartJs" />
<script src="${chartJs}"></script>
<!-- PAGE SCRIPTS -->
<spring:url value="/resources/dist/js/pages/dashboard2.js" var="dashboardJs" />
<script src="${dashboardJs}"></script>
</body>
</html>