package fotos.social.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fotos.social.dados.Sessao;
import fotos.social.dados.Usuario;
import fotos.social.negocio.Sistema;

public class Cadastro extends JFrame {

    private JPanel cadastroPainel = new JPanel();
    private JLabel cadastroHeader = new JLabel("Cadastro");

    private JLabel realnameHeader = new JLabel("Nome Completo");
    private JTextField realnameInput = new JTextField();

    private JLabel usernameHeader = new JLabel("Nome de Usuário");
    private JTextField usernameInput = new JTextField();

    private JLabel passwordHeader = new JLabel("Senha");
    private JPasswordField passwordInput = new JPasswordField();

    private JButton cadastroButton = new JButton("Confirmar");

    private JLabel loginHeader = new JLabel("Já tem uma conta?");
    private JButton loginButton = new JButton("Login");

    public Cadastro() {

        cadastroPainel.setLayout(null);
        cadastroPainel.setBounds(228, 50, 225, 300);
        cadastroPainel.setBackground(new Color(0, 179, 89));

        cadastroHeader.setFont(new Font("Arial", Font.BOLD, 25));
        cadastroHeader.setHorizontalAlignment(SwingConstants.CENTER);
        cadastroHeader.setBounds(57, 30, 114, 30);
        cadastroPainel.add(cadastroHeader);

        usernameHeader.setFont(new Font("Arial",Font.PLAIN,17));
        usernameHeader.setHorizontalAlignment(SwingConstants.CENTER);
        usernameHeader.setBounds(43,70,150,30);
        cadastroPainel.add(usernameHeader);

        usernameInput.setFont(new Font("Arial",Font.PLAIN,17));
        usernameInput.setBounds(32, 100, 160, 20);
        cadastroPainel.add(usernameInput);

        realnameHeader.setFont(new Font("Arial",Font.PLAIN,17));
        realnameHeader.setHorizontalAlignment(SwingConstants.CENTER);
        realnameHeader.setBounds(32,125, 160,20);
        cadastroPainel.add(realnameHeader);

        realnameInput.setFont(new Font("Arial",Font.PLAIN,17));
        realnameInput.setBounds(32,150, 160,20);
        cadastroPainel.add(realnameInput);
        
        passwordHeader.setFont(new Font("Arial",Font.PLAIN,17));
        passwordHeader.setHorizontalAlignment(SwingConstants.CENTER);
        passwordHeader.setBounds(32,173, 160,20);
        cadastroPainel.add(passwordHeader);
        
        passwordInput.setBounds(32,195, 160,20);
        cadastroPainel.add(passwordInput);

        cadastroButton.setFont(new Font("Arial",Font.PLAIN,17));
        cadastroButton.setBounds(45,225,130,20);
        cadastroPainel.add(cadastroButton);

        loginHeader.setFont(new Font("Arial",Font.PLAIN,13));
        loginHeader.setHorizontalAlignment(SwingConstants.CENTER);
        loginHeader.setBounds(32,245,160,20);
        cadastroPainel.add(loginHeader);

        loginButton.setFont(new Font("Arial",Font.PLAIN,13));
        loginButton.setBounds(45,265,130,20);
        cadastroPainel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Base base = Base.getInstance();
                base.loginPageEvent(cadastroPainel);
            }
        });
        
        cadastroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Sistema sys = Sistema.getInstance();
                String username,fullname,password;
                username = usernameInput.getText();
                fullname = realnameInput.getText();
                password = String.valueOf(passwordInput.getPassword());

                usernameInput.setText("");
                realnameInput.setText("");
                passwordInput.setText("");
                
                sys.cadastroUsuario(new Usuario(username, fullname, password, ""));
                Sessao ses = sys.login(username, password);
                Base.getInstance().loginEvent(ses,cadastroPainel);
                //Abrir pagina principal
            }
        });
    }

    public JPanel getCadastroPanel() {
        return cadastroPainel;
    }
}
