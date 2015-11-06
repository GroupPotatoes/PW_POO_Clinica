package View;

import Module.DAO.ConnectionSetup;
import Module.DAO.RegisteredEmployee;
import Module.DAO.RegisteredEmployeeDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class AdministracaoMedicos extends javax.swing.JFrame {
    
    final JPanel parentPanel;
    final TelaExclusao excluiCadastro = new TelaExclusao();
    final TelaAlterarProfSaude telaAlterarSaude = new TelaAlterarProfSaude();
    final TelaPesquisa_Medico pesquisaMedico = new TelaPesquisa_Medico();
    final EmployeeList employeeList = new EmployeeList();
    private ConnectionSetup connection;
    private InserirProfissionalSaude insereProfSaude = new InserirProfissionalSaude();

    public AdministracaoMedicos() {
        
        try {
            this.connection = new ConnectionSetup();
        } catch (SQLException ex) {
            Logger.getLogger(AdministracaoMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.parentPanel = new JPanel();
        this.parentPanel.setLayout(new BorderLayout(300, 300));
        
        initComponents();
         
        this.parentPanel.add(this.employeeList, BorderLayout.CENTER);
        this.employeeList.setPreferredSize(new Dimension(300, 300));
        this.employeeList.setVisible(true);
        
        this.setLocationRelativeTo(null);
        
        add(this.parentPanel);
        pack();
        setVisible(true);
              
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        mnuMenuPrincipal = new javax.swing.JMenuBar();
        smnExcluir = new javax.swing.JMenu();
        smnPesquisar = new javax.swing.JMenu();
        mnuPesquisaMedico = new javax.swing.JMenuItem();
        smnAlterar = new javax.swing.JMenu();
        smnInserir = new javax.swing.JMenu();
        smnSair = new javax.swing.JMenu();

        jInternalFrame1.setVisible(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setSize(new java.awt.Dimension(300, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        smnExcluir.setText("Excluir");
        smnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnExcluirMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnExcluir);

        smnPesquisar.setText("Pesquisar");

        mnuPesquisaMedico.setText("Médicos");
        mnuPesquisaMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPesquisaMedicoActionPerformed(evt);
            }
        });
        smnPesquisar.add(mnuPesquisaMedico);

        mnuMenuPrincipal.add(smnPesquisar);

        smnAlterar.setText("Alterar");
        smnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnAlterarMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnAlterar);

        smnInserir.setText("Inserir");
        smnInserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnInserirMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnInserir);

        smnSair.setText("Voltar");
        smnSair.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        smnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnSairMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnSair);

        setJMenuBar(mnuMenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnSairMouseClicked
       //this.connection.FecharConexao();
        this.setVisible(false);
    }//GEN-LAST:event_smnSairMouseClicked

    private void smnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnExcluirMouseClicked

        ConnectionSetup.currentEmployeeSelect = this.employeeList.getRegisteredEmployeeSelected();
        
        setVisibility(true, false, false, false, false);
        
        this.parentPanel.add(this.excluiCadastro, BorderLayout.CENTER);
        this.excluiCadastro.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
        

    }//GEN-LAST:event_smnExcluirMouseClicked

    private void smnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnAlterarMouseClicked
       
       ConnectionSetup.currentEmployeeSelect = this.employeeList.getRegisteredEmployeeSelected();
         
        setVisibility(false, false, true, false, false);
        
        this.parentPanel.add(this.telaAlterarSaude, BorderLayout.CENTER);
        
        this.telaAlterarSaude.setPreferredSize(new Dimension(445, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
        
        
    }//GEN-LAST:event_smnAlterarMouseClicked

    private void smnInserirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnInserirMouseClicked
       
        setVisibility(false, false, false, true, false);
        
        this.parentPanel.add(this.insereProfSaude, BorderLayout.CENTER);
        this.insereProfSaude.setPreferredSize(new Dimension(480, 390));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
       
        
    }//GEN-LAST:event_smnInserirMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        setVisibility(false, false, false, false, true);
        
        this.parentPanel.add(this.employeeList, BorderLayout.CENTER);
        this.employeeList.setPreferredSize(new Dimension(480, 400));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
        
        loadRegisteredEmployeeList();
        

    }//GEN-LAST:event_formWindowActivated

    private void mnuPesquisaMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPesquisaMedicoActionPerformed
        
        setVisibility(false, true, false, false, false);
        
        this.parentPanel.add(this.pesquisaMedico, BorderLayout.CENTER);
        this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
        
    }//GEN-LAST:event_mnuPesquisaMedicoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       loadRegisteredEmployeeList();
    }//GEN-LAST:event_formWindowOpened

    private void loadRegisteredEmployeeList() {
          try 
        {
            RegisteredEmployeeDAO registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
            List<RegisteredEmployee> employees = registeredEmployeeDAO.SelectAllHealthProfessionals();
            this.employeeList.setEmployeeList(employees.toArray());
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void setVisibility(boolean shownExcluir, boolean shownPesquisarMedico, boolean shownAlterar, boolean shownInserir, boolean shownEmployeeList){
        
        this.employeeList.setVisible(shownEmployeeList);
        this.pesquisaMedico.setVisible(shownPesquisarMedico);
        this.telaAlterarSaude.setVisible(shownAlterar);
        this.excluiCadastro.setVisible(shownExcluir);
        this.insereProfSaude.setVisible(shownInserir);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private java.awt.List list1;
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenuItem mnuPesquisaMedico;
    private javax.swing.JMenu smnAlterar;
    private javax.swing.JMenu smnExcluir;
    private javax.swing.JMenu smnInserir;
    private javax.swing.JMenu smnPesquisar;
    private javax.swing.JMenu smnSair;
    // End of variables declaration//GEN-END:variables
}
