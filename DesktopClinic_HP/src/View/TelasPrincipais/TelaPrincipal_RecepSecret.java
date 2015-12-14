package View.TelasPrincipais;

import Module.DBO.ConnectionSetup;
import View.Common.TelaExclusao;
import View.Employee.TelaAlterarEmployee;
import View.Employee.TelaAlterar_HealthProfessional;
import View.Employee.TelaCadastroEmployee;
import View.Employee.TelaCadastro_HealthProfessionals;
import View.Employee.TelaDesmarcarConsulta_Employee;
import View.Employee.TelaMarcarConsulta_Employee;
import View.Employee.TelaPesquisa_Employee;
import View.Employee.TelaPesquisa_HealthProfessionals;
import View.Employee.TelaVisualizacaoConsultas_Employee;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class TelaPrincipal_RecepSecret extends javax.swing.JFrame {

    private final JPanel parentPanel;
    final Welcome welcomepanel = new Welcome();
    final TelaAlterar_HealthProfessional telaAlterarSaude = new TelaAlterar_HealthProfessional();
    final TelaPesquisa_HealthProfessionals pesquisaMedico = new TelaPesquisa_HealthProfessionals();
    //final EmployeeList employeeList = new EmployeeList();
    private ConnectionSetup connection;
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
    
    public TelaPrincipal_RecepSecret() {
        try {
            this.connection = new ConnectionSetup();
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal_RecepSecret.class.getName()).log(Level.SEVERE, null, ex);
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
        mnuPesquisarFunc = new javax.swing.JMenuItem();
        mnuAdministrarMedico = new javax.swing.JMenu();
        mnuPesquisarMed = new javax.swing.JMenuItem();
        smnConsultas = new javax.swing.JMenu();
        mnuMarcarConsulta = new javax.swing.JMenuItem();
        mnuDesmarcarConsulta = new javax.swing.JMenuItem();
        mnuVisualizarConsulta = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Administrativo do Hospital Plus");
        setSize(new java.awt.Dimension(780, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        smnIncluir.setText("Administração de Funcionários");
        smnIncluir.setToolTipText("");

        mnuPesquisarFunc.setText("Pesquisar");
        mnuPesquisarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPesquisarFuncActionPerformed(evt);
            }
        });
        smnIncluir.add(mnuPesquisarFunc);

        mnuMenuPrincipal.add(smnIncluir);

        mnuAdministrarMedico.setText("Administrar Médicos");

        mnuPesquisarMed.setText("Pesquisar");
        mnuPesquisarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPesquisarMedActionPerformed(evt);
            }
        });
        mnuAdministrarMedico.add(mnuPesquisarMed);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void setVisibility(boolean welcome,
            boolean pesqMed, 
            boolean pesqFunc, 
            boolean marcaConsulta, 
            boolean desmarcaConsulta, 
            boolean visualizaCons) {

        this.welcomepanel.setVisible(welcome);
        this.pesquisaMedico.setVisible(pesqMed);
        this.pesquisaFuncionario.setVisible(pesqFunc);
        this.marcarConsulta.setVisible(marcaConsulta);
        this.desmarcarConsulta.setVisible(desmarcaConsulta);
        this.visualizarConsulta.setVisible(visualizaCons);
    }

    private void mnuPesquisarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPesquisarMedActionPerformed
        setVisibility(false, true, false, false, false, false);

        this.parentPanel.add(this.pesquisaMedico, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuPesquisarMedActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        this.parentPanel.add(this.welcomepanel);
        this.welcomepanel.setVisible(true);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_formComponentShown

    private void mnuMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcarConsultaActionPerformed
        setVisibility(false, false, false, true, false, false);
        this.parentPanel.add(this.marcarConsulta, BorderLayout.CENTER);
        //this.telaAlterar.setPreferredSize(new Dimension(300, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuMarcarConsultaActionPerformed

    private void mnuDesmarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDesmarcarConsultaActionPerformed

        setVisibility(false, false, false, false, true, false);
        this.parentPanel.add(this.desmarcarConsulta, BorderLayout.CENTER);
        // this.telaAlterar.setPreferredSize(new Dimension(300, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuDesmarcarConsultaActionPerformed

    private void mnuVisualizarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVisualizarConsultaActionPerformed
        // TODO add your handling code here:
        setVisibility(false, false, false, false, false, true);
        this.parentPanel.add(this.visualizarConsulta, BorderLayout.CENTER);
        //this.telaAlterar.setPreferredSize(new Dimension(300, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuVisualizarConsultaActionPerformed

    private void mnuPesquisarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPesquisarFuncActionPerformed
        setVisibility(false, false, true, false, false, false);
        this.parentPanel.add(this.pesquisaFuncionario, BorderLayout.CENTER);
        //this.pesquisaFuncionario.setPreferredSize(new Dimension(300, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_mnuPesquisarFuncActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu logout;
    private javax.swing.JMenu mnuAdministrarMedico;
    private javax.swing.JMenuItem mnuDesmarcarConsulta;
    private javax.swing.JMenuItem mnuMarcarConsulta;
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenuItem mnuPesquisarFunc;
    private javax.swing.JMenuItem mnuPesquisarMed;
    private javax.swing.JMenuItem mnuVisualizarConsulta;
    private javax.swing.JMenu smnConsultas;
    private javax.swing.JMenu smnIncluir;
    // End of variables declaration//GEN-END:variables
}
