// Interface Gráfica: telaAgendamento
// Responsável pela gestão de agendamentos de exames e vacinas para pacientes.
// Permite adicionar exames e vacinas ao check-out, exibir os procedimentos agendados,
// e avançar para a tela de pagamento. Inclui funcionalidade de auto-completar para nomes
// de pacientes e placeholders para campos de texto.

package telas;

import database.BancoDeDados;
import classes.*;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class telaAgendamento extends javax.swing.JFrame {
    
//    Instanciando banco de dados e auxiliares.
    
    private JPopupMenu popupPaciente = new JPopupMenu();
    protected BancoDeDados database = new BancoDeDados(); 
    private Timer debounceTimer;
    
//    Declaração de EDA's auxiliares para manipulação do "carrinho".
    
    ArrayList<Exame> checkOutExames;
    ArrayList<Vacina> checkOutVacinas;
    
//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.
    
    public telaAgendamento() throws IOException, FileNotFoundException, ParseException {
        
        initComponents();
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/iconCoracao.png")).getImage());
        this.setTitle("Atendente - Agendamento");
        
//        Métodos para inicialização de placeholders

        setupAutoComplete();
        setupPlaceholders();
        
//        Carregando dados dos pacientes, para pesquisa

        database.lerArquivo("paciente");
        
//       Instanciando EDA's e atualizando tabela com o "carrinho".

        this.checkOutExames = new ArrayList<>();
        this.checkOutVacinas = new ArrayList<>();
        atualizarTabelaCheckOut();
        
        database.lerArquivoAgendamento();
        
//         Trecho de DEBUG...           ---------------------------------------------
//        for (Agendamento a : database.getAgendamentos()) {;
//            System.out.println("Agendamento ID: " + a.getId());
//            System.out.println("Data de Criação: " + a.getDataCriado());
//            System.out.println("Valor Total: " + a.getValorTotal());
//
//            // Itera sobre a lista de exames do agendamento
//            for (Exame e : a.getListaExames()) {
//                System.out.println("  Tipo de Exame: " + e.getTipoExame());
//                System.out.println("  Subtipo de Exame: " + e.getSubtipo());
//                System.out.println("  Data de Realização: " + e.getDataRealizacao());
//                System.out.println("  CPF do Paciente Associado: " + e.getCpfPacienteAssociado());
//                System.out.println("  CPF do Enfermeiro Associado: " + e.getCpfEnfermeiroAssociado());
//                System.out.println("  Preço: " + e.getPreco());
//            }
//
//            // Itera sobre a lista de vacinas do agendamento
//            for (Vacina v : a.getListaVacinas()) {
//                System.out.println("  Tipo de Vacina: " + v.getTipoVacina());
//                System.out.println("  Validade da Vacina: " + v.getValidade());
//                System.out.println("  CPF do Paciente Associado: " + v.getCpfPacienteAssociado());
//                System.out.println("  CPF do Enfermeiro Associado: " + v.getCpfEnfermeiroAssociado());
//                System.out.println("  Dosagem: " + v.getDose());
//                System.out.println("  Preço: " + v.getPreco());
//            }
//
//            System.out.println("-------------------------------------------------");
//        }
//      ---------------------------------------------------------------------------------- 

            txtPaciente.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }
                @Override
                public void focusLost(FocusEvent e) {
                    Paciente paciente = getPacienteSelecionado();
                    if (paciente != null) {
                        //System.out.println(paciente.getSexo());
                        atualizarIconeSexo(paciente.getSexo());
                    } else {
                        iconSexoPaciente.setIcon(null); 
                    }
            }
        });
    }
    
