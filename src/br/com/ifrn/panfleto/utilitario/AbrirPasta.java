package br.com.ifrn.panfleto.utilitario;

import br.com.ifrn.panfleto.gerarpdf.PdfCreator;
import java.io.IOException;

/**
 * Abrir pasta no linux e no windows, mais antes e preciso informar o seu gerenciador de arquivos
 */
public class AbrirPasta {
    public void irURL() throws IOException {
        String text, text2;
        text = System.getProperty("os.name");
        text = text.toLowerCase();
        text2 = PdfCreator.diretorioPrincipal;

        if (text.contains("linux") && !text2.equals("")) {
            Runtime.getRuntime().exec("caja " + PdfCreator.diretorioPrincipal); // Seu gerenciador de arquivos: konkeror (KDE), dolphin, nautilus (gnome) e etc  
            /*} catch (IOException ex) {
                System.out.println("Gerenciador de arquivos não instalado.");
            }*/
        } else if (text.contains("windows") && !text2.equals("")) {
            Runtime.getRuntime().exec("explorer.exe " + PdfCreator.diretorioPrincipal); // A url, que no caso é C:/  
            /*} catch (IOException ex) {
                System.out.println("Desculpe, falha na execução dessa função!");
            }*/
        }
    }
}
