package br.com.ifrn.panfleto.envento;

/*
Esta classe cria o evendo do tipo esporte
*/

import br.com.ifrn.panfleto.Evento;

public class Esporte extends Evento {

    private String nome;
    private String equipe;

    public Esporte() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nEquipe: " + getEquipe()
                + super.toString();
    }

}
