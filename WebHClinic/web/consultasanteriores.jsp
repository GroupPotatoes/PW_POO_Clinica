<%-- 
    Document   : consultasanteriores
    Created on : Nov 24, 2015, 12:41:03 AM
    Author     : amanda
--%>
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
    </head>
    <body>
        <div id="row">
            <nav class="navbar navbar-fixed-top">
                <ul class="topMenu">
                    <li> <a href="home.jsp" class="current">Home</a>
                    <li> <a href="#">Administrar conta</a>
                        <ul class="subMenu">
                            <li><a href="alterar.html">Alterar</a></li>
                            <li><a href="excluir.html">Excluir</a></li>
                        </ul>
                    </li>
                    <li> <a href="#">Consultas</a>
                        <ul class="subMenu">
                            <li><a href="criarconsulta_carregarespecializacao.jsp">Marcar consulta</a></li>
                            <li><a href="#">Consultas anteriores</a></li>
                            <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
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
                    boolean empty = true;
                    DoctorAppointmentDAO doctorAppDAO = new DoctorAppointmentDAO();
                    for (DoctorAppointment doctorApp : doctorAppDAO.SelectAllPatientDoctorAppointment((int) session.getAttribute("patientID"))) {
                        if (doctorApp.getDate().compareTo(now) < 0) {
                            empty = false;
                            if (!doctorApp.getMedicalExamRequest().isEmpty()
                                    && !doctorApp.getObservation().isEmpty()
                                    && !doctorApp.getPrescription().isEmpty()
                                    && !doctorApp.getRecommendation().isEmpty()) {
                  //Se tudo no bd já foi preenchido, campo disponível para resultado:              
                %>
                <input name="doctorApp" type="radio" value="<%= doctorApp.getId()%>"> <%= doctorApp%> <i class="fa fa-heart"></i>
                <br> 
                <%
                } else {
                //Visivel mas não disponível para consultar resultado:
                %>
                <input name="doctorApp" type="radio" value="<%= doctorApp.getId()%>" disabled> <%= doctorApp%> <i class="fa fa-heart-o"></i>
                <br> 
                <%
                            }
                        }
                    }
                    if (empty == true) {
                %> Nenhuma consulta anterior registrada.

                <% }%>         
                <br>
                <br>
                <div class="button-group">                       
                    <button type="submit" class="btn btn-default">Ver resultado</button>
                </div> 
            </form>
        </div>
    </body>
</html>
