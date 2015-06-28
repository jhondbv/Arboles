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
    NodoLg x,Raiz,ultimo;
    String hilera;
    int n;
    public void construyeLg(String s){
        pila = new Stack();
        x = new NodoLg(null);
        Raiz= x ;
        ultimo=x;
        hilera=s;
        n=s.length();
        for(int i=1;i<n-1;i++){
           switch (hilera.charAt(i)){
               
               case ',':
                   x=new NodoLg(null);
                   ultimo.asignaLiga(x);
                   ultimo=x;
                   break;
               case '(':
                   pila.push(ultimo);//Para apilar
                   x=new NodoLg(null);
                   ultimo.asignaSw(1);
                    ultimo.asignaDato(x);
                    ultimo = x;
                    i = i+2;
               case ')':
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

