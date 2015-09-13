package br.com.ifrn.panfleto.envento;

import br.com.ifrn.panfleto.Evento;

public class Filme extends Evento{
    private String nome;
    private int censura;    
    private String estreia;
    private String genero;   

    public Filme(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCensura() {
        return censura;
    }

    public void setCensura(int censura) {
        this.censura = censura;
    }        

    public String getEstreia() {
        return estreia;
    }

    public void setEstreia(String estreia) {
        this.estreia = estreia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String censuraFilme(int censura){
        if(censura < 10){
            return "Livre para todos os públicos";
        }else{
            return "Somente para maiores de " + censura + " anos.";
        }
    }
    
    public String informacoesTecnicas(){
     return "Informações Técnicas: "
                + "\nEstreia: " + getEstreia() + "\nGenêro: " + getGenero() + "\nCensura: " + censuraFilme(getCensura());
    }            
}
