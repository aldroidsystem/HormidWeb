<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value = "in_ID"/>
  <!-- Main row -->
  
<spring:url value="/resources/icon/coins16.png" var="coinPng" />
<spring:url value="/resources/icon/bill16.png" var="billPng" />
<spring:url value="/admin/userForm" var="userForm" />
<spring:url value="/kasir" var="kasirURL" />

  <div class="row">
    <!-- Left col -->
    <div class="col-md-12">


      <!-- TABLE: LATEST ORDERS -->
      <div class="card">
			<div class="card-header">
				<h3 class="card-title">
					Peminjam
				</h3>
	            <div class="card-tools">
					<form:form method="POST" modelAttribute="piutangSearchForm">
					   <div class="input-group input-group-sm" style="width: 150px;">
					     <form:input type="text" path="fullname" name="fullname" class="form-control float-right" placeholder="Pencarian"/>
					 	<div class="input-group-append">
					       <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
			     		</div>
					   </div>
					</form:form>
				</div>
			</div>
              <!-- /.card-header -->
              <div class="card-body">
              
                <table id="example2" class="table table-bordered table-hover table-striped">
                  <thead>
                  <tr>
                    <th>Aksi</th>
                    <th>Kode Pengguna</th>
                    <th>Nama</th>
                    <th>Area</th>
                    <th>Pinjaman</th>
                    <th>Terakhir Bayar</th>
                    <th>Terakhir Pinjam</th>
                  </tr>
                  </thead>
                  <tbody>
         
					<c:forEach items="${listUser}" var="user">
					<tr>
						<td><a href="${kasirURL}/piutangTransaction?username=${user.getUsername()}"  data-toggle="tooltip" title="Transaksi Piutang">
							<img src="${coinPng}" alt="User Image">
						</a>
						<a href="${kasirURL}/piutangHistory?username=${user.getUsername()}"  data-toggle="tooltip" title="Sejarah Piutang">
							<img src="${billPng}" alt="User Image">
						</a>
						</td>
						<td>${user.getUsername()}</td>
						<td>${user.getFullname()}</td>
						<td>${user.getArea()}</td>
						<td><fmt:formatNumber value = "${user.getHutang()}" type = "currency" minFractionDigits="0"/></td>
						<td><fmt:formatDate value="${user.getTerakhirBayar()}" type="date" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${user.getTerakhirPinjam()}" type="date" pattern="dd/MM/yyyy"/></td>
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