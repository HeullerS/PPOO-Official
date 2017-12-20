
package ppo.de.pratico.trabalho.exceptions;


public class UsuarioJaCadastradoException extends Exception{

    @Override
    public String getMessage() {
        return "Email já cadastrado";
    }
  
}
