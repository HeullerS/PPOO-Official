
package ppo.de.pratico.trabalho.exceptions;


public class SenhasNaoConferemException extends Exception{

    @Override
    public String getMessage() {
        return "As senhas não coincidem";
    }
    
}
