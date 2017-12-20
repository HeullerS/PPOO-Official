package ppo.de.pratico.trabalho.exceptions;

import javax.swing.JOptionPane;

public class LivroNaoEncontradoException extends Exception{

    @Override
    public String getMessage() {
        return "Livro não encontrado";
    }
       
}
