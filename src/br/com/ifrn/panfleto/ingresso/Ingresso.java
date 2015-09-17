package br.com.ifrn.panfleto.ingresso;

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
                + "\nTotal de ingressos á venda: " + getQuantidade() + super.toString();                
    }

}