package br.com.ifrn.panfleto.utilitario;

public class FormatarTempo {
    public String timeString(int time){
        String tempo;
        tempo = "Duração: " + time/60 + " horas e " + time%60 + " minutos.";
        
        return tempo;
    }
}
