// Interface Gráfica: telaAgendarExame
// Responsável pelo preenchimento de dados para o agendamento de exames.
// Podendo definir: o tipo de exame, o exame e o enfermeiro, para adicionar ao agendamento.

package telas;

import classes.*;
import database.BancoDeDados;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class telaAgendarExame extends javax.swing.JFrame {

//    Instanciando banco de dados e auxiliares.
    
    private BancoDeDados database = new BancoDeDados();
    private ButtonGroup buttonGroup;
    private telaAgendamento telaAgendamentoRef;
    
//    Declaração de EDA's auxiliares para armazenar os exames e enfermeiros.
    
    private ArrayList<Exame> exames; 
    private ArrayList<Enfermeiro> enfermeiros; 
    
    public telaAgendarExame() {}
    
//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.

    public telaAgendarExame(telaAgendamento ref) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    //  Configura os botões da interface e o comboBox de exames
        configurarBotoes();
        configurarComboBoxExame(); 
         
        telaAgendamentoRef = ref; // Atribui a referência da tela de agendamento principal
    }

    private void configurarBotoes() {
        
//         Agrupando os radio buttons

        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtnSorologico);
        buttonGroup.add(rbtnHemograma);

//         Adicionar listener para ativar/desativar a combobox com base no radio button selecionado
        
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                txtPreco.setText("");
                if (rbtnSorologico.isSelected()) {
                    cbTipoExame.setEnabled(true);
                    carregarExames(); 
                } else if (rbtnHemograma.isSelected()) {
                    cbTipoExame.setEnabled(true);
                    carregarExames(); 
                }
                cbEnfermeiro.setEnabled(true);
                carregarEnfermeiros();
            }
        };

        rbtnSorologico.addActionListener(actionListener);
        rbtnHemograma.addActionListener(actionListener);    

        cbTipoExame.setEnabled(false);  
        cbEnfermeiro.setEnabled(false); 
    }

    
//  Carrega a lista de exames do banco de dados e inclui na comboBox
//  Dependendo do tipo de exame selecionado (Sorológico ou Hemograma)
//  E aplica a funcionalidade de autocompletar no comboBox.
 
    private void carregarExames() {
        database.lerArquivo("exame"); // Lê os exames do arquivo
        exames = database.getExames();
        cbTipoExame.removeAllItems();

    //  Adiciona as patologias dos exames Sorológicos ao comboBox
        if (rbtnSorologico.isSelected()) {
            for (Exame exame : exames) {
                if (exame instanceof Sorologico) {
                    cbTipoExame.addItem(((Sorologico) exame).getPatologia());
                }
            }
        }
        
    //  Adiciona os alvos dos exames de Hemograma ao comboBox
        else if (rbtnHemograma.isSelected()) {
            for (Exame exame : exames) {
                if (exame instanceof Hemograma) {
                    cbTipoExame.addItem(((Hemograma) exame).getAlvo());
                }
            }
        }

        AutoCompleteDecorator.decorate(cbTipoExame); // Aplica autocompletar ao comboBox
    }

//  Carrega a lista de enfermeiros do banco de dados e inclui na comboBox de enfermeiros.
//  E aplica a funcionalidade de autocompletar no comboBox.
    
    private void carregarEnfermeiros() {
        database.lerArquivo("enfermeiro"); // Lê os enfermeiros do arquivo
        enfermeiros = database.getEnfermeiros(); 
        cbEnfermeiro.removeAllItems();
        
        // Adiciona os nomes dos enfermeiros ao comboBox
        for (Enfermeiro enfermeiro : enfermeiros) {
            cbEnfermeiro.addItem(enfermeiro.getNome());
        }

        AutoCompleteDecorator.decorate(cbEnfermeiro); // Aplica autocompletar ao comboBox
    }

    
//  Configura o comboBox de tipos de exame para reagir à seleção de itens.
//  Quando o usuário seleciona um novo item no comboBox, o preço é atualizado.

    private void configurarComboBoxExame() {
        cbTipoExame.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    atualizarPreco();
                }
            }
        });
    }

    
