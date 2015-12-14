<%@page session = "true" %>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="Module.DAO.DoctorAppointment"%>
<%@page import="Module.DAO.DoctorAppointmentDAO"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultas anteriores</title>
        <link rel="icon" type="image/png" href="images/logo_oficial.png" />
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
                            <li id="active" class="active"><a href="#">Consultas anteriores</a></li>
                            <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                          </ul>
                        </li> 
                    </ul>
                </div>
            </div>
            <div class="col-md-10"> 
                <div id="page-container">
                    <form action="resultado.jsp">
                        <h4>Selecione a consulta para visualizar o resultado.</h4>
                        <h6>
                                 <i class="fa fa-heart"></i> = Resultado disponível <br>
                                 <i class="fa fa-heart-o"></i> = Resultado indisponível <br><br>
                        </h6>
                        <br>
                        <%
                            String now = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                            DoctorAppointmentDAO doctorAppDAO = new DoctorAppointmentDAO();
                            int patientID = (Integer) session.getAttribute("patientID");
                            List<DoctorAppointment> doctorAppointments = doctorAppDAO.SelectAllLastPatientDoctorAppointment(patientID);   
                            if(!doctorAppointments.isEmpty())
                            {
                                for (DoctorAppointment doctorApp : doctorAppointments) 
                                {
                                    if (doctorApp.getDate().compareTo(now) < 0) 
                                    {
                                        if (!doctorApp.getMedicalExamRequest().isEmpty()
                                                && !doctorApp.getObservation().isEmpty()
                                                && !doctorApp.getPrescription().isEmpty()
                                                && !doctorApp.getRecommendation().isEmpty()) 
                                        {
                                                //Se tudo no bd já foi preenchido, campo disponível para resultado:              
                                          %>
                                          <input name="doctorApp" type="radio" value="<%= doctorApp.getId()%>"> <%= doctorApp%> <i class="fa fa-heart"></i>
                                          <br> 
                                          <%
                                        } 
                                        else {
                                          //Visivel mas não disponível para consultar resultado:
                                          %>
                                          <input name="doctorApp" type="radio" value="<%= doctorApp.getId()%>" disabled> <%= doctorApp%> <i class="fa fa-heart-o"></i>
                                          <br> 
                                          <%
                                        }
                                    }
                                }
                                          %>     
                                          <div class="button-group">                       
                                              <button type="submit" class="btn btn-default">Ver resultado</button>
                                          </div> 
                                          <%     
                            }
                            else
                            {
                                        %> 
                                Nenhuma consulta anterior registrada.

                        <% }%>         
                        <br>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
