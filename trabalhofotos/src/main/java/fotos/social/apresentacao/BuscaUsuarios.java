package fotos.social.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import fotos.social.dados.Sessao;
import fotos.social.dados.Usuario;
import fotos.social.negocio.Sistema;

public class BuscaUsuarios  {
    private Sessao sessao = Base.getInstance().getSes();
    private JPanel mainPanel = new JPanel();
    private JTable usuarios;
    private UserTable tabela;
    private JLabel header = new JLabel("Usuarios");

    private JButton paginaPrincipal = new JButton("Feed");

    public BuscaUsuarios(Sessao ses){
        mainPanel.setLayout(null);
        mainPanel.setBounds(50,40,600,420);
        mainPanel.setBackground(new Color(0, 179, 89));
        sessao = ses;
        tabela = new UserTable(sessao);
        usuarios = new JTable(tabela);
        
        usuarios.setBounds(65, 105, 450, 300);
        mainPanel.add(usuarios);
        
        header.setFont(new Font("Arial",Font.BOLD,30));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBounds(30,30,200,40);
        mainPanel.add(header);

        paginaPrincipal.setFont(new Font("Arial",Font.BOLD,15));
        paginaPrincipal.setBounds(350,25,150,20);
        mainPanel.add(paginaPrincipal);

        usuarios.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selected = usuarios.getSelectedRow();
                
                Sistema sys = Sistema.getInstance();
                Usuario selecionado = sys.getUsers().get(selected);
                
                if(!sys.getSeguindo(sessao).contains(selecionado))
                    sys.seguir(sessao, selecionado);
                else
                    sys.desSeguir(sessao, selecionado);
                tabela.atualizar();
            }
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        });

        paginaPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Base.getInstance().paginaPrincipalEvent(mainPanel);
            }
        });
    }

    public JPanel getPanel(){
        return mainPanel;
    }
}
