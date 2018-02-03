
package ppo.de.pratico.trabalho.tablemodel;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import ppo.de.pratico.trabalho.gui.TelaBuscaLivros;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorLivrosL;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;


public class LivroTableModelBusca extends AbstractTableModel{
    
    private ArrayList<Livro> dados;
    private ArrayList<Livro> lista;
    private String[] colunas = {"Livro", "Autor", "Usuario"};
    
    public LivroTableModelBusca(String titulo) throws IOException, ClassNotFoundException {
        
        lista = GerenciadorLivrosL.obterInstancia().getListaLivro();
        dados = GerenciadorLivrosL.obterInstancia().getListaLibro(titulo);
        
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
            case 3:
                return dados.get(linha).getPalavrasChave();
            
        }
        
        return null;
    }
    
}    

