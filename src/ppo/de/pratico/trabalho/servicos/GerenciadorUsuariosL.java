
package ppo.de.pratico.trabalho.servicos;

import java.io.IOException;
import ppo.de.pratico.trabalho.DAOL.lista.UsuarioDAOLArray;
import ppo.de.pratico.trabalho.DAOL.UsuarioDAOL;
import javax.swing.JOptionPane;
import ppo.de.pratico.trabalho.exceptions.UsuarioJaCadastradoException;
import ppo.de.pratico.trabalho.seguranca.SessaoUsuarioL;
import ppo.de.pratico.trabalho.modelos.Usuario;


public class GerenciadorUsuariosL {
    private static GerenciadorUsuariosL instancia;
    private final UsuarioDAOL repositorioUsuario;
    private final static SessaoUsuarioL sessaoUsuario = SessaoUsuarioL.obterInstancia();

    public GerenciadorUsuariosL() throws IOException, ClassNotFoundException {
        
        repositorioUsuario = UsuarioDAOLArray.obterInstancia();
        
    }
    
    public static GerenciadorUsuariosL obterInstancia() throws IOException, ClassNotFoundException {
        
        if (instancia == null) {
            instancia = new GerenciadorUsuariosL();
        }
        
        return instancia;
    }
    
    public String obterEmailDoUsuarioLogado() {
        return sessaoUsuario.getEmail();
    }
    
    public void autenticarUsuario(Usuario usuario) throws Exception{
    
        Usuario usuarioCadastrado = repositorioUsuario.obterUsuarioPeloEmail(usuario.getEmail());
        if(usuarioCadastrado == null) {
            throw new UsuarioJaCadastradoException();
        }
        sessaoUsuario.alterarUsuario(usuarioCadastrado, usuario.getSenha());
    }
    
    public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastradoException, IOException {
    
        Usuario ret = repositorioUsuario.obterUsuarioPeloEmail(usuario.getEmail());
        if (ret != null) {
            throw new UsuarioJaCadastradoException();
        }
        
        repositorioUsuario.adicionarUsuario(usuario);
    }
    
}
