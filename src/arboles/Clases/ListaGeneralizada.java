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

    public void construyeArbolLg(String s){
            Stack pila;
            NodoLg primero, ultimo, x;
            String hilera;
            int n,i;
            pila = new Stack();
            hilera = s;
            primero = new NodoLg(null);
            ultimo = primero;
            primero.asignaDato(hilera.charAt(1));
            n = hilera.length();
            i = 3;
            while (i<=n-3){ //verificar que sí sea -3
                x = new NodoLg(null);
                ultimo.asignaLiga(x);
                if (hilera.charAt(i+1)== '('){
                    ultimo.asignaSw(1);
                    pila.push(ultimo);
                    x = new NodoLg(hilera.charAt(i));
                    ultimo.asignaDato(x);
                    ultimo = x;
                    i = i+2;
                } else {
                    ultimo.asignaDato(hilera.charAt(i));
                    if(hilera.charAt(i+1) == ')'){
                        i++;
                        while(i<n-1 && hilera.charAt(i) == ')' && !pila.empty()){
                            ultimo = (NodoLg)pila.pop();
                            i++;
                        }
                        if(hilera.charAt(i) == ','){
                            i++;
                        }
                    }else {
                        i = i+2;
                    }
                }
            
            }
        }
    
}

