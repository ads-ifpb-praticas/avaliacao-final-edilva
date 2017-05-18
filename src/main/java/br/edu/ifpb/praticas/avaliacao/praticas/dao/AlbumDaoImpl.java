package br.edu.ifpb.praticas.avaliacao.praticas.dao;

import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
public class AlbumDaoImpl implements AlbumDAO {

    @Inject
    private EntityManager manager;

    public AlbumDaoImpl() {
    }

    @Override
    public boolean salvar(Album album) {
        boolean retorno = false;
        try {
            manager.getTransaction().begin();
            manager.persist(album);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public boolean altualizar(Album album) {
        boolean retorno = false;
        try {
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
    public boolean remover(Album album) {
        boolean retorno = false;
        try {
            manager.getTransaction().begin();
            manager.remove(album);
            manager.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            manager.getTransaction().rollback();
        }
        return retorno;
    }

    @Override
    public Album exibir(int id) {
        return manager.find(Album.class, id);
    }

    @Override
    public List<Album> listar() {
        List<Album> albuns;
        Query query = manager.createQuery("SELECT a FROM Album a");
        albuns = query.getResultList();
        return albuns;
    }

}
