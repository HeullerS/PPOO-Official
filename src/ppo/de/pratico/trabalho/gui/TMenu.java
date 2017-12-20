
package ppo.de.pratico.trabalho.gui;


import ppo.de.pratico.trabalho.gui.TelaSalvarRecurso;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import ppo.de.pratico.trabalho.seguranca.SessaoUsuarioL;


public class TMenu extends JFrame{
    
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    private final SessaoUsuarioL sessaoUsuario;
    
    private JButton btnListarRecursos;
    private JButton btnListarMeusRecursos;
    private JButton btnLogout;

    public TMenu() {
        
        super("Livraria Online");
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sessaoUsuario = SessaoUsuarioL.obterInstancia();
        inicializar();
        
    }
    
    private void construirTela(){
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }
    
    private void inicializar(){
    
        construirTela();
        configurarAcoesBotoes();
    }
    
    private void configurarAcoesBotoes(){
        
        btnListarRecursos = new JButton("Listar todos recursos");
        adicionarComponente(btnListarRecursos, GridBagConstraints.EAST, GridBagConstraints.BOTH, 0, 0, 1, 1);
        
        btnListarMeusRecursos = new JButton("Listar meus recursos");
        adicionarComponente(btnListarMeusRecursos, GridBagConstraints.EAST, GridBagConstraints.BOTH, 0, 1, 1, 1);
        
        btnLogout = new JButton("Logout");
        adicionarComponente(btnLogout, GridBagConstraints.EAST, GridBagConstraints.BOTH, 0, 2, 1, 1);
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessaoUsuario.invalidarSessao();
                TelaAutenticacao tp = new TelaAutenticacao();
                 tp.setVisible(true);
                 dispose();
            }
        });
        
        btnListarMeusRecursos.addActionListener(
            new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            TelaMeusRecursosArrastaESolta tm = new TelaMeusRecursosArrastaESolta();
            tm.setVisible(true);
            dispose();
                }
            }
        );
        
        
        btnListarRecursos.addActionListener(
            new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            TelaTodosRecursosArrastaESolta tr = new TelaTodosRecursosArrastaESolta();
            tr.setVisible(true);
            dispose();
                }
            }
        );

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
