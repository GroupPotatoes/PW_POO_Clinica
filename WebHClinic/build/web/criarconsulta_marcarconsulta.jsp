<%@page import="Module.DAO.DoctorAppointmentDAO"%>
<%@page import="Module.DAO.DoctorAppointment"%>
<%@page session = "true" %>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendamento de Consultas</title>
    </head>
    <body>
        <nav class="navbar navbar-fixed-top"><ul class="topMenu">
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
                        <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>                    </ul>
                </li>
            </ul>
        </nav>
        <%
            ///TODO: verificacao de erro
            int availabilityID = Integer.parseInt(request.getParameter("availability"));

            AvailabilityDAO availabilityDAO = new AvailabilityDAO();

            //Pegando horario da diponibilidade selecionada. Se tiver outro jeito de fazer, melhor.
            String inciation = availabilityDAO.SelectIniciationAvailability(availabilityID);
            String finish = availabilityDAO.SelectFinishAvailability(availabilityID);

            int patientID = ((int) session.getAttribute("patientID"));
            String date = ((String) session.getAttribute("dateselected"));

            //int idPatient, int idAvailability, String iniciation, String finish, String date
            DoctorAppointment doctorAppointment = new DoctorAppointment(patientID, availabilityID, inciation, finish, date);
            DoctorAppointmentDAO doctorDAO = new DoctorAppointmentDAO();

            String message = "ERRO! Não foi possível marcar a consulta. Tente de novo!";

            if (doctorDAO.insertDoctorAppointment(doctorAppointment)) {
                message = "Consulta foi marcada com sucesso.";
            }

        %>
        <div id="page-container">
            <%= message%>
        </div>

    </body>
</html>
