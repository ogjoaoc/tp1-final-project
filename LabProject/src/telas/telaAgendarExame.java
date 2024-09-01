package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

public class telaAgendarExame extends javax.swing.JFrame {
    
    private JPopupMenu popupExame = new JPopupMenu();
    private JPopupMenu popupEnfermeiro = new JPopupMenu();
    private BancoDeDados database = new BancoDeDados(); 
    private Timer debounceTimer;
    
    public telaAgendarExame() {
        initComponents();
        setupAutoComplete();
        setupPlaceholders();
        
        database.lerArquivo("exame");
        database.lerArquivo("enfermeiro");
    }
    
    private void setupAutoComplete() {
        txtExame.getDocument().addDocumentListener(new AutoCompleteListener(txtExame, "exame"));
        txtEnfermeiro.getDocument().addDocumentListener(new AutoCompleteListener(txtEnfermeiro, "enfermeiro"));
    }

    private class AutoCompleteListener implements DocumentListener {
        private JTextField textField;
        private String tipo;  
        private JPopupMenu popupMenu;
        private boolean updatingText = false;

        public AutoCompleteListener(JTextField textField, String tipo) {
            this.textField = textField;
            this.tipo = tipo;

            switch(tipo) {
                case "exame":
                    this.popupMenu = popupExame;
                    break;
                case "enfermeiro":
                    this.popupMenu = popupEnfermeiro;
                    break;
            }
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (!updatingText) {
                debounceBusca();
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (!updatingText) {
                debounceBusca();
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        private void debounceBusca() {
            if (debounceTimer != null) {
                debounceTimer.stop();
            }

            debounceTimer = new Timer(300, e -> showSuggestions());
            debounceTimer.setRepeats(false);
            debounceTimer.start();
        }

        private void showSuggestions() {
            
            popupMenu.removeAll();
            String textoBusca = textField.getText().toLowerCase();

            if (textoBusca.isEmpty()) {
                popupMenu.setVisible(false);
                return;
            }

            ArrayList<String> suggestions = buscarSugestoes(textoBusca, tipo);

            for (String suggestion : suggestions) {
                JMenuItem item = new JMenuItem(suggestion);
                item.addActionListener(e -> {
                    updatingText = true;
                    textField.setText(suggestion);
                    
                    // Se o exame foi selecionado, atualizar o campo de preço
                    if(tipo.equals("exame")){
                        Exame exame = database.getExames().stream()
                            .filter(ex -> {
                                if (ex instanceof Sorologico) {
                                    return ((Sorologico) ex).getPatologia().equalsIgnoreCase(suggestion);
                                } else if (ex instanceof Hemograma) {
                                    return ((Hemograma) ex).getAlvo().equalsIgnoreCase(suggestion);
                                }
                                return false;
                            })
                            .findFirst().orElse(null);

                        if (exame != null) {
                            txtPreco.setText(String.valueOf(exame.getPreco()));
                        }
                    }

                    popupMenu.setVisible(false);
                    textField.requestFocusInWindow();
                    updatingText = false;
                
                });
                popupMenu.add(item);
            }

            if (popupMenu.getComponentCount() > 0) {
                popupMenu.show(textField, 0, textField.getHeight());
            } else {
                popupMenu.setVisible(false);
            }
            
        }

        private ArrayList<String> buscarSugestoes(String textoBusca, String tipo) {
            ArrayList<String> resultados = new ArrayList<>();

            switch (tipo) {
                case "exame":
                    resultados = new ArrayList<>(database.getExames().stream()
                            .map(ex -> {
                                if (ex instanceof Sorologico) {
                                    return ((Sorologico) ex).getPatologia();
                                } else if (ex instanceof Hemograma) {
                                    return ((Hemograma) ex).getAlvo();
                                }
                                return ""; // Caso não seja de nenhum dos tipos esperados
                            })
                            .filter(nome -> nome.toLowerCase().contains(textoBusca.toLowerCase()))
                            .toList());
                    break;
                case "enfermeiro":
                    resultados = new ArrayList<>(database.getEnfermeiros().stream()
                            .map(Enfermeiro::getNome)
                            .filter(nome -> nome.toLowerCase().contains(textoBusca))
                            .toList());
                    break;
            }

            return resultados;
        }
    }

    private void setupPlaceholders() {
        configurarPlaceholder(txtExame, "Digite o nome do exame...");
        configurarPlaceholder(txtEnfermeiro, "Digite o nome do enfermeiro...");
    }

    private void configurarPlaceholder(JTextField textField, String placeholderText) {
        textField.setText(placeholderText);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholderText);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblExame = new javax.swing.JLabel();
        lblEnfermeiro = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtExame = new javax.swing.JTextField();
        txtEnfermeiro = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnAgendar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 500, 200));
        setMinimumSize(new java.awt.Dimension(500, 200));
        this.setLocationRelativeTo(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(248, 197, 190));

        lblExame.setText("Exame: ");
        lblExame.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtExame.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblEnfermeiro.setText("Enfermeiro: ");
        lblEnfermeiro.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtEnfermeiro.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblPreco.setText("Preço: ");
        lblPreco.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 18));
        
        btnAgendar.setText("Agendar");
        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblExame)
                    .addComponent(lblEnfermeiro)
                    .addComponent(lblPreco))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtExame)
                    .addComponent(txtEnfermeiro)
                    .addComponent(txtPreco))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnAgendar)
                .addGap(40, 40, 40)
                .addComponent(btnSair)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExame)
                    .addComponent(txtExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnfermeiro)
                    .addComponent(txtEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnSair))
                .addGap(30, 30, 30)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        telaAgendamento telaAgendamento = new telaAgendamento();
        telaAgendamento.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendarVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEnfermeiro;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblExame;
    private javax.swing.JTextField txtEnfermeiro;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtExame;
    // End of variables declaration  
}

