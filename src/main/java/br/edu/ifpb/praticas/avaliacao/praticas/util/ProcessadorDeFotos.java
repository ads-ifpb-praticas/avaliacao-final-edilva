
package br.edu.ifpb.praticas.avaliacao.praticas.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Edilva
 */
public class ProcessadorDeFotos {
    
    private String pasta;

    public ProcessadorDeFotos(String pasta) {
        this.pasta = pasta;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }
    
    public boolean salvarFoto(String path, InputStream item, String nameToSave) {
        try {
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }

            File savedFile = new File(f.getAbsoluteFile() + File.separator + nameToSave);
            FileOutputStream fos = new FileOutputStream(savedFile);

//            InputStream is = item.openStream();
            InputStream is = item;

            int x = 0;
            byte[] b = new byte[1024];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.flush();
            fos.close();

            return true;

        } catch (Exception ex) {
        }
        return false;
    }

    public String processarFoto(HttpServletRequest request, Part fotoPart, String nameToSave)
            throws ServletException, IOException {

        
        if (fotoPart != null & nameToSave != null) {
            InputStream fileContent = fotoPart.getInputStream();
            String contextPath = request.getServletContext().getRealPath("/");
            
            if (salvarFoto(contextPath + File.separator + pasta, fileContent, nameToSave)) {
                return pasta + "/" + nameToSave;
            }
        }

        return null;
    }
    
}
