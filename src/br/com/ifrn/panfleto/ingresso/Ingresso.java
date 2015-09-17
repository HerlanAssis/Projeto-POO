package br.com.ifrn.panfleto.ingresso;

/**
 * A classe ingresso herda da classe promoção, ele é responsavél por gerar valor do evento
 * junto com seu publico máximo, ainda falta corrigir alguns bugs basicos como valores negativos;
 */
public class Ingresso extends Promoção {

    private double valor;
    private int quantidade;        

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nIngressos à venda: " + "Valor R$: " + getValor()
                + "\nTotal de ingressos à venda: " + getQuantidade() + super.toString();                
    }

}