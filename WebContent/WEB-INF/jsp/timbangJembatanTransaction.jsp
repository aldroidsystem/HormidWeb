<%@ page import="com.aldroid.hormid.model.transaksi.Harga" %>
<%@ page import="com.aldroid.hormid.generic.process.CommonParsing" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<spring:url value="/kasir" var="kasirURL" />
<fmt:setLocale value = "in_ID"/>
<section class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
	      <div class="card card-default">
	        <div class="card-header">
	          <h3 class="card-title">
	            <i class="fas fa-bullhorn"></i>
	            Catatan
	          </h3>
	        </div>
	        <!-- /.card-header -->
	        <div class="card-body">

			  <c:set var="catatanVehicle" value="${jembatanForm.getCatatanVehicle()}"/>
			  <c:set var="catatanSupir" value="${jembatanForm.getCatatanSupir()}"/>
			  <c:set var="catatanPengirim" value="${jembatanForm.getCatatanPengirim()}"/>
			  <c:set var="hutangPengirim" value="${jembatanForm.getHutangPengirim()}"/>
	          <div class="callout callout-info" style="padding: 0.3rem; padding-left: 1rem;" id="idCatatanVehicle"></div>
	          <div class="callout callout-info" style="padding: 0.3rem; padding-left: 1rem;" id="idCatatanSupir"></div>
	          <div class="callout callout-info" style="padding: 0.3rem; padding-left: 1rem;" id="idCatatanPengirim"></div>
	          <div class="callout callout-info" style="padding: 0.3rem; padding-left: 1rem;" id="idCatatanHutangPengirim"></div>
	          
	        </div>
	        <!-- /.card-body -->
	      </div>
	      <!-- /.card -->
          
<!-- Default box -->
		<form:form method="POST" modelAttribute="jembatanForm">
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
				<c:choose>
					<c:when test="${jembatanForm.getNoNota()!=null && jembatanForm.getNoNota()!=''}">
			            <div class="form-group row">
					  		<label for="idInputNetto" class="col-sm-3 col-form-label">No Nota</label>
								<div class="col-sm-9">
									<input type="hidden" name="noNota" value="${jembatanForm.getNoNota()}"></input>
			                		<form:input type="text" path="noNota" id="idInputNoNota" name="noNota" class="form-control " disabled="true"></form:input>
			                	</div>
			         	</div>
					</c:when>
