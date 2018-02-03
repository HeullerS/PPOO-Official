
package ppo.de.pratico.trabalho.DAOL;

import java.io.IOException;
import java.util.ArrayList;
import ppo.de.pratico.trabalho.exceptions.LivroNaoEncontradoException;
import ppo.de.pratico.trabalho.modelos.Livro;


public interface LivrosDAOL {
    
    public void adicionarLivro(Livro l) throws IOException;
    public Livro obterLivroPeloTitulo(String email, String titulo);
    public ArrayList<Livro> getListaLivros();
    public ArrayList<Livro> getListaLivros(String email);
    public ArrayList<Livro> getListaLibros(String palavra);
    public void lerArquivo() throws IOException, ClassNotFoundException;
    public void escreverArquivo() throws IOException;
    public void remover(String email, String titulo) throws LivroNaoEncontradoException, IOException;
    
}
