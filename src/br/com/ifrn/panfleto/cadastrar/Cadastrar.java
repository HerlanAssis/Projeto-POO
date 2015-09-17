package br.com.ifrn.panfleto.cadastrar;

/**
 *A classe cadastrar tem a função de servir de ponte entre o frame e as classes auxiliares
 * utilizando também a opcao de referência única ela funciona como uma espécie de "contole remoto"
 * entre a interface e as demais classes.
 */

import br.com.ifrn.panfleto.FormalizarEvento;
import br.com.ifrn.panfleto.envento.*;
import br.com.ifrn.panfleto.gerarpdf.PdfCreator;
import br.com.ifrn.panfleto.utilitario.AbrirPasta;
import br.com.ifrn.panfleto.utilitario.FormatarData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Cadastrar implements FormalizarEvento {

    //Locais
    private ArrayList<Esporte> esporte;
    private ArrayList<Filme> filme;
    private ArrayList<Peca> peca;
    private ArrayList<Show> show;
    private final AbrirPasta abrirPasta = new AbrirPasta();
    private final FormatarData formatarData = new FormatarData();
    private PdfCreator pdfCreator;
    private static Cadastrar uniqueInstance;

    private Cadastrar() {
        esporte = new ArrayList<>();
        filme = new ArrayList<>();
        peca = new ArrayList<>();
        show = new ArrayList<>();
    }

    public PdfCreator getPdfCreator() {
        return pdfCreator;
    }

    public void setPdfCreator(PdfCreator pdfCreator) {
        this.pdfCreator = pdfCreator;
    }        

    public static Cadastrar getUniqueInstance() {
        if (uniqueInstance == null) {
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

    public ArrayList<Esporte> getEsporte() {
        return esporte;
    }

    public ArrayList<Filme> getFilme() {
        return filme;
    }

    public ArrayList<Peca> getPeca() {
        return peca;
    }

    public ArrayList<Show> getShow() {
        return show;
    }        
    
    public void abrirPasta() throws IOException{
        abrirPasta.irURL();
    }
    
    public String dateToString(Date date) throws Exception{
        return formatarData.DateToString(date);        
    }
    
    public Date stringToDate(String date) throws Exception{
        return formatarData.StringToDate(date);
    }
    
    public boolean validarData(String data) throws Exception {
        return formatarData.ValidarData(data);
    }
}
