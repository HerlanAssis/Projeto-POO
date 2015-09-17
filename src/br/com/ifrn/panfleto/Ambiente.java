package br.com.ifrn.panfleto;

/*
**A classe ambiente armazena o local do evento em questão juntamenta com seu endereço
*/

public class Ambiente {
    
    private String nome;
    private String descricao;  
    private String endereco;
    private String prontoReferencia;
    private Setor setor;

    public Ambiente(){}

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntoReferencia() {
        return prontoReferencia;
    }

    public void setProntoReferencia(String prontoReferencia) {
        this.prontoReferencia = prontoReferencia;
    }

    @Override
    public String toString() {
        return getSetor().toString() + "\nNome: " + getNome() +
                "\nDescrição: " + getDescricao() +
                "\nEndereço: " + getEndereco() + "\nPonto de Referência: " + getProntoReferencia();
    }        
}
