<%@ page import="com.aldroid.hormid.model.transaksi.Harga" %>
<%@ page import="com.aldroid.hormid.generic.process.CommonParsing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/kasir" var="kasirURL" />
<fmt:setLocale value = "in_ID"/>
<section class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
      
<!-- Default box -->
		<form:form method="POST" modelAttribute="gantungForm">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Transaksi</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body">			
				
				      <spring:bind path="username">  
		                <div class="form-group row">
		                  <label class="col-sm-3 col-form-label" for="idInputUsername">Petani</label>
							<div class="col-sm-9">
			                  <form:select items="${newPetaniMap}"  class="select2" id="idInputUsername" data-placeholder="Pilih Petani" style="width: 100%;" name="username" path="username">
			                  </form:select>
			                  <span class="invalid-feedback">
				              <form:errors path="username"></form:errors></span>
				            </div>
		                </div>
                		</spring:bind>
                			
	            <div class="form-group row">
			  		<label for="idInputBruto" class="col-sm-3 col-form-label">Berat Kotor</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="bruto" id="idInputBruto" name="bruto" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Berat kotor"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="bruto"></form:errors></span>
	                	</div>
	         	</div>
	            <div class="form-group row">
			  		<label for="idInputPotongan" class="col-sm-3 col-form-label">% Refraksi</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="potongan" id="idInputPotongan" name="potongan" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Persentase potongan berat"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="potongan"></form:errors></span>
	                	</div>
	         	</div>	
                
	            <div class="form-group row">
			  		<label for="idInputHarga" class="col-sm-3 col-form-label">Harga</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="harga" id="idInputHarga" name="harga" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Harga sawit/kg"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="harga"></form:errors></span>
	                	</div>
	         	</div>
	            <div class="form-group row">
			  		<label class="col-sm-3 col-form-label" for="idInputCatatan">Catatan</label>
					<div class="col-sm-9">
	                	<form:textarea type="text" path="catatan" id="idInputCatatan" class="form-control" rows="3" name="catatan" placeholder="Catatan"></form:textarea>
	                </div>
	         	</div>
		            
					<div class="form-group row">
						<div class="offset-sm-3 col-sm-9">
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
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->
  </div><!-- /.container-fluid -->
</section>