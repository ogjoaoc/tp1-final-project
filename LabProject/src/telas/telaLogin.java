/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author joaoc
 */
public class telaLogin extends javax.swing.JFrame {

    /**
     * Creates new form telaLogin
     */
    public telaLogin() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage();
        setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrar = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        backgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 210, 60));

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblLogin.setText("Login: ");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        txtLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 320, 50));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 320, 50));

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setMaximumSize(new java.awt.Dimension(106, 36));
        btnSair.setMinimumSize(new java.awt.Dimension(106, 36));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 210, 60));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 570, 250));

        backgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundCor.png"))); // NOI18N
        getContentPane().add(backgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        if(login.equals("") || senha.equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos.", "Aviso",JOptionPane.INFORMATION_MESSAGE);
            txtLogin.setText(""); 
            txtSenha.setText("");
        } else if(login.equals("admin") && senha.equals("1234")) { 
            // abrir interface de ADM (cadastros e afins)
            telaAdmin telaAdmin = new telaAdmin();
            telaAdmin.setVisible(true);
            this.dispose(); 
        } else if (login.equals("enfermeiro") && senha.equals("1234")){
            // abrir interface do enfermeiro
            telaEnfermeiro telaEnfermeiro = new telaEnfermeiro();
            telaEnfermeiro.setVisible(true);
            this.dispose();
        } else if (login.equals("atendente") && senha.equals("1234")){
            // abrir interface do atendente
            telaAtendente telaAtendente = new telaAtendente();
            telaAtendente.setVisible(true);
            this.dispose();
        } 
        else {
            String tipoDeUsuario = "";
            // percorrer array de usuários (Pessoas?)
            /*
            for (Pessoa pessoa : pessoas) {
                if (pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    // Verifica o tipo da pessoa
                    if (pessoa instanceof Atendente) {
                        tipoDeUsuario = "atendente";
                    } else if (pessoa instanceof Enfermeiro) {
                        tipoDeUsuario = "enfermeiro";
                    }
                    break; 
                }
            }
            if(tipoDeUsuario.equals("")) {
                JOptionPane.showMessageDialog(null,"Usuário não encontrad.", "Aviso",JOptionPane.ERROR_MESSAGE);
            } else if(tipoDeUsuario.euquals("atendente") {
                // abrir interface atendente
            } else if (tipoDeUsuario.equals("enfermeiro" ){
                // abrir interface enfermeiro
            }

            */
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        telaInicial telaInicial = new telaInicial();
        telaInicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLogin;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
