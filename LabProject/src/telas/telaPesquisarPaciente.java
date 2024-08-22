/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Funcionario;
import classes.Paciente;
import database.BancoDeDados;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author analuisa
 */
public class telaPesquisarPaciente extends javax.swing.JFrame {

    BancoDeDados database = new BancoDeDados(); 
    private final String placeholderText = "Pesquisar por CPF ou nome...";
    
    public telaPesquisarPaciente() {
        initComponents();
        this.setResizable(false);
        
        addSearchListener();
        
        database.lerArquivo("paciente");
        
        carregarTabela(database.getPacientes());
        
        configurarPlaceholder();
    }
    
    private Timer debounceTimer;

    private void addSearchListener() {
        txtBusca.getDocument().addDocumentListener(new DocumentListener() {
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
        String textoBusca = txtBusca.getText().toLowerCase();
        
        // Verificar se o campo de busca está vazio
        if (textoBusca.isEmpty() || textoBusca.equals(placeholderText.toLowerCase())) {
            carregarTabela(database.getPacientes());
        } else {
            // Filtrar os funcionários com base no nome ou CPF
            List<Paciente> pacientesFiltrados = database.getPacientes().stream()
                .filter(f -> f.getNome().toLowerCase().contains(textoBusca) || f.getCpf().contains(textoBusca))
                .toList();

            // Criar um novo ArrayList com os elementos filtrados
            ArrayList<Paciente> pacientesArrayList = new ArrayList<>(pacientesFiltrados);

            // Atualizar a tabela
            carregarTabela(pacientesArrayList);
        }
    }
    
    private void carregarTabela(ArrayList<Paciente> pacientes) {
        DefaultTableModel model = (DefaultTableModel) tblPacientes.getModel();
        model.setRowCount(0);  // Limpar a tabela

        for (Paciente p : pacientes) {
            model.addRow(new Object[]{p.getNome(), p.getCpf(), p.getSexo(), p.getEmail()});
        }
    }
    
    private void configurarPlaceholder() {
        txtBusca.setText(placeholderText);
        txtBusca.setForeground(Color.GRAY);

        txtBusca.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtBusca.getText().equals(placeholderText)) {
                    txtBusca.setText("");
                    txtBusca.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtBusca.getText().isEmpty()) {
                    txtBusca.setForeground(Color.GRAY);
                    txtBusca.setText(placeholderText);
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBkGround = new javax.swing.JPanel();
        pnlPesquisa = new javax.swing.JPanel();
        txtBusca = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        btnVoltarResult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(931, 584));

        pnlBkGround.setBackground(new java.awt.Color(248, 197, 190));

        pnlPesquisa.setBackground(new java.awt.Color(248, 197, 190));

        txtBusca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPesquisaLayout = new javax.swing.GroupLayout(pnlPesquisa);
        pnlPesquisa.setLayout(pnlPesquisaLayout);
        pnlPesquisaLayout.setHorizontalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        pnlPesquisaLayout.setVerticalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome ", "CPF", "Sexo", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.setSelectionBackground(new java.awt.Color(248, 197, 190));
        jScrollPane1.setViewportView(tblPacientes);
        if (tblPacientes.getColumnModel().getColumnCount() > 0) {
            tblPacientes.getColumnModel().getColumn(0).setResizable(false);
            tblPacientes.getColumnModel().getColumn(1).setResizable(false);
            tblPacientes.getColumnModel().getColumn(2).setResizable(false);
            tblPacientes.getColumnModel().getColumn(3).setResizable(false);
        }

        btnVoltarResult.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltarResult.setText("Voltar");
        btnVoltarResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBkGroundLayout = new javax.swing.GroupLayout(pnlBkGround);
        pnlBkGround.setLayout(pnlBkGroundLayout);
        pnlBkGroundLayout.setHorizontalGroup(
            pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltarResult, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
        );
        pnlBkGroundLayout.setVerticalGroup(
            pnlBkGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltarResult, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarResultActionPerformed
        telaAtendente atendente = new telaAtendente();
        atendente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarResultActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

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
            java.util.logging.Logger.getLogger(telaPesquisarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPesquisarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new telaPesquisarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltarResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBkGround;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JFormattedTextField txtBusca;
    // End of variables declaration//GEN-END:variables

}
