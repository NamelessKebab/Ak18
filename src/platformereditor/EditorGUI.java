/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformereditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * Editor.java Zweck: Die GUI des Editors
 *
 * @author Flo & Julian
 */
public class EditorGUI extends javax.swing.JFrame {

    Dimension tsize;
    Editor editorobj;

    /**
     * Erstellt die EditorGUI und fügt die RadioButtons in dem "Rechtsklickmenü"
     * jeweils zu einer ButtonGroup hinzu. Zudem Schiebt er das Fenster in die
     * Mitte.
     */
    EditorGUI(Editor editor) {
        editorobj = editor;
        initComponents();

        btngRcklMenu.add(rbmitAdd);
        btngRcklMenu.add(rbmitDel);
        btngRcklMenu.add(rbmitSelect);

        btngRcklMenuType.add(rbmitSpieler);
        btngRcklMenuType.add(rbmitBlock);
        btngRcklMenuType.add(rbmitZiel);

        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rcklMenu = new javax.swing.JPopupMenu();
        rbmitAdd = new javax.swing.JRadioButtonMenuItem();
        rbmitSelect = new javax.swing.JRadioButtonMenuItem();
        rbmitDel = new javax.swing.JRadioButtonMenuItem();
        sep2 = new javax.swing.JPopupMenu.Separator();
        rbmitSpieler = new javax.swing.JRadioButtonMenuItem();
        rbmitBlock = new javax.swing.JRadioButtonMenuItem();
        rbmitZiel = new javax.swing.JRadioButtonMenuItem();
        btngRcklMenu = new javax.swing.ButtonGroup();
        btngRcklMenuType = new javax.swing.ButtonGroup();
        pnEditor = new EditorPanel();
        mbMenu = new javax.swing.JMenuBar();
        miDatei = new javax.swing.JMenu();
        mitNeu = new javax.swing.JMenuItem();
        mitOeffne = new javax.swing.JMenuItem();
        mitSave = new javax.swing.JMenuItem();
        sep1 = new javax.swing.JPopupMenu.Separator();
        reRender = new javax.swing.JMenuItem();
        miWindows = new javax.swing.JMenu();
        mitOpenProps = new javax.swing.JMenuItem();
        mitOpenLevelProps = new javax.swing.JMenuItem();
        miExtra = new javax.swing.JMenu();
        mitInfo = new javax.swing.JMenuItem();

        rbmitAdd.setSelected(true);
        rbmitAdd.setText("Hinzufügen");
        rbmitAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmitActionPerformed(evt);
            }
        });
        rcklMenu.add(rbmitAdd);

        rbmitSelect.setSelected(true);
        rbmitSelect.setText("Auswählen");
        rbmitSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmitActionPerformed(evt);
            }
        });
        rcklMenu.add(rbmitSelect);

        rbmitDel.setSelected(true);
        rbmitDel.setText("Entfernen");
        rbmitDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmitActionPerformed(evt);
            }
        });
        rcklMenu.add(rbmitDel);
        rcklMenu.add(sep2);

        rbmitSpieler.setSelected(true);
        rbmitSpieler.setText("Spieler");
        rbmitSpieler.setActionCommand("Spielerbtn");
        rbmitSpieler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmitTypeActionPerformed(evt);
            }
        });
        rcklMenu.add(rbmitSpieler);

        rbmitBlock.setSelected(true);
        rbmitBlock.setText("Block");
        rbmitBlock.setActionCommand("Blockbtn");
        rbmitBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmitTypeActionPerformed(evt);
            }
        });
        rcklMenu.add(rbmitBlock);

        rbmitZiel.setSelected(true);
        rbmitZiel.setText("Ziel");
        rbmitZiel.setActionCommand("Zielbtn");
        rbmitZiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmitTypeActionPerformed(evt);
            }
        });
        rcklMenu.add(rbmitZiel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pnEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnEditorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnEditorLayout = new javax.swing.GroupLayout(pnEditor);
        pnEditor.setLayout(pnEditorLayout);
        pnEditorLayout.setHorizontalGroup(
            pnEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        pnEditorLayout.setVerticalGroup(
            pnEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        getContentPane().add(pnEditor);

        mbMenu.setBackground(new java.awt.Color(204, 204, 204));

        miDatei.setText("Datei");

        mitNeu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mitNeu.setText("Neu");
        mitNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNeuActionPerformed(evt);
            }
        });
        miDatei.add(mitNeu);

        mitOeffne.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mitOeffne.setText("Öffnen");
        mitOeffne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitOeffneActionPerformed(evt);
            }
        });
        miDatei.add(mitOeffne);

        mitSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mitSave.setText("Speichern");
        mitSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSaveActionPerformed(evt);
            }
        });
        miDatei.add(mitSave);
        miDatei.add(sep1);

        reRender.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        reRender.setText("Aktualisieren");
        reRender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reRenderActionPerformed(evt);
            }
        });
        miDatei.add(reRender);

        mbMenu.add(miDatei);

        miWindows.setText("Fenster");

        mitOpenProps.setText("Objekt Eigenschaften");
        mitOpenProps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitOpenPropsActionPerformed(evt);
            }
        });
        miWindows.add(mitOpenProps);

        mitOpenLevelProps.setText("Level Eigenschaften");
        mitOpenLevelProps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitOpenLevelPropsActionPerformed(evt);
            }
        });
        miWindows.add(mitOpenLevelProps);

        mbMenu.add(miWindows);

        miExtra.setText("Extra");

        mitInfo.setText("Info");
        miExtra.add(mitInfo);

        mbMenu.add(miExtra);

        setJMenuBar(mbMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitOeffneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitOeffneActionPerformed
        editorobj.openClicked();
    }//GEN-LAST:event_mitOeffneActionPerformed

    /**
     * Setzt die Panelgröße und passt das Frame auf die größe an.
     *
     * @param size
     */
    public void setPanelSize(Dimension size) {
        pnEditor.setPreferredSize(size);
        this.pack();
    }

    /**
     * Zeichnet das Frame neu
     */
    public void reRender() {
        pnEditor.repaint();
    }
    private void reRenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reRenderActionPerformed
        reRender();
    }//GEN-LAST:event_reRenderActionPerformed

    private void pnEditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnEditorMouseClicked
        editorobj.panelClicked(evt);
    }//GEN-LAST:event_pnEditorMouseClicked

    private void mitOpenPropsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitOpenPropsActionPerformed
        editorobj.openProps();
    }//GEN-LAST:event_mitOpenPropsActionPerformed

    private void mitSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSaveActionPerformed
        editorobj.saveClicked();
    }//GEN-LAST:event_mitSaveActionPerformed

    private void mitNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNeuActionPerformed
        editorobj.newClicked();
    }//GEN-LAST:event_mitNeuActionPerformed

    private void rbmitTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmitTypeActionPerformed
        editorobj.updateProps();
    }//GEN-LAST:event_rbmitTypeActionPerformed

    private void rbmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmitActionPerformed
        editorobj.checkAuswaehl();
    }//GEN-LAST:event_rbmitActionPerformed

    private void mitOpenLevelPropsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitOpenLevelPropsActionPerformed
        editorobj.openLevelProps();
    }//GEN-LAST:event_mitOpenLevelPropsActionPerformed

    /**
     * Zeigt das Rechtklickmenü an der entsprechenden Stelle.
     *
     * @param evt
     */
    public void showRightClickMenu(MouseEvent evt) {
        rcklMenu.show(this, evt.getX(), evt.getY());
    }

    /**
     * Gibt die Blocktyp Auswahl des "Rechtsklickmenüs" zurück
     * @return Blocktyp
     */
    public int getRightClickMenuTypeStatus() {
        if (rbmitSpieler.isSelected()) {
            return 1; // Spieler
        }
        if (rbmitBlock.isSelected()) {
            return 2; // Block
        }
        if (rbmitZiel.isSelected()) {
            return 3; // Ziel
        }
        return 0;
    }

    /**
     * Gibt die Aktion Auswahl des "Rechtsklickmenüs" zurück
     * @return Aktion
     */
    public int getRightClickMenuStatus() {
        if (rbmitAdd.isSelected()) {
            return 1; // Hinzufügen
        }
        if (rbmitSelect.isSelected()) {
            return 2; // Auswählen
        }
        if (rbmitDel.isSelected()) {
            return 3; // Entfernen
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngRcklMenu;
    private javax.swing.ButtonGroup btngRcklMenuType;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenu miDatei;
    private javax.swing.JMenu miExtra;
    private javax.swing.JMenu miWindows;
    private javax.swing.JMenuItem mitInfo;
    private javax.swing.JMenuItem mitNeu;
    private javax.swing.JMenuItem mitOeffne;
    private javax.swing.JMenuItem mitOpenLevelProps;
    private javax.swing.JMenuItem mitOpenProps;
    private javax.swing.JMenuItem mitSave;
    private javax.swing.JPanel pnEditor;
    private javax.swing.JRadioButtonMenuItem rbmitAdd;
    private javax.swing.JRadioButtonMenuItem rbmitBlock;
    private javax.swing.JRadioButtonMenuItem rbmitDel;
    private javax.swing.JRadioButtonMenuItem rbmitSelect;
    private javax.swing.JRadioButtonMenuItem rbmitSpieler;
    private javax.swing.JRadioButtonMenuItem rbmitZiel;
    private javax.swing.JPopupMenu rcklMenu;
    private javax.swing.JMenuItem reRender;
    private javax.swing.JPopupMenu.Separator sep1;
    private javax.swing.JPopupMenu.Separator sep2;
    // End of variables declaration//GEN-END:variables

    /**
     * Auf diesem Panel wird gezeichnet.
     */
    class EditorPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            editorobj.Render(g2d);
        }

    }

}
