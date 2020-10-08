<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value = "in_ID"/>
  <!-- Main row -->
  
<spring:url value="/kasir" var="kasirURL" />
  
        
        
  <div class="row">
    <!-- Left col -->
    <div class="col-md-12">


      <!-- TABLE: LATEST ORDERS -->
      <div class="card">
			<div class="card-header">
				<h3 class="card-title">
					<a href="${kasirURL}/pabrikForm"><button type="button" class="btn btn-block btn-primary">Pabrik Baru</button></a>
				</h3>
			</div>
              <!-- /.card-header -->
              <div class="card-body">
              
                <table id="example2" class="table table-bordered table-hover table-striped">
                  <thead>
                  <tr>
                    <th>Nama Perusahaan</th>
                    <th>Uang Jalan Truk</th>
                    <th>Biaya Mobil Truk</th>
                    <th>Uang Jalan Tronton</th>
                    <th>Biaya Mobil Tronton</th>
                  </tr>
                  </thead>
                  <tbody>
					<c:forEach items="${listPabrik}" var="pabrik">
					<tr>
						<td><a href="${kasirURL}/pabrikForm?pabrikId=${pabrik.getPabrikId()}"  data-toggle="tooltip" title="Transaksi Timbang">${pabrik.getNamaPerusahaan()}</a></td>
						<td><fmt:formatNumber value = "${pabrik.getUangJalanTruk()}" type="number" minFractionDigits="0"/></td>
						<td>${pabrik.getBiayaMobilTruk()}</td>
						<td><fmt:formatNumber value = "${pabrik.getUangJalanTronton()}" type="number" minFractionDigits="0"/></td>
						<td>${pabrik.getBiayaMobilTronton()}</td>
					</tr>
					</c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
      <!-- /.card -->
    </div>
    <!-- /.col -->
  </div>
  <!-- /.row -->