package fotos.social.apresentacao;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import fotos.social.dados.Post;
import fotos.social.dados.Sessao;
import fotos.social.negocio.Sistema;

public class PostTable extends AbstractTableModel {
    private final String[] colunas = {"Posts","Descrição"};
    private List<Post> posts;
    
    public PostTable(Sessao ses){
        posts = Sistema.getInstance().getPostSeguindo(ses);
    }

    public int getColumnCount(){
        return 2;
    }

    public String getColumnName(int column){
        return colunas[column];
    }

    public int getRowCount(){
        return posts.size();
    }
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    public Object getValueAt(int x, int y){
        if(y==0)
            return new ImageIcon(posts.get(x).getFoto());
        else
            return posts.get(x).getLegenda();
    }

}
