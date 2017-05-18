package testes;

import br.edu.ifpb.praticas.avaliacao.praticas.entities.Album;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Foto;
import br.edu.ifpb.praticas.avaliacao.praticas.entities.Local;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class AlbumTest {
    
    private Album album;

    @Test
    public void albumNulo() {
        Assert.assertNull(album);
    }
    
    @Test
    public void albumSemFotos(){
        List<Foto> fotos = new ArrayList<>();
        album = new Album(1, "Férias", LocalDate.now(), fotos);
        Assert.assertTrue(album.getFotos().isEmpty());
    }
    
    @Test
    public void albumComFotos(){
        List<Foto> fotos = new ArrayList<>();
        album = new Album(1, "Férias", LocalDate.now(), fotos);
        album.addFoto(new Foto(1, "foto", "Praia", "Sol e mar!", new Local("PB", "João Pessoa")));
        Assert.assertTrue(!album.getFotos().isEmpty());
    }
    
    @Test
    public void setNome(){
        List<Foto> fotos = new ArrayList<>();
        album = new Album(1, "Férias", LocalDate.now(), fotos);
        album.setNome("As férias dos sonhos");
        Assert.assertEquals("As férias dos sonhos", album.getNome());
    }
}
