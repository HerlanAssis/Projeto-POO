package br.com.ifrn.panfleto.cadastrar;

import br.com.ifrn.panfleto.Ambiente;
import br.com.ifrn.panfleto.Contatos;
import br.com.ifrn.panfleto.Setor;
import br.com.ifrn.panfleto.envento.Esporte;
import br.com.ifrn.panfleto.envento.Filme;
import br.com.ifrn.panfleto.envento.Peca;
import br.com.ifrn.panfleto.envento.Show;
import br.com.ifrn.panfleto.gerarpdf.PdfCreator;
import br.com.ifrn.panfleto.ingresso.Ingresso;
import br.com.ifrn.panfleto.utilitario.FormatarData;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Teste {

    public static void main(String[] args) throws Exception {
        Date date = new Date(System.currentTimeMillis());
        FormatarData formatarData = new FormatarData();

        Cadastrar cadastrar = Cadastrar.getUniqueInstance();                        
        
        Esporte esporte = new Esporte();
        esporte.setNome("Encontrão");
        esporte.setEquipe("Herlan;Savio;Faran;Toin");
        esporte.setSinopse("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        esporte.setDescricao("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        esporte.setDuracao(180);
        
        Ambiente ambiente = new Ambiente();
        ambiente.setNome("Ginásio Poliespotivo");
        ambiente.setDescricao("Local Arejado e em otimas condições");
        ambiente.setEndereco("Avenia Deputado Patricio de Figueredo Neto, Cascalho, 469, Alexandria/RN");
        ambiente.setProntoReferencia("Proximo ao Bar da Cajarana");
        Setor setor = new Setor();
        setor.setCapacidade(1000);
        setor.setNome("Bloco Único");
        ambiente.setSetor(setor);
        esporte.setAmbiente(ambiente);
        
        Contatos contatos = new Contatos();
        contatos.setNome("FH Divulgações");
        contatos.setEmail("alunos@ifrn.edu.br");
        contatos.setTelefone("(84) 99876-5432");
        contatos.setEndereco("Avenida Deputado, Centro, Alexandria/RN, 59965-000");
        esporte.setContatos(contatos);
        esporte.setDataEvento(date);
        
        Ingresso ingresso = new Ingresso();
        ingresso.setMensagem("Promoção do dia!");
        ingresso.setQuantidade(100);
        ingresso.setQuantidadeDisponivél(50);
        ingresso.setValor(20);
        ingresso.setValorDeDesconto(2);
        
        esporte.setIngresso(ingresso);                

        cadastrar.cadastrarEsporte(esporte);
        
        Filme filme = new Filme();        
        filme.setNome("Interestelar");
        filme.setGenero("Ficção Científica");
        filme.setEstreia("Hoje!");
        filme.setCensura(16);
        filme.setAmbiente(ambiente);
        filme.setContatos(contatos);
        filme.setDataEvento(date);
        filme.setSinopse("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        filme.setDescricao("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        filme.setDuracao(189);
        filme.setIngresso(ingresso);    
        
        cadastrar.cadastrarFilme(filme);   
        
        Peca peca = new Peca();
        peca.setNome("Hermanoteu Na Terra de Godah");
        peca.setGenero("Comédia");
        peca.setCompanhia("Os melhores do mundo");
        peca.setCensura(0);
        peca.setAmbiente(ambiente);
        peca.setContatos(contatos);
        peca.setDataEvento(date);
        peca.setDuracao(100);
        peca.setIngresso(ingresso);
        peca.setSinopse("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        peca.setDescricao("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        
        Show show = new Show();
        show.setNome("Rock In Rio");
        show.setEstilo("Rock");
        show.setDataEvento(date);        
        show.setArtista("Vários Artistas");
        show.setAmbiente(ambiente);
        show.setContatos(contatos);
        show.setDuracao(300);
        show.setIngresso(ingresso);
        show.setSinopse("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        show.setDescricao("Mussum ipsum cacilds, vidis litro abertis. "
                + "Consetis adipiscings elitis. Pra lá , depois divoltis "
                + "porris, paradis. Paisis, filhis, espiritis santis. "
                + "Mé faiz elementum girarzis, nisi eros vermeio, in elementis "
                + "mé pra quem é amistosis quis leo. Manduma pindureta quium dia "
                + "nois paga. Sapien in monti palavris qui num significa nadis i pareci "
                + "latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.");
        
        cadastrar.listarEventos();

        Rectangle rectangle = new Rectangle(PageSize.A3);

        PdfCreator pdfCreator = new PdfCreator(rectangle, date, BaseColor.WHITE);

        try {
            pdfCreator.gerarPlanfletoEsporte(esporte);
            pdfCreator.gerarPlanfletoFilme(filme);            
            pdfCreator.gerarPlanfletoPeca(peca);
            pdfCreator.gerarPlanfletoShow(show);
            JOptionPane.showMessageDialog(null, "Arquivo gerado com com sucesso!");
        } catch (DocumentException | IOException de) {
            JOptionPane.showMessageDialog(null, de.getMessage());
        }        
    }
}
