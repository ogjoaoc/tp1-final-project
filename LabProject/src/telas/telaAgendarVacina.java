// Interface Gráfica: telaAgendarVacina
// Responsável pelo preenchimento de dados para o agendamento de vacinas.
// Podendo definir: a vacina, o enfermeiro e a dosagem, para adicionar ao agendamento.s

package telas;

import classes.Enfermeiro;
import classes.*;
import classes.Vacina;
import database.BancoDeDados;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import javax.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class telaAgendarVacina extends javax.swing.JFrame {
    
//    Instanciando banco de dados e auxiliares.

    private BancoDeDados database = new BancoDeDados();
    private telaAgendamento telaAgendamentoRef;
    
//    Declaração de EDA's auxiliares para armazenar as vacinas e enfermeiros.
   
    private ArrayList<Vacina> vacinas; 
    private ArrayList<Enfermeiro> enfermeiros; 
        
    public telaAgendarVacina(){}
    
//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.
  
    public telaAgendarVacina(telaAgendamento ref) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    //  Faz a leitura dos arquivos Vacinas e Enfermeiros para configurar os comboBox
        carregarVacinas();
        carregarEnfermeiros();
        
    //  Configura os comboBox de vacina e enfermeiro  
        configurarComboBoxVacina();
        configurarComboBoxEnfermeiro();
       
        telaAgendamentoRef = ref; // Atribui a referência da tela de agendamento principal
    }
    
//    Carrega a lista de vacinas do banco de dados e inclui na comboBox tipoVacina.
//    Aplica a funcionalidade de autocompletar no comboBox.
                
    private void carregarVacinas() {
        database.lerArquivo("vacina");
        vacinas = database.getVacinas();
        cbTipoVacina.removeAllItems();
        cbTipoVacina.addItem("Selecione um tipo...");
        
        for (Vacina vac : vacinas) {
            cbTipoVacina.addItem(vac.getTipoVacina());
        }

        AutoCompleteDecorator.decorate(cbTipoVacina);
    }

//    Carrega a lista de enfermeiro do banco de dados e inclui na comboBox enfermeiro.
//    Aplica a funcionalidade de autocompletar no comboBox.
    
    private void carregarEnfermeiros() {
        database.lerArquivo("enfermeiro");
        enfermeiros = database.getEnfermeiros(); 
        cbEnfermeiro.removeAllItems();
        cbEnfermeiro.addItem("Nome do enfermeiro...");
        
        for (Enfermeiro enfermeiro : enfermeiros) {
            cbEnfermeiro.addItem(enfermeiro.getNome());
        }

        AutoCompleteDecorator.decorate(cbEnfermeiro);
    }
    
    
//  Configura o comboBox de tipos de vacina para reagir à seleção de itens.
//  E chama o método "atualizarPreco" para atualizar o preço da vacina.
    
    private void configurarComboBoxVacina() {
        cbTipoVacina.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbTipoVacina.getSelectedIndex() != 0) {
                        atualizarPreco();
                    }
                }
            }
        });
    }

//  Configura o comboBox de enfermeiro para reagir à seleção de itens.
    
    private void configurarComboBoxEnfermeiro() {
        cbEnfermeiro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Não remove a opção padrão
                }
            }
        });
    }

