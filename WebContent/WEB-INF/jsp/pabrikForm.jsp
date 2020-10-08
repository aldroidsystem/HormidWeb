<%@ page import="com.aldroid.hormid.model.transaksi.Harga" %>
<%@ page import="com.aldroid.hormid.generic.process.CommonParsing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/kasir" var="kasirURL" />
<fmt:setLocale value = "in_ID"/>
<section class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
      
<!-- Default box -->
		<form:form method="POST" modelAttribute="pabrikForm">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Pabrik Sawit</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body">			
					
	            <div class="form-group row">
			  		<label for="idInputNamaPerusahaan" class="col-sm-3 col-form-label">Nama Perusahaan</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="namaPerusahaan" id="idInputNamaPerusahaan" name="namaPerusahaan" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Nama Perusahaan"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="namaPerusahaan"></form:errors></span>
	                	</div>
	         	</div>
                			
	            <div class="form-group row">
			  		<label for="idInputUangJalanTruk" class="col-sm-3 col-form-label">Uang Jalan Truk</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="uangJalanTruk" id="idInputUangJalanTruk" name="uangJalanTruk" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Uang jalan mobil truk"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="uangJalanTruk"></form:errors></span>
	                	</div>
	         	</div>
	            <div class="form-group row">
			  		<label for="idInputBiayaTruk" class="col-sm-3 col-form-label">Biaya Mobil Truk</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="biayaMobilTruk" id="idInputBiayaTruk" name="biayaMobilTruk" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Biaya mobil truk per-kg"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="biayaMobilTruk"></form:errors></span>
	                	</div>
	         	</div>	
                			
	            <div class="form-group row">
			  		<label for="idInputUangJalanTronton" class="col-sm-3 col-form-label">Uang Jalan Tronton</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="uangJalanTronton" id="idInputUangJalanTronton" name="uangJalanTronton" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Uang jalan mobil tronton"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="uangJalanTronton"></form:errors></span>
	                	</div>
	         	</div>
	            <div class="form-group row">
			  		<label for="idInputBiayaTronton" class="col-sm-3 col-form-label">Biaya Mobil Tronton</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="biayaMobilTronton" id="idInputBiayaTronton" name="biayaMobilTronton" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Biaya mobil tronton per-kg"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="biayaMobilTronton"></form:errors></span>
	                	</div>
	         	</div>	
	            <div class="form-group row">
			  		<label class="col-sm-3 col-form-label" for="idInputCatatan">Catatan</label>
					<div class="col-sm-9">
	                	<form:textarea type="text" path="catatan" id="idInputCatatan" class="form-control" rows="3" name="catatan" placeholder="Catatan"></form:textarea>
	                </div>
	         	</div>
	         	<c:choose>
					<c:when test="${pabrikForm.getPabrikId() != null && pabrikForm.getPabrikId() > 0}">
						<input type="hidden" name="pabrikId" value="${pabrikForm.getPabrikId() }"/>
					</c:when>
				</c:choose>
		            
					<div class="form-group row">
						<div class="offset-sm-3 col-sm-9">
							<button type="submit" class="btn btn-danger">Simpan</button>
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