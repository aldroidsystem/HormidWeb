<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.security.web.WebAttributes" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Horas Miduk | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">


  <!-- Font Awesome Icons -->
  <spring:url value="/resources/plugins/fontawesome-free/css/all.min.css" var="allMinCss" />
  <link rel="stylesheet" href="${allMinCss}">
  <!-- Ionicons
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
   -->
  <!-- icheck bootstrap -->
  <spring:url value="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css" var="icheckCss" />
  <link rel="stylesheet" href="${icheckCss}">
  <!-- Theme style -->
  <spring:url value="/resources/dist/css/adminlte.min.css" var="adminCss" />
  <link rel="stylesheet" href="${adminCss}">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b>Horas</b>Miduk
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sila masuk untuk memulai</p>

      <form method="POST" action="login" role="form" id="quickForm" class="form-horizontal">
		<div class="form-group ${error != null ? 'has-error' : ''}">
			<span>${message}</span>
			<div class="input-group mb-3 form-group  row">
			  <input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Kode Pengguna">
			  <div class="input-group-append">
				<div class="input-group-text">
				  <span class="fas fa-user"></span>
				</div>
			  </div>
			</div>
			<div class="input-group mb-3 form-group  row">
			  <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Kata Kunci">
			  <div class="input-group-append">
				<div class="input-group-text">
				  <span class="fas fa-lock"></span>
				</div>
			  </div>
			</div>
			
			<c:choose>
				<c:when test="${error != null && SPRING_SECURITY_LAST_EXCEPTION != null}">
	                <div class="alert alert-danger alert-dismissible">
	                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	                  ${SPRING_SECURITY_LAST_EXCEPTION}
	                </div>
				</c:when>  
			</c:choose>	
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="row">
			  <div class="col-8">
				<div class="icheck-primary">
				  <input type="checkbox" id="remember">
				  <label for="remember">
					Ingat Pengguna
				  </label>
				</div>
			  </div>
			  <!-- /.col -->
			  <div class="col-4">
				<button type="submit" class="btn btn-primary btn-block">Masuk</button>
			  </div>
			  <!-- /.col -->
			</div>
		</div>
      </form>

      <p class="mb-1">
        <a href="forgot-password.html">Saya lupa kata kunci</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<spring:url value="/resources/plugins/jquery/jquery.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
<!-- Bootstrap 4 -->
<spring:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJs" />
<script src="${bootstrapJs}"></script>
<!-- AdminLTE App -->
<spring:url value="/resources/dist/js/adminlte.js" var="adminLteJs" />
<script src="${adminLteJs}"></script>


<spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script>
<script type="text/javascript">
$(document).ready(function () {
  $('#quickForm').validate({
    rules: {
      username: {
        required: true
      },
      password: {
        required: true,
        minlength: 6
      }
    },
    messages: {
      username: {
        required: "Please enter your username",
      },
      password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
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
</body>
</html>
