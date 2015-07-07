/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.View;

import arboles.Clases.ArbolAvl;
import arboles.Clases.DrawBinaryTree;
import arboles.Clases.ListaDobleLigada;
import arboles.Clases.ListaGeneralizada;
import arboles.Clases.NodoDoble;
import arboles.Clases.NodoDobleAvl;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.List;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jhon
 */
public class Default extends javax.swing.JFrame {

    private DrawBinaryTree panelBinary;
    private DrawBinaryTree panelN;
    private DrawBinaryTree panelAVL;
    private JTabbedPane jtab;
    private JButton jButton1;
    private JButton jButton2;

    /**
     * Creates new form Default
     */
    public Default() {
        initComponent();
    }

    private void initComponent() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelBinary = new DrawBinaryTree();
        panelN = new DrawBinaryTree();
        panelAVL = new DrawBinaryTree();
        JPanel frame = new JPanel(null);
        JScrollPane scrollPane = new JScrollPane(panelBinary);
        JScrollPane scrollPane1 = new JScrollPane(panelN);
        JScrollPane scrollPane2 = new JScrollPane(panelAVL);
        jtab = new javax.swing.JTabbedPane();

        panelBinary.setPreferredSize(new Dimension(1000, 1000));
        panelN.setPreferredSize(new Dimension(1000, 1000));
        panelAVL.setPreferredSize(new Dimension(1000, 1000));

        
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) event.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                switch (sourceTabbedPane.getTitleAt(index)) {
                    case "Arbol Binario":
                        if(panelBinary.raizP!=null)
                          panelBinary.paintComponent(panelBinary.getGraphics());
                        break;
                    case "Arbol N-ario":
                         if(panelN.raizN!=null)
                        panelN.paintComponent(panelN.getGraphics());
                        break;
                    case "Arbol AVL":
                         if(panelN.raizA!=null)
                        panelAVL.paintComponent(panelAVL.getGraphics());
                        break;
                    default:
                        break;
                }
            }

          
        };
        
        jtab.addChangeListener(changeListener);

        jButton2.setText("Pruebas");
        jButton2.setBounds(530, 50, 150, 20);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtab.add("Arbol Binario", scrollPane);
        jtab.add("Arbol N-ario", scrollPane1);
        jtab.add("Arbol AVL", scrollPane2);

        jtab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        jtab.setBounds(20, 20, 400, 400);

        frame.setPreferredSize(new Dimension(700, 500));
        frame.add(jtab);
        frame.add(jButton1);
        frame.add(jButton2);
        frame.setVisible(true);
        setContentPane(frame);

        pack();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
  // TODO add your handling code here:
        //String cadena = "(a(b(e(f(o)),g),c,d(h,i(l,m(n(x,z))),j,k)))";
        String cadena = "(a(b(d,g,h),e(z,x,u),c(f(j))))";
       // String cadena = "(a(b(e,f(x,y)),c(h,i,j,k),d(p,r,u,v)))";
        //String cadena = "(e(c(b(a),d),f))";
        ListaGeneralizada lg = new ListaGeneralizada();
        lg.construyeLg(cadena);
        ListaDobleLigada ld = new ListaDobleLigada();
        NodoDoble ld1;
        ld1 = ld.convierteNarioABinario(lg.primero);
        ArbolAvl arbol = new ArbolAvl();
        arbol.construyeAvl(ld1);
        panelAVL.DibujarArbolAvl(arbol.raiz, panelAVL.getGraphics());
         panelN.DibujarArbolNario(lg.primero, panelN.getGraphics());
        panelBinary.DibujarArbol(ld1,panelBinary.getGraphics());
        jtab.setSelectedIndex(1);
        jtab.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Default d = new Default();
        d.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
