
package ppo.de.pratico.trabalho.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import ppo.de.pratico.trabalho.modelos.Livro;

public class Usuario implements Serializable {
    
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Livro> livros;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        livros = new ArrayList<>();
    }
    
    public Usuario(String email, String senha) {
        this("", email, senha);
    }
    
    public void cadastrarRecursoAoMeu(Livro l){
       
        livros.add(l);
    
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
