<%@page session = "true" %>
<%@page import="Module.DAO.AvailabilityDAO"%>
<%@page import="Module.DAO.Availability"%>
<%@page import="Module.DAO.DoctorAppointment"%>
<%@page import="Module.DAO.DoctorAppointmentDAO"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>Resultado das consultas</title>
        <link rel="icon" type="image/png" href="images/logo_oficial.png" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
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
                            <li id="active" class="active"><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                            <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                          </ul>
                        </li> 
                    </ul>
                </div>
            </div>
            <div class="col-md-10"> 
                <div id="page-container">
                    <%
                        if(request.getParameter("doctorApp") == null)
                            response.sendRedirect("consultasanteriores.jsp"); 
                        else{
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
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
