<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<fmt:setLocale value = "in_ID"/>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Piutang Invoice Print - Horas Miduk</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap 4 -->

  <!-- Font Awesome Icons -->
   <spring:url value="/resources/plugins/fontawesome-free/css/all.min.css" var="allMinCss" />
  <link rel="stylesheet" href="${allMinCss}"> 
  <!-- Ionicons -->
<!--   <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
 -->
  <!-- Theme style -->
  <spring:url value="/resources/dist/css/adminlte.min.css" var="adminCss" />
  <link rel="stylesheet" href="${adminCss}">

  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
  <style>
@media print {
    html, body {
        display: block; 
        font-family: "Calibri";
        margin: 0;
    }

    @page {
      size: 10.6cm 14cm;
    }

    .logo {
      width: 30%;
    }

}
</style>
</head>
<body>
<div class="wrapper">
  <!-- Main content -->
  <section class="invoice">
    <!-- title row -->
    <div class="row">
      <div class="col-12">
        <h4>
          <i class="fas fa-globe"></i> Lapak Hormid
        </h4>
      </div>
      <!-- /.col -->
    </div>
    <!-- info row -->
    <div class="row invoice-info">
      <div class="col-sm-12 row">
     <table>
     	<tr>
     		<td style="padding-left: 20px;"><b>Faktur Piutang</b></td>
     		<td>: ${piutangForm.getPiutangId()}</td>
     	</tr>
     	<tr>
     		<td style="padding-left: 20px;"><b>Tanggal</b></td>
     		<td>: <fmt:formatDate value="${piutangForm.getCreatedDate()}" type="date" pattern="dd/MM/yyyy"/></td>
     	</tr>
     	<tr>
     		<td style="padding-left: 20px;"><b>Peminjam</b></td>
     		<td>: ${piutangForm.getFullname()}</td>
     	</tr>
     	<tr>
     		<td style="padding-left: 20px;"><b>Piutang Awal</b></td>
     		<td>: <c:choose>
					<c:when test="${piutangForm.getHutang()> 0}">
						<fmt:formatNumber value = "${piutangForm.getSisaHutang() - piutangForm.getHutang()}" type = "currency" minFractionDigits="0"/>
					</c:when>
					<c:otherwise>
						<fmt:formatNumber value = "${piutangForm.getSisaHutang() + piutangForm.getBayar()}" type = "currency" minFractionDigits="0"/>
					</c:otherwise>
				</c:choose>		</td>
     	</tr>
     </table>
      </div>
    </div>
    <!-- /.row -->
<br/>
       <!-- Table row -->
    <div class="row">
      <div class="col-12 table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>Transaksi</th>
            <th>Keterangan</th>
            <th>Jumlah</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
				<c:choose>
					<c:when test="${piutangForm.getHutang()>0}">
						Peminjaman
					</c:when>
					<c:otherwise>
						Pembayaran
					</c:otherwise>
				</c:choose>	
			</td>
            <td>${piutangForm.getKeterangan()}</td>
            <td>
				<c:choose>
					<c:when test="${piutangForm.getHutang()> 0}">
						<fmt:formatNumber value = "${piutangForm.getHutang()}" type = "currency" minFractionDigits="0"/>
					</c:when>
					<c:otherwise>
						<fmt:formatNumber value = "${piutangForm.getBayar()}" type = "currency" minFractionDigits="0"/>
					</c:otherwise>
				</c:choose>	
            </td>
          </tr>
          
          </tbody>
        </table>
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->

    <div class="row" style="padding-left: 20px;">
      <!-- accepted payments column -->
      <div class="col-4" >
      
      <br/>
      <br/>
      Di Catat Oleh,
      <br/>
      <br/>
      ${piutangForm.getCreatedBy()}
      </div>
      <!-- /.col -->
      <div class="col-8">
        <div class="table-responsive">
          <table class="table">
            <tr>
              <th style="width:50%">Sisa Piutang:</th>
              <td><fmt:formatNumber value = "${piutangForm.getSisaHutang()}" type = "currency" minFractionDigits="0"/></td>
            </tr>
          </table>
        </div>
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->
  </section>
  <!-- /.content -->
</div>
<!-- ./wrapper -->

<script type="text/javascript"> 
  window.addEventListener("load", window.print());
</script>
</body>
</html>
