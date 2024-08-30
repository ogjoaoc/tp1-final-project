package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.BorderLayout;
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
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import telas.telaAdmin;

public class telaCadastroExame extends javax.swing.JFrame {

    BancoDeDados bancoDeDados = new BancoDeDados();
    private String estadoSalvar;
    private final String placeholderText = "Pesquisar por nome...";
    
    public telaCadastroExame() {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        //bancoDeDados.lerArquivo("vacina");
        
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
        habilitarCampos(false,false,false);
        habilitarBotoes(true,false,true,true,false);
        
        //Adicionar o listener para monitorar o campo de texto
        addSearchListener();
        
        // Inicializar a tabela com todos os funcionários
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
        
        // Verificar se o campo de busca está vazio
        if (textoBusca.isEmpty() || textoBusca.equals(placeholderText.toLowerCase())) {
            // Exibir todos os funcionários se o campo estiver vazio
            carregarTabela(bancoDeDados.getExames());
        } else {
            // Filtrar os funcionários com base no nome ou CPF
            List<Exame> examesFiltrados = bancoDeDados.getExames().stream()
                .filter(e -> (e instanceof Sorologico && ((Sorologico) e).getPatologia().toLowerCase().contains(textoBusca.toLowerCase())) ||
                        (e instanceof Hemograma && ((Hemograma) e).getAlvo().toLowerCase().contains(textoBusca.toLowerCase())))
                .toList();

            // Criar um novo ArrayList com os elementos filtrados
            ArrayList<Exame> examesArrayList = new ArrayList<>(examesFiltrados);

            // Atualizar a tabela
            carregarTabela(examesArrayList);
        }
    }
    
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
    
    private void carregarTabela(ArrayList<Exame> exames) {
        DefaultTableModel model = (DefaultTableModel) tblExames.getModel();
        model.setRowCount(0);  // Limpar a tabela
        
        for(Exame e : exames){
            if(e instanceof Sorologico){
                model.addRow(new Object[]{"Sorológico", ((Sorologico) e).getPatologia(), e.getPreco()});
            }
            else if(e instanceof Hemograma){
             model.addRow(new Object[]{"Hemograma",((Hemograma) e).getAlvo(), e.getPreco()});
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
        lblTipo1 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtBarraPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExames = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundColor.setBackground(new java.awt.Color(248, 197, 190));

        lblExame.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblExame.setText("Exame:");

        txtExame.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        cmbTipo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo...", "Hemograma", "Sorológico" }));

        lblPreco.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblPreco.setText("Preço:");

        lblTipo1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTipo1.setText("Tipo: ");

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
        jScrollPane1.setViewportView(tblExames);

        btnSair.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
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
                                    .addComponent(lblTipo1))
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
                            .addComponent(jScrollPane1)))
                    .addGroup(backgroundColorLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(lblTipo1)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        telaAdmin admin = new telaAdmin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        limparCampos();
        habilitarCampos(true,true,true);
        habilitarBotoes(true,true,false,false,true);
        estadoSalvar = "cadastro";
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtExame.getText().equals("") || cmbTipo.getSelectedIndex() == 0 || txtPreco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser inseridos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            String nomeExame = txtExame.getText();
            String tipoExame = (String) cmbTipo.getSelectedItem();
            double preco = Double.parseDouble(txtPreco.getText());
            
            if(estadoSalvar.equals("cadastro")){
                // Adiciona um novo exame ao banco de dados
                if(tipoExame.equals("Sorológico")){
                    Sorologico exame = new Sorologico(nomeExame,preco);
                    try {
                        bancoDeDados.adicionarExame((Exame) exame);
                    } catch (IOException ex) {}
                } else if(tipoExame.equals("Hemograma")){
                    Hemograma exame = new Hemograma(nomeExame, preco);
                    try {
                        bancoDeDados.adicionarExame((Exame) exame);
                    } catch (IOException ex) {}
                }
                carregarTabela(bancoDeDados.getExames());
                
            }
            else if(estadoSalvar.equals("edicao")){
                // Atualiza o exame selecionado
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
        int idx = tblExames.getSelectedRow(); // Obtém o índice da linha selecionada na tabela
        if (idx >= 0) {

            // Preenche os campos com os dados da vacina selecionada
            txtExame.setText(tblExames.getValueAt(idx, 0).toString());
            txtPreco.setText(tblExames.getValueAt(idx, 2).toString());
            cmbTipo.setSelectedItem(tblExames.getValueAt(idx, 1).toString());

            // Define o estado para "edicao" e habilita os campos
            estadoSalvar = "edicao";
            habilitarCampos(true, true, true);
            habilitarBotoes(false, true, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um exame para editar.", "Mensagem", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int idx = tblExames.getSelectedRow(); // índice da linha selecionada na tabela
        
        if (idx >= 0) {
            // Confirmação antes de excluir
            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este exame?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                // Remove a vacina da lista
                String exameExcluido = tblExames.getValueAt(idx,0).toString();
                bancoDeDados.removerVacina(exameExcluido);

                // Atualiza a tabela
                carregarTabela(bancoDeDados.getExames());

                // Limpa os campos e desabilita os botões de edição e exclusão
                limparCampos();
                habilitarCampos(false, false, false);
                habilitarBotoes(true, false, true, true, true);
                limparBarraPesquisa();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um exame para excluir.", "Mensagem", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        habilitarCampos(false,false,false);
        habilitarBotoes(true,false,true,true,false);
        limparBarraPesquisa();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(telaCadastroExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadastroExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadastroExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadastroExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastroExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundColor;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExame;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo1;
    private javax.swing.JTable tblExames;
    private javax.swing.JTextField txtBarraPesquisa;
    private javax.swing.JTextField txtExame;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
