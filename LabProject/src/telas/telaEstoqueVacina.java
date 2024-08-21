/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// falta terminar de implementar os botões de editar e excluir.
package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.BorderLayout;
import java.awt.Color;
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


public class telaEstoqueVacina extends javax.swing.JFrame{
    // Instanciando database    
    BancoDeDados bancoDeDados = new BancoDeDados();
    private String estadoSalvar;
    private final String placeholderText = "Pesquisar por nome ou validade...";
    
    public telaEstoqueVacina() {
        initComponents();
        this.setResizable(false);
        bancoDeDados.lerArquivo("vacina");
        
        // Adiciona a tecla ENTER a funcionalidade de avançar os campos de texto
        txtVacina.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        txtValidade.requestFocus(); 
                    }
                }
        });
        txtValidade.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        txtQuantidade.requestFocus(); 
                    }
                }
        });
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
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
        habilitarCampos(false,false,false,false);
        habilitarBotoes(true,false,true,true,false);
        
        // Adicionar o listener para monitorar o campo de texto
        addSearchListener();
        
        // Inicializar a tabela com todos os funcionários
        carregarTabela(bancoDeDados.getVacinas());
        
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
            carregarTabela(bancoDeDados.getVacinas());
        } else {
            // Filtrar os funcionários com base no nome ou CPF
            List<Vacina> vacinasFiltrados = bancoDeDados.getVacinas().stream()
                .filter(f -> f.getTipoVacina().toLowerCase().contains(textoBusca) || f.getValidade().contains(textoBusca))
                .toList();

            // Criar um novo ArrayList com os elementos filtrados
            ArrayList<Vacina> vacinasArrayList = new ArrayList<>(vacinasFiltrados);

            // Atualizar a tabela
            carregarTabela(vacinasArrayList);
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
    
    private void limparBarraPesquisa(){
        txtBarraPesquisa.setText(placeholderText);
        txtBarraPesquisa.setForeground(Color.GRAY);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnlBkGround = new javax.swing.JPanel();
        pnlVacina = new javax.swing.JPanel();
        lblVacina = new javax.swing.JLabel();
        txtVacina = new javax.swing.JTextField();
        lblValidade = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtValidade = new javax.swing.JFormattedTextField();
        lblpreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVacinas = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtBarraPesquisa = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 760, 600));
        setMinimumSize(new java.awt.Dimension(760, 600));
        setResizable(false);

        pnlBkGround.setBackground(new java.awt.Color(248, 197, 190));

        pnlVacina.setBackground(new java.awt.Color(248, 197, 190));

        lblVacina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVacina.setText("Vacina:");

        txtVacina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVacinaActionPerformed(evt);
            }
        });

        lblValidade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValidade.setText("Validade:");

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantidade.setText("Quantidade:");

        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        try {
            txtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtValidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValidade.setPreferredSize(new java.awt.Dimension(126, 36));

        lblpreco.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblpreco.setText("Preço: ");

        try {
            txtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPreco.setPreferredSize(new java.awt.Dimension(126, 36));

        javax.swing.GroupLayout pnlVacinaLayout = new javax.swing.GroupLayout(pnlVacina);
        pnlVacina.setLayout(pnlVacinaLayout);
        pnlVacinaLayout.setHorizontalGroup(
            pnlVacinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVacinaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVacinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVacina)
                    .addComponent(lblValidade))
                .addGap(26, 26, 26)
                .addGroup(pnlVacinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVacinaLayout.createSequentialGroup()
                        .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblpreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlVacinaLayout.setVerticalGroup(
            pnlVacinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVacinaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlVacinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVacina)
                    .addComponent(txtVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVacinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValidade)
                    .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tblVacinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome ", "Validade", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblVacinas.setSelectionBackground(new java.awt.Color(248, 197, 190));
        jScrollPane1.setViewportView(tblVacinas);

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Sair");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtBarraPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBarraPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarraPesquisaActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar Vacina");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBkGroundLayout = new javax.swing.GroupLayout(pnlBkGround);
        pnlBkGround.setLayout(pnlBkGroundLayout);
        pnlBkGroundLayout.setHorizontalGroup(
            pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlVacina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlBkGroundLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(pnlBkGroundLayout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                    .addComponent(txtBarraPesquisa))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlBkGroundLayout.setVerticalGroup(
            pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBkGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBkGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void txtVacinaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        telaAdmin admin = new telaAdmin();
        admin.setVisible(true);
        this.dispose();
    }                                         

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(txtVacina.getText().equals("") || txtValidade.getText().equals("") ||
           txtQuantidade.getText().equals("") || txtPreco.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser inseridos!", "Mensagem",JOptionPane.PLAIN_MESSAGE);
        } else{
            String nomeVacina = txtVacina.getText();
            String validade = txtValidade.getText();
            int qtd = Integer.parseInt(txtQuantidade.getText());
            double preco = Double.parseDouble(txtPreco.getText());
            
            if(estadoSalvar.equals("cadastro")){
                // Adiciona uma nova vacina ao estoque
                try {
                    boolean disponivel = true;
                    Vacina vacina = new Vacina(nomeVacina, validade, disponivel, qtd, preco);
                    bancoDeDados.adicionarVacina(vacina);
                    carregarTabela(bancoDeDados.getVacinas());
                } catch (IOException ex) {}
            }
            else if(estadoSalvar.equals("edicao")){
                // Atualiza a vacina selecionada
                Vacina vacinaEditada = new Vacina(nomeVacina,validade,true,qtd,preco);
                bancoDeDados.atualizarVacina(vacinaEditada);
                carregarTabela(bancoDeDados.getVacinas());
            }
        }
        
        limparCampos();
        habilitarCampos(false,false,false,false);
        habilitarBotoes(true,false,true,true,true);
        limparBarraPesquisa();
    }                                         

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int idx = tblVacinas.getSelectedRow(); // Obtém o índice da linha selecionada na tabela
        if (idx >= 0) {

            // Preenche os campos com os dados da vacina selecionada
            txtVacina.setText(tblVacinas.getValueAt(idx, 0).toString());
            txtValidade.setText(tblVacinas.getValueAt(idx, 1).toString());
            txtQuantidade.setText(tblVacinas.getValueAt(idx, 2).toString());
            txtPreco.setText(tblVacinas.getValueAt(idx,3).toString());

            // Define o estado para "edicao" e habilita os campos
            estadoSalvar = "edicao";
            habilitarCampos(false, true, true, true);
            habilitarBotoes(false, true, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma vacina para editar.", "Mensagem", JOptionPane.WARNING_MESSAGE);
        }
    }                                         

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int idx = tblVacinas.getSelectedRow(); // índice da linha selecionada na tabela
        
        if (idx >= 0) {
            // Confirmação antes de excluir
            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta vacina?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                // Remove a vacina da lista
                String vacinaExcluida = tblVacinas.getValueAt(idx,0).toString();
                bancoDeDados.removerVacina(vacinaExcluida);

                // Atualiza a tabela
                carregarTabela(bancoDeDados.getVacinas());

                // Limpa os campos e desabilita os botões de edição e exclusão
                limparCampos();
                habilitarCampos(false, false, false, false);
                habilitarBotoes(true, false, true, true, true);
                limparBarraPesquisa();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma vacina para excluir.", "Mensagem", JOptionPane.WARNING_MESSAGE);
        }   
    }                                          

    private void txtBarraPesquisaActionPerformed(java.awt.event.ActionEvent evt) {}                                                

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        limparCampos();
        habilitarCampos(true,true,true,true);
        habilitarBotoes(true,true,false,false,true);
        estadoSalvar = "cadastro";
    }                                            

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        limparCampos();
        habilitarCampos(false,false,false,false);
        habilitarBotoes(true,false,true,true,false);
        limparBarraPesquisa();
        
    }                                           
    
    private void limparCampos(){
       txtVacina.setText("");
       txtValidade.setText("");
       txtQuantidade.setText("");
       txtPreco.setText("");
    }
    
    private void habilitarCampos(boolean vacina, boolean val, boolean qtd, boolean preco){
        txtVacina.setEnabled(vacina);
        txtValidade.setEnabled(val);
        txtQuantidade.setEnabled(qtd);
        txtPreco.setEnabled(preco);
    }
    
    private void habilitarBotoes(boolean cad, boolean salvar, boolean editar, boolean excluir, boolean cancelar){
        btnCadastrar.setEnabled(cad);
        btnSalvar.setEnabled(salvar);
        btnEditar.setEnabled(editar);
        btnExcluir.setEnabled(excluir);
        btnCancelar.setEnabled(cancelar);
    }
    
    // arrumar carregamento da tabela
    private void carregarTabela(ArrayList<Vacina> vacinas) {
        DefaultTableModel model = (DefaultTableModel) tblVacinas.getModel();
        model.setRowCount(0);  // Limpar a tabela

        for (Vacina v : vacinas) {
            model.addRow(new Object[]{v.getTipoVacina(),v.getValidade(),v.getQtd(),v.getPreco()});
        }
    }
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaEstoqueVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblVacina;
    private javax.swing.JLabel lblValidade;
    private javax.swing.JLabel lblpreco;
    private javax.swing.JPanel pnlBkGround;
    private javax.swing.JPanel pnlVacina;
    private javax.swing.JTable tblVacinas;
    private javax.swing.JTextField txtBarraPesquisa;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtVacina;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration                   
}

