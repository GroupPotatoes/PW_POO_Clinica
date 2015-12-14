<%@page session = "true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- BOOTSTRAP CDN LINKS: Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendamento de Consultas</title>
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
                            <li id="active" class="active"><a href="criarconsulta_carregarespecializacao.jsp">Marcar consulta</a></li>
                            <li><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                            <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                          </ul>
                        </li> 
                    </ul>
                </div>
            </div>
            <div class="col-md-10">
                <div id="page-container">
                    <form action="criarconsulta_marcarconsulta.jsp">
                            <div id="disponibilidade">
                                <%
                                    int idhealthProfessionals = 0;
                                    if (request.getParameter("healthprofessionals") != null) {
                                        idhealthProfessionals = Integer.parseInt(request.getParameter("healthprofessionals"));
                                    }

                                    String data = session.getAttribute("dateselected").toString();
                                    int dayofweek = (Integer)session.getAttribute("dayOfWeek");

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
                                <div class="radio">
                                    <label><input type="radio" name="availability" value="<%= av.getId()%>"><%= av%></label>
                                </div>
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

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>