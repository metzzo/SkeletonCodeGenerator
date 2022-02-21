package SkeletonCodeGenerator;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.io.*;


/*
 * Alles was man sieht.
 *
 * Created on 01.10.2010, 08:45:33
 */

/**
 *
 * @author Coolo
 */
public class GUIInterface extends javax.swing.JFrame {

    /**
     * Standardkonstruktor, initialisiert alles
     */
    public GUIInterface() {
        initComponents();
        chooser=new JFileChooser();
        uml=new UMLGenerator("");
        asso=new AssoInterface();
        asso.open(this);
        asso.F.setVisible(false);
        prop=new Property(this);
        setget=new SetterGetterMenu(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(((int)screenSize.getWidth()-this.getWidth())/2, ((int)screenSize.getHeight()-this.getHeight())/2);


        load();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jMenu9 = new javax.swing.JMenu();
        jCheckBoxMenuItem9 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem10 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem11 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem12 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem13 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem14 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem15 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem16 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem18 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar4.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar4.add(jMenu7);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu9.setText("Options");

        jCheckBoxMenuItem9.setSelected(true);
        jCheckBoxMenuItem9.setText("Generate Setter/Getter");
        jCheckBoxMenuItem9.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jCheckBoxMenuItem9AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        jMenu9.add(jCheckBoxMenuItem9);

        jCheckBoxMenuItem10.setSelected(true);
        jCheckBoxMenuItem10.setText("Generate Attributes");
        jMenu9.add(jCheckBoxMenuItem10);

        jCheckBoxMenuItem11.setSelected(true);
        jCheckBoxMenuItem11.setText("Generate Constructors");
        jMenu9.add(jCheckBoxMenuItem11);

        jCheckBoxMenuItem12.setSelected(true);
        jCheckBoxMenuItem12.setText("Generate Methods");
        jMenu9.add(jCheckBoxMenuItem12);

        jCheckBoxMenuItem13.setSelected(true);
        jCheckBoxMenuItem13.setText("Generate ToString");
        jMenu9.add(jCheckBoxMenuItem13);

        jCheckBoxMenuItem14.setSelected(true);
        jCheckBoxMenuItem14.setText("Generate Comments");
        jMenu9.add(jCheckBoxMenuItem14);

        jCheckBoxMenuItem15.setSelected(true);
        jCheckBoxMenuItem15.setText("Generate Generics");
        jMenu9.add(jCheckBoxMenuItem15);

        jCheckBoxMenuItem16.setSelected(true);
        jCheckBoxMenuItem16.setText("Autoupdate Java");
        jMenu9.add(jCheckBoxMenuItem16);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Skeleton-Code-Generator by Robert Fischer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("UML Code:");

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 12));
        jTextArea2.setRows(5);
        jTextArea2.setTabSize(4);
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.setTabSize(4);

        jLabel2.setText("Output:");

        jTextArea1.setDocument(new UMLHighlighter());
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea3.setDocument(new UMLHighlighter());
        jTextArea3.setEditable(false);
        jTextArea3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea3KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jLabel3.setText("Autogenerated UML Code:");

        jButton1.setText("Update Output");
        jButton1.setEnabled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jMenu4.setText("File");