//    Método para setar o ícone do sexo a partir do paciente selecionado
    public void atualizarIconeSexo(String sexoPaciente) {
        
        java.net.URL girlIconURL = getClass().getResource("/imagens/IconGirl.png");
        java.net.URL boyIconURL = getClass().getResource("/imagens/IconBoy.png");

        ImageIcon iconGirl = (girlIconURL != null) ? new ImageIcon(girlIconURL) : null;
        ImageIcon iconBoy = (boyIconURL != null) ? new ImageIcon(boyIconURL) : null;

        if (sexoPaciente.equalsIgnoreCase("Feminino")) {
            iconSexoPaciente.setIcon(iconGirl); 
        } else if (sexoPaciente.equalsIgnoreCase("Masculino")) {
            //System.out.println("oi");
            iconSexoPaciente.setIcon(iconBoy);  
        } else {
            iconSexoPaciente.setIcon(null); 
        }
        
    }
    
//    Método para reinicializar campos.
    
    protected void limparTela(){
        txtPaciente.setText("");
        checkOutExames.clear();
        checkOutVacinas.clear();
        atualizarTabelaCheckOut();
    }
    
//    getter do objeto pacienteSelecionado.
    
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
    
//    Método para atualização da tabela de checkOut.
    
    protected void atualizarTabelaCheckOut() {
        String[] colunas = {"Procedimento", "Tipo", "Enfermeiro", "Valor", "Data de Realização"};
        Object[][] dados = new Object[checkOutExames.size() + checkOutVacinas.size()][5];

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
        for (Vacina vacina : checkOutVacinas) {
            dados[i][0] = "Vacina"; 
            dados[i][1] = vacina.getTipoVacina(); 
            dados[i][2] = vacina.getEnfermeiroAssociado().getNome(); 
            dados[i][3] = vacina.getPreco(); 
            dados[i][4] = sdf.format(new Date()); 
            i++;
        }

        javax.swing.table.DefaultTableModel modeloTabela = new javax.swing.table.DefaultTableModel(dados, colunas);
        tblAgendamentos.setModel(modeloTabela);
    }
    
//    Getters e setters.

    public ArrayList<Exame> getCheckOutExames() {
        return checkOutExames;
    }

    public void setCheckOutExames(ArrayList<Exame> checkOutExames) {
        this.checkOutExames = checkOutExames;
    }

    public ArrayList<Vacina> getCheckOutVacina() {
        return checkOutVacinas;
    }

    public void setCheckOutVacina(ArrayList<Vacina> checkOutVacina) {
        this.checkOutVacinas = checkOutVacina;
    }
    
    
//     Configura a funcionalidade de auto-completar para o campo de texto do paciente, e
//     adiciona um DocumentListener ao campo de texto que ativa o auto-completar quando
//     o texto é alterado.
    
    private void setupAutoComplete() {
        txtPaciente.getDocument().addDocumentListener(new telaAgendamento.AutoCompleteListener(txtPaciente));
    }
    
//     Classe interna que implementa DocumentListener para fornecer sugestões de auto-completar.
//     Utiliza um Timer para debouncer e mostra sugestões em um JPopupMenu com base no texto
//     inserido pelo usuário, poder atualizar a lista de sugestões a partir dos nomes de pacientes.
    
    private class AutoCompleteListener implements DocumentListener {
        private JTextField textField;
        private String tipo;  
        private JPopupMenu popupMenu;
        private boolean updatingText = false;

        public AutoCompleteListener(JTextField textField) {
            this.textField = textField;
            this.popupMenu = popupPaciente;

            // Adiciona o KeyListener para detectar quando a tecla Enter é pressionada
            this.textField.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        textField.transferFocus(); // Perde o foco ao apertar Enter
                    }
                }
            });
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
        public void changedUpdate(DocumentEvent e) {}

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

                    textField.transferFocus(); // Força a perda de foco ao selecionar um item da lista
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

//  Define o texto indicativo que aparece no campo de busca de paciente
    private void setupPlaceholders() {
        configurarPlaceholder(txtPaciente, "Digite o nome do paciente...");     
    }

//     Configura um placeholder para um campo de texto. O placeholder é exibido quando
//     o campo está vazio e é substituído quando o campo recebe o foco, podendo retornar o texto
//     e a cor original quando o campo perde o foco.
    
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
    
