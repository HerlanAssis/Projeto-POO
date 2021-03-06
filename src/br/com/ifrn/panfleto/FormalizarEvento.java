package br.com.ifrn.panfleto;

/**
 * A interface Formalizar evento serve para ter um controle das principais funções da classe cadastrar. 
 */

import br.com.ifrn.panfleto.envento.*;

public interface FormalizarEvento {
    public void cadastrarEsporte(Esporte esporte);
    public void deletarEsporte();
    
    public void cadastrarFilme(Filme filme);
    public void deletarFilme();
    
    public void cadastrarPeca(Peca peca);
    public void deletarPeca();
    
    public void cadastrarShow(Show show);
    public void deletarShow();
    
    public void listarEventos();
}
