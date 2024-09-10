package telas;

import classes.Laudo;

public class templateLaudo extends javax.swing.JFrame {

    
    public templateLaudo() {
        
    }
    public templateLaudo(Laudo laudoAtual) {
        initComponents();
    
        txtNome.setText(laudoAtual.getPacienteAssociado().getNome()); // Nome do paciente
        txtGenero.setText(laudoAtual.getPacienteAssociado().getSexo()); // Gênero do paciente
        txtEnfermeiro.setText(laudoAtual.getEnfermeiroAssociado().getNome()); // Enfermeiro responsável
        txtData.setText(laudoAtual.getDataCriacao()); // Data de emissão do laudo
        txtNomeExame.setText(laudoAtual.getNomeExame()); // Se houver nome do exame específico
        txtResultado.setText(laudoAtual.getInfo()); // Resultado do exame ou informações adicionais

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblEnfermeiro = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtEnfermeiro = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        separator2 = new javax.swing.JSeparator();
        txtNomeExame = new javax.swing.JTextField();
        scrollPaneResultado = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        pnlBordaInferior = new javax.swing.JPanel();
        separator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("LabSaúde++");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitle)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblNome.setText("Nome do paciente:");

        lblGenero.setText("Gênero: ");

        lblData.setText("Data de emissão do laudo: ");

        lblEnfermeiro.setText("Enfermeiro responsável: ");

        txtNome.setBackground(new java.awt.Color(242, 242, 242));
        txtNome.setBorder(null);

        txtGenero.setBackground(new java.awt.Color(242, 242, 242));
        txtGenero.setBorder(null);

        txtEnfermeiro.setBackground(new java.awt.Color(242, 242, 242));
        txtEnfermeiro.setBorder(null);

        txtData.setBackground(new java.awt.Color(242, 242, 242));
        txtData.setBorder(null);
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtNomeExame.setBackground(new java.awt.Color(242, 242, 242));
        txtNomeExame.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txtNomeExame.setBorder(null);

        txtResultado.setBackground(new java.awt.Color(242, 242, 242));
        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtResultado.setLineWrap(true);
        txtResultado.setRows(5);
        txtResultado.setBorder(null);
        scrollPaneResultado.setViewportView(txtResultado);

        pnlBordaInferior.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlBordaInferiorLayout = new javax.swing.GroupLayout(pnlBordaInferior);
        pnlBordaInferior.setLayout(pnlBordaInferiorLayout);
        pnlBordaInferiorLayout.setHorizontalGroup(
            pnlBordaInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBordaInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator3)
                .addContainerGap())
        );
        pnlBordaInferiorLayout.setVerticalGroup(
            pnlBordaInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBordaInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(separator1)
            .addComponent(separator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEnfermeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnfermeiro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomeExame)
                    .addComponent(scrollPaneResultado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(pnlBordaInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnfermeiro)
                    .addComponent(txtEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBordaInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(templateLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(templateLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(templateLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(templateLaudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new templateLaudo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEnfermeiro;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBordaInferior;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrollPaneResultado;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator3;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEnfermeiro;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeExame;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
