
<%@page import="Modelo.AreaPOJO"%>
<%@page import="Controlador.AreaDAO"%>
<%@page import="Modelo.SolicitudPOJO"%>
<%@page import="Controlador.SolicitudDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.UsuarioPOJO"%>
<%@page import="Controlador.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Adinelsa-Menu</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<% 
      
        
        
        if(session.getAttribute("dni")==null){
            response.sendRedirect("login_error.jsp");
        }
      UsuarioDAO usuDao=new UsuarioDAO();
      String usu_dni=session.getAttribute("dni").toString();
      UsuarioPOJO usu=usuDao.RecuperarUsuario(usu_dni);
      AreaDAO areDAO=new AreaDAO();
  %>

<body id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Inicio  Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="menu1.jsp">
        <div class="sidebar-brand-text mx-3">Adinelsa</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="menu1.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Cuadro de Mando</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Utilidades
      </div>

      
      <!-- Item de SidBar -->
      <li class="nav-item">
        <a class="nav-link" href="menu1.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Evaluar Solicitudes</span></a>
      </li>
      
      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Solicitudes Evaluadas</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Aprobadas|Desaprobadas:</h6>
            <a class="collapse-item" href="soliAprobadas.jsp">Solicitudes Aprobadas</a>
            <a class="collapse-item" href="soliDesaprobadas.jsp">Solicitudes Desaprobadas</a>
          </div>
        </div>
      </li>
     

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- Fin de Sidebar -->
<!-- 
  https://sistemas.mpfn.gob.pe/paginas/RENADES/index.php?sis=11
-->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">


        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
        <span class="mr-2 d-none d-lg-block text-gray-600 small"> <%= usu.getNombrearea() %> </span>
          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
            </li>


            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%= usu.getNombres()+" "+usu.getApellidos() %></span>
                <img class="img-profile rounded-circle" src="http://tusimagenesde.com/wp-content/uploads/2018/03/foto-perfil-1.png">
              </a>
              <!-- Dropdown - Informacion Perfil -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <div class="dropdown-item"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Cerrar Sesion
                </a>
              </div>
            </li>

          </ul>
        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        
        <%
            SolicitudDAO soliDAO=new SolicitudDAO();
            ArrayList<SolicitudPOJO>listaSoliEstado=new ArrayList<SolicitudPOJO>();
            listaSoliEstado=soliDAO.RecuperarSolicitudEstado("0");
        
        %>
        
        <div class="container-fluid">
          <!-- Content Row -->
          
         <!-- Contenido de la pagina -->

            <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Evalue las Solicitudes</h1>
          <p class="mb-4">Para evaluar las siguientes solicitudes, tenga en cuenta el presupuesto asignado.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-danger">Solicitudes Pendientes</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>Descripcion</th>
                      <th>Fecha</th>
                      <th>Usuario</th>
                      <th>Area</th>
                      <th>Estado</th>
                      <th>Accion</th>   
                    </tr>
                  </thead>
                  
                  <tbody>
                    
                        <% int i=0; 
                        for(SolicitudPOJO soliEstado: listaSoliEstado){
                            i++;
                            AreaPOJO areaPojo=areDAO.RecuperarArea(soliEstado.getFk_areaDestino());
                        %>
                      <tr>
                        <th scope="row"> <a href="verDetalleSolicitud.jsp?idSoli=<%= soliEstado.getIdSolicitud() %>"><%= i %></a> </th>
                        <td> <%= soliEstado.getDescripcion() %> </td>
                        <td><%= soliEstado.getFecha()%>  </td>
                        <td><%= soliEstado.getFkUsuario() %></td>
                        <td> <%= areaPojo.getNombreArea() %></td>
                        <td><%= "Pendiente" %></td>
                        <td> <a class="btn btn-success" href="verDetalleSolicitud.jsp?idSoli=<%= soliEstado.getIdSolicitud() %>">Ver</a> </td>
                        
                      </tr>
                      <%}%>
                   
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy;GRUPO F</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Botton de scroll-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Modal cerrar sesion-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Cerrar</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">¿Desea Cerrar Sesion?</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
          <a class="btn btn-primary" href="logout">Salir</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>
  
  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>

</body>

</html>
