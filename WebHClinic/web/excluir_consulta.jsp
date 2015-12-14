<%@page session = "true" %>
<%@page import="Module.DAO.DoctorAppointmentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <% 
            if(request.getParameter("doctorApp") != null)
            {
                int idDoctorApp = Integer.parseInt(request.getParameter("doctorApp"));
                DoctorAppointmentDAO doctorAppDAO = new DoctorAppointmentDAO();
                doctorAppDAO.RemoveDoctorAppointment(idDoctorApp);
            }
            
            response.sendRedirect("minhasconsultas.jsp");    
        %>
    </body>
</html>
 