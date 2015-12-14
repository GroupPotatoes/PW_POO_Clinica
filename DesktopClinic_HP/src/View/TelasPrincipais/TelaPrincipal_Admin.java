package View.TelasPrincipais;

import Module.DBO.ConnectionSetup;
import View.Common.TelaExclusao;
import View.Employee.*;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class TelaPrincipal_Admin extends javax.swing.JFrame {

    private final JPanel parentPanel;
    final Welcome welcomepanel = new Welcome();
    final TelaExclusao excluiCadastroMed = new TelaExclusao();
    final TelaExclusao excluiCadastroFunc = new TelaExclusao();
    final TelaAlterar_HealthProfessional telaAlterarSaude = new TelaAlterar_HealthProfessional();
    final TelaPesquisa_HealthProfessionals pesquisaMedico = new TelaPesquisa_HealthProfessionals();
    //final EmployeeList employeeList = new EmployeeList();
    private ConnectionSetup connection;
    private TelaCadastro_HealthProfessionals insereProfSaude = new TelaCadastro_HealthProfessionals();
    final TelaAlterarEmployee telaAlterar = new TelaAlterarEmployee();
    final TelaCadastroEmployee telaCadastro = new TelaCadastroEmployee();
    final TelaPesquisa_Employee pesquisaFuncionario = new TelaPesquisa_Employee();
    final TelaMarcarConsulta_Employee marcarConsulta = new TelaMarcarConsulta_Employee();
    final TelaDesmarcarConsulta_Employee desmarcarConsulta = new TelaDesmarcarConsulta_Employee();
    final TelaVisualizacaoConsultas_Employee visualizarConsulta = new TelaVisualizacaoConsultas_Employee();
    private javax.swing.JLabel lblTexto;

    class ImagePanel extends JComponent {
        private Image image;
        
        public ImagePanel(Image image) {
            this.image = image;
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public TelaPrincipal_Admin() {
        try {
            this.connection = new ConnectionSetup();
            this.setResizable(false); //bloqueando o tamanho do frame
            this.setLocationRelativeTo(null); //abrindo no meio da tela
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/logo_oficial.png")).getImage());  
 
        this.setLocationRelativeTo(null);
        this.parentPanel = new JPanel();
        
        this.parentPanel.setLayout(new BorderLayout(780, 600));
        
        this.setContentPane(parentPanel);
        pack();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuMenuPrincipal = new javax.swing.JMenuBar();
        smnIncluir = new javax.swing.JMenu();
        mnuCadastrarFunc = new javax.swing.JMenuItem();
        mnuExcluirFunc = new javax.swing.JMenuItem();
        mnuPesquisarFunc = new javax.swing.JMenuItem();
        mnuAlterarFunc = new javax.swing.JMenuItem();
        mnuAdministrarMedico = new javax.swing.JMenu();
        mnuCadastrarMed = new javax.swing.JMenuItem();
        mnuPesquisarMed = new javax.swing.JMenuItem();
        mnuAlterarMed = new javax.swing.JMenuItem();
        smnConsultas = new javax.swing.JMenu();
        mnuMarcarConsulta = new javax.swing.JMenuItem();
        mnuDesmarcarConsulta = new javax.swing.JMenuItem();
        mnuVisualizarConsulta = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Administrativo do Hospital Plus");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("SAHP"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        smnIncluir.setText("Administração de Funcionários");
        smnIncluir.setToolTipText("");

        mnuCadastrarFunc.setText("Cadastrar");
        mnuCadastrarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarFuncActionPerformed(evt);
            }
        });
        smnIncluir.add(mnuCadastrarFunc);

        mnuExcluirFunc.setText("Excluir");
        mnuExcluirFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExcluirFuncActionPerformed(evt);
            }
        });
        smnIncluir.add(mnuExcluirFunc);

        mnuPesquisarFunc.setText("Pesquisar");
        mnuPesquisarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPesquisarFuncActionPerformed(evt);
            }
        });
        smnIncluir.add(mnuPesquisarFunc);

        mnuAlterarFunc.setText("Alterar");
        mnuAlterarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarFuncActionPerformed(evt);
            }
        });
        smnIncluir.add(mnuAlterarFunc);

        mnuMenuPrincipal.add(smnIncluir);

        mnuAdministrarMedico.setText("Administrar Médicos");

        mnuCadastrarMed.setText("Cadastrar");
        mnuCadastrarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarMedActionPerformed(evt);
            }
        });
        mnuAdministrarMedico.add(mnuCadastrarMed);

        mnuPesquisarMed.setText("Pesquisar");
        mnuPesquisarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPesquisarMedActionPerformed(evt);
            }
        });
        mnuAdministrarMedico.add(mnuPesquisarMed);

        mnuAlterarMed.setText("Alterar");
        mnuAlterarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarMedActionPerformed(evt);
            }
        });
        mnuAdministrarMedico.add(mnuAlterarMed);

        mnuMenuPrincipal.add(mnuAdministrarMedico);

        smnConsultas.setText("Consultas");

        mnuMarcarConsulta.setText("Agendar");
        mnuMarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcarConsultaActionPerformed(evt);
            }
        });
        smnConsultas.add(mnuMarcarConsulta);

        mnuDesmarcarConsulta.setText("Desmarcar");
        mnuDesmarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDesmarcarConsultaActionPerformed(evt);
            }
        });
        smnConsultas.add(mnuDesmarcarConsulta);

        mnuVisualizarConsulta.setText("Visualizar");
        mnuVisualizarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVisualizarConsultaActionPerformed(evt);
            }
        });
        smnConsultas.add(mnuVisualizarConsulta);

        mnuMenuPrincipal.add(smnConsultas);

        logout.setText("Logout");
        logout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(logout);

        setJMenuBar(mnuMenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void setVisibility(boolean welcome, boolean cadastraMed, boolean excluiMed, 
            boolean pesqMed, boolean altMed,
            boolean cadastraFunc, boolean excluiFunc, 
            boolean pesqFunc, boolean altFunc,
            boolean marcaConsulta, boolean desmarcaConsulta, boolean visualizaCons){
        
        
        this.welcomepanel.setVisible(welcome);
        this.insereProfSaude.setVisible(cadastraMed);
        this.excluiCadastroMed.setVisible(excluiMed);
        //this.employeeList.setVisible(shownEmployeeList);
        this.pesquisaMedico.setVisible(pesqMed);
        this.telaAlterarSaude.setVisible(altMed);
        this.telaCadastro.setVisible(cadastraFunc);
        this.excluiCadastroFunc.setVisible(excluiFunc);
        this.pesquisaFuncionario.setVisible(pesqFunc);
        this.telaAlterar.setVisible(altFunc);
        this.marcarConsulta.setVisible(marcaConsulta);
        this.desmarcarConsulta.setVisible(desmarcaConsulta);
        this.visualizarConsulta.setVisible(visualizaCons);
    }
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
        this.parentPanel.add(this.welcomepanel);
        this.welcomepanel.setVisible(true);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_formComponentShown

    /*
    ###########################################
    #       MÉTODOS DE ADM DE FUNCIONARIOS    #
    ###########################################
    */
    
    private void mnuCadastrarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarFuncActionPerformed
        setVisibility(false, false, false, false, false, 
                true, false, false, false,
                false, false, false);
        this.parentPanel.add(this.telaCadastro, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuCadastrarFuncActionPerformed

    private void mnuExcluirFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirFuncActionPerformed
        setVisibility(false, false, false, false, false, 
                false, true, false, false,
                false, false, false);
        
        this.parentPanel.add(this.excluiCadastroFunc, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuExcluirFuncActionPerformed

    private void mnuPesquisarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPesquisarFuncActionPerformed
        setVisibility(false, false, false, false, false, 
                false, false, true, false,
                false, false, false);
        this.parentPanel.add(this.pesquisaFuncionario, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuPesquisarFuncActionPerformed

    private void mnuAlterarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarFuncActionPerformed
        setVisibility(false, false, false, false, false, 
                false, false, false, true,
                false, false, false);
        this.parentPanel.add(this.telaAlterar, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuAlterarFuncActionPerformed

    private void mnuMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcarConsultaActionPerformed
       
        setVisibility(false, false, false, false, false, 
                false, false, false, false,
                true, false, false);
        this.parentPanel.add(this.marcarConsulta, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuMarcarConsultaActionPerformed

    private void mnuDesmarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDesmarcarConsultaActionPerformed
        
        setVisibility(false, false, false, false, false, 
                false, false, false, false,
                false, true, false);
        this.parentPanel.add(this.desmarcarConsulta, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuDesmarcarConsultaActionPerformed

    private void mnuVisualizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVisualizarConsultaActionPerformed
        // TODO add your handling code here:
        setVisibility(false, false, false, false, false, 
                false, false, false, false,
                false, false, true);
        this.parentPanel.add(this.visualizarConsulta, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuVisualizarConsultaActionPerformed

    private void mnuAlterarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarMedActionPerformed
        setVisibility(false, false, false, false, true,
            false, false, false, false,
            false, false, false);

        this.parentPanel.add(this.telaAlterarSaude, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuAlterarMedActionPerformed

    private void mnuPesquisarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPesquisarMedActionPerformed
        setVisibility(false, false, false, true, false,
            false, false, false, false,
            false, false, false);

        this.parentPanel.add(this.pesquisaMedico, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuPesquisarMedActionPerformed

    private void mnuCadastrarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarMedActionPerformed
        setVisibility(false, true, false, false, false,
            false, false, false, false,
            false, false, false);

        this.parentPanel.add(this.insereProfSaude, BorderLayout.CENTER);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuCadastrarMedActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu logout;
    private javax.swing.JMenu mnuAdministrarMedico;
    private javax.swing.JMenuItem mnuAlterarFunc;
    private javax.swing.JMenuItem mnuAlterarMed;
    private javax.swing.JMenuItem mnuCadastrarFunc;
    private javax.swing.JMenuItem mnuCadastrarMed;
    private javax.swing.JMenuItem mnuDesmarcarConsulta;
    private javax.swing.JMenuItem mnuExcluirFunc;
    private javax.swing.JMenuItem mnuMarcarConsulta;
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenuItem mnuPesquisarFunc;
    private javax.swing.JMenuItem mnuPesquisarMed;
    private javax.swing.JMenuItem mnuVisualizarConsulta;
    private javax.swing.JMenu smnConsultas;
    private javax.swing.JMenu smnIncluir;
    // End of variables declaration//GEN-END:variables
}
