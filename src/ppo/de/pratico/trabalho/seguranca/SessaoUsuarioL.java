
package ppo.de.pratico.trabalho.seguranca;

import java.util.Arrays;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import ppo.de.pratico.trabalho.modelos.Usuario;
import ppo.de.pratico.trabalho.modelos.Usuario;

public class SessaoUsuarioL {
    
    private static SessaoUsuarioL instancia;
    private Usuario usuario;

    public SessaoUsuarioL() {
    }
    
    public static SessaoUsuarioL obterInstancia(){
        
        if (instancia == null) {
            instancia = new SessaoUsuarioL();
        }
        
        return instancia;
        
    }
    
    public String getEmail(){
        return usuario.getEmail();
    }
    
    public Usuario obterUsuario(){
    
        return this.usuario;
    
    }
    
    public boolean estaLogado(){
    
        return (this.usuario != null);
    }
    
    public void alterarUsuario(Usuario usuario, String senha) throws Exception{ //autenticacao do usuário
    
        //if (usuario == null || !Arrays.equals(usuario.getSenha(), senha)) {
        if (usuario == null || !BCrypt.checkpw(senha, usuario.getSenha())) {
            
            throw new Exception();
        }
        else{
        
            this.usuario = usuario;
        }
    }
    
    public void invalidarSessao(){
    
        this.usuario = null;
    }
 
}
