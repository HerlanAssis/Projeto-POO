package br.com.ifrn.panfleto.utilitario;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class EventTable extends PdfPageEventHelper{

    protected PdfPTable footer;

    public EventTable(PdfPTable footer) {
        this.footer = footer;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        footer.writeSelectedRows(0, -1, document.leftMargin(), document.bottom() + 20, writer.getDirectContent());
    }
}
