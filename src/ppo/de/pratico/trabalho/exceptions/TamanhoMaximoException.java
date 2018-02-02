
package ppo.de.pratico.trabalho.exceptions;

public class TamanhoMaximoException extends Exception{

    @Override
    public String getMessage() {
        return "O comentário deve possuir no máximo 144 caracteres";
    }
    
    
    
}
