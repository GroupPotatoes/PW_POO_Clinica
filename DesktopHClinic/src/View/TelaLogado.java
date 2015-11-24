package View;

import Module.DAO.ConnectionSetup;
import Module.DAO.RegisteredEmployee;
import Module.DAO.RegisteredEmployeeDAO;
import Module.DAO.HealthProfessionalsDAO;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe com a tela inicial.
 * @author Maiara Rodrigues
 */
public class TelaLogado extends javax.swing.JFrame {

    protected Color corBotao;
    private ConnectionSetup connection;
    //controla valores do BD
    final EmployeeList employeeListHealthProfessional = new EmployeeList(),
                       employeeListAdministrative = new EmployeeList();
    
    //TELAS
    final TelaExclusao telaExcluiCadastro = new TelaExclusao();  
    final TelaAlterarProfSaude telaMedicoAlterarProfSaude = new TelaAlterarProfSaude();
    final TelaPesquisa_Medico telaMedicoPesquisa = new TelaPesquisa_Medico();    
    final InserirProfissionalSaude telaMedicoInsereProfSaude = new InserirProfissionalSaude();
    //telas de funcionário [administrativo]
    final TelaAlterar telaAdministrativoAlterar = new TelaAlterar();        //É frame
    final TelaCadastro telaAdministrativoCadastro = new TelaCadastro();     //É frame
    final TelaPesquisa_Funcionario administrativoPesquisa = new TelaPesquisa_Funcionario(); 
    
    
    /**
     * Construtor da TelaLogado.
     */
    public TelaLogado() throws SQLException {
        initComponents();
        //deixando ele com um tamanho fixo
        this.setResizable(false);
        //setando pro centro da tela
        this.setLocationRelativeTo(null);
        //configurando o connection
         try {
            this.connection = new ConnectionSetup();
        } catch (SQLException ex) {
            Logger.getLogger(AdministracaoFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenuLateral = new javax.swing.JPanel();
        lblAdministrar = new javax.swing.JLabel();
        lblFuncionarios = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFCadastrar = new javax.swing.JLabel();
        lblFAlterar = new javax.swing.JLabel();
        lblFPesquisar = new javax.swing.JLabel();
        lblMedicos = new javax.swing.JLabel();
        lblMCadastrar = new javax.swing.JLabel();
        lblMAlterar = new javax.swing.JLabel();
        lblMPesquisar = new javax.swing.JLabel();
        lblConsultar = new javax.swing.JLabel();
        lblAgendar = new javax.swing.JLabel();
        lblVisualizar = new javax.swing.JLabel();
        lblSair = new javax.swing.JLabel();
        lblExcluir = new javax.swing.JLabel();
        lblGeral = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlConteudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(225, 246, 225));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlMenuLateral.setBackground(new java.awt.Color(254, 254, 254));

        lblAdministrar.setBackground(new java.awt.Color(214, 247, 216));
        lblAdministrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdministrar.setText("Administrar");
        lblAdministrar.setOpaque(true);
        lblAdministrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdministrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAdministrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAdministrar1MouseEntered(evt);
            }
        });

        lblFuncionarios.setText("♦ Funcionários");

        lblFCadastrar.setText("• Cadastrar");
        lblFCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFCadastrarMouseClicked(evt);
            }
        });

        lblFAlterar.setText("• Alterar");
        lblFAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFAlterarMouseClicked(evt);
            }
        });

        lblFPesquisar.setText("• Pesquisar");
        lblFPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFPesquisarMouseClicked(evt);
            }
        });

        lblMedicos.setText("♦ Médicos");

        lblMCadastrar.setText("• Cadastrar");
        lblMCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMCadastrarMouseClicked(evt);
            }
        });

        lblMAlterar.setText("• Alterar");
        lblMAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMAlterarMouseClicked(evt);
            }
        });

        lblMPesquisar.setText("• Pesquisar");
        lblMPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMPesquisarMouseClicked(evt);
            }
        });

        lblConsultar.setBackground(new java.awt.Color(214, 247, 216));
        lblConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConsultar.setText("Consultas");
        lblConsultar.setOpaque(true);
        lblConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConsultarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConsultarMouseExited(evt);
            }
        });

        lblAgendar.setText("♦ Agendar");

        lblVisualizar.setText("♦ Visualizar");

        lblSair.setBackground(new java.awt.Color(215, 233, 217));
        lblSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSair.setText("    Sair (Arlindo)");
        lblSair.setOpaque(true);
        lblSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSairMouseClicked(evt);
            }
        });

        lblExcluir.setText("• Exclusão");
        lblExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExcluirMouseClicked(evt);
            }
        });

        lblGeral.setText("♦ Geral");

        javax.swing.GroupLayout pnlMenuLateralLayout = new javax.swing.GroupLayout(pnlMenuLateral);
        pnlMenuLateral.setLayout(pnlMenuLateralLayout);
        pnlMenuLateralLayout.setHorizontalGroup(
            pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAdministrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                        .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                                .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblFAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblFPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblFCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                                            .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblMedicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblMPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblMAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblMCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGap(34, 34, 34))
                                        .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                                            .addComponent(lblGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(136, 136, 136))
                                        .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(lblExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(38, 38, 38)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVisualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAgendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlMenuLateralLayout.setVerticalGroup(
            pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                .addComponent(lblAdministrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel2))
                    .addGroup(pnlMenuLateralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFuncionarios)
                        .addGap(6, 6, 6)
                        .addComponent(lblFCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(lblMedicos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGeral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExcluir)))
                .addGap(29, 29, 29)
                .addComponent(lblConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAgendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(lblSair, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(42, 130, 72));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(":: Sistema da Clínica X ::");
        lblTitulo.setOpaque(true);

        jSeparator1.setForeground(new java.awt.Color(125, 136, 122));
        jSeparator1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSeparator1KeyReleased(evt);
            }
        });

        pnlConteudo.setBackground(new java.awt.Color(227, 227, 227));
        pnlConteudo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 0)));
        pnlConteudo.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(pnlConteudo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlMenuLateral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /*
    ###########################################
    #   MÉTODOS PARA ESTILIZAÇÃO DOS "BOTÕES" #
    ###########################################
    */
    
    /**
     * Método do botão sair.
     * @param evt evento 
     */
    private void lblSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseClicked
        this.corBotao=new Color(152,184,154);
        this.lblSair.setBackground(corBotao);
        this.setVisible(false);
        System.exit(1);
    }//GEN-LAST:event_lblSairMouseClicked

    /**
     * Método para quando se passa o mouse em cima do botão Consultar.
     * @param evt evento 
     */
    private void lblConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultarMouseEntered
        this.corBotao = new Color(184,245,188);
        this.lblConsultar.setBackground(corBotao);
    }//GEN-LAST:event_lblConsultarMouseEntered

    /**
     * Método para quando se tira o mouse de cima do botão Consultar.
     * @param evt evento 
     */
    private void lblConsultarMouseExited(java.awt.event.MouseEvent evt) {                                         
        this.corBotao = new Color(214,247,216);
        this.lblConsultar.setBackground(corBotao);
    }                                         
	
    /**
     * Método para quando se clica no botão Consultar.
     * @param evt evento 
     */
    private void lblConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultarMouseClicked
        this.corBotao=new Color(152,184,154);
        this.lblConsultar.setBackground(corBotao);
    }//GEN-LAST:event_lblConsultarMouseClicked
	
    /**
     * Método para quando se passa o mouse em cima do botão Administrar.
     * @param evt evento 
     */
    private void lblAdministrar1MouseEntered(java.awt.event.MouseEvent evt) {                                             
        this.corBotao = new Color(184,245,188);
        this.lblAdministrar.setBackground(corBotao);
    }                                             
	
    /**
     * Método para quando se tira o mouse de cima do botão Administrar.
     * @param evt evento 
     */
    private void lblAdministrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdministrarMouseExited
        this.corBotao=new Color(214,247,216);
        this.lblAdministrar.setBackground(corBotao);
    }//GEN-LAST:event_lblAdministrarMouseExited
   
    /**
     * Método para quando se clica no botão Administrar.
     * @param evt evento 
     */
    private void lblAdministrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdministrarMouseClicked
        this.corBotao=new Color(152,184,154);
        this.lblAdministrar.setBackground(corBotao);
    }//GEN-LAST:event_lblAdministrarMouseClicked

     
    /*
    ###########################################
    #     MÉTODOS DE EVENTOS DO FORMULÁRIO    #
    ###########################################
    */
    
    /**
     * Evento de abertura do formulário.
     * @param evt evento 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //aqui, eu carrego já os dados do BD
        loadRegisteredEmployeeListAdministrative();
        loadRegisteredEmployeeListHealthProfessionals();
    }//GEN-LAST:event_formWindowOpened

    /**
     * Evento chamado quando o formulário se tornar visível.
     * @param evt evento 
     */
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        //recarregando as coisas
        this.pnlConteudo.revalidate();
        this.pnlConteudo.repaint();
        this.pack();
        //aqui, eu carrego já os dados do BD
        loadRegisteredEmployeeListAdministrative();
        loadRegisteredEmployeeListHealthProfessionals();
    }//GEN-LAST:event_formWindowActivated
	
    
    /*
    ###########################################
    #       MÉTODOS DA CHAMADA DAS TELAS      #
    ###########################################
    */
	
     /**
     * Método que seta a visibilidade dos panels existentes nesta tela.
     * @param telaExcluiCadastro seta a visibilidade do panel telaExcluiCadastro.
     * @param telaMedicoAlterarProfSaude seta a visibilidade do panel telaMedicoAlterarProfSaude.
     * @param telaMedicoPesquisa seta a visibilidade do panel telaMedicoPesquisa.
     * @param telaMedicoInsereProfSaude seta a visibilidade do panel telaMedicoInsereProfSaude.
     * @param telaAdministrativoAlterar seta a visibilidade do panel telaAdministrativoAlterar.
     * @param telaAdministrativoCadastro seta a visibilidade do panel telaAdministrativoCadastro.
     * @param administrativoPesquisa  seta a visibilidade do panel administrativoPesquisa.
     */
    private void setVisibility(boolean telaExcluiCadastro, boolean telaMedicoAlterarProfSaude, boolean telaMedicoPesquisa, 
      boolean telaMedicoInsereProfSaude, boolean telaAdministrativoAlterar, boolean telaAdministrativoCadastro, 
      boolean administrativoPesquisa){
        this.telaExcluiCadastro.setVisible(telaExcluiCadastro);
        this.telaMedicoAlterarProfSaude.setVisible(telaMedicoAlterarProfSaude);
        this.telaMedicoPesquisa.setVisible(telaMedicoPesquisa);
        this.telaMedicoInsereProfSaude.setVisible(telaMedicoInsereProfSaude);
        this.telaAdministrativoAlterar.setVisible(telaAdministrativoAlterar);
        this.telaAdministrativoCadastro.setVisible(telaAdministrativoCadastro);
        this.administrativoPesquisa.setVisible(administrativoPesquisa);
    }
	
    //TELAS TANTO MÉDICAS QUANTO ADMINISTRATIVAS
		
    /**
     * Método que carrega a tela de Exclusão no pnlResult.
     * @param evt evento 
     */
    private void lblExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExcluirMouseClicked
        this.setVisibility(true, false, false, false, false, false, false);
        this.pnlConteudo.add(this.telaExcluiCadastro);        
    }//GEN-LAST:event_lblExcluirMouseClicked
    
    //TELAS MÉDICAS
    
    /**
     * Método que carrega a tela de Cadastro Médico no pnlResult.
     * @param evt evento 
     */
    private void lblMCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMCadastrarMouseClicked
        this.setVisibility(false, false, false, true, false, false, false);
        this.pnlConteudo.add(this.telaMedicoInsereProfSaude);
    }//GEN-LAST:event_lblMCadastrarMouseClicked
    
    /**
     * Método que carrega a tela de Alteração Médica no pnlResult.
     * @param evt evento 
     */
    private void lblMAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMAlterarMouseClicked
        this.setVisibility(false, true, false, false, false, false, false);
        this.pnlConteudo.add(this.telaMedicoAlterarProfSaude);
    }//GEN-LAST:event_lblMAlterarMouseClicked

    /**
     * Método que carrega a tela de Pesquisa Médica no pnlResult.
     * @param evt evento 
     */
    private void lblMPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMPesquisarMouseClicked
       this.setVisibility(false, false, true, false, false, false, false);
        this.pnlConteudo.add(this.telaMedicoPesquisa);
    }//GEN-LAST:event_lblMPesquisarMouseClicked
    
    //TELAS ADIMINISTRATIVAS
    
    /**
     * Método que carrega a tela de Pesquisa Administrativa no pnlResult.
     * @param evt evento 
     */
    private void lblFPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFPesquisarMouseClicked
         this.setVisibility(false, false, false, false, false, false, true);
        this.pnlConteudo.add(this.administrativoPesquisa);
    }//GEN-LAST:event_lblFPesquisarMouseClicked

    /**
     * Método que carrega a tela de Cadastro Administrativo no pnlResult.
     * @param evt evento 
     */
    private void lblFCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFCadastrarMouseClicked
       this.setVisibility(false, false, false, false, false, true, false);
        this.telaAdministrativoCadastro.show();
    }//GEN-LAST:event_lblFCadastrarMouseClicked

    /**
     * Método que carrega a tela de Alteração Administrativa no pnlResult.
     * @param evt evento 
     */
    private void lblFAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFAlterarMouseClicked
        this.setVisibility(false, false, false, false, true, false, false);
        this.telaAdministrativoAlterar.show();
    }//GEN-LAST:event_lblFAlterarMouseClicked

    private void jSeparator1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSeparator1KeyReleased
         if(evt.getKeyChar()==27)  
            this.setVisibility(false, false, false, false, false, false, false);
    }//GEN-LAST:event_jSeparator1KeyReleased

        
    /*
    ###########################################
    #        MÉTODOS DE ACESSO AO BD          #
    ###########################################
    */
	
    /**
     * Método que lista os profissionais de saúde, setando o atributo @employeeListHealthProfessional.
     */
    private void loadRegisteredEmployeeListHealthProfessionals() {
        try 
        {   
            HealthProfessionalsDAO healthProfessionalsDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
            List<RegisteredEmployee> employees = healthProfessionalsDAO.SelectAllHealthProfessionals();
            this.employeeListHealthProfessional.setEmployeeList(employees.toArray());             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
   
    /**
     * Método que lista os profissionais de saúde, setando o atributo @employeeListAdministrative.
     */
    private void loadRegisteredEmployeeListAdministrative() {
        try 
        {
            RegisteredEmployeeDAO registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
            List<RegisteredEmployee> employees = registeredEmployeeDAO.SelectAllEmployee();
            this.employeeListAdministrative.setEmployeeList(employees.toArray());             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   /*
    ###########################################
    #         DECLARAÇÃO VARIÁVEIS            #
    ###########################################
    */  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdministrar;
    private javax.swing.JLabel lblAgendar;
    private javax.swing.JLabel lblConsultar;
    private javax.swing.JLabel lblExcluir;
    private javax.swing.JLabel lblFAlterar;
    private javax.swing.JLabel lblFCadastrar;
    private javax.swing.JLabel lblFPesquisar;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblGeral;
    private javax.swing.JLabel lblMAlterar;
    private javax.swing.JLabel lblMCadastrar;
    private javax.swing.JLabel lblMPesquisar;
    private javax.swing.JLabel lblMedicos;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVisualizar;
    private javax.swing.JPanel pnlConteudo;
    private javax.swing.JPanel pnlMenuLateral;
    // End of variables declaration//GEN-END:variables

/*
    ###########################################
    #                   MAIN                  #
    ###########################################
    */      
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaLogado().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaLogado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
/*TODO: chamar telas pra respectivo local pelo clique nos labels
        setar pra visualizável/n visualiável itens dos labels
        transformar labels p/ aparência clicável
        SIMBORA
        Alterar quem é JFrame para JPanel:
            - telaAdministrativoCadastro
        Refatorar métodos pra ficarem abaixo dos comentários [em ##]
        CardLayout
*/