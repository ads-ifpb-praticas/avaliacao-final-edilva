
package br.edu.ifpb.praticas.avaliacao.praticas.dao;

import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Foto;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface FotoDAO {
    
    boolean salvar(Album album, Foto foto);
    boolean altualizar(Foto foto);
    boolean remover(Album album, Foto foto);
    Foto exibir(int id);
    List<Foto> listar();
}
