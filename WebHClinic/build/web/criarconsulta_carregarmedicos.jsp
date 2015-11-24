<%@page import="java.util.Calendar"%>
<%@page import="Module.DAO.HealthProfessionals"%>
<%@page import="Module.DAO.HealthProfessionalsDAO"%>
<%@page import="Module.DAO.Availability"%>
<%@page import="java.util.List"%>
<%@page import="Module.DAO.AvailabilityDAO"%>
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
        <form action="criarconsulta_carregardisponibilidade.jsp">
            <div id="page-container">
                <%
                    String message = "";
                    String dateSelected = request.getParameter("date");
                    int idSpecialization = Integer.parseInt(request.getParameter("specialization"));

                    session.setAttribute("dateselected", dateSelected);
                    session.setAttribute("idSpecialization", idSpecialization);

                    String data = session.getAttribute("dateselected").toString();
                    Date date = Date.valueOf(data);
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

                    session.setAttribute("dayOfWeek", dayOfWeek);

                    HealthProfessionalsDAO hpDAO = new HealthProfessionalsDAO();
                    List<HealthProfessionals> hpList = hpDAO.SelectHealthProfessionals(idSpecialization, dayOfWeek);
                    if (!hpList.isEmpty()) {
                %>   
                <div id="disponibilidade">
                    <label>Selecionar médico de preferência: </label>
                    <select name="healthprofessionals" id="healthprofessionals">
                        <option value="0">Nenhum</option>
                        <%
                            for (HealthProfessionals hp : hpList) {
                        %>
                        <option value="<%= hp.getidRegisteredEmployee()%>"><%= hp.getName()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div>
                    <button type="submit" value="submit" class="btn btn-default">Próximo</button>
                </div>
                <%
                    } else {
                        message = "Não foi encontrado médicos disponíveis nessa data.";
                    }
                %> 
                <%= message%>
            </div> 
        </form>
    </body>
</html>
