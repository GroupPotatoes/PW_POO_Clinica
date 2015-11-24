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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Minhas Consultas</title>        
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
                            <li><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                            <li><a href="#">Proximas consultas</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="row">
            <div class="col-lg-2">
            </div> 
            <div class="col-lg-8">
                <form action="excluir_consulta.jsp">
                    <div id="lst" class="list-group">
                        <!-- Para cada consulta, um item desse -->
                        <%
                            String now = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                            boolean empty = true;
                    
                            DoctorAppointmentDAO doctorAppDAO = new DoctorAppointmentDAO();
                            for (DoctorAppointment doctorApp : doctorAppDAO.SelectAllPatientDoctorAppointment((int) session.getAttribute("patientID"))) {
                                if (doctorApp.getDate().compareTo(now) > 0) {
                                    empty = false;
                        %>
                        <input name="doctorApp" type="radio" value="<%= doctorApp.getId()%>"> <%= doctorApp%><br> 
                        <%
                                }
                            }
                            if (empty == true) {
                        %> Nenhuma consulta futura registrada.

                        <% }%>
                    </div>                
                    <div class="button-group">                       
                        <button type="submit" class="btn btn-default">Excluir</button>
                    </div> 
                </form>
            </div> 
            <div class="col-lg-2">
            </div>
        </div>
    </body>
</html>

