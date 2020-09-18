<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
		<div class="col-md-12">
		<form:form method="POST" modelAttribute="propertiesForm">
	      <div class="card  card-default">
	        <div class="card-header">
                <h5 class="card-title">Ubah Pengaturan</h5>
	          <div class="card-tools">
	            <button type="button" class="btn btn-tool" data-card-widget="collapse">
	              <i class="fas fa-minus"></i>
	            </button>
	          </div>
	        </div>
	        <!-- /.card-header -->
	        <div class="card-body">

	            <div class="form-group">
			  		<label for="idInputCode">Kode</label>
					<form:input type="text" path="code" id="idInputCode" class="form-control" placeholder="Masukkan kode pengaturan" disabled="true"></form:input>
	            </div>
	            <div class="form-group">
			  		<label for="idInputData">Tipe Data</label>
				  	<form:input type="text" path="tipeData" id="idInputData" class="form-control" placeholder="Masukkan Tipe Data" disabled="true" value="${propertiesForm.tipeData}"></form:input>
	            </div>

	            <div class="form-group">
			  		<label for="idInputDescription">Deskripsi</label>
	                <form:textarea type="text" path="propertyDesc" id="idInputDescription" class="form-control" rows="3" placeholder="Masukkan deskripsi pengaturan" disabled="true"></form:textarea>
	         	</div>

		        <spring:bind path="value">
		            <div class="form-group">
				  		<label for="idInputValue">Nilai</label>
		                <form:textarea type="text" path="value" id="idInputValue" class="form-control  ${status.error ? 'is-invalid' : ''}" rows="3" placeholder="Masukkan nilai pengaturan"></form:textarea>
		                <span class="invalid-feedback">
		                <form:errors path="value"></form:errors></span>
		         	</div>
		        </spring:bind>

	          <!-- /.row -->
	        </div>
	        <!-- ./card-body -->
	        
	        <!-- ./card-body -->
	          <div class="card-footer">
	          	<input type="hidden" name="propertyDesc" value="${propertiesForm.propertyDesc}"></input>
	          	<input type="hidden" name="tipeData" value="${propertiesForm.tipeData}"></input>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	            <button type="submit" class="btn btn-primary">Simpan</button>
	          </div>
	        </div>
    	</form:form>
	   </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    