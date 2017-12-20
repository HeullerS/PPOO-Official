
package ppo.de.pratico.trabalho.exceptions;

import javax.swing.JLabel;


public class CampoVazioException extends Exception{
    
    private JLabel componente;

    public CampoVazioException(JLabel componente) {
        this.componente = componente;
    }

    @Override
    public String getMessage() {
        if (componente != null) {
            return String.format("O campo \"%s\" não pode estar vazio!", componente.getText());
        }
        return "";
    }
      
}
