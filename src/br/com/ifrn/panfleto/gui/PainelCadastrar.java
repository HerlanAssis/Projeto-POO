/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrn.panfleto.gui;

import br.com.ifrn.panfleto.Ambiente;
import br.com.ifrn.panfleto.Contatos;
import br.com.ifrn.panfleto.Setor;
import br.com.ifrn.panfleto.cadastrar.Cadastrar;
import br.com.ifrn.panfleto.envento.Esporte;
import br.com.ifrn.panfleto.envento.Filme;
import br.com.ifrn.panfleto.envento.Peca;
import br.com.ifrn.panfleto.envento.Show;
import br.com.ifrn.panfleto.gerarpdf.PdfCreator;
import br.com.ifrn.panfleto.ingresso.Ingresso;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author herlan
 */
public class PainelCadastrar extends javax.swing.JFrame {

    /**
     * Creates new form PainelCadastrar
     */
    private Cadastrar cadastrar;
    private Esporte esporte;
    private Filme filme;
    private Peca peca;
    private Show show;
    private Date date;    
    private Ambiente ambiente;
    private Ingresso ingresso;
    private Setor setor;
    private Contatos contatos;

    //Possivél Implementação Manual para Validar Paineis
//    private boolean validarEsporte = true;
//    private boolean validarFilme = true;
//    private boolean validarPeca = true;
//    private boolean validarShow = true;
//    private boolean validarDetalheEvento = true;
//    private boolean validarAmbiente = true;
//    private boolean validarIngresso = true;
//    private boolean validarContato = true;
//    private boolean validarGerarPdf = true;

    public PainelCadastrar() {//Instanciando a classe principal cadastrar
        initComponents();
        this.setLocationRelativeTo(null);
        cadastrar = Cadastrar.getUniqueInstance();
    }
    
    
    private final int Esporte = 1;
    private final int Filme = 2;
    private final int Peca = 3;
    private final int Show = 4;
    private int variavelControle = 0;

    public JPanel getPainelPrincipal() {
        return PainelPrincipal;
    }

    public void mudarPainel(String x) {
        CardLayout layout = (CardLayout) PainelPrincipal.getLayout();
        layout.show(PainelPrincipal, x);
    }

    public void limparCampo(JTextArea jTextArea) {
        jTextArea.setText("");
    }

    public void limparText(JTextField jTextField) {
        jTextField.setText("");
    }

    public void controlePainelCadastrar() {
        comboxCadastrarEvento.setSelectedIndex(0);
        comboxGerarPdfEvento.setSelectedIndex(0);
    }

    public void setVariavelControle(int variavelControle) {
        this.variavelControle = variavelControle;
    }

    public void qualVoltar() {
        if (this.variavelControle == 1) {
            mudarPainel("painelEsporte");
        } else if (this.variavelControle == 2) {
            mudarPainel("painelFilme");
        } else if (this.variavelControle == 3) {
            mudarPainel("painelPeca");
        } else if (this.variavelControle == 4) {
            mudarPainel("painelShow");
        }
    }

    public boolean validarFormularioText(JTextArea jTextArea) {
        return !jTextArea.equals("");
    }

    public BaseColor corPagina() {
        if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Branco")) {
            return BaseColor.WHITE;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Preto")) {
            return BaseColor.BLACK;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Azul")) {
            return BaseColor.BLUE;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Cinza Escuro")) {
            return BaseColor.DARK_GRAY;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Cinza")) {
            return BaseColor.GRAY;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Cinza Claro")) {
            return BaseColor.LIGHT_GRAY;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Magenta")) {
            return BaseColor.MAGENTA;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Laranja")) {
            return BaseColor.ORANGE;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Rosa")) {
            return BaseColor.PINK;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Vermlho")) {
            return BaseColor.RED;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Amarero")) {
            return BaseColor.YELLOW;
        } else if (comboxSelecionarCorPainelGerarPdf.getSelectedItem().equals("Cyan")) {
            return BaseColor.CYAN;
        }

        return BaseColor.WHITE;
    }

    public Rectangle tamanhoDaPagina() {
        if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("A0")) {
            return new Rectangle(PageSize.A0);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("A1")) {
            return new Rectangle(PageSize.A1);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("A2")) {
            return new Rectangle(PageSize.A2);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("A3")) {
            return new Rectangle(PageSize.A3);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("A4")) {
            return new Rectangle(PageSize.A4);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("A5")) {
            return new Rectangle(PageSize.A5);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("B0")) {
            return new Rectangle(PageSize.B0);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("B1")) {
            return new Rectangle(PageSize.B1);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("B2")) {
            return new Rectangle(PageSize.B2);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("B3")) {
            return new Rectangle(PageSize.B3);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("B4")) {
            return new Rectangle(PageSize.B4);
        } else if (comboxSelecionarTamanhoPaginaPainelGerarPdf.getSelectedItem().equals("B5")) {
            return new Rectangle(PageSize.B5);
        }

        return new Rectangle(PageSize.A4);
    }

    public void gerarPdf() throws IOException, Exception {        
        cadastrar.setPdfCreator(new PdfCreator(tamanhoDaPagina(), corPagina()));

        if (comboxGerarPdfEvento.getSelectedItem().equals("Esporte")) {
            cadastrar.getPdfCreator().gerarPlanfletoEsporte(cadastrar.getEsporte().get(comboxListaEventoPDF.getSelectedIndex()));
        
        } else if (comboxGerarPdfEvento.getSelectedItem().equals("Filme")) {
            cadastrar.getPdfCreator().gerarPlanfletoFilme(cadastrar.getFilme().get(comboxListaEventoPDF.getSelectedIndex()));
        
        } else if (comboxGerarPdfEvento.getSelectedItem().equals("Peça")) {
            cadastrar.getPdfCreator().gerarPlanfletoPeca(cadastrar.getPeca().get(comboxListaEventoPDF.getSelectedIndex()));
        
        } else if (comboxGerarPdfEvento.getSelectedItem().equals("Show")) {
            cadastrar.getPdfCreator().gerarPlanfletoShow(cadastrar.getShow().get(comboxListaEventoPDF.getSelectedIndex()));
        }
    }

    public Esporte cadastrarEsporte() throws Exception {
        date = new Date(System.currentTimeMillis());
        //formatarData = new FormatarData();

        esporte = new Esporte();
//        ambiente = new Ambiente();
//        setor = new Setor();
//        contatos = new Contatos();
//        ingresso = new Ingresso();

        esporte.setNome(txtNomeEsporte.getText());
        esporte.setEquipe(campoCadastrarEquipeEsporte.getText());
        esporte.setDescricao(campoDescricaoAmbiente.getText());
        esporte.setSinopse(campoSinopseEvento.getText());
        esporte.setDataInclusao(date);

        if (cadastrar.validarData(formatedDataHoraEvento.getText())) {
            esporte.setDataEvento(cadastrar.stringToDate(formatedDataHoraEvento.getText()));
        }

        esporte.setDuracao(Integer.parseInt(txtDuracaoEvento.getText()));

//        ambiente.setNome(txtNomeAmbiente.getText());
//        ambiente.setDescricao(campoDescricaoAmbiente.getText());
//        ambiente.setEndereco(campoEnderecoAmbiente.getText());
//        ambiente.setProntoReferencia(txtPontoReferenciaAmbiente.getText());
//        setor.setNome(txtNomeSetorAmbiente.getText());
//        setor.setCapacidade(Integer.parseInt(txtCapacidadeSetorAmbiente.getText()));
//        ambiente.setSetor(setor);
//
//        ingresso.setMensagem(campoMensagemPromocaoIngresso.getText());
//        ingresso.setQuantidade(Integer.parseInt(txtQuantidadeIngressoEvento.getText()));
//        ingresso.setQuantidadeDisponivél(Integer.parseInt(txtQuantudadeDisponivelPromocaoIngresso.getText()));
//        ingresso.setValor(Double.parseDouble(txtValorIngressoEvento.getText()));
//        ingresso.setValorDeDesconto(Double.parseDouble(txtlValorDescontoPromocaoIngresso.getText()));
//
//        contatos.setNome(txtNomeContato.getText());
//        contatos.setEmail(txtEmailContato.getText());
//        contatos.setEndereco(campoEnderecoContato.getText());
//        contatos.setTelefone(txtTelefoneContato.getText());
        esporte.setAmbiente(getAmbiente());
        esporte.setContatos(getContato());
        esporte.setIngresso(getIngresso());

        return esporte;
    }

    public Filme cadastrarFilme() throws Exception {
        date = new Date(System.currentTimeMillis());
        //formatarData = new FormatarData();

        filme = new Filme();

        filme.setNome(txtNomeFilme.getText());
        filme.setGenero(txtGeneroFilme.getText());
        filme.setEstreia(txtEstreiaFilme.getText());
        filme.setCensura(Integer.parseInt(txtCensuraFilme.getText()));
        filme.setDescricao(campoDescricaoAmbiente.getText());
        filme.setSinopse(campoSinopseEvento.getText());
        filme.setDataInclusao(date);

        if (cadastrar.validarData(formatedDataHoraEvento.getText())) {
            filme.setDataEvento(cadastrar.stringToDate(formatedDataHoraEvento.getText()));
        }

        filme.setDuracao(Integer.parseInt(txtDuracaoEvento.getText()));

        filme.setAmbiente(getAmbiente());
        filme.setContatos(getContato());
        filme.setIngresso(getIngresso());

        return filme;
    }

    public Peca cadastrarPeca() throws Exception {
        date = new Date(System.currentTimeMillis());
        //formatarData = new FormatarData();

        peca = new Peca();

        peca.setNome(txtNomePeca.getText());
        peca.setGenero(txtGeneroPeca.getText());
        peca.setCompanhia(txtCompanhiaPeca.getText());
        peca.setCensura(Integer.parseInt(txtCensuraPeca.getText()));

        peca.setDescricao(campoDescricaoAmbiente.getText());
        peca.setSinopse(campoSinopseEvento.getText());
        peca.setDataInclusao(date);

        if (cadastrar.validarData(formatedDataHoraEvento.getText())) {
            peca.setDataEvento(cadastrar.stringToDate(formatedDataHoraEvento.getText()));
        }
        peca.setDuracao(Integer.parseInt(txtDuracaoEvento.getText()));

        peca.setAmbiente(getAmbiente());
        peca.setContatos(getContato());
        peca.setIngresso(getIngresso());

        return peca;
    }

    public Show cadastrarShow() throws Exception {
        date = new Date(System.currentTimeMillis());
        //formatarData = new FormatarData();

        show = new Show();
        show.setNome(txtNomeShow.getText());
        show.setEstilo(txtEstilhoShow.getText());
        show.setArtista(txtArtistaShow.getText());

        show.setDescricao(campoDescricaoAmbiente.getText());
        show.setSinopse(campoSinopseEvento.getText());
        show.setDataInclusao(date);

        if (cadastrar.validarData(formatedDataHoraEvento.getText())) {
            show.setDataEvento(cadastrar.stringToDate(formatedDataHoraEvento.getText()));
        }
        show.setDuracao(Integer.parseInt(txtDuracaoEvento.getText()));

        show.setAmbiente(getAmbiente());
        show.setContatos(getContato());
        show.setIngresso(getIngresso());

        return show;
    }

    public Ambiente getAmbiente() {
        ambiente = new Ambiente();
        setor = new Setor();

        ambiente.setNome(txtNomeAmbiente.getText());
        ambiente.setDescricao(campoDescricaoAmbiente.getText());
        ambiente.setEndereco(campoEnderecoAmbiente.getText());
        ambiente.setProntoReferencia(txtPontoReferenciaAmbiente.getText());
        setor.setNome(txtNomeSetorAmbiente.getText());
        setor.setCapacidade(Integer.parseInt(txtCapacidadeSetorAmbiente.getText()));
        ambiente.setSetor(setor);

        return ambiente;
    }

    public Contatos getContato() {
        contatos = new Contatos();

        contatos.setNome(txtNomeContato.getText());
        contatos.setEmail(txtEmailContato.getText());
        contatos.setEndereco(campoEnderecoContato.getText());
        contatos.setTelefone(txtTelefoneContato.getText());

        return contatos;
    }

    public Ingresso getIngresso() {
        ingresso = new Ingresso();

        ingresso.setMensagem(campoMensagemPromocaoIngresso.getText());
        ingresso.setQuantidade(Integer.parseInt(txtQuantidadeIngressoEvento.getText()));
        ingresso.setQuantidadeDisponivél(Integer.parseInt(txtQuantudadeDisponivelPromocaoIngresso.getText()));
        ingresso.setValor(Double.parseDouble(txtValorIngressoEvento.getText()));
        ingresso.setValorDeDesconto(Double.parseDouble(txtlValorDescontoPromocaoIngresso.getText()));

        return ingresso;
    }

