
package ppo.de.pratico.trabalho.exceptions;

import javax.swing.JLabel;


public class CampoComQuantidadeMinimaException extends Exception{

    public CampoComQuantidadeMinimaException(JLabel label) {
        super("O campo" + label.getText() + " não possui o número necessário de palavras-chave");

    }
     
}
