// Interface Gráfica: telaCadastroFuncionario
// Tela essencial para cadastro dos Atendentes e Enfermeiros na base de dados do programa.
// É possível especificar todos os atributos e características de um Funcionário.

package telas;
import classes.Atendente;
import classes.Enfermeiro;
import database.BancoDeDados;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public final class telaCadastroFuncionario extends javax.swing.JFrame {

//     Instanciando database    
    
    BancoDeDados bancoDeDados = new BancoDeDados();

//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.

    public telaCadastroFuncionario() {
        
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        
        bancoDeDados.lerArquivo("enfermeiro");
        bancoDeDados.lerArquivo("atendente");
        inicializarButtonGroup();
        
        //        Módulo para ao pressionar ESCAPE retornar a tela anterior

        this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "exitToLogin");
        this.getRootPane().getActionMap().put("exitToLogin", new AbstractAction() {
        @Override public void actionPerformed(ActionEvent e) { btnVoltar.doClick(); } });
        
    }
    
//    Método auxiliar para limpar campos de texto da tela.
    
    public void limparCampos() {
        txtCpf.setText("");
        txtNome.setText("");
        txtData.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        txtSalario.setText("");
    }

//    Método auxiliar para inicializar button group da seleção do sexo.
    
    public void inicializarButtonGroup() {
        btnGrupoSexo.add(rbtnMasculino);
        btnGrupoSexo.add(rbtnFeminino);
        rbtnFeminino.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblFuncao = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        rbtnFeminino = new javax.swing.JRadioButton();
        rbtnMasculino = new javax.swing.JRadioButton();
        txtSenha = new javax.swing.JPasswordField();
        cbFuncao = new javax.swing.JComboBox<>();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        lblImagem = new javax.swing.JLabel();
        backgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin - Cadastro de Funcionários");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.hoverBackground"));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNome.setText("Nome:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCpf.setText("CPF:");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblData.setText("Nascimento:");

        lblSexo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSexo.setText("Sexo:");

        lblFuncao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFuncao.setText("Função: ");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSenha.setText("Senha:");

        btnGrupoSexo.add(rbtnFeminino);
        rbtnFeminino.setText("Feminino");

        btnGrupoSexo.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");

        cbFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendente", "Enfermeiro" }));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        lblSalario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSalario.setText("Salário:");

        try {
            txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("$####.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenha)
                            .addComponent(lblFuncao)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblEmail)
                            .addComponent(lblSexo))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbFuncao, 0, 231, Short.MAX_VALUE)
                            .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(rbtnFeminino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnMasculino)
                                .addGap(25, 25, 25))
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(txtSenha))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCpf)
                        .addGap(23, 23, 23)
                        .addComponent(lblEmail)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnMasculino)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSexo)
                        .addComponent(rbtnFeminino)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(cbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 570));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconPerson.png"))); // NOI18N
        getContentPane().add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 230, 490));

        backgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundCor.png"))); // NOI18N
        getContentPane().add(backgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 830, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    
//    O botão "Salvar" é responsável pela identificação dos campos preenchidos, e definição do armazenamento e criação do objeto na base de dados.

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String funcao = (String)cbFuncao.getSelectedItem();
        String sexo = "";
        
        if (rbtnFeminino.isSelected()) {
            
            sexo = rbtnFeminino.getText();
            
        } else if (rbtnMasculino.isSelected()) {
            
            sexo = rbtnMasculino.getText();
            
        }
        
        if(txtCpf.getText().equals("") || txtData.getText().equals("") || txtEmail.getText().equals("") || txtNome.getText().equals("") ||
           txtSenha.getText().equals("") || sexo.equals("") || funcao.equals("") || txtSalario.equals("")) {
            
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        } else {
            
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String dataNascimento = txtData.getText();
            String email = txtEmail.getText();
            String senha = new String(txtSenha.getPassword());
            String salario = txtSalario.getText();
            
            if (bancoDeDados.encontrarFuncionario(cpf)){
                JOptionPane.showMessageDialog(null, "Já existe funcionário com esse CPF!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtCpf.setText("");
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            try {
                LocalDate data = LocalDate.parse(dataNascimento, formatter);
                
                System.out.println(Period.between(data, LocalDate.now()).getYears() );
                
                if (Period.between(data, LocalDate.now()).getYears() > 120){
                    JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    txtData.setText("");
                    return;
                }
            
            } catch (DateTimeParseException e) {
                // Se a conversão falhar, a data é inválida
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtData.setText("");
                return;
            }
            
            if(funcao.equals("Enfermeiro")) {
                
                boolean disponivel = true;
                Enfermeiro enfermeiro = new Enfermeiro(nome, cpf, sexo, dataNascimento, email, senha, salario, disponivel);
                bancoDeDados.adicionarPessoa(enfermeiro);

            } else if(funcao.equals("Atendente")) {
                
                Random random = new Random();
                int credencial = 1000 + random.nextInt(9000); 
                Atendente atendente = new Atendente(nome, cpf, sexo, dataNascimento, email, senha, salario, "Manhã", credencial, 0);
                bancoDeDados.adicionarPessoa(atendente);
                
            }
            
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            telaAdmin telaAdmin = new telaAdmin();
            telaAdmin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaAdmin telaAdmin = new telaAdmin();
        telaAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLogin;
    private javax.swing.ButtonGroup btnGrupoSexo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbFuncao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rbtnFeminino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
