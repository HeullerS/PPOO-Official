package ppo.de.pratico.trabalho.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ppo.de.pratico.trabalho.exceptions.AvaliacaoInvalidaException;
import ppo.de.pratico.trabalho.exceptions.CampoVazioException;
import ppo.de.pratico.trabalho.exceptions.JaAvaliouException;
import ppo.de.pratico.trabalho.exceptions.TamanhoMaximoException;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;


public class TelaVisualizarTodosLivros extends JFrame{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    private JLabel lbTitulo;
    private JPanel painelAvaliacao;
    private JLabel lbAvaliar;
    private JTextField txtAvaliar;
    private JButton btnAvaliar;
    private JLabel lbDescricao;
    private JTextArea taDescricaoTexto;
    
    private JLabel lbAutor;
    private JTextArea taAutor;
    private JLabel lbGenero;
    private JTextArea taGenero;
    private JLabel lbAnoLanc;
    private JTextArea taAnoLanc;
    
    private JPanel painelComentario;
    private JScrollPane scrollComentario;
    
    private JTextArea taComments;
    private JScrollPane scrollComments;
    private JPanel painelComments;
    
    private JLabel lbPalavrasChave;
    private JTextArea taPalavrasChave;
    private JLabel lbComentarios;
    
    private JTextArea taComentar;
    private JPanel painelBotoes;
    private JButton btnComentar;
    private JButton btnSair;
    
    private Livro livro;
    
    
    public TelaVisualizarTodosLivros(String txtTitulo, String descricao, String palavrasChave, String autor, String genero, String anoLanc, Livro livro, String email){
        super("Livraria online");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.livro = livro;
        inicializar(txtTitulo, descricao, palavrasChave, autor, genero, anoLanc, email);
    }
    
    
    private void inicializar(String txtTitulo, String descricao, String palavrasChave, String autor, String genero, String anoLanc, String email){
    
        construirTela(txtTitulo, descricao, palavrasChave, autor, genero, anoLanc, email);
        configurarAcaoBotoes();
    }
    
    private void construirTela(String txtTitulo, String descricao, String palavrasChave, String autor, String genero, String anoLanc, String email){
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        
        lbTitulo = new JLabel(txtTitulo + " (" + email + " | " + livro.getPontos() + " pontos)");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        adicionarComponente(lbTitulo, GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 0, 1, 1);
        
        painelAvaliacao = new JPanel();
        lbAvaliar = new JLabel("Avaliar:");
        txtAvaliar = new JTextField("1 a 5 pontos");
        btnAvaliar = new JButton("Salvar avaliação");
        painelAvaliacao.add(lbAvaliar);
        painelAvaliacao.add(txtAvaliar);
        painelAvaliacao.add(btnAvaliar);
        adicionarComponente(painelAvaliacao, GridBagConstraints.WEST, GridBagConstraints.BOTH, 1, 0, 1, 1);
        
        lbAutor = new JLabel("Autor");
        adicionarComponente(lbAutor, GridBagConstraints.WEST, GridBagConstraints.NONE, 2, 0, 1, 1);
        
        taAutor = new JTextArea(autor);
        taAutor.setLineWrap(true);
        taAutor.setEditable(false);
        taAutor.setBackground(null);
        adicionarComponente(taAutor, GridBagConstraints.WEST, GridBagConstraints.NONE, 3, 0, 1, 1);
        
        lbGenero = new JLabel("Gênero");
        adicionarComponente(lbGenero, GridBagConstraints.WEST, GridBagConstraints.NONE, 4, 0, 1, 1);
        
        taGenero = new JTextArea(genero);
        taGenero.setLineWrap(true);
        taGenero.setEditable(false);
        taGenero.setBackground(null);
        adicionarComponente(taGenero, GridBagConstraints.WEST, GridBagConstraints.NONE, 5, 0, 1, 1);
        
        lbAnoLanc = new JLabel("Ano de lançamento");
        adicionarComponente(lbAnoLanc, GridBagConstraints.WEST, GridBagConstraints.NONE, 6, 0, 1, 1);
        
        taAnoLanc = new JTextArea(anoLanc);
        taAnoLanc.setLineWrap(true);
        taAnoLanc.setEditable(false);
        taAnoLanc.setBackground(null);
        adicionarComponente(taAnoLanc, GridBagConstraints.WEST, GridBagConstraints.NONE, 7, 0, 1, 1);
        
        lbDescricao = new JLabel("Descrição:");
        adicionarComponente(lbDescricao, GridBagConstraints.WEST, GridBagConstraints.NONE, 8, 0, 1, 1);
        
        taDescricaoTexto = new JTextArea(descricao);
        taDescricaoTexto.setLineWrap(true);
        taDescricaoTexto.setEditable(false);
        taDescricaoTexto.setSize(300, 100);
        taDescricaoTexto.setBackground(null);
        adicionarComponente(taDescricaoTexto, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 9, 0, 1, 1);
        
        lbPalavrasChave = new JLabel("Palavras-chave");
        adicionarComponente(lbPalavrasChave, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 10, 0, 1, 1);
        
        taPalavrasChave = new JTextArea(palavrasChave);
        taPalavrasChave.setLineWrap(true);
        taPalavrasChave.setEditable(false);
        taPalavrasChave.setSize(100, 100);
        taPalavrasChave.setBackground(null);
        adicionarComponente(taPalavrasChave, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 11, 0, 1, 1);
        
        lbComentarios = new JLabel("Comentários:");
        adicionarComponente(lbComentarios, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 12, 0, 1, 1);
        
        //COMENTARIOS
        
        taComments = new JTextArea(retornaComments());
        taComments.setEditable(false);
        taComments.setBackground(null);
        scrollComments = new JScrollPane(taComments);
        scrollComments.setPreferredSize(new Dimension(150, 100)); 
        painelComments = new JPanel(new GridLayout(1, 1));
        painelComments.add(scrollComments, BorderLayout.PAGE_END);
        adicionarComponente(painelComments, GridBagConstraints.WEST, GridBagConstraints.BOTH, 13, 0, 1, 1);
        
        
        
        taComentar = new JTextArea();
        scrollComentario = new JScrollPane(taComentar);
        scrollComentario.setPreferredSize(new Dimension(250, 150)); 
        painelComentario = new JPanel(new GridLayout(1, 1));
        painelComentario.add(scrollComentario, BorderLayout.PAGE_END);
        adicionarComponente(painelComentario, GridBagConstraints.WEST, GridBagConstraints.BOTH, 14, 0, 1, 1);
        
        painelBotoes = new JPanel();
        btnComentar = new JButton("Comentar");
        btnSair = new JButton("Sair");
        painelBotoes.add(btnComentar);
        painelBotoes.add(btnSair);
        adicionarComponente(painelBotoes, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 15, 0, 1, 1);
        
    }
    
