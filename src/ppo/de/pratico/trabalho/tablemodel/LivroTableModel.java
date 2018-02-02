
package ppo.de.pratico.trabalho.tablemodel;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorLivrosL;

public class LivroTableModel extends AbstractTableModel{

    
    private ArrayList<Livro> dados = new ArrayList<>();
    private String[] colunas = {"Livro", "Autor", "Usuario"};
    
    public LivroTableModel() throws IOException, ClassNotFoundException {
        
        dados = GerenciadorLivrosL.obterInstancia().getListaLivro();

    }
     public Livro retornaLivro(int linha){
    
        return dados.get(linha);
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
    
    public String retornaEmail(int linha){
    
        return dados.get(linha).getEmailUsuario();
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
                return dados.get(linha).getEmailUsuario();
            
        }
        
        return null;
    }
    
}
   