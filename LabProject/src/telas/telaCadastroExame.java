// Interface Gráfica: telaCadastroExame
// Tela auxiliar para cadastrar objetos do tipo Exame na base de dados.
// Somente administradores tem o privilégio de manipular essa tela.
// É possível criar, excluir, editar e pesquisar exames já existentes na base de dados.

package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class telaCadastroExame extends javax.swing.JFrame {
    
//    Instanciando base de dados e auxiliares.

    BancoDeDados bancoDeDados = new BancoDeDados();
    private String estadoSalvar;
    private final String placeholderText = "Pesquisar por nome...";
    
    
//    Construtor

    public telaCadastroExame() {
        
        initComponents();
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        this.setTitle("Admin - Cadastro de Exames");
        this.setLocationRelativeTo(null);
        
        bancoDeDados.lerArquivo("exame");
        
        // Adiciona a tecla ENTER a funcionalidade de avançar os campos de texto
        
        txtExame.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        txtPreco.requestFocus(); 
                    }
                }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        btnSalvar.doClick(); 
                    }
                }
        });
        
        limparCampos();
        escAtalho();
        habilitarCampos(false,false,false);
        habilitarBotoes(true,false,true,true,false);
        
        //Adicionar o listener para monitorar o campo de texto
        
        addSearchListener();
        
        // Inicializar a tabela com todos os exames
        
        carregarTabela(bancoDeDados.getExames());
        
        // Configurar o texto de instrução
        
        configurarPlaceholder();
        
    }
    
    private Timer debounceTimer;
    
    private void addSearchListener() {
        txtBarraPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                debounceBusca();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                debounceBusca();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                debounceBusca();
            }
        });
    }

    private void debounceBusca() {
        if (debounceTimer != null) {
            debounceTimer.stop();
        }

        debounceTimer = new Timer(300, e -> atualizarBusca());  // 300ms debounce
        debounceTimer.setRepeats(false);  // Executar apenas uma vez
        debounceTimer.start();
    }

    private void atualizarBusca() {
        
        String textoBusca = txtBarraPesquisa.getText().toLowerCase();
        
        if (textoBusca.isEmpty() || textoBusca.equals(placeholderText.toLowerCase())) {
            
            // Exibir todos os exames se o campo estiver vazio
            
            carregarTabela(bancoDeDados.getExames());
            
        } else {
            
//            Filtro utilizando a EDA List, e o método stream(), para retirar linhas com o nome digitado.
            
            List<Exame> examesFiltrados = bancoDeDados.getExames().stream()
                .filter(e -> (e instanceof Sorologico && ((Sorologico) e).getPatologia().toLowerCase().contains(textoBusca.toLowerCase())) ||
                        (e instanceof Hemograma && ((Hemograma) e).getAlvo().toLowerCase().contains(textoBusca.toLowerCase())))
                .toList();

//             Convertendo a List para ArrayList, para seguir os padrões da base de dados.
            
            ArrayList<Exame> examesArrayList = new ArrayList<>(examesFiltrados);

            carregarTabela(examesArrayList);
            
        }
    }
    
//        Método auxiliar para configuração do placeholder.
    
    private void configurarPlaceholder() {
        
        txtBarraPesquisa.setText(placeholderText);
        txtBarraPesquisa.setForeground(Color.GRAY);

        txtBarraPesquisa.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                
                if (txtBarraPesquisa.getText().equals(placeholderText)) {
                    txtBarraPesquisa.setText("");
                    txtBarraPesquisa.setForeground(Color.BLACK);
                }
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                if (txtBarraPesquisa.getText().isEmpty()) {
                    txtBarraPesquisa.setForeground(Color.GRAY);
                    txtBarraPesquisa.setText(placeholderText);
                }
                
            }
        });
    }
    
    
//    Módulo auxiliar para tecla ESCAPE retornar a tela anterior
    
    private void escAtalho() {

        this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "exitToLogin");
        this.getRootPane().getActionMap().put("exitToLogin", new AbstractAction() {
        @Override public void actionPerformed(ActionEvent e) { btnVoltar.doClick(); } });
        
    }
    
