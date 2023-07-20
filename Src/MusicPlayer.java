package Src;
import Src.CustomWidgets.RoundedBorder;
import Src.JTableDeleteIcon.TableDeletesCellEditor;
import Src.JTableDeleteIcon.TableDeleteCellRender;
import Src.JTableDeleteIcon.TableDeleteEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.event.ActionEvent;
/**
 *
 * @author Chirag
 */
public class MusicPlayer extends javax.swing.JFrame {

    JFileChooser openMultisFileChooser;
    ArrayList<String> songsFileList = new ArrayList<>();
    ArrayList<String> animationArray = new ArrayList<String>();

    long total_length, pause;
    FileInputStream fileInputStream;
    BufferedInputStream BufferedInputStream;
    Player player;
    String myFile = null;
    ImageIcon playIcon, pauseIcon, backwardIcon, forwardIcon;
    boolean checkSong = false;
    boolean checkPlayer;

    public MusicPlayer() {
        initComponents();

        animationArray.add("src\\Images\\Gif\\gif1.gif");
        animationArray.add("src\\Images\\Gif\\gif2.gif");
        animationArray.add("src\\Images\\Gif\\gif3.gif");
        TableDeleteEvent event = new TableDeleteEvent() {
            @Override
            public void onDelete(int row) {
                if (SongTable.isEditing()) {
                    SongTable.getCellEditor().stopCellEditing();
                }
                checkPlayer = (player!=null);
                DefaultTableModel model = (DefaultTableModel) SongTable.getModel();
                songsFileList.remove(row);
                model.removeRow(row);
                if(checkPlayer){
                if(row<SongTable.getRowCount()){
                SongTable.setRowSelectionInterval(0,row);
                player.close();
                playSong();
                }
                if(SongTable.getRowCount()==0 && player!=null){
                    player.close();
                    SongNameLabel.setText("");
                    AnimationLabel.setIcon(null);
                }
                }
            }
        };
        AnimationLabel.setBorder(new RoundedBorder(Color.BLACK, 178));
        playIcon = new ImageIcon("src\\Images\\Icon\\play.png");
        pauseIcon = new ImageIcon("src\\Images\\Icon\\pause.png");
        backwardIcon = new ImageIcon("src\\Images\\Icon\\backward.png");
        forwardIcon = new ImageIcon("src\\Images\\Icon\\forward.png");
        openMultisFileChooser = new JFileChooser();
        openMultisFileChooser.setAcceptAllFileFilterUsed(false);
        openMultisFileChooser.setMultiSelectionEnabled(true);
        SongTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        openMultisFileChooser.setFileFilter(new FileNameExtensionFilter("mp3 file", "mp3"));
        SongTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        SongTable.getTableHeader().setOpaque(false);
        SongTable.setRowHeight(40);
        SongTable.getColumnModel().getColumn(1).setCellRenderer(new TableDeleteCellRender());
        SongTable.getColumnModel().getColumn(1).setCellEditor(new TableDeletesCellEditor(event));

    }
    
    public void showMessage(String message){
        showMessageLabel.setText(message);
        Timer t = new Timer(2000, (ActionEvent e) -> {
            showMessageLabel.setText("");
        });
        t.setRepeats(false);
        t.start();
        
    }
    
    
    class JPanelGradient_custom extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = Background.getWidth();
            int height = Background.getHeight();
//            Dimension arcs = new Dimension(70,70);
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            Color c1 = new Color(52, 143, 80);
            Color c2 = new Color(86, 180, 211);

//            Color c1 = new Color(236, 0, 140);
//            Color c2 = new Color(252,103,103);
            GradientPaint gp = new GradientPaint(0, 0, c1, 180, height, c2);
            g2d.setPaint(gp);

