package clinic;

import Module.Controle;
import Module.DAO.PatientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidateRegistration", urlPatterns = {"/ValidateRegistration"})
public class ValidateRegistration extends HttpServlet {

    protected String login, senha, nome;
    protected PatientDAO patientDAO;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        this.nome=name;
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String number = request.getParameter("number");
        String complement = request.getParameter("complement");
        String phone_type = request.getParameter("phone_type");
        String phone_number = request.getParameter("phone_number");
        String area_code = request.getParameter("area_code");
        this.generateLoginPassword();
        if(WebClinic.registerValidate(this.login, this.senha, this.nome, cpf, cep, number, 
                complement, phone_type, phone_number, area_code)) {
            out.println("<html>"
                            + "<head>"
                                + "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>"
                                + "<title>Cadastro efetuado com sucesso!</title>"
                                + "<meta charset=\"UTF-8\">"
                                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"                    
                            + "</head>"
                            + "<BODY>"
                                + "<form id=\"page-container\">"
                                    + "<p>Parabéns! Seu cadastro foi efetuado com sucesso! <br>"
                                    + "Anote seu login e sua senha:</p>"
                                    + "<table>"
                                        + "<tr>"
                                            + "<td><b>Login: </b></td>"
                                            + "<td>"+this.login+"</td>"
                                        + "</tr>"
                                        + "<tr>"
                                            + "<td><b>Senha: </b></td>"
                                            + "<td>"+this.senha+"</td>"
                                        + "</tr>"
                                    + "</table>"
                                    + "<p>Faça seu login <a href=\"index.jsp\">aqui</a></p>"
                                + "</form>"
                            + "</BODY>"
                        + "</html>");
        }
        else {
            request.setCharacterEncoding("UTF-8");
            out.println("<html>"
                            + "<head>"
                                + "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>"
                                + "<title>Cadastro não efetuado :(</title>"
                                + "<meta charset=\"UTF-8\">"
                                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"                    
                            + "</head>"
                            + "<BODY>"
                                + "<form id=\"page-container\">"
                                    + "<p>Erros no seu cadastro!<br> <br>"
                                    + "Favor <a href=\"register.html\">voltar à tela de cadastro</a> e reinicie"
                                    + " o processo.</p>"
                                + "</form>"
                            + "</BODY>"
                        + "</html>");
        }
    }

    protected void generateLoginPassword() throws SQLException, ClassNotFoundException{
        //criando os vetores de login e senha de acordo com o tamanho dos caracteres
        char    l[] = new char[Controle.NUM_CARACTERES_LOGIN.getValor()],
                s[] = new char[Controle.NUM_CARACTERES_SENHA.getValor()];     
        
        Random random = new Random();    
        
        do{
            //:::::::::::::::::::::::::::::: LOGIN ::::::::::::::::::::::::::::::
            
            //adicionando os valores iniciais e finais [com base na tabela ASCII] aos inteiros
            int valorMinimo=Controle.ASCII_VALOR_MIN.getValor(),
                valorMaximo=Controle.ASCII_VALOR_MAX.getValor();
            
            //atrelando os dois caracteres iniciais com o nome da pessoa
            l[0]=nome.charAt(0);
            l[1]=nome.charAt(1);
            
            //me baseando no valor do Enum para a parada do laço
            for(int i=2;i<Controle.NUM_CARACTERES_LOGIN.getValor();i++){ 
                //atribuindo a cada posição do vetor um char, que será gerado randomicamente
                //entre os valores mínimos e máximos
                l[i] = (char)(valorMinimo+random.nextInt(valorMaximo-valorMinimo));
            }
            
            //:::::::::::::::::::::::::::::: SENHA ::::::::::::::::::::::::::::::

            //me baseando no valor do Enum para a parada do laço
            for(int i=0;i<Controle.NUM_CARACTERES_SENHA.getValor();i++){                 
                //atribuindo a cada posição desse vetor um número aleatório (que vai até o 9), na base 10
                s[i] = Character.forDigit(random.nextInt(9), 10);                
            }
            
            //:::::::::::::::::::::::::::::: ATRIBUINDO VALORES ::::::::::::::::::::::::::::::
            
            //copyValueOf() transforma um vetor de chars em uma String :)
            this.login=String.copyValueOf(l);
            this.senha=String.copyValueOf(s);
        
            //execução da lógica enquanto o login e a senha não forem exclusivos
            this.patientDAO = new PatientDAO();
        }
        while(!exclusive(this.login, this.senha));
    }
    
    protected boolean exclusive(String login, String senha) throws SQLException{
        return !(patientDAO.ExistLogin(login, senha));
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ValidateRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ValidateRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
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
