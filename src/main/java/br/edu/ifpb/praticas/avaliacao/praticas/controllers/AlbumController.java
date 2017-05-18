
package br.edu.ifpb.praticas.avaliacao.praticas.controllers;

import br.edu.ifpb.praticas.avaliacao.praticas.dao.AlbumDAO;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import br.edu.ifpb.praticas.avaliacao.praticas.util.FacesUtil;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@RequestScoped
public class AlbumController implements Serializable {
    
    @Inject
    private AlbumDAO albumDAO;
    private Album album = new Album();
    private List<Album> albuns = new ArrayList<>();

    public AlbumController() {
    }

    public String salvar(){
        album.setData(LocalDate.now());
        if(albumDAO.salvar(album)){
            FacesUtil.addMsgInfo("Álbum criado com sucesso!");
        }else{
            FacesUtil.addMsgErro("Erro ao criar álbum!");
        }
        limpar();
        return null;
    }
    
    public String remover(Album a){
        if(albumDAO.remover(a)){
            FacesUtil.addMsgInfo("Álbum removido com sucesso!");
        }else{
            FacesUtil.addMsgErro("Erro ao remover álbum!");
        }
        return null;
    }
    
    public void editar(Album a){
        album = a;
    }
    
    public String atualizar(){
        albumDAO.altualizar(album);
        limpar();
        return null;
    }
    
    public void listar(){
        albuns = albumDAO.listar();
    }
    
    private void limpar(){
        album = new Album();
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> getAlbuns() {
        listar();
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }
    
}
