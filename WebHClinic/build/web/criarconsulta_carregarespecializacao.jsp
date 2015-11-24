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
                        <li><a href="#">Marcar consulta</a></li>
                        <li><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                        <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>                    </ul>
                </li>
            </ul>
        </nav>
        <%
            SpecializationDAO specializationDAO = new SpecializationDAO();
            List<Specialization> specializations = specializationDAO.SelectAllSpecialization();
        %>
        <form action="criarconsulta_carregarmedicos.jsp">
            <div id="page-container">
                <div>
                    <label>Especialidade: </label>
                    <select name="specialization" id="specialization">
                        <%
                            for (Specialization s : specializations) {
                        %>
                        <option value="<%= s.getId()%>"><%= s.getNome()%></option>
                        <%

                            }
                        %>
                    </select>
                    <div class="form-group">
                        <label for="filter_date">Data:</label>
                        <input type="date" name="date">
                    </div>
                </div>
                <div>
                    <button type="submit" value="submit" class="btn btn-default">Próximo</button>
                </div>
            </div>
        </form>
    </body>
</html>
