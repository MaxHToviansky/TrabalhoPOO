package fotos.social.apresentacao;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fotos.social.dados.Sessao;
import fotos.social.negocio.Sistema;

public class Base extends JFrame {
    private static Base base = null;
    private JPanel painel = new JPanel();
    private Cadastro cadastro = new Cadastro();
    private Login login = new Login();
    private PaginaPrincipal mainPage = null;
    private Sessao ses = null;
    private BuscaUsuarios busca = null;

    private Base(){
        setTitle("Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,720,480);
        
        setContentPane(painel);
        painel.setLayout(null);
        painel.setBackground(new Color(153, 255, 204));
        painel.add(login.getLoginPanel());
        cadastro.getCadastroPanel().setVisible(false);
        painel.add(cadastro.getCadastroPanel());
    }

    public static Base getInstance(){
        if(base==null)
            base = new Base();
        return base;
    }

    public void cadastroEvent(JPanel origin){
        origin.setVisible(false);
        cadastro.getCadastroPanel().setVisible(true);
    }

    public void loginPageEvent(JPanel origin){
        origin.setVisible(false);
        login.getLoginPanel().setVisible(true);
    } 

    public void loginEvent(Sessao ses, JPanel origin){
        this.ses = ses;
        origin.setVisible(false);
        if(mainPage!=null){
            painel.remove(mainPage.getPanel());
            mainPage = null;
        }
        if(busca!=null){
            painel.remove(busca.getPanel());
            busca = null;
        }
        mainPage = new PaginaPrincipal(ses);
        busca = new BuscaUsuarios(ses);
        busca.getPanel().setVisible(false);
        painel.add(busca.getPanel());
        painel.add(mainPage.getPanel());
    }

    public Sessao getSes() {
        return ses;
    }

    public void buscaEvent(JPanel origin){
        origin.setVisible(false);
        busca.getPanel().setVisible(true);
    }

    public void paginaPrincipalEvent(JPanel origin){
        origin.setVisible(false);
        mainPage.getPanel().setVisible(true);
    }

    public void logoff(JPanel origin){
        origin.setVisible(false);
        login.getLoginPanel().setVisible(true);
        Sistema.getInstance().logoff(ses);
        ses = null;
        painel.remove(mainPage.getPanel());
        painel.remove(busca.getPanel());
        mainPage = null;
        busca = null;
    }
    
}
