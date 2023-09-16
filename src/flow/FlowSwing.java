package flow;

import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FlowSwing extends javax.swing.JFrame {

    public FlowSwing() {
        initComponents();

        DefaultListModel<String> model = new DefaultListModel<>();
        musica.setModel(model);
    }

   
    public String type;
    public String name;

    
     MP3Player mp3player = new MP3Player();
    
    private int posActual = -1;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        musica = new javax.swing.JList<>();
        play = new javax.swing.JLabel();
        pause = new javax.swing.JLabel();
        stop = new javax.swing.JLabel();
        btnAddMusic = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FLOW MUSIC PLAYER");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        musica.setBackground(new java.awt.Color(0, 0, 0));
        musica.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(musica);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 620, 320));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playboton.png"))); // NOI18N
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 110, 100));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pauseiconeditado.png"))); // NOI18N
        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseMouseClicked(evt);
            }
        });
        getContentPane().add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 130, 120));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imageeditado.png"))); // NOI18N
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 130, 100));

        btnAddMusic.setBackground(new java.awt.Color(204, 204, 255));
        btnAddMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addmusica.png"))); // NOI18N
        btnAddMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMusicActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 190, 190));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoastetik2.jpg"))); // NOI18N
        fondo.setOpaque(true);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMusicActionPerformed
        JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("Z/" + name));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos MP3", "mp3");
        fileChooser.setFileFilter(filter);

        // Muestra el diálogo de selección de archivos y espera a que el usuario seleccione uno o varios archivos
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(this);

        // Si el usuario seleccionó un archivo, obtiene su ruta y lo carga en el reproductor
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (File file : files) {
                mp3player.addToPlayList(file);

                // Agrega el name del archivo a la lista
                DefaultListModel<String> model = (DefaultListModel<String>) musica.getModel();
                model.addElement(file.getName());
            }
        }
    }//GEN-LAST:event_btnAddMusicActionPerformed

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        mp3player.stop();
    }//GEN-LAST:event_stopMouseClicked

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
         int selectedIndex = musica.getSelectedIndex();
        if (selectedIndex != -1) {
            if (selectedIndex < posActual) {
                mp3player.skipBackward();
            } else {
                mp3player.skipForward();
            }
            mp3player.play();
            posActual = selectedIndex;
        }
    }//GEN-LAST:event_playMouseClicked

    private void pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseClicked
        mp3player.pause();
    }//GEN-LAST:event_pauseMouseClicked


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
            java.util.logging.Logger.getLogger(FlowSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlowSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlowSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlowSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlowSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMusic;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> musica;
    private javax.swing.JScrollPane panel;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel play;
    private javax.swing.JLabel stop;
    // End of variables declaration//GEN-END:variables
}
