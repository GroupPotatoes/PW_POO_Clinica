<%@page session = "true" %>
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
            </div>
        </div>
    </body>
</html>
