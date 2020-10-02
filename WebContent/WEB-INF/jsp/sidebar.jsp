<!-- Brand Logo -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/icon/Hormid32.png" var="logoPng" />
<spring:url value="/admin" var="adminURL" />
<spring:url value="/lapak" var="lapakURL" />
<spring:url value="/kasir" var="kasirURL" />

<div class="brand-link navbar-light">
  <img src="${logoPng}" alt="AdminLTE Logo" class="brand-image" style="opacity: .8"/>
  <span class="brand-text font-weight-light"><b>Horas</b>Miduk</span>
</div>
<!-- Sidebar -->
<div class="sidebar">
  <!-- Sidebar user panel (optional) -->
  <div class="user-panel mt-3 pb-3 mb-3 d-flex">
    <div class="image">
		<spring:url value="/resources/icon/user32.png" var="userJpg" />
      <img src="${userJpg}" class="img-circle elevation-2" alt="User Image">
    </div>
    <div class="info">
      <a href="${lapakURL}/profile" class="d-block">${pageContext.request.userPrincipal.name}</a>
    </div>
  </div>

  <!-- Sidebar Menu -->
  <nav class="mt-2">
    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
      <!-- Add icons to the links using the .nav-icon class
           with font-awesome or any other icon font library -->
           <li class="nav-item has-treeview">
        <a href="#" class="nav-link">
          <i class="nav-icon fas fa-edit"></i>
            Kelola
            <i class="fas fa-angle-left right"></i>
        </a>
        <ul class="nav nav-treeview">
          <li class="nav-item">
            <a href="${adminURL}/user" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              Pengguna
            </a>
          </li>
          <li class="nav-item">
            <a href="${adminURL}/properties" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>Pengaturan Sistem</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${kasirURL}/vehicle" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>Kendaraan</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${kasirURL}/petani" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>Petani</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${kasirURL}/agen" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>Agen</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${kasirURL}/piutang" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>Piutang</p>
            </a>
          </li>
        </ul>
      </li>
      
      
      
      
      
    </ul>
    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
      <!-- Add icons to the links using the .nav-icon class
           with font-awesome or any other icon font library -->
           <li class="nav-item has-treeview">
        <a href="#" class="nav-link">
          <i class="nav-icon fas fa-edit"></i>
            Transaksi
            <i class="fas fa-angle-left right"></i>
        </a>
        <ul class="nav nav-treeview">
          <li class="nav-item">
            <a href="${kasirURL}/timbangGantung" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              Timbang Gantung
            </a>
          </li>
          <li class="nav-item">
            <a href="${kasirURL}/harga" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>Harga Sawit</p>
            </a>
          </li>
          
        </ul>
      </li>
    </ul>
  </nav>
  <!-- /.sidebar-menu -->
</div>
<!-- /.sidebar -->