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

        <!-- Profile Image -->
            <div class="card card-primary card-outline">
            <div class="card-header">
              <h3 class="card-title">
                Informasi Pengguna
              </h3>
            </div>
              <div class="card-body box-profile">
	            <div class="form-group row">
			  		<label class="col-sm-3 col-form-label">Nama</label>
						<div class="col-sm-9">
	                		${piutangForm.getFullname()}
	                	</div>
	         	</div>
	            <div class="form-group row">
			  		<label class="col-sm-3 col-form-label">Total Hutang</label>
						<div class="col-sm-9">
	                		<fmt:formatNumber value = "${piutangForm.getHutang()}" type = "currency" minFractionDigits="0"/>
	                	</div>
	         	</div>
                
                
              </div>
              
              
              <!-- /.card-body -->
            </div>

        <!-- /.card -->
      
<!-- Default box -->
		<form:form method="POST" modelAttribute="piutangForm">
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
                      <div class="form-group row">
	                  <label class="col-sm-3 col-form-label">Jenis Transaksi</label>
							<div class="col-sm-9">
		                        <div class="custom-control custom-radio">
		                          <form:radiobutton value="bayar" class="custom-control-input" id="idInputJenisTrx1" path="jenisTransaksi" name="jenisTransaksi"/>
		                          <label for="idInputJenisTrx1" class="custom-control-label">Pembayaran</label>
		                        </div>
		                        <div class="custom-control custom-radio">
		                          <form:radiobutton value="pinjam" class="custom-control-input" id="idInputJenisTrx2" path="jenisTransaksi" name="jenisTransaksi"/>
		                          <label for="idInputJenisTrx2" class="custom-control-label">Peminjaman</label>
		                        </div>
                        	</div>
                      </div>
                
                
	            <div class="form-group row">
			  		<label for="idInputJumlah" class="col-sm-3 col-form-label">Jumlah</label>
						<div class="col-sm-9">
	                		<form:input type="text" path="amount" id="idInputJumlah" name="amount" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Jumlah bayar/pinjam"></form:input>
	                	<span class="invalid-feedback">
	                		<form:errors path="amount"></form:errors></span>
	                	</div>
	         	</div>
	            <div class="form-group row">
			  		<label class="col-sm-3 col-form-label" for="idInputKeterangan">Keterangan</label>
					<div class="col-sm-9">
	                	<form:textarea type="text" path="keterangan" id="idInputKeterangan" class="form-control" rows="3" name="keterangan" placeholder="Keterangan"></form:textarea>
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