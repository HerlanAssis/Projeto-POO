package br.com.ifrn.panfleto;

/*
**A classe contato armazenas as informações que serão utilizadas no rodapé do documento pdf
*/

public class Contatos {
    private String nome;
    private String endereco;
    private String telefone;
    private String email; 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getNome() + "\n" + getEmail() + " - " + getTelefone() + "\n" + getEndereco();
    }       
}
