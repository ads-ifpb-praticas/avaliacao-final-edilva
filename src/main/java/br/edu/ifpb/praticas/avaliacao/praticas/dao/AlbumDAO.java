
package br.edu.ifpb.praticas.avaliacao.praticas.dao;

import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AlbumDAO {
    
    boolean salvar(Album album);
    boolean altualizar(Album album);
    boolean remover(Album album);
    Album exibir(int id);
    List<Album> listar();
    
}
