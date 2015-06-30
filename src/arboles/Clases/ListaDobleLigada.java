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
public class ListaDobleLigada {
    public NodoDoble raiz;
     
    public NodoDoble convierteNarioABinario(NodoLg r){
       NodoDoble x, ultimo;
        NodoLg p, q;
        Stack pila;
        pila = new Stack();
        p = r;
        x = new NodoDoble(p.retornaDato());
        raiz = x;
        ultimo = x;
        p = p.retornaLiga();
        while (p != null){
            if(p.retornaSw() == 0){
                 x = new NodoDoble(p.retornaDato());
            }else{
                q = (NodoLg)p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x);
                pila.push(q.retornaLiga());
            }
            ultimo.asignaLi(x);
            ultimo = x;
            p = p.retornaLiga();
            while (p != null){
                if(p.retornaSw() == 0){
                 x = new NodoDoble(p.retornaDato());
            }else{
                q = (NodoLg)p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x);
                pila.push(q.retornaLiga());
            }
            ultimo.asignaLd(x);
            ultimo = x;
            p = p.retornaLiga();   
            }
            if (!pila.empty()){
                p = (NodoLg)pila.pop();
                ultimo = (NodoDoble)pila.pop();
            }
        }

        return raiz;
    }

    

}




