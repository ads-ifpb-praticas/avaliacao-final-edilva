package br.edu.ifpb.praticas.avaliacao.praticas.controllers;

import br.edu.ifpb.praticas.avaliacao.praticas.dao.FotoDAO;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Foto;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Local;
import br.edu.ifpb.praticas.avaliacao.praticas.util.FacesUtil;
import br.edu.ifpb.praticas.avaliacao.praticas.util.ProcessadorDeFotos;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Edilva
 */
@Named
@RequestScoped
public class FotoController implements Serializable {

    @Inject
    private FotoDAO fotoDAO;
    private Foto foto = new Foto();
    private Local local = new Local();
    private List<Foto> fotos = new ArrayList<>();
    private Album alb = new Album();
    private Part img;

    public FotoController() {
    }

    private void processarFoto() throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        String photo = new ProcessadorDeFotos("fotos").processarFoto(request, img, foto.getTitulo());
        foto.setFoto(photo);
    }

    public String salvar() throws ServletException, IOException {
        processarFoto();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        alb = (Album) session.getAttribute("album1");
        foto.setLocal(local);
        if(fotoDAO.salvar(alb, foto)){
            FacesUtil.addMsgInfo("Foto adicionada com sucesso!");
        }else{
            FacesUtil.addMsgErro("Erro ao adicionar foto!");
        }
        limpar();
        return null;
    }

    public String remover(Foto f) {
        foto = f;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        alb = (Album) session.getAttribute("album1");
        if(fotoDAO.remover(alb, foto)){
            FacesUtil.addMsgInfo("Foto removida com sucesso!");
        }else{
            FacesUtil.addMsgErro("Erro ao remover foto!");
        }
        limpar();
        return null;
    }

    public void editar(Foto f) {
        foto = f;
    }

    public String atualizar() {
        fotoDAO.altualizar(foto);
        limpar();
        return null;
    }

    public void listar() {
        fotos = fotoDAO.listar();
    }

    private void limpar() {
        foto = new Foto();
        local = new Local();
    }

    public String pegaAlbum(Album a) {
        this.alb = a;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("album1", alb);
        return "album.xhtml";
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public List<Foto> getFotos() {
        listar();
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Album getAlb() {
        return alb;
    }

    public void setAlb(Album alb) {
        this.alb = alb;
    }

    public Part getImg() {
        return img;
    }

    public void setImg(Part img) {
        this.img = img;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

}
