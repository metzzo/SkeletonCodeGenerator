package SkeletonCodeGenerator;

/*
 * Setter/Getter bearbeiten (welche werden generiert,...)
 *
 * Created on 19.11.2010, 09:05:36
 */
import java.util.*;
/**
 * Das Setter Getter Menü
 * @author Coolo
 */
public class SetterGetterMenu extends javax.swing.JFrame {
    private static String[] attributes;
    private GUIInterface inter;
    private boolean norefresh=false;
    /**
     * Konstruktor
     * @param i das zugehörige Interface
     */
    public SetterGetterMenu(GUIInterface i) {
        initComponents();
        inter=i;
    }
    /**
     * Updatet das Interface mit den neuen Daten
     * @param list
     */
    public void refresh(LinkedList<UMLAttribute> list) {
        if (norefresh) return;
        this.list=list;
        attributes=new String[list.size()];
        int i=0;
        for (UMLAttribute att:list) {
            attributes[i]=att.getName();
            i++;
        }
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings=SetterGetterMenu.attributes;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        if (attributes.length>0) selectMenu=attributes[0];
        update();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Setter/Getter Editor");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jCheckBox1.setText("Generate setter");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBox1MousePressed(evt);
            }
        });

        jCheckBox2.setText("Generate getter");
        jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBox2MousePressed(evt);
            }
        });

        jLabel3.setText("Name:");

        jLabel4.setText("Datatype:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Wenn auf die Liste gedrückt wird, update
     * @param evt
     */
    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
         selectMenu=(String)jList1.getSelectedValue();
        if (selectMenu!=null) {
            update();
        } else {
            if (attributes.length>0) selectMenu=attributes[0];
        }
    }//GEN-LAST:event_jList1MousePressed
    /**
     * Setter generieren?
     * @param evt
     */
    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        //System.out.println("Clicked: "+selectMenu);
        UMLAttribute att=getByName(selectMenu);
        if (att!=null) att.setGensetter(jCheckBox1.isSelected());
        norefresh=true;
        inter.compiler();
        inter.getUMLGen().setBeforeAttributes(list);
        norefresh=false;
    }//GEN-LAST:event_jCheckBox1MouseClicked
    /**
     * Getter generieren?
     * @param evt
     */
    private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseClicked
        UMLAttribute att=getByName(selectMenu);
        if (att!=null) att.setGengetter(jCheckBox2.isSelected());
        norefresh=true;
        inter.compiler();
        inter.getUMLGen().setBeforeAttributes(list);
        norefresh=false;
    }//GEN-LAST:event_jCheckBox2MouseClicked
   
    private void jCheckBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MousePressed
        jCheckBox1MouseClicked(evt);
    }//GEN-LAST:event_jCheckBox1MousePressed

    private void jCheckBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MousePressed
        jCheckBox2MouseClicked(evt);
    }//GEN-LAST:event_jCheckBox2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private LinkedList<UMLAttribute> list;
    private String selectMenu;
    /**
     * Liefert ein Attribut anhand des Namens
     * @param name
     * @return
     */
    private UMLAttribute getByName(String name) {
        for (UMLAttribute att:list) {
            //System.out.println("Name: "+att.getName()+" Search: "+name);
            if (att.getName().equals(name)) {
                return att;
            }
        }
        return null;
    }
    /**
     * Updatet alles
     */
    private void update() {
        UMLAttribute att=getByName(selectMenu);
        if (att!=null) {
            jLabel1.setText(att.getName());
            jLabel2.setText(att.getDatatype());
            jCheckBox1.setSelected(att.isGensetter());
            jCheckBox2.setSelected(att.isGengetter());
        }
    }
    /**
     * Die Liste mit UMLAttributes
     * @return
     */
    public LinkedList<UMLAttribute> getList() {
        return list;
    }
}
