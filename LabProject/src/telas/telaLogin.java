package telas;

import classes.Enfermeiro;
import classes.Funcionario;
import classes.Pessoa;
import database.BancoDeDados;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class telaLogin extends javax.swing.JFrame {

    BancoDeDados database = new BancoDeDados();
    
    public telaLogin() {
        
        initComponents();
        this.setResizable(false);
        Image icon = new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage();
        setIconImage(icon);
        database.lerArquivo("enfermeiro");
        database.lerArquivo("atendente");
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
        
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    txtSenha.requestFocus(); 
                }
            }
        });

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    btnEntrar.doClick(); 
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        imgIconUser = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        backgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Senha: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setMaximumSize(new java.awt.Dimension(106, 36));
        btnSair.setMinimumSize(new java.awt.Dimension(106, 36));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        imgIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconUserL.png"))); // NOI18N

        txtLogin.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(imgIconUser)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(txtLogin))
                .addGap(19, 19, 19))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(imgIconUser)
                .addGap(39, 39, 39)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 420, 430));

        backgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundCor.png"))); // NOI18N
        getContentPane().add(backgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (login.equals("") || senha.equals("")) {
            
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,
                "Todos os campos devem ser preenchidos.", "Aviso",
                JOptionPane.INFORMATION_MESSAGE);
            txtLogin.setText("");
            txtSenha.setText("");

        } else if (login.equals("admin") && senha.equals("1234")) {
            
            // abrir interface de ADM (cadastros e afins)
            telaAdmin telaAdmin = new telaAdmin();
            telaAdmin.setVisible(true);
            this.dispose();
            
        } else if (login.equals("enfermeiro") && senha.equals("1234")) {
            
            // abrir interface do enfermeiro
            telaEnfermeiro telaEnfermeiro = new telaEnfermeiro();
            telaEnfermeiro.setVisible(true);
            this.dispose();
            
        } else if (login.equals("atendente") && senha.equals("1234")) {
            
            // abrir interface do atendente
            telaAtendente telaAtendente = new telaAtendente();
            telaAtendente.setVisible(true);
            this.dispose();
            
        } else {
            
            String tipoDeUsuario = "";
            for (Funcionario funcionario : database.getFuncionarios()) {
                if (funcionario.getCpf().equals(login) && funcionario.getSenha().equals(senha)) {
                    if(funcionario instanceof Enfermeiro) {
                        tipoDeUsuario = "enfermeiro";
                    } else {
                        tipoDeUsuario = "atendente";
                    }
                }
            }

            if(tipoDeUsuario.equals("")) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"Usuário não encontrado.", "Aviso",JOptionPane.ERROR_MESSAGE); 
            } else if(tipoDeUsuario.equals("atendente")) {
                
                // abrir interface atendente
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"Login realizado com sucesso.", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                telaAtendente telaAtendente = new telaAtendente();
                telaAtendente.setVisible(true);
                this.dispose();
                
            } else if (tipoDeUsuario.equals("enfermeiro")) {
                // abrir interface enfermeiro
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"Login realizado com sucesso.", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                telaEnfermeiro telaEnfermeiro = new telaEnfermeiro();
                telaEnfermeiro.setVisible(true);
                this.dispose();
                
            }

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
    private javax.swing.JLabel imgIconUser;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
