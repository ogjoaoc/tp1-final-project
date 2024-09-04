package telas;

import classes.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class telaPagamento extends javax.swing.JFrame {

    public telaPagamento() {}
    
    private ArrayList<Exame> pagamentoExames;
    private ArrayList<Vacina> pagamentoVacinas;
    private telaAgendamento telaPrincipalAgendamento;
    private double valorTotalAgendamento = 0f;
    
    public telaPagamento(telaAgendamento telaPrincipalAgendamento) {
        
        initComponents();
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        this.telaPrincipalAgendamento = telaPrincipalAgendamento;
        pagamentoExames = telaPrincipalAgendamento.getCheckOutExames();
        pagamentoVacinas = telaPrincipalAgendamento.getCheckOutVacina();
       
        atualizarTabelaPagamento();
        configurarCamposTexto();
        
    }
    
    private void atualizarTabelaPagamento() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Item", "Info", "Valor"});
        double valorTotal = 0.0;

        for (Exame exame : pagamentoExames) {
            String[] linha = {
                "Exame", exame.getSubtipo(), String.format("$%.2f", exame.getPreco())
            };
            modelo.addRow(linha);
            valorTotal += exame.getPreco();
        }

        for (Vacina vacina : pagamentoVacinas) {
            String[] linha = {
                "Vacina", vacina.getTipoVacina(), String.format("$%.2f", vacina.getPreco())
            };
            modelo.addRow(linha);
            valorTotal += vacina.getPreco();
        }

        jTable1.setModel(modelo);
        lblValorTotalPanel.setText(String.format("Valor total: $%.2f", valorTotal));
        valorTotalAgendamento = valorTotal;
    }

    
    private void configurarCamposTexto() {
        
        txtNomeTitular.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        txtCpf.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        txtNumCartao.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        txtDataVencimento.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        
        txtNomeTitular.setText("Nome do titular");
        txtNomeTitular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtNomeTitular.getText().equals("Nome do titular")) {
                    txtNomeTitular.setText("");
                    txtNomeTitular.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtNomeTitular.getText().isEmpty()) {
                    txtNomeTitular.setText("Nome do titular");
                    txtNomeTitular.setForeground(Color.GRAY);
                }
            }
        });
        txtNomeTitular.setForeground(Color.GRAY);

        txtNumCartao.setText("0000000000000000");
        txtNumCartao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtNumCartao.getText().equals("0000.0000.0000.0000")) {
                    txtNumCartao.setText("");
                    txtNumCartao.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtNumCartao.getText().isEmpty()) {
                    txtNumCartao.setText("0000 0000 0000 0000");
                    txtNumCartao.setForeground(Color.GRAY);
                }
            }
        });
        txtNumCartao.setForeground(Color.GRAY);

        txtCvv.setText("123");
        txtCvv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtCvv.getText().equals("123")) {
                    txtCvv.setText("");
                    txtCvv.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtCvv.getText().isEmpty()) {
                    txtCvv.setText("123");
                    txtCvv.setForeground(Color.GRAY);
                }
            }
        });
        txtCvv.setForeground(Color.GRAY);

        txtEnderecoCobranca.setText("Endereço de cobrança");
        txtEnderecoCobranca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtEnderecoCobranca.getText().equals("Endereço de cobrança")) {
                    txtEnderecoCobranca.setText("");
                    txtEnderecoCobranca.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtEnderecoCobranca.getText().isEmpty()) {
                    txtEnderecoCobranca.setText("Endereço de cobrança");
                    txtEnderecoCobranca.setForeground(Color.GRAY);
                }
            }
        });
        txtEnderecoCobranca.setForeground(Color.GRAY);

        txtCpf.setText("000.000.000-00");
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtCpf.getText().equals("000.000.000-00")) {
                    txtCpf.setText("");
                    txtCpf.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtCpf.getText().isEmpty()) {
                    txtCpf.setText("000.000.000-00");
                    txtCpf.setForeground(Color.GRAY);
                }
            }
        });
        txtCpf.setForeground(Color.GRAY);
        
        txtDataVencimento.setText("24/04/2024");
        txtDataVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtDataVencimento.getText().equals("24/04/2024")) {
                    txtDataVencimento.setText("");
                    txtDataVencimento.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtDataVencimento.getText().isEmpty()) {
                    txtDataVencimento.setText("24/04/2024");
                    txtDataVencimento.setForeground(Color.GRAY);
                }
            }
        });
        txtDataVencimento.setForeground(Color.GRAY);
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundColor = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        panelTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        tabbedPagamento = new javax.swing.JTabbedPane();
        pnlCartao = new javax.swing.JPanel();
        lblNomeTitular = new javax.swing.JLabel();
        lblNumCartao = new javax.swing.JLabel();
        txtCvv = new javax.swing.JTextField();
        lblVencimento = new javax.swing.JLabel();
        txtEnderecoCobranca = new javax.swing.JTextField();
        lblCVV = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblVencimento1 = new javax.swing.JLabel();
        lblIconCard = new javax.swing.JLabel();
        separatorCartao = new javax.swing.JSeparator();
        txtNumCartao = new javax.swing.JFormattedTextField();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        txtNomeTitular = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        pnlPix = new javax.swing.JPanel();
        pnlValorTotal = new javax.swing.JPanel();
        lblTitleCheckOut = new javax.swing.JLabel();
        lblValorTotalPanel = new javax.swing.JLabel();
        separatorCheckOut = new javax.swing.JSeparator();
        tblCheckOut = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundColor.setBackground(new java.awt.Color(248, 197, 190));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("Informações - Pagamento");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(362, 362, 362))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(16, 16, 16))
        );

        tabbedPagamento.setBackground(new java.awt.Color(248, 197, 190));
        tabbedPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 197, 190)));
        tabbedPagamento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        pnlCartao.setBackground(new java.awt.Color(248, 197, 190));
        pnlCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 197, 190), 2, true));

        lblNomeTitular.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNomeTitular.setText("Nome do titular:");

        lblNumCartao.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNumCartao.setText("Número do cartão:");

        txtCvv.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        lblVencimento.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblVencimento.setText("Endereço de cobrança:");

        txtEnderecoCobranca.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        lblCVV.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCVV.setText("CVV:");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCpf.setText("CPF:");

        lblVencimento1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblVencimento1.setText("Data de vencimento:");

        lblIconCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconCard.png"))); // NOI18N

        separatorCartao.setForeground(new java.awt.Color(0, 0, 0));
        separatorCartao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        try {
            txtNumCartao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####.####.####.####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumCartao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtNomeTitular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtNomeTitular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCartaoLayout = new javax.swing.GroupLayout(pnlCartao);
        pnlCartao.setLayout(pnlCartaoLayout);
        pnlCartaoLayout.setHorizontalGroup(
            pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartaoLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(separatorCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(pnlCartaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartaoLayout.createSequentialGroup()
                        .addComponent(txtNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlCartaoLayout.createSequentialGroup()
                        .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeTitular)
                            .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumCartao)
                                    .addComponent(txtNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblVencimento))
                            .addComponent(txtEnderecoCobranca, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVencimento1)
                            .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartaoLayout.createSequentialGroup()
                                .addComponent(lblIconCard, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartaoLayout.createSequentialGroup()
                                .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCVV)
                                    .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCpf))
                                .addGap(58, 58, 58))))))
        );
        pnlCartaoLayout.setVerticalGroup(
            pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartaoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeTitular)
                    .addComponent(lblCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCartaoLayout.createSequentialGroup()
                        .addComponent(lblCVV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCartaoLayout.createSequentialGroup()
                        .addComponent(lblNumCartao)
                        .addGap(36, 36, 36))
                    .addComponent(txtNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartaoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnderecoCobranca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVencimento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCartaoLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblIconCard, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(separatorCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        tabbedPagamento.addTab("    Cartão de Crédito     ", pnlCartao);

        pnlPix.setBackground(new java.awt.Color(248, 197, 190));

        javax.swing.GroupLayout pnlPixLayout = new javax.swing.GroupLayout(pnlPix);
        pnlPix.setLayout(pnlPixLayout);
        pnlPixLayout.setHorizontalGroup(
            pnlPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        pnlPixLayout.setVerticalGroup(
            pnlPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        tabbedPagamento.addTab("   Pix    ", pnlPix);

        pnlValorTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitleCheckOut.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitleCheckOut.setText("Check-out:");

        lblValorTotalPanel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblValorTotalPanel.setText("Valor total:  $");

        separatorCheckOut.setForeground(new java.awt.Color(0, 0, 0));
        separatorCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Info", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCheckOut.setViewportView(jTable1);

        javax.swing.GroupLayout pnlValorTotalLayout = new javax.swing.GroupLayout(pnlValorTotal);
        pnlValorTotal.setLayout(pnlValorTotalLayout);
        pnlValorTotalLayout.setHorizontalGroup(
            pnlValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlValorTotalLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separatorCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tblCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(pnlValorTotalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorTotalPanel)
                    .addComponent(lblTitleCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlValorTotalLayout.setVerticalGroup(
            pnlValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValorTotalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitleCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tblCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(separatorCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(lblValorTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundColorLayout = new javax.swing.GroupLayout(backgroundColor);
        backgroundColor.setLayout(backgroundColorLayout);
        backgroundColorLayout.setHorizontalGroup(
            backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundColorLayout.createSequentialGroup()
                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(backgroundColorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundColorLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(pnlValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        backgroundColorLayout.setVerticalGroup(
            backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundColorLayout.createSequentialGroup()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundColorLayout.createSequentialGroup()
                        .addComponent(tabbedPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        telaPrincipalAgendamento.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        int idAgendamento = telaPrincipalAgendamento.database.getAgendamentos().size() + 1;
        double valorTotal = valorTotalAgendamento; // Valor total calculado anteriormente

        Agendamento novoAgendamento = new Agendamento(idAgendamento, pagamentoExames, pagamentoVacinas, valorTotal);

        try {
            telaPrincipalAgendamento.database.adicionarAgendamento(novoAgendamento);
        } catch (IOException ex) {
            Logger.getLogger(telaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(telaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaPrincipalAgendamento.database.reescreverArquivoAgendamento();

        JOptionPane.showMessageDialog(this, "Agendamento finalizado com sucesso!");

        this.dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(telaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundColor;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCVV;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblIconCard;
    private javax.swing.JLabel lblNomeTitular;
    private javax.swing.JLabel lblNumCartao;
    private javax.swing.JLabel lblTitleCheckOut;
    private javax.swing.JLabel lblValorTotalPanel;
    private javax.swing.JLabel lblVencimento;
    private javax.swing.JLabel lblVencimento1;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JPanel pnlCartao;
    private javax.swing.JPanel pnlPix;
    private javax.swing.JPanel pnlValorTotal;
    private javax.swing.JSeparator separatorCartao;
    private javax.swing.JSeparator separatorCheckOut;
    private javax.swing.JTabbedPane tabbedPagamento;
    private javax.swing.JScrollPane tblCheckOut;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtCvv;
    private javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtEnderecoCobranca;
    private javax.swing.JFormattedTextField txtNomeTitular;
    private javax.swing.JFormattedTextField txtNumCartao;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
