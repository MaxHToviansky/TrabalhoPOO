package fotos.social.negocio;

import java.util.ArrayList;
import java.util.List;

import fotos.social.dados.Post;
import fotos.social.dados.Sessao;
import fotos.social.dados.Usuario;

public class Sistema {
    private static Sistema sys = null;
    private List<Usuario> usuarios;
    private List<Post> posts;
    private List<Sessao> sessoes;
    private int idCounter = 0;
    // id é simplorio porém unico para cada execução.
    private Sistema() {
        usuarios = new ArrayList<Usuario>(0);
        posts = new ArrayList<Post>(0);
        sessoes = new ArrayList<Sessao>(0);
    }

    public static Sistema getInstance(){
        if(sys == null)
            sys = new Sistema();
        return sys;
    }

    public boolean cadastroUsuario(Usuario u){
        if(u==null)
            return false;
        assert u.getNomePerfil() != null && u.getSenha() != null;
        usuarios.add(u);
        u.setId(idCounter);
        idCounter++;
        return true;
    }

    public Sessao login(String nomePerfil, String senha){
        Sessao tmp = null;
        for(Usuario u : usuarios){
            if (u.getNomePerfil().equals(nomePerfil) && u.getSenha().equals(senha)) {
                tmp = new Sessao(idCounter, u);
                sessoes.add(tmp);
                idCounter++;
                return tmp;
            }
        }
        return tmp;
    }

    public boolean logoff(Sessao s){
        return sessoes.remove(s);
    }

    public List<Post> getPostSeguindo(Sessao sesId){
        if(sesId ==null || !sessoes.contains(sesId))
            return null;
        List<Post> asw = new ArrayList<Post>(0);
        for(Usuario  a : sesId.getLoggedAs().getSegue()){
            asw.addAll(a.getPostados());
        }
        return asw;
    }

    public boolean postFoto(Sessao sesId, Post p){
        if(p == null || sesId == null || !sessoes.contains(sesId))
            return false;
        assert p.getFoto() != null && p.getLegenda()!=null;
        
        p.setId(idCounter);
        posts.add(p);
        idCounter++;
        sesId.getLoggedAs().postar(p);
        return true;
    }

    public List<Usuario> getSeguindo(Sessao sesId){
        if(sesId == null || !sessoes.contains(sesId))
            return null;
        return sesId.getLoggedAs().getSegue();
    }

    public Usuario search(String s){
        for (Usuario u : usuarios) {
            if(u.getNomePerfil().equals(s))
                return u;
        }
        return null;
    }

    public boolean seguir(Sessao sesId, Usuario u){
        if(sesId!= null && u != null && !sesId.getLoggedAs().equals(u)){
            sesId.getLoggedAs().seguir(u);
            return true;
        }
        return false;
    }

    public boolean desSeguir(Sessao sesId, Usuario u){
        if(sesId == null || u ==null)
            return false;
        return sesId.getLoggedAs().desSeguir(u);
    }

    public boolean favoritar(Sessao sesId, Post p){
        if(sesId == null || p ==null || !sessoes.contains(sesId))
            return false;
        p.addFav(sesId.getLoggedAs());
        return true;
    }

    // Funções para teste.

    public List<Usuario> getUsers(){
        return usuarios;
    }
}
