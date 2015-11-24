<%-- 
    Document   : resultado
    Created on : Nov 23, 2015, 9:40:58 PM
    Author     : amanda
--%>
<%@page import="Module.DAO.AvailabilityDAO"%>
<%@page import="Module.DAO.Availability"%>
<%@page import="Module.DAO.DoctorAppointment"%>
<%@page import="Module.DAO.DoctorAppointmentDAO"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado das consultas</title>
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
                            <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <%
            int idApp = Integer.parseInt(request.getParameter("doctorApp"));
            if (idApp == 0) {
        %> 
        Houve um erro na sua requisição. Não há consulta a ser mostrada. 
        <%
        } else {
            DoctorAppointment docApp = new DoctorAppointmentDAO().getAppointmentResults(idApp);
            //If results are empty
            if (docApp.getMedicalExamRequest().isEmpty()
                    && docApp.getObservation().isEmpty()
                    && docApp.getPrescription().isEmpty()
                    && docApp.getRecommendation().isEmpty()) {
        %>
        Não há resultado disponível para esta consulta.

        <%
        } else {
        %>
        <div class="panel panel-info">
            <div class="panel-heading">Consulta do dia <%= docApp.getDate()%></div>
            <table class="table">
                <tr>
                    <td>Data e horário: </td>
                    <%
                        String inicio = docApp.getIniciation();
                        String fim = docApp.getFinish();
                        inicio = inicio.substring(0, inicio.length() - 11);
                        fim = fim.substring(0, fim.length() - 11);
                    %>
                    <td><%= docApp.getDate()%></td>
                    <td><%= inicio%> às <%= fim%> </td>
                </tr>
                <tr>
                    <%
                        Availability av = new AvailabilityDAO().getAvailability(docApp.getIdAvailability());
                    %>
                    <td>Médico: </td>
                    <td><%= av.getIdHealthProfessionals().getName()%></td>
                    <td><%= av.getIdHealthProfessionals().getIDClass()%></td>
                </tr>
                <tr>
                    <td>Observações: </td>
                    <td><%= docApp.getObservation()%></td>
                </tr>
                <tr>
                    <td>Recomendações: </td>
                    <td><%= docApp.getRecommendation()%></td>
                </tr>
                <tr>
                    <td>Exames: </td>
                    <td><%= docApp.getMedicalExamRequest()%></td>
                </tr>
                <tr>
                    <td>Prescrição/Receita: </td>
                    <td><%= docApp.getPrescription()%></td>
                </tr>
            </table>
        </div>
        <%
                }
            }

        %>
    </body>
</html>
