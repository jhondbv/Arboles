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
public class ListaGeneralizada { //Esta clase sólo se utiliza para crear el árbol n-ario representado como lista generalizada
    
    public NodoLg primero;
//contruye la lista generalizada que representa a la hilera entrada como parámetro    
    public void construyeLg(String s){
       if(s.isEmpty())
       {
       primero = null;
       return;
       }
        Stack pila;
        NodoLg ultimo, x;
        String hilera;
        int n,i;
        pila = new Stack();
        hilera = s;
        primero = new NodoLg(null);
        ultimo = primero;
        primero.asignaDato(hilera.charAt(1));
        n = hilera.length();
        i = 3;
        while (i <= n-3){ 
            x = new NodoLg(null);
            ultimo.asignaLiga(x);
            ultimo = x;
            if (hilera.charAt(i+1) == '('){ //se construye una sublista
                ultimo.asignaSw(1);
                pila.push(ultimo);
                x = new NodoLg(hilera.charAt(i));
                ultimo.asignaDato(x);
                ultimo = x;
                i = i+2;
            }else{
                ultimo.asignaDato(hilera.charAt(i));
                if(hilera.charAt(i+1) == ')'){ //se ha terminado de construir la lista
                    i++;
                    while(i<n-1 && hilera.charAt(i) == ')' && !pila.empty()){
                        ultimo = (NodoLg)pila.pop();
                        i++;
                    }
                    if(hilera.charAt(i) == ','){ //esto indica que sigue otro átomo u otra lista
                        i++;
                    }
                }else{
                    i = i+2;
                }
            }
        }
     }

}


