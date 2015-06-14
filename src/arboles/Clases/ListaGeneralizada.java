/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

import java.util.Stack;

/**
 *
 * @author vero
 */
public class ListaGeneralizada {
    
    
    Stack pila;
    NodoLg x;
    NodoLg ultimo;
    String hilera;
    int n;
    void construyeLg(String s){
        pila = new Stack();
        x = new NodoLg(null);
        ultimo = new NodoLg();
        hilera=s;
        n=s.length();
        for(int i=1;i<n;i++){
           switch (hilera.charAt(i)){
               
               case ',':
                   x=new NodoLg(null);
                   ultimo.asignaLiga(x);
                   ultimo=x;
                   break;
               case '(':
                   pila.push(ultimo);//¿Sí se usa este para apilar?
                   x=new NodoLg(null);
                   ultimo.asignaSw(1);
                    ultimo.asignaDato(x);
                   ultimo=x;
                   break;
               case ')':
                   ultimo=(NodoLg)pila.pop(); //¿Sí se usa este para desapilar?
                   break;
               default:
                   ultimo.asignaSw(0);
                   ultimo.asignaDato(hilera.charAt(i));
                    
           
           }
        }
    
}
}
    


    
