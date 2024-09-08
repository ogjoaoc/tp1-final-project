package telas;

import classes.*;
import database.BancoDeDados;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class telaAgendarExame extends javax.swing.JFrame {

    private BancoDeDados database = new BancoDeDados();
    private ButtonGroup buttonGroup;
    private ArrayList<Exame> exames; 
    private ArrayList<Enfermeiro> enfermeiros; 
    private telaAgendamento telaAgendamentoRef;

    public telaAgendarExame() {}
    
    public telaAgendarExame(telaAgendamento ref) {
        initComponents();
        configurarBotoes();
        configurarComboBoxExame(); 
        setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        telaAgendamentoRef = ref;
    }

    private void configurarBotoes() {
        
//         Agrupando os radio buttons

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

//         Adicionar listener para ativar/desativar a combobox com base no radio button selecionado
        
ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                txtPreco.setText("");
                if (jRadioButton1.isSelected()) {
                    cbTipoExame.setEnabled(true);
                    carregarExames(); 
                } else if (jRadioButton2.isSelected()) {
                    cbTipoExame.setEnabled(true);
                    carregarExames(); 
                }
                cbEnfermeiro.setEnabled(true);
                carregarEnfermeiros();
            }
        };

        jRadioButton1.addActionListener(actionListener);
        jRadioButton2.addActionListener(actionListener);    

        cbTipoExame.setEnabled(false);  
        cbEnfermeiro.setEnabled(false); 
    }

    private void carregarExames() {
        database.lerArquivo("exame");
        exames = database.getExames();
        cbTipoExame.removeAllItems();

        if (jRadioButton1.isSelected()) {
            for (Exame exame : exames) {
                if (exame instanceof Sorologico) {
                    cbTipoExame.addItem(((Sorologico) exame).getPatologia());
                }
            }
        } else if (jRadioButton2.isSelected()) {
            for (Exame exame : exames) {
                if (exame instanceof Hemograma) {
                    cbTipoExame.addItem(((Hemograma) exame).getAlvo());
                }
            }
        }

        AutoCompleteDecorator.decorate(cbTipoExame);
    }

    private void carregarEnfermeiros() {
        database.lerArquivo("enfermeiro");
        enfermeiros = database.getEnfermeiros(); 
        cbEnfermeiro.removeAllItems();

        for (Enfermeiro enfermeiro : enfermeiros) {
            cbEnfermeiro.addItem(enfermeiro.getNome());
        }

        AutoCompleteDecorator.decorate(cbEnfermeiro);
    }

    private void configurarComboBoxExame() {
        cbTipoExame.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    atualizarPreco();
                }
            }
        });
    }

    private void atualizarPreco() {
        String selectedExame = (String) cbTipoExame.getSelectedItem();
        if (selectedExame != null) {
            for (Exame exame : exames) {
                String preco = "";
                if (jRadioButton1.isSelected() && exame instanceof Sorologico) {
                    if (((Sorologico) exame).getPatologia().equals(selectedExame)) {
                        preco = String.valueOf(((Sorologico) exame).getPreco());
                    }
                } else if (jRadioButton2.isSelected() && exame instanceof Hemograma) {
                    if (((Hemograma) exame).getAlvo().equals(selectedExame)) {
                        preco = String.valueOf(((Hemograma) exame).getPreco());
                    }
                }
                if (!preco.isEmpty()) {
                    txtPreco.setText(preco);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        lblSelecionarPaciente1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lblSelecionarPaciente2 = new javax.swing.JLabel();
        cbEnfermeiro = new javax.swing.JComboBox<>();
        lblSelecionarPaciente3 = new javax.swing.JLabel();
        cbTipoExame = new javax.swing.JComboBox<>();
        lblSelecionarPaciente4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnAgendar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("Exame");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(txtTitle)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(18, 18, 18))
        );

        background.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 60));

        lblSelecionarPaciente1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente1.setText("Preço:");
        background.add(lblSelecionarPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 40));

        jRadioButton1.setBackground(new java.awt.Color(248, 197, 190));
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Sorológico");
        background.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(248, 197, 190));
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Hemograma");
        background.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        lblSelecionarPaciente2.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente2.setText("Exame:");
        background.add(lblSelecionarPaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 120, 40));

        cbEnfermeiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome do enfermeiro...", " " }));
        background.add(cbEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 190, 40));

        lblSelecionarPaciente3.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente3.setText("Tipo:");
        background.add(lblSelecionarPaciente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 120, 40));

        cbTipoExame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo...", " " }));
        background.add(cbTipoExame, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 190, 40));

        lblSelecionarPaciente4.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente4.setText("Enfermeiro:");
        background.add(lblSelecionarPaciente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, 40));
        background.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 190, 40));

        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        background.add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 140, 40));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        background.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        if(cbTipoExame.getSelectedItem().equals("Selecione um tipo...") || cbEnfermeiro.getSelectedItem().equals("Nome do enfermeiro...") ||
           txtPreco.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos!", "Aviso",JOptionPane.WARNING_MESSAGE);
        } else{
        
            String nomeEnfermeiro = (String) cbEnfermeiro.getSelectedItem();
            String tipoExame = (String) cbTipoExame.getSelectedItem();
            String precoExame = txtPreco.getText();

            // Encontrar o enfermeiro selecionado no banco de dados
            Enfermeiro enfermeiroSelecionado = null;
            for (Enfermeiro enf : enfermeiros) {
                if (enf.getNome().equals(nomeEnfermeiro)) {
                    enfermeiroSelecionado = enf;
                    break;
                }
            }

            Exame novoExame = null;
            if (jRadioButton1.isSelected()) { // Sorológico
                novoExame = new Sorologico(tipoExame, "01/09/2023", telaAgendamentoRef.getPacienteSelecionado(), enfermeiroSelecionado, parseDouble(precoExame),false); // Data fixa por enquanto
            } else if (jRadioButton2.isSelected()) { // Hemograma
                novoExame = new Hemograma(tipoExame, "01/09/2023" , telaAgendamentoRef.getPacienteSelecionado(), enfermeiroSelecionado, parseDouble(precoExame),false);
            }

            // Adicionar o exame à lista na tela principal
            telaAgendamentoRef.getCheckOutExames().add(novoExame);
            telaAgendamentoRef.verificarCarrinho();
            telaAgendamentoRef.atualizarTabelaCheckOut();
            this.dispose();
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

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
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendarExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbEnfermeiro;
    private javax.swing.JComboBox<String> cbTipoExame;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel lblSelecionarPaciente1;
    private javax.swing.JLabel lblSelecionarPaciente2;
    private javax.swing.JLabel lblSelecionarPaciente3;
    private javax.swing.JLabel lblSelecionarPaciente4;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
