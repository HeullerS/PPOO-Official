
package ppo.de.pratico.trabalho.exceptions;


public class TamanhoMinimoSenha extends Exception{

    @Override
    public String getMessage() {
        return "A senha deve possuir pelo menos 4 caracteres";
    }
  
}
