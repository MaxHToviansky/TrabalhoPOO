package fotos.social;

import fotos.social.apresentacao.Base;
import fotos.social.dados.Sessao;
import fotos.social.dados.Usuario;
import fotos.social.negocio.Sistema;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Sistema sys = Sistema.getInstance();
        
        sys.cadastroUsuario(new Usuario("Base","","123",""));
        sys.cadastroUsuario(new Usuario("Zephyr", "Carlos Silveiro", "123", ""));
        sys.cadastroUsuario(new Usuario("Grian", "Charles Batchelor", "Xelqua", "Participante de HermitCraft"));
        sys.cadastroUsuario(new Usuario("Kettle", "Henry Boylstead", "Elektric", "Um cara que gosta de raios"));
        sys.cadastroUsuario(new Usuario("Shaco", "João Lucas", "Maestro@1231", ":D"));
        sys.cadastroUsuario(new Usuario("caCAWCAWCAW", "Corvus Corax", "CAWCAWCAW", "ohhh brilhante CAW"));

        Sessao myLogin = sys.login("Zephyr", "123");
        sys.seguir(myLogin, sys.search("Grian"));
        sys.seguir(myLogin, sys.search("caCAWCAWCAW")); 
        sys.seguir(myLogin, sys.search("Shaco"));
        sys.logoff(myLogin);

        Base base = Base.getInstance();
        base.setVisible(true);        


        


    }

    
}
