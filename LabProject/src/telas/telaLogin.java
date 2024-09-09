// Interface Gráfica: telaLogin
// Tela que redireciona os usuários após o login de acordo com suas especificações.
// Usuário administrador possuí login padrão.
// Cpf "000.000.000-00" e Senha 1234 ou, utilizando o atalho Ctrl + P.
// A lógica da tela é procurar a partir da senha digitada algum usuário na base de dados. Se existir um usuário com aquela senha, é retornado o tipo de usuário
// e o objeto do mesmo para armazenamento no Gerenciador de Login.

package telas;

import classes.*;
import database.BancoDeDados;
import interfaces.UserLogado;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class telaLogin extends javax.swing.JFrame {

//    Instanciando base de dados
    
    BancoDeDados database = new BancoDeDados();

//    Construtor
    
    public telaLogin() {
        
        initComponents();
        this.setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        
        database.lerArquivo("enfermeiro");
        database.lerArquivo("atendente");
        
//        Método auxiliar para garantir atalho na digitação dos campos

        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
        
//        O foco para os campos altera no momento que o usuário termina a digitação e pressiona enter.
            
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
        
//        Módulo para atalho Ctrl + P ocasionar no login como Administrador.

        this.getRootPane().getInputMap().put(KeyStroke.getKeyStroke("ctrl P"), "loginAdmin");
        this.getRootPane().getActionMap().put("loginAdmin", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                new telaAdmin().setVisible(true);
                dispose();  
            }
        });
        
//         Módulo para atalho ESC ocasionar o retorno à tela de login (pressionar o botão Sair).

        this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "exitToLogin");
        this.getRootPane().getActionMap().put("exitToLogin", new AbstractAction() {
        @Override public void actionPerformed(ActionEvent e) { btnSair.doClick(); } });
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        imgIconUser = new javax.swing.JLabel();
        txtLogin = new javax.swing.JFormattedTextField();
        backgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSenha.setBackground(new java.awt.Color(242, 242, 242));
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

        txtLogin.setBackground(new java.awt.Color(242, 242, 242));
        txtLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Login:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        try {
            txtLogin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

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
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtLogin)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(imgIconUser)
                .addGap(36, 36, 36)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 420, 430));

        backgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundCor.png"))); // NOI18N
        getContentPane().add(backgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        
//        O método responsável pelo botão "Entrar" garante o redirecionamento correto do usuário, e a confirmação do Login, ou retificação do preenchimento dos campos.

        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (login.equals("") || senha.equals("")) {
            
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtLogin.setText("");
            txtSenha.setText("");

        } else if (login.equals("000.000.000-00") && senha.equals("1234")) {
            
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null,"Login realizado com sucesso.", "Mensagem",JOptionPane.INFORMATION_MESSAGE);
            telaAdmin telaAdmin = new telaAdmin();
            telaAdmin.setVisible(true);
            this.dispose();
            
        } else {
            
            String tipoDeUsuario = "";
            UserLogado userLogado = null;
            for (Funcionario funcionario : database.getFuncionarios()) {
                if (funcionario.getCpf().equals(login) && funcionario.getSenha().equals(senha)) {
                    if(funcionario instanceof Enfermeiro) {
                        tipoDeUsuario = "enfermeiro";
                    } else {
                        tipoDeUsuario = "atendente";
                    }
                    userLogado = funcionario;
                    break;
                }
            }
            
            // Seta usuário logado no Gerenciador de Login.
            
            GerenciadorLogin.getInstance().setUserLogado(userLogado);
            
            if(tipoDeUsuario.equals("")) {
                
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"Usuário não encontrado.", "Aviso",JOptionPane.ERROR_MESSAGE); 
            
            } else if(tipoDeUsuario.equals("atendente")) {
                
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"Login realizado com sucesso.", "Mensagem",JOptionPane.INFORMATION_MESSAGE);
                telaAtendente telaAtendente = new telaAtendente();
                telaAtendente.setVisible(true);
                this.dispose();
                
            } else if (tipoDeUsuario.equals("enfermeiro")) {
                
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"Login realizado com sucesso.", "Mensagem",JOptionPane.INFORMATION_MESSAGE);
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

    public static void main(String args[]) {
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
    private javax.swing.JFormattedTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
