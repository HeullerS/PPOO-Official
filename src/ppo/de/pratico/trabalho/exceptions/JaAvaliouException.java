
package ppo.de.pratico.trabalho.exceptions;


public class JaAvaliouException extends Exception{

    @Override
    public String getMessage() {
        return "Você já avaliou esse livro";
    }
    
    
    
}
