<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
		<div class="col-md-12">
		<form:form method="POST" modelAttribute="vehicleForm">
	      <div class="card  card-default">
	        <div class="card-header">
				<c:choose>
					<c:when test="${vehicleForm.getVehicleId()==null ||  vehicleForm.getAction()=='c'}">
                		<h5 class="card-title">Tambah Kendaraan</h5>
					</c:when>    
					<c:otherwise>
                		<h5 class="card-title">Ubah Kendaraan</h5>
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
  				<spring:bind path="plateNumber"> 	
					<div class="form-group">
				  		<label for="idInputPlateNumber">Nomor Polisi</label>
		                <form:input type="text" path="plateNumber" id="idInputPlateNumber" name="plateNumber" class="form-control   ${status.error ? 'is-invalid' : ''}" data-placeholder="Nomor polisi kendaraan"></form:input>
		                <span class="invalid-feedback">
			            <form:errors path="plateNumber"></form:errors></span>
		            </div>
           		</spring:bind>
		      	<spring:bind path="vehicleType">  
	                <div class="form-group">
	                  <label for="idInputVehicleType">Jenis Kendaraan</label>
	                  <form:select items="${listVehicleType}"  class="select2" id="idInputVehicleType" data-placeholder="Jenis Kendaraan" style="width: 100%;" name="vehicleType" path="vehicleType">
	                  </form:select>
	                  <span class="invalid-feedback">
			                <form:errors path="vehicleType"></form:errors></span>
	                </div>
           		</spring:bind>
  				<spring:bind path="defaultBiayaBongkar"> 	
					<div class="form-group">
				  		<label for="idInputBiayaBongkar">Biaya Bongkar</label>
		                <form:input type="text" path="defaultBiayaBongkar" id="idInputBiayaBongkar" name="defaultBiayaBongkar" class="form-control ${status.error ? 'is-invalid' : ''}" data-placeholder="Biaya bongkar otomatis"></form:input>
		                <span class="invalid-feedback">
			            <form:errors path="defaultBiayaBongkar"></form:errors></span>
		            </div>
           		</spring:bind>
		        <spring:bind path="listSupirUsername">
		            <div class="form-group">
				  		<label for="idInputPeranan">Supir</label>	
		                  <form:select  items="${listSupirMap}"  class="select2" id="idInputSupir" multiple="multiple" data-placeholder="Pilih Supir" style="width: 100%;" name="listSupirUsername" path="listSupirUsername">
		                  </form:select>
		                <form:errors path="listSupirUsername"></form:errors>
		            </div>
		        </spring:bind>
	            <div class="form-group">
                   <label for="fieldFlagHormid">Properti Lapak Hormid</label>
                   <div class="custom-switch" id="fieldFlagHormid">
					<c:choose>
						<c:when test="${vehicleForm.getFlagHormid()==1}">
	                		<input type="checkbox" id="idInputflagHormid" name="flagHormid" class="custom-control-input" value="1" checked></input>
						</c:when>    
						<c:otherwise>
	                		<input type="checkbox" id="idInputflagHormid" name="flagHormid" class="custom-control-input" value="1"></input>
						</c:otherwise>
					</c:choose>	
                   	<label class="custom-control-label" for="idInputflagHormid"></label>
            	</div>
	         	<br/>
	         	</div>
	            <div class="form-group">
			  		<label for="idInputCatatan">Catatan</label>
	                <form:textarea type="text" path="catatan" id="idInputCatatan" class="form-control" rows="3" name="catatan" placeholder="Catatan supir"></form:textarea>
	         	</div>
	        
	        <!-- ./card-body -->
	          <div class="card-footer">
				<c:choose>
					<c:when test="${vehicleForm.getVehicleId()==null || vehicleForm.getVehicleId()==''}">
                		<input type="hidden" name="action" value="c"/>
					</c:when>    
					<c:otherwise>
                		<input type="hidden" name="action" value="u"/>
					</c:otherwise>
				</c:choose>	
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="hidden" name="vehicleId" value="${vehicleForm.getVehicleId()}"/>
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