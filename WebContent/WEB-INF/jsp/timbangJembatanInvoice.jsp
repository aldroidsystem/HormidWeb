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
	         <h5>NOTA PEMBELIAN SAWIT</h5>
	     </div>
         <div class="col-sm-12 row">
	         <a class="float: right;"><fmt:formatDate value="${jembatanForm.getCreatedDate()}" type="date" pattern="dd/MM/yyyy"/></a>
	     </div>
           <div class="col-sm-12 row">
           	<table>
		     	<tr>
		     		<td style="padding-left: 20px; width:50%" ><b>No. Nota</b></td>
		     		<td></td>
		     		<td>: ${jembatanForm.getNoNota()}</td>
		     	</tr>
		     	<tr>
		     		<td style="padding-left: 20px; width:50%"><b>Berat Kotor</b></td>
		     		<td></td>
		     		<td>: ${jembatanForm.getBruto()}</td>
		     	</tr>
		     	<tr>
		     		<td style="padding-left: 20px; width:50%"><b>Refraksi</b></td>
		     		<td>( ${jembatanForm.getPotongan()}% )</td>
		     		<td>: ${jembatanForm.getTotalPotongan()}</td>
		     	</tr>
		     	<tr>
		     		<td style="padding-left: 20px; width:50%"><b>Berat Bersih</b></td>
		     		<td></td>
		     		<td>: ${jembatanForm.getNetto()}</td>
		     	</tr>
		     	<tr>
		     		<td style="padding-left: 20px; width:50%"><b>Harga</b></td>
		     		<td></td>
		     		<td>: <fmt:formatNumber value = "${jembatanForm.getHarga()}" type = "currency" minFractionDigits="0"/></td>
		     	</tr>
<%-- 		     	<tr>
		     		<td style="padding-left: 20px; width:50%"><b>Pembulatan</b></td>
		     		<td></td>
		     		<td>: (<fmt:formatNumber value = "${jembatanForm.getPembulatan()}" type = "currency" minFractionDigits="0"/>)</td>
		     	</tr> --%>
		     	<tr>
		     		<td style="padding-left: 20px; width:50%"><b>Total</b></td>
		     		<td></td>
		     		<td>: <fmt:formatNumber value = "${jembatanForm.getTotal()}" type = "currency" minFractionDigits="0"/></td>
		     	</tr>
		     	<tr>
		     		<td>
      
				      <br/>
				      <br/>
				      Dibayar oleh,
				      <br/>
				      <br/>
				      ${jembatanForm.getPaidBy()}
				     </td>
		     		<td></td>
		     		<td>
				      <br/>
				      <br/>
				      Penerima,
				      <br/>
				      <br/>
				      ${jembatanForm.getPengirim()}</td>
		     	</tr>
		     </table>
           </div>
         </div>

         
         <!-- /.row -->

         <!-- this row will not appear when printing -->
         <div class="row no-print">
           <div class="col-12">
             <a href="${kasirURL}/piutangInvoicePrint?piutangId=${jembatanForm.getNoNota()}" target="_blank" class="btn btn-default"><i class="fas fa-print"></i> Print</a>
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