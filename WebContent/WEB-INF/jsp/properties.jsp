<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <section class="content">
      <div class="container-fluid">
        <!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">			
  					<spring:url value="/admin/propertiesForm" var="propertiesForm" />
					<h3 class="card-title">
    					Daftar Pengaturan Sistem
					</h3>
                <div class="card-tools">                
					<form:form method="POST" modelAttribute="propertiesSearchForm">
					   <div class="input-group input-group-sm" style="width: 150px;">
					     <form:input type="text" path="propertyDesc" name="propertyDesc" class="form-control float-right" placeholder="Pencarian"/>
					     <div class="input-group-append">
					       <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
					     </div>
					   </div>
					</form:form>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap table-bordered table-striped"> 
                  <thead>
                    <tr>
                      <th>Kode</th>
                      <th>Tipe Data</th>
                      <th>Nilai</th>
                      <th>Deskripsi</th>
                    </tr>
                  </thead>
                  <tbody>
					<spring:url value="/resources/icon/edit16.png" var="iedit" />
					<c:forEach items="${listProperties}" var="property">
					<tr>
						<td><a href="propertiesForm?code=${property.getCode()}"  data-toggle="tooltip" title="Ubah pengaturan">${property.getCode()}</a></td>
						<td>${property.getTipeData()}</td>
						<td>
							<c:choose>
								<c:when test="${property.getTipeData()=='Kata'}">
			                		<span class="badge bg-info">${property.getKata()}</span>
								</c:when>    
								<c:when test="${property.getTipeData()=='Daftar Kata'}">
									<c:forEach items="${property.getDaftarKata()}" var="kata">
										<span class="badge bg-info">${kata}</span>
									</c:forEach>
								</c:when>   
								<c:when test="${property.getTipeData()=='Angka'}">
			                		<span class="badge bg-info">${property.getAngka()}</span>
								</c:when>   
								<c:when test="${property.getTipeData()=='Daftar Angka'}">
									<c:forEach items="${property.getDaftarAngka()}" var="angka">
										<span class="badge bg-info">${angka}</span>
									</c:forEach>
								</c:when>   
								<c:when test="${property.getTipeData()=='Desimal'}">
			                		<span class="badge bg-info">${property.getDesimal()}</span>
								</c:when>   
								<c:when test="${property.getTipeData()=='Daftar Desimal'}">
									<c:forEach items="${property.getDaftarDesimal()}" var="desimal">
										<span class="badge bg-info">${desimal}</span>
									</c:forEach>
								</c:when>   
								<c:otherwise>
			                		<span class="badge bg-error">ERROR: TIDAK DIKETAHUI</span>
								</c:otherwise>
							</c:choose>	
						
						</td>
						<td>${property.getPropertyDesc()}</td>
					</tr>
					</c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
        
      </div><!-- /.container-fluid -->
    </section>
    
