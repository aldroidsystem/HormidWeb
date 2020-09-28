<%@ page import="com.aldroid.hormid.model.transaksi.Harga" %>
<%@ page import="com.aldroid.hormid.generic.process.CommonParsing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value = "in_ID"/>
<spring:url value="/kasir" var="kasirURL" />
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
					<h3 class="card-title">Filter Sejarah Pinjaman</h3>
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
		                          <form:radiobutton value="semua" class="custom-control-input" id="idInputJenisTrx0" path="jenisTransaksi" name="jenisTransaksi" checked="true"/>
		                          <label for="idInputJenisTrx0" class="custom-control-label">Semua</label>
		                        </div>
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
	                  <label class="col-sm-3 col-form-label">Dari Tanggal</label>
	                    <div class="col-sm-9 input-group date" id="idDariTanggal" data-target-input="nearest">
	                        <form:input type="text" path="dariTanggal" class="form-control datetimepicker-input  ${status.error ? 'is-invalid' : ''}" data-target="#idDariTanggal"/>
	                        <div class="input-group-append" data-target="#idDariTanggal" data-toggle="datetimepicker">
	                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
	                        </div>
	                    	<span class="invalid-feedback">
		                		<form:errors path="dariTanggal"></form:errors></span>
		                	</div>
	               	</div>
	                <div class="form-group row">
	                  <label class="col-sm-3 col-form-label">Sampai Tanggal</label>
	                    <div class="col-sm-9 input-group date" id="idSampaiTanggal" data-target-input="nearest">
	                        <form:input value="24/09//2020" type="text" path="sampaiTanggal" class="form-control datetimepicker-input  ${status.error ? 'is-invalid' : ''}" data-target="#idSampaiTanggal"/>
	                        <div class="input-group-append" data-target="#idSampaiTanggal" data-toggle="datetimepicker">
	                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
	                        </div>
	                    	<span class="invalid-feedback">
		                		<form:errors path="sampaiTanggal"></form:errors></span>
		                	</div>
	               	</div>
                	            
					<div class="form-group row">
						<div class="offset-sm-3 col-sm-9">
							<button type="submit" class="btn btn-danger">Filter</button>
						</div>
					</div>
				</div>
				<!-- /.card-body -->
			<!-- 	<div class="card-footer">
				</div> -->
			</div>
		</form:form>

      </div>
      </div>
      <div class="row">
    <div class="col-md-12">
      <div class="card">
				<div class="card-header">
					<h3 class="card-title">Sejarah Pinjaman</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
					</div>
				</div>
				<div class="card-body">					
                  <table id="example2" class="table table-bordered table-hover table-striped">
	                  <thead>
	                  <tr>
	                    <th>No. Nota</th>
	                    <th>Tanggal</th>
	                    <th>Jumlah Pinjam</th>
	                    <th>Jumlah Bayar</th>
	                    <th>Sisa Pinjaman</th>
	                  </tr>
	                  </thead>
	                  <tbody>
						<c:forEach items="${listPiutangHistory}" var="piutangHistory">
						<tr>
							<td>${piutangHistory.getPiutangId()}</td>
							<td><fmt:formatDate value="${piutangHistory.getCreatedDate()}" type="date" pattern="dd/MM/yyyy"/></td>
							<td>
								<c:choose>
									<c:when test="${piutangHistory.getHutang()!=0}">
										<fmt:formatNumber value = "${piutangHistory.getHutang()}" type = "currency" minFractionDigits="0"/>
									</c:when>
								</c:choose>	
							</td>
							<td>
								<c:choose>
									<c:when test="${piutangHistory.getBayar()!=0}">
										<fmt:formatNumber value = "${piutangHistory.getBayar()}" type = "currency" minFractionDigits="0"/>
									</c:when>
								</c:choose>	
							</td>
							<td><fmt:formatNumber value = "${piutangHistory.getSisaHutang()}" type = "currency" minFractionDigits="0"/></td>
						<%-- 	<td>${piutangHistory.getCreatedBy()}</td>
							<td>${piutangHistory.getPiutangId()}</td> --%>
						</tr>
						</c:forEach>
	                  </tbody>
	                </table>
                </div>
				<!-- /.card-body -->
				<div class="card-footer">
				</div>
			</div>
      <!-- /.col -->
      </div>
    </div>
    <!-- /.row -->
  </div><!-- /.container-fluid -->
</section>