package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class telaAgendamento extends javax.swing.JFrame {
    
    private JPopupMenu popupPaciente = new JPopupMenu();
    private BancoDeDados database = new BancoDeDados(); 
    private Timer debounceTimer;
    
    ArrayList<Exame> checkOutExames;
    ArrayList<Vacina> checkOutVacina;
    
    
    public telaAgendamento() {
        initComponents();
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setupAutoComplete();
        setupPlaceholders();
        
        database.lerArquivo("paciente");
        this.checkOutExames = new ArrayList<>();
        this.checkOutVacina = new ArrayList<>();
        atualizarTabelaCheckOut();
       
    }
    
    protected Paciente getPacienteSelecionado() {
        String nomePacienteSelecionado = txtPaciente.getText();
        ArrayList<Paciente> auxiliarPacientes = database.getPacientes();
        for(Paciente pac: auxiliarPacientes) {
            if(pac.getNome().equals(nomePacienteSelecionado)) {
                return pac;
            }
        }
        return null;
    }
    
    protected void atualizarTabelaCheckOut() {
        String[] colunas = {"Procedimento", "Tipo", "Enfermeiro", "Valor", "Data de Realização"};
        Object[][] dados = new Object[checkOutExames.size() + checkOutVacina.size()][5];

        int i = 0;
        for (Exame exame : checkOutExames) {
            dados[i][0] = "Exame";
            dados[i][1] = exame.getSubtipo(); 
            dados[i][2] = exame.getEnfermeiroAssociado().getNome(); 
            dados[i][3] = exame.getPreco(); 
            dados[i][4] = exame.getDataRealizacao(); 
            i++;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Vacina vacina : checkOutVacina) {
            dados[i][0] = "Vacina"; 
            dados[i][1] = vacina.getTipoVacina(); 
            dados[i][2] = vacina.getEnfermeiroAssociado().getNome(); 
            dados[i][3] = vacina.getPreco(); 
            dados[i][4] = sdf.format(new Date()); 
            i++;
        }

        javax.swing.table.DefaultTableModel modeloTabela = new javax.swing.table.DefaultTableModel(dados, colunas);
        jTable1.setModel(modeloTabela);
    }
    

    public ArrayList<Exame> getCheckOutExames() {
        return checkOutExames;
    }

    public void setCheckOutExames(ArrayList<Exame> checkOutExames) {
        this.checkOutExames = checkOutExames;
    }

    public ArrayList<Vacina> getCheckOutVacina() {
        return checkOutVacina;
    }

    public void setCheckOutVacina(ArrayList<Vacina> checkOutVacina) {
        this.checkOutVacina = checkOutVacina;
    }
    
    
    
    private void setupAutoComplete() {
        txtPaciente.getDocument().addDocumentListener(new telaAgendamento.AutoCompleteListener(txtPaciente));
    }
    
    private class AutoCompleteListener implements DocumentListener {
        private JTextField textField;
        private String tipo;  
        private JPopupMenu popupMenu;
        private boolean updatingText = false;

        public AutoCompleteListener(JTextField textField) {
            this.textField = textField;
            this.popupMenu = popupPaciente;
        }
        
        @Override
        public void insertUpdate(DocumentEvent e) {
            if (!updatingText) {
                debounceBusca();
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (!updatingText) {
                debounceBusca();
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        private void debounceBusca() {
            if (debounceTimer != null) {
                debounceTimer.stop();
            }

            debounceTimer = new Timer(300, e -> showSuggestions());
            debounceTimer.setRepeats(false);
            debounceTimer.start();
        }

        private void showSuggestions() {
            
            popupMenu.removeAll();
            String textoBusca = textField.getText().toLowerCase();

            if (textoBusca.isEmpty()) {
                popupMenu.setVisible(false);
                return;
            }

            ArrayList<String> suggestions = buscarSugestoes(textoBusca);

            for (String suggestion : suggestions) {
                JMenuItem item = new JMenuItem(suggestion);
                item.addActionListener(e -> {
                    updatingText = true;
                    textField.setText(suggestion);
                    popupMenu.setVisible(false);
                    textField.requestFocusInWindow();
                    updatingText = false;
                
                });
                popupMenu.add(item);
            }

            if (popupMenu.getComponentCount() > 0) {
                popupMenu.show(textField, 0, textField.getHeight());
            } else {
                popupMenu.setVisible(false);
            }
          
        }

        private ArrayList<String> buscarSugestoes(String textoBusca) {
            ArrayList<String> resultados = new ArrayList<>();
            resultados = new ArrayList<>(database.getPacientes().stream()
                        .map(Paciente::getNome)
                        .filter(nome -> nome.toLowerCase().contains(textoBusca))
                        .toList());
            return resultados;
        }
    }

    private void setupPlaceholders() {
        configurarPlaceholder(txtPaciente, "Digite o nome do paciente...");     
    }

    private void configurarPlaceholder(JTextField textField, String placeholderText) {
        textField.setText(placeholderText);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholderText);
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jComboBox1 = new javax.swing.JComboBox<>();
        background = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        lblSelecionarEnfermeiro = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        lblSelecionarPaciente = new javax.swing.JLabel();
        btnAvancar = new javax.swing.JButton();
        tblCheckOut = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdicionarExame = new javax.swing.JButton();
        btnAdicionarVacina = new javax.swing.JButton();
        lblSelecionarPaciente1 = new javax.swing.JLabel();
        iconSexoPaciente2 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("Agendamento - Exames e Vacinas");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(txtTitle)
                .addContainerGap(477, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(18, 18, 18))
        );

        background.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 70));

        lblSelecionarEnfermeiro.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblSelecionarEnfermeiro.setText("Check-out:");
        background.add(lblSelecionarEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, 40));

        txtPaciente.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        background.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, 40));

        lblSelecionarPaciente.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblSelecionarPaciente.setText("Adicionar:");
        background.add(lblSelecionarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 210, 40));

        btnAvancar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });
        background.add(btnAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 180, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Procedimento", "Tipo", "Enfermeiro", "Valor"
            }
        ));
        tblCheckOut.setViewportView(jTable1);

        background.add(tblCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 640, 220));

        btnAdicionarExame.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnAdicionarExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconExameP.png"))); // NOI18N
        btnAdicionarExame.setText("Exame");
        btnAdicionarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarExameActionPerformed(evt);
            }
        });
        background.add(btnAdicionarExame, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 130, 40));

        btnAdicionarVacina.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnAdicionarVacina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconVacinaP.png"))); // NOI18N
        btnAdicionarVacina.setText("Vacina");
        btnAdicionarVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarVacinaActionPerformed(evt);
            }
        });
        background.add(btnAdicionarVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 130, 40));

        lblSelecionarPaciente1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblSelecionarPaciente1.setText("Selecionar paciente:");
        background.add(lblSelecionarPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 40));

        iconSexoPaciente2.setText("IconSexo");
        background.add(iconSexoPaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, 20));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        background.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 180, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        // TODO add your handling code here:
        telaPagamento telaPag = new telaPagamento(this);
        telaPag.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaAtendente telaAtendente = new telaAtendente();
        telaAtendente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAdicionarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarVacinaActionPerformed
        telaAgendarVacina telaAgendarVacina = new telaAgendarVacina(this);
        telaAgendarVacina.setVisible(true);
    }//GEN-LAST:event_btnAdicionarVacinaActionPerformed

    private void btnAdicionarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarExameActionPerformed
        telaAgendarExame telaAgendarExame = new telaAgendarExame(this);
        telaAgendarExame.setVisible(true);
    }//GEN-LAST:event_btnAdicionarExameActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAdicionarExame;
    private javax.swing.JButton btnAdicionarVacina;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel iconSexoPaciente2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblSelecionarEnfermeiro;
    private javax.swing.JLabel lblSelecionarPaciente;
    private javax.swing.JLabel lblSelecionarPaciente1;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JScrollPane tblCheckOut;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
