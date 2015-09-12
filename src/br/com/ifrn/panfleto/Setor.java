package br.com.ifrn.panfleto;

public class Setor {

    private String nome;
    private int capacidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade > 0) {
            this.capacidade = capacidade;
        } else {
            this.capacidade = 1;
        }

    }

    @Override
    public String toString() {
        return "Setor: " + getNome() + " | Capacidade: " + getCapacidade();
    }

}
