/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppo.de.pratico.trabalho.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ppo.de.pratico.trabalho.modelos.Livro;
import ppo.de.pratico.trabalho.servicos.GerenciadorUsuariosL;
import ppo.de.pratico.trabalho.tablemodel.LivroTableModelBusca;
import ppo.de.pratico.trabalho.tablemodel.LivroTableModelMeus;

/**
 *
 * @author Héuller
 */
public class TelaBuscaLivros extends javax.swing.JFrame {

    
    private LivroTableModelBusca tableM;

    public TelaBuscaLivros(String titulo) {
        
        try { 
            tableM = new LivroTableModelBusca(titulo);
            initComponents();
            JTMeusLibros.setModel(tableM);
            
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro montagem da tabela", JOptionPane.ERROR_MESSAGE);
        } 
        
    }

    public TelaBuscaLivros() {
        
    }
    
    public int tamTabela(){
    
        return tableM.getRowCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTMeusLibros = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
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

        btnVoltar.setText("Voltar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisualizar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnVoltar)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
            TelaTodosLivros tdl = new TelaTodosLivros();
            tdl.setVisible(true);
            dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
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
                    tableM.retornaGenero(JTMeusLibros.getSelectedRow()), anoLanc, retornaLivro(), tableM.retornaEmail(JTMeusLibros.getSelectedRow()));
                    tv.setVisible(true);
                    dispose();
                   
               }
               else{
                   
                    TelaVisualizarTodosLivros tv = new TelaVisualizarTodosLivros(tableM.retornaTitulo(JTMeusLibros.getSelectedRow()), 
                    tableM.retornaDescricao(JTMeusLibros.getSelectedRow()), result , tableM.retornaAutor(JTMeusLibros.getSelectedRow()), 
                    tableM.retornaGenero(JTMeusLibros.getSelectedRow()), anoLanc, retornaLivro(), tableM.retornaEmail(JTMeusLibros.getSelectedRow()));
                    tv.setVisible(true);
                    dispose();
               
               }
           } catch (IOException | ClassNotFoundException ex ) {
               Logger.getLogger(TelaTodosLivros.class.getName()).log(Level.SEVERE, null, ex);
           } 
                     
        }
    }//GEN-LAST:event_btnVisualizarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaBuscaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBuscaLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTMeusLibros;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
