package br.com.ifrn.panfleto.gerarpdf;

import br.com.ifrn.panfleto.Ambiente;
import br.com.ifrn.panfleto.Contatos;
import br.com.ifrn.panfleto.Setor;
import br.com.ifrn.panfleto.cadastrar.Cadastrar;
import br.com.ifrn.panfleto.constantes.Fonts;
import br.com.ifrn.panfleto.envento.Esporte;
import br.com.ifrn.panfleto.envento.Filme;
import br.com.ifrn.panfleto.envento.Peca;
import br.com.ifrn.panfleto.envento.Show;
import br.com.ifrn.panfleto.ingresso.Ingresso;
import br.com.ifrn.panfleto.utilitario.FormatarData;
import br.com.ifrn.panfleto.utilitario.FormatarTempo;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.util.Date;
import javax.swing.JOptionPane;

public class PdfCreator extends PdfPageEventHelper{

    public static void main(String[] args) throws Exception {
        //VOCÊ IRA TESTAR O MODELO POR AQUI!
        Date date = new Date(System.currentTimeMillis());
        FormatarData formatarData = new FormatarData();
        FormatarTempo formatarTempo = new FormatarTempo();

        Cadastrar cadastrar = Cadastrar.getUniqueInstance();

        Filme filme = new Filme();
        filme.setNome("A volta dos que não foram");
        filme.setGenero("Comédia");
        filme.setEstreia("Hoje!");
        filme.setCensura(9);
        filme.setSinopse("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eget leo quis elit "
                + "pulvinar gravida in quis orci. Pellentesque habitant morbi tristique senectus et netus et "
                + "malesuada fames ac turpis egestas. Vestibulum congue maximus cursus. Sed faucibus felis eu "
                + "ligula gravida, vel tincidunt purus bibendum. In volutpat ornare nisl, id egestas ligula gravida "
                + "vitae. Proin mollis luctus bibendum. Suspendisse a elit lacinia, auctor leo eget, tincidunt velit. "
                + "Duis lobortis tempor elit ut ullamcorper. Sed a ultricies erat, et scelerisque lacus. Pellentesque "
                + "in ullamcorper felis, molestie semper ex. Donec neque ligula, rhoncus sed rhoncus nec, "
                + "venenatis ac nulla.");
        filme.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eget leo quis elit "
                + "pulvinar gravida in quis orci. Pellentesque habitant morbi tristique senectus et netus et "
                + "malesuada fames ac turpis egestas. Vestibulum congue maximus cursus. Sed faucibus felis eu "
                + "ligula gravida, vel tincidunt purus bibendum. In volutpat ornare nisl, id egestas ligula gravida "
                + "vitae. Proin mollis luctus bibendum. Suspendisse a elit lacinia, auctor leo eget, tincidunt velit. "
                + "Duis lobortis tempor elit ut ullamcorper. Sed a ultricies erat, et scelerisque lacus. Pellentesque "
                + "in ullamcorper felis, molestie semper ex. Donec neque ligula, rhoncus sed rhoncus nec, "
                + "venenatis ac nulla.");
        filme.setDuracao(210);
        filme.setDataEvento(date);
        filme.setDataInclusao(date);

        Ambiente ambiente = new Ambiente();
        ambiente.setDescricao("Local Arejado, ótimo ponto de encontro");
        ambiente.setEndereco("Avenida Deputado Patricio de Figueredo Neto, Cascalo, 469, 59965-999 - Alexandria/RN");
        ambiente.setNome("Cinema Central");
        ambiente.setProntoReferencia("Proximo a academia dos que não trabalha");
        Setor setor = new Setor();
        setor.setCapacidade(1000);
        setor.setNome("Sala 03");
        ambiente.setSetor(setor);
        filme.setAmbiente(ambiente);

        Contatos contatos = new Contatos();
        contatos.setNome("FH Divulgações");
        contatos.setEmail("alunos@ifrn.edu.com.br");
        contatos.setTelefone("(84) 99876-5432");
        contatos.setEndereco("Avenida Deputado Patrício de Figueredo Neto, 469, Cascalho - CEP:59965000 - Alexandria/RN");
        filme.setContatos(contatos);

