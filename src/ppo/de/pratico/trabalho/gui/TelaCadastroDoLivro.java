
package ppo.de.pratico.trabalho.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import ppo.de.pratico.trabalho.tablemodel.LivroTableModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ppo.de.pratico.trabalho.exceptions.CampoComQuantidadeMinimaException;
import ppo.de.pratico.trabalho.exceptions.CampoVazioException;
import ppo.de.pratico.trabalho.exceptions.PalavraChaveIgualException;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.modelos.Usuario;
import ppo.de.pratico.trabalho.seguranca.SessaoUsuarioL;
import ppo.de.pratico.trabalho.servicos.GerenciadorLivrosL;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;


public class TelaCadastroDoLivro extends JFrame{
    
    private LivroTableModel tableModel;
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    private JPanel painelCadastrarRecurso;
    private JLabel icnCadastrarRecurso;
    private JLabel lbCadastrarRecurso;
    
    private JLabel lbTitulo;
    private JTextField txtTitulo;
    
    private JLabel lbAutor;
    private JTextField txtAutor;
    
    private JLabel lbGenero;
    private JTextField txtGenero;
    
    private JLabel lbAnoLancamento;
    private JTextField txtAnoLancamento;
    
    private JLabel lbDescricao;
    private JTextArea txtDescricao;
    private JPanel painelDescricao;
    private JScrollPane scrollDesc;
    
    private JLabel lbPalavrasChave;
    private JTextField txtPalavrasChave;
    
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JPanel painelBotoes;

    public TelaCadastroDoLivro() {
        super("Livraria Online");
        setSize(400,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializar();
        
    }
    
    private void inicializar(){
        
        construirTela();
        configurarAcoesBotoes();
    }
    
    private void construirTela(){
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        
        icnCadastrarRecurso = new JLabel(new ImageIcon(getClass().getResource("../img/icnCadastrarRecurso.png")));
        lbCadastrarRecurso = new JLabel("Cadastrar livro");
        painelCadastrarRecurso = new JPanel();
        painelCadastrarRecurso.add(icnCadastrarRecurso);
        painelCadastrarRecurso.add(lbCadastrarRecurso);
        adicionarComponente(painelCadastrarRecurso, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 3, 1);
       
        lbTitulo = new JLabel("Titulo");
        adicionarComponente(lbTitulo, GridBagConstraints.WEST, GridBagConstraints.BOTH, 1, 0, 1, 1);
        txtTitulo = new JTextField(25);
        adicionarComponente(txtTitulo, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 2, 0, 1, 1);
        
        lbAutor = new JLabel("Autor");
        adicionarComponente(lbAutor, GridBagConstraints.WEST, GridBagConstraints.BOTH, 3, 0, 1, 1);
        txtAutor = new JTextField(6);
        adicionarComponente(txtAutor, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 4, 0, 1, 1);
        
        lbGenero = new JLabel("Gênero");
        adicionarComponente(lbGenero, GridBagConstraints.WEST, GridBagConstraints.BOTH, 5, 0, 2, 1);
        txtGenero = new JTextField(6);
        adicionarComponente(txtGenero, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 6, 0, 1, 1);
        
        lbAnoLancamento = new JLabel("Ano de lançamento");
        adicionarComponente(lbAnoLancamento, GridBagConstraints.WEST, GridBagConstraints.BOTH, 7, 0, 1, 1);
        txtAnoLancamento = new JTextField(6);
        adicionarComponente(txtAnoLancamento, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 8, 0, 1, 1);
        
        
        
        lbDescricao = new JLabel("Descrição");
        adicionarComponente(lbDescricao, GridBagConstraints.WEST, GridBagConstraints.BOTH, 9, 0, 1, 1);
        txtDescricao = new JTextArea();
        scrollDesc = new JScrollPane(txtDescricao);
        scrollDesc.setPreferredSize(new Dimension(250, 150)); 
        painelDescricao = new JPanel(new GridLayout(1, 1));
        painelDescricao.add(scrollDesc, BorderLayout.PAGE_END);
        adicionarComponente(painelDescricao, GridBagConstraints.WEST, GridBagConstraints.BOTH, 10, 0, 1, 1);
        
        
        lbPalavrasChave = new JLabel("Palavras-chave (mínimo 2)");
        adicionarComponente(lbPalavrasChave, GridBagConstraints.WEST, GridBagConstraints.BOTH, 11, 0, 1, 1);
        txtPalavrasChave = new JTextField(6);
        adicionarComponente(txtPalavrasChave, GridBagConstraints.WEST, GridBagConstraints.BOTH, 12, 0, 1, 1);
        
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        painelBotoes = new JPanel();
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        adicionarComponente(painelBotoes, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 13, 0, 1, 1);
    }
    
    private Livro carregarLivro() {
        
        int ano = Integer.parseInt(txtAnoLancamento.getText());
        try {
            return (new Livro(txtTitulo.getText(), txtAutor.getText(), txtDescricao.getText(), txtGenero.getText(), ano,
                    txtPalavrasChave.getText().split(" "), GerenciadorUsuariosL.obterInstancia().obterEmailDoUsuarioLogado()));
        } catch (IOException |ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Carregar Livro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
        
    }
    
    private void validarCampos() throws Exception{
    
        if (txtTitulo.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbTitulo);
        }
        if (txtAutor.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbAutor);
        }
        
        if (txtGenero.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbGenero);
        }
        if (txtAnoLancamento.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbAnoLancamento);
        }
        if (txtDescricao.getText().trim().isEmpty()) {
            throw new CampoVazioException(lbDescricao);
        }
        
        String palavraChave[] = txtPalavrasChave.getText().split(" ");
        if (palavraChave.length < 2) {
            throw new CampoComQuantidadeMinimaException(lbPalavrasChave);
        }
        
        for (int i = 0; i < palavraChave.length; i++) {
            for (int j = 0; j < palavraChave.length - 1; j++) {
                if ((palavraChave[i].equals(palavraChave[j+1])) && (i != j+1)) {
                throw new PalavraChaveIgualException();
            }
            }
        }
        
    }
    
   
    private void configurarAcoesBotoes(){
        
        btnSalvar.addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    validarCampos();
                    GerenciadorLivrosL.obterInstancia().cadastrarLivro(carregarLivro());
                    JOptionPane.showMessageDialog(null, "Livro salvo com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    limparTela();
                }catch(NumberFormatException ex){
                 
                      JOptionPane.showMessageDialog(null, "O ano de lançamento deve ser um número!", "Recurso", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnCancelar.addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                 
                TelaMeusLivros tmas = new TelaMeusLivros();
                tmas.setVisible(true);
                dispose();
            }
        });
    }
    
    private void limparTela(){
    
        txtTitulo.setText("");
        txtAutor.setText("");
        txtGenero.setText("");
        txtAnoLancamento.setText("");
        txtDescricao.setText("");
        txtPalavrasChave.setText("");
    
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
