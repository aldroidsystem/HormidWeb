<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
		<div class="col-md-12">
		<form:form method="POST" modelAttribute="userForm">
	      <div class="card  card-default">
	        <div class="card-header">
				<c:choose>
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()=='' ||  userForm.getAction()=='c'}">
                		<h5 class="card-title">Pendaftaran Pengguna</h5>
					</c:when>    
					<c:otherwise>
                		<h5 class="card-title">Ubah Pengguna</h5>
					</c:otherwise>
				</c:choose>	
                
	          <div class="card-tools">
	            <button type="button" class="btn btn-tool" data-card-widget="collapse">
	              <i class="fas fa-minus"></i>
	            </button>
	          </div>
	        </div>
	        <!-- /.card-header -->
	        <div class="card-body">
				<c:choose>
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()=='' ||  userForm.getAction()=='c'}">
				        <spring:bind path="username">
				            <div class="form-group">
						  		<label for="idInputUsername">Kode Pengguna</label>
				                <form:input type="text" path="username" id="idInputUsername" class="form-control  ${status.error ? 'is-invalid' : ''}" placeholder="Masukkan kode pengguna"></form:input>
				                <span class="invalid-feedback">
				                <form:errors path="username"></form:errors></span>
				         	</div>
				        </spring:bind>
				        
					</c:when>    
					<c:otherwise>						
						<div class="form-group">
					  		<label for="idInputUsername">Kode Pengguna</label>
			                <form:input type="text" path="username" id="idInputUsername" name="username" class="form-control" disabled="true"></form:input>
			         	</div>
					</c:otherwise>
				</c:choose>	
		        
				<c:choose>
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()=='' ||  userForm.getAction()=='c'}">
		        		<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
			                    <label for="idInputPassword1">Kata Kunci</label>
			                    <input type="password" name="password" class="form-control" id="idInputPassword1" placeholder="Kata Kunci">
		                  	</div>
	                  	</spring:bind>
					</c:when>    
				</c:choose>	
				
	            <div class="form-group">
			  		<label for="idInputFullname">Nama</label>
	                <form:input type="text" path="fullname" id="idInputFullname" name="fullname" class="form-control" placeholder="Masukkan nama pengguna"></form:input>
	         	</div>
	            <div class="form-group">
			  		<label for="idInputUsername">Telepon</label>
					<form:input type="text" path="phone" id="idInputPhone" name="phone" class="form-control" placeholder="Masukkan nomor telepon"></form:input>
	            </div>
	            <div class="form-group">
			  		<label for="idInputFullname">Email</label>
	                <form:input type="text" path="email" id="idInputEmail" name="email" class="form-control" placeholder="Masukkan email"></form:input>
	         	</div>
	            <div class="form-group">
			  		<label for="idInputDataType">Area</label>	
	                <form:select items="${properties_village}"  class="custom-select" id="idInputArea" data-placeholder="Pilih area" name="area" path="area">
	                </form:select>
	                <form:errors path="area"></form:errors>
	            </div>
		        <spring:bind path="roles">
		            <div class="form-group ${status.error ? 'has-error' : ''}">
				  		<label for="idInputPeranan">Peranan</label>	
		                  <form:select items="${properties_rolemap}"  class="select2" id="idInputPeranan" multiple="multiple" data-placeholder="Pilih Peranan" style="width: 100%;" name="roles" path="roles">
		                  </form:select>
		                <form:errors path="roles"></form:errors>
		            </div>
		        </spring:bind>
	            <div class="form-group">
			  		<label for="idInputPwdExpiry">Periode Ubah Kata Kunci</label>
	                <form:input type="text" path="passwordExpiryPeriod" id="idInputPwdExpiry" name="passwordExpiryPeriod" class="form-control" placeholder="Masukkan periode"></form:input>
	            </div>
	            <div class="form-group">
                    		<label for="fieldFlagActive">Aktifkan Pengguna</label>
	            	<div class="custom-switch" id="fieldFlagActive">
						<c:choose>
							<c:when test="${userForm.getFlagActive()==1}">
		                		<input type="checkbox" id="idInputflagActive" name="flagActive" class="custom-control-input" value="1" checked></input>
							</c:when>    
							<c:otherwise>
		                		<input type="checkbox" id="idInputflagActive" name="flagActive" class="custom-control-input" value="1"></input>
							</c:otherwise>
						</c:choose>	
                    			<label class="custom-control-label" for="idInputflagActive"></label>
	            	</div>
	         	</div>
	         	<br/>
	            <div class="form-group">
                   <label for="fieldFlagNeverDisable">Jangan di Kunci</label>
                   <div class="custom-switch" id="fieldFlagNeverDisable">
						<c:choose>
							<c:when test="${userForm.getFlagNeverDisable()==1}">
		                		<input type="checkbox" id="idInputflagNeverDisable" name="flagNeverDisable" class="custom-control-input" value="1" checked></input>
							</c:when>    
							<c:otherwise>
		                		<input type="checkbox" id="idInputflagNeverDisable" name="flagNeverDisable" class="custom-control-input" value="1"></input>
							</c:otherwise>
						</c:choose>	
	                   	<label class="custom-control-label" for="idInputflagNeverDisable"></label>
	            	</div>
	         	</div>
	         	<br/>
	            <div class="form-group">
			  		<label for="idInputDescription">Alamat</label>
	                <form:textarea type="text" path="address" id="idInputAddress" class="form-control" rows="3" name="address" placeholder="Alamat pengguna"></form:textarea>
	         	</div>
	            <div class="form-group">
			  		<label for="idInputDescription">Catatan</label>
	                <form:textarea type="text" path="catatan" id="idInputAddress" class="form-control" rows="3" name="catatan" placeholder="Masukkan pengguna"></form:textarea>
	         	</div>
	        </div>
	        <!-- ./card-body -->
	        
	        <!-- ./card-body -->
	          <div class="card-footer">
				<c:choose>
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()=='' ||  userForm.getAction()=='c'}">
                		<input type="hidden" name="action" value="c"/>
					</c:when> 
					<c:when test="${userForm.getUsername()==null || userForm.getUsername()=='' ||  userForm.getAction()=='c'}">
                		<input type="hidden" name="action" value="c"/>
					</c:when>    
					<c:otherwise>
                		<input type="hidden" name="action" value="u"/>
					</c:otherwise>
				</c:choose>	
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	            <button type="submit" class="btn btn-primary">Simpan</button>
	          </div>
	        </div>
    	</form:form>
    	
		<c:choose>
			<c:when test="${userForm.getUsername()!=null && userForm.getUsername()!='' &&  userForm.getAction()!='c'}">
		    	<form:form class="form-horizontal" action="resetPassword" method="POST" modelAttribute="passwordForm">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Ubah Kata Kunci</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
				           	<input type="hidden" name="username" value="${userForm.getUsername()}"/>
							<spring:bind path="password">
								<div class="form-group row">
									<label for="idInputPassword1" class="col-sm-2 col-form-label">Kata
										Kunci</label>
									<div class="col-sm-10">
										<input type="password" name="password" class="form-control ${status.error ? is-invalid: ''}"
											id="idInputPassword1" placeholder="Kata Kunci">
										<span class="invalid-feedback">
					                	<form:errors path="password"></form:errors></span>
									</div>
								</div>
							</spring:bind>
							
				
							<spring:bind path="passwordConfirm">
								<div class="form-group row">
									<label for="idInputPassword2" class="col-sm-2 col-form-label">Konfirmasi
										Kata Kunci</label>
									<div class="col-sm-10">
										<input type="password" name="passwordConfirm"
											class="form-control ${status.error ? 'is-invalid' : ''}" id="idInputPassword2"
											placeholder="Konfirmasi Kata Kunci">
										<span class="invalid-feedback">
					                	<form:errors path="passwordConfirm"></form:errors></span>
									</div>
								</div>
							</spring:bind>
							<div class="form-group row">
								<div class="offset-sm-2 col-sm-10">
									<button type="submit" class="btn btn-danger">Submit</button>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer">
						</div>
						<!-- /.card-footer-->
					</div>
				</form:form>
			</c:when> 
		</c:choose>	
	   </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>