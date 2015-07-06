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

    public NodoDoble raizP;
    public NodoLg raizN;
    
    public DrawBinaryTree() {
        /* this.setPreferredSize(new Dimension(491,454));*/
        setBackground(Color.white);
        setLocation(10, 10);

    }

    public void paintRectangle(Graphics g) {

        
        g.drawOval(220, 20, 30, 30);// x,y, ancho,largo
        g.drawString("A", 230, 40);

        g.drawOval(180, 80, 30, 30);
        g.drawString("B", 190, 100);
        g.drawLine(235, 50, 195, 80);//linea al padre es x(padre)+15 y(padre)+30, linea a si mismo x(actual)+15 y(actual)

        g.drawOval(260, 80, 30, 30);
        g.drawString("C", 270, 100);
        g.drawLine(235, 50, 275, 80);

    }
    
      //Metodo que dibuja un arbol N-ario representado como lista generalizada
    public void DibujarArbolNario (NodoLg raiz , Graphics g)
    {
        raizN = raiz ;
        int p =recorrerArbolNario(raiz.retornaLiga(), 0, 2, g);//llama recursivamente al metodo que establece la posicion de cada nodo
        int posr=(p+1)/2;
        PintarNodo(posr, raiz, 1, g);
        recorrerNodosLineasN(raizN, g,raizN);
        
    
    }
    
    //Metodo Recursivo que establece la posicion de cada nodo
    private int recorrerArbolNario(NodoLg r , int pos , int alt,Graphics g )
    {
        NodoLg p =null;
        int q =0;
        NodoLg x =null;
        if(r==null)
        {
            return pos;
        }
        p=r;
        while (p!=null)
        {
            
            if(p.retornaSw()==0)
            {
                pos++;
                if(p.retornaLiga()!=null)
                {
                    q=recorrerArbolNario(p.retornaLiga(), pos, alt, g);
                    if(p!=raizN)
                    PintarNodo(pos, p, alt, g);
                    return q ;
                }
                else
                {
                    PintarNodo(pos, p, alt, g);
                    return pos;
                
                }
            }
            if(p.retornaSw()==1)
            {
                x= (NodoLg)p.retornaDato();
                int alttemp= alt+1;
                q=recorrerArbolNario(x.retornaLiga(), pos, alttemp, g);
                PintarNodo((q+pos)/2, x, alt, g);
                if(q>pos)
                    pos=q;
            }
            p=p.retornaLiga();
        
        }
        return pos;
        
    
    }
    
    
    //Metodo recursivo que dibuja las lineas que unen a los nodos hijos con sus padres
    private void recorrerNodosLineasN(NodoLg r, Graphics g,NodoLg padre)
    {
        NodoLg p =null;
        int q =0;
        NodoLg x =null;
        if(r==null)
        {
            return ;
        }
        p=r;
        while (p!=null)
        {
            
            if(p.retornaSw()==0)
            {
               
                if(p.retornaLiga()!=null)
                {
                    recorrerNodosLineasN(p.retornaLiga(),g,padre);
                    if(p!=raizN)
                    PintarLineas(padre, p, g,Color.BLUE);
                    return  ;
                }
                else
                {
                    PintarLineas(padre, p, g,Color.BLUE);

                    return ;
                
                }
            }
            if(p.retornaSw()==1)
            {
                x= (NodoLg)p.retornaDato();
                recorrerNodosLineasN(x.retornaLiga(),g,x);
                PintarLineas(padre,x , g,Color.BLUE);
               
            }
            p=p.retornaLiga();
        
        }
        return ;
        
    
    }

    //Metodo que dibuja al arbol 
       public void DibujarArbol(NodoDoble raiz,Graphics g) {
        raizP = raiz;
        ListaDobleLigada ld = new ListaDobleLigada();
        int LI = ld.CountNodos(raiz.li);//cuenta los nodos de la liga izquierda
        PintarNodo(LI + 1, raiz, 1, g);//pinta nodo Raiz
        DrawnLI(LI, raiz.li, 2, g);//pinta liga izquierda de nodo 
        RecorrerNodosLineas(raiz, g);//recorre los nodos y los une con una linea segun su posicion

    }

    //Pinta la liga izquierda del arbol 
    private int DrawnLI(int pos, NodoDoble r, int alt, Graphics g) {
        if (r.li != null && r.ld == null) {

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.ld != null) {
            pos = DrawnLI(pos, r.ld, alt + 1, g);
            PintarNodo(pos, r, alt, g);
            pos--;
        }
        if (r.li != null) {

            //PintarNodo(pos, r, alt, g);
            pos = DrawnLI(pos, r.li, alt + 1, g);

        }
        if (r.li == null && r.ld == null) {

            PintarNodo(pos, r, alt, g);
            pos--;
        }
        return pos;

    }

    //Recorre los nodos recursivamente uniendolos con un mentodo Pintarlineas
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
    public void paintComponent(Graphics g)
    {
     super.paintComponent(g);
        if(raizP!=null)
        DibujarArbol(raizP,g);
        else
            if(raizN!=null)
                DibujarArbolNario(raizN, g);
    }

}
