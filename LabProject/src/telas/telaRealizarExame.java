// Interface Gráfica: telaRealizarExame
// responsável pela conclusão e visualização dos dados do exame
// e gerar laudo

package telas;

import classes.*;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import database.BancoDeDados;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.stream.Collectors;


public class telaRealizarExame extends javax.swing.JFrame {

//    Instanciar o banco de dados e variáveis auxiliares.

    BancoDeDados database = new BancoDeDados();
    private Exame exameRealizado;
    private int idAgendamento;
    
//    Construtor da tela
//    Por padrão centralizada, e com redimensionamento desabilitado.    
    
    public telaRealizarExame(Integer id,Exame exame) throws IOException, FileNotFoundException, ParseException {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);

//        Define as variáveis auxiliares
        exameRealizado = exame;
        idAgendamento = id;

//        Carrega os dados dos agendamentos 
        database.lerArquivoAgendamento();

//      Define o layout dos campos de texto  
        preencherCampos(exame);
        desabilitarCampos();
        
    }

//    Método para transformar o laudo em PDF
    
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


    private telaRealizarExame() {
    }

//    Método para preecher os campos de texto
            
    public void preencherCampos(Exame exame){
        Paciente p = exame.getPacienteAssociado();
        
        // Dados Paciente
        txtNome.setText(p.getNome());
        txtEmail.setText(p.getEmail());
        txtSexo.setText(p.getSexo());
        txtTipoSanguineo.setText(p.getTipoSanguineo());
        txtConvenio.setText(p.getConvenio());
        
        // Dados Exame
        txtData.setText(exame.getDataRealizacao());
        txtTipo.setText(exame.getSubtipo());
        txtPatologia.setText(exame.getTipoExame());
        
    
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
        txtTipo.setEnabled(false);
        txtPatologia.setEnabled(false);
        
        // Campo Resultado
        txtResultado.setEnabled(true);
    
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
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblPatologia = new javax.swing.JLabel();
        txtPatologia = new javax.swing.JTextField();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        pnlBotoes = new javax.swing.JPanel();
        btnConcluir = new javax.swing.JButton();
        btnGerarLaudo = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 750, 510));
        setMinimumSize(new java.awt.Dimension(750, 510));
        setSize(new java.awt.Dimension(750, 510));

        pnlBackgroundColor.setBackground(new java.awt.Color(248, 197, 190));

        pnlDadosPaciente.setBackground(new java.awt.Color(248, 197, 190));
        pnlDadosPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados do Paciente: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N
        pnlDadosPaciente.setMaximumSize(new java.awt.Dimension(400, 176));
        pnlDadosPaciente.setMinimumSize(new java.awt.Dimension(400, 176));

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
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(pnlDadosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblConvenio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConvenio))
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoSanguineo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoSanguineo))
                    .addGroup(pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosPacienteLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlDadosExame.setBackground(new java.awt.Color(248, 197, 190));
        pnlDadosExame.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados do Exame: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N
        pnlDadosExame.setMaximumSize(new java.awt.Dimension(400, 110));
        pnlDadosExame.setMinimumSize(new java.awt.Dimension(400, 110));
        pnlDadosExame.setPreferredSize(new java.awt.Dimension(400, 110));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblData.setText("Data:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setToolTipText("");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTipo.setText("Tipo:");

        lblPatologia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPatologia.setText("Patologia / Alvo : ");

        txtPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatologiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosExameLayout = new javax.swing.GroupLayout(pnlDadosExame);
        pnlDadosExame.setLayout(pnlDadosExameLayout);
        pnlDadosExameLayout.setHorizontalGroup(
            pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosExameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDadosExameLayout.createSequentialGroup()
                        .addComponent(lblPatologia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatologia))
                    .addGroup(pnlDadosExameLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        pnlDadosExameLayout.setVerticalGroup(
            pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosExameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosExameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPatologia)
                    .addComponent(txtPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 0));
        lblTitle.setText("Realização - Exames");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlResultados.setBackground(new java.awt.Color(248, 197, 190));
        pnlResultados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        javax.swing.GroupLayout pnlResultadosLayout = new javax.swing.GroupLayout(pnlResultados);
        pnlResultados.setLayout(pnlResultadosLayout);
        pnlResultadosLayout.setHorizontalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlResultadosLayout.setVerticalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pnlBotoes.setBackground(new java.awt.Color(248, 197, 190));

        btnConcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        btnGerarLaudo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGerarLaudo.setText("Gerar Laudo");
        btnGerarLaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarLaudoActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGerarLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerarLaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundColorLayout = new javax.swing.GroupLayout(pnlBackgroundColor);
        pnlBackgroundColor.setLayout(pnlBackgroundColorLayout);
        pnlBackgroundColorLayout.setHorizontalGroup(
            pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDadosExame, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        pnlBackgroundColorLayout.setVerticalGroup(
            pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundColorLayout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundColorLayout.createSequentialGroup()
                        .addComponent(pnlDadosPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlDadosExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatologiaActionPerformed

    private void txtTipoSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSanguineoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSanguineoActionPerformed

    private void txtConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConvenioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConvenioActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
//        Altera o status do exame para "Concluído"
        
        if(txtResultado.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário preencher o resultado antes de concluir!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else{
            for (Agendamento agendamentoAtualizado : database.getAgendamentos()) {
                System.out.println("Verificando agendamento: " + agendamentoAtualizado.getId()); // Debug do agendamento atual

                if(agendamentoAtualizado.getId() == idAgendamento){
                    for (int i = 0; i < agendamentoAtualizado.getListaExames().size(); i++) {
                        Exame exameAtual = agendamentoAtualizado.getListaExames().get(i);
                        System.out.println("Verificando vacina: " + exameAtual.getTipoExame() + " - Status: " + exameAtual.getStatus()); // Debug da vacina atual

                        if (exameAtual.getTipoExame().equals(exameRealizado.getTipoExame())) {
                            System.out.println("Vacina encontrada: " + exameRealizado.getTipoExame()); // Confirma que a vacina foi encontrada
                            exameRealizado.setStatus(true);
                            agendamentoAtualizado.getListaExames().set(i, exameRealizado);
                            System.out.println("Vacina atualizada: " + exameRealizado.getTipoExame() + " - Novo Status: " + exameRealizado.getStatus()); // Confirma que o status foi atualizado
                            database.atualizarAgendamento(agendamentoAtualizado);
                            System.out.println("Agendamento atualizado: " + agendamentoAtualizado.getId()); // Confirma que o agendamento foi atualizado no banco de dados
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaDemandas telaDemandas = null;
       
        try {
            telaDemandas = new telaDemandas();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(telaRealizarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(telaRealizarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        telaDemandas.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnGerarLaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarLaudoActionPerformed
//        Gera o laudo a partir do resultado escrito pelo enfermeiro
        
        if(txtResultado.getText().equals("")) {
        
            JOptionPane.showMessageDialog(null, "O campo de resultado deve ser preenchido!" , "Aviso", JOptionPane.WARNING_MESSAGE);
        
        } else {
        
            // gerando novo Laudo
            String info = txtResultado.getText();
            String nomeExame = exameRealizado.getSubtipo() + " - " + exameRealizado.getTipoExame();
            Laudo laudoAtual = new Laudo(
                    exameRealizado.getDataRealizacao(),
                    exameRealizado.getPacienteAssociado(),
                    exameRealizado.getEnfermeiroAssociado(),
                    info, nomeExame);
            
            
            templateLaudo resultado = new templateLaudo(laudoAtual);
            resultado.setVisible(true);
            
            
            String caminho =  "src/resultados/exames/" + idAgendamento + "_" + exameRealizado.getTipoExame() + "_" + formatarData(exameRealizado.getDataRealizacao()) + ".pdf";
            exportarJFrameParaPDF(resultado, Paths.get(System.getProperty("user.dir"), caminho).toString());
            try {
                Desktop.getDesktop().open(new File(caminho));
            } catch (IOException ex) {}

        }
    }//GEN-LAST:event_btnGerarLaudoActionPerformed

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
            java.util.logging.Logger.getLogger(telaRealizarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaRealizarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaRealizarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaRealizarExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaRealizarExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnGerarLaudo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConvenio;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPatologia;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoSanguineo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBackgroundColor;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlDadosExame;
    private javax.swing.JPanel pnlDadosPaciente;
    private javax.swing.JPanel pnlResultados;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTextField txtConvenio;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPatologia;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTipoSanguineo;
    // End of variables declaration//GEN-END:variables
}
