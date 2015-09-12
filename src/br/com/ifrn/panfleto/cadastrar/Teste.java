package br.com.ifrn.panfleto.cadastrar;

import br.com.ifrn.panfleto.Ambiente;
import br.com.ifrn.panfleto.Setor;
import br.com.ifrn.panfleto.envento.Esporte;
import br.com.ifrn.panfleto.ingresso.Ingresso;
import br.com.ifrn.panfleto.utilitario.FormatarData;
import java.util.Date;

public class Teste {

    public static void main(String[] args) throws Exception {
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
        esporte.setDescricao("1º Encontro de amigos");
        esporte.setEquipe("Todo mundo");
        Ingresso ingresso = new Ingresso();
        ingresso.setQuantidade(100);
        ingresso.setQuantidadeDisponivél(50);
        ingresso.setValor(100.0);
        ingresso.setValorDeDesconto(50);
        ingresso.setMensagem("Promoção para os Primeiros Participantes");
        esporte.setIngresso(ingresso);
        esporte.setNome("Encontrão");
        esporte.setSinopse("Vai ser o primeiro encontro e tal e tal bla bla");

        cadastrar.cadastrarEsporte(esporte);

        cadastrar.listarEventos();

    }
}
