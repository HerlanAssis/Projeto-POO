package br.com.ifrn.panfleto.envento;

import br.com.ifrn.panfleto.Evento;

public class Peca extends Evento{

    private String nome;
    private String companhia;
    private String genero;
    private int censura;

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

    public int getCensura() {
        return censura;
    }

    public void setCensura(int censura) {
        this.censura = censura;
    }        
    
    private String censuraPeca(int censura){
        if(censura < 10){
            return "Livre para todos os públicos";
        }else{
            return "Somente para maiores de " + censura + " anos.";
        }
    }

    @Override
    public String toString() {
        return "Informaçoẽs Técnicas: \nNome: " + getNome() + "\nGenêro: " + getGenero() + "\nCompanhia: " + getCompanhia() + "\nCensura: " + censuraPeca(getCensura());
    }    
}