        Ingresso ingresso = new Ingresso();
        ingresso.setMensagem("Concorra a um mês de ingressos Gratis!");
        ingresso.setQuantidade(1000);
        ingresso.setQuantidadeDisponivél(100);
        ingresso.setValor(25);
        ingresso.setValorDeDesconto(10);
        filme.setIngresso(ingresso);

        cadastrar.cadastrarFilme(filme);

        Rectangle layout = new Rectangle(PageSize.A3);
        layout.setBackgroundColor(BaseColor.WHITE);
        Document document = new Document(layout);
        String pathImage = "src/imagens/esporteLogo.png";
        Image image = Image.getInstance(pathImage);                

        try {
            gerarPlanfletoFilme(document, filme, formatarData, formatarTempo, image);
            JOptionPane.showMessageDialog(null, "Arquivo gerado com com sucesso!");
        } catch (DocumentException | IOException de) {
            JOptionPane.showMessageDialog(null, de.getMessage());
        } finally {
            document.close();
        }
    }

    public static void gerarPlanfletoEsporte(Document document, Esporte esporte, FormatarData formatarData, FormatarTempo formatarTempo, Image imageLogo) throws DocumentException, IOException, Exception {
        PdfWriter pdfWriter;
        pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(esporte.getNome()));        
        document.open();
        adicionarLogo(document, imageLogo);

        //MODEL
        adicionarParagrafoEsquerda(document, formatarData.DateToString(esporte.getDataEvento()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoEsquerda(document, formatarTempo.timeString(esporte.getDuracao()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoCentralizado(document, esporte.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, esporte.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, esporte.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarTabelaEquipe(document, esporte.getEquipe(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoCentralizado(document, esporte.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoDireita(document, esporte.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
        adicionarParagrafoCentralizado(document, esporte.getContatos().toString(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_16);
        //END        
    }

    public static void gerarPlanfletoFilme(Document document, Filme filme, FormatarData formatarData, FormatarTempo formatarTempo, Image imageLogo) throws DocumentException, BadElementException, FileNotFoundException, IOException, Exception {
        PdfWriter pfWriter;
        pfWriter = PdfWriter.getInstance(document, new FileOutputStream(filme.getNome()));        
        
        document.open();
        adicionarLogo(document, imageLogo);
        //Model
        adicionarParagrafoEsquerda(document, formatarData.DateToString(filme.getDataEvento()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoCentralizado(document, filme.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, filme.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, filme.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, filme.informacoesTecnicas(), Fonts.TIMES_ROMAN_BOLD_BLACK_20);
        adicionarParagrafoEsquerda(document, formatarTempo.timeString(filme.getDuracao()), Fonts.TIMES_ROMAN_BOLD_BLACK_20);
        adicionarParagrafoCentralizado(document, filme.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoDireita(document, filme.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
        adicionarParagrafoCentralizado(document, filme.getContatos().toString(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_16);        
        //END
    }

    public void gerarPlanfletoPeca(Document document, Peca peca, FormatarData formatarData, FormatarTempo formatarTempo, Image imageLogo) {

    }

    public void gerarPlanfletoShow(Document document, Show show, FormatarData formatarData, FormatarTempo formatarTempo, Image imageLogo) {

    }

    public static void adicionarLogo(Document document, Image imageLogo) throws DocumentException, BadElementException, IOException {
        imageLogo.setAlignment(Element.ALIGN_CENTER);
        document.add(imageLogo);
    }

    public static void adicionarParagrafoCentralizado(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }

    public static void adicionarParagrafoJustificado(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        paragraph.setFirstLineIndent(50);
        document.add(paragraph);
    }

    public static void adicionarParagrafoDireita(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
    }

    public static void adicionarParagrafoEsquerda(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
    }  

    public static void adicionarTabelaEquipe(Document document, String conteudo, Font font) throws DocumentException {
        PdfPTable table = new PdfPTable(2);        
        // the cell object
        PdfPCell cell;

        table.setSpacingBefore(50);
        table.setSpacingAfter(50);

        int i = 1;
        for (String aux : conteudo.split(";")) {
            cell = new PdfPCell(new Phrase("" + i));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(aux));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            i++;
        }
        document.add(table);
    }        
}