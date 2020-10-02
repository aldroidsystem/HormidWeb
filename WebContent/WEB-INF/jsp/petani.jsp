<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!-- Main row -->
<spring:url value="/kasir/petaniForm" var="petaniFormURL" />
   
  <div class="row">
    <!-- Left col -->
    <div class="col-md-12">


      <!-- TABLE: LATEST ORDERS -->
      <div class="card">
			<div class="card-header">
				<h3 class="card-title">
					
				</h3>
	            <div class="card-tools">
					<form:form method="POST" modelAttribute="petaniSearchForm">
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
                    <th>Potongan</th>
                    <th>Kendaraan</th>
                  </tr>
                  </thead>
                  <tbody>
					<c:forEach items="${listPetani}" var="petani">
					<tr>
						<td><a href="${petaniFormURL}?username=${petani.getUsername()}"  data-toggle="tooltip" title="Ubah Petani">
							${petani.getUsername()}
						</a></td>
						<td>${petani.getFullname()}</td>
						<td>
							<c:forEach items="${petani.getRoles()}" var="role">
								<span class="badge bg-info">${role}</span>
							</c:forEach>
						</td>
						<td>${petani.getDefaultPotongan()}</td>
						<td>
							<c:forEach items="${petani.getListVehiclePlate()}" var="vehicle">
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