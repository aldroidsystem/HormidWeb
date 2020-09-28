<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<fmt:setLocale value = "in_ID"/>
<spring:url value="/kasir" var="kasirURL" />
 <div class="container-fluid">
   <div class="row">
     <div class="col-12">
       <div class="callout callout-info">
         <h5><i class="fas fa-info"></i> Catatan:</h5>
         Halaman ini adalah bukti transaksi secara elektronik, silakan klik tombol print untuk mencetak.
       </div>


       <!-- Main content -->
       <div class="invoice p-3 mb-3">
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

         <div class="row">
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
           <div class="col-7">
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

         <!-- this row will not appear when printing -->
         <div class="row no-print">
           <div class="col-12">
             <a href="${kasirURL}/piutangInvoicePrint?piutangId=${piutangForm.getPiutangId()}" target="_blank" class="btn btn-default"><i class="fas fa-print"></i> Print</a>
             <button type="button" class="btn btn-primary float-right" style="margin-right: 5px;">
               <i class="fas fa-download"></i> Generate PDF
             </button>
           </div>
         </div>
       </div>
       <!-- /.invoice -->
     </div><!-- /.col -->
   </div><!-- /.row -->
 </div><!-- /.container-fluid -->