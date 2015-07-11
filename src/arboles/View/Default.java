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
import java.awt.Component;
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
    private JButton btnAltura;
    private JButton btnInsert;
    private JButton btnGrado;
    private JButton btnHojas;
    private JButton btnPadre;
    private JButton btnAncestros;
    private JButton btnTios;
    private JButton btnGradoDato;
    private JButton btnPrimos;
    private JLabel lbl;
    private JTextField textbox;


    public Default() {
        initComponent();
    }

    private void initComponent() {

        btnAltura = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnGrado = new javax.swing.JButton();
        btnAncestros = new javax.swing.JButton();
        btnGradoDato = new javax.swing.JButton();
        btnHojas = new javax.swing.JButton();
        btnPadre = new javax.swing.JButton();
        btnPrimos = new javax.swing.JButton();
        btnTios = new javax.swing.JButton();
        textbox = new JTextField();
        lbl = new JLabel();
        panelBinary = new DrawBinaryTree();
        panelN = new DrawBinaryTree();
        panelAVL = new DrawBinaryTree();
        JPanel frame = new JPanel(null);
        JScrollPane scrollPane = new JScrollPane(panelBinary);
        JScrollPane scrollPane1 = new JScrollPane(panelN);
        JScrollPane scrollPane2 = new JScrollPane(panelAVL);
        jtab = new javax.swing.JTabbedPane();

        panelBinary.setPreferredSize(new Dimension(6000, 6000));
        panelN.setPreferredSize(new Dimension(6000, 6000));
        panelAVL.setPreferredSize(new Dimension(6000, 6000));

        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) event.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                switch (sourceTabbedPane.getTitleAt(index)) {
                    case "Árbol Binario":
                        if (panelBinary.raizP != null) {
                            panelBinary.paintComponent(panelBinary.getGraphics());
                        }
                        break;
                    case "Árbol N-ario":
                        if (panelN.raizN != null) {
                            panelN.paintComponent(panelN.getGraphics());
                        }
                        break;
                    case "Árbol AVL":
                        if (panelN.raizA != null) {
                            panelAVL.paintComponent(panelAVL.getGraphics());
                        }
                        break;
                    default:
                        break;
                }
            }

        };

        jtab.addChangeListener(changeListener);
        lbl.setBounds(560, 30, 400, 20);
        lbl.setText("Ingrese la cadena que representará su árbol");
        textbox.setBounds(530, 60, 400, 25);
        btnInsert.setText("Insertar");
        btnInsert.setBounds(640, 90, 150, 20);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        btnAltura.setText("Altura");
        btnAltura.setBounds(560, 150, 120, 20);
        btnAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlturaActionPerformed(evt);
            }
        });
        btnGrado.setText("Grado");
        btnGrado.setBounds(760, 150, 120, 20);
        btnGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradoActionPerformed(evt);
            }
        });
        btnGradoDato.setText("Grado dato");
        btnGradoDato.setBounds(560, 200, 120, 20);
        btnGradoDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradoDatoActionPerformed(evt);
            }
        });
        
        btnHojas.setText("Hojas");
        btnHojas.setBounds(760, 200, 120, 20);
        btnHojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHojasActionPerformed(evt);
            }
        });
        btnPadre.setText("Padre");
        btnPadre.setBounds(560, 250, 120, 20);
        btnPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadreActionPerformed(evt);
            }
        });
        btnPrimos.setText("Primos");
        btnPrimos.setBounds(760, 250, 120, 20);
        btnPrimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimoActionPerformed(evt);
            }
        });
        btnTios.setText("Tíos");
        btnTios.setBounds(560, 300, 120, 20);
        btnTios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTioActionPerformed(evt);
            }
        });
        btnAncestros.setText("Ancestros");
        btnAncestros.setBounds(760, 300, 120, 20);
        btnAncestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAncestroActionPerformed(evt);
            }
        });
        jtab.add("Árbol Binario", scrollPane);
        jtab.add("Árbol N-ario", scrollPane1);
        jtab.add("Árbol AVL", scrollPane2);

        jtab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        jtab.setBounds(20, 20, 500, 500);
        
        SetStatusButton(false);
        
        frame.setPreferredSize(new Dimension(950, 550));
        frame.add(lbl);
        frame.add(jtab);
        frame.add(btnGradoDato);
        frame.add(btnHojas);
        frame.add(btnPadre);
        frame.add(btnPrimos);
        frame.add(btnGrado);
        frame.add(btnTios);
        frame.add(btnAncestros);
        frame.add(btnAltura);
        frame.add(btnInsert);
        frame.add(textbox);
        frame.setVisible(true);
        setContentPane(frame);
        setResizable(false);
        setTitle("Graficador de árboles");
        pack();
    }

    private void SetStatusButton(boolean status)
    {
            
        btnAltura.setEnabled(status);
        btnAncestros.setEnabled(status);
        btnGrado.setEnabled(status);
        btnGradoDato.setEnabled(status);
        btnHojas.setEnabled(status);
        btnPadre.setEnabled(status);
        btnPrimos.setEnabled(status);
        btnTios.setEnabled(status);

    
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        String cadena = textbox.getText();
        ListaGeneralizada lg = new ListaGeneralizada();
        lg.construyeLg(cadena);
        ListaDobleLigada ld = new ListaDobleLigada();
        NodoDoble ld1;
        ld1 = ld.convierteNarioABinario(lg.primero);
        ArbolAvl arbol = new ArbolAvl();
        if(ld1==null)
        {
           arbol.raiz=null;
        }
        else
        arbol.construyeAvl(ld1);
        
        panelAVL.DibujarArbolAvl(arbol.raiz, panelAVL.getGraphics());
        panelN.DibujarArbolNario(lg.primero, panelN.getGraphics());
        panelBinary.DibujarArbol(ld1, panelBinary.getGraphics());
        jtab.setSelectedIndex(1);
        jtab.setSelectedIndex(0);
        SetStatusButton(true);

    }
    
     private void btnAlturaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         
         ListaDobleLigada ld = new ListaDobleLigada();
