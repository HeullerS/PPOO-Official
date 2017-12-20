
package ppo.de.pratico.trabalho.exceptions;


public class LivroJaCadastradoException extends Exception{

    @Override
    public String getMessage() {
        return "Livro já cadastrado";
    }
      
}
