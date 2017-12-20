
package ppo.de.pratico.trabalho.DAOL.lista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ppo.de.pratico.trabalho.DAOL.LivrosDAOL;
import ppo.de.pratico.trabalho.exceptions.LivroNaoEncontradoException;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.modelos.Usuario;


public class LivrosDAOLArray implements LivrosDAOL{
    
    private static LivrosDAOLArray instancia;
    private final String caminhoArquivo = "arquivosB/livros.bin";
    private ArrayList<Livro> listaLivro;

    public LivrosDAOLArray() throws IOException, ClassNotFoundException {
        
        listaLivro = new ArrayList<>();
        criarArquivo();
        lerArquivo();
        
    }
    
    public static LivrosDAOLArray obterInstancia() throws IOException, ClassNotFoundException{
    
        if (instancia == null) {
            instancia = new LivrosDAOLArray();
        }
        
        return instancia;
    }

    @Override
    public void adicionarLivro(Livro l) throws IOException {
        listaLivro.add(l);
        escreverArquivo();
    }

    @Override
    public Livro obterLivroPeloTitulo(String email, String titulo) {
        for (Livro li : listaLivro) {
            if (titulo.equals(li.getTitulo()) && email.equals(li.getEmailUsuario())) {
                return li;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Livro> getListaLivros() {
        ArrayList<Livro> l1 = new ArrayList<>();
        for (Livro livro : listaLivro) {
            l1.add(livro);
        }
        return l1;
    }
    
    public ArrayList<Livro> getListaLivros(String email) {
        ArrayList<Livro> l1 = new ArrayList<>();
        for (Livro livro : listaLivro) {
            if(livro.getEmailUsuario().equals(email)) {
                l1.add(livro);
            }
        }
        return l1;
    }

    @Override
    public void lerArquivo() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(caminhoArquivo));
        listaLivro = (ArrayList<Livro>) ois.readObject();
        
    }

    @Override
    public void escreverArquivo() throws IOException {
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
        oos.writeObject(listaLivro);
        oos.close();
    }
    
    public void criarArquivo() throws IOException{
        File arq = new File(caminhoArquivo);
        if (!arq.exists()) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
            oos.writeObject(listaLivro);
            oos.close();
        }
    }
    
    @Override
    public void remover(String email, String titulo) throws IOException, LivroNaoEncontradoException{
        for (Livro livro : listaLivro) {
            if ((email.equals(livro.getEmailUsuario())) && (titulo.equals(livro.getTitulo()))) {
                listaLivro.remove(livro);
                escreverArquivo();
                return;
            } 
        }
        throw new LivroNaoEncontradoException();
    }

}
