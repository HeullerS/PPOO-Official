
package ppo.de.pratico.trabalho.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;
import ppo.de.pratico.trabalho.tablemodel.LivroTableModel;


public class TelaTodosLivros extends javax.swing.JFrame {

    private LivroTableModel tableM;
    public TelaTodosLivros() {
        super("Livraria Online");
        try {
            tableM = new LivroTableModel();
            initComponents();
            JTMeusLibros.setModel(tableM);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro na tela", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTMeusLibros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTMeusLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTMeusLibros);

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar livro");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 367, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnVoltar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed

        TelaMenu tm = new TelaMenu();
         tm.setVisible(true);
         dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked

    }//GEN-LAST:event_btnVoltarMouseClicked

    
    public Livro retornaLivro(){
    
        Livro livrinho = (tableM.retornaLivro(JTMeusLibros.getSelectedRow()));
        return livrinho;
    }
    
    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
       if (JTMeusLibros.getSelectedRow() != -1) {
            
                String result = "";
                for (int i = 0; i < tableM.retornaPalavrasChave(JTMeusLibros.getSelectedRow()).length; i++) {
                    if (i == tableM.retornaPalavrasChave(JTMeusLibros.getSelectedRow()).length - 1) {
                        result += tableM.retornaPalavrasChave(JTMeusLibros.getSelectedRow())[i];
                    }
                    else{
                        result += tableM.retornaPalavrasChave(JTMeusLibros.getSelectedRow())[i] + ", ";
                    }
                    
                }
                Livro livrinho = (tableM.retornaLivro(JTMeusLibros.getSelectedRow()));
                String anoLanc = Integer.toString((tableM.retornaAnoLancamento(JTMeusLibros.getSelectedRow())));
                
           try {
               if ((tableM.retornaEmail(JTMeusLibros.getSelectedRow())).equals(GerenciadorUsuariosL.obterInstancia().obterEmailDoUsuarioLogado())) {
                   
                   TelaVisualizarMeusLivros tv = new TelaVisualizarMeusLivros(tableM.retornaTitulo(JTMeusLibros.getSelectedRow()), 
                    tableM.retornaDescricao(JTMeusLibros.getSelectedRow()), result , tableM.retornaAutor(JTMeusLibros.getSelectedRow()), 
                    tableM.retornaGenero(JTMeusLibros.getSelectedRow()), anoLanc, retornaLivro());
                    tv.setVisible(true);
                    dispose();
                   
               }
               else{
                   
                    TelaVisualizarTodosLivros tv = new TelaVisualizarTodosLivros(tableM.retornaTitulo(JTMeusLibros.getSelectedRow()), 
                    tableM.retornaDescricao(JTMeusLibros.getSelectedRow()), result , tableM.retornaAutor(JTMeusLibros.getSelectedRow()), 
                    tableM.retornaGenero(JTMeusLibros.getSelectedRow()), anoLanc, retornaLivro());
                    tv.setVisible(true);
                    dispose();
               
               }
           } catch (IOException | ClassNotFoundException ex ) {
               Logger.getLogger(TelaTodosLivros.class.getName()).log(Level.SEVERE, null, ex);
           } 
                     
        }
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().length() > 0) {
                

                 TelaBuscaLivros tbl = new TelaBuscaLivros(txtBuscar.getText());
                 tbl.setVisible(true);
                 dispose();

            
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaTodosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTodosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTodosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTodosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTodosLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTMeusLibros;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
