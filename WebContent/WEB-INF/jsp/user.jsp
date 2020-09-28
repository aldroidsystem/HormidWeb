<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value = "in_ID"/>
  <!-- Main row -->
  
<spring:url value="/resources/icon/rupiah16.png" var="rupiahPng" />
<spring:url value="/resources/icon/edit16.png" var="editPng" />
<spring:url value="/admin/userForm" var="userForm" />
  
  <h5 class="mb-2">Statistik Pengguna</h5>
  <div class="row">
    <div class="col-md-3 col-sm-6 col-12">
      <div class="info-box">
        <span class="info-box-icon bg-info"><i class="far fa-envelope"></i></span>

        <div class="info-box-content">
          <span class="info-box-text">Messages</span>
          <span class="info-box-number">1,410</span>
        </div>
        <!-- /.info-box-content -->
      </div>
      <!-- /.info-box -->
    </div>
    <!-- /.col -->
    <div class="col-md-3 col-sm-6 col-12">
      <div class="info-box">
        <span class="info-box-icon bg-success"><i class="far fa-flag"></i></span>

        <div class="info-box-content">
          <span class="info-box-text">Bookmarks</span>
          <span class="info-box-number">410</span>
        </div>
        <!-- /.info-box-content -->
      </div>
      <!-- /.info-box -->
    </div>
    <!-- /.col -->
    <div class="col-md-3 col-sm-6 col-12">
      <div class="info-box">
        <span class="info-box-icon bg-warning"><i class="far fa-copy"></i></span>

        <div class="info-box-content">
          <span class="info-box-text">Uploads</span>
          <span class="info-box-number">13,648</span>
        </div>
        <!-- /.info-box-content -->
      </div>
      <!-- /.info-box -->
    </div>
    <!-- /.col -->
    <div class="col-md-3 col-sm-6 col-12">
      <div class="info-box">
        <span class="info-box-icon bg-danger"><i class="far fa-star"></i></span>

        <div class="info-box-content">
          <span class="info-box-text">Likes</span>
          <span class="info-box-number">93,139</span>
        </div>
        <!-- /.info-box-content -->
      </div>
      <!-- /.info-box -->
    </div>
    <!-- /.col -->
  </div>
        
        
  <div class="row">
    <!-- Left col -->
    <div class="col-md-12">


      <!-- TABLE: LATEST ORDERS -->
      <div class="card">
			<div class="card-header">
				<h3 class="card-title">
					<a href="${userForm}"><button type="button" class="btn btn-block btn-primary">Pendaftaran Pengguna</button></a>
				</h3>
	            <div class="card-tools">
					<form:form method="POST" modelAttribute="userSearchForm">
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
                    <th>Area</th>
                    <th>Peranan</th>
                  </tr>
                  </thead>
                  <tbody>
         
					<c:forEach items="${listUser}" var="user">
					<tr>
						<td><a href="userForm?username=${user.getUsername()}"  data-toggle="tooltip" title="Ubah Pengguna">
						${user.getUsername()}</a></td>
						<td>${user.getFullname()}</td>
						<td>${user.getArea()}</td>
						<td>
							<c:forEach items="${user.getRoles()}" var="role">
								<span class="badge bg-info">${role}</span>
							</c:forEach>
						</td>
<%-- 						<td>${user.getLoginFailCount()}</td>
						<td>${user.getSessionInstanceCount()}</td> --%>
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