package fotos.social.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fotos.social.dados.Post;
import fotos.social.dados.Sessao;
import fotos.social.negocio.Sistema;

public class PaginaPrincipal {
    
    private Sessao ses;

    private JPanel mainPage = new JPanel();
    private JScrollPane postBar = new JScrollPane();
    private PostTable tabela;
    private JTable posts;

    private JLabel info = new JLabel("Crie um post!");
    private JLabel nomeArq = new JLabel("Escolha um arquivo");
    
    private JButton buscaImagem = new JButton("Upload Imagem");
    private JFileChooser imageGetter = new JFileChooser();
    private Image input = null;

    private JLabel legendaHeader = new JLabel("Descrição");
    private JTextField legendaInput = new JTextField();

    private JButton makePost = new JButton("Postar!");

    private JButton pesquisa = new JButton("Procurar Usuarios");

    private JButton logoff = new JButton("Log Off");


    public PaginaPrincipal(Sessao sessao){
        ses = sessao;
        tabela = new PostTable(ses);
        mainPage.setLayout(null);
        mainPage.setBounds(50,20,600,420);
        mainPage.setBackground(new Color(0, 179, 89));

        postBar.setBounds(65, 105, 450, 300);
        mainPage.add(postBar);

        info.setFont(new Font("Arial",Font.BOLD,20));
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setBounds(10,10,200,30);
        mainPage.add(info);

        buscaImagem.setFont(new Font("Arial",Font.PLAIN,10));
        buscaImagem.setBounds(50,50,110,20);
        mainPage.add(buscaImagem);

        nomeArq.setFont(new Font("Arial",Font.PLAIN,8));
        nomeArq.setBounds(50,35,110,20);
        nomeArq.setHorizontalAlignment(SwingConstants.CENTER);
        mainPage.add(nomeArq);

        legendaHeader.setFont(new Font("Arial",Font.PLAIN,15));
        legendaHeader.setHorizontalAlignment(SwingConstants.CENTER);
        legendaHeader.setBounds(185, 25, 100, 30);
        mainPage.add(legendaHeader);

        legendaInput.setFont(new Font("Arial",Font.PLAIN,15));
        legendaInput.setBounds(175,50,120,20);
        mainPage.add(legendaInput);

        makePost.setFont(new Font("Arial",Font.PLAIN,10));
        makePost.setBounds(110,80,110,20);
        mainPage.add(makePost);
        
        posts = new JTable(tabela);
        posts.setRowHeight(120);
        postBar.setViewportView(posts);



        pesquisa.setFont(new Font("Arial",Font.BOLD,15));
        pesquisa.setBounds(350,25,200,20);
        mainPage.add(pesquisa);

        logoff.setFont(new Font("Arial",Font.BOLD,15));
        logoff.setBounds(350,50,200,20);
        mainPage.add(logoff);

        buscaImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int state = imageGetter.showOpenDialog(buscaImagem);
                if(state!= JFileChooser.APPROVE_OPTION)
                    return;
                try{
                    File f = imageGetter.getSelectedFile();
                    input = ImageIO.read(f);
                    nomeArq.setText(f.getName());
                }catch(IOException exception){
                    System.out.println("dor");
                }
            }
        });
        
        makePost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input==null){
                    System.out.println("Não há imagem!");
                    return;
                }
                Sistema sys = Sistema.getInstance();
                sys.postFoto(ses, new Post(input, legendaInput.getText()));
                legendaInput.setText("");
                nomeArq.setText("");
                input = null;
            }
        });
        
        pesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Base up = Base.getInstance();
                up.buscaEvent(mainPage);
            }
        });

        logoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Base.getInstance().logoff(mainPage);
            }
        });

    }

    public JPanel getPanel(){
        return mainPage;
    }
}
