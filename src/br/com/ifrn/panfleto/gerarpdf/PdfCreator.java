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
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Date;
import javax.swing.JOptionPane;

public class PdfCreator {

    public static void main(String[] args) throws Exception {
        //VOCÊ IRA TESTAR O MODELO POR AQUI!
        Date date = new Date(System.currentTimeMillis());
        FormatarData formatarData = new FormatarData();

        Cadastrar cadastrar = Cadastrar.getUniqueInstance();

        Esporte esporte = new Esporte();
        Ambiente ambiente = new Ambiente();
        ambiente.setNome("Ginásio Poliesportivo");
        ambiente.setDescricao("Local Arejado, ótimo ponto de encontro");
        ambiente.setEndereco("Avenida Deputado Patrício de Figueredo Neto, 469");
        ambiente.setProntoReferencia("Próximo a igreja Deus é Amor");
        Setor setor = new Setor();
        setor.setCapacidade(10000);
        setor.setNome("Bloco A");
        ambiente.setSetor(setor);
        esporte.setAmbiente(ambiente);
        esporte.setDataEvento(date);
        esporte.setDataInclusao(date);
        esporte.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eget leo quis elit pulvinar gravida in quis orci. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum congue maximus cursus. Sed faucibus felis eu ligula gravida, vel tincidunt purus bibendum. In volutpat ornare nisl, id egestas ligula gravida vitae. Proin mollis luctus bibendum. Suspendisse a elit lacinia, auctor leo eget, tincidunt velit. Duis lobortis tempor elit ut ullamcorper. Sed a ultricies erat, et scelerisque lacus. Pellentesque in ullamcorper felis, molestie semper ex. Donec neque ligula, rhoncus sed rhoncus nec, venenatis ac nulla.");
        esporte.setEquipe("Herlan;Faran:Toin;Rennan;Alana;Dhyego");
        Ingresso ingresso = new Ingresso();
        ingresso.setQuantidade(100);
        ingresso.setQuantidadeDisponivél(50);
        ingresso.setValor(100.0);
        ingresso.setValorDeDesconto(50);
        ingresso.setMensagem("Promoção para os Primeiros Participantes");
        esporte.setIngresso(ingresso);
        esporte.setNome("Encontrão");
        esporte.setSinopse("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eget leo quis elit pulvinar gravida in quis orci. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum congue maximus cursus. Sed faucibus felis eu ligula gravida, vel tincidunt purus bibendum. In volutpat ornare nisl, id egestas ligula gravida vitae. Proin mollis luctus bibendum. Suspendisse a elit lacinia, auctor leo eget, tincidunt velit. Duis lobortis tempor elit ut ullamcorper. Sed a ultricies erat, et scelerisque lacus. Pellentesque in ullamcorper felis, molestie semper ex. Donec neque ligula, rhoncus sed rhoncus nec, venenatis ac nulla.");
        Contatos contatos = new Contatos();
        contatos.setNome("FH Divulgações");
        contatos.setEndereco("Alexandria/RN - Avenida Deputado Patrício de Figueredo Neto, 469, Cascalho");
        contatos.setEmail("alunos@ifrn.edu.br");
        contatos.setTelefone("(84) 99999-9999");
        esporte.setContatos(contatos);

        cadastrar.cadastrarEsporte(esporte);

        cadastrar.listarEventos();
        //FIM DO MODELO PARA PREENCHIMENTO

        // criação do documento
        Rectangle layout = new Rectangle(PageSize.A3);
        layout.setBackgroundColor(BaseColor.WHITE);
        Document document = new Document(layout);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(esporte.getNome()));
            document.open();

            String pathImage = "src/imagens/esporteLogo.png";
            
            adicionarLogo(document, pathImage);

            //MODEL
            adicionarParagrafoEsquerda(document, formatarData.DateToString(esporte.getDataEvento()), Fonts.TIMES_ROMAN_RED_NORMAL_16);
            adicionarParagrafoCentralizado(document, esporte.getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
            adicionarParagrafoJustificado(document, esporte.getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_16);
            adicionarParagrafoJustificado(document, esporte.getSinopse(), Fonts.TIMES_ROMAN_BLACK_NORMAL_16);
            adicionarTabelaEquipe(document, esporte.getEquipe(), null);
            adicionarParagrafoCentralizado(document, esporte.getAmbiente().getNome(), Fonts.TIMES_ROMAN_BOLD_UNDERLINE_BLACK_24);
            adicionarParagrafoEsquerda(document, esporte.getAmbiente().getSetor().toString(), Fonts.TIMES_ROMAN_BLACK_NORMAL_16);
            adicionarParagrafoEsquerda(document, esporte.getAmbiente().getDescricao(), Fonts.TIMES_ROMAN_BLACK_NORMAL_16);
            adicionarParagrafoEsquerda(document, esporte.getAmbiente().getEndereco(), Fonts.TIMES_ROMAN_BLACK_NORMAL_16);
            adicionarParagrafoEsquerda(document, esporte.getAmbiente().getProntoReferencia(), Fonts.TIMES_ROMAN_BLACK_NORMAL_16);
            adicionarParagrafoDireita(document, esporte.getIngresso().toString(), Fonts.TIMES_ROMAN_RED_BOLD_20);
            adicionarParagrafoCentralizado(document, esporte.getContatos().toString(), Fonts.TIMES_ROMAN_BOLD_BLACK_16);
            //END            

            JOptionPane.showMessageDialog(null, "Arquivo gerado com com sucesso!");
        } catch (DocumentException | IOException de) {
            JOptionPane.showMessageDialog(null, de.getMessage());
        } finally {
            document.close();
        }
    }

    public void gerarPlanfletoEsporte(Esporte esporte) {
        String pathImage = "src/imagens/esporteLogo.png";
    }

    public void gerarPlanfletoFilme(Filme filme) {

    }

    public void gerarPlanfletoPeca(Peca peca) {

    }

    public void gerarPlanfletoShow(Show show) {

    }

    public static void adicionarLogo(Document document, String path) throws DocumentException, BadElementException, IOException {
        Image image = Image.getInstance(path);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);
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

    public static void adicionarParagrafoInferior(Document document, String conteudo, Font font) throws DocumentException {
        Paragraph paragraph = new Paragraph(conteudo, font);
        paragraph.setAlignment(Element.ALIGN_BOTTOM);
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
            cell = new PdfPCell(new Phrase(""+i));
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
