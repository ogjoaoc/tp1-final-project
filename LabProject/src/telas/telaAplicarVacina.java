// Interface Gráfica: telaAplicarVacina
// responsável pela conclusão e visualização dos dados da vacina
// e gerar o cartão de vacina

package telas;

import classes.*;
import classes.Vacina;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import database.BancoDeDados;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public final class telaAplicarVacina extends javax.swing.JFrame {
    
//    Instanciar o banco de dados e variáveis auxiliares.
    
    BancoDeDados database = new BancoDeDados();
    private Vacina vacinaAplicada;
    private int idAgendamento;
    private boolean aplicado = false;
    private telaDemandas telaAnterior;
    
//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.    
    
    public telaAplicarVacina(int id, Vacina vacina, telaDemandas telaAnterior) throws IOException, FileNotFoundException, ParseException {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);

//        Define as variáveis auxiliares        
        vacinaAplicada = vacina;
        idAgendamento = id;
        this.telaAnterior = telaAnterior;
 
//        Carrega os dados dos agendamentos e das vacinas
        database.lerArquivo("vacina");
        database.lerArquivoAgendamento();

//      Define o layout dos campos de texto          
        preencherCampos(vacina);
        desabilitarCampos();
        
    }

    private telaAplicarVacina() {
    }

//    Método para preecher os campos de texto
    public void preencherCampos(Vacina vacina){
        Paciente p = vacina.getPacienteAssociado();
        
        // Dados Paciente
        txtNome.setText(p.getNome());
        txtEmail.setText(p.getEmail());
        txtSexo.setText(p.getSexo());
        txtTipoSanguineo.setText(p.getTipoSanguineo());
        txtConvenio.setText(p.getConvenio());
        
        // Dados Exame
        txtData.setText(vacina.getValidade());
        txtDose.setText(vacina.getDose());
        txtVacina.setText(vacina.getTipoVacina());
    
    }
    