//        Método auxiliar para carregar dados dos exames da base de dados na tebela.
    
    private void carregarTabela(ArrayList<Exame> exames) {
        
        DefaultTableModel model = (DefaultTableModel) tblExames.getModel();
        model.setRowCount(0);  
        
        for(Exame e : exames){
            switch (e) {
                case Sorologico sorologico -> model.addRow(new Object[]{"Sorológico", sorologico.getPatologia(), e.getPreco()});
                case Hemograma hemograma -> model.addRow(new Object[]{"Hemograma",hemograma.getAlvo(), e.getPreco()});
                default -> {
                }
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundColor = new javax.swing.JPanel();
        lblExame = new javax.swing.JLabel();
        txtExame = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        lblPreco = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtBarraPesquisa = new javax.swing.JTextField();
        scrollPaneExames = new javax.swing.JScrollPane();
        tblExames = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundColor.setBackground(new java.awt.Color(248, 197, 190));

        lblExame.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblExame.setText("Exame:");

        txtExame.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        cmbTipo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo...", "Hemograma", "Sorológico" }));

        lblPreco.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblPreco.setText("Preço:");

        lblTipo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTipo.setText("Tipo: ");

        txtPreco.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar Exame");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtBarraPesquisa.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        tblExames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exame", "Tipo", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPaneExames.setViewportView(tblExames);

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundColorLayout = new javax.swing.GroupLayout(backgroundColor);
        backgroundColor.setLayout(backgroundColorLayout);
        backgroundColorLayout.setHorizontalGroup(
            backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundColorLayout.createSequentialGroup()
                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundColorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backgroundColorLayout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundColorLayout.createSequentialGroup()
                                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblExame)
                                    .addComponent(lblTipo))
                                .addGap(18, 18, 18)
                                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundColorLayout.createSequentialGroup()
                                        .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtExame, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(backgroundColorLayout.createSequentialGroup()
                                                .addGap(119, 119, 119)
                                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(148, 148, 148)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(backgroundColorLayout.createSequentialGroup()
                                        .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(backgroundColorLayout.createSequentialGroup()
                                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblPreco)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPreco))))
                            .addComponent(txtBarraPesquisa)
                            .addComponent(scrollPaneExames)))
                    .addGroup(backgroundColorLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        backgroundColorLayout.setVerticalGroup(
            backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundColorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExame)
                    .addComponent(txtExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(lblTipo)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtBarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneExames, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaAdmin admin = new telaAdmin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        
        limparCampos();
        habilitarCampos(true,true,true);
        habilitarBotoes(false,true,false,false,true);
        estadoSalvar = "cadastro";
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if (txtExame.getText().equals("") || cmbTipo.getSelectedIndex() == 0 || txtPreco.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preechidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
        
        else{
            
            String nomeExame = txtExame.getText();
            String tipoExame = (String) cmbTipo.getSelectedItem();
            double preco = Double.parseDouble(txtPreco.getText());
            
            if(estadoSalvar.equals("cadastro")){
                
                if(tipoExame.equals("Sorológico")){
                    
                    Sorologico exame = new Sorologico(nomeExame,preco);
                    
                    try {
                        bancoDeDados.adicionarExame((Exame) exame);
                    } catch (IOException ex) {
                        System.out.println("Erro ao adicionar exame na base de dados...");
                    }
                    
                } else if(tipoExame.equals("Hemograma")){
                    
                    Hemograma exame = new Hemograma(nomeExame, preco);
                    
                    try {
                        bancoDeDados.adicionarExame((Exame) exame);
                    } catch (IOException ex) {
                        System.out.println("Erro ao adicionar exame na base de dados...");
                    }
                }
                carregarTabela(bancoDeDados.getExames());
                
            } else if(estadoSalvar.equals("edicao")) {
                
                if(tipoExame.equals("Sorológico")){

                    Sorologico exameEditado = new Sorologico(nomeExame,preco);
                    bancoDeDados.atualizarExame((Exame) exameEditado);

                } else if(tipoExame.equals("Hemograma")){

                    Hemograma exameEditado = new Hemograma(nomeExame, preco);
                    bancoDeDados.atualizarExame((Exame) exameEditado);

                }

                carregarTabela(bancoDeDados.getExames());

            }
        }
        
        limparCampos();
        habilitarCampos(false,false,false);
        habilitarBotoes(true,false,true,true,true);
        limparBarraPesquisa();           
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       
        int idx = tblExames.getSelectedRow(); 
        
        if (idx >= 0) {

            txtExame.setText(tblExames.getValueAt(idx, 1).toString());
            txtPreco.setText(tblExames.getValueAt(idx, 2).toString());
            cmbTipo.setSelectedItem(tblExames.getValueAt(idx, 0).toString());

            estadoSalvar = "edicao";
            habilitarCampos(true, true, true);
            habilitarBotoes(false, true, true, true, true);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Selecione um exame para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        
        }
    }//GEN-LAST:event_btnEditarActionPerformed

//        O botão excluir é responsável pela exclusão do objeto Funcionário selecionado da base de dados.
    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        int idx = tblExames.getSelectedRow(); 
        
        if (idx >= 0) {
            
            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este exame?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            
            if (confirmacao == JOptionPane.YES_OPTION) {

                // Remove a vacina da lista

                String exameExcluido = tblExames.getValueAt(idx,1).toString();
                bancoDeDados.removerExame(exameExcluido);

                // Atualiza a tabela
                
                carregarTabela(bancoDeDados.getExames());

                // Limpa os campos e desabilita os botões de edição e exclusão
                
                limparCampos();
                habilitarCampos(false, false, false);
                habilitarBotoes(true, false, true, true, true);
                limparBarraPesquisa();
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Selecione um exame para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }   
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        limparCampos();
        habilitarCampos(false,false,false);
        habilitarBotoes(true,false,true,true,false);
        limparBarraPesquisa();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

//    Abaixo seguem métodos auxiliares para limpeza de campos e organização.
    
    private void limparCampos(){
       
       txtExame.setText("");
       txtPreco.setText("");
       cmbTipo.setSelectedIndex(0);
       
    }
    
    private void habilitarCampos(boolean exame, boolean preco, boolean tipo){
        
        txtExame.setEnabled(exame);
        txtPreco.setEnabled(preco);
        cmbTipo.setEnabled(tipo);
        
    }
    
    private void habilitarBotoes(boolean cad, boolean salvar, boolean editar, boolean excluir, boolean cancelar){
        
        btnCadastrar.setEnabled(cad);
        btnSalvar.setEnabled(salvar);
        btnEditar.setEnabled(editar);
        btnExcluir.setEnabled(excluir);
        btnCancelar.setEnabled(cancelar);
        
    }
    
    private void limparBarraPesquisa(){
        
        txtBarraPesquisa.setText(placeholderText);
        txtBarraPesquisa.setForeground(Color.GRAY);
        
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new telaCadastroExame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundColor;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel lblExame;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JScrollPane scrollPaneExames;
    private javax.swing.JTable tblExames;
    private javax.swing.JTextField txtBarraPesquisa;
    private javax.swing.JTextField txtExame;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
