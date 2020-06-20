<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Log in with your user</title>

<style>


html, body { height: 100%; }
body {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  position: relative;
}

.login-form {
  width: 450px;
  padding: 2em;
  position: relative;
}
</style>
  <link rel="stylesheet" href="resources/dist/css/adminlte.min.css">
</head>
<body>

	<div class="login-form">
		<div class="card card-primary card-outline">
		  <div class="card-header">
		    <h2 class="form-heading">
		      <i class="fas fa-edit"></i>
		      Login
		    </h2>
		  </div>
		    <form method="POST" action="login" role="form" id="quickForm" class="form-horizontal">
        	<div class="form-group ${error != null ? 'has-error' : ''}">
	            <span>${message}</span>
			     <div class="card-body">
			       <div class="form-group row">
						<div class="col-sm-3">
			         		<label for="exampleInputEmail1">Username</label>
						</div>
						<div class="col-sm-9">
						  <input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Username">
						</div>
			       </div>
			       <div class="form-group row">
					<div class="col-sm-3">
			         	<label for="exampleInputPassword1">Password</label>
					</div>
					<div class="col-sm-9">
					  <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" width="300px">
					</div>
			       </div>
			       <div class="form-group row">
			         <div class="offset-sm-3 col-sm-9">
			           <div class="form-check">
			             <input type="checkbox" class="form-check-input" id="exampleCheck1">
			             <label class="form-check-label" for="exampleCheck2">Remember me</label>
			           </div>
			         </div>
			       </div>
	            	<span>${error}</span>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="card-footer">
					  <button type="submit" class="btn btn-primary">Sign in</button>
					</div>
        	</div>
		   </form>
		</div>

</div>

<!-- jQuery -->
<script src="resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jquery-validation -->
<script src="resources/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="resources/plugins/jquery-validation/additional-methods.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>
<script type="text/javascript">
$(document).ready(function () {
  $('#quickForm').validate({
    rules: {
      username: {
        required: true
      },
      password: {
        required: true,
        minlength: 5
      }
    },
    messages: {
      username: {
        required: "Please enter the username",
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