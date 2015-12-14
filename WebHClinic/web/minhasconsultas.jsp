<%@page session = "true" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="Module.DAO.DoctorAppointment"%>
<%@page import="Module.DAO.DoctorAppointmentDAO"%>
<%@page import="Module.DAO.Availability"%>
<%@page import="Module.DAO.AvailabilityDAO"%>
<%@page import="Module.DAO.Specialization"%>
<%@page import="java.util.List"%>
<%@page import="Module.DAO.SpecializationDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html>
    <head>
         <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- BOOTSTRAP CDN LINKS: Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Minhas Consultas</title>  
        <link rel="icon" type="image/png" href="images/logo_oficial.png" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
             
    </head>
    <body>        
       <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script type='text/javascript' src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type='text/javascript'>      
        $(document).ready(function() {   
        });
        </script>
        <script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
          ga('create', 'UA-40413119-1', 'bootply.com');
          ga('send', 'pageview');
        </script>
        <div class="row">
            <div class="col-md-2">
                <div id='menu'>
                    <img src="images/logo_oficial.png" class="img-responsive" alt="Cinque Terre">
                    <ul class="nav nav-pills nav-stacked left-menu" id="stacked-menu">
                        <li><a href="home.jsp">Home</a></li>
                        <li>
                          <a href="#" data-target="#item1" data-toggle="collapse" data-parent="#stacked-menu">Editar perfil<span class="caret arrow"></span></a>
                          <ul class="nav nav-stacked collapse left-submenu" id="item1">
                            <li><a href="alterarcadastro.jsp">Alterar conta</a></li>
                            <li><a href="excluircadastro.jsp">Excluir conta</a></li>
                          </ul>
                        </li>
                        <li>
                          <a href="#" data-target="#item2" data-toggle="collapse" data-parent="#stacked-menu">Consultas<span class="caret arrow"></span></a>
                          <ul class="nav nav-stacked collapse left-submenu" id="item2">
                            <li><a href="criarconsulta_carregarespecializacao.jsp">Marcar consulta</a></li>
                            <li><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                            <li id="active" class="active"><a href="#">Proximas consultas</a></li>
                          </ul>
                        </li> 
                    </ul>
                </div>
            </div>
            <div class="col-md-10">
                <div id="page-container">
                    <div id="row">
                        <div class="col-lg-12">
                            <form action="excluir_consulta.jsp">
                                <div id="lst" class="list-group">
                                    <!-- Para cada consulta, um item desse -->
                                    <%
                                        String now = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

                                        DoctorAppointmentDAO doctorAppDAO = new DoctorAppointmentDAO();
                                        int IDPatient = (Integer) session.getAttribute("patientID");
                                        List<DoctorAppointment> doctorAppointments = doctorAppDAO.SelectAllNextPatientDoctorAppointment(IDPatient);
                                        if(!doctorAppointments.isEmpty())
                                        {
                                            for (DoctorAppointment doctorApp : doctorAppointments) 
                                            {
                                                if (doctorApp.getDate().compareTo(now) > 0) 
                                                {
                                    %>
                                                    <div class="radio">
                                                        <label><input type="radio" name="doctorApp" value="<%=doctorApp.getId()%>"><%=doctorApp%></label>
                                                    </div>
                                    <%
                                                }
                                            }
                                    %>                             
                                    <div class="button-group">                       
                                        <button id="btnexluir" type="submit" class="btn btn-default">Excluir</button>
                                    </div> 
                                    <%
                                        }
                                        else
                                        {
                                    %>
                                          Nenhuma consulta futura registrada.
                                    <%
                                        }
                                    %>
                                </div> 
                            </form>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

