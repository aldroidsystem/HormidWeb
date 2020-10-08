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
					<a href="${kasirURL}/timbangJembatan"><button type="button" class="btn btn-block btn-primary">Transaksi Baru</button></a>
				</h3>
			</div>
              <!-- /.card-header -->
              <div class="card-body">
              
                <table id="example2" class="table table-bordered table-hover table-striped">
                  <thead>
                  <tr>
                    <th>NOPOL</th>
                    <th>Supir</th>
                    <th>Pengirim</th>
                    <th>Bruto</th>
                    <th>Jam Timbang1</th>
                  </tr>
                  </thead>
                  <tbody>
         
					<c:forEach items="${listJembatan}" var="jembatan">
					<tr>
						<td><a href="timbangJembatan?noNota=${jembatan.getNoNota()}"  data-toggle="tooltip" title="Transaksi Timbang">${jembatan.getNoNota()}</a></td>
						<td>${jembatan.getSupir()}</td>
						<td>${jembatan.getPengirim()}</td>
						<td><fmt:formatNumber value = "${jembatan.getBruto()}" type="number" minFractionDigits="0"/></td>
						<td><fmt:formatDate value="${jembatan.getTimestampTimbang1()}" type = "both" dateStyle = "short" timeStyle = "short"/></td>
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