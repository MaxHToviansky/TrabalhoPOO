package fotos.social.dados;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nomePerfil, nomeCompleto, senha, biografia;
    private List<Usuario> segue;
    private List<Post> postados;
        
    // TODO -> Implementação de id atrelado a banco de dados.
    public Usuario( String nomePerfil, String nomeCompleto, String senha, String biografia) {
        this.nomePerfil = nomePerfil;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.biografia = biografia;
        segue = new ArrayList<Usuario>(0);
        postados = new ArrayList<Post>(0);
    }

    public Usuario() {
        segue = new ArrayList<Usuario>(0);
        postados = new ArrayList<Post>(0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void seguir(Usuario u){
        segue.add(u);
    }

    public boolean desSeguir(Usuario u){
        return segue.remove(u);
    }

    public void postar(Post p){
        postados.add(p);
    }

    public List<Usuario> getSegue() {
        return segue;
    }

    public List<Post> getPostados() {
        return postados;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }
    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getBiografia() {
        return biografia;
    }
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        if(biografia.equals(""))
            return nomePerfil + ", " + nomeCompleto + ".";
        return nomePerfil + ", " + nomeCompleto + ". \n   -" + biografia;
    }
    
    

}
