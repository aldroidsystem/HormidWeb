<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main content -->
<section class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-3">

        <!-- Profile Image -->
        <div class="card card-primary card-outline">
          <div class="card-body box-profile">
            <div class="text-center">
				<spring:url value="/resources/icon/user64.png" var="userJpg" />
            	<img class="profile-user-img img-fluid img-circle" src="${userJpg}" alt="User profile picture">
            </div>

            <h3 class="profile-username text-center">${userForm.getFullname()}</h3>

            <p class="text-muted text-center">
	            <c:forEach items="${userForm.getRoles()}" var="role">
					<span class="badge bg-info"><spring:message code='${role}' /> </span>
				</c:forEach>
            </p>
          </div>
          <!-- /.card-body -->
        </div>

        <!-- /.card -->
      </div>
      <!-- /.col -->
      <div class="col-md-9">
      
<!-- Default box -->
		<form:form method="POST" action="profileUpdate" modelAttribute="userForm">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Informasi</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body">
					<div class="form-group row">
						<label for="idInputUsername" class="col-sm-2 col-form-label">Kode Pengguna</label>
						<div class="col-sm-10">
		           			<input type="hidden" name="username" value="${userForm.getUsername()}"/>
							<form:input type="text" path="username" id="idInputUsername" name="username" class="form-control" disabled="true"></form:input>
						</div>
					</div>
		            <div class="form-group row">
				  		<label for="idInputFullname" class="col-sm-2 col-form-label">Nama</label>
							<div class="col-sm-10">
		                		<form:input type="text" path="fullname" id="idInputFullname" name="fullname" class="form-control" placeholder="Masukkan nama pengguna"></form:input>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputUsername" class="col-sm-2 col-form-label">Telepon</label>
							<div class="col-sm-10">
								<form:input type="text" path="phone" id="idInputPhone" name="phone" class="form-control" placeholder="Masukkan nomor telepon"></form:input>
		                	</div>
		            </div>
		            <div class="form-group row">
				  		<label for="idInputFullname" class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
				                <form:input type="text" path="email" id="idInputEmail" name="email" class="form-control" placeholder="Masukkan email"></form:input>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputDataType" class="col-sm-2 col-form-label">Area</label>	
							<div class="col-sm-10">
				                <form:select items="${properties_village}"  class="custom-select" id="idInputArea" data-placeholder="Pilih area" name="area" path="area">
				                </form:select>
		                	</div>
		                <form:errors path="area"></form:errors>
		            </div>
						
		            <div class="form-group row">
				  		<label for="idInputDescription" class="col-sm-2 col-form-label">Alamat</label>
							<div class="col-sm-10">
				                <form:textarea type="text" path="address" id="idInputAddress" class="form-control" rows="3" name="address" placeholder="Masukkan alamat pengguna"></form:textarea>
							</div>
		         	</div>
		         	
					<div class="form-group row">
						<div class="offset-sm-2 col-sm-10">
							<button type="submit" class="btn btn-danger">Submit</button>
						</div>
					</div>
				</div>
				<!-- /.card-body -->
				<div class="card-footer">
				</div>
			</div>
		</form:form>
		<!-- /.card -->
  
  
        <!-- Default box -->
		<form:form class="form-horizontal" action="resetPassword" method="POST" modelAttribute="passwordForm">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Ubah Kata Kunci</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body">
		           	<input type="hidden" name="username" value="${userForm.getUsername()}"/>
					<spring:bind path="password">
						<div class="form-group row">
							<label for="idInputPassword1" class="col-sm-2 col-form-label">Kata
								Kunci</label>
							<div class="col-sm-10">
								<input type="password" name="password" class="form-control ${status.error ? is-invalid: ''}"
									id="idInputPassword1" placeholder="Kata Kunci">
								<span class="invalid-feedback">
			                	<form:errors path="password"></form:errors></span>
							</div>
						</div>
					</spring:bind>
					
		
					<spring:bind path="passwordConfirm">
						<div class="form-group row">
							<label for="idInputPassword2" class="col-sm-2 col-form-label">Konfirmasi
								Kata Kunci</label>
							<div class="col-sm-10">
								<input type="password" name="passwordConfirm"
									class="form-control ${status.error ? 'is-invalid' : ''}" id="idInputPassword2"
									placeholder="Konfirmasi Kata Kunci">
								<span class="invalid-feedback">
			                	<form:errors path="passwordConfirm"></form:errors></span>
							</div>
						</div>
					</spring:bind>
					<div class="form-group row">
						<div class="offset-sm-2 col-sm-10">
							<button type="submit" class="btn btn-danger">Submit</button>
						</div>
					</div>
				</div>
				<!-- /.card-body -->
				<div class="card-footer">
				</div>
				<!-- /.card-footer-->
			</div>
		</form:form>
		<!-- /.card -->
  
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->
  </div><!-- /.container-fluid -->
</section>
<!-- /.content -->