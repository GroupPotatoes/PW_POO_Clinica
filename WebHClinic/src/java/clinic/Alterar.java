package clinic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Module.DAO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet que valida a alteração do cadastro de um funciomário.
 * @author Maiara Rodrigues
 */
@WebServlet(name = "Alterar", urlPatterns = {"/Alterar"})
public class Alterar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String cpf = request.getParameter("cpf");
            String cep = request.getParameter("cep");
            String number = request.getParameter("number");
            String complement = request.getParameter("complement");
            String phone_type = request.getParameter("phone_type");
            String phone_number = request.getParameter("phone_number");
            String area_code = request.getParameter("area_code");
            String login = request.getParameter("login");
            String senha = request.getParameter("password");
            if(alterando(login, senha, name, cpf, cep, number, 
                complement, phone_type, 
                phone_number, area_code)){
                out.println("<html>"
                            + "<head>"
                                + "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>"
                                + "<title>Alteração concluída com sucesso!</title>"
                                + "<meta charset=\"UTF-8\">"
                                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"                    
                            + "</head>"
                            + "<BODY>"
                                + "<form id=\"page-container\">"
                                    + "<p>Parabéns! Seu cadastro foi alterado com sucesso! <br>"
                                    + "<p>Volte agora para a <a href=\"home.jsp\">tela inicial</a>, e continue a"
                                    + " mexer em nosso sistema!</p>"
                                + "</form>"
                            + "</BODY>"
                        + "</html>");
            }else{
                out.println("<html>"
                            + "<head>"
                                + "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>"
                                + "<title>Erro ao realizar alteração :(</title>"
                                + "<meta charset=\"UTF-8\">"
                                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"                    
                            + "</head>"
                            + "<BODY>"
                                + "<form id=\"page-container\">"
                                    + "<p>Seu cadastro não foi alterado com sucesso...<br>"
                                    + "<p>Volte para a <a href=\"alterar.html\">tela de cadastrosl</a>, e tente repetir a operação."
                                + "</form>"
                            + "</BODY>"
                        + "</html>");
            }            
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    protected boolean alterando(String login, String senha, String name,
            String cpf,  String cep, String number,  String comp, String phone_type,
            String phone_number, String area_code){
        try{
            
            //criando o paciente
            Patient patient = new Patient(ConnectionSetup.id, name, cep, cpf, number, comp, login, senha);
            PatientDAO patientDAO = new PatientDAO();
            
            //inserindo
            patientDAO.UpdatePatient(patient);
            return true;
        }catch(SQLException e){
            e.getMessage();
        } catch (ParseException ex) {
            Logger.getLogger(Alterar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Alterar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