//  Atualiza o campo de preço de acordo com a vacina selecionado no comboBox.
//  se houver correspondência com o item selecionado, define o preço no campo de texto.

    private void atualizarPreco() {
        String selectedTipoVacina = (String) cbTipoVacina.getSelectedItem();
        if (selectedTipoVacina != null && !selectedTipoVacina.equals("Selecione um tipo...")) {
            for (Vacina vacina : vacinas) {
                if (vacina.getTipoVacina().equals(selectedTipoVacina)) {
                    txtPreco.setText(String.valueOf(vacina.getPreco()));
                    return;
                }
            }
        } else {
            txtPreco.setText("0"); 
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        lblSelecionarPaciente1 = new javax.swing.JLabel();
        lblVacina = new javax.swing.JLabel();
        cbDose = new javax.swing.JComboBox<>();
        cbTipoVacina = new javax.swing.JComboBox<>();
        lblSelecionarPaciente4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnAgendar = new javax.swing.JButton();
        cbEnfermeiro = new javax.swing.JComboBox<>();
        lblSelecionarPaciente2 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(153, 0, 0));
        txtTitle.setText("Vacina");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(txtTitle)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtTitle)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        background.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 60));

        lblSelecionarPaciente1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente1.setText("Dosagem:");
        background.add(lblSelecionarPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, 40));

        lblVacina.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblVacina.setText("Vacina:");
        background.add(lblVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 120, 40));

        cbDose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a dose...", "1ª Dose", "2ª Dose", "Dose de reforço" }));
        background.add(cbDose, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 190, 40));

        cbTipoVacina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo...", " " }));
        background.add(cbTipoVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 190, 40));

        lblSelecionarPaciente4.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente4.setText("Enfermeiro:");
        background.add(lblSelecionarPaciente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 120, 40));

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        background.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 190, 40));

        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        background.add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 140, 40));

        cbEnfermeiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome do enfermeiro...", " " }));
        background.add(cbEnfermeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 190, 40));

        lblSelecionarPaciente2.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        lblSelecionarPaciente2.setText("Preço:");
        background.add(lblSelecionarPaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 40));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        background.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 140, 40));

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

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
//      Verifica se todos os campos obrigatórios foram preenchidos antes de prosseguir com o agendamento da vacina.
//      Se algum campo estiver vazio ou com uma seleção padrão, exibe uma mensagem de aviso.
//      Caso contrário, busca o enfermeiro e a vacina selecionados nas listas correspondentes,
//      cria um novo objeto Vacina com os dados fornecidos, adiciona-o ao carrinho de vacinas,
//      e atualiza a tabela de checkout na tela principal. Finalmente, fecha a janela atual.

        if(cbEnfermeiro.getSelectedItem().equals("Nome do enfermeiro...") || cbTipoVacina.getSelectedItem().equals("Selecione um tipo...") ||
           cbDose.getSelectedItem().equals("Selecione a dose...") || txtPreco.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos!", "Aviso",JOptionPane.WARNING_MESSAGE);
        } else{
            String nomeEnfermeiro = (String) cbEnfermeiro.getSelectedItem();
            String tipoVacina = (String) cbTipoVacina.getSelectedItem();
            String dosagem = (String) cbDose.getSelectedItem();
            String precoVacina = txtPreco.getText();

        //  Busca o enfermeiro selecionado na lista de enfermeiros
            Enfermeiro enfermeiroSelecionado = null;
            for (Enfermeiro enf : enfermeiros) {
                if (enf.getNome().equals(nomeEnfermeiro)) {
                    enfermeiroSelecionado = enf;
                    break;
                }
            }
            
        //  Busca a vacina selecionada na lista de vacinas
            Vacina vacinaSelecionada = null;
            for (Vacina vac : vacinas) {
                if(vac.getTipoVacina().equals(tipoVacina)) {
                    vacinaSelecionada = vac;
                    break;
                }
            }
        
        //  Cria uma nova vacina com os dados fornecidos e adiciona ao carrinho, atualizando a telaAgendamento
            Vacina novaVacina = new Vacina(tipoVacina, vacinaSelecionada.getValidade(), enfermeiroSelecionado, telaAgendamentoRef.getPacienteSelecionado(), dosagem, vacinaSelecionada.getPreco(),false);
            telaAgendamentoRef.getCheckOutVacina().add(novaVacina);
            telaAgendamentoRef.verificarCarrinho();
            telaAgendamentoRef.atualizarTabelaCheckOut();
            this.dispose();
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

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
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAgendarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAgendarVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbDose;
    private javax.swing.JComboBox<String> cbEnfermeiro;
    private javax.swing.JComboBox<String> cbTipoVacina;
    private javax.swing.JLabel lblSelecionarPaciente1;
    private javax.swing.JLabel lblSelecionarPaciente2;
    private javax.swing.JLabel lblSelecionarPaciente4;
    private javax.swing.JLabel lblVacina;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
