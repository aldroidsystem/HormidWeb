<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
		<div class="col-md-12">
		<form:form method="POST" modelAttribute="userForm">
	      <div class="card  card-default">
	        <div class="card-header">
				<c:choose>
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()==''}">
                		<h5 class="card-title">Buat Pengguna</h5>
					</c:when>    
					<c:otherwise>
                		<h5 class="card-title">Ubah Pengguna</h5>
					</c:otherwise>
				</c:choose>	
                
	          <div class="card-tools">
	            <button type="button" class="btn btn-tool" data-card-widget="collapse">
	              <i class="fas fa-minus"></i>
	            </button>
	          </div>
	        </div>
	        <!-- /.card-header -->
	        <div class="card-body">
	          <div class="row">
	              <div class="col-md-6">
				        <spring:bind path="username">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputUsername">Kode Pengguna</label>
								<c:choose>
									<c:when test="${userForm.getUsername()==null || userForm.getUsername()==''}">
				                		<form:input type="text" path="username" id="idInputUsername" name="username" class="form-control" placeholder="Masukkan kode pengguna"></form:input>
									</c:when>    
									<c:otherwise>
				                		<form:input type="text" path="username" id="idInputUsername" name="username" class="form-control" placeholder="Masukkan kode pengguna" disabled="true"></form:input>
									</c:otherwise>
								</c:choose>	
				                <form:errors path="username"></form:errors>
				            </div>
				        </spring:bind>
	              </div>
	              <div class="col-md-6">
				        <spring:bind path="fullname">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputFullname">Nama Lengkap</label>
				                <form:input type="text" path="fullname" id="idInputFullname" name="fullname" class="form-control" placeholder="Masukkan nama pengguna"></form:input>
				                <form:errors path="fullname"></form:errors>
				         	</div>
				        </spring:bind>
	              </div>
	          </div>
	          <div class="row">
	              <div class="col-md-6">
				        <spring:bind path="phone">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputUsername">Telepon</label>
								<form:input type="text" path="phone" id="idInputPhone" name="phone" class="form-control" placeholder="Masukkan nomor telepon"></form:input>
				                <form:errors path="phone"></form:errors>
				            </div>
				        </spring:bind>
	              </div>
	              <div class="col-md-6">
				        <spring:bind path="email">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputFullname">Email</label>
				                <form:input type="text" path="email" id="idInputEmail" name="email" class="form-control" placeholder="Masukkan email"></form:input>
				                <form:errors path="email"></form:errors>
				         	</div>
				        </spring:bind>
	              </div>
	          </div>
	          <div class="row">
	              <div class="col-md-6">
				        <spring:bind path="area">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputDataType">Area</label>				  		
 								<form:select path="area" id="idInputArea" class="custom-select" name="area">
									<c:forEach items="${properties_village}" var="village">
								  		<option>${village}</option>
									</c:forEach>
								</form:select>
				                <form:errors path="area"></form:errors>
				            </div>
				        </spring:bind>
	              </div>
	              <div class="col-md-6">
				        <spring:bind path="roles">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputPeranan">Peranan</label>	
				                  <%-- <form:select class="select2" id="idInputPeranan" multiple="multiple" data-placeholder="Pilih Peranan" style="width: 100%;" name="roles" path="roles">
									<c:forEach items="${properties_roles}" var="role">
								  		<option value="${role.getCode()}">${role.getName()}</option>
									</c:forEach>
				                  </form:select> --%>
				                  <form:select items="${properties_rolemap}"  class="select2" id="idInputPeranan" multiple="multiple" data-placeholder="Pilih Peranan" style="width: 100%;" name="roles" path="roles">
				                  </form:select>
				                <form:errors path="roles"></form:errors>
				            </div>
				        </spring:bind>
	              </div>
	          </div>
	          <div class="row">
	              <div class="col-md-6">
				        <spring:bind path="passwordExpiryPeriod">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputPwdExpiry">Periode Ubah Kata Kunci</label>
				                <form:input type="text" path="passwordExpiryPeriod" id="idInputPwdExpiry" name="passwordExpiryPeriod" class="form-control" placeholder="Masukkan periode"></form:input>
					            <form:errors path="passwordExpiryPeriod"></form:errors>
				            </div>
				        </spring:bind>
	              </div>
	              <div class="col-md-3">
				        <spring:bind path="flagActive">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
	                      		<label for="fieldFlagActive">Aktifkan Pengguna</label>
				            	<div class="custom-switch" id="fieldFlagActive">
									<c:choose>
										<c:when test="${propertiesForm.getFlagActive()=='1'}">
					                		<input type="checkbox" id="idInputflagActive" name="flagActive" class="custom-control-input" value="1" checked="true"></input>
										</c:when>    
										<c:otherwise>
					                		<input type="checkbox" id="idInputflagActive" name="flagActive" class="custom-control-input" value="1"></input>
										</c:otherwise>
									</c:choose>	
	                      			<label class="custom-control-label" for="idInputflagActive"></label>
					                <form:errors path="flagActive"></form:errors>
				            	</div>
				         	</div>
				        </spring:bind>
	              </div>
	              <div class="col-md-3">
				        <spring:bind path="flagNeverDisable">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
	                      		<label for="fieldFlagNeverDisable">Jangan di Non-Aktifkan</label>
				            	<div class="custom-switch" id="fieldFlagNeverDisable">
					                <input type="checkbox" id="idInputflagNeverDisable" name="flagNeverDisable" class="custom-control-input" value="1"></input>
	                      			<label class="custom-control-label" for="idInputflagNeverDisable"></label>
					                <form:errors path="flagNeverDisable"></form:errors>
				            	</div>
				         	</div>
				        </spring:bind>
	              </div>
	          </div>
	          <div class="row">
	              <div class="col-md-6">
				        <spring:bind path="address">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
						  		<label for="idInputDescription">Alamat</label>
				                <form:textarea type="text" path="address" id="idInputAddress" class="form-control" rows="3" name="address" placeholder="Masukkan alamat pengguna"></form:textarea>
				                <form:errors path="address"></form:errors>
				         	</div>
				        </spring:bind>
	              </div>
	          </div>
	          <!-- /.row -->
	        </div>
	        <!-- ./card-body -->
	        
	        <!-- ./card-body -->
	          <div class="card-footer">
				<c:choose>
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()==''}">
                		<input type="hidden" name="action" value="c"/>
					</c:when>    
					<c:otherwise>
                		<input type="hidden" name="action" value="u"/>
					</c:otherwise>
				</c:choose>	
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	            <button type="submit" class="btn btn-primary">Simpan</button>
	          </div>
	        </div>
    	</form:form>
	        <!-- /.card-footer -->
	   </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    
<spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script>
<script type="text/javascript">
$(document).ready(function () {	
  $('#quickForm').validate({
    rules: {
    	code: {
        required: true
      },
      value: {
        required: true
      }
    },
    messages: {
      username: {
        required: "Kolom 'kode' tidak boleh kosong",
      },
      value: {
        required: "Kolom 'nilai' tidak boleh kosong"
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