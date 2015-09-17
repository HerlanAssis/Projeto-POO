package br.com.ifrn.panfleto.envento;

/**
 * Esta classe herda da classe evento e cria um evento do tipo shoe, com atributos especifícos.
 */

import br.com.ifrn.panfleto.Evento;

public class Show extends Evento{

    private String nome;
    private String artista;
    private String estilo;

    public Show(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }        

    @Override
    public String toString() {
        return "\"" +getNome() + "\n" + getArtista() + "\n" + getEstilo() + "\"";
    }        
}
