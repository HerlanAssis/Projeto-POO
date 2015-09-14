package br.com.ifrn.panfleto.cadastrar;

import br.com.ifrn.panfleto.FormalizarEvento;
import br.com.ifrn.panfleto.envento.*;
import java.util.ArrayList;

public class Cadastrar implements FormalizarEvento{
    //Locais
    private ArrayList<Esporte> esporte;
    private ArrayList<Filme> filme;
    private ArrayList<Peca> peca;
    private ArrayList<Show> show;
    private static Cadastrar uniqueInstance;

    private Cadastrar (){
        esporte = new ArrayList<>();
        filme = new ArrayList<>();
        peca = new ArrayList<>();
        show = new ArrayList<>();
    }        

    public static Cadastrar getUniqueInstance() {
        if(uniqueInstance == null){
            uniqueInstance = new Cadastrar();
        }
        
        return uniqueInstance;
    }

    public static void setUniqueInstance(Cadastrar uniqueInstance) {
        Cadastrar.uniqueInstance = uniqueInstance;
    }
    
    @Override
    public void cadastrarEsporte(Esporte esporte) {
        this.esporte.add(esporte);
    }
    
    @Override
    public void deletarEsporte() {
        this.esporte.clear();
    }

    @Override
    public void cadastrarFilme(Filme filme) {
        this.filme.add(filme);
    }
    
    @Override
    public void deletarFilme() {
        this.filme.clear();
    }

    @Override
    public void cadastrarPeca(Peca peca) {
        this.peca.add(peca);
    }
    
    @Override
    public void deletarPeca() {
        this.peca.clear();
    }

    @Override
    public void cadastrarShow(Show show) {
        this.show.add(show);
    }
  
    @Override
    public void deletarShow() {
        this.show.clear();
    }
    
    @Override
    public void listarEventos() {
        for (int i = 0; i < esporte.size(); i++) {
            System.out.println(this.esporte.get(i).toString());
        }
        
        for (int i = 0; i < filme.size(); i++) {
            System.out.println(this.filme.get(i).toString());
        }
    }
}