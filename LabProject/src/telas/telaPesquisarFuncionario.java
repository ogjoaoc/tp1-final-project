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
import javax.swing.table.DefaultTableModel;

public class telaPesquisarFuncionario extends javax.swing.JFrame {

    BancoDeDados database = new BancoDeDados(); 
    private final String placeholderText = "Pesquisar por CPF ou nome...";
    
    public telaPesquisarFuncionario() {
        initComponents();
        this.setResizable(false); // Desativar redimensionamento da tela
        
        // Ler os dados dos arquivos
        database.lerArquivo("enfermeiro");
        database.lerArquivo("atendente");

        // Adicionar o listener para monitorar o campo de texto
        addSearchListener();
        
        // Inicializar a tabela com todos os funcionários
        carregarTabela(database.getFuncionarios());
        
        // Configurar o texto de instrução
        configurarPlaceholder();
    }

    private Timer debounceTimer;

    private void addSearchListener() {
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
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
        String textoBusca = jTextField1.getText().toLowerCase();
        
        // Verificar se o campo de busca está vazio
        if (textoBusca.isEmpty() || textoBusca.equals(placeholderText.toLowerCase())) {
            // Exibir todos os funcionários se o campo estiver vazio
            carregarTabela(database.getFuncionarios());
        } else {
            // Filtrar os funcionários com base no nome ou CPF
            List<Funcionario> funcionariosFiltrados = database.getFuncionarios().stream()
                .filter(f -> f.getNome().toLowerCase().contains(textoBusca) || f.getCpf().contains(textoBusca))
                .toList();

            // Criar um novo ArrayList com os elementos filtrados
            ArrayList<Funcionario> funcionariosArrayList = new ArrayList<>(funcionariosFiltrados);

            // Atualizar a tabela
            carregarTabela(funcionariosArrayList);
        }
    }

    private void carregarTabela(ArrayList<Funcionario> funcionarios) {
        DefaultTableModel model = (DefaultTableModel) tblFuncionarios.getModel();
        model.setRowCount(0);  // Limpar a tabela

        for (Funcionario f : funcionarios) {
            String funcao;
            if (f instanceof Enfermeiro) funcao = "Enfermeiro";
            else funcao = "Atendente";
            model.addRow(new Object[]{f.getNome(), f.getCpf(), f.getSexo(), f.getEmail(), funcao});
        }
    }

    private void configurarPlaceholder() {
        jTextField1.setText(placeholderText);
        jTextField1.setForeground(Color.GRAY);

        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField1.getText().equals(placeholderText)) {
                    jTextField1.setText("");
                    jTextField1.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField1.getText().isEmpty()) {
                    jTextField1.setForeground(Color.GRAY);
                    jTextField1.setText(placeholderText);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlBkGround = new javax.swing.JPanel();
        pnlPesquisa = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();  // Alterado para JTextField
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        btnDemitir = new javax.swing.JButton();
        btnVoltarResult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(931, 584));

        pnlBkGround.setBackground(new java.awt.Color(248, 197, 190));
        pnlBkGround.setLayout(new BorderLayout()); // Usar BorderLayout

        pnlPesquisa.setBackground(new java.awt.Color(248, 197, 190));
        javax.swing.GroupLayout pnlPesquisaLayout = new javax.swing.GroupLayout(pnlPesquisa);
        pnlPesquisa.setLayout(pnlPesquisaLayout);
        pnlPesquisaLayout.setHorizontalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(lblPaciente)
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        pnlPesquisaLayout.setVerticalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Nome", "CPF", "Sexo", "Email", "Função"
            }
        ));
        tblFuncionarios.setSelectionBackground(new java.awt.Color(248, 197, 190));
        jScrollPane1.setViewportView(tblFuncionarios);

        btnDemitir.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnDemitir.setText("Demitir");
        btnDemitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemitirActionPerformed(evt);
            }
        });

        btnVoltarResult.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltarResult.setText("Voltar");
        btnVoltarResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarResultActionPerformed(evt);
            }
        });
        
        JPanel btnPanel = new JPanel(); // Painel para o botão
        btnPanel.setBackground(new java.awt.Color(248, 197, 190));
        btnPanel.add(btnDemitir);
        btnPanel.add(btnVoltarResult); // Adicionar o botão ao painel

        pnlBkGround.add(pnlPesquisa, BorderLayout.NORTH);
        pnlBkGround.add(jScrollPane1, BorderLayout.CENTER);
        pnlBkGround.add(btnPanel, BorderLayout.SOUTH); // Adicionar o painel com o botão ao sul

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBkGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBkGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnVoltarResultActionPerformed(java.awt.event.ActionEvent evt) {                                                
        telaAdmin admin = new telaAdmin();
        admin.setVisible(true);
        this.dispose();
    }   
    
    private void btnDemitirActionPerformed(java.awt.event.ActionEvent evt) {
        int idx = tblFuncionarios.getSelectedRow();
        
        if (idx >= 0) {
            // Confirmação antes de excluir
            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja demitir o funcionário?", "Confirmar Demissão", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                // Remove o funcionario da lista
                if(tblFuncionarios.getValueAt(idx,4).equals("Enfermeiro")){
                    String cpf = tblFuncionarios.getValueAt(idx,1).toString();
                    database.removerPessoa("enfermeiro", cpf);
                }
                
                else if(tblFuncionarios.getValueAt(idx,4).equals("Atendente")){
                    String cpf = tblFuncionarios.getValueAt(idx,1).toString();
                    database.removerPessoa("atendente", cpf);
                }
                
                carregarTabela(database.getFuncionarios());
            }
        }
    }  

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPesquisarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnVoltarResult;
    private javax.swing.JButton btnDemitir;
    private javax.swing.JTextField jTextField1;  // Alterado para JTextField
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JPanel pnlBkGround;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JTable tblFuncionarios;
    // End of variables declaration                   
}
