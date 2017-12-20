package ppo.de.pratico.trabalho.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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
import ppo.de.pratico.trabalho.gui.TMenu;
import ppo.de.pratico.trabalho.modelos.Usuario;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;



public class TelaAutenticacao extends JFrame{
    
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
       
    private JLabel icnAutenticacao;
    private JLabel lbAutenticacao;
    private JPanel painelSuperiorAutenticacao;
    
    private JLabel lbEmail;
    private JTextField txtEmail;
    
    private JLabel lbSenha;
    private JPasswordField txtSenha;
    
    private JButton btnNovoUsuario;
    
    private JButton btnEntrar;
    private JButton btnSair;
    private JPanel painelBotoesAutenticacao;
    
    
    public TelaAutenticacao(){
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
        
        painelSuperiorAutenticacao = new JPanel();
        icnAutenticacao = new JLabel(new ImageIcon(getClass().getResource("../img/icnAutenticacao.png")));
        lbAutenticacao = new JLabel("Autenticar usuário");
        painelSuperiorAutenticacao.add(icnAutenticacao);
        painelSuperiorAutenticacao.add(lbAutenticacao);
        adicionarComponente(painelSuperiorAutenticacao, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 3, 1);
        
        lbEmail = new JLabel("Email");
        adicionarComponente(lbEmail, GridBagConstraints.WEST, GridBagConstraints.NONE, 1, 0, 1, 1);
        txtEmail = new JTextField(20);
        adicionarComponente(txtEmail, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1 , 1, 3, 1);
        
        lbSenha = new JLabel("Senha");
        adicionarComponente(lbSenha, GridBagConstraints.WEST, GridBagConstraints.NONE, 2, 0, 1 , 1);
        txtSenha = new JPasswordField(10);
        adicionarComponente(txtSenha, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 2, 1, 1, 1);
        
        btnNovoUsuario = new JButton("Novo Usuário");
        adicionarComponente(btnNovoUsuario, GridBagConstraints.EAST, GridBagConstraints.NONE, 2, 2, 1, 1);
        
        btnEntrar = new JButton("Entrar");
        btnSair = new JButton("Sair");
        painelBotoesAutenticacao = new JPanel();
        painelBotoesAutenticacao.add(btnEntrar);
        painelBotoesAutenticacao.add(btnSair);
        adicionarComponente(painelBotoesAutenticacao, GridBagConstraints.CENTER, GridBagConstraints.NONE, 3, 0, 4, 1);
    }
    
    private Usuario carregarUsuario() {
        return new Usuario(txtEmail.getText(), txtSenha.getText());
    }
    
    private void configurarAcaoBotoes(){
        
        btnNovoUsuario.addActionListener(
            new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
                TelaCadastro tc = new TelaCadastro();
                tc.setVisible(true);
                dispose();
                }
            }
        );
        
        btnEntrar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                    GerenciadorUsuariosL.obterInstancia().autenticarUsuario(carregarUsuario());
                    JOptionPane.showMessageDialog(null, "Bem-vindo!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
                    TMenu ti = new TMenu();
                    ti.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao autenticar", "Autenticação", JOptionPane.ERROR_MESSAGE);
                    limparTela();
                }
               }
            }
        );
        
        btnSair.addActionListener(
            new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
                }
            }
        ); 
    }
    
    private void limparTela(){
        
        txtEmail.setText("");
        txtSenha.setText("");
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