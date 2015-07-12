/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jhon
 */
public class DrawBinaryTree extends JPanel {

    public NodoDoble raizP; //raiz del árbol binario
    public NodoLg raizN; //raíz del árbol n-ario
    public NodoDobleAvl raizA; //raíz del árbol avl

    public DrawBinaryTree() {
       
        setBackground(Color.white); //para modificar el fondo Jpanel
        setLocation(10, 10); //Se establece la posicion del panel

    }


    //Método que dibuja un árbol N-ario representado como lista generalizada
    public void DibujarArbolNario(NodoLg raiz, Graphics g) {

        raizN = raiz;// se almacena la raiz del arbol N-ario para dibujarlo en cada repaint del panel
          if(raizN==null)
        {
            return;
        }
        int p = recorrerArbolNario(raiz.retornaLiga(), 1, 2, g);//llama al método que establece la posición de cada nodo y retorna la maxima posicion establecida 
        
        int posr = (p + 1) / 2; //posición de la raíz
        PintarNodo(posr, raiz, 1, g);//pinta el nodo raiz 
        if(raiz.retornaLiga()==null)
        {
            return;
        }
        recorrerNodosLineasN(raizN, g, raizN);//recorre los nodos y los une con su padre correspondiente por medio de una linea

    }

    //Método Recursivo que establece la posición de cada nodo
    private int recorrerArbolNario(NodoLg r, int pos, int alt, Graphics g) {
        NodoLg p = null;
        int q = 0;
        NodoLg x = null;
        if (r == null) {
            return pos;
        }
        p = r;
        while (p != null) {

            if (p.retornaSw() == 0) {
                pos++;
                if (p.retornaLiga() != null) {
                    q = recorrerArbolNario(p.retornaLiga(), pos, alt, g);
                    if (p != raizN) {
                        PintarNodo(pos, p, alt, g);
                    }
                    return q;
                } else {
                    PintarNodo(pos, p, alt, g);
                    return pos;

                }
            }
            if (p.retornaSw() == 1) {
                x = (NodoLg) p.retornaDato();
                int alttemp = alt + 1;
                q = recorrerArbolNario(x.retornaLiga(), pos, alttemp, g);
                int posroot = (q + pos+1) / 2;
                PintarNodo(posroot, x, alt, g);
                if (q > pos) {
                    pos = q;
                }
            }
            p = p.retornaLiga();

        }
        return pos;

    }

    //Metodo recursivo que dibuja las lineas que unen a los nodos hijos con sus padres
    private void recorrerNodosLineasN(NodoLg r, Graphics g, NodoLg padre) {
        
        NodoLg p = null;
        int q = 0;
        NodoLg x = null;
        if (r == null ) { // si el nodo es nulo se termina el metodo
            return;
        }
        p = r;
        while (p != null) {

            if (p.retornaSw() == 0) {// si tiene hermanos o hijos sigue el proceso

                if (p.retornaLiga() != null) {
                    recorrerNodosLineasN(p.retornaLiga(), g, padre);
                    if (p != raizN) {
                        PintarLineas(padre, p, g, Color.BLUE);//pinta la lina desde el nodo actual hacia su padre
                    }
                    return;
                } else {
                    PintarLineas(padre, p, g, Color.BLUE);//pinta la lina desde el nodo actual hacia su padre

                    return;

                }
            }
            if (p.retornaSw() == 1) {// si tiene hijos sigue el proceso
                x = (NodoLg) p.retornaDato();// retorna el dato que corresponde al nodo hijo
                recorrerNodosLineasN(x.retornaLiga(), g, x);//llama recursivamente para recorrer los hermanos 
                PintarLineas(padre, x, g, Color.BLUE);//Pinta la linea entre el hijo y el padre

            }
            p = p.retornaLiga();

        }
        return;

    }

    //Metodo que dibuja al arbol 
    public void DibujarArbol(NodoDoble raiz, Graphics g) {
        raizP = raiz;//se almacena la raiz del arbol Binario para dibujarlo en cada repaint del panel
        if(raizP==null)
        {
           
            return;
        }
        ListaDobleLigada ld = new ListaDobleLigada();
        int LI = ld.CountNodos(raiz.li);//cuenta los nodos de la liga izquierda
        PintarNodo(LI + 1, raiz, 1, g);//pinta nodo Raiz
        if(raiz.li!=null)
        {
        DrawnLI(LI, raiz.li, 2, g);//pinta liga izquierda de nodo 
        RecorrerNodosLineas(raiz, g);//recorre los nodos y los une con una linea segun su posicion

        }
        
    }

    //Metodo que dibuja al arbol 
    public void DibujarArbolAvl(NodoDobleAvl raiz, Graphics g) {
        raizA = raiz;
        if(raizA==null)
        {
            
            return;
        }
        ArbolAvl ld = new ArbolAvl();
        int LI = ld.CountNodos(raiz.li);//cuenta los nodos de la liga izquierda
        int LD = ld.CountNodos(raiz.ld);//cuenta los nodos de la liga derecha
        int sum =LI+LD;
        PintarNodo(LI + 1, raiz, 1, g);//pinta nodo Raiz
        DrawnLIAVL(LI, raiz.li, 2, g);//pinta liga izquierda de nodo 
        DrawnLD(sum, raiz.ld, 2, g);//pinta liga derecha de nodo 
        RecorrerNodosLineasAVL(raiz, g);//recorre los nodos y los une con una linea segun su posicion

    }

