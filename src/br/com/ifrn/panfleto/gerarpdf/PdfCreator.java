package br.com.ifrn.panfleto.gerarpdf;

/**
 * Esta é a classe que cria o documento pdf, ja tem modelos prontos criados em metodos
 * para ser utilizado na criação dos docs. Para ela gerar o pdf ela se comunica com a classe cadastrar.
 */

import br.com.ifrn.panfleto.constantes.Fonts;
import br.com.ifrn.panfleto.envento.Esporte;
import br.com.ifrn.panfleto.envento.Filme;
import br.com.ifrn.panfleto.envento.Peca;
import br.com.ifrn.panfleto.envento.Show;
import br.com.ifrn.panfleto.utilitario.EventTable;
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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class PdfCreator extends PdfPageEventHelper {

    private Document document;
    private Rectangle rectangle;

    public static final String diretorioPrincipal = "Eventos";    
    private final String pathImageEsporteLogo = "src/imagens/esporteLogo.png";
    private final String pathImageFilmeLogo = "src/imagens/filmeLogo.png";
    private final String pathImagePecaLogo = "src/imagens/pecaLogo.png";
    private final String pathImageShowLogo = "src/imagens/showLogo.png";
    private final String pathImageFooter = "src/imagens/logoFooter_181x75.png";
    private File file = new File(diretorioPrincipal);

    
    /**
     * Ao criar a classe é necessário definir o tamanho do pdf e a cor de fundo.
     */    
    public PdfCreator(Rectangle rectangle, BaseColor baseColor) {
        this.rectangle = rectangle;
        rectangle.setBackgroundColor(baseColor);
        if(!file.exists())
            file.mkdir();           
    }
    
    //Gerar Modelo ponto de esporte;
    public void gerarPlanfletoEsporte(Esporte esporte) throws DocumentException, IOException, Exception {
        document = new Document(rectangle);

        Image imageLogo = Image.getInstance(pathImageEsporteLogo);
        Image imageLogoFooter = Image.getInstance(pathImageFooter);

        FormatarData formatarData = new FormatarData();
        FormatarTempo formatarTempo = new FormatarTempo();

        PdfWriter pfWriter;
        pfWriter = PdfWriter.getInstance(document, new FileOutputStream(diretorioPrincipal+"/"+esporte.getNome()));
        adicionarRodape(document, pfWriter, imageLogoFooter, esporte.getContatos().toString());

        document.open();
        adicionarLogo(document, imageLogo);

        //MODEL
        adicionarParagrafoEsquerda(document, formatarData.DateToString(esporte.getDataEvento()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoEsquerda(document, formatarTempo.timeString(esporte.getDuracao()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoCentralizado(document, esporte.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, esporte.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, esporte.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarTabelaEquipe(document, esporte.getEquipe(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoCentralizado(document, esporte.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, esporte.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoDireita(document, esporte.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
        //END        
        document.close();
    }

    //Gerar Modelo ponto de filme;   
    public void gerarPlanfletoFilme(Filme filme) throws DocumentException, BadElementException, FileNotFoundException, IOException, Exception {
        document = new Document(rectangle);

        Image imageLogo = Image.getInstance(pathImageFilmeLogo);
        Image imageLogoFooter = Image.getInstance(pathImageFooter);

        FormatarData formatarData = new FormatarData();
        FormatarTempo formatarTempo = new FormatarTempo();

        PdfWriter pfWriter;
        pfWriter = PdfWriter.getInstance(document, new FileOutputStream(diretorioPrincipal+"/"+filme.getNome()));
        adicionarRodape(document, pfWriter, imageLogoFooter, filme.getContatos().toString());

        document.open();
        adicionarLogo(document, imageLogo);
        //Model
        adicionarParagrafoEsquerda(document, formatarData.DateToString(filme.getDataEvento()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoCentralizado(document, filme.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, filme.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);

        adicionarParagrafoJustificado(document, filme.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, filme.informacoesTecnicas(), Fonts.TIMES_ROMAN_BOLD_BLACK_20);
        adicionarParagrafoEsquerda(document, formatarTempo.timeString(filme.getDuracao()), Fonts.TIMES_ROMAN_BOLD_BLACK_20);
        adicionarParagrafoDireita(document, filme.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
        adicionarParagrafoCentralizado(document, filme.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, filme.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        //END
        document.close();
    }

    //Gerar Modelo ponto de peca;
    public void gerarPlanfletoPeca(Peca peca) throws DocumentException, FileNotFoundException, BadElementException, IOException, Exception {
        document = new Document(rectangle);

        Image imageLogo = Image.getInstance(pathImagePecaLogo);
        Image imageLogoFooter = Image.getInstance(pathImageFooter);

        FormatarData formatarData = new FormatarData();
        FormatarTempo formatarTempo = new FormatarTempo();

        PdfWriter pfWriter;
        pfWriter = PdfWriter.getInstance(document, new FileOutputStream(diretorioPrincipal+"/"+peca.getNome()));
        adicionarRodape(document, pfWriter, imageLogoFooter, peca.getContatos().toString());

        document.open();
        adicionarLogo(document, imageLogo);
        //MODEL
        adicionarParagrafoEsquerda(document, formatarData.DateToString(peca.getDataEvento()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoCentralizado(document, peca.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, peca.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, peca.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoCentralizado(document, peca.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, peca.toString(), Fonts.TIMES_ROMAN_BOLD_BLACK_20);
        adicionarParagrafoEsquerda(document, formatarTempo.timeString(peca.getDuracao()), Fonts.TIMES_ROMAN_BOLD_BLACK_20);
        adicionarParagrafoEsquerda(document, peca.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, peca.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, peca.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, peca.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoDireita(document, peca.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
        //END
        document.close();
    }

    //Gerar Modelo ponto de show;
    public void gerarPlanfletoShow(Show show) throws DocumentException, FileNotFoundException, BadElementException, IOException, Exception {
        document = new Document(rectangle);

        Image imageLogo = Image.getInstance(pathImageShowLogo);
        Image imageLogoFooter = Image.getInstance(pathImageFooter);

        FormatarData formatarData = new FormatarData();
        FormatarTempo formatarTempo = new FormatarTempo();

        PdfWriter pfWriter;
        pfWriter = PdfWriter.getInstance(document, new FileOutputStream(diretorioPrincipal+"/"+show.getNome()));
        adicionarRodape(document, pfWriter, imageLogoFooter, show.getContatos().toString());

        document.open();
        adicionarLogo(document, imageLogo);
        //MODEL
        adicionarParagrafoEsquerda(document, formatarData.DateToString(show.getDataEvento()), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
        adicionarParagrafoCentralizado(document, show.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoJustificado(document, show.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoJustificado(document, show.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoCentralizado(document, show.toString(), Fonts.TIMES_ROMAN_BLACK_ITALIC_24);
        adicionarParagrafoCentralizado(document, formatarTempo.timeString(show.getDuracao()), Fonts.TIMES_ROMAN_RED_ITALIC_24);
        adicionarParagrafoCentralizado(document, show.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
        adicionarParagrafoEsquerda(document, show.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, show.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, show.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoEsquerda(document, show.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_20);
        adicionarParagrafoDireita(document, show.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
        //END
        document.close();
    }

    //Adicionar o logo centralizado
    private void adicionarLogo(Document document, Image imageLogo) throws DocumentException, BadElementException, IOException {
        imageLogo.setAlignment(Element.ALIGN_CENTER);
        document.add(imageLogo);
    }

    //Adicionar o parafo centralizado
    private void adicionarParagrafoCentralizado(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }

    //Adicionar o parafo justificado com identação
    private void adicionarParagrafoJustificado(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        //adicionar espaço de paragráfo
        paragraph.setFirstLineIndent(50);
        document.add(paragraph);
    }

    //Adicionar o parafo direita
    private void adicionarParagrafoDireita(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
    }

    //Adicionar o parafo esquerda
    private void adicionarParagrafoEsquerda(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
    }

    //Adicionar o parafo rodapé
    //Cria uma tabela que passa pelo metodo endOnPage para que assim toda a pagina tenha por padrão
    //este rodapé
    private void adicionarRodape(Document document, PdfWriter writer, Image imageLogo, String conteudo) {
        Rectangle page = document.getPageSize();
        //Imagem da primeira celula da matriz, com tamanho já definido
        imageLogo.scalePercent(80, 50);

        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());

        PdfPCell cell = new PdfPCell(imageLogo);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        PdfPCell cell1 = new PdfPCell(new Phrase(conteudo));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setBorder(0);
        table.addCell(cell1);

        EventTable eventTable = new EventTable(table);

        writer.setPageEvent(eventTable);
    }
    
    //Adiciona uma tebla de equipe, com duas colunas.
    private void adicionarTabelaEquipe(Document document, String conteudo, Font font) throws DocumentException {
        PdfPTable table = new PdfPTable(2);

        // the cell object
        PdfPCell cell;

        table.setSpacingBefore(50);
        table.setSpacingAfter(50);

        cell = new PdfPCell(new Phrase("#"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Jogador"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        //faz o split da string com os elementos da equipe e os alinha ao centro
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
        
        //adiciona tabela ao documento
        document.add(table);
    }   
}