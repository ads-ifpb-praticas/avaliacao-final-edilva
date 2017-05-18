
package br.edu.ifpb.praticas.avaliacao.praticas.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Edilva
 */
@Entity
public class Foto implements Serializable, Comparable<Foto>{
    
    @Id
    @GeneratedValue
    private int id;
    private String foto;
    private String titulo;
    private String descricao;
    @Embedded
    private Local local;

    public Foto(int id, String foto, String titulo, String descricao, Local local) {
        this.id = id;
        this.foto = foto;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
    }

    public Foto(String foto, String titulo, String descricao, Local local) {
        this.foto = foto;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
    }

    public Foto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.foto);
        hash = 37 * hash + Objects.hashCode(this.titulo);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.local);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Foto other = (Foto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Foto{" + "id=" + id + ", foto=" + foto + ", titulo=" + titulo + ", descricao=" + descricao + ", local=" + local + '}';
    }

    @Override
    public int compareTo(Foto o) {
        return this.getTitulo().compareTo(o.getTitulo());
    }
    
}
