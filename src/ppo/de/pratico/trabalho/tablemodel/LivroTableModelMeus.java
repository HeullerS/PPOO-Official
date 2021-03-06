
package ppo.de.pratico.trabalho.tablemodel;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ppo.de.pratico.trabalho.exceptions.LivroNaoEncontradoException;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorLivrosL;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;

public class LivroTableModelMeus extends AbstractTableModel{

    
    private ArrayList<Livro> lista;
    private ArrayList<Livro> dados;
    private String[] colunas = {"Livro", "Autor", "Gênero", "Ano lanc.", "Descricao"};
    
    public LivroTableModelMeus() throws IOException, ClassNotFoundException {
        
        lista = GerenciadorLivrosL.obterInstancia().getListaLivro();
        dados = GerenciadorLivrosL.obterInstancia().getListaLivro(GerenciadorUsuariosL.obterInstancia().obterEmailDoUsuarioLogado());
     
    }
   
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

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
        switch(coluna){
            case 0: 
                dados.get(linha).setTitulo((String)valor);
                break;
            case 1: 
                dados.get(linha).setAutor((String)valor);
                break;
            case 2:
                dados.get(linha).setGenero((String)valor);
                break;
            case 3:
                dados.get(linha).setAnoDeLancamento(Integer.parseInt((String)valor));
                break;
            case 4:
                dados.get(linha).setDescricao((String)valor);
                break;
            
        }
        
        this.fireTableRowsUpdated(linha, linha);
        
    }
    
    public void removeRow(int linha) throws IOException, ClassNotFoundException, LivroNaoEncontradoException {
    
        GerenciadorLivrosL.obterInstancia().remover(GerenciadorUsuariosL.obterInstancia().obterEmailDoUsuarioLogado(),
                                                    dados.get(linha).getTitulo());
        this.lista.remove(linha);
        this.dados.remove(linha);
        
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
