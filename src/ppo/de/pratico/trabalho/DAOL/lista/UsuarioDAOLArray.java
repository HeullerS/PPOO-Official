
package ppo.de.pratico.trabalho.DAOL.lista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ppo.de.pratico.trabalho.DAOL.UsuarioDAOL;
import java.util.ArrayList;
import ppo.de.pratico.trabalho.modelos.Usuario;


public class UsuarioDAOLArray implements UsuarioDAOL{
    private final String caminhoArquivo =  "arquivosB/usuarios.bin";
    private static UsuarioDAOLArray instancia; 
    private ArrayList<Usuario> listaUsuario; //Array de usuários cadastrados

    private UsuarioDAOLArray() throws IOException, ClassNotFoundException {
        
        listaUsuario = new ArrayList<>();
        criarArquivo();
        lerBinario();
    }
    
    
    
    public static UsuarioDAOLArray obterInstancia() throws IOException, ClassNotFoundException{
        if (instancia == null) {
            instancia = new UsuarioDAOLArray();
        }
        return instancia;
    }
    
    public void criarArquivo() throws IOException{
        File arq = new File(caminhoArquivo);
        if (!arq.exists()) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
            oos.writeObject(listaUsuario);
            oos.close();
        }
    }

    @Override
    public Usuario obterUsuarioPeloEmail(String email) { 
        for (Usuario u : listaUsuario) {
            if (email.equals(u.getEmail()) ) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void adicionarUsuario(Usuario usuario) throws IOException { 
        listaUsuario.add(usuario);
        escreverBinario();
    }
    
    @Override
    public void escreverBinario() throws IOException {
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
        oos.writeObject(listaUsuario);
        oos.close();
    }
    
    @Override
    public void lerBinario() throws IOException,ClassNotFoundException {
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(caminhoArquivo));
        listaUsuario = (ArrayList<Usuario>) ois.readObject();
        
    }
    
}
