
package ppo.de.pratico.trabalho.servicos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ppo.de.pratico.trabalho.DAOL.LivrosDAOL;
import ppo.de.pratico.trabalho.DAOL.lista.LivrosDAOLArray;
import ppo.de.pratico.trabalho.exceptions.LivroJaCadastradoException;
import ppo.de.pratico.trabalho.exceptions.LivroNaoEncontradoException;
import ppo.de.pratico.trabalho.modelos.Livro;


public class GerenciadorLivrosL {
    
    private static GerenciadorLivrosL instancia;
    private final LivrosDAOL repositorioLivro;

    public GerenciadorLivrosL() throws IOException, ClassNotFoundException {
        
        repositorioLivro = LivrosDAOLArray.obterInstancia();
    }
    
    public static GerenciadorLivrosL obterInstancia() throws IOException, ClassNotFoundException {
        
        if (instancia == null) {
            instancia = new GerenciadorLivrosL();
        }
        
        return instancia;
    }
    
    
    public void cadastrarLivro(Livro l) throws Exception{
        Livro lib = repositorioLivro.obterLivroPeloTitulo(l.getEmailUsuario(),l.getTitulo());
        
        if ((lib != null) && (lib.getEmailUsuario().equals(l.getEmailUsuario()))) {
            
            throw new LivroJaCadastradoException();
        }
        repositorioLivro.adicionarLivro(l);
        
    } 
    
    public ArrayList<Livro> getListaLivro(){
        
        ArrayList<Livro> li = repositorioLivro.getListaLivros();
        Collections.sort(li);
        return li;
    }
    
    public ArrayList<Livro> getListaLivro(String email){
        
        ArrayList<Livro> li = repositorioLivro.getListaLivros(email);
        Collections.sort(li);
        return li;
    }
    
    public void remover(String email, String titulo) throws LivroNaoEncontradoException, IOException {
        
        repositorioLivro.remover(email,titulo);
    }
    
    
}
