<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Module.DAO.DoctorAppointmentDAO"%>
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
                        <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <form action="criarconsulta_marcarconsulta.jsp">
            <div id="page-container">
                <div id="disponibilidade">
                    <%
                        int idhealthProfessionals = 0;
                        if (request.getParameter("healthprofessionals") != null) {
                            idhealthProfessionals = Integer.parseInt(request.getParameter("healthprofessionals"));
                        }

                        String data = session.getAttribute("dateselected").toString();
                        int dayofweek = (int) session.getAttribute("dayOfWeek");

                        //Pegando as horas ocupadas por uma data selecionada pelo paciente
                        DoctorAppointmentDAO doctorApp = new DoctorAppointmentDAO();
                        List<String> busyHours = doctorApp.SelectBusyHours(data);

                        //Pegando as disponibilidades por um dia da semana da data selecionada, uma especialização e um medico se tiver sido selecionado
                        AvailabilityDAO avDAO = new AvailabilityDAO();
                        List<Availability> avs = avDAO.SelectAllAvailability(Integer.parseInt(session.getAttribute("idSpecialization").toString()), dayofweek, idhealthProfessionals);
                       //fazendo uma copia da lista para conseguir manipular a lista e rodar ela ao mesmo tempo

                        //List listaB = new ArrayList(listaA); copia sem referencia
                        List<Availability> avscopy = new ArrayList(avs);

                        //tirando os horarios ocupados que ja tem consulta
                        for (String h : busyHours) {
                            for (Availability av : avscopy) {
                                if (h.equals(av.getIniciation().toString())) {
                                    avs.remove(av);
                                }
                            }
                        }

                        if (!avs.isEmpty()) {
                    %>
                    <label> Disponibilidades: </label>
                    <%
                        for (Availability av : avs) {
                    %> 
                    <input name="availability" type="radio" value="<%= av.getId()%>"><%= av%><br>
                    <%
                        }
                    %>
                </div>
                <div>
                    <button type="submit" value="submit" class="btn btn-default">Marcar consulta</button>
                </div>
                <%
                } else {
                    String message = "Não foi possível encontrar horário disponível.";
                %>
                <div>
                    <%= message%>
                </div>
                <%
                    }
                %>
            </div>
        </form>
    </body>
</html>