package telas;

import classes.Paciente;
import database.BancoDeDados;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class telaEditarPaciente extends javax.swing.JFrame {

    BancoDeDados bancoDeDados = new BancoDeDados();
    Paciente pacienteAntigo;
    private telaPesquisarPaciente telaPesquisarPaciente;

    public telaEditarPaciente() {
        
        initComponents();
        this.setResizable(false);

    }
    
    public telaEditarPaciente(Paciente p, telaPesquisarPaciente telaPesquisarPaciente) {
        initComponents();
        this.setResizable(false);
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        this.setTitle("Atendente - Editar paciente");
        
        txtNome.setText(p.getNome());
        txtEmail.setText(p.getEmail());
        txtCPF.setText(p.getCpf());
        txtDataNascimento.setText(p.getDataNascimento());
        cmbTipoSanguineo.setSelectedItem(p.getTipoSanguineo());
        if ("Masculino".equals(p.getSexo()))
            rdbMasculino.setSelected(true);
        else
            rdbFeminino.setSelected(true);
        
        cmbConvenio.setSelectedItem(p.getConvenio());
        
        bancoDeDados.lerArquivo("paciente");
        
        this.pacienteAntigo = p;
        this.telaPesquisarPaciente = telaPesquisarPaciente;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupSexo = new javax.swing.ButtonGroup();
        groupPreferencial = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        rdbFeminino = new javax.swing.JRadioButton();
        rdbMasculino = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        cmbConvenio = new javax.swing.JComboBox<>();
        cmbTipoSanguineo = new javax.swing.JComboBox<>();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(248, 197, 190));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 34, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Sexo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("CPF:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("E-mail:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 82, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Data de nascimento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 178, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tipo sanguíneo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 226, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Convênio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setToolTipText("");
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 31, 431, -1));

        rdbFeminino.setBackground(new java.awt.Color(248, 197, 190));
        groupSexo.add(rdbFeminino);
        rdbFeminino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbFeminino.setText("Feminino");
        rdbFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFemininoActionPerformed(evt);
            }
        });
        jPanel1.add(rdbFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        rdbMasculino.setBackground(new java.awt.Color(248, 197, 190));
        groupSexo.add(rdbMasculino);
        rdbMasculino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbMasculino.setText("Masculino");
        rdbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMasculinoActionPerformed(evt);
            }
        });
        jPanel1.add(rdbMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setToolTipText("");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 77, 431, 32));

        cmbConvenio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbConvenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Convênio", "Unimed", "Amil", "Bradesco Saúde", "Porto Seguro" }));
        cmbConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConvenioActionPerformed(evt);
            }
        });
        jPanel1.add(cmbConvenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 180, -1));

        cmbTipoSanguineo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-" }));
        cmbTipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoSanguineoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbTipoSanguineo, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 223, 122, -1));

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 173, -1, 32));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 127, 197, -1));

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 126, 42));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconHash.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (txtNome.getText().equals("") ||
            txtCPF.getText().equals("") ||
            groupSexo.getSelection() == null ||
            txtDataNascimento.getText().equals("") ||
            txtEmail.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            String tipoSanguineo = (String) cmbTipoSanguineo.getSelectedItem();
            String convenio = (String) cmbConvenio.getSelectedItem();
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();
            String dataNascimento = txtDataNascimento.getText();
            String email = txtEmail.getText();
            String sexo;
            if (rdbMasculino.isSelected()) sexo = "Masculino";
            else sexo = "Feminino";

            Paciente pacienteNovo = new Paciente(nome, cpf, sexo, dataNascimento, email, tipoSanguineo, convenio);

            this.telaPesquisarPaciente.database.atualizarPaciente(pacienteAntigo, pacienteNovo);
            this.telaPesquisarPaciente.atualizarTabela();
            
            this.pacienteAntigo = pacienteNovo;
            JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(telaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaEditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaEditarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbConvenio;
    private javax.swing.JComboBox<String> cmbTipoSanguineo;
    private javax.swing.ButtonGroup groupPreferencial;
    private javax.swing.ButtonGroup groupSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdbFeminino;
    private javax.swing.JRadioButton rdbMasculino;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
