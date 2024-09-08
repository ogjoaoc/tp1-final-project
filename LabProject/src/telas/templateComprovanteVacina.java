package telas;

import classes.ComprovanteVacina;
import classes.Vacina;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class templateComprovanteVacina extends javax.swing.JFrame {

    ComprovanteVacina comprovanteVacinaAtual;
    
    public templateComprovanteVacina() {}
    
    public templateComprovanteVacina(Vacina vacina) {
        
        initComponents();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        txtNome.setText(vacina.getPacienteAssociado().getNome());
        txtData.setText(LocalDate.now().format(formatter));
        txtEnfermeiro.setText(vacina.getEnfermeiroAssociado().getNome());
        txtVacina.setText(vacina.getTipoVacina());
        txtDose.setText(vacina.getDose());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        separator1 = new javax.swing.JSeparator();
        separator2 = new javax.swing.JSeparator();
        lblEnfermeiro = new javax.swing.JLabel();
        txtEnfermeiro = new javax.swing.JTextField();
        lblVacina = new javax.swing.JLabel();
        txtDose = new javax.swing.JTextField();
        lblDose = new javax.swing.JLabel();
        txtVacina = new javax.swing.JTextField();
        lblicone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("Comprovante Vacina - LabSaúde++");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitle)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitle)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblNome.setText("Nome do Paciente: ");

        lblData.setText("Data de Emissão: ");

        txtNome.setBackground(new java.awt.Color(242, 242, 242));
        txtNome.setBorder(null);

        txtData.setBackground(new java.awt.Color(242, 242, 242));
        txtData.setBorder(null);
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEnfermeiro.setText("Enfermeiro responsável:");

        txtEnfermeiro.setBackground(new java.awt.Color(242, 242, 242));
        txtEnfermeiro.setBorder(null);

        lblVacina.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblVacina.setText("Vacina: ");

        txtDose.setBackground(new java.awt.Color(242, 242, 242));
        txtDose.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtDose.setBorder(null);

        lblDose.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblDose.setText("Dose:");

        txtVacina.setBackground(new java.awt.Color(242, 242, 242));
        txtVacina.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtVacina.setBorder(null);

        lblicone.setText("lblicone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(separator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addGap(13, 13, 13)
                        .addComponent(txtData))
                    .addComponent(separator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEnfermeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnfermeiro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVacina)
                            .addComponent(lblDose))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDose)
                            .addComponent(txtVacina, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblicone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnfermeiro)
                    .addComponent(txtEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVacina)
                    .addComponent(txtVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDose)
                    .addComponent(txtDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblicone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new templateComprovanteVacina().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDose;
    private javax.swing.JLabel lblEnfermeiro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVacina;
    private javax.swing.JLabel lblicone;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDose;
    private javax.swing.JTextField txtEnfermeiro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtVacina;
    // End of variables declaration//GEN-END:variables
}
