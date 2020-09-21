<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <!-- Main row -->
<spring:url value="/kasir/vehicleForm" var="vehicleFormURL" />
   
  <div class="row">
    <!-- Left col -->
    <div class="col-md-12">


      <!-- TABLE: LATEST ORDERS -->
      <div class="card">
			<div class="card-header">
				<h3 class="card-title">
					<a href="${vehicleFormURL}"><button type="button" class="btn btn-block btn-primary">Tambah Kendaraan</button></a>
				</h3>
	            <div class="card-tools">
					<form:form method="POST" modelAttribute="vehicleSearchForm">
					   <div class="input-group input-group-sm" style="width: 150px;">
					     <form:input type="text" path="plateNumber" name="plateNumber" class="form-control float-right" placeholder="Pencarian"/>
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
                    <th>Nomor Polisi</th>
                    <th>Jenis</th>
                    <th>Supir</th>
                    <th>Biaya Bongkar</th>
                  </tr>
                  </thead>
                  <tbody>
					<c:forEach items="${listVehicle}" var="vehicle">
					<tr>
						<td><a href="${vehicleFormURL}?vehicleId=${vehicle.getVehicleId()}"  data-toggle="tooltip" title="Ubah Pengguna">
							${vehicle.getPlateNumber()}
						</a></td>
						<td>${vehicle.getVehicleType()}</td>
						<td>
						 	<c:forEach items="${vehicle.getListSupirFullname()}" var="supir">
								<span class="badge bg-info">${supir}</span>
							</c:forEach> 
						</td>
							<td>${vehicle.getDefaultBiayaBongkar()}</td>
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