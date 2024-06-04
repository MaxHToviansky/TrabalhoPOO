package fotos.social.apresentacao;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fotos.social.dados.Post;

public class PostComponent {
    JPanel postPanel = new JPanel();
    ImageIcon mainFoto = new ImageIcon();



    public PostComponent(Post p){
        mainFoto.setImage(p.getFoto());
        
    }
}
