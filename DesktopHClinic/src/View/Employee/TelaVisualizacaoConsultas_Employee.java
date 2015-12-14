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

    private ConnectionSetup conexao;
    DoctorAppointmentDAO daDAO;
    AvailabilityDAO availabilityDAO;

    /**
     * Creates new form Panel_VisualizacaoConsultas_Administrativo
     */
    public TelaVisualizacaoConsultas_Employee() {
        try {
            initComponents();
            this.conexao = new ConnectionSetup();
            this.daDAO = new DoctorAppointmentDAO(conexao.connection);
            this.availabilityDAO = new AvailabilityDAO(conexao.connection);
        } catch (SQLException ex) {
            Logger.getLogger(TelaVisualizacaoConsultas_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        scrLista.setViewportView(lstListaConsltas);

        lblData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData.setText("Selecione uma data...");
        lblData.setEnabled(false);

        btnIndisponibilizar.setText("Indisponibilizar Horário");
        btnIndisponibilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndisponibilizarActionPerformed(evt);
            }
        });

        dtCalendario.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dtCalendario.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dtCalendarioOnSelectionChange(evt);
        }
    });

    jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

    lblTitulo2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
    lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblTitulo2.setText("Clique em uma data para mais detalhes");

    jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

    lblTitulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblTitulo.setText(":: Visualização de Consultas - Administrativo ::");

    lblTitulo1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblTitulo1.setText("DETALHES DE CADA DATA  -");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jSeparator3)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dtCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(scrLista, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(btnIndisponibilizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
            .addGap(23, 23, 23))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addComponent(dtCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addComponent(scrLista, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnIndisponibilizar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
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