    //Pinta la liga izquierda del arbol 
    private int DrawnLI(int pos, NodoDoble r, int alt, Graphics g) {
        if (r.li != null && r.ld == null) {//para este caso pinta un nodo con hijos ,pero  sin hermanos

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.ld != null) {//Si el nodo  tiene hermanos 
            pos = DrawnLI(pos, r.ld, alt + 1, g);//llama recursivamente a DrawLI para calcular la maxima posicion de los hermanos
            PintarNodo(pos, r, alt, g);//pinta el nodo actual 
            pos--;
        }
        if (r.li != null) {//si el nodo tiene hijos

            //PintarNodo(pos, r, alt, g);
            pos = DrawnLI(pos, r.li, alt + 1, g);//llama recursivamente a DrawLI para calcular la maxima posicion de los hijos

        }
        if (r.li == null && r.ld == null) {// si el nodo es una hoja lo pinta sin ninguna validacion 

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        return pos;

    }

    //Pinta la liga izquierda del arbol  AVL
    private int DrawnLIAVL(int pos, NodoDobleAvl r, int alt, Graphics g) {
         if(r==null) //si el nodo es nulo retorna la posicion alctual
        {
            return pos;
        }
        if (r.li != null && r.ld == null) {

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.ld != null) {
            pos = DrawnLIAVL(pos, r.ld, alt + 1, g);
            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.li != null) {

            //PintarNodo(pos, r, alt, g);
            pos = DrawnLIAVL(pos, r.li, alt + 1, g);

        }
        if (r.li == null && r.ld == null) {

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        return pos;

    }

    //Pinta la liga Derecha del arbol Avl
    private int DrawnLD(int pos, NodoDobleAvl r, int alt, Graphics g) {

        if(r==null)
        {
            return pos;
        }
        if (r.ld != null && r.li == null) {

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.li != null) {
            pos = DrawnLD(pos, r.li, alt + 1, g);
            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.ld != null) {

            //PintarNodo(pos, r, alt, g);
            pos = DrawnLD(pos, r.ld, alt + 1, g);

        }

        if (r.li == null && r.ld == null) {

            PintarNodo(pos, r, alt, g);
            pos--;
        }

        return pos;

    }

    //Recorre los nodos recursivamente uniendolos con un metodo Pintarlineas
    private void RecorrerNodosLineas(NodoDoble r, Graphics g) {
        if (r.li != null) {
            PintarLineas(r, r.li, g, Color.BLUE);//Pinta las lineas entre el nodo actual y su hijo
            RecorrerNodosLineas(r.li, g);
        }
        if (r.ld != null) {
            PintarLineas(r, r.ld, g, Color.RED);
            RecorrerNodosLineas(r.ld, g);
        }

    }

    //Recorre los nodos recursivamente uniendolos con un mentodo Pintarlineas
    private void RecorrerNodosLineasAVL(NodoDobleAvl r, Graphics g) {
        if (r.li != null) {
            PintarLineas(r, r.li, g, Color.BLUE);//Pinta las lineas entre el nodo actual y su hijo
            RecorrerNodosLineasAVL(r.li, g);
        }
        if (r.ld != null) {
            PintarLineas(r, r.ld, g, Color.RED);
            RecorrerNodosLineasAVL(r.ld, g);
        }

    }

    //Metodo que pinta las lineas entre el nodo padre e hijo
    private void PintarLineas(NodoDoble p, NodoDoble h, Graphics g, Color c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(p.x + 15, p.y + 30, h.x + 15, h.y);//linea al padre es x(padre)+15 y(padre)+30, linea a si mismo x(actual)+15 y(actual)
    }

    //Metodo que pinta las lineas entre el nodo padre e hijo
    private void PintarLineas(NodoLg p, NodoLg h, Graphics g, Color c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(p.x + 15, p.y + 30, h.x + 15, h.y);//linea al padre es x(padre)+15 y(padre)+30, linea a si mismo x(actual)+15 y(actual)
    }

    //Metodo que pinta las lineas entre el nodo padre e hijo
    private void PintarLineas(NodoDobleAvl p, NodoDobleAvl h, Graphics g, Color c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(p.x + 15, p.y + 30, h.x + 15, h.y);//linea al padre es x(padre)+15 y(padre)+30, linea a si mismo x(actual)+15 y(actual)
    }

    private void PintarNodo(int pos, NodoLg p, int alt, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        p.x = 40 * pos;
        p.y = 60 * alt;
        g2d.drawOval(p.x, p.y, 30, 30);
        g2d.setFont(new Font("Tahoma", Font.PLAIN, 20));
        g2d.drawString(p.retornaDato().toString(), p.x + 10, p.y + 20);

    }

    private void PintarNodo(int pos, NodoDobleAvl p, int alt, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        p.x = 40 * pos;
        p.y = 60 * alt;
        g2d.drawOval(p.x, p.y, 30, 30);
        g2d.setFont(new Font("Tahoma", Font.PLAIN, 20));
        g2d.drawString(p.retornaDato().toString(), p.x + 10, p.y + 20);

    }
    
    private void PintarVacio( Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.setFont(new Font("Tahoma", Font.PLAIN, 40));
        g2d.drawString("ÁRBOL VACÍO",100,50);

    }

    //Metodo que pinta los nodos
    private void PintarNodo(int pos, NodoDoble p, int alt, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        p.x = 40 * pos;
        p.y = 40 * alt;
        g2d.drawOval(p.x, p.y, 30, 30);
        g2d.setFont(new Font("Tahoma", Font.PLAIN, 20));
        g2d.drawString(p.retornaDato().toString(), p.x + 10, p.y + 20);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raizP != null) {
            DibujarArbol(raizP, g);
        } else if (raizN != null) {
            DibujarArbolNario(raizN, g);
        }else if (raizA != null) {
            DibujarArbolAvl(raizA, g);
        }
    }

}
