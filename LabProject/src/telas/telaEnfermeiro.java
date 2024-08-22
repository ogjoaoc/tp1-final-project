package telas;

import classes.*;

public class telaEnfermeiro extends javax.swing.JFrame {
    
    Enfermeiro userLogado = (Enfermeiro) GerenciadorLogin.getInstance().getFuncionario();
    
    public telaEnfermeiro() {
        initComponents();
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtNomeAtendente = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        btnSair1 = new javax.swing.JButton();
        background = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        btnMinhaConta = new javax.swing.JButton();
        btnRealizarExame = new javax.swing.JButton();
        btnRealizarVacina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 197, 190));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomeAtendente.setBackground(new java.awt.Color(242, 242, 242));
        txtNomeAtendente.setText("Funcionário João João");
        txtNomeAtendente.setBorder(null);
        txtNomeAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAtendenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtNomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 785, -1));

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("LabSaúde ++");

        btnSair1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExit.png"))); // NOI18N
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 785, -1));

        background.setBackground(new java.awt.Color(248, 197, 190));

        lblInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInfo.setText("<html>Logado como: <i>Enfermeiro</i></html>");

        btnMinhaConta.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnMinhaConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconProfile.png"))); // NOI18N
        btnMinhaConta.setText("   Minha Conta     ");
        btnMinhaConta.setToolTipText("");
        btnMinhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinhaContaActionPerformed(evt);
            }
        });

        btnRealizarExame.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnRealizarExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExame.png"))); // NOI18N
        btnRealizarExame.setText("Realizar Exame");
        btnRealizarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarExameActionPerformed(evt);
            }
        });

        btnRealizarVacina.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnRealizarVacina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconVacina.png"))); // NOI18N
        btnRealizarVacina.setText("Realizar Vacina");
        btnRealizarVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVacinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnRealizarExame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizarVacina)
                        .addGap(30, 30, 30)))
                .addComponent(btnMinhaConta)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarExame, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRealizarVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinhaConta))
                .addGap(163, 163, 163)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarExameActionPerformed
        telaRelatorioExames telaRelatorioExames = new telaRelatorioExames();
        telaRelatorioExames.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRealizarExameActionPerformed

    private void btnRealizarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVacinaActionPerformed
        // TODO add your handling code here:
        telaAplicarVacina telaAplicarVacina = new telaAplicarVacina();
        telaAplicarVacina.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRealizarVacinaActionPerformed

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        telaLogin telaLogin = new telaLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void btnMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinhaContaActionPerformed
        telaContaFuncionario telaContaAtendente = new telaContaFuncionario();
        telaContaAtendente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMinhaContaActionPerformed

    private void txtNomeAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAtendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAtendenteActionPerformed

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
            java.util.logging.Logger.getLogger(telaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaEnfermeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaEnfermeiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnMinhaConta;
    private javax.swing.JButton btnRealizarExame;
    private javax.swing.JButton btnRealizarVacina;
    private javax.swing.JButton btnSair1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTextField txtNomeAtendente;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
