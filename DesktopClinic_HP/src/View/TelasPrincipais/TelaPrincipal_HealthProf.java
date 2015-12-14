package View.TelasPrincipais;

import Module.DBO.ConnectionSetup;
import View.Common.TelaExclusao;
import View.HealthProfessionals.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class TelaPrincipal_HealthProf extends javax.swing.JFrame {

    private final JPanel parentPanel;
    final Welcome welcomepanel = new Welcome();
    final TelaExclusao excluiCadastro = new TelaExclusao();
    private ConnectionSetup connection;
    final TelaMarcarConsulta_HealthProfessionals marcarConsulta = new TelaMarcarConsulta_HealthProfessionals();
    final TelaRemoverAlterarConsulta_HealthProfessionals removerAlterarConsulta = new TelaRemoverAlterarConsulta_HealthProfessionals();
    final TelaAlterarConsultaRealizada_HealthProfessionals consultaAnterior = new TelaAlterarConsultaRealizada_HealthProfessionals();
    final TelaVisualizacaoConsultas_HealthProfessionals visualizarConsulta = new TelaVisualizacaoConsultas_HealthProfessionals(ConnectionSetup.id);
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

    public TelaPrincipal_HealthProf() {
        try {
            this.connection = new ConnectionSetup();
            this.setResizable(false); //bloqueando o tamanho do frame
            this.setLocationRelativeTo(null); //abrindo no meio da tela
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal_HealthProf.class.getName()).log(Level.SEVERE, null, ex);
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
        agendarConsulta = new javax.swing.JMenu();
        visualizarConsultas = new javax.swing.JMenu();
        altConsultas = new javax.swing.JMenu();
        consAnteriores = new javax.swing.JMenu();
        proxConsultas = new javax.swing.JMenu();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Administrativo do Hospital Plus");
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(780, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        agendarConsulta.setText("Agendar consulta");
        agendarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agendarConsultaMouseClicked(evt);
            }
        });
        agendarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarConsultaActionPerformed(evt);
            }
        });
        mnuMenuPrincipal.add(agendarConsulta);

        visualizarConsultas.setText("Visualizar consultas");
        visualizarConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visualizarConsultasMouseClicked(evt);
            }
        });
        visualizarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarConsultasActionPerformed(evt);
            }
        });
        mnuMenuPrincipal.add(visualizarConsultas);

        altConsultas.setText("Alterar consultas");

        consAnteriores.setText("Consultas anteriores");
        consAnteriores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consAnterioresMouseClicked(evt);
            }
        });
        consAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consAnterioresActionPerformed(evt);
            }
        });
        altConsultas.add(consAnteriores);

        proxConsultas.setText("Próximas consultas");
        proxConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proxConsultasMouseClicked(evt);
            }
        });
        proxConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxConsultasActionPerformed(evt);
            }
        });
        altConsultas.add(proxConsultas);

        mnuMenuPrincipal.add(altConsultas);

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
            boolean marcaConsulta, 
            boolean visualizaConsulta,
            boolean altConsultaRealizada,
            boolean removerAlterarConsulta) {

        this.welcomepanel.setVisible(welcome);
        this.consultaAnterior.setVisible(altConsultaRealizada);
        this.marcarConsulta.setVisible(marcaConsulta);
        this.removerAlterarConsulta.setVisible(removerAlterarConsulta);
        this.visualizarConsulta.setVisible(visualizaConsulta);
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

        this.parentPanel.add(this.welcomepanel);
        this.welcomepanel.setVisible(true);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_formComponentShown

    private void agendarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarConsultaActionPerformed
        setVisibility(false, true, false, false, false);

        this.parentPanel.add(this.marcarConsulta, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_agendarConsultaActionPerformed

    private void visualizarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarConsultasActionPerformed
        setVisibility(false, false, true, false, false);

        this.parentPanel.add(this.visualizarConsulta, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_visualizarConsultasActionPerformed

    private void consAnterioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consAnterioresActionPerformed
        setVisibility(false, false, false, true, false);

        this.parentPanel.add(this.consultaAnterior, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_consAnterioresActionPerformed

    private void proxConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxConsultasActionPerformed
        setVisibility(false, false, false, false, true);

        this.parentPanel.add(this.removerAlterarConsulta, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_proxConsultasActionPerformed

    private void agendarConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agendarConsultaMouseClicked
        // TODO add your handling code here:
        setVisibility(false, true, false, false, false);

        this.parentPanel.add(this.marcarConsulta, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_agendarConsultaMouseClicked

    private void visualizarConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarConsultasMouseClicked
        // TODO add your handling code here:
        setVisibility(false, false, true, false, false);

        this.parentPanel.add(this.visualizarConsulta, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_visualizarConsultasMouseClicked

    private void consAnterioresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consAnterioresMouseClicked
        // TODO add your handling code here:
        setVisibility(false, false, false, true, false);

        this.parentPanel.add(this.consultaAnterior, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_consAnterioresMouseClicked

    private void proxConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proxConsultasMouseClicked
        // TODO add your handling code here:
        setVisibility(false, false, false, false, true);

        this.parentPanel.add(this.removerAlterarConsulta, BorderLayout.CENTER);
        //this.pesquisaMedico.setPreferredSize(new Dimension(400, 300));
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.pack();
    }//GEN-LAST:event_proxConsultasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu agendarConsulta;
    private javax.swing.JMenu altConsultas;
    private javax.swing.JMenu consAnteriores;
    private javax.swing.JMenu logout;
    private javax.swing.JMenuBar mnuMenuPrincipal;
    private javax.swing.JMenu proxConsultas;
    private javax.swing.JMenu visualizarConsultas;
    // End of variables declaration//GEN-END:variables
}
