
package ppo.de.pratico.trabalho.tablemodel;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorLivrosL;

public class LivroTableModel extends AbstractTableModel{

    
    private ArrayList<Livro> dados = new ArrayList<>();
    
    public LivroTableModel() throws IOException, ClassNotFoundException {
        
        dados = GerenciadorLivrosL.obterInstancia().getListaLivro();

    }
    
    private String[] colunas = {"Livro", "Autor", "Gênero", "Ano lanc.", "Descricao"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0: 
                return dados.get(linha).getTitulo();
            case 1: 
                return dados.get(linha).getAutor();
            case 2:
                return dados.get(linha).getGenero();
            case 3:
                return dados.get(linha).getAnoDeLancamento();
            case 4:
                return dados.get(linha).getDescricao();
            
        }
        
        return null;
    }
    
}
