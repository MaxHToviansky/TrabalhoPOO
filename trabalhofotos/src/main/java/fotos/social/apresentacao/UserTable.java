package fotos.social.apresentacao;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fotos.social.dados.Sessao;
import fotos.social.dados.Usuario;
import fotos.social.negocio.Sistema;

public class UserTable extends AbstractTableModel{
    private List<Usuario> users;
    private Sessao ses;
    private String[] colunas = {"Nome","Biografia","Seguindo?"};
    


    public UserTable(Sessao ses) {
        users = Sistema.getInstance().getUsers();
        this.ses = ses;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int column){
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==1)
            return users.get(rowIndex).getBiografia();
        else if(columnIndex==0)
            return users.get(rowIndex).getNomePerfil();
        else
            return (ses.getLoggedAs().getSegue().contains(users.get(rowIndex))) ? "Segue" : "Não Segue";
    }


    public void atualizar(){
        fireTableStructureChanged();
    }
}
