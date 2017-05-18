
package br.edu.ifpb.praticas.avaliacao.praticas.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Edilva
 */
@Entity
public class Album implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate data;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Foto> fotos = new ArrayList<>();

    public Album(int id, String nome, LocalDate data, List<Foto> fotos) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.fotos = fotos;
    }

    public Album(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public Album() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
    
    public void addFoto(Foto foto){
        this.fotos.add(foto);
    }
    
    public void removeFoto(Foto foto){
        this.fotos.remove(foto);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.data);
        hash = 13 * hash + Objects.hashCode(this.fotos);
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
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.fotos, other.fotos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", nome=" + nome + ", data=" + data + ", fotos=" + fotos + '}';
    }
    
}
