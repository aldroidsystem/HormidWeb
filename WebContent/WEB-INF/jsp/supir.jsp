<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!-- Main row -->
<spring:url value="/kasir/supirForm" var="supirFormURL" />
   
  <div class="row">
    <!-- Left col -->
    <div class="col-md-12">


      <!-- TABLE: LATEST ORDERS -->
      <div class="card">
			<div class="card-header">
				<h3 class="card-title">
					<a href="${supirFormURL}"><button type="button" class="btn btn-block btn-primary">Tambah Supir</button></a>
				</h3>
	            <div class="card-tools">
					<form:form method="POST" modelAttribute="supirSearchForm">
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
                    <th>Kode Pengguna</th>
                    <th>Nama</th>
                    <th>Peranan</th>
                    <th>Kendaraan</th>
                  </tr>
                  </thead>
                  <tbody>
					<c:forEach items="${listSupir}" var="supir">
					<tr>
						<td><a href="${supirFormURL}?username=${supir.getUsername()}"  data-toggle="tooltip" title="Ubah Pengguna">
							${supir.getUsername()}
						</a></td>
						<td>${supir.getFullname()}</td>
						<td>
							<c:forEach items="${supir.getRoles()}" var="role">
								<span class="badge bg-info">${role}</span>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${supir.getListVehiclePlate()}" var="vehicle">
								<span class="badge bg-info">${vehicle}</span>
							</c:forEach>
						
						</td>
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