//    public void cadastrar() throws Exception {
//        cadastrar.cadastrarEsporte(cadastrarEsporte());
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelPrincipal = new javax.swing.JPanel();
        painelCadastrar = new javax.swing.JPanel();
        labelCadastrarEvento = new javax.swing.JLabel();
        comboxCadastrarEvento = new javax.swing.JComboBox();
        labelGerarPdfCadastrar = new javax.swing.JLabel();
        comboxGerarPdfEvento = new javax.swing.JComboBox();
        btnGerarPdfOk = new javax.swing.JButton();
        btnCadastrarEventoOk = new javax.swing.JButton();
        painelEsporte = new javax.swing.JPanel();
        labelNomeEsporte = new javax.swing.JLabel();
        btnAvançarEsporte = new javax.swing.JButton();
        txtNomeEsporte = new javax.swing.JTextField();
        labelEquipeEsporte = new javax.swing.JLabel();
        btnVoltarEsporte = new javax.swing.JButton();
        labelTituloCadastrarEsporte = new javax.swing.JLabel();
        cadastrarEquipeEsporteScroll1 = new javax.swing.JScrollPane();
        campoCadastrarEquipeEsporte = new javax.swing.JTextArea();
        painelFilme = new javax.swing.JPanel();
        labelCadastrarFilme = new javax.swing.JLabel();
        labelNomeFilme = new javax.swing.JLabel();
        labelGeneroFilme = new javax.swing.JLabel();
        labelCensuraFilme = new javax.swing.JLabel();
        txtCensuraFilme = new javax.swing.JTextField();
        txtGeneroFilme = new javax.swing.JTextField();
        txtNomeFilme = new javax.swing.JTextField();
        btnVoltarFilme = new javax.swing.JButton();
        btnAvançarFilme = new javax.swing.JButton();
        labelEstreiaFilme = new javax.swing.JLabel();
        txtEstreiaFilme = new javax.swing.JTextField();
        painelShow = new javax.swing.JPanel();
        btnVoltarShow = new javax.swing.JButton();
        btnAvançarShow = new javax.swing.JButton();
        labelCadastrarShow = new javax.swing.JLabel();
        labelNomeShow = new javax.swing.JLabel();
        txtNomeShow = new javax.swing.JTextField();
        txtArtistaShow = new javax.swing.JTextField();
        labelArtistaShow = new javax.swing.JLabel();
        labelEstiloShow = new javax.swing.JLabel();
        txtEstilhoShow = new javax.swing.JTextField();
        painelPeca = new javax.swing.JPanel();
        labelCadastrarPeca = new javax.swing.JLabel();
        labelNomePeca = new javax.swing.JLabel();
        labelCompanhiaPeca = new javax.swing.JLabel();
        labelGeneroPeca = new javax.swing.JLabel();
        labelCensuraPeca = new javax.swing.JLabel();
        txtCensuraPeca = new javax.swing.JTextField();
        txtGeneroPeca = new javax.swing.JTextField();
        txtCompanhiaPeca = new javax.swing.JTextField();
        btnVoltarPeca = new javax.swing.JButton();
        btnAvançarPeca = new javax.swing.JButton();
        txtNomePeca = new javax.swing.JTextField();
        painelDetalheEvento = new javax.swing.JPanel();
        labelDetalhesEvento = new javax.swing.JLabel();
        labelSinopseEvento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoSinopseEvento = new javax.swing.JTextArea();
        labelDescricaoEvento = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        campoDescricaoEvento = new javax.swing.JTextArea();
        btnVoltarAmbiente2 = new javax.swing.JButton();
        btnAvançarAmbiente2 = new javax.swing.JButton();
        labelDuracaoEvento = new javax.swing.JLabel();
        labelDataHoraEvento = new javax.swing.JLabel();
        txtDuracaoEvento = new javax.swing.JTextField();
        formatedDataHoraEvento = new javax.swing.JFormattedTextField();
        painelAmbiente = new javax.swing.JPanel();
        labelCadastrarAmbiente = new javax.swing.JLabel();
        labelNomeAmbiente = new javax.swing.JLabel();
        txtNomeAmbiente = new javax.swing.JTextField();
        labelDescricaoAmbiente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricaoAmbiente = new javax.swing.JTextArea();
        labelPontoReferenciaAmbiente = new javax.swing.JLabel();
        txtPontoReferenciaAmbiente = new javax.swing.JTextField();
        txtNomeSetorAmbiente = new javax.swing.JTextField();
        labelSetorAmbiente = new javax.swing.JLabel();
        txtCapacidadeSetorAmbiente = new javax.swing.JTextField();
        labelCapacidadeAmbiente = new javax.swing.JLabel();
        btnAvançarAmbiente = new javax.swing.JButton();
        btnVoltarAmbiente = new javax.swing.JButton();
        labelEnderecoAmbiente = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        campoEnderecoAmbiente = new javax.swing.JTextArea();
        painelngresso = new javax.swing.JPanel();
        labelngressoEvento = new javax.swing.JLabel();
        labelValorIngresso = new javax.swing.JLabel();
        labelQuantidadeIngresso = new javax.swing.JLabel();
        labelPromocaoIngresso = new javax.swing.JLabel();
        labelMensagemIngressoPromocao = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        campoMensagemPromocaoIngresso = new javax.swing.JTextArea();
        txtQuantidadeIngressoEvento = new javax.swing.JTextField();
        txtValorIngressoEvento = new javax.swing.JTextField();
        labelQuantidadeDisponivelPromocaoIngresso = new javax.swing.JLabel();
        txtQuantudadeDisponivelPromocaoIngresso = new javax.swing.JTextField();
        txtlValorDescontoPromocaoIngresso = new javax.swing.JTextField();
        labelValorDescontoPromocaoIngresso = new javax.swing.JLabel();
        btnVoltarIngressoEvento = new javax.swing.JButton();
        btnAvançarIngressoEvento = new javax.swing.JButton();
        painelContato = new javax.swing.JPanel();
        labelContatoEvento = new javax.swing.JLabel();
        labelNomeContato = new javax.swing.JLabel();
        labelTelefoneContato = new javax.swing.JLabel();
        labelEmailContato = new javax.swing.JLabel();
        labelEnderecoContato = new javax.swing.JLabel();
        txtEmailContato = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        campoEnderecoContato = new javax.swing.JTextArea();
        txtTelefoneContato = new javax.swing.JTextField();
        txtNomeContato = new javax.swing.JTextField();
        btnVoltarContato = new javax.swing.JButton();
        btnConcluirContato = new javax.swing.JButton();
        painelGerarPdf = new javax.swing.JPanel();
        comboxListaEventoPDF = new javax.swing.JComboBox();
        btnMenuPrincipalGerarPdf = new javax.swing.JButton();
        comboxSelecionarTamanhoPaginaPainelGerarPdf = new javax.swing.JComboBox();
        comboxSelecionarCorPainelGerarPdf = new javax.swing.JComboBox();
        btnGerarPdfPainelGerarPdf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        painelSobre = new javax.swing.JPanel();
        labelComponenteSobre = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        campoComponenteSobre = new javax.swing.JTextArea();
        labelAgradecimentosSobre = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        campoAgradecimentoSobre = new javax.swing.JTextArea();
        labelSobreSoftwareSobre = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        campoSobreSofwareSobre = new javax.swing.JTextArea();
        btnSobreMenuPrincipal = new javax.swing.JButton();
        menuPainelCadastrar = new javax.swing.JMenuBar();
        subMenuPainelCadastrar = new javax.swing.JMenu();
        itemMenuPrincipalArquivoSubMenuPainelCadastrar = new javax.swing.JMenuItem();
        itemAbrirPastaSubMenuPainelCadastrar = new javax.swing.JMenuItem();
        itemSairSubMenuPainelCadastrar = new javax.swing.JMenuItem();
        subMenuPainelSobre = new javax.swing.JMenu();
        itemSobreSubMenuPainelCadastrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PainelPrincipal.setLayout(new java.awt.CardLayout());

        labelCadastrarEvento.setText("Cadastrar Evento");

        comboxCadastrarEvento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Esporte", "Filme", "Peça", "Show" }));
        comboxCadastrarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxCadastrarEventoActionPerformed(evt);
            }
        });

        labelGerarPdfCadastrar.setText("Gerar PDF");

        comboxGerarPdfEvento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Esporte", "Filme", "Peça", "Show" }));

        btnGerarPdfOk.setText("OK");
        btnGerarPdfOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarPdfOkActionPerformed(evt);
            }
        });

        btnCadastrarEventoOk.setText("OK");
        btnCadastrarEventoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEventoOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCadastrarLayout = new javax.swing.GroupLayout(painelCadastrar);
        painelCadastrar.setLayout(painelCadastrarLayout);
        painelCadastrarLayout.setHorizontalGroup(
            painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
            .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCadastrarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelGerarPdfCadastrar)
                        .addGroup(painelCadastrarLayout.createSequentialGroup()
                            .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelCadastrarEvento)
                                .addComponent(comboxCadastrarEvento, 0, 191, Short.MAX_VALUE)
                                .addComponent(comboxGerarPdfEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(29, 29, 29)
                            .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCadastrarEventoOk)
                                .addComponent(btnGerarPdfOk))))
                    .addContainerGap(477, Short.MAX_VALUE)))
        );
        painelCadastrarLayout.setVerticalGroup(
            painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
            .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCadastrarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelCadastrarEvento)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboxCadastrarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastrarEventoOk))
                    .addGap(65, 65, 65)
                    .addComponent(labelGerarPdfCadastrar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(painelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboxGerarPdfEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGerarPdfOk))
                    .addContainerGap(292, Short.MAX_VALUE)))
        );

        PainelPrincipal.add(painelCadastrar, "painelCadastrar");

        labelNomeEsporte.setText("Nome: ");

        btnAvançarEsporte.setText("Avançar");
        btnAvançarEsporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarEsporteActionPerformed(evt);
            }
        });

        txtNomeEsporte.setText("Digite o nome da equipe: ");
        txtNomeEsporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeEsporteMouseClicked(evt);
            }
        });

        labelEquipeEsporte.setText("Equipe: ");

        btnVoltarEsporte.setText("Voltar");
        btnVoltarEsporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarEsporteActionPerformed(evt);
            }
        });

        labelTituloCadastrarEsporte.setText("Cadastrar Esporte");

        campoCadastrarEquipeEsporte.setColumns(20);
        campoCadastrarEquipeEsporte.setRows(5);
        campoCadastrarEquipeEsporte.setText("Digite o nome dos mebros da equipe sepadados por \";\"");
        campoCadastrarEquipeEsporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCadastrarEquipeEsporteMouseClicked(evt);
            }
        });
        cadastrarEquipeEsporteScroll1.setViewportView(campoCadastrarEquipeEsporte);

        javax.swing.GroupLayout painelEsporteLayout = new javax.swing.GroupLayout(painelEsporte);
        painelEsporte.setLayout(painelEsporteLayout);
        painelEsporteLayout.setHorizontalGroup(
            painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsporteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltarEsporte))
                    .addGroup(painelEsporteLayout.createSequentialGroup()
                        .addGroup(painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTituloCadastrarEsporte)
                            .addGroup(painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(painelEsporteLayout.createSequentialGroup()
                                    .addComponent(labelNomeEsporte)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNomeEsporte))
                                .addGroup(painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEquipeEsporte)
                                    .addComponent(cadastrarEquipeEsporteScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 196, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAvançarEsporte)
                .addContainerGap())
        );
        painelEsporteLayout.setVerticalGroup(
            painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEsporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloCadastrarEsporte)
                .addGap(18, 18, 18)
                .addGroup(painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeEsporte)
                    .addComponent(txtNomeEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(labelEquipeEsporte)
                .addGap(18, 18, 18)
                .addComponent(cadastrarEquipeEsporteScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsporteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelEsporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarEsporte)
                    .addComponent(btnAvançarEsporte))
                .addContainerGap())
        );

        PainelPrincipal.add(painelEsporte, "painelEsporte");

        labelCadastrarFilme.setText("Cadastrar Filme");

        labelNomeFilme.setText("Nome: ");

        labelGeneroFilme.setText("Genêro: ");

        labelCensuraFilme.setText("Censura: ");

        txtCensuraFilme.setText("Censura do filme: ");
        txtCensuraFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCensuraFilmeMouseClicked(evt);
            }
        });

        txtGeneroFilme.setText("Genêro do filme:");
        txtGeneroFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGeneroFilmeMouseClicked(evt);
            }
        });

        txtNomeFilme.setText("Nome do filme: ");
        txtNomeFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeFilmeMouseClicked(evt);
            }
        });

        btnVoltarFilme.setText("Voltar");
        btnVoltarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarFilmeActionPerformed(evt);
            }
        });

        btnAvançarFilme.setText("Avançar");
        btnAvançarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarFilmeActionPerformed(evt);
            }
        });

        labelEstreiaFilme.setText("Estreia: ");

        txtEstreiaFilme.setText("Digite o dia de estreia");
        txtEstreiaFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEstreiaFilmeMouseClicked(evt);
            }
        });
        txtEstreiaFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstreiaFilmeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFilmeLayout = new javax.swing.GroupLayout(painelFilme);
        painelFilme.setLayout(painelFilmeLayout);
        painelFilmeLayout.setHorizontalGroup(
            painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFilmeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFilmeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltarFilme)
                        .addGap(18, 18, 18)
                        .addComponent(btnAvançarFilme))
                    .addGroup(painelFilmeLayout.createSequentialGroup()
                        .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelFilmeLayout.createSequentialGroup()
                                .addComponent(labelCensuraFilme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCensuraFilme))
                            .addComponent(labelCadastrarFilme)
                            .addGroup(painelFilmeLayout.createSequentialGroup()
                                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelGeneroFilme)
                                    .addComponent(labelNomeFilme))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGeneroFilme)))
                            .addGroup(painelFilmeLayout.createSequentialGroup()
                                .addComponent(labelEstreiaFilme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstreiaFilme)))
                        .addGap(0, 451, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelFilmeLayout.setVerticalGroup(
            painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFilmeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCadastrarFilme)
                .addGap(18, 18, 18)
                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeFilme)
                    .addComponent(txtNomeFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGeneroFilme)
                    .addComponent(txtGeneroFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCensuraFilme)
                    .addComponent(txtCensuraFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstreiaFilme)
                    .addComponent(txtEstreiaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(painelFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvançarFilme)
                    .addComponent(btnVoltarFilme))
                .addContainerGap())
        );

        PainelPrincipal.add(painelFilme, "painelFilme");

        btnVoltarShow.setText("Voltar");
        btnVoltarShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarShowActionPerformed(evt);
            }
        });

        btnAvançarShow.setText("Avançar");
        btnAvançarShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarShowActionPerformed(evt);
            }
        });

        labelCadastrarShow.setText("Cadastrar Show");

        labelNomeShow.setText("Nome: ");

        txtNomeShow.setText("Nome Show: ");
        txtNomeShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeShowMouseClicked(evt);
            }
        });
        txtNomeShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeShowActionPerformed(evt);
            }
        });

        txtArtistaShow.setText("Nome Artista: ");
        txtArtistaShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtArtistaShowMouseClicked(evt);
            }
        });
        txtArtistaShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtistaShowActionPerformed(evt);
            }
        });

        labelArtistaShow.setText("Artista: ");

        labelEstiloShow.setText("Estilo: ");

        txtEstilhoShow.setText("Estilo Show: ");
        txtEstilhoShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEstilhoShowMouseClicked(evt);
            }
        });
        txtEstilhoShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstilhoShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelShowLayout = new javax.swing.GroupLayout(painelShow);
        painelShow.setLayout(painelShowLayout);
        painelShowLayout.setHorizontalGroup(
            painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelShowLayout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addComponent(btnVoltarShow)
                .addGap(18, 18, 18)
                .addComponent(btnAvançarShow)
                .addContainerGap())
            .addGroup(painelShowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelShowLayout.createSequentialGroup()
                        .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomeShow)
                            .addComponent(labelArtistaShow)
                            .addComponent(labelEstiloShow))
                        .addGap(20, 20, 20)
                        .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeShow)
                            .addComponent(txtArtistaShow, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtEstilhoShow)))
                    .addComponent(labelCadastrarShow))
                .addContainerGap(481, Short.MAX_VALUE))
        );
        painelShowLayout.setVerticalGroup(
            painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCadastrarShow)
                .addGap(18, 18, 18)
                .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeShow)
                    .addComponent(txtNomeShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArtistaShow)
                    .addComponent(txtArtistaShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstiloShow)
                    .addComponent(txtEstilhoShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addGroup(painelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvançarShow)
                    .addComponent(btnVoltarShow))
                .addContainerGap())
        );

        PainelPrincipal.add(painelShow, "painelShow");

        labelCadastrarPeca.setText("Cadastrar Peça");

        labelNomePeca.setText("Nome: ");

        labelCompanhiaPeca.setText("Companhia: ");

        labelGeneroPeca.setText("Genêro: ");

        labelCensuraPeca.setText("Censura: ");

        txtCensuraPeca.setText("Censura da pela: ");
        txtCensuraPeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCensuraPecaMouseClicked(evt);
            }
        });

        txtGeneroPeca.setText("Genêro da peça: ");
        txtGeneroPeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGeneroPecaMouseClicked(evt);
            }
        });

        txtCompanhiaPeca.setText("Companhia da peça: ");
        txtCompanhiaPeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCompanhiaPecaMouseClicked(evt);
            }
        });

        btnVoltarPeca.setText("Voltar");
        btnVoltarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarPecaActionPerformed(evt);
            }
        });

        btnAvançarPeca.setText("Avançar");
        btnAvançarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarPecaActionPerformed(evt);
            }
        });

        txtNomePeca.setText("Companhia da peça: ");
        txtNomePeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomePecaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelPecaLayout = new javax.swing.GroupLayout(painelPeca);
        painelPeca.setLayout(painelPecaLayout);
        painelPecaLayout.setHorizontalGroup(
            painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPecaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCadastrarPeca)
                    .addGroup(painelPecaLayout.createSequentialGroup()
                        .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCompanhiaPeca)
                            .addComponent(labelGeneroPeca)
                            .addComponent(labelCensuraPeca)
                            .addComponent(labelNomePeca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCompanhiaPeca, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtGeneroPeca)
                            .addComponent(txtCensuraPeca)
                            .addComponent(txtNomePeca, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
                .addContainerGap(470, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPecaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltarPeca)
                .addGap(18, 18, 18)
                .addComponent(btnAvançarPeca)
                .addContainerGap())
        );
        painelPecaLayout.setVerticalGroup(
            painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCadastrarPeca)
                .addGap(18, 18, 18)
                .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomePeca)
                    .addComponent(txtNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCompanhiaPeca)
                    .addComponent(txtCompanhiaPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGeneroPeca)
                    .addComponent(txtGeneroPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCensuraPeca)
                    .addComponent(txtCensuraPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addGroup(painelPecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvançarPeca)
                    .addComponent(btnVoltarPeca))
                .addContainerGap())
        );

        PainelPrincipal.add(painelPeca, "painelPeca");

        labelDetalhesEvento.setText("Detalhes do Evento");

        labelSinopseEvento.setText("Sinospse: ");

        campoSinopseEvento.setColumns(20);
        campoSinopseEvento.setRows(5);
        campoSinopseEvento.setText("Digite aqui a sinopse");
        campoSinopseEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoSinopseEventoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(campoSinopseEvento);

        labelDescricaoEvento.setText("Descrição: ");

        campoDescricaoEvento.setColumns(20);
        campoDescricaoEvento.setRows(5);
        campoDescricaoEvento.setText("Digite aqui a descrição");
        campoDescricaoEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoDescricaoEventoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(campoDescricaoEvento);

        btnVoltarAmbiente2.setText("Voltar");
        btnVoltarAmbiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarAmbiente2ActionPerformed(evt);
            }
        });

        btnAvançarAmbiente2.setText("Avançar");
        btnAvançarAmbiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarAmbiente2ActionPerformed(evt);
            }
        });

        labelDuracaoEvento.setText("Duração: ");

        labelDataHoraEvento.setText("Data e Hora do Evento:");

        txtDuracaoEvento.setText("Duração do evento");
        txtDuracaoEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDuracaoEventoMouseClicked(evt);
            }
        });

        try {
            formatedDataHoraEvento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatedDataHoraEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatedDataHoraEventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDetalheEventoLayout = new javax.swing.GroupLayout(painelDetalheEvento);
        painelDetalheEvento.setLayout(painelDetalheEventoLayout);
        painelDetalheEventoLayout.setHorizontalGroup(
            painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDetalheEventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(labelDetalhesEvento)
                    .addComponent(labelDescricaoEvento)
                    .addComponent(labelSinopseEvento)
                    .addComponent(jScrollPane3))
                .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDetalheEventoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDuracaoEvento)
                            .addComponent(labelDataHoraEvento)))
                    .addGroup(painelDetalheEventoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDuracaoEvento))
                    .addGroup(painelDetalheEventoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(formatedDataHoraEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDetalheEventoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltarAmbiente2)
                .addGap(18, 18, 18)
                .addComponent(btnAvançarAmbiente2)
                .addContainerGap())
        );
        painelDetalheEventoLayout.setVerticalGroup(
            painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDetalheEventoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(labelDetalhesEvento)
                .addGap(18, 18, 18)
                .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSinopseEvento)
                    .addComponent(labelDuracaoEvento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDetalheEventoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDescricaoEvento)
                            .addComponent(labelDataHoraEvento)))
                    .addComponent(txtDuracaoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatedDataHoraEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelDetalheEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvançarAmbiente2)
                    .addComponent(btnVoltarAmbiente2))
                .addContainerGap())
        );

        PainelPrincipal.add(painelDetalheEvento, "painelDetalheEvento");

        labelCadastrarAmbiente.setText("Cadastrar Ambiente");

        labelNomeAmbiente.setText("Nome Ambiente: ");

        txtNomeAmbiente.setText("Nome do Ambiente: ");
        txtNomeAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeAmbienteMouseClicked(evt);
            }
        });

        labelDescricaoAmbiente.setText("Descrição: ");

        campoDescricaoAmbiente.setColumns(20);
        campoDescricaoAmbiente.setRows(5);
        campoDescricaoAmbiente.setText("Digite aqui os detalhes do ambiente");
        campoDescricaoAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoDescricaoAmbienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(campoDescricaoAmbiente);

        labelPontoReferenciaAmbiente.setText("Ponto de Referência: ");

        txtPontoReferenciaAmbiente.setText("Ponto de Referência: ");
        txtPontoReferenciaAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPontoReferenciaAmbienteMouseClicked(evt);
            }
        });

        txtNomeSetorAmbiente.setText("Nome do Setor:");
        txtNomeSetorAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeSetorAmbienteMouseClicked(evt);
            }
        });

        labelSetorAmbiente.setText("Setor: ");

        txtCapacidadeSetorAmbiente.setText("Capacidade: ");
        txtCapacidadeSetorAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCapacidadeSetorAmbienteMouseClicked(evt);
            }
        });

        labelCapacidadeAmbiente.setText("Capacidade: ");

        btnAvançarAmbiente.setText("Avançar");
        btnAvançarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarAmbienteActionPerformed(evt);
            }
        });

        btnVoltarAmbiente.setText("Voltar");
        btnVoltarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarAmbienteActionPerformed(evt);
            }
        });

        labelEnderecoAmbiente.setText("Endereço: ");

        campoEnderecoAmbiente.setColumns(20);
        campoEnderecoAmbiente.setRows(5);
        campoEnderecoAmbiente.setText("Endereço do ambiente: ");
        campoEnderecoAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEnderecoAmbienteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(campoEnderecoAmbiente);

        javax.swing.GroupLayout painelAmbienteLayout = new javax.swing.GroupLayout(painelAmbiente);
        painelAmbiente.setLayout(painelAmbienteLayout);
        painelAmbienteLayout.setHorizontalGroup(
            painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAmbienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAmbienteLayout.createSequentialGroup()
                        .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(painelAmbienteLayout.createSequentialGroup()
                                .addComponent(labelPontoReferenciaAmbiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPontoReferenciaAmbiente))
                            .addGroup(painelAmbienteLayout.createSequentialGroup()
                                .addComponent(labelNomeAmbiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeAmbiente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAmbienteLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVoltarAmbiente)
                                .addGap(18, 18, 18)
                                .addComponent(btnAvançarAmbiente))
                            .addGroup(painelAmbienteLayout.createSequentialGroup()
                                .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDescricaoAmbiente)
                                    .addComponent(labelCadastrarAmbiente)
                                    .addComponent(labelEnderecoAmbiente))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(painelAmbienteLayout.createSequentialGroup()
                        .addComponent(labelSetorAmbiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeSetorAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCapacidadeAmbiente)
                        .addGap(6, 6, 6)
                        .addComponent(txtCapacidadeSetorAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 387, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)))
        );
        painelAmbienteLayout.setVerticalGroup(
            painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAmbienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCadastrarAmbiente)
                .addGap(18, 18, 18)
                .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeAmbiente)
                    .addComponent(txtNomeAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelDescricaoAmbiente)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPontoReferenciaAmbiente)
                    .addComponent(txtPontoReferenciaAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSetorAmbiente)
                    .addComponent(labelCapacidadeAmbiente)
                    .addComponent(txtNomeSetorAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapacidadeSetorAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelEnderecoAmbiente)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(painelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvançarAmbiente)
                    .addComponent(btnVoltarAmbiente))
                .addContainerGap())
        );

        PainelPrincipal.add(painelAmbiente, "painelAmbiente");

        labelngressoEvento.setText("Ingresso");

        labelValorIngresso.setText("Valor: ");

        labelQuantidadeIngresso.setText("Quantidade: ");

        labelPromocaoIngresso.setText("Promoção");

        labelMensagemIngressoPromocao.setText("Mensagem: ");

        campoMensagemPromocaoIngresso.setColumns(20);
        campoMensagemPromocaoIngresso.setRows(5);
        campoMensagemPromocaoIngresso.setText("Mensagem Promocional");
        campoMensagemPromocaoIngresso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMensagemPromocaoIngressoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(campoMensagemPromocaoIngresso);

        txtQuantidadeIngressoEvento.setText("Quantidade: ");
        txtQuantidadeIngressoEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantidadeIngressoEventoMouseClicked(evt);
            }
        });

        txtValorIngressoEvento.setText("Valor: ");
        txtValorIngressoEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtValorIngressoEventoMouseClicked(evt);
            }
        });

        labelQuantidadeDisponivelPromocaoIngresso.setText("Quantidade Disponivél: ");

        txtQuantudadeDisponivelPromocaoIngresso.setText("Quantidade Disponivél");
        txtQuantudadeDisponivelPromocaoIngresso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantudadeDisponivelPromocaoIngressoMouseClicked(evt);
            }
        });

        txtlValorDescontoPromocaoIngresso.setText("Valor de Desconto");
        txtlValorDescontoPromocaoIngresso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtlValorDescontoPromocaoIngressoMouseClicked(evt);
            }
        });

        labelValorDescontoPromocaoIngresso.setText("Valor de Desconto: ");

        btnVoltarIngressoEvento.setText("Voltar");
        btnVoltarIngressoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarIngressoEventoActionPerformed(evt);
            }
        });

        btnAvançarIngressoEvento.setText("Avançar");
        btnAvançarIngressoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvançarIngressoEventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelngressoLayout = new javax.swing.GroupLayout(painelngresso);
        painelngresso.setLayout(painelngressoLayout);
        painelngressoLayout.setHorizontalGroup(
            painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelngressoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelngressoLayout.createSequentialGroup()
                        .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMensagemIngressoPromocao)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelValorDescontoPromocaoIngresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtlValorDescontoPromocaoIngresso)
                            .addComponent(txtQuantudadeDisponivelPromocaoIngresso)
                            .addComponent(labelQuantidadeDisponivelPromocaoIngresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(124, 124, 124))
                    .addGroup(painelngressoLayout.createSequentialGroup()
                        .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelngressoLayout.createSequentialGroup()
                                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelValorIngresso)
                                    .addComponent(labelQuantidadeIngresso))
                                .addGap(31, 31, 31)
                                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtQuantidadeIngressoEvento)
                                    .addComponent(txtValorIngressoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelngressoEvento)
                            .addComponent(labelPromocaoIngresso))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelngressoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltarIngressoEvento)
                .addGap(18, 18, 18)
                .addComponent(btnAvançarIngressoEvento)
                .addContainerGap())
        );
        painelngressoLayout.setVerticalGroup(
            painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelngressoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelngressoEvento)
                .addGap(18, 18, 18)
                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelValorIngresso)
                    .addComponent(txtValorIngressoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantidadeIngresso)
                    .addComponent(txtQuantidadeIngressoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelPromocaoIngresso)
                .addGap(18, 18, 18)
                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMensagemIngressoPromocao)
                    .addComponent(labelQuantidadeDisponivelPromocaoIngresso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelngressoLayout.createSequentialGroup()
                        .addComponent(txtQuantudadeDisponivelPromocaoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelValorDescontoPromocaoIngresso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtlValorDescontoPromocaoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelngressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvançarIngressoEvento)
                    .addComponent(btnVoltarIngressoEvento))
                .addContainerGap())
        );

        PainelPrincipal.add(painelngresso, "painelIngresso");

        labelContatoEvento.setText("Contato");

        labelNomeContato.setText("Nome: ");

        labelTelefoneContato.setText("Telefone: ");

        labelEmailContato.setText("Email: ");

        labelEnderecoContato.setText("Endereço: ");

        txtEmailContato.setText("Email: ");
        txtEmailContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailContatoMouseClicked(evt);
            }
        });

        campoEnderecoContato.setColumns(20);
        campoEnderecoContato.setRows(5);
        campoEnderecoContato.setText("Exemp: Avenida Deputado Patricio de Figuererdo Neto, 469 - Cascalho, CEP: 59965000 - Alexandria/RN");
        campoEnderecoContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEnderecoContatoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(campoEnderecoContato);

        txtTelefoneContato.setText("Telefone: ");
        txtTelefoneContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefoneContatoMouseClicked(evt);
            }
        });

        txtNomeContato.setText("Nome: ");
        txtNomeContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeContatoMouseClicked(evt);
            }
        });

        btnVoltarContato.setText("Voltar");
        btnVoltarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarContatoActionPerformed(evt);
            }
        });

        btnConcluirContato.setText("Concluir");
        btnConcluirContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelContatoLayout = new javax.swing.GroupLayout(painelContato);
        painelContato.setLayout(painelContatoLayout);
        painelContatoLayout.setHorizontalGroup(
            painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelContatoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltarContato)
                        .addGap(18, 18, 18)
                        .addComponent(btnConcluirContato))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addGroup(painelContatoLayout.createSequentialGroup()
                        .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTelefoneContato)
                            .addComponent(labelEmailContato))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmailContato)
                            .addComponent(txtTelefoneContato, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)))
                    .addGroup(painelContatoLayout.createSequentialGroup()
                        .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEnderecoContato)
                            .addComponent(labelContatoEvento))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelContatoLayout.createSequentialGroup()
                        .addComponent(labelNomeContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelContatoLayout.setVerticalGroup(
            painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelContatoEvento)
                .addGap(18, 18, 18)
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeContato)
                    .addComponent(txtNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefoneContato)
                    .addComponent(txtTelefoneContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmailContato)
                    .addComponent(txtEmailContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelEnderecoContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluirContato)
                    .addComponent(btnVoltarContato))
                .addContainerGap())
        );

        PainelPrincipal.add(painelContato, "painelContato");

        comboxListaEventoPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxListaEventoPDFActionPerformed(evt);
            }
        });

        btnMenuPrincipalGerarPdf.setText("Menu Principal");
        btnMenuPrincipalGerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalGerarPdfActionPerformed(evt);
            }
        });

        comboxSelecionarTamanhoPaginaPainelGerarPdf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A0", "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5" }));

        comboxSelecionarCorPainelGerarPdf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branco", "Preto", "Azul", "Cinza Escuro", "Cinza", "Cinza Claro", "Magenta", "Laranja", "Rosa", "Vermelho", "Amarelo", "Cyan" }));

        btnGerarPdfPainelGerarPdf.setText("Gerar PDF!");
        btnGerarPdfPainelGerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarPdfPainelGerarPdfActionPerformed(evt);
            }
        });

        jLabel1.setText("Tamanho da Página: ");

        jLabel2.setText("Cor: ");

        jLabel3.setText("Evento/Data Inclusão: ");

        javax.swing.GroupLayout painelGerarPdfLayout = new javax.swing.GroupLayout(painelGerarPdf);
        painelGerarPdf.setLayout(painelGerarPdfLayout);
        painelGerarPdfLayout.setHorizontalGroup(
            painelGerarPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGerarPdfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelGerarPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelGerarPdfLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMenuPrincipalGerarPdf))
                    .addGroup(painelGerarPdfLayout.createSequentialGroup()
                        .addGroup(painelGerarPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboxSelecionarTamanhoPaginaPainelGerarPdf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboxSelecionarCorPainelGerarPdf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelGerarPdfLayout.createSequentialGroup()
                                .addGroup(painelGerarPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 380, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addComponent(btnGerarPdfPainelGerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelGerarPdfLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboxListaEventoPDF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelGerarPdfLayout.setVerticalGroup(
            painelGerarPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGerarPdfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelGerarPdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelGerarPdfLayout.createSequentialGroup()
                        .addComponent(btnGerarPdfPainelGerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenuPrincipalGerarPdf))
                    .addGroup(painelGerarPdfLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboxSelecionarTamanhoPaginaPainelGerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboxSelecionarCorPainelGerarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboxListaEventoPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 254, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PainelPrincipal.add(painelGerarPdf, "painelGerarPdf");

        labelComponenteSobre.setText("Componentes: ");

        campoComponenteSobre.setEditable(false);
        campoComponenteSobre.setColumns(20);
        campoComponenteSobre.setRows(5);
        campoComponenteSobre.setText("Herlan Assis Pereira da Silva - Aluno do 2º Período de Análise e Desenvolvimento de Sistemas.\n\nFranklin Venâncio da Silva Rocha - Aluno do 2º Período de Análise e Desenvolvimento de Sistemas.");
        jScrollPane7.setViewportView(campoComponenteSobre);

        labelAgradecimentosSobre.setText("Agradecimentos: ");

        campoAgradecimentoSobre.setEditable(false);
        campoAgradecimentoSobre.setColumns(20);
        campoAgradecimentoSobre.setRows(5);
        campoAgradecimentoSobre.setText("Agradecemos a todos os professores do Curso Superior de Análise e Deselvolvimento pela sua ajuda e dedicação\nem nos ensinar a \"arte da criação\".");
        jScrollPane8.setViewportView(campoAgradecimentoSobre);

        labelSobreSoftwareSobre.setText("Sobre o software: ");

        campoSobreSofwareSobre.setEditable(false);
        campoSobreSofwareSobre.setColumns(20);
        campoSobreSofwareSobre.setRows(5);
        campoSobreSofwareSobre.setText("Versão de Teste 1.0\n\nEste software tem como função gerar modelos pronto em pdf com base nas informações dadas pelo usuário no\nmomento do cadastro.");
        jScrollPane9.setViewportView(campoSobreSofwareSobre);

        btnSobreMenuPrincipal.setText("Menu Principal");
        btnSobreMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelSobreLayout = new javax.swing.GroupLayout(painelSobre);
        painelSobre.setLayout(painelSobreLayout);
        painelSobreLayout.setHorizontalGroup(
            painelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSobreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)
                    .addGroup(painelSobreLayout.createSequentialGroup()
                        .addGroup(painelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelComponenteSobre)
                            .addComponent(labelAgradecimentosSobre)
                            .addComponent(labelSobreSoftwareSobre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSobreLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSobreMenuPrincipal)))
                .addContainerGap())
        );
        painelSobreLayout.setVerticalGroup(
            painelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSobreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelComponenteSobre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelAgradecimentosSobre)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSobreSoftwareSobre)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnSobreMenuPrincipal)
                .addContainerGap())
        );

        PainelPrincipal.add(painelSobre, "painelSobre");

        subMenuPainelCadastrar.setText("Arquivo");
        subMenuPainelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPainelCadastrarActionPerformed(evt);
            }
        });

        itemMenuPrincipalArquivoSubMenuPainelCadastrar.setText("Menu Principal");
        itemMenuPrincipalArquivoSubMenuPainelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuPrincipalArquivoSubMenuPainelCadastrarActionPerformed(evt);
            }
        });
        subMenuPainelCadastrar.add(itemMenuPrincipalArquivoSubMenuPainelCadastrar);

        itemAbrirPastaSubMenuPainelCadastrar.setText("Abrir Pasta");
        itemAbrirPastaSubMenuPainelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirPastaSubMenuPainelCadastrarActionPerformed(evt);
            }
        });
        subMenuPainelCadastrar.add(itemAbrirPastaSubMenuPainelCadastrar);

        itemSairSubMenuPainelCadastrar.setText("Sair");
        itemSairSubMenuPainelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairSubMenuPainelCadastrarActionPerformed(evt);
            }
        });
        subMenuPainelCadastrar.add(itemSairSubMenuPainelCadastrar);

        menuPainelCadastrar.add(subMenuPainelCadastrar);

        subMenuPainelSobre.setText("Sobre");

        itemSobreSubMenuPainelCadastrar.setText("Sobre");
        itemSobreSubMenuPainelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreSubMenuPainelCadastrarActionPerformed(evt);
            }
        });
        subMenuPainelSobre.add(itemSobreSubMenuPainelCadastrar);

        menuPainelCadastrar.add(subMenuPainelSobre);

        setJMenuBar(menuPainelCadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboxCadastrarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxCadastrarEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxCadastrarEventoActionPerformed

    private void btnGerarPdfOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarPdfOkActionPerformed
        comboxListaEventoPDF.removeAllItems();

        if (comboxGerarPdfEvento.getSelectedItem().equals("Esporte")) {
            for (int i = 0; i < cadastrar.getEsporte().size(); i++) {
                try {                    
                    comboxListaEventoPDF.addItem(cadastrar.getEsporte().get(i).getNome()
                            + cadastrar.dateToString(cadastrar.getEsporte().get(i).getDataInclusao()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
                }
            }
            mudarPainel("painelGerarPdf");
        } else if (comboxGerarPdfEvento.getSelectedItem().equals("Filme")) {
            for (int i = 0; i < cadastrar.getFilme().size(); i++) {
                try {
                    comboxListaEventoPDF.addItem(cadastrar.getFilme().get(i).getNome()
                            + cadastrar.dateToString(cadastrar.getFilme().get(i).getDataInclusao()));
                } catch (Exception ex) {
                    Logger.getLogger(PainelCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            mudarPainel("painelGerarPdf");
        } else if (comboxGerarPdfEvento.getSelectedItem().equals("Peça")) {
            for (int i = 0; i < cadastrar.getPeca().size(); i++) {
                try {
                    comboxListaEventoPDF.addItem(cadastrar.getPeca().get(i).getNome()
                            + cadastrar.dateToString(cadastrar.getPeca().get(i).getDataInclusao()));
                } catch (Exception ex) {
                    Logger.getLogger(PainelCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            mudarPainel("painelGerarPdf");
        } else if (comboxGerarPdfEvento.getSelectedItem().equals("Show")) {
            for (int i = 0; i < cadastrar.getPeca().size(); i++) {
                try {
                    comboxListaEventoPDF.addItem(cadastrar.getPeca().get(i).getNome()
                            + cadastrar.dateToString(cadastrar.getPeca().get(i).getDataInclusao()));
                } catch (Exception ex) {
                    Logger.getLogger(PainelCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            mudarPainel("painelGerarPdf");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item!");
        }
    }//GEN-LAST:event_btnGerarPdfOkActionPerformed

    private void btnCadastrarEventoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEventoOkActionPerformed
        if (comboxCadastrarEvento.getSelectedItem().equals("Esporte")) {
            mudarPainel("painelEsporte");
        } else if (comboxCadastrarEvento.getSelectedItem().equals("Filme")) {
            mudarPainel("painelFilme");
        } else if (comboxCadastrarEvento.getSelectedItem().equals("Peça")) {
            mudarPainel("painelPeca");
        } else if (comboxCadastrarEvento.getSelectedItem().equals("Show")) {
            mudarPainel("painelShow");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item!");
        }
    }//GEN-LAST:event_btnCadastrarEventoOkActionPerformed

    private void itemAbrirPastaSubMenuPainelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirPastaSubMenuPainelCadastrarActionPerformed
        ///
        try {
            cadastrar.abrirPasta();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Erro, Verifique seu Gerenciador de Arquivo!");
        }
    }//GEN-LAST:event_itemAbrirPastaSubMenuPainelCadastrarActionPerformed

    private void itemSairSubMenuPainelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairSubMenuPainelCadastrarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja Sair? ");
        if (opcao == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_itemSairSubMenuPainelCadastrarActionPerformed

    public void mudarParaPainelDetalheEvento() {
        mudarPainel("painelDetalheEvento");
    }

    private void btnVoltarEsporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarEsporteActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_btnVoltarEsporteActionPerformed

    private void txtNomeEsporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeEsporteMouseClicked
        limparText(txtNomeEsporte);
    }//GEN-LAST:event_txtNomeEsporteMouseClicked

    private void campoCadastrarEquipeEsporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCadastrarEquipeEsporteMouseClicked
        limparCampo(campoCadastrarEquipeEsporte);
    }//GEN-LAST:event_campoCadastrarEquipeEsporteMouseClicked

    private void btnVoltarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarFilmeActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_btnVoltarFilmeActionPerformed

    private void btnVoltarShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarShowActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_btnVoltarShowActionPerformed

    private void btnVoltarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarPecaActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_btnVoltarPecaActionPerformed

    private void txtNomeFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeFilmeMouseClicked
        limparText(txtNomeFilme);
    }//GEN-LAST:event_txtNomeFilmeMouseClicked

    private void txtGeneroFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneroFilmeMouseClicked
        limparText(txtGeneroFilme);
    }//GEN-LAST:event_txtGeneroFilmeMouseClicked

    private void txtCensuraFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCensuraFilmeMouseClicked
        limparText(txtCensuraFilme);
    }//GEN-LAST:event_txtCensuraFilmeMouseClicked

    private void txtNomeShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeShowActionPerformed
        //
    }//GEN-LAST:event_txtNomeShowActionPerformed

    private void txtArtistaShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtistaShowActionPerformed
        //
    }//GEN-LAST:event_txtArtistaShowActionPerformed

    private void txtEstilhoShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstilhoShowActionPerformed
        //
    }//GEN-LAST:event_txtEstilhoShowActionPerformed

    private void txtNomeShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeShowMouseClicked
        limparText(txtNomeShow);
    }//GEN-LAST:event_txtNomeShowMouseClicked

    private void txtArtistaShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArtistaShowMouseClicked
        limparText(txtArtistaShow);
    }//GEN-LAST:event_txtArtistaShowMouseClicked

    private void txtEstilhoShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEstilhoShowMouseClicked
        limparText(txtEstilhoShow);
    }//GEN-LAST:event_txtEstilhoShowMouseClicked

    private void txtCompanhiaPecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCompanhiaPecaMouseClicked
        limparText(txtCompanhiaPeca);
    }//GEN-LAST:event_txtCompanhiaPecaMouseClicked

    private void txtGeneroPecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneroPecaMouseClicked
        limparText(txtGeneroPeca);
    }//GEN-LAST:event_txtGeneroPecaMouseClicked

    private void txtCensuraPecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCensuraPecaMouseClicked
        limparText(txtCensuraPeca);
    }//GEN-LAST:event_txtCensuraPecaMouseClicked

    private void txtNomePecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomePecaMouseClicked
        limparText(txtNomePeca);
    }//GEN-LAST:event_txtNomePecaMouseClicked

    private void btnAvançarEsporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarEsporteActionPerformed
        setVariavelControle(Esporte);
        mudarParaPainelDetalheEvento();        
    }//GEN-LAST:event_btnAvançarEsporteActionPerformed

    private void btnAvançarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarPecaActionPerformed
        setVariavelControle(Peca);
        mudarParaPainelDetalheEvento();
    }//GEN-LAST:event_btnAvançarPecaActionPerformed

    private void btnAvançarShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarShowActionPerformed
        setVariavelControle(Show);
        mudarParaPainelDetalheEvento();
    }//GEN-LAST:event_btnAvançarShowActionPerformed

    private void btnAvançarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarFilmeActionPerformed
        setVariavelControle(Filme);
        mudarParaPainelDetalheEvento();
    }//GEN-LAST:event_btnAvançarFilmeActionPerformed

    private void btnVoltarAmbiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarAmbiente2ActionPerformed
        qualVoltar();
    }//GEN-LAST:event_btnVoltarAmbiente2ActionPerformed

    private void btnVoltarIngressoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarIngressoEventoActionPerformed
        mudarPainel("painelAmbiente");
    }//GEN-LAST:event_btnVoltarIngressoEventoActionPerformed

    private void formatedDataHoraEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatedDataHoraEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formatedDataHoraEventoActionPerformed

    private void campoSinopseEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoSinopseEventoMouseClicked
        limparCampo(campoSinopseEvento);
    }//GEN-LAST:event_campoSinopseEventoMouseClicked

    private void campoDescricaoEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDescricaoEventoMouseClicked
        limparCampo(campoDescricaoEvento);
    }//GEN-LAST:event_campoDescricaoEventoMouseClicked

    private void txtDuracaoEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuracaoEventoMouseClicked
        limparText(txtDuracaoEvento);
    }//GEN-LAST:event_txtDuracaoEventoMouseClicked

    private void txtValorIngressoEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorIngressoEventoMouseClicked
        limparText(txtValorIngressoEvento);
    }//GEN-LAST:event_txtValorIngressoEventoMouseClicked

    private void txtQuantidadeIngressoEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantidadeIngressoEventoMouseClicked
        limparText(txtQuantidadeIngressoEvento);
    }//GEN-LAST:event_txtQuantidadeIngressoEventoMouseClicked

    private void campoMensagemPromocaoIngressoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMensagemPromocaoIngressoMouseClicked
        limparCampo(campoMensagemPromocaoIngresso);
    }//GEN-LAST:event_campoMensagemPromocaoIngressoMouseClicked

    private void txtQuantudadeDisponivelPromocaoIngressoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantudadeDisponivelPromocaoIngressoMouseClicked
        limparText(txtQuantudadeDisponivelPromocaoIngresso);
    }//GEN-LAST:event_txtQuantudadeDisponivelPromocaoIngressoMouseClicked

    private void txtlValorDescontoPromocaoIngressoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtlValorDescontoPromocaoIngressoMouseClicked
        limparText(txtlValorDescontoPromocaoIngresso);
    }//GEN-LAST:event_txtlValorDescontoPromocaoIngressoMouseClicked

    private void btnAvançarAmbiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarAmbiente2ActionPerformed
        mudarPainel("painelAmbiente");
    }//GEN-LAST:event_btnAvançarAmbiente2ActionPerformed

    private void btnAvançarIngressoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarIngressoEventoActionPerformed
        mudarPainel("painelContato");
    }//GEN-LAST:event_btnAvançarIngressoEventoActionPerformed

    private void btnVoltarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarAmbienteActionPerformed
        mudarParaPainelDetalheEvento();
    }//GEN-LAST:event_btnVoltarAmbienteActionPerformed

    private void btnAvançarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvançarAmbienteActionPerformed
        mudarPainel("painelIngresso");
    }//GEN-LAST:event_btnAvançarAmbienteActionPerformed

    private void txtNomeAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeAmbienteMouseClicked
        limparText(txtNomeAmbiente);
    }//GEN-LAST:event_txtNomeAmbienteMouseClicked

    private void campoDescricaoAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoDescricaoAmbienteMouseClicked
        limparCampo(campoDescricaoAmbiente);
    }//GEN-LAST:event_campoDescricaoAmbienteMouseClicked

    private void txtPontoReferenciaAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPontoReferenciaAmbienteMouseClicked
        limparText(txtPontoReferenciaAmbiente);
    }//GEN-LAST:event_txtPontoReferenciaAmbienteMouseClicked

    private void txtNomeSetorAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeSetorAmbienteMouseClicked
        limparText(txtNomeSetorAmbiente);
    }//GEN-LAST:event_txtNomeSetorAmbienteMouseClicked

    private void txtCapacidadeSetorAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCapacidadeSetorAmbienteMouseClicked
        limparText(txtCapacidadeSetorAmbiente);
    }//GEN-LAST:event_txtCapacidadeSetorAmbienteMouseClicked

    private void comboxListaEventoPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxListaEventoPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxListaEventoPDFActionPerformed

    private void btnMenuPrincipalGerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalGerarPdfActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_btnMenuPrincipalGerarPdfActionPerformed

    private void btnGerarPdfPainelGerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarPdfPainelGerarPdfActionPerformed
        try {
            gerarPdf();
            int opcao = JOptionPane.showConfirmDialog(null, "Arquivo Gerado Com Sucesso!"
                    + "\nDeseja Abrir a Pasta do Arquivo? ");
            if (opcao == 0) {
                cadastrar.abrirPasta();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }//GEN-LAST:event_btnGerarPdfPainelGerarPdfActionPerformed

    private void campoEnderecoAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEnderecoAmbienteMouseClicked
        limparCampo(campoEnderecoAmbiente);
    }//GEN-LAST:event_campoEnderecoAmbienteMouseClicked

    private void btnConcluirContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirContatoActionPerformed
        try {
            if (comboxCadastrarEvento.getSelectedIndex() == 1) {
                cadastrar.cadastrarEsporte(cadastrarEsporte());
                JOptionPane.showMessageDialog(null, "Evento Esportivo Cadastrado!");
            } else if (comboxCadastrarEvento.getSelectedItem().equals("Filme")) {
                cadastrar.cadastrarFilme(cadastrarFilme());
                JOptionPane.showMessageDialog(null, "Evento de Filme Cadastrado!");
            } else if (comboxCadastrarEvento.getSelectedItem().equals("Peça")) {
                cadastrar.cadastrarPeca(cadastrarPeca());
                JOptionPane.showMessageDialog(null, "Evento de Peça Cadastrado!");
            } else if (comboxCadastrarEvento.getSelectedItem().equals("Show")) {
                cadastrar.cadastrarShow(cadastrarShow());
                JOptionPane.showMessageDialog(null, "Evento de Show Cadastrado!");
            }
            //JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Dados Errados!");
        }
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
        ///Metodo de Cadastrar
    }//GEN-LAST:event_btnConcluirContatoActionPerformed

    private void btnVoltarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarContatoActionPerformed
        mudarPainel("painelIngresso");
    }//GEN-LAST:event_btnVoltarContatoActionPerformed

    private void txtNomeContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeContatoMouseClicked
        limparText(txtNomeContato);
    }//GEN-LAST:event_txtNomeContatoMouseClicked

    private void txtTelefoneContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefoneContatoMouseClicked
        limparText(txtTelefoneContato);
    }//GEN-LAST:event_txtTelefoneContatoMouseClicked

    private void campoEnderecoContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEnderecoContatoMouseClicked
        limparCampo(campoEnderecoContato);
    }//GEN-LAST:event_campoEnderecoContatoMouseClicked

    private void txtEmailContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailContatoMouseClicked
        limparText(txtEmailContato);
    }//GEN-LAST:event_txtEmailContatoMouseClicked

    private void txtEstreiaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstreiaFilmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstreiaFilmeActionPerformed

    private void txtEstreiaFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEstreiaFilmeMouseClicked
        limparText(txtEstreiaFilme);
    }//GEN-LAST:event_txtEstreiaFilmeMouseClicked

    private void subMenuPainelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPainelCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuPainelCadastrarActionPerformed

    private void itemMenuPrincipalArquivoSubMenuPainelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuPrincipalArquivoSubMenuPainelCadastrarActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_itemMenuPrincipalArquivoSubMenuPainelCadastrarActionPerformed

    private void btnSobreMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreMenuPrincipalActionPerformed
        mudarPainel("painelCadastrar");
        controlePainelCadastrar();
    }//GEN-LAST:event_btnSobreMenuPrincipalActionPerformed

    private void itemSobreSubMenuPainelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreSubMenuPainelCadastrarActionPerformed
        mudarPainel("painelSobre");
    }//GEN-LAST:event_itemSobreSubMenuPainelCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(PainelCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelPrincipal;
    private javax.swing.JButton btnAvançarAmbiente;
    private javax.swing.JButton btnAvançarAmbiente2;
    private javax.swing.JButton btnAvançarEsporte;
    private javax.swing.JButton btnAvançarFilme;
    private javax.swing.JButton btnAvançarIngressoEvento;
    private javax.swing.JButton btnAvançarPeca;
    private javax.swing.JButton btnAvançarShow;
    private javax.swing.JButton btnCadastrarEventoOk;
    private javax.swing.JButton btnConcluirContato;
    private javax.swing.JButton btnGerarPdfOk;
    private javax.swing.JButton btnGerarPdfPainelGerarPdf;
    private javax.swing.JButton btnMenuPrincipalGerarPdf;
    private javax.swing.JButton btnSobreMenuPrincipal;
    private javax.swing.JButton btnVoltarAmbiente;
    private javax.swing.JButton btnVoltarAmbiente2;
    private javax.swing.JButton btnVoltarContato;
    private javax.swing.JButton btnVoltarEsporte;
    private javax.swing.JButton btnVoltarFilme;
    private javax.swing.JButton btnVoltarIngressoEvento;
    private javax.swing.JButton btnVoltarPeca;
    private javax.swing.JButton btnVoltarShow;
    private javax.swing.JScrollPane cadastrarEquipeEsporteScroll1;
    private javax.swing.JTextArea campoAgradecimentoSobre;
    private javax.swing.JTextArea campoCadastrarEquipeEsporte;
    private javax.swing.JTextArea campoComponenteSobre;
    private javax.swing.JTextArea campoDescricaoAmbiente;
    private javax.swing.JTextArea campoDescricaoEvento;
    private javax.swing.JTextArea campoEnderecoAmbiente;
    private javax.swing.JTextArea campoEnderecoContato;
    private javax.swing.JTextArea campoMensagemPromocaoIngresso;
    private javax.swing.JTextArea campoSinopseEvento;
    private javax.swing.JTextArea campoSobreSofwareSobre;
    private javax.swing.JComboBox comboxCadastrarEvento;
    private javax.swing.JComboBox comboxGerarPdfEvento;
    private javax.swing.JComboBox comboxListaEventoPDF;
    private javax.swing.JComboBox comboxSelecionarCorPainelGerarPdf;
    private javax.swing.JComboBox comboxSelecionarTamanhoPaginaPainelGerarPdf;
    private javax.swing.JFormattedTextField formatedDataHoraEvento;
    private javax.swing.JMenuItem itemAbrirPastaSubMenuPainelCadastrar;
    private javax.swing.JMenuItem itemMenuPrincipalArquivoSubMenuPainelCadastrar;
    private javax.swing.JMenuItem itemSairSubMenuPainelCadastrar;
    private javax.swing.JMenuItem itemSobreSubMenuPainelCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelAgradecimentosSobre;
    private javax.swing.JLabel labelArtistaShow;
    private javax.swing.JLabel labelCadastrarAmbiente;
    private javax.swing.JLabel labelCadastrarEvento;
    private javax.swing.JLabel labelCadastrarFilme;
    private javax.swing.JLabel labelCadastrarPeca;
    private javax.swing.JLabel labelCadastrarShow;
    private javax.swing.JLabel labelCapacidadeAmbiente;
    private javax.swing.JLabel labelCensuraFilme;
    private javax.swing.JLabel labelCensuraPeca;
    private javax.swing.JLabel labelCompanhiaPeca;
    private javax.swing.JLabel labelComponenteSobre;
    private javax.swing.JLabel labelContatoEvento;
    private javax.swing.JLabel labelDataHoraEvento;
    private javax.swing.JLabel labelDescricaoAmbiente;
    private javax.swing.JLabel labelDescricaoEvento;
    private javax.swing.JLabel labelDetalhesEvento;
    private javax.swing.JLabel labelDuracaoEvento;
    private javax.swing.JLabel labelEmailContato;
    private javax.swing.JLabel labelEnderecoAmbiente;
    private javax.swing.JLabel labelEnderecoContato;
    private javax.swing.JLabel labelEquipeEsporte;
    private javax.swing.JLabel labelEstiloShow;
    private javax.swing.JLabel labelEstreiaFilme;
    private javax.swing.JLabel labelGeneroFilme;
    private javax.swing.JLabel labelGeneroPeca;
    private javax.swing.JLabel labelGerarPdfCadastrar;
    private javax.swing.JLabel labelMensagemIngressoPromocao;
    private javax.swing.JLabel labelNomeAmbiente;
    private javax.swing.JLabel labelNomeContato;
    private javax.swing.JLabel labelNomeEsporte;
    private javax.swing.JLabel labelNomeFilme;
    private javax.swing.JLabel labelNomePeca;
    private javax.swing.JLabel labelNomeShow;
    private javax.swing.JLabel labelPontoReferenciaAmbiente;
    private javax.swing.JLabel labelPromocaoIngresso;
    private javax.swing.JLabel labelQuantidadeDisponivelPromocaoIngresso;
    private javax.swing.JLabel labelQuantidadeIngresso;
    private javax.swing.JLabel labelSetorAmbiente;
    private javax.swing.JLabel labelSinopseEvento;
    private javax.swing.JLabel labelSobreSoftwareSobre;
    private javax.swing.JLabel labelTelefoneContato;
    private javax.swing.JLabel labelTituloCadastrarEsporte;
    private javax.swing.JLabel labelValorDescontoPromocaoIngresso;
    private javax.swing.JLabel labelValorIngresso;
    private javax.swing.JLabel labelngressoEvento;
    private javax.swing.JMenuBar menuPainelCadastrar;
    private javax.swing.JPanel painelAmbiente;
    private javax.swing.JPanel painelCadastrar;
    private javax.swing.JPanel painelContato;
    private javax.swing.JPanel painelDetalheEvento;
    private javax.swing.JPanel painelEsporte;
    private javax.swing.JPanel painelFilme;
    private javax.swing.JPanel painelGerarPdf;
    private javax.swing.JPanel painelPeca;
    private javax.swing.JPanel painelShow;
    private javax.swing.JPanel painelSobre;
    private javax.swing.JPanel painelngresso;
    private javax.swing.JMenu subMenuPainelCadastrar;
    private javax.swing.JMenu subMenuPainelSobre;
    private javax.swing.JTextField txtArtistaShow;
    private javax.swing.JTextField txtCapacidadeSetorAmbiente;
    private javax.swing.JTextField txtCensuraFilme;
    private javax.swing.JTextField txtCensuraPeca;
    private javax.swing.JTextField txtCompanhiaPeca;
    private javax.swing.JTextField txtDuracaoEvento;
    private javax.swing.JTextField txtEmailContato;
    private javax.swing.JTextField txtEstilhoShow;
    private javax.swing.JTextField txtEstreiaFilme;
    private javax.swing.JTextField txtGeneroFilme;
    private javax.swing.JTextField txtGeneroPeca;
    private javax.swing.JTextField txtNomeAmbiente;
    private javax.swing.JTextField txtNomeContato;
    private javax.swing.JTextField txtNomeEsporte;
    private javax.swing.JTextField txtNomeFilme;
    private javax.swing.JTextField txtNomePeca;
    private javax.swing.JTextField txtNomeSetorAmbiente;
    private javax.swing.JTextField txtNomeShow;
    private javax.swing.JTextField txtPontoReferenciaAmbiente;
    private javax.swing.JTextField txtQuantidadeIngressoEvento;
    private javax.swing.JTextField txtQuantudadeDisponivelPromocaoIngresso;
    private javax.swing.JTextField txtTelefoneContato;
    private javax.swing.JTextField txtValorIngressoEvento;
    private javax.swing.JTextField txtlValorDescontoPromocaoIngresso;
    // End of variables declaration//GEN-END:variables
}
