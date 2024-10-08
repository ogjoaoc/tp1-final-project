// Interface Gráfica: telaCadastroPaciente
// Tela auxiliar para cadastrar Pacientes na base de dados.
// Inserindo dados como: nome, email, CPF, data de nascimento, tipo Sanguíneo, sexo e convênio. 

package telas;

import classes.Paciente;
import database.BancoDeDados;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class telaCadastroPaciente extends javax.swing.JFrame {

//    Intanciando o banco de dados
    BancoDeDados bancoDeDados = new BancoDeDados();
    
//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.        
    
    public telaCadastroPaciente() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
//        Define o ícone e o título da janela
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        this.setTitle("Atendente - Cadastro de Pacientes");
        
        bancoDeDados.lerArquivo("paciente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupSexo = new javax.swing.ButtonGroup();
        backgroundColor = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblSangue = new javax.swing.JLabel();
        lblConvenio = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        rdbFeminino = new javax.swing.JRadioButton();
        rdbMasculino = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        cmbConvenio = new javax.swing.JComboBox<>();
        cmbTipoSanguineo = new javax.swing.JComboBox<>();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundColor.setBackground(new java.awt.Color(248, 197, 190));
        backgroundColor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNome.setText("Nome:");
        backgroundColor.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 34, -1, -1));

        lblSexo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSexo.setText("Sexo:");
        backgroundColor.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCpf.setText("CPF:");
        backgroundColor.add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 130, -1, -1));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("E-mail:");
        backgroundColor.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 82, -1, -1));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblData.setText("Data de nascimento:");
        backgroundColor.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 178, -1, -1));

        lblSangue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSangue.setText("Tipo sanguíneo:");
        backgroundColor.add(lblSangue, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 226, -1, -1));

        lblConvenio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblConvenio.setText("Convênio:");
        backgroundColor.add(lblConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setToolTipText("");
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        backgroundColor.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 31, 431, -1));

        rdbFeminino.setBackground(new java.awt.Color(248, 197, 190));
        groupSexo.add(rdbFeminino);
        rdbFeminino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbFeminino.setText("Feminino");
        rdbFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFemininoActionPerformed(evt);
            }
        });
        backgroundColor.add(rdbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        rdbMasculino.setBackground(new java.awt.Color(248, 197, 190));
        groupSexo.add(rdbMasculino);
        rdbMasculino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbMasculino.setText("Masculino");
        rdbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMasculinoActionPerformed(evt);
            }
        });
        backgroundColor.add(rdbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setToolTipText("");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        backgroundColor.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 77, 431, 32));

        cmbConvenio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbConvenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Convênio", "Unimed", "Amil", "Bradesco Saúde", "Porto Seguro" }));
        cmbConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConvenioActionPerformed(evt);
            }
        });
        backgroundColor.add(cmbConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 180, -1));

        cmbTipoSanguineo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-" }));
        cmbTipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoSanguineoActionPerformed(evt);
            }
        });
        backgroundColor.add(cmbTipoSanguineo, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 223, 122, -1));

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backgroundColor.add(txtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 173, 110, 32));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backgroundColor.add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 127, 197, -1));

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        backgroundColor.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 126, 42));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        backgroundColor.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 126, 42));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconHash.png"))); // NOI18N
        backgroundColor.add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void rdbFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFemininoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbFemininoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cmbTipoSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoSanguineoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoSanguineoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
//      Verifica se os campos obrigatórios estão preenchidos.
//      Se algum campo estiver vazio, exibe uma mensagem de aviso.
//      Caso contrário, cria um objeto Paciente com os dados fornecidos e o adiciona ao banco de dados.
//      Exibe uma mensagem de sucesso e redireciona para a tela principal do atendente.
        
        if (txtNome.getText().equals("") ||
            txtCPF.getText().equals("") ||
            groupSexo.getSelection() == null ||
            txtDataNascimento.getText().equals("") ||
            txtEmail.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            String tipoSanguineo = (String) cmbTipoSanguineo.getSelectedItem();
            //boolean preferencial = rdbSim.isSelected();
            String convenio = (String) cmbConvenio.getSelectedItem();
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();
            String dataNascimento = txtDataNascimento.getText();
            String email = txtEmail.getText();
            String sexo;
            if (rdbMasculino.isSelected()) sexo = "Masculino";
            else sexo = "Feminino";
            
            if (bancoDeDados.encontrarPaciente(cpf) != null){
                JOptionPane.showMessageDialog(null, "Já existe paciente com esse CPF!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtCPF.setText("");
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            try {
                LocalDate data = LocalDate.parse(dataNascimento, formatter);
                
                System.out.println(Period.between(data, LocalDate.now()).getYears() );
                
                if (Period.between(data, LocalDate.now()).getYears() > 120){
                    JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    txtDataNascimento.setText("");
                    return;
                }
            
            } catch (DateTimeParseException e) {
                // Se a conversão falhar, a data é inválida
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtDataNascimento.setText("");
                return;
            }

            Paciente paciente = new Paciente(tipoSanguineo, convenio, /*preferencial*/ nome, cpf, sexo, dataNascimento, email);
            
            bancoDeDados.adicionarPessoa(paciente);

            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            telaAtendente telaAtendente = new telaAtendente();
            telaAtendente.setVisible(true);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaAtendente telaAtendente = new telaAtendente();
        telaAtendente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void rdbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbMasculinoActionPerformed

    private void cmbConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConvenioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbConvenioActionPerformed

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
            java.util.logging.Logger.getLogger(telaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundColor;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbConvenio;
    private javax.swing.JComboBox<String> cmbTipoSanguineo;
    private javax.swing.ButtonGroup groupSexo;
    private javax.swing.JLabel lblConvenio;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSangue;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JRadioButton rdbFeminino;
    private javax.swing.JRadioButton rdbMasculino;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