        jMenuItem1.setText("Save UML");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuItem1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jMenuItem1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem8.setText("Save UML As");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem8MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem2.setText("Load UML");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem22.setText("New UML");
        jMenuItem22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem22MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem22MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem22);
        jMenu4.add(jSeparator1);

        jMenuItem4.setText("Save Java");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Save Java As");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem5MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem5);
        jMenu4.add(jSeparator2);

        jMenuItem7.setText("View association");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem7MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem6.setText("Check for Errors");
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem6MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem6);
        jMenu4.add(jSeparator3);

        jMenuItem3.setText("About");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar2.add(jMenu4);

        jMenu8.setText("Options");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Generate setter/getter");
        jCheckBoxMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem1MouseReleased(evt);
            }
        });
        jCheckBoxMenuItem1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jCheckBoxMenuItem1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenu8.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Generate attributes");
        jCheckBoxMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem2MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("Generate constructors");
        jCheckBoxMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem4MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem4);

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Generate methods");
        jCheckBoxMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem3MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem3);

        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("Generate toString");
        jCheckBoxMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem5MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem5);

        jCheckBoxMenuItem18.setText("Generate equals/hashCode");
        jCheckBoxMenuItem18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem18MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem18MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem18);

        jCheckBoxMenuItem6.setSelected(true);
        jCheckBoxMenuItem6.setText("Generate javadoc");
        jCheckBoxMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem6MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem6);

        jCheckBoxMenuItem7.setText("Generate generics");
        jCheckBoxMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem7MouseReleased(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem7);

        jCheckBoxMenuItem8.setSelected(true);
        jCheckBoxMenuItem8.setText("Autoupdate");
        jCheckBoxMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem8MousePressed(evt);
            }
        });
        jMenu8.add(jCheckBoxMenuItem8);

        jMenuBar2.add(jMenu8);

        jMenu11.setText("Settings");

        jMenuItem19.setText("Class settings");
        jMenuItem19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem19MousePressed(evt);
            }
        });
        jMenu11.add(jMenuItem19);

        jMenuItem20.setText("Setter/Getter settings");
        jMenuItem20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem20MousePressed(evt);
            }
        });
        jMenu11.add(jMenuItem20);

        jMenuBar2.add(jMenu11);

        jMenu10.setText("Help");

        jMenuItem18.setText("Class");
        jMenuItem18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem18MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem18);

        jMenuItem11.setText("Methods");
        jMenuItem11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem11MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenuItem12.setText("Attributes");
        jMenuItem12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem12MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem12);

        jMenuItem10.setText("Constructors");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem10MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem10);

        jMenuItem13.setText("Arrays");
        jMenuItem13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem13MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem9.setText("Information hiding");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem9MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem9);

        jMenuItem17.setText("Comments");
        jMenuItem17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem17MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem17);

        jMenuItem14.setText("Associations");
        jMenuItem14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem14MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem14);

        jMenuItem16.setText("Static members");
        jMenuItem16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem16MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem16);

        jMenuItem15.setText("Generics");
        jMenuItem15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem15MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem15);

        jMenuItem21.setText("Open class");
        jMenuItem21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem21MousePressed(evt);
            }
        });
        jMenu10.add(jMenuItem21);

        jMenuBar2.add(jMenu10);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked

    }//GEN-LAST:event_jMenuItem2MouseClicked
    /**
     * UML Laden Dialog
     * @param evt
     */
    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new UMLFilter());
        if (umlpath != null) 
            chooser.setSelectedFile(umlpath);
        else
            chooser.setSelectedFile(new File(uml.getClassName()));
        int res=chooser.showOpenDialog(GUIInterface.this);
        
        if (res==JFileChooser.APPROVE_OPTION) {
            umlpath=chooser.getSelectedFile();
            FileReader filereader;

            try {
              filereader=new FileReader(umlpath);
              
              uml=new UMLGenerator(filereader);
              jTextArea1.setText(uml.getInput());
            } catch(FileNotFoundException fr) {
                System.err.println("Error!");
            } catch (IOException fr) {
                System.err.println("Error!");
            }
            getUML();
        }
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem2MousePressed
    /**
     * UML speichenr
     * @param evt
     */
    private void jMenuItem8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MousePressed
        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new UMLFilter());
        if (umlpath != null) 
            chooser.setSelectedFile(umlpath);
        else
            chooser.setSelectedFile(new File(uml.getClassName()));
        int res=chooser.showSaveDialog(GUIInterface.this);
        if (res==JFileChooser.APPROVE_OPTION) {
            umlpath=chooser.getSelectedFile();
            try {
                String path = "";
                path = umlpath.getAbsolutePath();
                //System.out.println(path.substring(path.length()-4));
                if (!path.substring(path.length()-4).equals(".uml")) {
                    path += ".uml";
                }
                FileWriter file=new FileWriter(path);
                file.write(uml.getRealUML());
                file.close();
                file=null;
            } catch(FileNotFoundException fr) {
                System.err.println("Error!");
            } catch (IOException fr) {
                System.err.println("Error!");
            }
        }
        getUML();
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem8MousePressed
    /**
     * Uml Speichern Unter
     * @param evt
     */
    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        if (umlpath==null) {
            chooser = new JFileChooser();
            if (umlpath != null) 
                chooser.setSelectedFile(umlpath);
            else
                chooser.setSelectedFile(new File(uml.getClassName()));
            chooser.addChoosableFileFilter(new UMLFilter());
            int res=chooser.showSaveDialog(GUIInterface.this);
            if (res==JFileChooser.APPROVE_OPTION) {
                umlpath=chooser.getSelectedFile();
            }
        }
        if (umlpath!=null) {
            try {
                String path = "";
                path = umlpath.getAbsolutePath();
                //System.out.println(path.substring(path.length()-4));
                if (!path.substring(path.length()-4).equals(".uml")) {
                    path += ".uml";
                }
                FileWriter file=new FileWriter(path);
                file.write(uml.getRealUML());
                file.close();
                file=null;
            } catch(FileNotFoundException fr) {
                System.err.println("Error!");
            } catch (IOException fr) {
                System.err.println("Error!");
            }
        }
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem1MousePressed
    /**
     * Java Speichern
     * @param evt
     */
    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        if (javaPath==null) {
            chooser = new JFileChooser();
            if (javaPath != null) 
                chooser.setSelectedFile(javaPath);
            else
                chooser.setSelectedFile(new File(uml.getClassName()));
            
            chooser.addChoosableFileFilter(new JavaFilter());
            int res=chooser.showSaveDialog(GUIInterface.this);
            if (res==JFileChooser.APPROVE_OPTION) {
                javaPath=chooser.getSelectedFile();
            }
        }
        if (javaPath!=null) {
            compiler();
            try {
                getUML();
                if (compiler()) {
                    String path = "";
                    path = javaPath.getAbsolutePath();
                    //System.out.println(path.substring(path.length()-4));
                    if (!path.substring(path.length()-5).equals(".java")) {
                        path += ".java";
                    }
                    FileWriter file=new FileWriter(path);
                    file.write(uml.getCode());
                    file.close();
                    file=null;
                }
            } catch(FileNotFoundException fr) {
                System.err.println("Error!");
            } catch (IOException fr) {
                System.err.println("Error!");
            }
        }
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem4MousePressed
    /**
     * Syntax Error?
     * @param evt
     */
    private void jMenuItem6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MousePressed
        if (compiler(false)) jTextArea2.setText("There is no syntax error.");
    }//GEN-LAST:event_jMenuItem6MousePressed
    /**
     * Java Speichern unter
     * @param evt
     */
    private void jMenuItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MousePressed
        chooser = new JFileChooser();
        if (javaPath != null) 
            chooser.setSelectedFile(javaPath);
        else
            chooser.setSelectedFile(new File(uml.getClassName()));
        chooser.addChoosableFileFilter(new JavaFilter());
        int res=chooser.showSaveDialog(GUIInterface.this);
        if (res==JFileChooser.APPROVE_OPTION) {
            javaPath=chooser.getSelectedFile();
        }
        if (javaPath!=null) {
            compiler();
            try {
                getUML();
                if (compiler()) {
                    String path = "";
                    path = javaPath.getAbsolutePath();
                    //System.out.println(path.substring(path.length()-4));
                    if (!path.substring(path.length()-5).equals(".java")) {
                        path += ".java";
                    }
                    FileWriter file=new FileWriter(path);
                    file.write(uml.getCode());
                    file.close();
                    file=null;
                }
            } catch(FileNotFoundException fr) {
                System.err.println("Error!");
            } catch (IOException fr) {
                System.err.println("Error!");
            }
        }
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem5MousePressed

    private void jCheckBoxMenuItem1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1AncestorMoved
    }//GEN-LAST:event_jCheckBoxMenuItem1AncestorMoved

    private void jMenuItem1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuItem1AncestorMoved
    }//GEN-LAST:event_jMenuItem1AncestorMoved
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        new About().setVisible(true);
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem3MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem9AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem9AncestorMoved
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem9AncestorMoved
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem8MouseClicked
        if (!jCheckBoxMenuItem8.isSelected()) {
            
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem8MouseClicked

    private void jMenuItem7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MousePressed
        asso.F.setVisible(true);
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jMenuItem7MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MousePressed
        new Help(Help.HELP_INFORMATIONHIDING).setVisible(true);
    }//GEN-LAST:event_jMenuItem9MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem10MousePressed
        new Help(Help.HELP_CONSTRUCTORS).setVisible(true);
    }//GEN-LAST:event_jMenuItem10MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem11MousePressed
        new Help(Help.HELP_METHODS).setVisible(true);
    }//GEN-LAST:event_jMenuItem11MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem12MousePressed
        new Help(Help.HELP_ATTRIBUTES).setVisible(true);
    }//GEN-LAST:event_jMenuItem12MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem13MousePressed
        new Help(Help.HELP_ARRAYS).setVisible(true);
    }//GEN-LAST:event_jMenuItem13MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem14MousePressed
        new Help(Help.HELP_ASSOCIATIONS).setVisible(true);
    }//GEN-LAST:event_jMenuItem14MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem15MousePressed
        new Help(Help.HELP_GENERICS).setVisible(true);
    }//GEN-LAST:event_jMenuItem15MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem16MousePressed
        new Help(Help.HELP_STATICS).setVisible(true);
    }//GEN-LAST:event_jMenuItem16MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem17MousePressed
        new Help(Help.HELP_COMMENTS).setVisible(true);
    }//GEN-LAST:event_jMenuItem17MousePressed
    /**
     * Help Menüpunkt
     * @param evt
     */
    private void jMenuItem18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem18MousePressed
        new Help(Help.HELP_CLASS).setVisible(true);
    }//GEN-LAST:event_jMenuItem18MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1MousePressed
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem1MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2MousePressed
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem2MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4MousePressed
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem4MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3MousePressed
        if (jCheckBoxMenuItem8.isSelected())  compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem3MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem5MousePressed
        if (jCheckBoxMenuItem8.isSelected())  compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem5MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem6MousePressed
       if (jCheckBoxMenuItem8.isSelected())   compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem6MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem7MousePressed
        if (jCheckBoxMenuItem8.isSelected())  compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem7MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem8MousePressed
         this.jCheckBoxMenuItem8MouseClicked(evt);
    }//GEN-LAST:event_jCheckBoxMenuItem8MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1MouseClicked
        if (jCheckBoxMenuItem8.isSelected()) compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem1MouseClicked
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jMenuItem19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem19MousePressed
        prop.setVisible(true);
    }//GEN-LAST:event_jMenuItem19MousePressed
    /**
     * Setter/Getter Settings
     * @param evt
     */
    private void jMenuItem20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem20MousePressed
        setget.refresh(uml.getAllAttributes());
        setget.setVisible(true);
    }//GEN-LAST:event_jMenuItem20MousePressed
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        if (jCheckBoxMenuItem8.isSelected()) compiler();
}//GEN-LAST:event_jTextArea1KeyTyped
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        if (jCheckBoxMenuItem8.isSelected()) compiler();
}//GEN-LAST:event_jTextArea1KeyReleased
    /**
     * Wenn Klick, neukompilieren
     * @param evt
     */
    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        //versuche neu zu kompilieren, nur wenn aktiviert
        if (jCheckBoxMenuItem8.isSelected()) compiler();
}//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyPressed
    }//GEN-LAST:event_jTextArea3KeyPressed

    private void jTextArea3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyReleased
    }//GEN-LAST:event_jTextArea3KeyReleased

    private void jTextArea3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyTyped
    }//GEN-LAST:event_jTextArea3KeyTyped

    private void jCheckBoxMenuItem18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem18MousePressed
        
    }//GEN-LAST:event_jCheckBoxMenuItem18MousePressed
    /**
     * Hilfe
     * @param evt
     */
    private void jMenuItem21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem21MousePressed
        new Help(Help.HELP_OPENCLASS).setVisible(true);
    }//GEN-LAST:event_jMenuItem21MousePressed
    /**
     * Fensterposition speichern
     * @param evt
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        save();
    }//GEN-LAST:event_formWindowClosed
    /**
     * Fenster Position speichern
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        save();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased

    }//GEN-LAST:event_jButton1MouseReleased
    /**
     * Output Updaten
     * @param evt
     */
    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jCheckBoxMenuItem8.setSelected(true);
        compiler();
        jCheckBoxMenuItem8.setSelected(false);
    }//GEN-LAST:event_jButton1MousePressed

    private void jMenuItem22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem22MouseClicked

    }//GEN-LAST:event_jMenuItem22MouseClicked
    /**
     * Neu
     * @param evt
     */
    private void jMenuItem22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem22MousePressed
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        javaPath = null;
        umlpath = null;
        compiler();
    }//GEN-LAST:event_jMenuItem22MousePressed
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem18MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem18MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem6MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem6MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem7MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem7MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem5MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem5MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem3MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem4MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem2MouseReleased
    /**
     * Kompilieren
     * @param evt
     */
    private void jCheckBoxMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1MouseReleased
        compiler();
    }//GEN-LAST:event_jCheckBoxMenuItem1MouseReleased
    /**
     * Speichert die Fensterposition
     */
    private void save() {
        try {
            //System.out.println("save");
            DataOutputStream file=new DataOutputStream(new FileOutputStream("config.txt"));

            file.writeInt((int)this.getX());
            //System.out.println("x: "+this.getX());
            file.writeInt((int)this.getY());
            file.writeInt((int)this.getWidth());
            file.writeInt((int)this.getHeight());
            file.writeInt((int)asso.F.getX());
            file.writeInt((int)asso.F.getY());
            file.writeInt((int)asso.F.getWidth());
            file.writeInt((int)asso.F.getHeight());
            file.writeInt((int)prop.getX());
            file.writeInt((int)prop.getY());
            file.writeInt((int)prop.getWidth());
            file.writeInt((int)prop.getHeight());
            file.writeInt((int)setget.getX());
            file.writeInt((int)setget.getY());
            file.writeInt((int)setget.getWidth());
            file.writeInt((int)setget.getHeight());
            file.close();
            file=null;
            //System.out.println("finish");
        } catch(FileNotFoundException fr) {
            System.err.println("Error!");
        } catch (IOException fr) {
            System.err.println("Error "+fr.toString());
        }
    }
    /**
     * Lädt die Fensterposition
     */
    private void load() {
        try {
            //DataInputStream file=new DataInputStream(new FileInputStream("config.txt"));
            //System.out.println("load");
            DataInputStream file=new DataInputStream(new FileInputStream("config.txt"));
            int x,y,w,h;
            x=file.readInt();
            y=file.readInt();
            w=file.readInt();
            h=file.readInt();
            //System.out.println("x: "+x+" y: "+y+" w: "+w+" h: "+h);
            this.setLocation(x, y);
            this.setSize(w, h);
            x=file.readInt();
            y=file.readInt();
            w=file.readInt();
            h=file.readInt();
            this.asso.F.setLocation(x, y);
            this.asso.F.setSize(w, h);
            x=file.readInt();
            y=file.readInt();
            w=file.readInt();
            h=file.readInt();
            this.prop.setLocation(x, y);
            this.prop.setSize(w, h);
            x=file.readInt();
            y=file.readInt();
            w=file.readInt();
            h=file.readInt();
            this.setget.setLocation(x, y);
            this.setget.setSize(w, h);
            file.close();
            file=null;
        } catch(FileNotFoundException fr) {
            System.err.println("Error! not found");
        } catch (IOException fr) {
            System.err.println("Error!"+fr.toString());
        }
    }
    /**
     * Main Methode
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem10;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem11;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem12;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem13;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem14;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem15;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem16;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem18;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextPane jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane jTextArea3;
    // End of variables declaration//GEN-END:variables
    private JFileChooser chooser;
    private File javaPath, umlpath;
    private UMLGenerator uml;
    private AssoInterface asso;
    private Property prop;
    private SetterGetterMenu setget;
    private String currentpath="";
    /**
     * Der input UML Code
     * @return
     */
    public UMLGenerator getUMLGen() {
        return uml;
    }
    /**
     * Der UML Code, updatet jTextArea1
     * @return
     */
    private String getUML() {
        uml.setUML(this.jTextArea1.getText());
        return this.jTextArea1.getText();
    }
    /**
     * Kompiliert
     * @return
     */
    public boolean compiler() {
        return compiler(true);
    }
    /**
     * Kompiliert
     * @param test Ist es ein Syntaxcheck?
     * @return
     */
    private boolean compiler(boolean test) {
        Cursor c=this.jTextArea2.getCursor();
        uml=new UMLGenerator(getUML());
        uml.setProperty(prop.getAuthor(), prop.getVersion(), prop.getDesc());
        if (jCheckBoxMenuItem1.isSelected()) uml.genSetter();
        if (jCheckBoxMenuItem4.isSelected()) uml.genConstructors();
        if (jCheckBoxMenuItem2.isSelected()) uml.genAttributes();
        if (jCheckBoxMenuItem3.isSelected()) uml.genMethods();
        if (jCheckBoxMenuItem5.isSelected()) uml.genToString();
        if (jCheckBoxMenuItem6.isSelected()) uml.genComments();
        if (jCheckBoxMenuItem7.isSelected()) uml.genGenerics();
        if (jCheckBoxMenuItem18.isSelected()) {
            uml.genEquals();
            uml.genHashCode();
        }
        uml.setBeforeAttributes(setget.getList());
        String error="";
        boolean succ;
        getUML();
        if (uml.compile()) {
            if (test) error=uml.getCode();
            //Nun den umlcode setzen
            if (uml.getAutoUML().length()>0) this.jTextArea3.setText("Generated: \n"+uml.getAutoUML());// else this.jTextArea3.setText("");
            succ=true;
        } else {
            error=uml.getError();
            succ=false;
        }
        jTextArea2.setText(error);
        if (succ) setget.refresh(uml.getAllAttributes());
        //scroll positionen merken

        this.jTextArea2.setCursor(c);
        return succ;
    }
    private void dictup(String path) {
        for (int i=path.length()-1;i>=0;i--) {
            if (path.charAt(i)=='\\') {
                currentpath=path.substring(0,i);
                break;
            }
        }
    }
    public String getDict() {
        dictup(umlpath.getPath());
        return currentpath;
    }
}
