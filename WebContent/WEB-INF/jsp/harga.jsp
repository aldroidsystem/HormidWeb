<%@ page import="com.aldroid.hormid.model.lapak.Harga" %>
<%@ page import="com.aldroid.hormid.generic.process.CommonParsing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<section class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-3">

        <!-- Profile Image -->
            <div class="card card-primary card-outline">
              <div class="card-body box-profile">
                <h3 class="profile-username text-center">Harga Sawit</h3>

                <p class="text-muted text-center">Per - <fmt:formatDate value="${hargaSekarang.getTanggalMulai()}" type="date" pattern="dd/MM/yyyy"/></p>

                <ul class="list-group list-group-unbordered mb-3">
                  <li class="list-group-item">
                    <b>Harga Jual</b> <a class="float-right">${hargaSekarang.getHargaJual()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Harga Lapak Jembatan</b> <a class="float-right">${hargaSekarang.getHargaBeliJembatan()}</a>
                  </li>
                  <li class="list-group-item">
                    <b>Harga Lapak Gantung</b> <a class="float-right">${hargaSekarang.getHargaBeliGantung()}</a>
                  </li>
                </ul>
              </div>
              <!-- /.card-body -->
            </div>

        <!-- /.card -->
      </div>
      <!-- /.col -->
      <div class="col-md-9">
      
<!-- Default box -->
		<form:form method="POST" modelAttribute="hargaForm">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Harga Baru</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body">
<%-- 					<div class="form-group row">
						<label for="idTanggalMulai" class="col-sm-3 col-form-label">Tanggal Mulai</label>
						<div class="col-sm-9">
							<form:input type="text" path="tanggalMulai" id="idTanggalMulai" name="tanggalMulai" class="form-control"></form:input>
						</div>
					</div> --%>
					
					
	                <div class="form-group row">
	                  <label class="col-sm-3 col-form-label">Tanggal Mulai</label>
	                    <div class="col-sm-9 input-group date" id="reservationdate" data-target-input="nearest">
	                        <form:input type="text" path="tanggalMulai" class="form-control datetimepicker-input  ${status.error ? 'is-invalid' : ''}" data-target="#reservationdate"/>
	                        <div class="input-group-append" data-target="#reservationdate" data-toggle="datetimepicker">
	                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
	                        </div>
	                    	<span class="invalid-feedback">
		                		<form:errors path="tanggalMulai"></form:errors></span>
		                	</div>
	                </div>
                
                
		            <div class="form-group row">
				  		<label for="idHargaJual" class="col-sm-3 col-form-label">Harga Jual</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="hargaJual" id="idHargaJual" name="hargaJual" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Harga jual sawit ke pabrik"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="hargaJual"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idHargaLapakJembatan" class="col-sm-3 col-form-label">Harga Lapak Jembatan</label>
							<div class="col-sm-9">
								<form:input type="text" path="hargaBeliJembatan" id="idHargaLapakJembatan" name="hargaBeliJembatan" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Harga beli sawit lapak jembatan"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="hargaBeliJembatan"></form:errors></span>
		                	</div>
		            </div>
		            <div class="form-group row">
				  		<label for="idHargaLapakGantung" class="col-sm-3 col-form-label">Harga Lapak Gantung</label>
							<div class="col-sm-9">
								<form:input type="text" path="hargaBeliGantung" id="idHargaLapakGantung" name="hargaBeliGantung" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Harga beli sawit lapak gantung"></form:input>
		                		<span class="invalid-feedback">
		                		<form:errors path="hargaBeliGantung"></form:errors></span>
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