
package ppo.de.pratico.trabalho.modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ppo.de.pratico.trabalho.exceptions.CampoVazioException;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;


public class Livro implements Comparable<Livro> , Serializable{
    
    private String titulo;
    private String autor;
    private String descricao;
    private String genero;
    private int anoDeLancamento;
    private String[] palavrasChave;
    private String emailUsuario;
    private ArrayList<String> comentarios;
    //private final String caminhoArquivo =  "arquivosB/usuarios.bin";

    public Livro(String titulo, String autor, String descricao, String genero, int anoDeLancamento, String[] palavrasChave, String emailUsuario) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.genero = genero;
        this.anoDeLancamento = anoDeLancamento;
        this.palavrasChave = palavrasChave;
        this.emailUsuario = emailUsuario;
        comentarios = new ArrayList<>();
        //criarArquivo();
        //lerBinario();
    }
    /*
    public void criarArquivo() throws IOException{
        File arq = new File(caminhoArquivo);
        if (!arq.exists()) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
            oos.writeObject(comentarios);
            oos.close();
        }
    }
    
    public void escreverBinario() throws IOException {
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
        oos.writeObject(comentarios);
        oos.close();
    }
    
    public void lerBinario() throws IOException,ClassNotFoundException {
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(caminhoArquivo));
        comentarios = (ArrayList<String>) ois.readObject();
        
    }
    */
    public void comentar(String comment) throws IOException, ClassNotFoundException{
    
        comentarios.add(GerenciadorUsuariosL.obterInstancia().obterEmailDoUsuarioLogado() + ": " + comment);
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public String getAutor() {
        return autor;
    }
    
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public int compareTo(Livro outroLivro) {
        
        int comparacao = titulo.compareTo(outroLivro.getTitulo());
        if (comparacao < 0) {
            return -1;
        }
        else 
            if (comparacao > 0) {
            
                return 1;
        }
        return 0;
    }  
    
}