//  Atualiza o campo de preço de acordo com o exame selecionado no comboBox.
//  Verifica se o exame selecionado é Sorológico ou Hemograma e, 
//  se houver correspondência com o item selecionado, define o preço no campo de texto.

    private void atualizarPreco() {
        String selectedExame = (String) cbTipoExame.getSelectedItem();
        if (selectedExame != null) {
            for (Exame exame : exames) {
                String preco = "";
                if (rbtnSorologico.isSelected() && exame instanceof Sorologico) {
                    if (((Sorologico) exame).getPatologia().equals(selectedExame)) {
                        preco = String.valueOf(((Sorologico) exame).getPreco());
                    }
                } else if (rbtnHemograma.isSelected() && exame instanceof Hemograma) {
                    if (((Hemograma) exame).getAlvo().equals(selectedExame)) {
                        preco = String.valueOf(((Hemograma) exame).getPreco());
                    }
                }
                if (!preco.isEmpty()) {
                    txtPreco.setText(preco);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        rbtnSorologico = new javax.swing.JRadioButton();
        rbtnHemograma = new javax.swing.JRadioButton();
        lblExame = new javax.swing.JLabel();
        cbEnfermeiro = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        cbTipoExame = new javax.swing.JComboBox<>();
        lblEnfermeiro = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnAgendar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("Exame");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(txtTitle)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(18, 18, 18))
        );

        background.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 60));

        lblPreco.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblPreco.setText("Preço:");
        background.add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 40));

        rbtnSorologico.setBackground(new java.awt.Color(248, 197, 190));
        rbtnSorologico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnSorologico.setText("Sorológico");
        background.add(rbtnSorologico, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        rbtnHemograma.setBackground(new java.awt.Color(248, 197, 190));
        rbtnHemograma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnHemograma.setText("Hemograma");
        background.add(rbtnHemograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        lblExame.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblExame.setText("Exame:");
        background.add(lblExame, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 120, 40));

        cbEnfermeiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome do enfermeiro...", " " }));
        background.add(cbEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 190, 40));

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblTipo.setText("Tipo:");
        background.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 120, 40));

        cbTipoExame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo...", " " }));
        background.add(cbTipoExame, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 190, 40));

        lblEnfermeiro.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblEnfermeiro.setText("Enfermeiro:");
        background.add(lblEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, 40));
        background.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 190, 40));

        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        background.add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 140, 40));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        background.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
//      Verifica se todos os campos obrigatórios foram preenchidos antes de prosseguir com o agendamento do exame.
//      Se algum campo estiver vazio, exibe uma mensagem de aviso.
//      Caso contrário, busca o enfermeiro selecionado no banco de dados, cria um novo exame (Sorológico ou Hemograma),
//      adiciona-o ao carrinho de exames e atualiza a tabela de checkout na tela principal.
 
        if(cbTipoExame.getSelectedItem().equals("Selecione um tipo...") || cbEnfermeiro.getSelectedItem().equals("Nome do enfermeiro...") ||
           txtPreco.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos!", "Aviso",JOptionPane.WARNING_MESSAGE);
        } else{
        
            String nomeEnfermeiro = (String) cbEnfermeiro.getSelectedItem();
            String tipoExame = (String) cbTipoExame.getSelectedItem();
            String precoExame = txtPreco.getText();

            // Encontrar o enfermeiro selecionado no banco de dados
            Enfermeiro enfermeiroSelecionado = null;
            for (Enfermeiro enf : enfermeiros) {
                if (enf.getNome().equals(nomeEnfermeiro)) {
                    enfermeiroSelecionado = enf;
                    break;
                }
            }

            Exame novoExame = null;
            if (rbtnSorologico.isSelected()) { // Sorológico
                novoExame = new Sorologico(tipoExame, "01/09/2023", telaAgendamentoRef.getPacienteSelecionado(), enfermeiroSelecionado, parseDouble(precoExame),false); // Data fixa por enquanto
            } else if (rbtnHemograma.isSelected()) { // Hemograma
                novoExame = new Hemograma(tipoExame, "01/09/2023" , telaAgendamentoRef.getPacienteSelecionado(), enfermeiroSelecionado, parseDouble(precoExame),false);
            }

            // Adicionar o exame à lista na tela principal
            telaAgendamentoRef.getCheckOutExames().add(novoExame);
            telaAgendamentoRef.verificarCarrinho();
            telaAgendamentoRef.atualizarTabelaCheckOut();
            this.dispose();
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

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
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAgendarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendarExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbEnfermeiro;
    private javax.swing.JComboBox<String> cbTipoExame;
    private javax.swing.JLabel lblEnfermeiro;
    private javax.swing.JLabel lblExame;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JRadioButton rbtnHemograma;
    private javax.swing.JRadioButton rbtnSorologico;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
