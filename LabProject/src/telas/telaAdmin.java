// Interface Gráfica: telaAdmin
// responsável pela conexão das principais funcões do usuário Administrador
// Cadastro de funcionários e pesquisa.
// Cadastro, edição, pesquisa e deleção de Vacinas e Exames.

package telas;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class telaAdmin extends javax.swing.JFrame {

//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.
    
    public telaAdmin() {
        
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        
//        Módulo para ao pressionar ESCAPE retornar a tela anterior

        this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "exitToLogin");
        this.getRootPane().getActionMap().put("exitToLogin", new AbstractAction() {
        @Override public void actionPerformed(ActionEvent e) { btnSair.doClick(); } });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnCadastroExame = new javax.swing.JButton();
        btnEstoqueVacinas = new javax.swing.JButton();
        btnPesquisarFunc = new javax.swing.JButton();
        btnCadastrarFunc = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin - Gerenciamento");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInfo.setText("<html>Logado como: <i>Administrador</i></html>");
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 390, 30));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTitle.setText("Gerenciamento");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        btnCadastroExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExameG.png"))); // NOI18N
        btnCadastroExame.setText("    Cadastrar Exame");
        btnCadastroExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroExameActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastroExame, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 280, 100));

        btnEstoqueVacinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconVacinaG.png"))); // NOI18N
        btnEstoqueVacinas.setText("Estoque de Vacinas");
        btnEstoqueVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueVacinasActionPerformed(evt);
            }
        });
        getContentPane().add(btnEstoqueVacinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 280, 100));

        btnPesquisarFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconSearchUser.png"))); // NOI18N
        btnPesquisarFunc.setText("Pesquisar Funcionários");
        btnPesquisarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarFuncActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisarFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 280, 100));

        btnCadastrarFunc.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnCadastrarFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconAddUser.png"))); // NOI18N
        btnCadastrarFunc.setText("Cadastrar Funcionário");
        btnCadastrarFunc.setToolTipText("");
        btnCadastrarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 280, 100));

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 120, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundCor.png"))); // NOI18N
        background.setText("Gerenciamento Financeiro");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncActionPerformed
        telaCadastroFuncionario telaCadastro = new telaCadastroFuncionario();
        telaCadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarFuncActionPerformed

    private void btnPesquisarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarFuncActionPerformed
        telaPesquisarFuncionario pesquisarFuncionario = new telaPesquisarFuncionario();
        pesquisarFuncionario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPesquisarFuncActionPerformed

    private void btnEstoqueVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueVacinasActionPerformed
        telaEstoqueVacina telaVacina = new telaEstoqueVacina();
        telaVacina.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEstoqueVacinasActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        telaLogin telaLogin = new telaLogin();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastroExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroExameActionPerformed
        telaCadastroExame telaCadastroExame = new telaCadastroExame();
        telaCadastroExame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastroExameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCadastrarFunc;
    private javax.swing.JButton btnCadastroExame;
    private javax.swing.JButton btnEstoqueVacinas;
    private javax.swing.JButton btnPesquisarFunc;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
