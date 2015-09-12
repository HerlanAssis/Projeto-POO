package br.com.ifrn.panfleto.envento;

import br.com.ifrn.panfleto.Evento;
import br.com.ifrn.panfleto.ingresso.Ingresso;
import java.util.Date;

public class Peca extends Evento{

    private String nome;
    private String companhia;
    private String genero;

    public Peca(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
   
}
