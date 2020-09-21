<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
		<div class="col-md-12">
		<form:form method="POST" modelAttribute="supirForm">
	      <div class="card  card-default">
	        <div class="card-header">
				<c:choose>
					<c:when test="${supirForm.getUsername()==null || supirForm.getUsername()=='' ||  supirForm.getAction()=='c'}">
                		<h5 class="card-title">Tambah Supir</h5>
					</c:when>    
					<c:otherwise>
                		<h5 class="card-title">Ubah Supir</h5>
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
				<c:choose>
					<c:when test="${supirForm.getUsername()==null || supirForm.getUsername()=='' ||  supirForm.getAction()=='c'}">

				      <spring:bind path="username">  
		                <div class="form-group">
		                  <label for="idInputUsername">Pengguna</label>
		                  <form:select items="${newSupirMap}"  class="select2" id="idInputUsername" data-placeholder="Pilih Pengguna" style="width: 100%;" name="username" path="username">
		                  </form:select>
		                  <span class="invalid-feedback">
				                <form:errors path="username"></form:errors></span>
		                </div>
                		</spring:bind>
					</c:when>    
					<c:otherwise>						
						<div class="form-group">
					  		<label for="idInputUsername">Kode Pengguna</label>
			                <form:input type="text" path="username" id="idInputUsername" name="username" class="form-control" disabled="true"></form:input>
			         	</div>
					</c:otherwise>
				</c:choose>	
		        
		        <spring:bind path="roles">
		            <div class="form-group ${status.error ? 'has-error' : ''}">
				  		<label for="idInputPeranan">Kendaraan</label>	
		                  <form:select  items="${listVehicle}"  class="select2" id="idInputPeranan" multiple="multiple" data-placeholder="Pilih Peranan" style="width: 100%;" name="listVehicleId" path="listVehicleId">
		                  </form:select>
		                <form:errors path="roles"></form:errors>
		            </div>
		        </spring:bind>
		        
	            <div class="form-group">
			  		<label for="idInputCatatan">Catatan</label>
	                <form:textarea type="text" path="catatan" id="idInputCatatan" class="form-control" rows="3" name="catatan" placeholder="Catatan supir"></form:textarea>
	         	</div>
		        	
	        
	        <!-- ./card-body -->
	          <div class="card-footer">
				<c:choose>
					<c:when test="${supirForm.getUsername()==null || supirForm.getUsername()==''}">
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
  $('#supirForm').validate({
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

