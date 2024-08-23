package telas;

import classes.*;
import interfaces.UserLogado;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class telaAtendente extends javax.swing.JFrame {
    
    Atendente userLogado = (Atendente) GerenciadorLogin.getInstance().getFuncionario();
    
    public telaAtendente() {
        initComponents();
        this.setResizable(false);
        lblNome.setText("Logado desde: " + formatarHoraLogin());
    }
    
    public String formatarHoraLogin() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        LocalDateTime dataHoraLogin = GerenciadorLogin.getInstance().getDataHoraLogin();
        return dataHoraLogin.format(formatter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        btnCadastrarPaciente1 = new javax.swing.JButton();
        btnCadastrarPaciente = new javax.swing.JButton();
        btnAgendarExame = new javax.swing.JButton();
        btnMinhaConta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAgendarVacina = new javax.swing.JButton();
        btnPagamentos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 197, 190));

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        background.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 260, 30));

        lblInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInfo.setText("<html>Logado como: <i>Atendente</i></html>");
        background.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 190, 30));

        btnCadastrarPaciente1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnCadastrarPaciente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconSearchUser.png"))); // NOI18N
        btnCadastrarPaciente1.setText("Pesquisar Paciente");
        btnCadastrarPaciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPaciente1ActionPerformed(evt);
            }
        });
        background.add(btnCadastrarPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 230, 80));

        btnCadastrarPaciente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnCadastrarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconAddUser.png"))); // NOI18N
        btnCadastrarPaciente.setText("Cadastrar Paciente");
        btnCadastrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPacienteActionPerformed(evt);
            }
        });
        background.add(btnCadastrarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 230, 80));

        btnAgendarExame.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnAgendarExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExame.png"))); // NOI18N
        btnAgendarExame.setText("Agendar Exame");
        btnAgendarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarExameActionPerformed(evt);
            }
        });
        background.add(btnAgendarExame, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 230, 80));

        btnMinhaConta.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnMinhaConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconProfile.png"))); // NOI18N
        btnMinhaConta.setText("   Minha Conta     ");
        btnMinhaConta.setToolTipText("");
        btnMinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinhaContaActionPerformed(evt);
            }
        });
        background.add(btnMinhaConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 230, 77));

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("LabSaúde ++");

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExit.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 785, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 785, -1));

        btnAgendarVacina.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnAgendarVacina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconVacina.png"))); // NOI18N
        btnAgendarVacina.setText("Agendar Vacina");
        btnAgendarVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarVacinaActionPerformed(evt);
            }
        });
        background.add(btnAgendarVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 230, 77));

        btnPagamentos.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnPagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconPagamento.png"))); // NOI18N
        btnPagamentos.setText("    Pagamentos      ");
        btnPagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentosActionPerformed(evt);
            }
        });
        background.add(btnPagamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 230, 77));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPacienteActionPerformed
        telaCadastroPaciente telaCadPaciente = new telaCadastroPaciente();
        telaCadPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarPacienteActionPerformed

    private void btnAgendarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarExameActionPerformed
        telaAgendarExame telaAgendarExame = new telaAgendarExame();
        telaAgendarExame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendarExameActionPerformed

    private void btnMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinhaContaActionPerformed
        telaContaFuncionario telaContaAtendente = new telaContaFuncionario();
        telaContaAtendente.setVisible(true);
    }//GEN-LAST:event_btnMinhaContaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        telaLogin telaLogin = new telaLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastrarPaciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPaciente1ActionPerformed
        telaPesquisarPaciente telaPesquisarPaciente = new telaPesquisarPaciente();
        telaPesquisarPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarPaciente1ActionPerformed

    private void btnAgendarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarVacinaActionPerformed

    private void btnPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagamentosActionPerformed

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
            java.util.logging.Logger.getLogger(telaAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAtendente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAgendarExame;
    private javax.swing.JButton btnAgendarVacina;
    private javax.swing.JButton btnCadastrarPaciente;
    private javax.swing.JButton btnCadastrarPaciente1;
    private javax.swing.JButton btnMinhaConta;
    private javax.swing.JButton btnPagamentos;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