//    Método para desabilitar a escrita nos campos de texto

    public void desabilitarCampos(){
        // Dados Paciente
        txtNome.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSexo.setEnabled(false);
        txtTipoSanguineo.setEnabled(false);
        txtConvenio.setEnabled(false);
        
        // Dados Exame
        txtData.setEnabled(false);
        txtDose.setEnabled(false);
        txtVacina.setEnabled(false);
    
    }
    
    public void exportarJFrameParaPDF(JFrame frame, String pdfPath) {
        try {
            // Define a cor de fundo do conteúdo do JFrame como branco
            frame.getContentPane().setBackground(Color.WHITE);

            // Pega o painel de conteúdo (sem a borda e o título da janela)
            JPanel contentPanel = (JPanel) frame.getContentPane();

            // Captura o conteúdo do JFrame (sem a janela) como uma imagem
            BufferedImage image = new BufferedImage(contentPanel.getWidth(), contentPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            contentPanel.printAll(g2d); // Captura o conteúdo do JPanel
            g2d.dispose();

            // Salva a imagem em um arquivo temporário
            File tempFile = new File("temp_image.png");
            ImageIO.write(image, "png", tempFile);

            // Cria o documento PDF com o tamanho de página A4
            PdfWriter writer = new PdfWriter(pdfPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);
            
            document.setMargins(50, 50, 50, 50);

            // Carrega a imagem temporária
            ImageData imageData = ImageDataFactory.create(tempFile.getAbsolutePath());
            Image pdfImage = new Image(imageData);

            // Ajusta a escala da imagem para caber na página A4
            float imageWidth = pdfImage.getImageWidth();
            float imageHeight = pdfImage.getImageHeight();
            float pageWidth = PageSize.A4.getWidth() - document.getLeftMargin() - document.getRightMargin();
            float pageHeight = PageSize.A4.getHeight() - document.getTopMargin() - document.getBottomMargin();

            // Redimensiona a imagem para caber na página
            if (imageWidth > pageWidth || imageHeight > pageHeight) {
                pdfImage.scaleToFit(pageWidth, pageHeight);
            }

            // Adiciona a imagem ao PDF
            document.add(pdfImage);

            // Fecha o documento
            document.close();

            // Remove o arquivo temporário
            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundColor = new javax.swing.JPanel();
        pnlDadosPaciente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        lblConvenio = new javax.swing.JLabel();
        txtTipoSanguineo = new javax.swing.JTextField();
        lblTipoSanguineo = new javax.swing.JLabel();
        txtConvenio = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlDadosExame = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblDose = new javax.swing.JLabel();
        txtDose = new javax.swing.JTextField();
        lblVacina = new javax.swing.JLabel();
        txtVacina = new javax.swing.JTextField();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlBotoes = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnAplicarVacina = new javax.swing.JButton();
        btnCartaoVacina = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 760, 440));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlBackgroundColor.setBackground(new java.awt.Color(248, 197, 190));

        pnlDadosPaciente.setBackground(new java.awt.Color(248, 197, 190));
        pnlDadosPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados do Paciente: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNome.setText("Nome:");

        lblSexo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSexo.setText("Sexo:");

        lblConvenio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblConvenio.setText("Convênio:");

        txtTipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSanguineoActionPerformed(evt);
            }
        });

        lblTipoSanguineo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTipoSanguineo.setText("Tipo Sanguíneo:");

        txtConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConvenioActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("E-mail:");

        javax.swing.GroupLayout pnlDadosPacienteLayout = new javax.swing.GroupLayout(pnlDadosPaciente);
        pnlDadosPaciente.setLayout(pnlDadosPacienteLayout);
        pnlDadosPacienteLayout.setHorizontalGroup(
            pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblConvenio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConvenio))
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoSanguineo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoSanguineo, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosPacienteLayout.setVerticalGroup(
            pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(lblTipoSanguineo)
                    .addComponent(txtTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConvenio)
                    .addComponent(txtConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlDadosExame.setBackground(new java.awt.Color(248, 197, 190));
        pnlDadosExame.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados da Vacina: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblData.setText("Data:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setToolTipText("");

        lblDose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDose.setText("Dose: ");

        lblVacina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVacina.setText("Vacina: ");

        txtVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVacinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosExameLayout = new javax.swing.GroupLayout(pnlDadosExame);
        pnlDadosExame.setLayout(pnlDadosExameLayout);
        pnlDadosExameLayout.setHorizontalGroup(
            pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosExameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosExameLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDose))
                    .addGroup(pnlDadosExameLayout.createSequentialGroup()
                        .addComponent(lblVacina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVacina)))
                .addContainerGap())
        );
        pnlDadosExameLayout.setVerticalGroup(
            pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosExameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDose)
                    .addComponent(txtDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVacina)
                    .addComponent(txtVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("Aplicação - Vacinas");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(lblTitle)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlBotoes.setBackground(new java.awt.Color(248, 197, 190));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAplicarVacina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAplicarVacina.setText("Aplicar Vacina");
        btnAplicarVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarVacinaActionPerformed(evt);
            }
        });

        btnCartaoVacina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCartaoVacina.setText("Gerar Cartão de Vacina");
        btnCartaoVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartaoVacinaActionPerformed(evt);
            }
        });

        btnConcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAplicarVacina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCartaoVacina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAplicarVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnCartaoVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlBackgroundColorLayout = new javax.swing.GroupLayout(pnlBackgroundColor);
        pnlBackgroundColor.setLayout(pnlBackgroundColorLayout);
        pnlBackgroundColorLayout.setHorizontalGroup(
            pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDadosExame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnlBackgroundColorLayout.setVerticalGroup(
            pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                        .addComponent(pnlDadosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlDadosExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSanguineoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSanguineoActionPerformed

    private void txtConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConvenioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConvenioActionPerformed

    private void txtVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVacinaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaDemandas telaDemandas;
        try {
            telaDemandas = new telaDemandas();
            telaDemandas.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(telaAplicarVacina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(telaAplicarVacina.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAplicarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarVacinaActionPerformed
//        Diminui o estoque da vacina aplicada, se ela estiver disponível
        for(Vacina vac: database.getVacinas()){
            if(vac.getTipoVacina().equals(vacinaAplicada.getTipoVacina())){
                if(vac.isDisponivel()){
                    vac.aplicaVacina();
                    database.atualizarVacina(vac);
                    aplicado = true;
                    break;
                } else{
                    JOptionPane.showMessageDialog(null,"Vacina indisponível no estoque!", "Mensagem",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(null,"Vacina aplicada com sucesso.", "Mensagem",JOptionPane.WARNING_MESSAGE);
        btnAplicarVacina.setEnabled(false);
        btnVoltar.setEnabled(false);
    }//GEN-LAST:event_btnAplicarVacinaActionPerformed

    private void btnCartaoVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartaoVacinaActionPerformed
        
        if(!aplicado) {
        
            JOptionPane.showMessageDialog(null, "A vacina deve ser aplicada para gerar um comprovante atualizado!" , "Aviso", JOptionPane.WARNING_MESSAGE);
        
        } else {
            
            //ComprovanteVacina comprovanteAtual = new ComprovanteVacina(vacinaAplicada.getPacienteAssociado(), vacinaAplicada.getEnfermeiroAssociado());
            
            templateComprovanteVacina resultado = new templateComprovanteVacina(vacinaAplicada); 
            resultado.setVisible(false);
            
            
            String caminho =  "src/resultados/vacinas/" + idAgendamento + "_" + vacinaAplicada.getTipoVacina() + ".pdf";
            
            exportarJFrameParaPDF(resultado, Paths.get(System.getProperty("user.dir"), caminho).toString());
            try {
                Desktop.getDesktop().open(new File(caminho));
            } catch (IOException ex) {}

        }
        
    }//GEN-LAST:event_btnCartaoVacinaActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
//        Altera o status da vacina para "Concluído"

        if(aplicado){
            for (Agendamento agendamentoAtualizado : database.getAgendamentos()) {
                //System.out.println("Verificando agendamento: " + agendamentoAtualizado.getId()); // Debug do agendamento atual

                if(agendamentoAtualizado.getId() == idAgendamento){
                    for (int i = 0; i < agendamentoAtualizado.getListaVacinas().size(); i++) {
                        Vacina vacinaAtual = agendamentoAtualizado.getListaVacinas().get(i);
                        //System.out.println("Verificando vacina: " + vacinaAtual.getTipoVacina() + " - Status: " + vacinaAtual.getStatus()); // Debug da vacina atual

                        if (vacinaAtual.getTipoVacina().equals(vacinaAplicada.getTipoVacina())) {
                            //System.out.println("Vacina encontrada: " + vacinaAplicada.getTipoVacina()); // Confirma que a vacina foi encontrada
                            vacinaAplicada.setStatus(true);
                            agendamentoAtualizado.getListaVacinas().set(i, vacinaAplicada);
                            //System.out.println("Vacina atualizada: " + vacinaAplicada.getTipoVacina() + " - Novo Status: " + vacinaAplicada.getStatus()); // Confirma que o status foi atualizado
                            database.atualizarAgendamento(agendamentoAtualizado);
                            //System.out.println("Agendamento atualizado: " + agendamentoAtualizado.getId()); // Confirma que o agendamento foi atualizado no banco de dados
                            break;
                        }
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, "Vacina realizada com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            
            
            telaDemandas telaDemandas;
            try {
                telaDemandas = new telaDemandas();
                telaDemandas.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(telaEnfermeiro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(telaEnfermeiro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null,"Vacina não aplicada!", "Mensagem",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

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
            java.util.logging.Logger.getLogger(telaAplicarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAplicarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAplicarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAplicarVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAplicarVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarVacina;
    private javax.swing.JButton btnCartaoVacina;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblConvenio;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDose;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipoSanguineo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVacina;
    private javax.swing.JPanel pnlBackgroundColor;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlDadosExame;
    private javax.swing.JPanel pnlDadosPaciente;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTextField txtConvenio;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDose;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTipoSanguineo;
    private javax.swing.JTextField txtVacina;
    // End of variables declaration//GEN-END:variables
}
