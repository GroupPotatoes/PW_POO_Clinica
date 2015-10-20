package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Classe que possui as opções de administração de funcionários.
 * @author maiara
 */
public class AdministracaoFuncionarios extends javax.swing.JFrame {
    final JPanel parentPanel;
    final JPanel inicio;
    final TelaExclusao excluiCadastro;
    final TelaPesquisa pesquisa;
    
    /**
     * Construtor da Classe.
     */
    public AdministracaoFuncionarios() {
        this.parentPanel = new JPanel();
        this.inicio = new JPanel();
        this.excluiCadastro = new TelaExclusao();
        this.pesquisa = new TelaPesquisa();
        this.parentPanel.setLayout(new BorderLayout(380, 200));
        initComponents();
        
        this.parentPanel.add(this.inicio, BorderLayout.CENTER);
        this.inicio.setPreferredSize(new Dimension(380, 200));
        this.inicio.setVisible(true);
        this.setLocationRelativeTo(null);
        add(this.parentPanel);
        pack();
        setVisible(true);
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
        setAutoRequestFocus(false);
        setSize(new java.awt.Dimension(380, 200));
        getContentPane().setLayout(new java.awt.CardLayout());

        smnIncluir.setText("Incluir");
        mnuMenuPrincipal.add(smnIncluir);

        smnAlterar.setText("Alterar");
        smnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnAlterarMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnAlterar);

        smnExcluir.setText("Excluir");
        smnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnExcluirMouseClicked(evt);
            }
        });
        mnuMenuPrincipal.add(smnExcluir);

        smnPesquisar.setText("Pesquisar");
        smnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smnPesquisarMouseClicked(evt);
            }
        });
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnSairMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_smnSairMouseClicked

    private void smnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnExcluirMouseClicked
        // Abre tela de exclusao que faz o cadastro ficar inativo
        this.inicio.setVisible(false);
        this.pesquisa.setVisible(false);
        this.parentPanel.add(this.excluiCadastro, BorderLayout.CENTER);
        this.excluiCadastro.setPreferredSize(new Dimension(380, 200));
        this.excluiCadastro.setVisible(true);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        pack();
    }//GEN-LAST:event_smnExcluirMouseClicked

    private void smnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnPesquisarMouseClicked
        //Opens employee search screen
        this.inicio.setVisible(false);
        this.excluiCadastro.setVisible(false);
        this.parentPanel.add(this.pesquisa, BorderLayout.CENTER);
        this.pesquisa.setPreferredSize(new Dimension(380, 200));
        this.pesquisa.setVisible(true);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        pack();
    }//GEN-LAST:event_smnPesquisarMouseClicked

    private void smnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smnAlterarMouseClicked
        // TODO add your handling code here:
        TelaAlterar telaAlterar = new TelaAlterar();
        telaAlterar.setVisible(true);
    }//GEN-LAST:event_smnAlterarMouseClicked

    public void resultadoPesquisa() {
        this.inicio.setVisible(false);
        this.excluiCadastro.setVisible(false);
        this.pesquisa.setVisible(false);
        this.parentPanel.add(this.pesquisaRes, BorderLayout.CENTER);
        this.pesquisaRes.setPreferredSize(new Dimension(380, 200));
        this.pesquisaRes.setVisible(true);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenu smnAlterar;
    private javax.swing.JMenu smnExcluir;
    private javax.swing.JMenu smnIncluir;
    private javax.swing.JMenu smnPesquisar;
    private javax.swing.JMenu smnSair;
    // End of variables declaration//GEN-END:variables
}
