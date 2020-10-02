<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
		<div class="col-md-12">
		<form:form method="POST" modelAttribute="agenForm">
	      <div class="card  card-default">
	        <div class="card-header">
	       		<h5 class="card-title">Ubah Agen</h5>                
	          <div class="card-tools">
	            <button type="button" class="btn btn-tool" data-card-widget="collapse">
	              <i class="fas fa-minus"></i>
	            </button>
	          </div>
	        </div>
	        <!-- /.card-header -->
	        <div class="card-body">					
				<div class="form-group">
			  		<label for="idInputUsername">Kode Pengguna</label>
	                <form:input type="text" path="username" id="idInputUsername" name="username" class="form-control" disabled="true"></form:input>
	         	</div>
  				<spring:bind path="defaultPotongan"> 	
					<div class="form-group">
				  		<label for="idInputPotongan">Potongan</label>
		                <form:input type="text" path="defaultPotongan" id="idInputPotongan" name="defaultPotongan" class="form-control  ${status.error ? 'is-invalid' : ''}" data-placeholder="Potongan persen otomatis"></form:input>
		                <span class="invalid-feedback">
			            <form:errors path="defaultPotongan"></form:errors></span>
		            </div>
           		</spring:bind>
		        
	            <div class="form-group">
			  		<label for="idInputPeranan">Kendaraan</label>	
	                  <form:select  items="${listVehicle}"  class="select2" id="idInputPeranan" multiple="multiple" data-placeholder="Pilih Peranan" style="width: 100%;" name="listVehicleId" path="listVehicleId">
	                  </form:select>
	            </div>
		        
                <div class="form-group">
                  <label for="idInputPetani">Petani</label>
                  <form:select items="${listPetani}" class="duallistbox" multiple="multiple" id="idInputPetani" name="listPetaniUsername" path="listPetaniUsername">
                  </form:select>
                </div>
		        
	            <div class="form-group">
			  		<label for="idInputCatatan">Catatan</label>
	                <form:textarea type="text" path="catatan" id="idInputCatatan" class="form-control" rows="3" name="catatan" placeholder="Catatan agen"></form:textarea>
	         	</div>
	        
	        <!-- ./card-body -->
	          <div class="card-footer">
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
