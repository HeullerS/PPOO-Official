
package ppo.de.pratico.trabalho.gui;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ppo.de.pratico.trabalho.tablemodel.LivroTableModelMeus;
import javax.swing.JOptionPane;
import ppo.de.pratico.trabalho.exceptions.LivroNaoEncontradoException;
import ppo.de.pratico.trabalho.gui.TelaCadastroDoLivro;


public class TelaMeusLivros extends javax.swing.JFrame {

    
    private LivroTableModelMeus tableM;
    
    public TelaMeusLivros() {
        super("Livraria Online");
        
        try {
            System.out.println("cheguei aqui");
            tableM = new LivroTableModelMeus();
            System.out.println("cheguei aqui 2");
            initComponents();
            JTMeusLibros.setModel(tableM);
             System.out.println("cheguei aqui 3");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro montagem da tabela", JOptionPane.ERROR_MESSAGE);
        } 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTMeusLibros = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();

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

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Cadastrar Livro");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar livro");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVisualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnVisualizar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
         TelaMenu tm = new TelaMenu();
         tm.setVisible(true);
         dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       
        if (JTMeusLibros.getSelectedRow() != -1) {
            
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente remover esse livro?", "Remoção", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION){
                try {
                    tableM.removeRow(JTMeusLibros.getSelectedRow());
                } catch (IOException | ClassNotFoundException | LivroNaoEncontradoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        TelaCadastroDoLivro tsr = new TelaCadastroDoLivro();
        tsr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

   
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if (JTMeusLibros.getSelectedRow() != -1) {
            
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente editar esse livro?", "Editar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    String titulo = (tableM.retornaTitulo(JTMeusLibros.getSelectedRow()));
                    String autor = (tableM.retornaAutor(JTMeusLibros.getSelectedRow()));
                    String descricao = (tableM.retornaDescricao(JTMeusLibros.getSelectedRow()));
                    String genero = (tableM.retornaGenero(JTMeusLibros.getSelectedRow()));
                    int anoLanc = (tableM.retornaAnoLancamento(JTMeusLibros.getSelectedRow()));
                    String[] palavrasChave = (tableM.retornaPalavrasChave(JTMeusLibros.getSelectedRow()));
                    TelaEditarLivro te = new TelaEditarLivro();
                    te.setar(titulo, autor, descricao, genero, anoLanc, palavrasChave);
                    te.setVisible(true);
                    dispose();
                    tableM.removeRow(JTMeusLibros.getSelectedRow());
                } catch (IOException | ClassNotFoundException | LivroNaoEncontradoException ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
                
                String anoLanc = Integer.toString((tableM.retornaAnoLancamento(JTMeusLibros.getSelectedRow())));
                
                TelaVisualizarLivro tv = new TelaVisualizarLivro(tableM.retornaTitulo(JTMeusLibros.getSelectedRow()), 
                        tableM.retornaDescricao(JTMeusLibros.getSelectedRow()), result , tableM.retornaAutor(JTMeusLibros.getSelectedRow()), 
                            tableM.retornaGenero(JTMeusLibros.getSelectedRow()), anoLanc);
                tv.setVisible(true);
                dispose();
            
        }
    }//GEN-LAST:event_btnVisualizarActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMeusLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMeusLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMeusLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMeusLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMeusLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTMeusLibros;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
