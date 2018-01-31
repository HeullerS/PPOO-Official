
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
    private String[] colunas = {"Livro", "Autor"};
    
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
    
    public String retornaTitulo(int linha){
        
        return  dados.get(linha).getTitulo();
    
    }
    
    public String retornaDescricao(int linha){
        
        return  dados.get(linha).getDescricao();
    
    }
    
    public String retornaGenero(int linha){
        
        return  dados.get(linha).getGenero();
    
    }
    
    public int retornaAnoLancamento(int linha){
        
        return  dados.get(linha).getAnoDeLancamento();
    
    }
    
    public String[] retornaPalavrasChave(int linha){
        
        return  dados.get(linha).getPalavrasChave();
    
    }
    
    public String retornaAutor(int linha){
        
        return  dados.get(linha).getAutor();
    
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0: 
                return dados.get(linha).getTitulo();
            case 1: 
                return dados.get(linha).getAutor();
            
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
