package br.com.ifrn.panfleto.utilitario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Classe responsavél pelo controle de data do programa. Realiza conversões das datas.
 */
public class FormatarData {

    final private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Date StringToDate(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = simpleDateFormat;
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public String DateToString(Date date) throws Exception {
        String data = "";
        try {
            data = simpleDateFormat.format(date);
        } catch (Exception e) {
            throw e;
        }
        return " - Data da inclusão: " + data;
    }

    public boolean ValidarData(String data) throws Exception {
        DateFormat df = simpleDateFormat;
        df.setLenient(false); // aqui o pulo do gato  
        try {
            df.parse(data);
            return true;
            // data válida  
        } catch (ParseException ex) {
            return false;
        }
    }
}