            g2d.fillRect(0, 0, width, height);
//            g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new JPanelGradient_custom();
        panelTransparent1 = new Src.CustomWidgets.PanelTransparent();
        AnimationLabel = new javax.swing.JLabel();
        SongNameLabel = new javax.swing.JLabel();
        forwardBtn = new Src.CustomWidgets.JbuttonCustom();
        playPauseBtn = new Src.CustomWidgets.JbuttonCustom();
        backwardBtn = new Src.CustomWidgets.JbuttonCustom();
        showMessageLabel = new javax.swing.JLabel();
        close_lbl_btn = new javax.swing.JLabel();
        minimize_lbl_btn = new javax.swing.JLabel();
        AppHeadLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SongTable = new javax.swing.JTable();
        AddSongsButton = new Src.CustomWidgets.JbuttonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        AnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        SongNameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        SongNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        forwardBtn.setForeground(new java.awt.Color(255, 255, 255));
        forwardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/forward.png"))); // NOI18N
        forwardBtn.setBorderPainted(false);
        forwardBtn.setRadius(100);
        forwardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardBtnActionPerformed(evt);
            }
        });

        playPauseBtn.setForeground(new java.awt.Color(255, 255, 255));
        playPauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/play.png"))); // NOI18N
        playPauseBtn.setBorderPainted(false);
        playPauseBtn.setRadius(100);
        playPauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseBtnActionPerformed(evt);
            }
        });

        backwardBtn.setForeground(new java.awt.Color(255, 255, 255));
        backwardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/backward.png"))); // NOI18N
        backwardBtn.setBorderPainted(false);
        backwardBtn.setRadius(100);
        backwardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwardBtnActionPerformed(evt);
            }
        });

        showMessageLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        showMessageLabel.setForeground(new java.awt.Color(255, 51, 51));
        showMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(backwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(playPauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(forwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(AnimationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent1Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SongNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(AnimationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(SongNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playPauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(showMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        close_lbl_btn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        close_lbl_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_lbl_btn.setText("X");
        close_lbl_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_lbl_btnMouseClicked(evt);
            }
        });

        minimize_lbl_btn.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        minimize_lbl_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize_lbl_btn.setText("-");
        minimize_lbl_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize_lbl_btnMouseClicked(evt);
            }
        });

        AppHeadLabel.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        AppHeadLabel.setForeground(new java.awt.Color(255, 204, 102));
        AppHeadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AppHeadLabel.setText("Tune");

        SongTable.setBackground(new java.awt.Color(153, 255, 255));
        SongTable.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 51)));
        SongTable.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        SongTable.setForeground(new java.awt.Color(51, 51, 51));
        SongTable.getTableHeader().setBackground(Color.red);
        SongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Song Title", "Delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SongTable.setFocusable(false);
        SongTable.setGridColor(new java.awt.Color(255, 204, 204));
        SongTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        SongTable.setRowHeight(33);
        SongTable.setSelectionBackground(new java.awt.Color(242, 127, 242));
        SongTable.setShowVerticalLines(false);
        SongTable.getTableHeader().setResizingAllowed(false);
        SongTable.getTableHeader().setReorderingAllowed(false);
        SongTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SongTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SongTable);
        if (SongTable.getColumnModel().getColumnCount() > 0) {
            SongTable.getColumnModel().getColumn(0).setMinWidth(350);
            SongTable.getColumnModel().getColumn(0).setPreferredWidth(350);
            SongTable.getColumnModel().getColumn(0).setMaxWidth(350);
        }

        AddSongsButton.setText("Add Songs");
        AddSongsButton.setToolTipText("Add Song");
        AddSongsButton.setBorderPainted(false);
        AddSongsButton.setRadius(30);
        AddSongsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSongsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AppHeadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimize_lbl_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(close_lbl_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                .addComponent(AddSongsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)))))
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AppHeadLabel)
                        .addComponent(minimize_lbl_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(close_lbl_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddSongsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_lbl_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lbl_btnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_close_lbl_btnMouseClicked

    private void minimize_lbl_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_lbl_btnMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimize_lbl_btnMouseClicked

    private void forwardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardBtnActionPerformed
        forwardSong();
    }//GEN-LAST:event_forwardBtnActionPerformed

    private void playPauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) SongTable.getModel();
        int rowcount = model.getRowCount();
        if(rowcount==0){
            showMessage("Song Table is Empty.");
        }
        else if(rowcount > 0 && SongTable.getSelectedRow() == -1){
            checkSong = true;
            playSong();
            playPauseBtn.setIcon(pauseIcon);
        }
        else if ( rowcount > 0 && SongTable.getSelectedRow() >= 0) {
            if(checkSong){
                pauseSong();
                playPauseBtn.setIcon(playIcon);
                checkSong = false;
            }
            else{
                resumeSong();
                checkSong = true;
                playPauseBtn.setIcon(pauseIcon);
            }
            
        }


