package ppo.de.pratico.trabalho.DAOL;

import java.io.IOException;
import ppo.de.pratico.trabalho.modelos.Usuario;

public interface UsuarioDAOL {
    
    public Usuario obterUsuarioPeloEmail(String email);
    public void adicionarUsuario(Usuario usuario) throws IOException;
    public void lerBinario() throws IOException, ClassNotFoundException;
    public void escreverBinario() throws IOException;
    
}
