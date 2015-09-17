package br.com.ifrn.panfleto;

/*
**A classe Evento Serve de classe pai para os outros subEventos, ou seja, ela armazena as informações
**em comum de todos os eventos a serem utilizados.
*/

import br.com.ifrn.panfleto.ingresso.Ingresso;
import java.util.Date;

public class Evento {

    private String descricao;
    private Date dataInclusao;
    private Date dataEvento;
    private String sinopse;
    private int duracao;
    private Ingresso ingresso;
    private Contatos contatos;
    private Ambiente ambiente;

    public Evento(){}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getSinopse() {
        return sinopse;
    }    

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }        

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }    

    @Override
    public String toString() {
        return "\n"+getDescricao() + "\nData da Inclusão: " + getDataInclusao()
                + "\tData do Evento: " + getDataEvento()
                + getIngresso().toString()
                + getAmbiente().toString();
    }

}
