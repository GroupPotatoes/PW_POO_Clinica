/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 14432843
 */
@WebServlet(name = "ValidateRegistration", urlPatterns = {"/ValidateRegistration"})
public class ValidateRegistration extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String number = request.getParameter("number");
        String complement = request.getParameter("complement");
        String phone_type = request.getParameter("phone_type");
        String phone_number = request.getParameter("phone_number");
        String area_code = request.getParameter("area_code");
        //if(registerValidate(login, senha, name, cpf, cep, number, complement, phone_type, phone_number, area_code) {
        if(login !=  null){
            out.println("<html>");
            out.println("  <head>");
            out.println("    <title>Cadastro efetuado!</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <br/>Seu cadastro foi efetuado com sucesso!<br/>Faça seu login: </br>");
            out.println("    <iframe src=\"index.html\" width=\"200\" height=\"200\" style=\"border:none\"></iframe>");
            out.println("  </body>");
            out.println("</html>");
        }
        else {
            out.println("<html>");
            out.println("  <head>");
            out.println("    <title>Cadastro não efetuado</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <br/>Houve alguma falha no seu cadastro. Tente novamente.<br/>");
            out.println("  </body>");
            out.println("</html>");
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
