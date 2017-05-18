
package br.edu.ifpb.praticas.avaliacao.praticas.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Edilva
 */
@Embeddable
public class Local implements Serializable{
    
    private String uf;
    private String cidade;

    public Local(String uf, String cidade) {
        this.uf = uf;
        this.cidade = cidade;
    }

    public Local() {
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Local{" + "uf=" + uf + ", cidade=" + cidade + '}';
    }
    
}
