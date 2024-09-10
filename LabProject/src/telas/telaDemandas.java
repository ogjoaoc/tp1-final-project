// Interface Gráfica: telaDemandas
// responsável pela conexão das demandas de exames e vacinas de cada Enfermeiro
// realizar exames e aplicar vacinas
// monitorar a quantidade de demandas pendentes e concluídas
// visualizar os resultados das demandas conluídas

package telas;

import classes.*;
import classes.Exame;
import classes.Agendamento;
import database.BancoDeDados;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class telaDemandas extends javax.swing.JFrame {
    
//    Instanciar o banco de dados e o usuário logado.
    
    public BancoDeDados database = new BancoDeDados(); 
    public Enfermeiro userLogado = (Enfermeiro) GerenciadorLogin.getInstance().getFuncionario();
    
//    Declaração de EDA's auxiliares para manipulação das demandas (exames e vacinas).
    public ArrayList<Map.Entry<Integer,Object>> listaDemandas = new ArrayList<>();
    public ArrayList<Object> listaDemandasPendentes = new ArrayList<>();
    public ArrayList<Object> listaDemandasConcluidas = new ArrayList<>();

//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.
        
    public telaDemandas() throws IOException, FileNotFoundException, ParseException {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        
//        Carregando os dados dos agendamentos.
        database.lerArquivoAgendamento();
        
//        Filtra os agendamentos com o enfermeiro logado.
        filtraAgendamentos();
        
//        Indica a quantidade de demandas pendentes e concluídas.
        txtNumPendentes.setText(String.valueOf(listaDemandasPendentes.size()));
        txtNumConcluidos.setText(String.valueOf(listaDemandasConcluidas.size()));

//        Inicializa a tabela com as demandas filtradas.
        carregarTabela();
        
    }

//  Filtra os agendamentos a partir do cpf do Enfermeiro logado.
    
    private void filtraAgendamentos(){
        String cpfEnfermeiro = userLogado.getCpf();

          // Debug: Verificando se os agendamentos estão sendo carregados
//        System.out.println("Iniciando filtragem de agendamentos...");
//        System.out.println("CPF do enfermeiro logado: " + cpfEnfermeiro);
//        System.out.println("Total de agendamentos no banco de dados: " + database.getAgendamentos().size());

        for (Agendamento agendamento : database.getAgendamentos()) {
            // Debug: Verificando conteúdo de cada agendamento
//            System.out.println("Processando Agendamento ID: " + agendamento.getId());
//            System.out.println("Lista de Exames: " + agendamento.getListaExames().size());
//            System.out.println("Lista de Vacinas: " + agendamento.getListaVacinas().size());

            for (Exame exame: agendamento.getListaExames()) {
                // Debug: Examinando cada exame
//                System.out.println("Exame: " + exame.getTipoExame());
//                System.out.println("CPF do enfermeiro associado ao exame: " + exame.getEnfermeiroAssociado().getCpf());

                if (exame.getEnfermeiroAssociado().getCpf().equals(cpfEnfermeiro)) {
                    listaDemandas.add(new AbstractMap.SimpleEntry<>(agendamento.getId(), exame));

                    if (exame.getStatus() == false) {
                        listaDemandasPendentes.add(exame);
                        // Debug: Exame pendente
                        //System.out.println("Exame Pendente: " + exame.getTipoExame());
                    } else {
                        listaDemandasConcluidas.add(exame);
                        // Debug: Exame concluído
                        //System.out.println("Exame Concluído: " + exame.getTipoExame());
                    }
                }
            }

            for (Vacina vacina: agendamento.getListaVacinas()) {
                // Debug: Examinando cada vacina
//                System.out.println("Vacina: " + vacina.getTipoVacina());
//                System.out.println("CPF do enfermeiro associado à vacina: " + vacina.getEnfermeiroAssociado().getCpf());

                if (vacina.getEnfermeiroAssociado().getCpf().equals(cpfEnfermeiro)) {
                    listaDemandas.add(new AbstractMap.SimpleEntry<>(agendamento.getId(), vacina));

                    if (vacina.getStatus() == false) {
                        listaDemandasPendentes.add(vacina);
                        // Debug: Vacina pendente
                        //System.out.println("Vacina Pendente: " + vacina.getTipoVacina());
                    } else {
                        listaDemandasConcluidas.add(vacina);
                        // Debug: Vacina concluída
                        //System.out.println("Vacina Concluída: " + vacina.getTipoVacina());
                    }
                }
            } 
    }
    
    // Debug: Resumo final
//    System.out.println("Total Demandas: " + listaDemandas.size());
//    System.out.println("Demandas Pendentes: " + listaDemandasPendentes.size());
//    System.out.println("Demandas Concluídas: " + listaDemandasConcluidas.size());
}

//  Método auxiliar para carregar dados dos exames e vacinas da lista de demandas na tebela.
 
    public void carregarTabela(){
        String[] colunas = {"ID", "Procedimento", "Tipo", "Data", "Status"};
        Object[][] dados = new Object[listaDemandas.size()][5];
        
        
        int i = 0;
        for( Map.Entry<Integer, Object> pair : listaDemandas){
                        
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            if(pair.getValue() instanceof Exame){
                dados[i][0] = pair.getKey();
                dados[i][1] = ((Exame) pair.getValue()).getTipoExame(); 
                dados[i][2] = "Exame";
                dados[i][3] = ((Exame) pair.getValue()).getDataRealizacao();
                if(((Exame) pair.getValue()).getStatus() == false){
                    dados[i][4] = "Pendente"; 
                } else{
                    dados[i][4] = "Concluído";
                }
            }

            else if(pair.getValue() instanceof Vacina){
                dados[i][0] = pair.getKey();
                dados[i][1] = ((Vacina) pair.getValue()).getTipoVacina();
                dados[i][2] = "Vacina"; 
                dados[i][3] = sdf.format(new Date());
                if(((Vacina) pair.getValue()).getStatus() == false){
                    dados[i][4] = "Pendente"; 
                } else{
                    dados[i][4] = "Concluído";
                }
            }
            
            i++;
        }
        
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        tblDemandas.setModel(modelo); // Supondo que tabelaDemandas é o nome do seu JTable

    }
    
    public String formatarData(String data) {
        String aux = "";
        for(int i = 0; i < data.length(); i++) {
            if(Character.isDigit(data.charAt(i))) {
                aux += data.charAt(i);
            }
        }
        return aux;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundColor = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        scrollPaneDemandas = new javax.swing.JScrollPane();
        tblDemandas = new javax.swing.JTable();
        pnlDemandasPendentes = new javax.swing.JPanel();
        lblDemandasPendentes = new javax.swing.JLabel();
        txtNumPendentes = new javax.swing.JTextField();
        pnlDemandasConcluidas = new javax.swing.JPanel();
        lblDemandasConcluidas = new javax.swing.JLabel();
        txtNumConcluidos = new javax.swing.JTextField();
        btnAvancar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackgroundColor.setBackground(new java.awt.Color(248, 197, 190));

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("Demandas - Exames e Vacinas");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lblTitle)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18))
        );

        tblDemandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Procedimento", "Tipo", "Data", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDemandas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPaneDemandas.setViewportView(tblDemandas);

        lblDemandasPendentes.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblDemandasPendentes.setForeground(new java.awt.Color(153, 0, 0));
        lblDemandasPendentes.setText("Demandas Pendentes");

        txtNumPendentes.setBackground(new java.awt.Color(242, 242, 242));
        txtNumPendentes.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtNumPendentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumPendentes.setMaximumSize(new java.awt.Dimension(100, 36));
        txtNumPendentes.setMinimumSize(new java.awt.Dimension(100, 36));
        txtNumPendentes.setPreferredSize(new java.awt.Dimension(100, 36));

        javax.swing.GroupLayout pnlDemandasPendentesLayout = new javax.swing.GroupLayout(pnlDemandasPendentes);
        pnlDemandasPendentes.setLayout(pnlDemandasPendentesLayout);
        pnlDemandasPendentesLayout.setHorizontalGroup(
            pnlDemandasPendentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDemandasPendentesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblDemandasPendentes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDemandasPendentesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNumPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        pnlDemandasPendentesLayout.setVerticalGroup(
            pnlDemandasPendentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDemandasPendentesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblDemandasPendentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblDemandasConcluidas.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblDemandasConcluidas.setForeground(new java.awt.Color(153, 0, 0));
        lblDemandasConcluidas.setText("Demandas Concluídas");

        txtNumConcluidos.setBackground(new java.awt.Color(242, 242, 242));
        txtNumConcluidos.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        txtNumConcluidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumConcluidos.setMaximumSize(new java.awt.Dimension(100, 64));
        txtNumConcluidos.setMinimumSize(new java.awt.Dimension(100, 64));
        txtNumConcluidos.setPreferredSize(new java.awt.Dimension(100, 36));

        javax.swing.GroupLayout pnlDemandasConcluidasLayout = new javax.swing.GroupLayout(pnlDemandasConcluidas);
        pnlDemandasConcluidas.setLayout(pnlDemandasConcluidasLayout);
        pnlDemandasConcluidasLayout.setHorizontalGroup(
            pnlDemandasConcluidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDemandasConcluidasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblDemandasConcluidas)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDemandasConcluidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNumConcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        pnlDemandasConcluidasLayout.setVerticalGroup(
            pnlDemandasConcluidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDemandasConcluidasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblDemandasConcluidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumConcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAvancar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAvancar.setText("Realizar Exame / Aplicar Vacina");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVisualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundColorLayout = new javax.swing.GroupLayout(pnlBackgroundColor);
        pnlBackgroundColor.setLayout(pnlBackgroundColorLayout);
        pnlBackgroundColorLayout.setHorizontalGroup(
            pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlDemandasConcluidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDemandasPendentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisualizar)
                        .addGap(18, 18, 18)))
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAvancar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneDemandas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundColorLayout.setVerticalGroup(
            pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(pnlDemandasConcluidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(pnlDemandasPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(scrollPaneDemandas, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
//        Avança para a telaRealizarExame ou telaAplicarVacina a partir da seleção de uma demanda na tabela
        
        int idx = tblDemandas.getSelectedRow(); // Obtém o índice da linha selecionada na tabela
        if (idx >= 0) {
            if(tblDemandas.getValueAt(idx,4).equals("Pendente")){
                switch (listaDemandas.get(idx).getValue()) {
                    case Exame exame -> {
                        try {
                            telaRealizarExame telaRealizarExame = new telaRealizarExame(listaDemandas.get(idx).getKey(), exame, this);
                            telaRealizarExame.setVisible(true);
                        } catch (IOException | ParseException ex) {
                            Logger.getLogger(telaDemandas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.dispose();
                    }
                    case Vacina vacina -> {
                        telaAplicarVacina telaAplicarVacina;
                        try {
                            telaAplicarVacina = new telaAplicarVacina(listaDemandas.get(idx).getKey(), vacina, this);
                            telaAplicarVacina.setVisible(true);
                        } catch (IOException | ParseException ex) {
                            Logger.getLogger(telaDemandas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.dispose();
                    }
                    default -> {
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Demanda já concluída", "Mensagem",JOptionPane.PLAIN_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Selecione uma demanda para avançar.", "Mensagem",JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaEnfermeiro telaEnfermeiro = new telaEnfermeiro();
        telaEnfermeiro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        
        int idx = tblDemandas.getSelectedRow();
        
        if(idx != -1) {
            
            Exame exameAtual = null;
            Vacina vacinaAtual = null;
            
            if(listaDemandas.get(idx).getValue() instanceof Exame) {
                
                exameAtual = (Exame) listaDemandas.get(idx).getValue();
                
            } else {
                
                vacinaAtual = (Vacina) listaDemandas.get(idx).getValue();
               
            }

            if(exameAtual != null && exameAtual.getStatus() == true) {
                
                String caminho =  "src/resultados/exames/" + listaDemandas.get(idx).getKey() + "_" + exameAtual.getTipoExame() + "_" + formatarData(exameAtual.getDataRealizacao()) + ".pdf";
                
                try {
                    
                    Desktop.getDesktop().open(new File(caminho));
                
                } catch (IOException ex) {
                    
                    Logger.getLogger(telaDemandas.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
            } else if(vacinaAtual != null && vacinaAtual.getStatus() == true) {
                
                String caminho =  "src/resultados/vacinas/" + listaDemandas.get(idx).getKey() + "_" + vacinaAtual.getTipoVacina() + ".pdf";
                
                try {
                    
                    Desktop.getDesktop().open(new File(caminho));
                
                } catch (IOException ex) {
                    
                    Logger.getLogger(telaDemandas.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
            } else {
                
                JOptionPane.showMessageDialog(null,"A demanda deve ser concluída para visualizar o resultado!", "Aviso",JOptionPane.WARNING_MESSAGE);
                
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null,"Nenhuma demanda selecionada!", "Aviso",JOptionPane.WARNING_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btnVisualizarActionPerformed

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
            java.util.logging.Logger.getLogger(telaDemandas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaDemandas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaDemandas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaDemandas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaDemandas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(telaDemandas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(telaDemandas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblDemandasConcluidas;
    private javax.swing.JLabel lblDemandasPendentes;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackgroundColor;
    private javax.swing.JPanel pnlDemandasConcluidas;
    private javax.swing.JPanel pnlDemandasPendentes;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrollPaneDemandas;
    private javax.swing.JTable tblDemandas;
    private javax.swing.JTextField txtNumConcluidos;
    private javax.swing.JTextField txtNumPendentes;
    // End of variables declaration//GEN-END:variables
}