//        playPauseBtn.setIcon(pauseIcon);
    }//GEN-LAST:event_playPauseBtnActionPerformed

    private void backwardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwardBtnActionPerformed
        backwardSong();
    }//GEN-LAST:event_backwardBtnActionPerformed

    private void AddSongsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSongsButtonActionPerformed
        try {

            Component frame = null;
//        writer = new FileWriter("C:\\Users\\Admin\\Desktop\\mood\\SongList.txt");
//        int returnVal = openMultisFileChooser.showSaveDialog(frame);
            int returnVal = openMultisFileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File[] files = openMultisFileChooser.getSelectedFiles();
                ArrayList<String> arrayList = new ArrayList<>();
                for (File file : files) {
                    String filename = file.getName();
                    String filePath = file.toString();

                    if (filename.endsWith("mp3")) {
                        filename = filename.replace("mp3", "");
                    } else {
                        continue;
                    }
                    arrayList.add(filename);
                    songsFileList.add(filePath);
                }
                int count = files.length;
                DefaultTableModel model = (DefaultTableModel) SongTable.getModel();

                for (int i = 0; i < files.length; i++) {

                    Object[] row = {arrayList.get(i)};
                    model.addRow(row);
                }
            } else {
                showMessage("NO SONGS SELECTED.");
            }

        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddSongsButtonActionPerformed

    private void SongTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SongTableMouseClicked
        playSong();
    }//GEN-LAST:event_SongTableMouseClicked

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
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MusicPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Src.CustomWidgets.JbuttonCustom AddSongsButton;
    private javax.swing.JLabel AnimationLabel;
    private javax.swing.JLabel AppHeadLabel;
    public javax.swing.JPanel Background;
    private javax.swing.JLabel SongNameLabel;
    public javax.swing.JTable SongTable;
    private Src.CustomWidgets.JbuttonCustom backwardBtn;
    private javax.swing.JLabel close_lbl_btn;
    private Src.CustomWidgets.JbuttonCustom forwardBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimize_lbl_btn;
    private Src.CustomWidgets.PanelTransparent panelTransparent1;
    private Src.CustomWidgets.JbuttonCustom playPauseBtn;
    private javax.swing.JLabel showMessageLabel;
    // End of variables declaration//GEN-END:variables

    private class ThreadImpl extends Thread {

        public ThreadImpl() {
        }

        @Override
        public void run() {
            try {
                player.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void playSong() {
        DefaultTableModel model = (DefaultTableModel) SongTable.getModel();
        int rowcount = model.getRowCount();
        if (rowcount == 0) {
            checkSong = false;
            showMessage("Song Table is Empty.");
        } else if (SongTable.getSelectedRow() == -1) {
            if (player != null) {
                player.close();
            }
            checkSong = true;
            playPauseBtn.setIcon(pauseIcon);
            SongTable.setRowSelectionInterval(0, 0);
            int rnd = new Random().nextInt(animationArray.size());
            SongNameLabel.setText(model.getValueAt(0, 0).toString());
            ImageIcon icon = new ImageIcon(animationArray.get(rnd));
            AnimationLabel.setIcon(icon);
            try {
                myFile = songsFileList.get(0);
                fileInputStream = new FileInputStream(myFile);
                BufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(BufferedInputStream);
                total_length = fileInputStream.available();
                new ThreadImpl().start();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JavaLayerException | IOException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (player != null) {
                player.close();
            }

            if (SongTable.getSelectedColumn() == 0 || checkPlayer==true) {
                checkSong = true;
                playPauseBtn.setIcon(pauseIcon);
                int rnd = new Random().nextInt(animationArray.size());
                SongNameLabel.setText(model.getValueAt(SongTable.getSelectedRow(), 0).toString());
                ImageIcon icon = new ImageIcon(animationArray.get(rnd));
                AnimationLabel.setIcon(icon);
                try {
                    myFile = songsFileList.get(SongTable.getSelectedRow());
                    fileInputStream = new FileInputStream(myFile);
                    BufferedInputStream = new BufferedInputStream(fileInputStream);
                    player = new Player(BufferedInputStream);
                    total_length = fileInputStream.available();
                    new ThreadImpl().start();
                    

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException | IOException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

    public void resumeSong() {
        try {
            fileInputStream = new FileInputStream(myFile);
            fileInputStream.skip(total_length - pause);
            BufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new Player(BufferedInputStream);
            
            new ThreadImpl().start();

        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pauseSong() {
        if (player != null) {
            try {
                pause = fileInputStream.available();
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void forwardSong() {
        DefaultTableModel model = (DefaultTableModel) SongTable.getModel();
        int rowcount = model.getRowCount();
        int selectedRow = SongTable.getSelectedRow();
        if (rowcount == 0) {
            showMessage("Song Table is Empty.");
        } else if (rowcount > 0 && player == null) {
            showMessage("click a song to play.");
        }
        else if(selectedRow<rowcount-1 && player!=null){
                SongTable.setRowSelectionInterval(0,selectedRow+1);
                player.close();
                playSong();
        }     
    }
    

    public void backwardSong() {
        DefaultTableModel model = (DefaultTableModel) SongTable.getModel();
        int rowcount = model.getRowCount();
        int selectedRow = SongTable.getSelectedRow();
        if (rowcount == 0) {
            showMessage("Song Table is Empty.");
        } else if (rowcount > 0 && player == null) {
            showMessage("click a song to play.");
        }
        else if(selectedRow>0 && player!=null){
                SongTable.setRowSelectionInterval(0,selectedRow-1);
                player.close();
                playSong();
        }   
    }

}
