package fotos.social.dados;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String legenda;
    private Image foto;

    // TODO -> tipo string como placeholder para foto
    private List<Usuario> favorito;
    private int id;

    // TODO -> Implementação de id atrelado a banco de dados.
    public Post(Image foto, String legenda) {
        this.foto = foto;
        this.legenda = legenda;
        favorito = new ArrayList<Usuario>(0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post() {
        favorito = new ArrayList<Usuario>(0);
    }

    public int getId() {
        return id;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public void addFav(Usuario u) {
        favorito.add(u);
    }

    @Override
    public String toString() {
        String s = "";
        s +=  legenda;
        if (favorito.size() > 0) {
            s += "\n Favoritos: ";
            for (int i = 0; i < favorito.size() - 1; i++) {
                s += favorito.get(i).getNomePerfil() + ", ";
            }
            s += favorito.get(favorito.size() - 1).getNomePerfil() + ".";
        }
        return s;
    }

}
