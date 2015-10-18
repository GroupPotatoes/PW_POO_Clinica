package View;

/**
 * Classe que possui as opções de administração de funcionários.
 * @author maiara
 */
public class AdministracaoFuncionarios extends javax.swing.JFrame {

    /**
     * Construtor da Classe.
     */
    public AdministracaoFuncionarios() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuMenuPrincipal = new javax.swing.JMenuBar();
        smnIncluir = new javax.swing.JMenu();
        smnAlterar = new javax.swing.JMenu();
        smnExcluir = new javax.swing.JMenu();
        smnPesquisar = new javax.swing.JMenu();
        smnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        smnIncluir.setText("Incluir");
        mnuMenuPrincipal.add(smnIncluir);

        smnAlterar.setText("Alterar");
        mnuMenuPrincipal.add(smnAlterar);

        smnExcluir.setText("Excluir");
        smnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnExcluirMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnExcluir);

        smnPesquisar.setText("Pesquisar");
        mnuMenuPrincipal.add(smnPesquisar);

        smnSair.setText("Voltar");
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnSairMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_smnSairMouseClicked

    private void smnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnExcluirMouseClicked
        // Abre tela de exclusao que faz o cadastro ficar inativo
        TelaExclui excluiCadastro = new TelaExclui();
        excluiCadastro.setVisible(true);
    }//GEN-LAST:event_smnExcluirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenu smnAlterar;
    private javax.swing.JMenu smnExcluir;
    private javax.swing.JMenu smnIncluir;
    private javax.swing.JMenu smnPesquisar;
    private javax.swing.JMenu smnSair;
    // End of variables declaration//GEN-END:variables
}
