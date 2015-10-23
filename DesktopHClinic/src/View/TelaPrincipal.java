package View;

import Module.DAO.RegisteredEmployeeDAO;

/**
 * Classe que contém todas as funcionalidades da Tela Principal.
 * @author Maiara Rodrigues
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    /**
     * Construtor da classe.
     */
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null); 
        
    }

    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTexto = new javax.swing.JLabel();
        mnuMenuPrincipal = new javax.swing.JMenuBar();
        smnIncluir = new javax.swing.JMenu();
        smnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTexto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTexto.setText(":: Sistema da Clínica Médica ::");
        lblTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        smnIncluir.setText("Administração de Funcionários");
        smnIncluir.setToolTipText("");
        smnIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnIncluirMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnIncluir);

        smnSair.setText("Sair");
        smnSair.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        smnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnSairMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnSair);

        setJMenuBar(mnuMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnSairMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_smnSairMouseClicked

    private void smnIncluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnIncluirMouseClicked
        AdministracaoFuncionarios administracaoFuncionarios = new AdministracaoFuncionarios();
        administracaoFuncionarios.setVisible(true);
    }//GEN-LAST:event_smnIncluirMouseClicked
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTexto;
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenu smnIncluir;
    private javax.swing.JMenu smnSair;
    // End of variables declaration//GEN-END:variables
}
