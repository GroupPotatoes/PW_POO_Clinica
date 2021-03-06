/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Employee;

import Module.DAO.AvailabilityDAO;
import Module.DBO.ConnectionSetup;
import Module.DAO.DoctorAppointmentDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Panel com a pesquisa de consultas pelos funcionários.
 *
 * @author Maiara
 */
public class TelaVisualizacaoConsultas_Employee extends javax.swing.JPanel {

    DoctorAppointmentDAO daDAO  = new DoctorAppointmentDAO(ConnectionSetup.connection);
    AvailabilityDAO availabilityDAO = new AvailabilityDAO(ConnectionSetup.connection);

    /**
     * Creates new form Panel_VisualizacaoConsultas_Administrativo
     */
    public TelaVisualizacaoConsultas_Employee() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrLista = new javax.swing.JScrollPane();
        lstListaConsltas = new javax.swing.JList();
        lblData = new javax.swing.JLabel();
        btnIndisponibilizar = new javax.swing.JButton();
        dtCalendario = new datechooser.beans.DateChooserPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblTitulo2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrLista.setViewportView(lstListaConsltas);

        add(scrLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 353, 630, 168));

        lblData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData.setText("Selecione uma data...");
        lblData.setEnabled(false);
        add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 569, 17));

        btnIndisponibilizar.setText("Indisponibilizar Horário");
        btnIndisponibilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndisponibilizarActionPerformed(evt);
            }
        });
        add(btnIndisponibilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 420, -1));

        dtCalendario.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dtCalendarioOnSelectionChange(evt);
            }
        });
        add(dtCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 520, 219));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 420, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 10, 219));

        lblTitulo2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Clique em uma data para mais detalhes");
        add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 46, 758, 17));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 14, 219));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(":: Visualização de Consultas - Administrativo ::");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 23, 758, 17));

        lblTitulo1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo1.setText("DETALHES DE CADA DATA  -");
        add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 179, 17));
    }// </editor-fold>//GEN-END:initComponents

    private void btnIndisponibilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndisponibilizarActionPerformed
        new TelaIndisponibilizacao().setVisible(true);
    }//GEN-LAST:event_btnIndisponibilizarActionPerformed

    private void dtCalendarioOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dtCalendarioOnSelectionChange
        try {
            this.carregarDisponibilidades();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_dtCalendarioOnSelectionChange

    /**
     * Carrega as diponibilidades para a lista de disponibilidades.
     *
     * @throws Exception
     */
    private void carregarDisponibilidades() throws Exception {
        List<String> disponibilidades = new ArrayList<String>(); //array com as disponibilidades
        List<String> consultas = new ArrayList<String>();   //array com as consultas        
        Date dt = this.dtCalendario.getCurrent().getTime();        //criando a data para mandar para os métodos            
        disponibilidades = this.daDAO.selectFreeHours(dt); //pegando as datas válidas
        consultas = this.daDAO.searchDoctorAppointmentsComplete(dt);   //procurando as consultas
        List<String> exibicao = new ArrayList<String>();
        exibicao.add("CONSULTAS:\n");
        if (!consultas.isEmpty()) {
            exibicao.addAll(consultas);
        } else {
            exibicao.add("\tNenhuma consulta nesta data.");
        }
        exibicao.add("HORÁRIOS DISPONÍVEIS:\n");
        if (!disponibilidades.isEmpty()) {
            exibicao.addAll(disponibilidades);
        } else {
            exibicao.add("\tNenhum horário disponível.");
        }
        this.lstListaConsltas.setListData(exibicao.toArray());
        DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatadorData.format(dt);
        this.lblData.setText(data);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIndisponibilizar;
    private datechooser.beans.DateChooserPanel dtCalendario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JList lstListaConsltas;
    private javax.swing.JScrollPane scrLista;
    // End of variables declaration//GEN-END:variables
}
//TODO: remover essa instanciação do Connection [virá por parâmetro]
