/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.spotifei.view;

import com.mycompany.spotifei.control.PlaylistsController;
import com.mycompany.spotifei.model.entity.Musica;
import com.mycompany.spotifei.model.entity.Playlist;
import com.mycompany.spotifei.model.entity.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author becastal
 */
public class Playlists extends javax.swing.JFrame {
	Usuario user;
	PlaylistsController controller;

	/**
	 * Creates new form Playlists
	 * @param user_
	 */
	public Playlists(Usuario user_) {
		initComponents();
		user = user_;
		controller = new PlaylistsController();

		jTable1.setModel(new DefaultTableModel(
			new Object[]{"ID", "Nome"}, 0
		));
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jTable2.setModel(new DefaultTableModel(
			new Object[]{"ID", "Título", "Artista", "Gênero"}, 0
		));
		jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		carregarPlaylists();
	}

	private void carregarPlaylists() {
		try {
			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			model.setRowCount(0);
			ArrayList<Playlist> pls = controller.listarPlaylists(user.getId());
			for (Playlist p : pls) {
				model.addRow(new Object[]{p.getId(), p.getNome()});
			}
			((DefaultTableModel) jTable2.getModel()).setRowCount(0);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar playlists: " + ex.getMessage());
		}
	}

	private void carregarMusicas(int playlistId) {
		try {
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			model.setRowCount(0);
			ArrayList<Musica> S = controller.listarMusicas(playlistId);
			for (Musica m : S) {
				model.addRow(new Object[]{
					m.getId(),
					m.getTitulo(),
					m.getArtista().getNome(),
					m.getGenero()
				});
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar músicas: " + ex.getMessage());
		}
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable();
                jLabel4 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("CCM310 - Spotifei");

                jLabel1.setText("Playlists");

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                jTable1.setShowGrid(true);
                jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable1MouseClicked(evt);
                        }
                });
                jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                jTable1PropertyChange(evt);
                        }
                });
                jScrollPane1.setViewportView(jTable1);

                jLabel2.setText("Minhas Playlists");

                jLabel3.setText("Músicas");

                jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                jTable2.setShowGrid(true);
                jScrollPane2.setViewportView(jTable2);

                jLabel4.setForeground(new java.awt.Color(255, 51, 51));
                jLabel4.setText("voltar");
                jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabel4MouseClicked(evt);
                        }
                });

                jButton1.setText("Criar");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setText("Excluir");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setText("Adicionar");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                jButton4.setText("Excluir");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton2)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 174, Short.MAX_VALUE)
                                                                .addComponent(jButton3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton4)))))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton4)
                                                .addComponent(jButton3))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton1)
                                                .addComponent(jButton2)))
                                .addGap(17, 17, 17))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
                new Menu(user).setVisible(true);
                dispose();
        }//GEN-LAST:event_jLabel4MouseClicked

        private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
		int sel = jTable1.getSelectedRow();
		if (sel != -1) {
			int playlistId = (int) jTable1.getValueAt(sel, 0);
			carregarMusicas(playlistId);
		}
        }//GEN-LAST:event_jTable1PropertyChange

        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
		int sel = jTable1.getSelectedRow();
		if (sel != -1) {
			int playlistId = (int) jTable1.getValueAt(sel, 0);
			carregarMusicas(playlistId);
		}
        }//GEN-LAST:event_jTable1MouseClicked

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		String nome = JOptionPane.showInputDialog(this, "Nome da nova playlist:");
		if (nome != null && !nome.isBlank()) {
			try {
				controller.criarPlaylist(user.getId(), nome);
				carregarPlaylists();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Erro ao criar playlist: " + ex.getMessage());
			}
		}
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		int sel = jTable1.getSelectedRow();
		if (sel == -1) {
			JOptionPane.showMessageDialog(this, "Nenhuma playlist selecionada.");
			return;
		}
		int playlistId = (int) jTable1.getValueAt(sel, 0);
		try {
			controller.deletarPlaylist(playlistId);
			carregarPlaylists();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Erro ao excluir playlist: " + ex.getMessage());
		}
        }//GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		int sel = jTable1.getSelectedRow();
		if (sel == -1) {
			JOptionPane.showMessageDialog(Playlists.this, "Nenhuma playlist selecionada.");
			return;
		}

		Musicas S = new Musicas(user, true);
		S.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				ArrayList<Musica> sels = S.getResultadoSelecao();
				if (sels.isEmpty()) {
					JOptionPane.showMessageDialog(Playlists.this, "Nenhuma música selecionada");
					return;
				}
				int playlistId = (int) jTable1.getValueAt( jTable1.getSelectedRow(), 0);
				for (Musica m : sels) {
					try {
						controller.adicionarMusica(playlistId, m.getId());
					} catch (SQLException ex) {
					}
				}
				carregarMusicas(playlistId);
			}
		});
		S.setVisible(true);
        }//GEN-LAST:event_jButton3ActionPerformed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		int rMusica = jTable2.getSelectedRow();
		if (rMusica == -1) {
			JOptionPane.showMessageDialog(this, "Selecione uma música para remover.");
			return;
		}

		int m = jTable2.convertRowIndexToModel(rMusica);
		DefaultTableModel songModel = (DefaultTableModel) jTable2.getModel();
		int musicaId = (int) songModel.getValueAt(m, 0);

		int rPlaylist = jTable1.getSelectedRow();
		if (rPlaylist == -1) {
			JOptionPane.showMessageDialog(this, "Selecione primeiro uma playlist.");
			return;
		}
		int playlistId = (int) jTable1.getValueAt(rPlaylist, 0);

		try {
			controller.removerMusica(playlistId, musicaId);
			carregarMusicas(playlistId);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog( this, "Erro ao remover música: " + ex.getMessage());
		}
        }//GEN-LAST:event_jButton4ActionPerformed

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
			java.util.logging.Logger.getLogger(Playlists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Playlists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Playlists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Playlists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTable jTable1;
        private javax.swing.JTable jTable2;
        // End of variables declaration//GEN-END:variables
}
