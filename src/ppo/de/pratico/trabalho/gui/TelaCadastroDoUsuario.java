
package ppo.de.pratico.trabalho.gui;

import ppo.de.pratico.trabalho.modelos.Usuario;
import ppo.de.pratico.trabalho.exceptions.CampoVazioException;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.mindrot.jbcrypt.BCrypt;
import ppo.de.pratico.trabalho.gui.TelaAutenticacaoDoUsuario;
import ppo.de.pratico.trabalho.exceptions.SenhasNaoConferemException;
import ppo.de.pratico.trabalho.exceptions.TamanhoMinimoException;
import ppo.de.pratico.trabalho.exceptions.UsuarioJaCadastradoException;


public class TelaCadastroDoUsuario extends JFrame{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    private JLabel lbCadastrar;
    private JLabel icnCadastrar;
    
    private JLabel lbNome;
    private JTextField txtNome;
    
    private JLabel lbEmail;
    private JTextField txtEmail;
    
    private JLabel lbSenha;
    private JPasswordField txtSenha;
    
    private JLabel lbConfirmarSenha;
    private JPasswordField txtConfirmarSenha;
    
    private JButton btnSalvar;
    private JButton btnVoltar;
    private JPanel painelCadastro;
    
    
    public TelaCadastroDoUsuario(){
        super("Livraria Online");
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializar();
        
    }
    
    private void inicializar(){
    
        construirTela();
        configurarAcaoBotoes();
    }
    
    private void construirTela(){
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        
        icnCadastrar = new JLabel(new ImageIcon(getClass().getResource("../img/icnCadastrar.png")));
        adicionarComponente(icnCadastrar, GridBagConstraints.WEST, GridBagConstraints.NONE, 0 , 0 , 1, 1);
        lbCadastrar = new JLabel("Cadastrar usuário");
        adicionarComponente(lbCadastrar, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 1, 1, 1);
        
        lbNome = new JLabel("Nome");
        adicionarComponente(lbNome, GridBagConstraints.WEST, GridBagConstraints.NONE, 1, 0 , 1, 1);
        txtNome = new JTextField(6);
        adicionarComponente(txtNome, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL , 1 , 1, 3, 1);
        
        lbEmail = new JLabel("Email");
        adicionarComponente(lbEmail, GridBagConstraints.WEST, GridBagConstraints.NONE, 2, 0, 1, 1);
        txtEmail = new JTextField(6);
        adicionarComponente(txtEmail, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 2, 1, 3, 1);
        
        lbSenha = new JLabel("Senha");
        adicionarComponente(lbSenha, GridBagConstraints.WEST, GridBagConstraints.NONE, 3, 0, 1, 1);
        txtSenha = new JPasswordField(6);
        adicionarComponente(txtSenha, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 3, 1, 1, 1);
        
        lbConfirmarSenha = new JLabel("Confirmar senha");
        adicionarComponente(lbConfirmarSenha, GridBagConstraints.WEST, GridBagConstraints.NONE, 3, 2, 1, 1);
        txtConfirmarSenha = new JPasswordField(8);
        adicionarComponente(txtConfirmarSenha, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 3, 3, 1, 1);
        
        btnSalvar = new JButton("Salvar");
        btnVoltar = new JButton("Voltar");
        painelCadastro = new JPanel();
        painelCadastro.add(btnSalvar);
        painelCadastro.add(btnVoltar);
        adicionarComponente(painelCadastro, GridBagConstraints.CENTER, GridBagConstraints.NONE, 4, 0, 4, 1);
        
    }
    
    private Usuario carregarUsuario(){
        
        return new Usuario(txtNome.getText(), txtEmail.getText(), BCrypt.hashpw(txtSenha.getText(), BCrypt.gensalt()) );
    
    }
    
    private void validarCampos() throws CampoVazioException {
    
        if (txtNome.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbNome);
        }
        if (txtEmail.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbEmail);
        }
    }
    
    private void validarSenhaConfere() throws SenhasNaoConferemException{
        
        if (!Arrays.equals(txtSenha.getPassword(), txtConfirmarSenha.getPassword())){
        
            txtSenha.setText("");
            txtConfirmarSenha.setText("");
            throw new SenhasNaoConferemException();
        }
    
    }
    
    private void validarSenhaMinimo() throws TamanhoMinimoException{
    
        if (txtSenha.getPassword().length < 4) {
            
            throw new TamanhoMinimoException();
        }
    }
    
    private void testarECadastrarCampos() {
        
        try {
            validarCampos();
            validarSenhaMinimo();
            validarSenhaConfere();
            GerenciadorUsuariosL.obterInstancia().cadastrarUsuario(carregarUsuario());
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (CampoVazioException | TamanhoMinimoException | SenhasNaoConferemException
                 | UsuarioJaCadastradoException | IOException | ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void configurarAcaoBotoes(){
        
        btnSalvar.addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    testarECadastrarCampos();
                } catch (Exception ex) {
                    System.out.println("erro");
                }
                 
            }
        });
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 TelaAutenticacaoDoUsuario tp = new TelaAutenticacaoDoUsuario();
                 tp.setVisible(true);
                 dispose();
            }
        });
    }
    
    private void limparTela(){
    
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        txtConfirmarSenha.setText("");
    
    }
    
    private void adicionarComponente(Component comp, int anchor, int fill, int linha, int coluna, int largura, int altura){
    
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.gridx = coluna;
        gbc.gridy = linha;
        gbc.gridwidth = largura;
        gbc.gridheight = altura;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbl.setConstraints(comp, gbc);
        add(comp);
    }
    
  
}
