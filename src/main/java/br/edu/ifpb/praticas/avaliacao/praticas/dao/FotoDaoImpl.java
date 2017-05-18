package br.edu.ifpb.praticas.avaliacao.praticas.dao;

import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Foto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Edilva
 */
public class FotoDaoImpl implements FotoDAO {

    @Inject
    private EntityManager manager;

    public FotoDaoImpl() {
    }

    @Override
    public boolean salvar(Album album, Foto foto) {
        boolean retorno = false;
        try {
            album.addFoto(foto);
            manager.getTransaction().begin();
            manager.merge(album);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public boolean altualizar(Foto foto) {
        boolean retorno = false;
        try {
            manager.getTransaction().begin();
            manager.merge(foto);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public boolean remover(Album album, Foto foto) {
        boolean retorno = false;
        try {
            album.removeFoto(foto);
            manager.getTransaction().begin();
            manager.merge(album);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public Foto exibir(int id) {
        return manager.find(Foto.class, id);
    }

    @Override
    public List<Foto> listar() {
        TypedQuery<Foto> query = manager
                .createQuery("SELECT f FROM Foto f", Foto.class);
        return query.getResultList();
    }

}