if(panelBinary.raizP==null)         
{
     JOptionPane.showMessageDialog((Component)evt.getSource(),"La altura del árbol vacío es 0","Altura",JOptionPane.INFORMATION_MESSAGE);
     return;
}
         int altura = ld.Altura(panelBinary.raizP);
         String msg = "La altura del árbol es : "+ altura; 
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Altura",JOptionPane.INFORMATION_MESSAGE);
      
    }
     private void btnGradoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         if(panelBinary.raizP==null)         
{
     JOptionPane.showMessageDialog((Component)evt.getSource(),"El grado del árbol vacío es 0","Altura",JOptionPane.INFORMATION_MESSAGE);
     return;
}
         ListaDobleLigada ld = new ListaDobleLigada();
         int grado = ld.gradoArbol(panelBinary.raizP);
         String msg = "El grado del árbol es : " + grado; 
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Grado",JOptionPane.INFORMATION_MESSAGE);
      
    }
     
        private void btnGradoDatoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
            if(panelBinary.raizP==null)         
{
     JOptionPane.showMessageDialog((Component)evt.getSource(),"El grado del árbol vacío es 0","Altura",JOptionPane.INFORMATION_MESSAGE);
     return;
}
         String input = JOptionPane.showInputDialog("Ingrese el dato: ");
         if(input.isEmpty())
         {
               JOptionPane.showMessageDialog((Component)evt.getSource(),"Ingrese un dato","Grado",JOptionPane.INFORMATION_MESSAGE);
               return;
         }
         ListaDobleLigada ld = new ListaDobleLigada();
         int grado = ld.GradoDato(input,panelBinary.raizP);
         if(grado==-1)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato no se encuentra en el árbol","Grado",JOptionPane.ERROR_MESSAGE);
               return;
         }
         String msg = "El grado del dato "+ input + " es: "+ grado; 
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Grado",JOptionPane.INFORMATION_MESSAGE);
      
    }
        
     private void btnHojasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         if(panelBinary.raizP==null)         
{
     JOptionPane.showMessageDialog((Component)evt.getSource(),"El número de hojas del árbol vacío es 0","Altura",JOptionPane.INFORMATION_MESSAGE);
     return;
}
        ListaDobleLigada ld = new ListaDobleLigada();
         int hojas = ld.hojas(panelBinary.raizP);
         String msg = "El número de hojas del arbol es: "+ hojas; 
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Hojas",JOptionPane.INFORMATION_MESSAGE);
      
    }
     
      private void btnPadreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         String input = JOptionPane.showInputDialog("Ingrese el dato: ");
         if(input.isEmpty())
         {
               JOptionPane.showMessageDialog((Component)evt.getSource(),"Ingrese un dato","Padre",JOptionPane.INFORMATION_MESSAGE);
               return;
         }
         ListaDobleLigada ld = new ListaDobleLigada();
         if(panelBinary.raizP==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"Árbol vacío","Padre",JOptionPane.ERROR_MESSAGE);
               return;
         }
         if(input.equals(panelBinary.raizP.retornaDato().toString()))
         {
              JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato raíz no tiene padre","Padre",JOptionPane.ERROR_MESSAGE);
               return;
         }
         NodoDoble padre = ld.GetPadre(input,panelBinary.raizP);
         if(padre==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato no se encuentra en el árbol","Padre",JOptionPane.ERROR_MESSAGE);
               return;
         }
         String msg = "El padre del dato "+ input + " es: "+ padre.retornaDato().toString(); 
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Padre",JOptionPane.INFORMATION_MESSAGE);
      
    }
      
      private void btnTioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         String input = JOptionPane.showInputDialog("Ingrese el dato: ");
         if(input.isEmpty())
         {
               JOptionPane.showMessageDialog((Component)evt.getSource(),"Ingrese un dato","Tío",JOptionPane.INFORMATION_MESSAGE);
               return;
         }
         ListaDobleLigada ld = new ListaDobleLigada();
         if(panelBinary.raizP==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"Árbol vacío","Tío",JOptionPane.ERROR_MESSAGE);
               return;
         }
         if(input.equals(panelBinary.raizP.retornaDato().toString()))
         {
              JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato raíz no tiene tíos","Tío",JOptionPane.ERROR_MESSAGE);
               return;
         }
         List<NodoDoble> tios = ld.GetTios(input,panelBinary.raizP);
         if(tios ==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato no se encuentra en el árbol o no tiene tíos","Tío",JOptionPane.ERROR_MESSAGE);
               return;
         }
         String msg = "Los tíos del dato "+ input + " son: \n"; 
          for (int i = 0; i < tios.size(); i++) {
              msg+= tios.get(i).retornaDato().toString() +"\n";
              
          }
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Tío",JOptionPane.INFORMATION_MESSAGE);
      
    }
      
       private void btnPrimoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         String input = JOptionPane.showInputDialog("Ingrese el dato: ");
         if(input.isEmpty())
         {
               JOptionPane.showMessageDialog((Component)evt.getSource(),"Ingrese un dato","Primo",JOptionPane.INFORMATION_MESSAGE);
               return;
         }
         ListaDobleLigada ld = new ListaDobleLigada();
         if(panelBinary.raizP==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"Árbol vacío","Primo",JOptionPane.ERROR_MESSAGE);
               return;
         }
         if(input.equals(panelBinary.raizP.retornaDato().toString()))
         {
              JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato raíz no tiene primos","Primo",JOptionPane.ERROR_MESSAGE);
               return;
         }
         List<NodoDoble> primos = ld.GetPrimos(input,panelBinary.raizP);
         if(primos ==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato no se encuentra en el árbol o no tiene primos","Primo",JOptionPane.ERROR_MESSAGE);
               return;
         }
         String msg = "Los primos del dato "+ input + " son: \n "; 
          for (int i = 0; i < primos.size(); i++) {
              msg+= primos.get(i).retornaDato().toString() +"\n";
              
          }
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Primo",JOptionPane.INFORMATION_MESSAGE);
      
    }
       
         private void btnAncestroActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         String input = JOptionPane.showInputDialog("Ingrese el dato: ");
         if(input.isEmpty())
         {
               JOptionPane.showMessageDialog((Component)evt.getSource(),"Ingrese un dato","Ancestro",JOptionPane.INFORMATION_MESSAGE);
               return;
         }
         ListaDobleLigada ld = new ListaDobleLigada();
         if(panelBinary.raizP==null)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"Árbol vacío","Ancestro",JOptionPane.ERROR_MESSAGE);
               return;
         }
         if(input.equals(panelBinary.raizP.retornaDato().toString()))
         {
              JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato raíz no tiene ancestro","Ancestro",JOptionPane.ERROR_MESSAGE);
               return;
         }
         List<NodoDoble> ancestros = ld.GetAncestros(input,panelBinary.raizP);
         if(ancestros.size()==0)
         {
             JOptionPane.showMessageDialog((Component)evt.getSource(),"El dato no se encuentra en el árbol","Ancestro",JOptionPane.ERROR_MESSAGE);
               return;
         }
         String msg = "Los ancestros del dato "+ input + " son: \n"; 
          for (int i = 0; i < ancestros.size(); i++) {
              msg+= ancestros.get(i).retornaDato().toString() +"\n";
              
          }
         JOptionPane.showMessageDialog((Component)evt.getSource(),msg,"Ancestro",JOptionPane.INFORMATION_MESSAGE);
      
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