    private void validarCampos() throws CampoVazioException, TamanhoMaximoException, IOException, ClassNotFoundException, JaAvaliouException{
    
        if (taComentar.getText().trim().isEmpty()) {
            throw new CampoVazioException("comentar");
        }
        
        if (taComentar.getText().length() > 144) {
            
            throw new TamanhoMaximoException();
        }
    
    }
    
    private void validarAvaliacao() throws JaAvaliouException, IOException, ClassNotFoundException, AvaliacaoInvalidaException{
        
        for (int i = 0; i < livro.getQuemJaAvaliou().size(); i++) {
            if (GerenciadorUsuariosL.obterInstancia().getUsuario().equals(livro.getQuemJaAvaliou().get(i))) {
                throw new JaAvaliouException();
            }
        }
        
        if ((Integer.parseInt(txtAvaliar.getText()) <= 0) || (Integer.parseInt(txtAvaliar.getText()) >= 6) ) {
            
            throw new AvaliacaoInvalidaException();
        }
    
    }
    
    private void configurarAcaoBotoes(){
        
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                TelaMenu tmras = new TelaMenu();
                tmras.setVisible(true);
                dispose();
                
            }
        });
        
        btnComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validarCampos();
                    livro.comentar(taComentar.getText());
                    dispose();
                    TelaTodosLivros tmras = new TelaTodosLivros();
                    tmras.setVisible(true);
                  }
                catch (CampoVazioException ex){
                
                   JOptionPane.showMessageDialog(null, ex.getMessage(), "Campo vazio", JOptionPane.ERROR_MESSAGE);
                }
                catch (TamanhoMaximoException ex) { 
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Tamanho máximo", JOptionPane.ERROR_MESSAGE);
                }
                catch (JaAvaliouException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Tamanho máximo", JOptionPane.ERROR_MESSAGE);
                } 
                catch (IOException | ClassNotFoundException ex ) {
                    Logger.getLogger(TelaVisualizarTodosLivros.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
  
            }
        });
        
        btnAvaliar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    validarAvaliacao();
                    livro.setPontos(Integer.parseInt(txtAvaliar.getText()));
                    livro.avaliarUsuario(GerenciadorUsuariosL.obterInstancia().getUsuario());
                    dispose();
                    JOptionPane.showMessageDialog(null, "Livro avaliado com sucesso");
                    TelaTodosLivros tdl = new TelaTodosLivros();
                    tdl.setVisible(true);

                } catch (JaAvaliouException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Avaliação", JOptionPane.ERROR_MESSAGE);
                } 
                
                catch (AvaliacaoInvalidaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Avaliação", JOptionPane.ERROR_MESSAGE);
                } 
                
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Você digitou um valor inválido", "Avaliação", JOptionPane.ERROR_MESSAGE);
                }
                
                
                catch (IOException | ClassNotFoundException ex ) {
                    Logger.getLogger(TelaVisualizarTodosLivros.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
            }
        });
    
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
    
    private String retornaComments(){
    
        String result = "";
        
        for (int i = 0; i < livro.getComentarios().size(); i++) {
            
            result += livro.getComentarios().get(i) + "\n";
        }
        
        return result;
    
    }
    
    
}
