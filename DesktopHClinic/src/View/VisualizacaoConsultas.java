package View;

import Module.DAO.ConnectionSetup;
import Module.DAO.DoctorAppointmentDAO;
import datechooser.model.DateChoose;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Maiara
 */
public class VisualizacaoConsultas extends javax.swing.JFrame {

    private ConnectionSetup conexao ;    
    
    public VisualizacaoConsultas() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);  
        this.conexao  = new ConnectionSetup();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblData1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        dtCalendario = new datechooser.beans.DateChooserPanel();
        lblData = new javax.swing.JLabel();
        scrLista = new javax.swing.JScrollPane();
        lstListaConsltas = new javax.swing.JList();

        lblData1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblData1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData1.setText("Selecione uma data...");
        lblData1.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(":: Visualização de Consultas ::");

        lblTitulo1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo1.setText("DETALHES -");

        lblTitulo2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo2.setText("Clique em uma data para mais detalhes");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
    dtCalendario.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.LOWERED,
        (java.awt.Color)null,
        (java.awt.Color)null));
dtCalendario.setNavigateFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
dtCalendario.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
dtCalendario.setShowOneMonth(true);
dtCalendario.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
    public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
        dtCalendarioOnSelectionChange(evt);
    }
    });

    lblData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    lblData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblData.setText("Selecione uma data...");
    lblData.setEnabled(false);

    scrLista.setViewportView(lstListaConsltas);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(dtCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrLista, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(60, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(37, 37, 37)
            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jSeparator1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addComponent(dtCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrLista, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(45, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtCalendarioOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dtCalendarioOnSelectionChange
        Calendar calendario = this.dtCalendario.getCurrent();
        //criando o formatador para dia, mês e ano
        DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        //atribuindo a String
        String data = formatadorData.format(calendario.getTime());
        //atribuindo ao formatador dia da semana
        formatadorData = new SimpleDateFormat("EEEE");        
        data+=(" - "+formatadorData.format(new java.util.Date()));
	this.lblData.setText(data);
        
        //conetando no BD
        try {            
            DoctorAppointmentDAO daDAO = new DoctorAppointmentDAO(conexao.connection);
            List<String> resultados = daDAO.searchDoctorAppointments(this.dtCalendario.getCurrent().getTime());
            if(resultados.size() > 0){
                this.lstListaConsltas.setListData(resultados.toArray());
             }
            else 
            {
                //TODO: o form fecha depois que exibe o erro
                this.lstListaConsltas.setListData(new Object[0]);
            }            
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPesquisa_Medico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisa_Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dtCalendarioOnSelectionChange

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{
            DoctorAppointmentDAO daDAO = new DoctorAppointmentDAO(conexao.connection);
            List<String> resultados = daDAO.searchDoctorAppointments();
            for(int i=0;i<31;i++){
//                if(dtCalendario.getCurrent().getTime().getDate())
            }
        }catch(SQLException sqlErr){
            System.err.println("Erro ao acessar o banco. "+sqlErr.getMessage());  
        }catch(Exception e){
            System.err.println("Erro desconhecido: "+e.getMessage());
        }
        /*
         *  super.actionPerformed(e);
                //pega o dia que foi setado previamente.
        int dia = super.getCalendar().get(Calendar.DAY_OF_MONTH);
                //pega o component os botões dos dias começam a partir da posição 12.
        JButton button  = (JButton)super.jcalendar.getDayChooser().
                                           getDayPanel().getComponent(11 + dia);

         button.setForeground(Color.red);
         */
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisualizacaoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizacaoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizacaoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizacaoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VisualizacaoConsultas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VisualizacaoConsultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserPanel dtCalendario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JList lstListaConsltas;
    private javax.swing.JScrollPane scrLista;
    // End of variables declaration//GEN-END:variables
}

//TODO:
//Achar uma forma de setar a cor das datas quando possuem consulta