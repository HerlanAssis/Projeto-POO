package br.com.ifrn.panfleto.ingresso;

public class Promoção {

    private String mensagem;
    private int quantidadeDisponivél;
    private double valorDeDesconto;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getQuantidadeDisponivél() {
        return quantidadeDisponivél;
    }

    public void setQuantidadeDisponivél(int quantidadeDisponivél) {
        this.quantidadeDisponivél = quantidadeDisponivél;
    }

    public double getValorDeDesconto() {
        return valorDeDesconto;
    }

    public void setValorDeDesconto(double valorDeDesconto) {
        this.valorDeDesconto = valorDeDesconto;
    }

    @Override
    public String toString() {
        return "\n" + getMensagem() + "\nQuantidade Disponivél: " + getQuantidadeDisponivél()
                + "\nValor de Desconto R$: " + getValorDeDesconto();
    }

}
