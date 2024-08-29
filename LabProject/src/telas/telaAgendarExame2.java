package telas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author joaoc
 */
public class telaAgendarExame2 extends javax.swing.JFrame {

    /**
     * Creates new form telaAgendarExame2
     */
    public telaAgendarExame2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        background = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        lblSelecionarEnfermeiro = new javax.swing.JLabel();
        cbTipoExameVacina = new javax.swing.JComboBox<>();
        lblTipoExameVacina = new javax.swing.JLabel();
        txtEnfermeiro = new javax.swing.JTextField();
        iconSexoPaciente = new javax.swing.JLabel();
        iconTipoExameVacina = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        lblSelecionarPaciente = new javax.swing.JLabel();
        btnAvancar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMarcadoPara1 = new javax.swing.JLabel();
        txtDataAgendamento = new javax.swing.JTextField();
        txtHorarioAgendamento = new javax.swing.JTextField();
        lblHorário = new javax.swing.JLabel();
        lblAgendadoEm1 = new javax.swing.JLabel();
        txtDataAgendamento1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("Agendamento - Exames");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(txtTitle)
                .addContainerGap(410, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtTitle)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        background.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 70));

        lblSelecionarEnfermeiro.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblSelecionarEnfermeiro.setText("Selecionar enfermeiro:");
        background.add(lblSelecionarEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 210, 40));

        cbTipoExameVacina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoExameVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoExameVacinaActionPerformed(evt);
            }
        });
        background.add(cbTipoExameVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 150, 30));

        lblTipoExameVacina.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblTipoExameVacina.setText("Tipo:");
        background.add(lblTipoExameVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 100, 40));

        txtEnfermeiro.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtEnfermeiro.setText("Jorginho Vasquez");
        background.add(txtEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 210, 30));

        iconSexoPaciente.setText("IconSexo");
        background.add(iconSexoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        iconTipoExameVacina.setText("IconOption");
        background.add(iconTipoExameVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        txtPaciente.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtPaciente.setText("João Carlos Gonçalves");
        background.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 210, 30));

        lblSelecionarPaciente.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblSelecionarPaciente.setText("Selecionar paciente:");
        background.add(lblSelecionarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 210, 40));

        btnAvancar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAvancar.setText("Avançar");
        background.add(btnAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 170, 60));

        lblMarcadoPara1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblMarcadoPara1.setText("Agendado para:");

        txtDataAgendamento.setText("data de agendamento");

        txtHorarioAgendamento.setText("horário agendamento");

        lblHorário.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblHorário.setText("Horário:");

        lblAgendadoEm1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblAgendadoEm1.setText("Marcado em: ");

        txtDataAgendamento1.setText("data de agendamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataAgendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHorário, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorarioAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarcadoPara1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgendadoEm1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAgendadoEm1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataAgendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMarcadoPara1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(txtDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHorário, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorarioAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 270, 310));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoExameVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoExameVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoExameVacinaActionPerformed

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
            java.util.logging.Logger.getLogger(telaAgendarExame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendarExame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JComboBox<String> cbTipoExameVacina;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel iconSexoPaciente;
    private javax.swing.JLabel iconTipoExameVacina;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgendadoEm1;
    private javax.swing.JLabel lblHorário;
    private javax.swing.JLabel lblMarcadoPara1;
    private javax.swing.JLabel lblSelecionarEnfermeiro;
    private javax.swing.JLabel lblSelecionarPaciente;
    private javax.swing.JLabel lblTipoExameVacina;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtDataAgendamento;
    private javax.swing.JTextField txtDataAgendamento1;
    private javax.swing.JTextField txtEnfermeiro;
    private javax.swing.JTextField txtHorarioAgendamento;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
