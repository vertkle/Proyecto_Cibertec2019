<%@page import="Modelo.DetalleSolicitudPOJO"%>
<%@page session="true"%>
<%@page import="Controlador.ProfesionDAO"%>
<%@page import="Modelo.ProfesionPOJO"%>
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
  
  <% 
      
        
        
        if(session.getAttribute("dni")==null){
            response.sendRedirect("login_error.jsp");
        }
      UsuarioDAO usuDao=new UsuarioDAO();
      String usu_dni=session.getAttribute("dni").toString();
      UsuarioPOJO usu=usuDao.RecuperarUsuario(usu_dni);
      
      
      //Recuperar Profesiones
      ArrayList<ProfesionPOJO>lista=new ArrayList<ProfesionPOJO>();
      ProfesionDAO proDAO=new ProfesionDAO();
      lista=proDAO.ListarProfesion();
  
  %>

</head>

<body id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Inicio  Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="menu2.jsp">
        <div class="sidebar-brand-text mx-3">Adinelsa</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="menu2.jsp">
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
        <a class="nav-link" href="menu2.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Registrar Solicitudes</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="solicitudesRegistradas.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Ver Solicitudes Registradas</span></a>
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
        <span class="mr-2 d-none d-lg-block text-gray-600 small"> <%= usu.getNombrearea()%> </span>
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
                  <span class="mr-2 d-none d-lg-block text-gray-600 small"> <%= usu.getNombres() + usu.getApellidos() %> </span>
                  
                 
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
        <div class="container-fluid">
          <!-- Content Row -->
          <div class="row">
              
         <!-- Contenido de la pagina -->

         
         <div class="col-lg-9">
             
             <h4>Registrar Requerimiento de Personal</h4>
             <!-- FORM REGISTRAR SOLICITUD -->
             <form action="insertarSolicitud">
             
             <div class="form-group">
                  <label for="exampleFormControlTextarea1">Descripcion de la Solicitud</label>
                  <textarea required  cols="40" rows="5" name="etDescripcion" onkeyup="contarCaracteres(this);" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                  <p id="charNum">0 Caracteres</p>
                </div>
             
                <div class="form-group col-lg-4">
                  <label for="exampleFormControlInput1">Ingrese Fecha de Solicitud</label>
                  <input required type="date" name="etFecha" class="form-control" id="exampleFormControlInput1">
                </div>
             <input type="submit" value="Enviar Solicitud" class="btn btn-info"/>
             <hr>
             
              
        </form>
             
             <!-- FORM AGREGAR DETALLE -->
             
             
          <form action="detalleSolicitud">
                 <h4>Ingrese Detalle de solicitud</h4>
             <div class="row">
                 <div class="form-group col-lg-3">
                <label for="exampleFormControlSelect1">Seleccione Profesion:</label>
                <select class="form-control" id="exampleFormControlSelect1" name="etprofesion">
                    <% for(ProfesionPOJO pro:lista){ %>
                    <option value=<%= pro.getIdprof() %>><%= pro.getProfesion() %></option>
                  
                  <%}%>
                </select>
             </div>
                 
             <div class="form-group col-lg-3">
                <label for="exampleFormControlSelect1">Ingrese Salario estimado:</label>
                <input type="number" class="form-control" id="exampleFormControlInput1" name="etSalario" required />
             </div>
                 
              <div class="form-group col-lg-3">
                <label for="exampleFormControlSelect1">Ingrese Cantidad de personal:</label>
                <input type="number" class="form-control" id="exampleFormControlInput1" name="etCantidadPersonal" required />
             </div>
                  
                  <button class="btn btn-success col-lg-3">Agregar</button>
             </div>
            
                  <hr>  
       </form>
                <a href="eliminarDetalle" class="btn btn-danger col-lg-3">Eliminar Datos Tabla</a>
                
                <%
                    
                 HttpSession sesion=request.getSession();
                 ArrayList<DetalleSolicitudPOJO>listaDetalle=new ArrayList<DetalleSolicitudPOJO>();
                if(sesion.getAttribute("detalle")!=null){
                    listaDetalle=(ArrayList<DetalleSolicitudPOJO>)sesion.getAttribute("detalle");
                }

                  
             %>
        </div>
    
     </div>
                  
     <div class="row">
           
         <div class="col-lg-9">
             <table class="table table-hover">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Profesion</th>
                        <th scope="col">Salario</th>
                        <th scope="col">Cantidad</th>
                      </tr>
                    </thead>
                    <tbody>
                        <% int i=0;
                            for(DetalleSolicitudPOJO det:listaDetalle){
                             i++;
                             ProfesionPOJO proPOJO=proDAO.RecuperarProfesion(det.getCodProfesion());
                        %>
                      <tr>
                        <th scope="row"><%= i %></th>
                        <td><%= proPOJO.getProfesion() %></td>
                        <td><%= "S/."+det.getSalario()%></td>
                        <td><%= det.getCantidadPersonal()  %></td>
                        
                      </tr>
                     <% } %>
                    </tbody>
            </table>
             
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
            <span>Copyright &copy;Klevert Herrera</span>
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
  




</body>


</html>