//  Verifica o conteúdo do carrinho de exames e vacinas.
//  Se houver itens no carrinho, desabilita o campo de texto do paciente;
//  caso contrário, mantém o campo habilitado.

    protected void verificarCarrinho() {
        if (!checkOutExames.isEmpty() || !checkOutVacinas.isEmpty()) {
            txtPaciente.setEnabled(false); // Desabilita o campo de texto se houver exames ou vacinas no carrinho
        } else {
            txtPaciente.setEnabled(true); // Caso contrário, mantém o campo habilitado
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jComboBox1 = new javax.swing.JComboBox<>();
        background = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblCheckOut = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        lblAdicionar = new javax.swing.JLabel();
        btnAvancar = new javax.swing.JButton();
        tblCheckOut = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        btnAdicionarExame = new javax.swing.JButton();
        btnAdicionarVacina = new javax.swing.JButton();
        lblSelecionarPaciente = new javax.swing.JLabel();
        iconSexoPaciente = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(248, 197, 190));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTitle.setPreferredSize(new java.awt.Dimension(700, 68));

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("Agendamento - Exames e Vacinas");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(lblTitle)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18))
        );

        background.add(panelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 70));

        lblCheckOut.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblCheckOut.setText("Check-out:");
        background.add(lblCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, 40));

        txtPaciente.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPacienteActionPerformed(evt);
            }
        });
        background.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, 40));

        lblAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblAdicionar.setText("Adicionar:");
        background.add(lblAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 210, 40));

        btnAvancar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });
        background.add(btnAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 180, 50));

        tblAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCheckOut.setViewportView(tblAgendamentos);

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

        lblSelecionarPaciente.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblSelecionarPaciente.setText("Selecionar paciente:");
        background.add(lblSelecionarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 40));
        background.add(iconSexoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 70, 70));

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
        
//        Só é possível avançar caso todos os campos e pelo menos 1 exame, ou 1 vacina, tenha(m) sidos adicionados ao check-out.

        if(checkOutVacinas.size() == 0 && checkOutExames.size() == 0){
            JOptionPane.showMessageDialog(null,"Nenhum procedimento cadastrado.", "Aviso",JOptionPane.WARNING_MESSAGE);                
        } else {
            telaPagamento telaPag = new telaPagamento(this);
            telaPag.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaAtendente telaAtendente = new telaAtendente();
        telaAtendente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAdicionarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarVacinaActionPerformed
//      Verifica se um paciente foi selecionado.
//      Se nenhum paciente estiver selecionado, exibe uma mensagem de aviso.
//      Caso contrário, abre a tela de agendamento de vacinas.

        if(getPacienteSelecionado() == null) {
            JOptionPane.showMessageDialog(null,"Nenhum paciente selecionado!", "Aviso",JOptionPane.WARNING_MESSAGE);  
        } else {
        telaAgendarVacina telaAgendarVacina = new telaAgendarVacina(this);
        telaAgendarVacina.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarVacinaActionPerformed

    private void btnAdicionarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarExameActionPerformed
//      Verifica se um paciente foi selecionado.
//      Se nenhum paciente estiver selecionado, exibe uma mensagem de aviso.
//      Caso contrário, abre a tela de agendamento de exames.

        if(getPacienteSelecionado() == null) {
            JOptionPane.showMessageDialog(null,"Nenhum paciente selecionado!", "Aviso",JOptionPane.WARNING_MESSAGE);  
        } else {
            telaAgendarExame telaAgendarExame = new telaAgendarExame(this);
            telaAgendarExame.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarExameActionPerformed

    private void txtPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPacienteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaAgendamento().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(telaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(telaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JLabel iconSexoPaciente;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lblAdicionar;
    private javax.swing.JLabel lblCheckOut;
    private javax.swing.JLabel lblSelecionarPaciente;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTable tblAgendamentos;
    private javax.swing.JScrollPane tblCheckOut;
    private javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}
