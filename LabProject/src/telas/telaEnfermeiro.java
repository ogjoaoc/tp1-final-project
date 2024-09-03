package telas;

import classes.*;
import interfaces.UserLogado;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class telaEnfermeiro extends javax.swing.JFrame {
    
    Enfermeiro userLogado = (Enfermeiro) GerenciadorLogin.getInstance().getFuncionario();
    
    public telaEnfermeiro() {
        initComponents();
        this.setResizable(false);
        lblInfo.setText("Logado desde: " + formatarHoraLogin());
    }
    
    public String formatarHoraLogin() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        LocalDateTime dataHoraLogin = GerenciadorLogin.getInstance().getDataHoraLogin();
        return dataHoraLogin.format(formatter);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        btnSair1 = new javax.swing.JButton();
        background = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        btnMinhaConta = new javax.swing.JButton();
        btnDemandas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 197, 190));
        setBounds(new java.awt.Rectangle(0, 25, 775, 520));
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(775, 520));
        setPreferredSize(new java.awt.Dimension(775, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(775, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnDemandas.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnDemandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconDemandas.png"))); // NOI18N
        btnDemandas.setText("   Demandas        ");
        btnDemandas.setToolTipText("");
        btnDemandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemandasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDemandas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnMinhaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMinhaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDemandas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        telaLogin telaLogin = new telaLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void btnMinhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinhaContaActionPerformed
        telaContaFuncionario telaContaAtendente = new telaContaFuncionario();
        telaContaAtendente.setVisible(true);
    }//GEN-LAST:event_btnMinhaContaActionPerformed

    private void btnDemandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemandasActionPerformed
        telaDemandas telaDemandas;
        try {
            telaDemandas = new telaDemandas();
            telaDemandas.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(telaEnfermeiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(telaEnfermeiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnDemandasActionPerformed

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
    private javax.swing.JButton btnDemandas;
    private javax.swing.JButton btnMinhaConta;
    private javax.swing.JButton btnSair1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
