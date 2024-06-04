package fotos.social.apresentacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fotos.social.dados.Sessao;
import fotos.social.negocio.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login{
    private JPanel loginPanel = new JPanel();
    
    private JLabel loginHeader = new JLabel("Login");
    
    private JLabel usernameHeader = new JLabel("Usuário:");
    private JTextField usernameInput = new JTextField();
    
    private JLabel passwordHeader = new JLabel("Senha:");
    private JPasswordField passwordInput = new JPasswordField();

    private JButton login = new JButton("Login");

    private JLabel cadastrarHeader = new JLabel("Não tem conta?");
    private JButton cadastro = new JButton("Cadastrar");

    public Login(){
        // Sistema sys = new Sistema();
        loginPanel.setLayout(null);
        loginPanel.setBounds(228,50,225,300);
        loginPanel.setBackground(new Color(0, 179, 89));

        loginHeader.setFont(new Font("Arial",Font.BOLD ,25));
        loginHeader.setHorizontalAlignment(SwingConstants.CENTER);
        loginHeader.setBounds(57,30,114,30);
        loginPanel.add(loginHeader);

        usernameHeader.setFont(new Font("Arial",Font.PLAIN,17));
        usernameHeader.setHorizontalAlignment(SwingConstants.CENTER);
        usernameHeader.setBounds(57,70,114,30);
        loginPanel.add(usernameHeader);

        usernameInput.setFont(new Font("Arial",Font.PLAIN,17));
        usernameInput.setBounds(32, 100, 160, 20);
        loginPanel.add(usernameInput);
        
        passwordHeader.setFont(new Font("Arial",Font.PLAIN,17));
        passwordHeader.setHorizontalAlignment(SwingConstants.CENTER);
        passwordHeader.setBounds(57,125,114,30);
        loginPanel.add(passwordHeader);

        passwordInput.setBounds(32, 155, 160, 20);
        loginPanel.add(passwordInput);

        login.setFont(new Font("Arial",Font.BOLD,14));
        login.setBounds(53, 195, 120, 25);
        loginPanel.add(login);

        cadastrarHeader.setFont(new Font("Arial",Font.PLAIN,17));
        cadastrarHeader.setHorizontalAlignment(SwingConstants.CENTER);
        cadastrarHeader.setBounds(57,225,120,30);
        loginPanel.add(cadastrarHeader);
        
        cadastro.setFont(new Font("Arial",Font.BOLD,14));
        cadastro.setBounds(53,260,120,25);
        loginPanel.add(cadastro);

        
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Sistema sys = Sistema.getInstance();
                String username,password;
                username = usernameInput.getText();
                password = String.valueOf(passwordInput.getPassword());
                Sessao ses = sys.login(username, password);
                if(ses == null){
                    return;
                }
                usernameInput.setText("");
                passwordInput.setText("");
                Base.getInstance().loginEvent(ses,loginPanel);
                
                
            } 
        });

        cadastro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Base up = Base.getInstance();
                up.cadastroEvent(loginPanel);
            }
        });

    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    
}
