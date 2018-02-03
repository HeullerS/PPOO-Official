
package ppo.de.pratico.trabalho.exceptions;


public class AvaliacaoInvalidaException extends Exception{

    @Override
    public String getMessage() {
        return "Digite um valor de 1 a 5";
    }
    
    
    
}