<%-- 					<c:otherwise>
						<fmt:formatNumber value = "${piutangForm.getBayar()}" type = "currency" minFractionDigits="0"/>
					</c:otherwise> --%>
				</c:choose>	
			      <spring:bind path="vehicleId">  
	                <div class="form-group row">
	                  <label class="col-sm-3 col-form-label" for="idInputVehicle">Kendaraan</label>
						<div class="col-sm-9">
		                  <form:select items="${listVehicle}"  class="select2" id="idInputVehicle" data-placeholder="Pilih Kendaraan" style="width: 100%;" name="vehicleId" path="vehicleId">
		                  <Option value="">Pilih Kendaraan</Option>
		                  </form:select>
		                  <span class="invalid-feedback">
			              <form:errors path="vehicleId"></form:errors></span>
			            </div>
	                </div>
               		</spring:bind>		
			
			      <spring:bind path="supir">  
	                <div class="form-group row">
	                  <label class="col-sm-3 col-form-label" for="idInputSupir">Supir</label>
						<div class="col-sm-9">
		                  <form:select items="${listSupir}"  class="select2" id="idInputSupir" data-placeholder="Pilih Supir" style="width: 100%;" name="supir" path="supir">
		                  </form:select>
		                  <span class="invalid-feedback">
			              <form:errors path="supir"></form:errors></span>
			            </div>
	                </div>
               		</spring:bind>
					<spring:bind path="pengirim">  
						<div class="form-group row">
							<label class="col-sm-3 col-form-label" for="idInputPengirim">Pengirim</label>
							<div class="col-sm-9">
								<form:select items="${listPengirim}"  class="select2" id="idInputPengirim" data-placeholder="Pilih Pengirim" style="width: 100%;" name="pengirim" path="pengirim">
								</form:select>
								<span class="invalid-feedback">
									<form:errors path="pengirim"></form:errors></span>
							</div>
						</div>
					</spring:bind>
               			
		            <div class="form-group row">
				  		<label for="idInputBruto" class="col-sm-3 col-form-label">Bruto</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="bruto" id="idInputBruto" name="bruto" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Berat kotor"></form:input>
		                		<span class="invalid-feedback">
		                			<form:errors path="bruto"></form:errors></span>
		                	</div>
		         	</div>
               			
		            <div class="form-group row">
				  		<label for="idInputTare" class="col-sm-3 col-form-label">Tare</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="tare" id="idInputTare" name="tare" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Berat kendaraan"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="tare"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputNetto" class="col-sm-3 col-form-label">Netto</label>
							<div class="col-sm-9">
								<fmt:formatNumber 
									var="formattedNetto" 
									value = "${jembatanForm.getNetto()}" type="number" minFractionDigits="0"/>
		                		<form:input type="text" path="netto" id="idInputNetto" name="netto" class="form-control " disabled="true" 
		                		value="${formattedNetto}"></form:input>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputPotongan" class="col-sm-3 col-form-label">% Refraksi</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="potongan" id="idInputPotongan" name="potongan" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Persentase potongan berat"></form:input>
		                		
								<fmt:formatNumber 
									var="formattedTotalPotongan" 
									value = "${jembatanForm.getTotalPotongan()}" 
									type="number" minFractionDigits="0"/>
									<form:input value="${formattedTotalPotongan}" type="text" path="totalPotongan" id="idInputTotalPotongan" name="totalPotongan" class="form-control" disabled="true"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="potongan"></form:errors></span>
		                	</div>
		         	</div>	
		            <div class="form-group row">
				  		<label for="idInputBeratBersih" class="col-sm-3 col-form-label">Berat Bersih</label>
							<div class="col-sm-9">
								<fmt:formatNumber 
									var="formattedBeratBersih" 
									value = "${jembatanForm.getBeratBersih()}" 
									type="number" minFractionDigits="0"/>
								<form:input value="${formattedBeratBersih}" type="text" path="beratBersih" id="idInputBeratBersih" name="beratBersih" class="form-control " disabled="true"></form:input>
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
				  		<label for="idInputTotal" class="col-sm-3 col-form-label">Total</label>
							<div class="col-sm-9">
								<fmt:formatNumber 
									var="formattedTotal" 
									value = "${jembatanForm.getTotal()}" 
									type="number" minFractionDigits="0"/>
								<form:input value="${formattedTotal}" type="text" path="total" id="idInputTotal" name="total" class="form-control " disabled="true"></form:input>
		                	</div>
		         	</div>
               
		            <div class="form-group row">
				  		<label for="idInputBongkar" class="col-sm-3 col-form-label">Biaya Bongkar</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="biayaBongkar" id="idInputBongkar" name="biayaBongkar" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Biaya bongkar sawit dari kendaraan"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="biayaBongkar"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row" id="idFieldBiayaMobil">
				  		<label for="idInputBiayaMobil" class="col-sm-3 col-form-label">Biaya Mobil</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="biayaMobil" id="idInputBiayaMobil" name="biayaMobil" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Biaya operasional mobil"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="biayaMobil"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row" id="idFieldPotonganBon">
				  		<label for="idInputPotonganBon" class="col-sm-3 col-form-label">Potongan Hutang</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="potonganBon" id="idInputPotonganBon" name="potonganBon" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Potongan Hutang"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="potonganBon"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputBiayaLain" class="col-sm-3 col-form-label">Biaya Lain</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="biayaLain" id="idInputBiayaLain" name="biayaLain" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Biaya Lain-Lain"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="biayaLain"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputKeteranganBiayaLain" class="col-sm-3 col-form-label">Keterangan Biaya Lain</label>
							<div class="col-sm-9">
		                		<form:input type="text" path="keteranganBiayaLain" id="idInputKeteranganBiayaLain" name="keteranganBiayaLain" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Keterangan Biaya Lain-Lain"></form:input>
		                	<span class="invalid-feedback">
		                		<form:errors path="keteranganBiayaLain"></form:errors></span>
		                	</div>
		         	</div>
		            <div class="form-group row">
				  		<label for="idInputTotalBayar" class="col-sm-3 col-form-label">Total Bayar</label>
							<div class="col-sm-9">
								<fmt:formatNumber 
									var="formattedTotalBayar" 
									value = "${jembatanForm.getTotalBayar()}" 
									type="number" minFractionDigits="0"/>
								<form:input value="${formattedTotalBayar}" type="text" path="totalBayar" id="idInputTotalBayar" name="totalBayar" class="form-control " disabled="true"></form:input>
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
							<button type="submit" class="btn btn-danger" formaction="${kasirURL}/timbangJembatan">Simpan</button>
							<button type="submit" class="btn btn-danger" formaction="${kasirURL}/timbangJembatanBayar">Pembayaran</button>
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