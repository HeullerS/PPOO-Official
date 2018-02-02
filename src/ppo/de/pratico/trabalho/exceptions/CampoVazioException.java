
package ppo.de.pratico.trabalho.exceptions;

import javax.swing.JLabel;


public class CampoVazioException extends Exception{
    
    private JLabel componente;
    private String campo;

    public CampoVazioException(JLabel componente) {
        this.componente = componente;
    }
    
    public CampoVazioException(String campo) {
        this.campo = campo;
    }

    @Override
    public String getMessage() {
        if (componente != null) {
            return String.format("O campo \"%s\" não pode estar vazio!", componente.getText());
        }
        if (campo != null) {
            return "O campo não pode estar vazio";
        }
        return "";
    }
      
}
