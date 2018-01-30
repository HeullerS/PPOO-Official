package ppo.de.pratico.trabalho.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaVisualizacao extends JFrame{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    private JLabel lbTitulo;
    
    
    public TelaVisualizacao(String txtTitulo){
        super("Visualizar livro");
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializar(txtTitulo);
    }
    
    private void inicializar(String txtTitulo){
    
        construirTela(txtTitulo);
        configurarAcaoBotoes();
    }
    
    private void construirTela(String txtTitulo){
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        
        String txtT = txtTitulo;
        
        lbTitulo = new JLabel(txtT);
        adicionarComponente(lbTitulo, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 1, 1);
    }
    
    private void configurarAcaoBotoes(){
    
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
