package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;

public class telaAgendarVacina extends javax.swing.JFrame {

    private JPopupMenu popupVacina;
    private JPopupMenu popupPaciente;
    private JPopupMenu popupEnfermeiro;
    BancoDeDados database = new BancoDeDados(); 

    public telaAgendarVacina() {
        initComponents();
        setupAutoComplete();
        setupPlaceholders();
        
        database.lerArquivo("vacina");
        database.lerArquivo("paciente");
        database.lerArquivo("enfermeiro");
   
    }

    private void setupAutoComplete() {
        // Mock data for demonstration
        List<String> vacinaList = Arrays.asList("Vacina A", "Vacina B", "Vacina C");
        
        /*ArrayList<String> vacinaList = new ArrayList<String>();
        for(Vacina v : database.getVacinas()){
            vacinaList.add(v.getTipoVacina());
        }*/

        ArrayList<String> pacienteList = new ArrayList<String>();
        for(Paciente p : database.getPacientes()){
            pacienteList.add(p.getCpf());
        }
        
        ArrayList<String> enfermeiroList = new ArrayList<String>();
        for(Enfermeiro e: database.getEnfermeiros()){
            enfermeiroList.add(e.getCpf());
        }

        txtVacina.getDocument().addDocumentListener(new AutoCompleteListener(txtVacina, vacinaList));
        txtPaciente.getDocument().addDocumentListener(new AutoCompleteListener(txtPaciente, pacienteList));
        txtEnfermeiro.getDocument().addDocumentListener(new AutoCompleteListener(txtEnfermeiro, enfermeiroList));
    }

    private void setupPlaceholders() {
        txtVacina.setToolTipText("Digite o nome da vacina");
        txtPaciente.setToolTipText("Digite o nome do paciente");
        txtEnfermeiro.setToolTipText("Digite o nome do enfermeiro");
        txtPreco.setToolTipText("Digite o preço da vacina");
    }

    private class AutoCompleteListener implements DocumentListener {
        private JTextField textField;
        private List<String> suggestions;
        private JPopupMenu popupMenu;

        public AutoCompleteListener(JTextField textField, List<String> suggestions) {
            this.textField = textField;
            this.suggestions = suggestions;
            this.popupMenu = new JPopupMenu();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            showSuggestions();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            showSuggestions();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not needed
        }

        private void showSuggestions() {
            popupMenu.removeAll();
            String text = textField.getText();
            if (text.isEmpty()) {
                popupMenu.setVisible(false);
                return;
            }

            for (String suggestion : suggestions) {
                if (suggestion.toLowerCase().startsWith(text.toLowerCase())) {
                    JMenuItem item = new JMenuItem(suggestion);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textField.setText(suggestion);
                            popupMenu.setVisible(false);
                        }
                    });
                    popupMenu.add(item);
                }
            }

            if (popupMenu.getComponentCount() > 0) {
                popupMenu.show(textField, 0, textField.getHeight());
            } else {
                popupMenu.setVisible(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblVacina = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        lblEnfermeiro = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblDose = new javax.swing.JLabel();
        txtVacina = new javax.swing.JTextField();
        txtPaciente = new javax.swing.JTextField();
        txtEnfermeiro = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        cmbDose = new javax.swing.JComboBox<>();
        btnAgendar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        this.setLocationRelativeTo(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(248, 197, 190));

        lblVacina.setText("Vacina: ");
        lblVacina.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtVacina.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblPaciente.setText("Paciente: ");
        lblPaciente.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblEnfermeiro.setText("Enfermeiro: ");
        lblEnfermeiro.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtEnfermeiro.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblPreco.setText("Preço: ");
        lblPreco.setFont(new java.awt.Font("Segoe UI", 1, 18));
        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblDose.setText("Dose: ");
        lblDose.setFont(new java.awt.Font("Segoe UI", 1, 18));

        cmbDose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a dose", "1ª Dose", "2ª Dose", "Dose de Reforço" }));
        cmbDose.setFont(new java.awt.Font("Segoe UI", 0, 18));

        btnAgendar.setText("Agendar");
        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVacina)
                    .addComponent(lblPaciente)
                    .addComponent(lblEnfermeiro)
                    .addComponent(lblPreco)
                    .addComponent(lblDose))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVacina)
                    .addComponent(txtPaciente)
                    .addComponent(txtEnfermeiro)
                    .addComponent(txtPreco)
                    .addComponent(cmbDose, 0, 250, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnAgendar)
                .addGap(40, 40, 40)
                .addComponent(btnSair)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVacina)
                    .addComponent(txtVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnfermeiro)
                    .addComponent(txtEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDose)
                    .addComponent(cmbDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnSair))
                .addGap(30, 30, 30)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        telaAtendente telaAtendente = new telaAtendente();
        telaAtendente.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendarVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbDose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDose;
    private javax.swing.JLabel lblEnfermeiro;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblVacina;
    private javax.swing.JTextField txtEnfermeiro;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtVacina;
    // End of variables declaration  
}
